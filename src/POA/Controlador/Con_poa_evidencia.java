/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.ActividadesBD;
import POA.Modelo.Validadores.*;
import POA.Modelo.CarreraMD;
import POA.Modelo.ProyectoMD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.CarreraBD;
import POA.Modelo.Conect;
import POA.Modelo.EvidenciaBD;
import POA.Modelo.EvidenciaMD;
import POA.Modelo.ObjetivoOperativoBD;
import POA.Modelo.ObjetivoOperativoMD;
import POA.Modelo.PoaBD;
import POA.Vista.vis_poa_evidencia;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import POA.Modelo.Validadores.anio_evidecia;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USUARIO
 */
public class Con_poa_evidencia {

    private final vis_poa_evidencia vista;
    public static List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    public static List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    List<POA.Modelo.EvidenciaMD> listaEvidencias = new ArrayList<>();
    public static List<POA.Modelo.ProyectoMD> listaProyecto = new ArrayList<>();
    public static List<POA.Modelo.ActividadesMD> listaActividades = new ArrayList<>();
    public static List<POA.Modelo.ObjetivoOperativoMD> listaObjetivos = new ArrayList<>();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private ProyectoBD baseDatosProyecto = new ProyectoBD();
    private PoaBD baseDatosPoa = new PoaBD();
    private EvidenciaBD baseDatosEvidencias = new EvidenciaBD();
    private ActividadesBD baseDatosActividades = new ActividadesBD();
    private ObjetivoOperativoBD baseDatosObjetivos = new ObjetivoOperativoBD();
    public static String anio = "";
    public static String id_carrera = "";
    public static int id_poa = 0, poa = 0;
    public static String objetivo = "";
    public static int objetivo_id = 0, id_obj = 0;
    public static String proyecto = "";
    public static int proyecto_id = 0, proyectoo = 0;
    public static String actividad = "";
    public static int id_actividad = 0, id_act = 0;
    int id_evidencia = 0;
    boolean x = false;

    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnImprimir().addActionListener(e -> imprimir());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getCbx_proyecto().setEnabled(false);
        vista.getCbx_carrera().setEnabled(false);
        vista.getCbx_anio().setEnabled(false);
        vista.getCbx_obje_opera().setEnabled(false);
        vista.getCbx_actividad().setEnabled(false);
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPoa = baseDatosPoa.mostrarDatos();
        listaProyecto = baseDatosProyecto.mostrarDatos();
        listaActividades = baseDatosActividades.mostrarDatos();
        listaObjetivos = baseDatosObjetivos.mostrarDatos();
        cargarComboCarrera();
        cargarComboAnio();
        vista.getTabla_Evidencia().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        lista();
    }

    public void imprimir() {
        Conect con = new Conect();
        System.out.println("Imprimir");
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/R_Evidencia.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Imprimiendo Evidencias");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cargarComboCarrera() {
        for (int j = 0; j < listaPoa.size(); j++) {
            for (int i = 0; i < listaCarreras.size(); i++) {
                if (Integer.parseInt(listaCarreras.get(i).getCodigo_carrera()) == listaPoa.get(j).getId_carrera()) {
                    vista.getCbx_carrera().addItem(listaCarreras.get(i).getNombre_carrera());
                }
            }
        }

    }

    public void cargarComboAnio() {
        vista.getCbx_carrera().addItemListener(new anio_evidecia(vista.getCbx_carrera(), vista.getCbx_anio()));
        vista.getCbx_anio().addItemListener(new proyecto_evidencia(vista.getCbx_carrera(), vista.getCbx_anio(), vista.getCbx_proyecto()));
        vista.getCbx_proyecto().addItemListener(new objetivo_evidencia(vista.getCbx_proyecto(), vista.getCbx_obje_opera()));
        vista.getCbx_obje_opera().addItemListener(new actividad_evidencia(vista.getCbx_obje_opera(), vista.getCbx_actividad()));
    }

    public void seleccionar() {
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(true);
        vista.getBtnModificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_Evidencia().getModel();
        int id_evid = (int) modelo.getValueAt(vista.getTabla_Evidencia().getSelectedRow(), 0);
        id_evidencia = id_evid;
        System.out.println(id_evid);
        List<EvidenciaMD> lista = baseDatosEvidencias.obtenerdatos(id_evid);
        baseDatosEvidencias.setId_objetivo(lista.get(0).getId_objetivo());
        baseDatosEvidencias.setId_actividades(lista.get(0).getId_actividades());
        baseDatosEvidencias.setId_poa(lista.get(0).getId_poa());
        baseDatosEvidencias.setId_proyecto(lista.get(0).getId_proyecto());
        baseDatosEvidencias.setId_objetivo(lista.get(0).getId_objetivo());
        baseDatosEvidencias.setArchivo(lista.get(0).getArchivo());

        for (int j = 0; j < lista.size(); j++) {
            for (int y = 0; y < listaPoa.size(); y++) {
                if (lista.get(j).getId_poa() == listaPoa.get(y).getId_POA()) {
                    for (int i = 0; i < listaCarreras.size(); i++) {
                        if (listaCarreras.get(i).getCodigo_carrera().equalsIgnoreCase(String.valueOf(listaPoa.get(y).getId_carrera()))) {
                            vista.getCbx_carrera().setSelectedItem(listaCarreras.get(i).getNombre_carrera());
                            cargarComboAnio();
                        }
                    }
                    vista.getCbx_anio().setSelectedItem(listaPoa.get(y).getAnio());
                }
            }
            for (int i = 0; i < listaProyecto.size(); i++) {
                if (lista.get(j).getId_proyecto() == listaProyecto.get(i).getId_proyecto()) {
                    vista.getCbx_proyecto().setSelectedItem(String.valueOf(listaProyecto.get(i).getId_proyecto()));
                    cargarComboAnio();
                }
            }
            for (int i = 0; i < listaObjetivos.size(); i++) {
                if (lista.get(j).getId_objetivo() == listaObjetivos.get(i).getId_objetivo_operativo()) {
                    vista.getCbx_obje_opera().setSelectedItem(listaObjetivos.get(i).getObjetivo());
                    cargarComboAnio();
                }
            }
            for (int i = 0; i < listaActividades.size(); i++) {
                if (lista.get(j).getId_actividades() == listaActividades.get(i).getId_actividades()) {
                    vista.getCbx_actividad().setSelectedItem(listaActividades.get(i).getActividad());
                    cargarComboAnio();
                }
            }
            vista.getTxtArchivo().setText(lista.get(j).getArchivo());
        }

    }

    public int id_actvidad(JComboBox comboactividad) {
        String actividad = (String) vista.getCbx_actividad().getSelectedItem();
        int id_actividad = 0;
        if (Con_poa_evidencia.actividad.equals("")) {
        } else if (Con_poa_evidencia.actividad.equalsIgnoreCase("yes")) {
            if (actividad != null) {
                if (actividad != "Seleccionar") {
                    for (int i = 0; i < listaActividades.size(); i++) {
                        if (listaActividades.get(i).getActividad().equalsIgnoreCase(actividad)) {
                            if (x == true) {
                                if (listaActividades.get(i).getId_objetivo_operativo() == id_obj) {
                                    id_actividad = listaActividades.get(i).getId_actividades();
                                }
                            } else {
                                if (listaActividades.get(i).getId_objetivo_operativo() == Con_poa_evidencia.objetivo_id) {
                                    id_actividad = listaActividades.get(i).getId_actividades();
                                }
                            }
                        }
                    }
                }
            }
        }
        return id_actividad;
    }

    public void guardar() {
        int actividad_id = id_actvidad(vista.getCbx_actividad());
        listaEvidencias = baseDatosEvidencias.mostrarDatos();
        int cod_evid = listaEvidencias.size() + 1;
        for (int i = 0; i < listaEvidencias.size(); i++) {
            if (cod_evid == listaEvidencias.get(i).getId_evidencia()) {
                cod_evid = cod_evid + 1;
            }
        }
        baseDatosEvidencias.guardar(cod_evid, actividad_id, id_poa, proyecto_id, objetivo_id, vista.getTxtArchivo().getText());
        lista();
        nuevo();

    }

    public void nuevo() {
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getCbx_proyecto().setEnabled(true);
        vista.getCbx_carrera().setEnabled(true);
        vista.getCbx_anio().setEnabled(true);
        vista.getCbx_obje_opera().setEnabled(true);
        vista.getCbx_actividad().setEnabled(true);
        vista.getCbx_carrera().setSelectedItem("Seleccionar");
        vista.getCbx_anio().setSelectedItem("Seleccionar");
        vista.getCbx_proyecto().setSelectedItem("Seleccionar");
        vista.getCbx_obje_opera().setSelectedItem("Seleccionar");
        vista.getCbx_actividad().setSelectedItem("Seleccionar");
        vista.getTxtArchivo().setText("");
    }

    public void modificar() {
        String carrera = (String) vista.getCbx_carrera().getSelectedItem();
        String anio = (String) vista.getCbx_anio().getSelectedItem();
        String proyecto = (String) vista.getCbx_proyecto().getSelectedItem();
        String objetivo = (String) vista.getCbx_obje_opera().getSelectedItem();
        String actividad = (String) vista.getCbx_actividad().getSelectedItem();
        if (vista.getTxtArchivo().equals("") || carrera.equalsIgnoreCase("Selecionar") || anio.equalsIgnoreCase("Selecionar") || proyecto.equalsIgnoreCase("Selecionar") || objetivo.equalsIgnoreCase("Selecionar") || actividad.equalsIgnoreCase("Selecionar")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos para poder guardar");
            x=false;
        } else {
            poa = id_poa(vista.getCbx_carrera(), vista.getCbx_anio());
            proyectoo = id_proyecto(vista.getCbx_proyecto());
            id_obj = id_objetivo(vista.getCbx_obje_opera());
            x=true;
            id_act = id_actvidad(vista.getCbx_actividad());

            baseDatosEvidencias.setId_actividades(id_act);
            baseDatosEvidencias.setId_poa(poa);
            baseDatosEvidencias.setId_proyecto(proyecto_id);
            baseDatosEvidencias.setId_objetivo(id_obj);
            baseDatosEvidencias.setArchivo(vista.getTxtArchivo().getText());
            int resp = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro de moficar");
            if (resp == 0) {
                if (baseDatosEvidencias.modificar(String.valueOf(id_evidencia))) {
                    JOptionPane.showMessageDialog(null, "Datos Actualizados");
                    lista();
                    nuevo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public int id_proyecto(JComboBox comboproyecto) {
        String proyecto = (String) comboproyecto.getSelectedItem();
        int id_proyecto = 0;
        if (Con_poa_evidencia.proyecto.equalsIgnoreCase("yes")) {
            if (proyecto != null) {
                if (proyecto != "Seleccionar") {
                    id_proyecto = Integer.parseInt(proyecto.trim());
                    for (int i = 0; i < Con_poa_evidencia.listaProyecto.size(); i++) {
                        if (Con_poa_evidencia.listaProyecto.get(i).getId_Poa() == Con_poa_evidencia.poa) {
                            if ((String.valueOf(Con_poa_evidencia.listaProyecto.get(i).getId_proyecto()).equalsIgnoreCase(proyecto))) {
                                id_proyecto = Con_poa_evidencia.listaProyecto.get(i).getId_proyecto();
                            }
                        }
                    }
                }
            }
        }
        return id_proyecto;
    }

    public int id_poa(JComboBox combocarrera, JComboBox comboanio) {
        String carrera = (String) combocarrera.getSelectedItem();
        String anio = (String) comboanio.getSelectedItem();
        int poa = 0;
        String id_carrera = "";
        for (int i = 0; i < Con_poa_evidencia.listaCarreras.size(); i++) {
            if (Con_poa_evidencia.listaCarreras.get(i).getNombre_carrera().equalsIgnoreCase(carrera)) {
                id_carrera = Con_poa_evidencia.listaCarreras.get(i).getCodigo_carrera();
            }
        }
        for (int i = 0; i < Con_poa_evidencia.listaPoa.size(); i++) {
            if (String.valueOf(Con_poa_evidencia.listaPoa.get(i).getId_carrera()).equalsIgnoreCase(id_carrera)) {
                if (Con_poa_evidencia.listaPoa.get(i).getAnio().equalsIgnoreCase(anio)) {
                    poa = Con_poa_evidencia.listaPoa.get(i).getId_POA();
                }
            }
        }
        return poa;
    }

    public int id_objetivo(JComboBox Cbx_obje_opera) {
        String objetivoo = (String) Cbx_obje_opera.getSelectedItem();
        int id_objetivo = 0;
        if (Con_poa_evidencia.proyecto.equals("")) {
        } else if (Con_poa_evidencia.proyecto.equalsIgnoreCase("yes")) {
            if (objetivoo != null) {
                if (objetivoo != "Seleccionar") {
                    for (int i = 0; i < Con_poa_evidencia.listaObjetivos.size(); i++) {
                        if (Con_poa_evidencia.listaObjetivos.get(i).getObjetivo().equalsIgnoreCase(objetivoo)) {
                            if (String.valueOf(Con_poa_evidencia.listaObjetivos.get(i).getId_proyecto()).equalsIgnoreCase(String.valueOf(proyectoo))) {
                                id_objetivo = Con_poa_evidencia.listaObjetivos.get(i).getId_objetivo_operativo();
                            }
                        }
                    }
                }
            }
        }
        return id_objetivo;
    }

    public void eliminar() {
        int resp = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro de eliminar");
        if (resp == 0) {
            if (baseDatosEvidencias.eliminar(String.valueOf(id_evidencia))) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_Evidencia().getModel();
        List<EvidenciaMD> lista = baseDatosEvidencias.mostrarDatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_Evidencia().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int j = 0; j < lista.size(); j++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_Evidencia().setValueAt(lista.get(j).getId_evidencia(), j, 0);
            for (int k = 0; k < listaPoa.size(); k++) {
                if (lista.get(j).getId_poa() == listaPoa.get(k).getId_POA()) {
                    for (int i = 0; i < listaCarreras.size(); i++) {
                        if (Integer.parseInt(listaCarreras.get(i).getCodigo_carrera()) == listaPoa.get(k).getId_carrera()) {
                            vista.getTabla_Evidencia().setValueAt(listaCarreras.get(i).getNombre_carrera(), j, 1);
                        }
                    }
                    vista.getTabla_Evidencia().setValueAt(listaPoa.get(k).getAnio(), j, 2);
                }
            }
            for (int i = 0; i < listaProyecto.size(); i++) {
                if (lista.get(j).getId_proyecto() == listaProyecto.get(i).getId_proyecto()) {
                    vista.getTabla_Evidencia().setValueAt(listaProyecto.get(i).getNum_proyecto_carrera(), j, 3);
                }
            }
            for (int i = 0; i < listaObjetivos.size(); i++) {
                if (lista.get(j).getId_objetivo()== listaObjetivos.get(i).getId_objetivo_operativo()) {
                    vista.getTabla_Evidencia().setValueAt(listaObjetivos.get(i).getNum_objetivo_proyecto(), j, 4);
                }
            }
            for (int i = 0; i < listaActividades.size(); i++) {
                if (lista.get(j).getId_actividades() == listaActividades.get(i).getId_actividades()) {
                    vista.getTabla_Evidencia().setValueAt(listaActividades.get(i).getActividad(), j, 5);
                }
            }
            vista.getTabla_Evidencia().setValueAt(lista.get(j).getArchivo(), j, 6);
        }
    }
}
