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
import java.util.ArrayList;
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
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<MateriaMD> listaMateria = new ArrayList<>();
    private MateriaBD baseDatosMateria = new MateriaBD();
    private List<PeriodoacademicoMD> listaPeriodo = new ArrayList<>();
    private List<AsignacionMateriaDocentesMD> lista = new ArrayList<>();
    private PeriodoacademicoBD baseDatosPeriodo = new PeriodoacademicoBD();

    public Con_Asignacion_Docente(vis_asignacionmateriadocentes vista) {
        this.vista = vista;
        vista.setVisible(true);
        cargarComboMateria();
        cargarComboPeriodo();
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
        listaMateria = baseDatosMateria.mostrardatos();
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        vista.getBtnagregar().setEnabled(true);
        vista.getCombodocentes().addActionListener(e->accion_combobox());
        inhabilitar_botones();
        buscardocente();
        lista();
    }

    public void plan() {
        int seleccionado;
        seleccionado = (int) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        System.out.println(seleccionado);
        if (seleccionado == 0) {
            JOptionPane.showMessageDialog(ESCRITORIO, "Seleccione un docente");
        } else {
            vista.setVisible(false);
            Vis_Documentacion doc = new Vis_Documentacion();
            Con_documentacion per = new Con_documentacion(doc, seleccionado);
            per.cargarDatos();
            per.desactivarBotones();
            per.eventoHoraguiaSi();
            per.eventoHoraguiaNo();
            per.datos();
            per.lista();
        }
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
    }
    public void imprimir() {
        Conect con = new Conect();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Asignacion_Docentes.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Imprimiendo");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_Asignacion_Docente.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void inhabilitar_botones() {
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(false);
        vista.getBtneliminar().setEnabled(false);
        vista.getCboxasignatura().setEnabled(false);
        vista.getCboxciclo().setEnabled(false);
        vista.getCboxjornada().setEnabled(false);
        vista.getCboxparalelo().setEnabled(false);
        vista.getCboxperiodo().setEnabled(false);

    }

    public void cargarComboPeriodo() {
        vista.getCboxperiodo().removeAllItems();
        vista.getCboxperiodo().addItem("Seleccione");
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        for (PeriodoacademicoMD periodo : listaPeriodo) {
            vista.getCboxperiodo().addItem(periodo.getNombre());
        }
    }

    public void buscar() {
        vista.getCombodocentes().removeAllItems();

        List<PersonaMD> lista = bdpersona.obtenerdatos(vista.getTxtdocente().getText());
        List<docenteMD> listadoc = bddocente.obtenerdatos(vista.getTxtdocente().getText());
        int con = 0;
        try {
            for (int i = 0; i < lista.size(); i++) {
                if (vista.getTxtdocente().getText().equalsIgnoreCase(listadoc.get(i).getCedula())) {
                    if (listadoc.get(i).getCedula().equals(lista.get(i).getCedula())) {
                        String nombre =lista.get(i).getNombres() + " " + lista.get(i).getApellidos();
                        //vista.getTxtnombredocente().setText(nombre);
                        con = 1;
                        vista.getCombodocentes().addItem(nombre);
                    }
                    if (listadoc.get(i).getEstado().equalsIgnoreCase("ACTIVO")) {
                        habilitar_botones();
                        for (int j = 0; j < listadoc.size(); j++) {
                            if (listadoc.get(j).getCedula().equalsIgnoreCase(vista.getTxtdocente().getText())) {
                                inhabilitar_botones();
                            }
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
        vista.getId_asignacion().setText("");
        vista.getCombodocentes().removeAllItems();
        vista.getCboxasignatura().setSelectedIndex(0);
        vista.getCboxciclo().setSelectedIndex(0);
        vista.getCboxjornada().setSelectedIndex(0);
        vista.getCboxparalelo().setSelectedIndex(0);
        vista.getCboxperiodo().setSelectedIndex(0);
        vista.getBtnguardar().setEnabled(true);
        habilitar_botones();
    }

    public void lista() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.addColumn("Id_asignacion");
        modelo.addColumn("Docente");
        modelo.addColumn("Asignatura");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Paralelo");
        Object[] fila = new Object[5];
        lista = bdasignacion.mostrardatos();
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        listaMateria = baseDatosMateria.mostrardatos();
        for (AsignacionMateriaDocentesMD user : lista) {
            fila[0] = user.getId_asignacio();
            fila[1] = user.getIdentificacion();
            for (MateriaMD carrera : listaMateria) {
                if (carrera.getCod_materia().equals(user.getAsignatura())) {
                    fila[2] = carrera.getNombre_materia();
                }
            }
            fila[3] = user.getCiclo();
            fila[4] = user.getParalelo();
            modelo.addRow(fila);
        }
        vista.getTablaasignaciondocentemateria().setModel(modelo);
        int id_asignacion1 = bdasignacion.id()+1;
        vista.getId_asignacion().setText(id_asignacion1+ "");
    }

    public void guardar() {
        AsignacionMateriaDocenteBD baseAsignacion = new AsignacionMateriaDocenteBD();
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        int codigoPeriodo = 0;
        codigoPeriodo = baseAsignacion.mostrarIdPeriodo(periodo);
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String codigoMateria = "";
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
        String codigoMateria =  baseAsignacion.mostrarIdMateria(asignatura);
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

        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?","",JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            if (bdasignacion.modificar(asignacion)){
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
                buscar();
            }

        });
    }

    public void seleccionar() {
        habilitar_botones();
        vista.getBtneliminar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(true);
        vista.getBtnguardar().setEnabled(false);
        vista.getId_asignacion().setEnabled(false);
        vista.getTxtdocente().setEnabled(false);
        vista.getCombodocentes().setEnabled(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        String identificacion = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 1);
        String id_asig = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 2);
        List<PersonaMD> listaper = bdpersona.obtenerdatos(identificacion);
        List<docenteMD> lista = bddocente.obtenerdatos(identificacion);
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.obtenerdatos(identificacion);
        String periodo = bdasignacion.mostrarPeriodo(Integer.parseInt(listaasig.get(0).getPeriodo()));
        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());
        String nombre =bdpersona.getNombres() + " " + bdpersona.getApellidos();
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
        vista.getCboxasignatura().setSelectedItem(id_asig);
        vista.getCboxciclo().setSelectedItem(bdasignacion.getCiclo());
        vista.getCboxjornada().setSelectedItem(bdasignacion.getJornada());
        vista.getCboxparalelo().setSelectedItem(bdasignacion.getParalelo());
        vista.getCombodocentes().setSelectedItem(nombre);
        id_asignacion = bdasignacion.getId_asignacio();

    }

    private void eliminar() {
        String seleccionado = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE ELIMINAR","",JOptionPane.YES_NO_OPTION);
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
                    vista.getCombodocentes().addItem(lista.get(i).getNombres()+" "+lista.get(i).getApellidos());
                }
            }

        }
    }
    
    public void accion_combobox(){
        List<PersonaMD> lista = bdpersona.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            if((lista.get(i).getNombres()+" "+lista.get(i).getApellidos()).equalsIgnoreCase((String) vista.getCombodocentes().getSelectedItem())){
                vista.getTxtdocente().setText(lista.get(i).getCedula());
            }
        }
        
       
    }
    
    
}
