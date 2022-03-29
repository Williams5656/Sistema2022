/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.ActividadesBD;
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
public class Con_poa_evidencia {

    private final vis_poa_evidencia vista;
    private ArrayList<ProyectoMD> listaProyectos = new ArrayList<>();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private List<POA.Modelo.ActividadesMD> listaActividaes = new ArrayList<>();
    private List<POA.Modelo.EvidenciaMD> listaEvidencias = new ArrayList<>();
    private ArrayList<ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
    private ProyectoBD baseDatosProyecto = new ProyectoBD();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private PoaBD baseDatosPoa = new PoaBD();
    private ActividadesBD baseDatosactividades = new ActividadesBD();
    private EvidenciaBD baseDatosEvidencias = new EvidenciaBD();
    private ObjetivoOperativoBD baseDatosObjOperativo = new ObjetivoOperativoBD();

    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
        lista();
        vista.getCbx_carrera().removeAllItems();
        vista.getCbx_anio().removeAllItems();
        vista.getCbx_actividad().removeAllItems();
        vista.getCbx_obje_opera().removeAllItems();
        vista.getCbx_proyecto().removeAllItems();
        vista.getBtnGuardar().addActionListener(e -> guardar());
        //cargarComboCarrera();
        //cargarComboAnio();
        //cargarComboProyecto();
    }

    public void cargarComboCarrera() {
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPoa = baseDatosPoa.mostrarDatos();
        for (int i = 0; i < listaCarreras.size(); i++) {
            for (int j = 0; j < listaPoa.size(); i++) {
                if (Integer.parseInt(listaCarreras.get(i).getCodigo_carrera()) == listaPoa.get(j).getId_carrera()) {
                    vista.getCbx_carrera().addItem(listaCarreras.get(i).getNombre_carrera());
                }
            }
        }
    }

    public void cargarComboAnio() {
        listaPoa = baseDatosPoa.mostrarDatos();
        for (int i = 0; i < listaPoa.size(); i++) {
            vista.getCbx_anio().addItem(listaPoa.get(i).getAnio());
        }
    }

    public void cargarComboProyecto() {
        String carrera = (String) vista.getCbx_carrera().getSelectedItem();
        String anio = (String) vista.getCbx_anio().getSelectedItem();
        for (int i = 0; i < listaPoa.size(); i++) {
            if (listaCarreras.get(i).getNombre_carrera().equals(carrera)) {
                String id_carrera = listaCarreras.get(i).getCodigo_carrera();
                if (listaPoa.get(i).getId_carrera() == Integer.parseInt(id_carrera));
                if (listaPoa.get(i).getAnio() == anio) {
                    vista.getCbx_proyecto().addItem("Proyecto: " + listaProyectos.get(i).getNum_proyecto_carrera());
                }
            }

        }
    }

    public void cargarComboObjetivos() {
        listaPoa = baseDatosPoa.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjOperativo.mostrarDatos();
        vista.getCbx_carrera().removeAllItems();
        int proyecto = (int) vista.getCbx_proyecto().getSelectedItem();
        for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
            if (listaObjetivosOperativos.get(i).getId_proyecto() == proyecto) {
                vista.getCbx_obje_opera().addItem(String.valueOf(listaObjetivosOperativos.get(i).getNum_objetivo_proyecto()));
            }
        }
    }

    public void cargarComboActividad() {
        listaPoa = baseDatosPoa.mostrarDatos();
        listaActividaes = baseDatosactividades.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjOperativo.mostrarDatos();
        vista.getCbx_carrera().removeAllItems();
        int proyecto = (int) vista.getCbx_proyecto().getSelectedItem();
        int objetivo = (int) vista.getCbx_obje_opera().getSelectedItem();
        for (int i = 0; i < listaActividaes.size(); i++) {
            if (listaObjetivosOperativos.get(i).getId_proyecto() == proyecto) {
                if (listaActividaes.get(i).getId_objetivo_operativo() == objetivo) {
                    vista.getCbx_actividad().addItem(String.valueOf(listaActividaes.get(i).getId_actividades()));

                }
            }
        }
    }

    public void guardar() {
        listaEvidencias = baseDatosEvidencias.mostrarDatos();
        int cod_evid = listaEvidencias.size() + 1;
        baseDatosEvidencias.guardar(cod_evid, vista.getTxtArchivo().getText());
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
