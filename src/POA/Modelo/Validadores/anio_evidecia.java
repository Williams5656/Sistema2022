/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class anio_evidecia implements ItemListener {
    private JComboBox Cbx_carrera,Cbx_anio;
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private PoaBD baseDatosPoa = new PoaBD();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private CarreraBD baseDatosCarrera = new CarreraBD();

    public anio_evidecia(JComboBox Cbx_carrera, JComboBox Cbx_anio) {
        this.Cbx_carrera = Cbx_carrera;
        this.Cbx_anio = Cbx_anio;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        String nomcarrera = (String) Cbx_carrera.getSelectedItem();
        if (nomcarrera != "Seleccionar") {
            Cbx_anio.removeAllItems();
            Cbx_anio.addItem("Seleccionar");
            listaCarreras = baseDatosCarrera.mostrardatos();
            listaPoa = baseDatosPoa.mostrarDatos();
            int id_carrera = 0;
            for (int i = 0; i < listaCarreras.size(); i++) {
                if (listaCarreras.get(i).getNombre_carrera().equalsIgnoreCase(nomcarrera)) {
                    id_carrera = Integer.parseInt(listaCarreras.get(i).getCodigo_carrera());
                }
            }
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
    
}
