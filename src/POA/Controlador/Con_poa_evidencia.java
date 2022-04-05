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
    public static int id_poa = 0;
    public static String objetivo = "";
    public static int objetivo_id = 0;
    public static String proyecto = "";
    public static int proyecto_id = 0;
    public static String actividad = "";
    public static int id_actividad = 0;

    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnImprimir().addActionListener(e -> imprimir());
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

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Evidencia.jasper"));
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
        vista.getBtnModificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_Evidencia().getModel();
        int id_evid = (int) modelo.getValueAt(vista.getTabla_Evidencia().getSelectedRow(), 0);
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
                            if (listaActividades.get(i).getId_objetivo_operativo() == Con_poa_evidencia.objetivo_id) {
                                id_actividad = listaActividades.get(i).getId_actividades();
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
        baseDatosEvidencias.guardar(cod_evid, actividad_id, id_poa, proyecto_id, objetivo_id, vista.getTxtArchivo().getText());
        lista();
        nuevo();

    }

    public void nuevo() {
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
        

        lista();
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
                        if (Integer.parseInt(listaCarreras.get(i).getCodigo_carrera()) == listaPoa.get(j).getId_carrera()) {
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
                if (lista.get(j).getId_actividades() == listaObjetivos.get(i).getId_objetivo_operativo()) {
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
