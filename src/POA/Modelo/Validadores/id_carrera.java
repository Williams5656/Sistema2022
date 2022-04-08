/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import POA.Controlador.Con_Poa1;

/**
 *
 * @author ASUS
 */
public class id_carrera implements ItemListener {

    JComboBox comboCarrera;
    JLabel id_carrear;

    public id_carrera(JComboBox comboCarrera, JLabel id_carrear) {
        this.comboCarrera = comboCarrera;
        this.id_carrear = id_carrear;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String carrera = (String) comboCarrera.getSelectedItem();
        System.out.println(carrera);
        if (carrera != "Seleccionar") {
            for (int i = 0; i < Con_Poa1.listaCarreras.size(); i++) {
                if (Con_Poa1.listaCarreras.get(i).getNombre_carrera().equalsIgnoreCase(carrera)) {
                    id_carrear.setText(Con_Poa1.listaCarreras.get(i).getCodigo_carrera());
                }
            }
        }
    }

}
