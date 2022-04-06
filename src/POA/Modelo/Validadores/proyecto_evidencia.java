/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.ProyectoMD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import POA.Modelo.Validadores.anio_evidecia;
import POA.Controlador.Con_poa_evidencia;

/**
 *
 * @author ASUS
 */
public class proyecto_evidencia implements ItemListener {

    private JComboBox Cbx_carrera, Cbx_anio, Cbx_proyecto;

    public proyecto_evidencia(JComboBox Cbx_carrera, JComboBox Cbx_anio, JComboBox Cbx_proyecto) {
        this.Cbx_carrera = Cbx_carrera;
        this.Cbx_anio = Cbx_anio;
        this.Cbx_proyecto = Cbx_proyecto;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String carrera = (String) Cbx_carrera.getSelectedItem();
        String anio = (String) Cbx_anio.getSelectedItem();
        int poa = 0;
        String id_carrera = "";
        if (carrera.equalsIgnoreCase("") || carrera.equalsIgnoreCase("Seleccionar")) {
            Cbx_proyecto.removeAllItems();
            Cbx_proyecto.addItem("Seleccionar");
        } else {
            if (anio != "null" || anio != "") {
                if (carrera != "Seleccionar" && anio != "Seleccionar") {
                    Cbx_proyecto.removeAllItems();
                    Cbx_proyecto.addItem("Seleccionar");
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
                    for (int j = 0; j < Con_poa_evidencia.listaProyecto.size(); j++) {
                        if (Con_poa_evidencia.listaProyecto.get(j).getId_Poa() == poa) {
                            Cbx_proyecto.addItem(String.valueOf(Con_poa_evidencia.listaProyecto.get(j).getId_proyecto()));
                            Con_poa_evidencia.proyecto = "YES";
                        }
                    }
                    Con_poa_evidencia.id_poa = poa;;
                }

            } else {
                Cbx_proyecto.removeAllItems();
                Cbx_proyecto.addItem("Seleccionar");
            }
        }
    }
}
