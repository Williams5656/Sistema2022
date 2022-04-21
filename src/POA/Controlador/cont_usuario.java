/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Controlador.Con_rol;
import POA.Modelo.RolBD;
import POA.Modelo.RolMD;
import POA.Modelo.UsuarioBD;
import POA.Modelo.UsuarioMD;
import POA.Modelo.Validadores.*;
import POA.Vista.Vis_Usuario;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class cont_usuario {
    private final Vis_Usuario vista;
    private UsuarioBD bdusuario = new UsuarioBD();
    RolBD bdrol = new RolBD();
    public cont_usuario(Vis_Usuario vista) {
        this.vista = vista;
        vista.setVisible(true);
        cedexistente();
        vista.getLblmensaje().setVisible(true);
        vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        vista.getBtnmodificar().addActionListener(e->modificar());
        vista.getBtneliminar().addActionListener(e->cambiarestado());
        vista.getBtncedula().addActionListener(e->buscarced());
        vista.getBtnbuscar().addActionListener(e->buscar());
        
        vista.getTableUsuario().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
            
        });
        
       validar();
        roles();
        lista();
        
    }
    
    public void validar(){
        //cedula
        Letras.no_espacios(vista.getTxtcedula());
        Letras.numero_letras(vista.getTxtcedula(), 9);
        Numeros.solo_numeros(vista.getTxtcedula());
        //Usuarios
        Letras.numero_letras(vista.getTxtUsuario(), 9);
        
    }
    
    public void roles(){
        
        List<RolMD> listar = bdrol.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getComborol().addItem(listar.get(i).getNombre_rol());
        }
        
        
    }
    public void buscarced(){
        PersonaBD dbp = new PersonaBD();
        List<PersonaMD> lista = dbp.mostrardatos();
        UsuarioBD dbpu = new UsuarioBD();
        List<UsuarioMD> listau = dbpu.mostrardatos();
        int n=0;
        for (int i = 0; i < lista.size(); i++) {
            
            if (vista.getTxtcedula().getText().equals(lista.get(i).getCedula())) {
                
                cedcorrect();
                vista.getLblnombre().setText(lista.get(i).getNombres()+" "+lista.get(i).getApellidos());
                vista.getTxtcedula().setEditable(false);
                n=2;               
            }else{
                
            }
           
        }
        
        for (int j = 0; j < listau.size(); j++) {
                            if (vista.getTxtcedula().getText().equals(listau.get(j).getCedula())) {
                                cedexistente();
                                n=1;
                            }else{
                                
                            }
                        }
        
        switch(n){
            case 0: vista.getLblmensaje().setVisible(true);
                break;
            case 1: JOptionPane.showMessageDialog(null, "*Usuario ya existente");
                break;
            case 2: vista.getLblmensaje().setVisible(false);
                break;
        }
        
        
        
    }
    public void cedexistente(){
        
        
        vista.getTxtcedula().setEditable(true);
        vista.getTxtUsuario().setEditable(false);
        vista.getTxtcontra().setEditable(false);
        vista.getLblmensaje().setVisible(false);
        vista.getLblnombre().setText("");
        vista.getComboestado().setEnabled(false);
        vista.getComborol().setEnabled(false);
        
        
    }
    public void cedcorrect(){
        
        vista.getTxtcedula().setEditable(true);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtUsuario().setEditable(true);
        vista.getTxtcontra().setEditable(true);
        vista.getLblmensaje().setVisible(false);
        vista.getComboestado().setEnabled(true);
        vista.getComborol().setEnabled(true);
        
    }
    
    
    public void nuevo(){
        
        vista.getBtnguardar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(false);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtbuscar().setText("");
        vista.getTxtcedula().setText("");
        vista.getTxtUsuario().setText("");
        vista.getTxtcontra().setText("");
        vista.getLblmensaje().setVisible(true);
        vista.getLblnombre().setText("");
        vista.getComboestado().setSelectedIndex(0);
        vista.getComborol().setSelectedIndex(0);
        cedexistente();
        lista();
        
        
    }
    
    public void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTableUsuario().getModel();
            List<UsuarioMD> lista1 = bdusuario.mostrarDatosCodigo(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista1.size(); i++) {
                    if (lista1.get(i).getCedula().equals(vista.getTxtbuscar().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTableUsuario().setValueAt(lista1.get(i).getCedula(), i, 0);
                        vista.getTableUsuario().setValueAt(lista1.get(i).getNombreUsuario(), i, 1);
                        vista.getTableUsuario().setValueAt(lista1.get(i).getContrasenia(), i, 2);
                        vista.getTableUsuario().setValueAt(lista1.get(i).getRol(), i, 3);
                        vista.getTableUsuario().setValueAt(lista1.get(i).getEstado(), i, 4);
                    }
                }
            }
        }
        
    }
    
    public void guardar(){
        
        bdusuario.setCedula(vista.getTxtcedula().getText());
        bdusuario.setNombreUsuario(vista.getTxtUsuario().getText());
        bdusuario.setContrasenia((vista.getTxtcontra().getText()));
        String estado = (String) vista.getComboestado().getSelectedItem();
        bdusuario.setEstado(estado);
         List<RolMD> listar = bdrol.mostrardatos();
         int idrol = vista.getComborol().getSelectedIndex();
         int nrol = listar.get(idrol).getId_rol();
         bdusuario.setRol(nrol);
         System.out.println(nrol);
        if (vista.getTxtcedula().getText().equals("")||vista.getTxtUsuario().getText().equals("")||vista.getTxtcontra().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            nuevo();
        }else{
            if (bdusuario.guardar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            lista();
            nuevo();
            cedexistente();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        }
        
    }
    
    public void cambiarestado() {
        String estado = (String) vista.getComboestado().getSelectedItem();
       
            int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro el cambio de estado");
            if (resp2 == 0) {
                if (estado.equals("Activo")) {
                    if (bdusuario.desactivar(vista.getTxtcedula().getText())) {
                        JOptionPane.showMessageDialog(null, "Datos desactivados correctamente");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al desactivar");
                    }
                }
                
                if (estado.equals("Inactivo")) {
                    if (bdusuario.activar(vista.getTxtcedula().getText())) {
                        JOptionPane.showMessageDialog(null, "Datos activados correctamente");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al desactivar");
                    }
                }

            }
        
    }

    

    public void modificar() {
        bdusuario.setCedula(vista.getTxtcedula().getText());
        bdusuario.setNombreUsuario(vista.getTxtUsuario().getText());
         List<RolMD> listar = bdrol.mostrardatos();
         int idrol = vista.getComborol().getSelectedIndex();
         int nrol = listar.get(idrol).getId_rol();
         bdusuario.setRol(nrol);
        bdusuario.setContrasenia((vista.getTxtcontra().getText()));
        
        int resp2 = JOptionPane.showConfirmDialog(null, "Confirme si esta seguro modificar");
        if (resp2 == 0) {
            if (bdusuario.modificar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }
    
    
    public void seleccionar(){
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);
        vista.getTxtcedula().setEditable(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTableUsuario().getSelectedRow(), 0);
        System.out.println(cedula);
        List<RolMD> listar = bdrol.mostrardatos();
        List<UsuarioMD> lista = bdusuario.obtenerDatos(cedula);
        bdusuario.setCedula(lista.get(0).getCedula());
        bdusuario.setNombreUsuario(lista.get(0).getNombreUsuario());
        bdusuario.setContrasenia(lista.get(0).getContrasenia());
        bdusuario.setRol(lista.get(0).getRol());
        bdusuario.setEstado(lista.get(0).getEstado());
        
        
        vista.getTxtcedula().setText(bdusuario.getCedula());
        vista.getTxtUsuario().setText(bdusuario.getNombreUsuario());
        vista.getTxtcontra().setText(bdusuario.getContrasenia());  
        int idrol = lista.get(0).getRol();
        List<RolMD> listar1 = bdrol.obtenerDatos(idrol);
        vista.getComborol().setSelectedItem(listar1.get(0).getNombre_rol());
        vista.getComboestado().setSelectedItem(bdusuario.getEstado());
        
        
        vista.getTxtcedula().setEditable(false);
        vista.getTxtcedula().setEditable(true);
        vista.getTxtUsuario().setEditable(true);
        vista.getTxtcontra().setEditable(true);
        vista.getLblmensaje().setVisible(false);
        vista.getComboestado().setEnabled(true);
        
    }
    
    public void lista(){
        DefaultTableModel modelo;
         List<RolMD> listar = bdrol.mostrardatos();
        modelo = (DefaultTableModel) vista.getTableUsuario().getModel();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTableUsuario().getRowCount()-1;j >= 0; j--) {
            modelo.removeRow(j);        }
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTableUsuario().setValueAt(lista.get(i).getNombreUsuario(), i, 1);
            vista.getTableUsuario().setValueAt(lista.get(i).getContrasenia(), i, 2);
            int idrol = lista.get(i).getRol();
            List<RolMD> listar1 = bdrol.obtenerDatos(idrol);
            vista.getTableUsuario().setValueAt(listar1.get(0).getNombre_rol(), i, 3);
            vista.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 4);            
            
        }
        
        
        
    }
    
}


