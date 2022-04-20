/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Controlador.Con_poa_evidencia;
import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
//import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class anio_evidecia implements ItemListener {

    private JComboBox Cbx_carrera, Cbx_anio;

    public anio_evidecia(JComboBox Cbx_carrera, JComboBox Cbx_anio) {
        this.Cbx_carrera = Cbx_carrera;
        this.Cbx_anio = Cbx_anio;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String nomcarrera = (String) Cbx_carrera.getSelectedItem();
        if (nomcarrera.equalsIgnoreCase("")) {
            Cbx_anio.removeAllItems();
            Cbx_anio.addItem("Seleccionar");
        } else {
            if (nomcarrera != "Seleccionar") {
                Cbx_anio.removeAllItems();
                Cbx_anio.addItem("Seleccionar");
                int id_carrera = id_carrera(Cbx_carrera);
                for (int i = 0; i < Con_poa_evidencia.listaPoa.size(); i++) {
                    if (Integer.parseInt(Con_poa_evidencia.listaPoa.get(i).getId_carrera())==id_carrera) {
                        Cbx_anio.addItem(Con_poa_evidencia.listaPoa.get(i).getAnio());
                    }
                }
            } else {
                Cbx_anio.removeAllItems();
                Cbx_anio.addItem("Seleccionar");
            }
        }
    }

    public int id_carrera(JComboBox combocarrera) {
        String nomcarrera = (String) Cbx_carrera.getSelectedItem();
        String id_carrera = "0";
        for (int i = 0; i < Con_poa_evidencia.listaCarreras.size(); i++) {
            if (Con_poa_evidencia.listaCarreras.get(i).getNombre_carrera().equalsIgnoreCase(nomcarrera)) {
                id_carrera = Con_poa_evidencia.listaCarreras.get(i).getCodigo_carrera();
            }
        }
        return Integer.parseInt(id_carrera);
    }

}
