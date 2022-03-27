/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.ProyectoBD;
import POA.Vista.vis_poa_proyectos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Con_poa_proyectos {

    private final vis_poa_proyectos vista;
    ProyectoBD poabd = new ProyectoBD();

    public Con_poa_proyectos(vis_poa_proyectos vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());

    }

    public void nuevo() {
        vista.getTxt_estrategia().setText("");
        vista.getTxt_obestra().setText("");
        vista.getTxt_obtac().setText("");
    }
    
    public void guardar() {
        String anios = (String) vista.getCb_anio().getSelectedItem();
        
//
//        poabd.set(vista.getTxt_placa().getText());
//        poabd.setMarca(marca);
//        poabd.setModelo(vista.getTxt_modelo().getText());
//        poabd.setAnios(Integer.parseInt(vista.getTxt_anios().getText()));
//        autobd.setColor(color);
//        poabd.setMotor(Integer.parseInt(vista.getTxt_motor().getText()));
//        poabd.setChasis(vista.getTxt_chasis().getText());
//
//
//        ImageIcon ic = (ImageIcon) vista.getFoto().getIcon();
//        autobd.setFoto(ic.getImage());
//
//        if (autobd.insertar()) {
//            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTEMENTE MI ESTIMADO CABEZA GATO");
//            lista();
//        } else {
//            JOptionPane.showMessageDialog(null, "NI PARA ESO MI ESTIMADO");
//        }
    }
}
