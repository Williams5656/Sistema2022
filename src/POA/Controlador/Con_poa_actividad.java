/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.vis_poa_actividad;

/**
 *
 * @author USUARIO
 */
public class Con_poa_actividad {
      private final vis_poa_actividad vista;
    

    public Con_poa_actividad(vis_poa_actividad vista) {
       this.vista = vista;
        vista.setVisible(true);

    }
}
