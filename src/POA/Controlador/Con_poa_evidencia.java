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

/**
 *
 * @author USUARIO
 */
public class Con_poa_evidencia  {

    private final vis_poa_evidencia vista;
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private List<POA.Modelo.EvidenciaMD> listaEvidencias = new ArrayList<>();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private PoaBD baseDatosPoa = new PoaBD();
    private EvidenciaBD baseDatosEvidencias = new EvidenciaBD();
    public static  String anio="";
    public static String id_carrera="";
    public static int id_poa=0;
    public static  int id_objetivo=0;
    public static int id_proyecto=0;
    public static  int id_actividad=0;
    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();
        vista.getBtnGuardar().addActionListener(e -> guardar());
        cargarComboCarrera();
        cargarComboAnio();
    }

    public void cargarComboCarrera() {
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPoa = baseDatosPoa.mostrarDatos();
        for (int j = 0; j < listaPoa.size(); j++) {
            for (int i = 0; i < listaCarreras.size(); i++) {
                if (Integer.parseInt(listaCarreras.get(i).getCodigo_carrera()) == listaPoa.get(j).getId_carrera()) {
                    vista.getCbx_carrera().addItem(listaCarreras.get(i).getNombre_carrera());
                    id_carrera=listaCarreras.get(i).getCodigo_carrera();
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

    public void guardar() {
        int actividad_id = (int) vista.getCbx_actividad().getSelectedItem();
        listaEvidencias = baseDatosEvidencias.mostrarDatos();
        int cod_evid = listaEvidencias.size() + 1;
        baseDatosEvidencias.guardar(cod_evid, actividad_id,vista.getTxtArchivo().getText());
        nuevo();
        lista();
    }

    public void nuevo() {
        vista.getCbx_actividad().setSelectedItem("");
        vista.getCbx_anio().setSelectedItem("");
        vista.getCbx_carrera().setSelectedItem("");
        vista.getCbx_obje_opera().setSelectedItem("");
        vista.getCbx_proyecto().setSelectedItem("");
        vista.getTxtArchivo().setText("");
    }

    public void lista() {
        if (listaEvidencias.size() != 0) {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_Evidencias().getModel();
            List<EvidenciaMD> lista3 = baseDatosEvidencias.mostrarDatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTabla_Evidencias().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista3.size(); i++) {
                    modelo.addRow(new Object[columnas]);
                    vista.getTabla_Evidencias().setValueAt(lista3.get(i).getId_evidencia(), i, 0);
                    vista.getTabla_Evidencias().setValueAt(lista3.get(i).getId_actividades(), i, 1);
                    vista.getTabla_Evidencias().setValueAt(lista3.get(i).getArchivo(), i, 2);
                }

            }
        }
    }

    
}
