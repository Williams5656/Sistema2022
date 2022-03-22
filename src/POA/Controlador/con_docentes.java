/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.vis_Docentes;

/**
 *
 * @author HP
 */
public class con_docentes {
    private final vis_Docentes vista;
     
    public con_docentes(vis_Docentes vista) {
      this.vista = vista;
        vista.setVisible(true);

    }
}
