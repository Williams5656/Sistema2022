/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;
import POA.Vista.*;
/**
 *
 * @author isaacmejia
 */
public class Con_BarraProgreso {
    private final vis_BarraProgreso vista;

    public Con_BarraProgreso(vis_BarraProgreso vista) {
        this.vista = vista;
    }
    
    public void cerrarBarra(){
        if (vista.getBarra().getValue() == 100){
            vista.setVisible(false);
        }        
    }
}
