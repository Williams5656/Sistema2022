package POA.Controlador;

import static POA.Controlador.Con_principal.vista;
import POA.Modelo.*;
import POA.Vista.Vis_Principal.*;

import POA.Modelo.AsignacionMateriaDocenteBD;
import POA.Modelo.PeriodoacademicoBD;
import POA.Modelo.PeriodoacademicoMD;
import POA.Modelo.MateriaMD;
import POA.Modelo.MateriaBD;
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

/**
 *
 * @author PC FACTORY
 */
public class Con_Asignacion {

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
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
        vista.getBtnagregar().addActionListener(e -> nuevo());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getTablaasignaciondocentemateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        listaMateria = baseDatosMateria.mostrardatos();
        listaPeriodo = baseDatosPeriodo.lista_periodos();
        inhabilitar_botones();
        vista.getBtnagregar().setEnabled(true);
        buscardocente();
        lista();

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
        vista.getBtnguardar().setEnabled(true);
        vista.getCboxperiodo().setEnabled(true);
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
        List<PersonaMD> lista = bdpersona.obtenerdatos(vista.getTxtdocente().getText());
        List<docenteMD> listadoc = bddocente.obtenerdatos(vista.getTxtdocente().getText());
        int con = 0;
        try {
            for (int i = 0; i < lista.size(); i++) {
                if (vista.getTxtdocente().getText().equalsIgnoreCase(listadoc.get(i).getCedula())) {
                    if (listadoc.get(i).getCedula().equals(lista.get(i).getCedula())) {
                        String nombre = "[" + lista.get(i).getCedula() + "]" + lista.get(i).getNombres() + " " + lista.get(i).getApellidos();
                        vista.getTxtnombredocente().setText(nombre);
                        con = 1;
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
            vista.getTxtnombredocente().setText("");
        }
    }

    public void nuevo() {
        vista.getTxtdocente().setText("");
        vista.getTxtnombredocente().setText("");
        vista.getCboxasignatura().setSelectedIndex(0);
        vista.getCboxciclo().setSelectedIndex(0);
        vista.getCboxidentificacion().setSelectedIndex(0);
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
            fila[4]=user.getParalelo();
            modelo.addRow(fila);
        }
        vista.getTablaasignaciondocentemateria().setModel(modelo);

    }

    public void guardar() {
        AsignacionMateriaDocenteBD baseAsignacion = new AsignacionMateriaDocenteBD();
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        int codigoPeriodo = 0;
        codigoPeriodo = baseAsignacion.mostrarIdPeriodo(periodo);
        String identificacion = (String) vista.getCboxidentificacion().getSelectedItem();
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
        String identificacio = (String) vista.getCboxidentificacion().getSelectedItem();
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

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        String identificacion = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        List<PersonaMD> listaper = bdpersona.mostrardatos();
        List<docenteMD> lista = bddocente.mostrardatos();
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.mostrardatos();
        bdasignacion.setId_asignacio(vista.getId_asignacion().getText());
        bdasignacion.setIdentificacion(listaasig.get(0).getIdentificacion());
        bdasignacion.setPeriodo(listaasig.get(0).getPeriodo());
        bdasignacion.setAsignatura(listaasig.get(0).getAsignatura());
        bdasignacion.setParalelo(listaasig.get(0).getParalelo());
        bdasignacion.setJornada(listaasig.get(0).getJornada());
        bdasignacion.setCiclo(listaasig.get(0).getCiclo());

        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());
        
        vista.getId_asignacion().setText(bdasignacion.getId_asignacio());
        vista.getTxtdocente().setText(bdasignacion.getIdentificacion());
        vista.getCboxperiodo().setSelectedItem(bdasignacion.getPeriodo());
        vista.getCboxasignatura().setSelectedItem(bdasignacion.getAsignatura());
        vista.getCboxciclo().setSelectedItem(bdasignacion.getCiclo());
        vista.getCboxjornada().setSelectedItem(bdasignacion.getJornada());
        vista.getCboxparalelo().setSelectedItem(bdasignacion.getParalelo());
        String nombre = "[" + bdasignacion.getIdentificacion() + "]" + bdpersona.getNombres() + " " + bdpersona.getApellidos();
        vista.getTxtnombredocente().setText(nombre);
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
}
