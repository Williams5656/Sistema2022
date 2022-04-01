package POA.Controlador;

import static POA.Controlador.Con_principal.vista;
import POA.Modelo.*;
import POA.Vista.Vis_Principal.*;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Action;

/**
 *
 * @author PC FACTORY
 */
public class Con_Asignacion {

    public static String id_asignacion;
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

    public Con_Asignacion(vis_asignacionmateriadocentes vista) {
        this.vista = vista;
        vista.setVisible(true);
        cargarComboMateria();
        cargarComboPeriodo();
        cargarpersona();
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
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

        Vis_Documentacion doc= new Vis_Documentacion();
        Con_documentacion per = new Con_documentacion(doc,id_asignacion);

        ESCRITORIO.add(doc);
        Dimension desktopSize = ESCRITORIO.getSize();
        Dimension FrameSize = doc.getSize();
        doc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    public void cargarComboMateria() {
        vista.getCboxasignatura().removeAllItems();
        vista.getCboxasignatura().addItem("");
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
        vista.getCboxperiodo().addItem("");
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
        bdasignacion.setId_asignacio(vista.getId_asignacion().getText());
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
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String ciclo = (String) vista.getCboxciclo().getSelectedItem();
        String jornada = (String) vista.getCboxjornada().getSelectedItem();
        String paralelo = (String) vista.getCboxparalelo().getSelectedItem();
        bdasignacion.setId_asignacio(vista.getId_asignacion().getText());
        bdasignacion.setIdentificacion(vista.getTxtdocente().getText());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(asignatura);
        bdasignacion.setCiclo(ciclo);
        bdasignacion.setJornada(jornada);
        bdasignacion.setParalelo(paralelo);

        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?");
        if (resp == 0) {
            if (bdasignacion.Modificar(vista.getTxtdocente().getText())) {
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
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        String identificacion = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 1);
        String id_asig = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 2);
        List<PersonaMD> listaper = bdpersona.obtenerdatos(identificacion);
        List<docenteMD> lista = bddocente.obtenerdatos(identificacion);
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.obtenerdatos(identificacion);
        String periodo = bdasignacion.mostrarPeriodo(Integer.parseInt(listaasig.get(0).getPeriodo()));
        bdasignacion.setId_asignacio(listaasig.get(0).getId_asignacio());
        bdasignacion.setIdentificacion(listaasig.get(0).getIdentificacion());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(listaasig.get(0).getAsignatura());
        bdasignacion.setParalelo(listaasig.get(0).getParalelo());
        bdasignacion.setJornada(listaasig.get(0).getJornada());
        bdasignacion.setCiclo(listaasig.get(0).getCiclo());

        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());

        vista.getId_asignacion().setText(bdasignacion.getId_asignacio());
        vista.getTxtdocente().setText(bdasignacion.getIdentificacion());
        vista.getCboxperiodo().setSelectedItem(bdasignacion.getPeriodo());
        vista.getCboxasignatura().setSelectedItem(id_asig);
        vista.getCboxciclo().setSelectedItem(bdasignacion.getCiclo());
        vista.getCboxjornada().setSelectedItem(bdasignacion.getJornada());
        vista.getCboxparalelo().setSelectedItem(bdasignacion.getParalelo());
        String nombre =bdpersona.getNombres() + " " + bdpersona.getApellidos();
        vista.getCombodocentes().setSelectedItem(nombre);

        id_asignacion = bdasignacion.getId_asignacio();

    }

    private void eliminar() {
        int seleccionado = vista.getTablaasignaciondocentemateria().getSelectedRow();
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE ELIMINAR");
        if (resp2 == 0) {
            if (bdasignacion.eliminar(vista.getTxtdocente().getText())) {
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
