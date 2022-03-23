/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Calendar;

/**
 *
 * @author Myrian
 */
public class Con_calendario {
     private final Vis_Calendar vista;

    public Con_calendario(Vis_Calendar vista) {
        this.vista = vista;
         vista.setVisible(true);
    }
}
