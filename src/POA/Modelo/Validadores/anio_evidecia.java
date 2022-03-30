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
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private List<POA.Modelo.CarreraMD> listaCarrera = new ArrayList<>();
    private PoaBD baseDatosPoa = new PoaBD();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    String id_carrera = "";

    public anio_evidecia(JComboBox Cbx_carrera, JComboBox Cbx_anio) {
        this.Cbx_carrera = Cbx_carrera;
        this.Cbx_anio = Cbx_anio;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String nomcarrera = (String) Cbx_carrera.getSelectedItem();
        int id_carrera=id_carrera(Cbx_carrera);
        if (nomcarrera != "Seleccionar") {
            Cbx_anio.removeAllItems();
            Cbx_anio.addItem("Seleccionar");
            listaPoa = baseDatosPoa.mostrarDatos();
            for (int i = 0; i < listaPoa.size(); i++) {
                if (listaPoa.get(i).getId_carrera() == id_carrera) {
                    Cbx_anio.addItem(listaPoa.get(i).getAnio());
               }
            }
        } else {
            Cbx_anio.removeAllItems();
            Cbx_anio.addItem("Seleccionar");
        }
    }

    public int id_carrera(JComboBox combocarrera) {
        String nomcarrera = (String) Cbx_carrera.getSelectedItem();
        String id_carrera="";
        listaCarrera = baseDatosCarrera.mostrardatos();
        for (int i = 0; i < listaCarrera.size(); i++) {
            if (listaCarrera.get(i).getNombre_carrera().equalsIgnoreCase(nomcarrera)) {
                id_carrera = listaCarrera.get(i).getCodigo_carrera();
            }
        }
        return Integer.parseInt(id_carrera);
    }

}
