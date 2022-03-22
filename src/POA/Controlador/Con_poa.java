/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.vis_poa;

/**
 *
 * @author USUARIO
 */
public class Con_poa {
     private final vis_poa vista;
     
    public Con_poa(vis_poa vista) {
      this.vista = vista;
        vista.setVisible(true);

    }
}
