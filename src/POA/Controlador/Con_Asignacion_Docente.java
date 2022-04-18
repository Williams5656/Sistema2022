package POA.Controlador;

import POA.Modelo.*;
import POA.Modelo.AsignacionMateriaDocenteBD;
import POA.Modelo.PeriodoacademicoBD;
import POA.Modelo.PeriodoacademicoMD;
import POA.Modelo.MateriaMD;
import POA.Modelo.MateriaBD;
import POA.Vista.Vis_Documentacion;
import POA.Vista.vis_asignacionmateriadocentes;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static POA.Vista.Vis_Principal.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PC FACTORY
 */
public class Con_Asignacion_Docente {

    public static int id_asignacion;
    private final vis_asignacionmateriadocentes vista;
    AsignacionMateriaDocenteBD bdasignacion = new AsignacionMateriaDocenteBD();
    docenteBD bddocente = new docenteBD();
    PersonaBD bdpersona = new PersonaBD();
    CarreraBD bdcarrera = new CarreraBD();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<MateriaMD> listaMateria = new ArrayList<>();
    private List<PersonaMD> listaPersona = new ArrayList<>();
    private List<CarreraMD> listaCarrera = new ArrayList<>();
    private MateriaBD baseDatosMateria = new MateriaBD();
    private List<PeriodoacademicoMD> listaPeriodo = new ArrayList<>();
    private List<AsignacionMateriaDocentesMD> lista = new ArrayList<>();
    private PeriodoacademicoBD baseDatosPeriodo = new PeriodoacademicoBD();
    private boolean tablaSeleccionada = false;

    public Con_Asignacion_Docente(vis_asignacionmateriadocentes vista) {
        this.vista = vista;
        vista.setVisible(true);
        cargarComboMateria();
        cargarComboPeriodo();
        cargarComboCarrera();
        cargarpersona();
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
        vista.getBtnimprimir().addActionListener(e -> imprimir());
        vista.getBtnagregar().addActionListener(e -> nuevo());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getBtncrearplan().addActionListener(e -> plan());
        vista.getTablaasignaciondocentemateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        vista.getCboxcarrera().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                seleccionarCarrera();
            }
        });
        vista.getCboxasignatura().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                seleccionarMateria();
            }
        });
        listaMateria = baseDatosMateria.mostrardatos();
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        vista.getBtnagregar().setEnabled(true);
        vista.getCombodocentes().addActionListener(e -> accion_combobox());
        inhabilitar_botones();
        buscardocente();
        lista();
    }

    public void plan() {
         if (tablaSeleccionada == true) {
            vista.setVisible(false);
            Vis_Documentacion doc = new Vis_Documentacion();
            Con_documentacion per = new Con_documentacion(doc, id_asignacion);
            per.cargarDatos();
            per.desactivarBotones();
            per.eventoHoraguiaSi();
            per.eventoHoraguiaNo();
            per.datos();
            per.lista();
         } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un docente de la tabla");
        }
//        int seleccionado = 0;
//        int id = 0;
//        seleccionado = (int) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
//        lista = bdasignacion.obtenerdatos(seleccionado);
//        for (AsignacionMateriaDocentesMD asignacion : lista) {
//            id = asignacion.getId_asignacio();
//        }
//        if (id == 0) {
//            JOptionPane.showMessageDialog(ESCRITORIO, "Seleccione un docente");
//        } else {
//            vista.setVisible(false);
//            Vis_Documentacion doc = new Vis_Documentacion();
//            Con_documentacion per = new Con_documentacion(doc, id_asignacion);
//            per.cargarDatos();
//            per.desactivarBotones();
//            per.eventoHoraguiaSi();
//            per.eventoHoraguiaNo();
//            per.datos();
//            per.lista();
//        }
    }

    public void cargarComboMateria() {
        vista.getCboxasignatura().removeAllItems();
        vista.getCboxasignatura().addItem("Seleccione");
        listaMateria = baseDatosMateria.mostrardatos();
        for (MateriaMD materia : listaMateria) {
            vista.getCboxasignatura().addItem(materia.getNombre_materia());
        }
    }

    public void habilitar_botones() {
        vista.getCboxasignatura().setEnabled(true);
        vista.getCboxjornada().setEnabled(true);
        vista.getCboxparalelo().setEnabled(true);
        vista.getCboxciclo().setEnabled(true);
        vista.getCboxperiodo().setEnabled(true);
        vista.getCombodocentes().setEnabled(true);
    }

    public void imprimir() {
        Conect con = new Conect();
        String parametro = "";
        String nombre="";         
        List <String> listanombres = new ArrayList<>();
        lista = bdasignacion.mostrardatos();
        for (AsignacionMateriaDocentesMD asignacionMD : lista) {            
            listaPersona = bdpersona.obtenerdatos(asignacionMD.getIdentificacion()); 
            for (PersonaMD persona: listaPersona) {
                nombre = persona.getNombres()+" " + persona.getApellidos();
                listanombres.add(nombre);                
            }
        }
        String [] nombres = new String  [listanombres.size()];
        for (int i = 0; i < listanombres.size(); i++) {
            nombres[i] = listanombres.get(i);
            
        }
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte por Docente",
            "Reporte de Carreras",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte De Asignacion de Docentes",       
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }else if (resp.equals("Reporte por Docente")){
            parametro = (String) JOptionPane.showInputDialog(null, "Seleccione un docente", "Docentes",       
                JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
            
        }
        try {
            Map p = new HashMap();
            p.put("index","%"+ parametro + "%");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Asignacion_Docentes.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, p, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_Asignacion_Docente.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void inhabilitar_botones() {
        vista.getId_asignacion().setEnabled(false);
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(false);
        vista.getBtneliminar().setEnabled(false);
        vista.getCboxasignatura().setEnabled(false);
        vista.getCboxciclo().setEnabled(false);
        vista.getCboxjornada().setEnabled(false);
        vista.getCboxparalelo().setEnabled(false);
        vista.getCboxperiodo().setEnabled(false);
        vista.getCombodocentes().setEnabled(false);

    }

    public void cargarComboPeriodo() {
        vista.getCboxperiodo().removeAllItems();
        vista.getCboxperiodo().addItem("Seleccione");
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        for (PeriodoacademicoMD periodo : listaPeriodo) {
            vista.getCboxperiodo().addItem(periodo.getNombre());
        }
    }

    public void cargarComboCarrera() {
        vista.getCboxcarrera().removeAllItems();
        vista.getCboxcarrera().addItem("Seleccione");
        listaCarrera = bdcarrera.mostrardatos();
        for (CarreraMD carrera : listaCarrera) {
            vista.getCboxcarrera().addItem(carrera.getNombre_carrera());
        }
    }

    public void buscar() {
        vista.getCombodocentes().removeAllItems();

        List<PersonaMD> lista = bdpersona.obtenerdatos(vista.getTxtdocente().getText());
        List<docenteMD> listadoc = bddocente.obtenerdatos(vista.getTxtdocente().getText());
        int con = 0;
        try {
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 0; j < listadoc.size(); j++) {

                    if (vista.getTxtdocente().getText().equalsIgnoreCase(listadoc.get(j).getCedula())&& listadoc.get(i).getEstado().equalsIgnoreCase("ACTIVO")) {
                        if (listadoc.get(j).getCedula().equals(lista.get(i).getCedula())) {
                            String nombre = lista.get(i).getNombres() + " " + lista.get(i).getApellidos();
                            //vista.getTxtnombredocente().setText(nombre);
                            con = 1;
                            vista.getCombodocentes().addItem(nombre);
                            habilitar_botones();

                        }
                    }
                }
            }
        } catch (Exception e) {
        }

        if (con != 1) {

            cargarpersona();
        }
    }

    public void nuevo() {
        vista.getTxtdocente().setText("");
        vista.getCombodocentes().removeAllItems();
        cargarpersona();
        vista.getCboxasignatura().setSelectedIndex(0);
        vista.getCboxjornada().setSelectedIndex(0);
        vista.getCboxparalelo().setSelectedIndex(0);
        vista.getCboxperiodo().setSelectedIndex(0);
        vista.getBtnguardar().setEnabled(true);
        habilitar_botones();
        vista.getTablaasignaciondocentemateria().setModel(modelo);
        int id_asignacion1 = bdasignacion.id() + 1;
        vista.getId_asignacion().setText(id_asignacion1 + "");
        tablaSeleccionada = false;
    }

    public void lista() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.addColumn("id");
        modelo.addColumn("Cedula");
        modelo.addColumn("Docente");
        modelo.addColumn("Asignatura");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Paralelo");
        Object[] fila = new Object[6];
        lista = bdasignacion.mostrardatos();
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        listaMateria = baseDatosMateria.mostrardatos();
        String nombre = "";
        for (AsignacionMateriaDocentesMD user : lista) {
            fila[0]= user.getId_asignacio();
            fila[1] = user.getIdentificacion();
            listaPersona = bdpersona.obtenerdatos(user.getIdentificacion());
            for (PersonaMD userp : listaPersona) {
                nombre = userp.getNombres() + " " + userp.getApellidos();
            }
            fila[2] = nombre;
            for (MateriaMD carrera : listaMateria) {
                if (carrera.getCod_materia().equals(user.getAsignatura())) {
                    fila[3] = carrera.getNombre_materia();
                }
            }
            fila[4] = user.getCiclo();
            fila[5] = user.getParalelo();
            modelo.addRow(fila);
        }
        vista.getTablaasignaciondocentemateria().setModel(modelo);
        int id_asignacion1 = bdasignacion.id() + 1;
        vista.getId_asignacion().setText(id_asignacion1 + "");
    }

    public void guardar() {
        AsignacionMateriaDocenteBD baseAsignacion = new AsignacionMateriaDocenteBD();
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        int codigoPeriodo = 0;
        codigoPeriodo = baseAsignacion.mostrarIdPeriodo(periodo);
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String carrera = (String) vista.getCboxcarrera().getSelectedItem();
        String codigoMateria = "";
        String codigoCarrera = "";
        codigoMateria = baseAsignacion.mostrarIdMateria(asignatura);

        String ciclo = (String) vista.getCboxciclo().getSelectedItem();
        String jornada = (String) vista.getCboxjornada().getSelectedItem();
        String paralelo = (String) vista.getCboxparalelo().getSelectedItem();
        bdasignacion.setId_asignacio(Integer.parseInt(vista.getId_asignacion().getText()));
        bdasignacion.setIdentificacion(vista.getTxtdocente().getText());
        bdasignacion.setPeriodo(codigoPeriodo + "");
        bdasignacion.setAsignatura(codigoMateria);
        bdasignacion.setCiclo(ciclo);
        bdasignacion.setJornada(jornada);
        bdasignacion.setParalelo(paralelo);

        if (bdasignacion.insertar()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
            /////autocreacion documntos, dudas consultar miguel///////////////////////
            doc_notas_BD not = new doc_notas_BD();
            if (not.crear_notas()) {
                System.out.println("notas creadas");
            } else {
                System.out.println("Error al crear notas");
            }
            doc_instrumento_evaluacionBD ins = new doc_instrumento_evaluacionBD();
            if (ins.crear_intrumentos()) {
                System.out.println("instrumentos creadas");
            } else {
                System.out.println("Error al crear instrumentos");
            }
            doc_informes_BD inf = new doc_informes_BD();
            if (inf.crear_notas()) {
                System.out.println("informes creados");
            } else {
                System.out.println("Error al crear informes");
            }
            /////autocreacion documntos, dudas consultar miguel///////////////////////
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }

    }

    public void modificar() {
        AsignacionMateriaDocenteBD baseAsignacion = new AsignacionMateriaDocenteBD();
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String codigoMateria = baseAsignacion.mostrarIdMateria(asignatura);
        String ciclo = (String) vista.getCboxciclo().getSelectedItem();
        String jornada = (String) vista.getCboxjornada().getSelectedItem();
        String paralelo = (String) vista.getCboxparalelo().getSelectedItem();
        int asignacion = Integer.parseInt(vista.getId_asignacion().getText());
        bdasignacion.setId_asignacio(Integer.parseInt(vista.getId_asignacion().getText()));
        bdasignacion.setIdentificacion(vista.getTxtdocente().getText());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(codigoMateria);
        bdasignacion.setCiclo(ciclo);
        bdasignacion.setJornada(jornada);
        bdasignacion.setParalelo(paralelo);

        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?", "", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            if (bdasignacion.modificar(asignacion)) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    public void buscardocente() {
        vista.getTxtdocente().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //if(vista.getTxtdocente().getText().length()>=10){
                buscar();
                //}
            }

        });

    }

    public void seleccionar() {
        cargarComboCarrera();
        cargarComboMateria();
        habilitar_botones();
        vista.getBtneliminar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(true);
        vista.getBtnguardar().setEnabled(false);
        vista.getId_asignacion().setEnabled(false);
        vista.getTxtdocente().setEnabled(false);
        vista.getCombodocentes().setEnabled(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        int id = (int) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        String identificacion = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 1);
        String id_asig = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 3);

        
        List<PersonaMD> listaper = bdpersona.obtenerdatos(identificacion);
        List<docenteMD> lista = bddocente.obtenerdatos(identificacion);
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.obtenerdatos(id);
        String carrera = bdasignacion.mostrarCarrera(id_asig);
        String periodo = bdasignacion.mostrarPeriodo(Integer.parseInt(listaasig.get(0).getPeriodo()));
        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());
        String nombre = bdpersona.getNombres() + " " + bdpersona.getApellidos();
        bdasignacion.setId_asignacio(listaasig.get(0).getId_asignacio());
        bdasignacion.setIdentificacion(listaasig.get(0).getIdentificacion());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(listaasig.get(0).getAsignatura());

        bdasignacion.setParalelo(listaasig.get(0).getParalelo());
        bdasignacion.setJornada(listaasig.get(0).getJornada());
        bdasignacion.setCiclo(listaasig.get(0).getCiclo());

        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());

        vista.getId_asignacion().setText(bdasignacion.getId_asignacio() + "");
        vista.getTxtdocente().setText(bdasignacion.getIdentificacion());
        vista.getCboxperiodo().setSelectedItem(bdasignacion.getPeriodo());
        vista.getCboxcarrera().setSelectedItem(carrera);
        vista.getCboxasignatura().setSelectedItem(id_asig);
        vista.getCboxciclo().setSelectedItem(bdasignacion.getCiclo());
        vista.getCboxjornada().setSelectedItem(bdasignacion.getJornada());
        vista.getCboxparalelo().setSelectedItem(bdasignacion.getParalelo());
        vista.getCombodocentes().setSelectedItem(nombre);
        id_asignacion = bdasignacion.getId_asignacio();
        tablaSeleccionada = true;

    }

    private void eliminar() {
        String seleccionado = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE ELIMINAR", "", JOptionPane.YES_NO_OPTION);
        if (resp2 == JOptionPane.YES_NO_OPTION) {
            if (bdasignacion.eliminar(seleccionado)) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }

    }

    public void eventotabla() {
        vista.getTablaasignaciondocentemateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar(); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public void cargarpersona() {
        vista.getCombodocentes().removeAllItems();
        vista.getCombodocentes().addItem("BUSCAR DOCENTE");
        List<docenteMD> listadoc = bddocente.mostrardatos();
        List<PersonaMD> lista = bdpersona.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < listadoc.size(); j++) {
                if (listadoc.get(j).getCedula().equalsIgnoreCase(lista.get(i).getCedula())) {
                    vista.getCombodocentes().addItem(lista.get(i).getNombres() + " " + lista.get(i).getApellidos());
                }
            }

        }
    }

    public void seleccionarCarrera() {
        System.out.println("Seleccionar Carrera");
        String nombre = "";
        String id_carrera = "";
        nombre = (String) vista.getCboxcarrera().getSelectedItem();
        for (CarreraMD carreraMD : listaCarrera) {
            if (carreraMD.getNombre_carrera().equalsIgnoreCase(nombre)) {
                id_carrera = carreraMD.getCodigo_carrera();
            }
        }
        listaMateria = baseDatosMateria.nombresCarrera(id_carrera);
        vista.getCboxasignatura().removeAllItems();
        vista.getCboxasignatura().addItem("Seleccione");
        for (MateriaMD materiaMD : listaMateria) {
            vista.getCboxasignatura().addItem(materiaMD.getNombre_materia());
        }
    }

    public void seleccionarMateria() {
        System.out.println("Seleccionar Materia");
        String nombre = "";
        nombre = (String) vista.getCboxasignatura().getSelectedItem();
        vista.getCboxciclo().removeAllItems();
        for (MateriaMD materiaMD : listaMateria) {
            if (materiaMD.getNombre_materia().equalsIgnoreCase(nombre)) {
                vista.getCboxciclo().addItem(materiaMD.getCiclo());
            }
        }
    }

    public void accion_combobox() {
        List<PersonaMD> lista = bdpersona.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getNombres() + " " + lista.get(i).getApellidos()).equalsIgnoreCase((String) vista.getCombodocentes().getSelectedItem())) {
                vista.getTxtdocente().setText(lista.get(i).getCedula());
            }
        }

    }

}
