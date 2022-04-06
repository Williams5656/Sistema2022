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

    private JComboBox Cbx_obje_opera, Cbx_actividad;

    ;

    public actividad_evidencia(JComboBox Cbx_obje_opera, JComboBox Cbx_actividad) {
        this.Cbx_obje_opera = Cbx_obje_opera;
        this.Cbx_actividad = Cbx_actividad;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String objetivoo = (String) Cbx_obje_opera.getSelectedItem();
        int id_objetivo = 0;
        Cbx_actividad.removeAllItems();
        Cbx_actividad.addItem("Seleccionar");
        if (Con_poa_evidencia.proyecto.equals("")) {
            Cbx_actividad.removeAllItems();
            Cbx_actividad.addItem("Seleccionar");
        } else if (Con_poa_evidencia.proyecto.equalsIgnoreCase("yes")) {
            if (objetivoo != null) {
                if (objetivoo != "Seleccionar") {
                    id_objetivo = id_objetivo(Cbx_obje_opera);
                    for (int i = 0; i < Con_poa_evidencia.listaActividades.size(); i++) {
                        if (Con_poa_evidencia.listaActividades.get(i).getId_objetivo_operativo() == id_objetivo) {
                            Cbx_actividad.addItem(String.valueOf(Con_poa_evidencia.listaActividades.get(i).getActividad()));
                            Con_poa_evidencia.actividad = "Yes";
                        }
                    }
                    Con_poa_evidencia.objetivo_id = id_objetivo;
                } else {
                    Cbx_actividad.removeAllItems();
                    Cbx_actividad.addItem("Seleccionar");
                }
            } else {
                Cbx_actividad.removeAllItems();
                Cbx_actividad.addItem("Seleccionar");
            }
        } else {
            Cbx_actividad.removeAllItems();
            Cbx_actividad.addItem("Seleccionar");
        }
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
                            if (String.valueOf(Con_poa_evidencia.listaObjetivos.get(i).getId_proyecto()).equalsIgnoreCase(String.valueOf(Con_poa_evidencia.proyecto_id))) {
                                id_objetivo = Con_poa_evidencia.listaObjetivos.get(i).getId_objetivo_operativo();
                            }
                        }
                    }
                }
            }
        }
        return id_objetivo;
    }
}
