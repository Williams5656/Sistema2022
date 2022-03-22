/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.vis_poa_evidencia;

/**
 *
 * @author USUARIO
 */
public class Con_poa_evidencia {
      private final vis_poa_evidencia vista;
    

    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
       

    }
}
