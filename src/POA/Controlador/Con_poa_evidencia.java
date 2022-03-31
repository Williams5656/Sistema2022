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
import javax.swing.JComboBox;

/**
 *
 * @author USUARIO
 */
public class Con_poa_evidencia  {

    private final vis_poa_evidencia vista;
    private List<POA.Modelo.ActividadesMD> listaActividaes = new ArrayList<>();
    private ActividadesBD baseDatosactividades = new ActividadesBD();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private List<POA.Modelo.EvidenciaMD> listaEvidencias = new ArrayList<>();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private PoaBD baseDatosPoa = new PoaBD();
    private EvidenciaBD baseDatosEvidencias = new EvidenciaBD();
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
        vista.getCbx_proyecto().setEnabled(false);
        vista.getCbx_carrera().setEnabled(false);
        vista.getCbx_anio().setEnabled(false);
        vista.getCbx_obje_opera().setEnabled(false);
        vista.getCbx_actividad().setEnabled(false);
        cargarComboCarrera();
        cargarComboAnio();
        lista();
    }

    public void cargarComboCarrera() {
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPoa = baseDatosPoa.mostrarDatos();
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

    public int id_actvidad(JComboBox comboactividad) {
        listaActividaes=baseDatosactividades.mostrarDatos();
        String actividad = (String) vista.getCbx_actividad().getSelectedItem();
        int id_actividad = 0;
        if (Con_poa_evidencia.actividad.equals("")) {
        } else if (Con_poa_evidencia.actividad.equalsIgnoreCase("yes")) {
            if (actividad != null) {
                if (actividad != "Seleccionar") {
                    for (int i = 0; i < listaActividaes.size(); i++) {
                        if (listaActividaes.get(i).getActividad().equalsIgnoreCase(actividad)) {
                            if (listaActividaes.get(i).getId_objetivo_operativo() == Con_poa_evidencia.objetivo_id) {
                                id_actividad = listaActividaes.get(i).getId_actividades();
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
        baseDatosEvidencias.guardar(cod_evid, actividad_id,id_poa,proyecto_id,objetivo_id, vista.getTxtArchivo().getText());
        lista();
        nuevo();
        
    }

    public void nuevo() {
        vista.getCbx_actividad().setSelectedItem("");
        vista.getCbx_anio().setSelectedItem("");
        vista.getCbx_carrera().setSelectedItem("");
        vista.getCbx_obje_opera().setSelectedItem("");
        vista.getCbx_proyecto().setSelectedItem("");
        vista.getTxtArchivo().setText("");
        vista.getCbx_proyecto().setEnabled(true);
        vista.getCbx_carrera().setEnabled(true);
        vista.getCbx_anio().setEnabled(true);
        vista.getCbx_obje_opera().setEnabled(true);
        vista.getCbx_actividad().setEnabled(true);
        lista();
    }

    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_Evidencia().getModel();
        List<EvidenciaMD> lista = baseDatosEvidencias.mostrarDatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_Evidencia().getRowCount()-1;j >= 0; j--) {
            modelo.removeRow(j);        }
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getId_evidencia(), i, 0);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getId_actividades(), i, 1);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getId_poa(), i, 2);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getId_proyecto(), i, 3);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getId_objetivo(), i, 4);
            vista.getTabla_Evidencia().setValueAt(lista.get(i).getArchivo(), i, 5); 
        }
    }
}
