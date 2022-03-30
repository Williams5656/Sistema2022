/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Controlador.Con_poa_evidencia;
import POA.Modelo.ActividadesBD;
import POA.Modelo.ObjetivoOperativoBD;
import POA.Modelo.ObjetivoOperativoMD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class actividad_evidencia implements ItemListener {

    private List<POA.Modelo.ActividadesMD> listaActividaes = new ArrayList<>();
    private ActividadesBD baseDatosactividades = new ActividadesBD();
    private ObjetivoOperativoBD baseDatosObjOperativo = new ObjetivoOperativoBD();
    private ArrayList<ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
    private JComboBox Cbx_obje_opera, Cbx_actividad;

    public actividad_evidencia(JComboBox Cbx_obje_opera, JComboBox Cbx_actividad) {
        this.Cbx_obje_opera = Cbx_obje_opera;
        this.Cbx_actividad = Cbx_actividad;
    }
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        listaActividaes = baseDatosactividades.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjOperativo.mostrarDatos();
        String objetivo = (String) Cbx_obje_opera.getSelectedItem();
        if (objetivo != "Seleccionar") {
            Cbx_actividad.removeAllItems();
            Cbx_actividad.addItem("Seleccionar");
            for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
                if (listaObjetivosOperativos.get(i).getNum_objetivo_proyecto() == Integer.parseInt(objetivo) && listaObjetivosOperativos.get(i).getId_proyecto() == Con_poa_evidencia.id_proyecto) {
                    Con_poa_evidencia.id_objetivo = listaObjetivosOperativos.get(i).getId_objetivo_operativo();
                }
            }
            for (int i = 0; i < listaActividaes.size(); i++) {
                if (listaActividaes.get(i).getId_objetivo_operativo() == Con_poa_evidencia.id_objetivo) {
                    Cbx_actividad.addItem(String.valueOf(listaActividaes.get(i).getActividad()));
                    Con_poa_evidencia.id_actividad = listaActividaes.get(i).getId_actividades();

                }
            }
        }else{
            Cbx_actividad.removeAllItems();
            Cbx_actividad.addItem("Seleccionar");
        }
    }
}
