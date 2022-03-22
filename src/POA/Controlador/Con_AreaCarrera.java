/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.AreaCarreraBD;
import POA.Modelo.AreaCarreraMD;
import POA.Modelo.CarreraBD;
import POA.Modelo.CarreraMD;
import POA.Modelo.PerfilBD;
import POA.Modelo.PerfilMD;
import POA.Vista.Vis_AreaCarrera;
import POA.Modelo.Validadores.Letras;
import POA.Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Con_AreaCarrera {

    private final Vis_AreaCarrera vista;
    private AreaCarreraBD bdarea= new AreaCarreraBD();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<AreaCarreraMD> lista = new ArrayList<>();
    private List<PerfilMD> listaPerfiles = new ArrayList<>();
    private List<CarreraMD> listaCarrera = new ArrayList<>();
    private PerfilBD baseDatosPerfil = new PerfilBD();
    private CarreraBD baseDatosCarrera = new CarreraBD();

    public Con_AreaCarrera(Vis_AreaCarrera vista) {
        this.vista = vista;
        cargarComboPerfil();
        cargarComboResponsable();
        cargarComboCarrera();
        vista.setVisible(true);
//        vista.getBtn_guardar().addActionListener(e -> guardar());
//        vista.getBtn_modificar().addActionListener(e -> modificar());
//        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getTablaAreaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                seleccionar();
            }
        });
        desactivarBotones();
//        lista();
    }

    public void desactivarBotones() {
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getComboPerfil().setEnabled(false);
        vista.getComboResponsable().setEnabled(false);
        vista.getComboCarrera().setEnabled(false);
    }

    public void cargarComboPerfil() {
        vista.getComboPerfil().removeAllItems();
        vista.getComboPerfil().addItem("");
        listaPerfiles = baseDatosPerfil.mostrardatos();
        for (PerfilMD perfil : listaPerfiles) {
            vista.getComboPerfil().addItem(perfil.getNombre());
        }
    }

    public void cargarComboResponsable() {
        vista.getComboResponsable().removeAllItems();
        vista.getComboResponsable().addItem("");
//        listaPerfiles = baseDatosPerfil.mostrardatos();
//        for (PerfilMD perfil : listaPerfiles){
//            vista.getComboPerfil().addItem(perfil.getNombre());
//        }
    }

    public void cargarComboCarrera() {
        vista.getComboCarrera().removeAllItems();
        vista.getComboCarrera().addItem("");
        listaCarrera = baseDatosCarrera.mostrardatos();
        for (CarreraMD carrera : listaCarrera) {
            vista.getComboCarrera().addItem(carrera.getNombre_carrera());
        }
    }

    private void nuevo() {
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getComboPerfil().setEnabled(true);
        vista.getComboResponsable().setEnabled(true);
        vista.getComboCarrera().setEditable(true);
        vista.getComboPerfil().setSelectedIndex(0);
        vista.getComboResponsable().setSelectedIndex(0);
        vista.getComboCarrera().setSelectedIndex(0);
    }

    private void guardar() {

        if (vista.getComboCarrera().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione la Carrera");
        } else if (vista.getComboPerfil().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione el Perfil");
        } else if (vista.getComboResponsable().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione el Responsable");
        } else {
            String perfilCombo = (String) vista.getComboPerfil().getSelectedItem();
            int codigoPerfil = 0;
            String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
            String codigoCarrera="";
            String responsableCombo = (String) vista.getComboResponsable().getSelectedItem();
            for (PerfilMD perfil : listaPerfiles) {
                if (perfilCombo.equals(perfil.getNombre())) {
                    codigoPerfil = perfil.getCodigo();
                }
            }
            for (CarreraMD carrera : listaCarrera) {
                if (carreraCombo.equals(carrera.getNombre_carrera())) {
                    codigoCarrera = carrera.getCodigo_carrera();
                }
            }
           if (bdarea.insertar()) {
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
            
        }
}

private void modificar() {
        int seleccionado = vista.getTablaAreaCarrera().getSelectedRow();
        int codigoPerfil = 0;
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdarea.modificar(lista.get(seleccionado).getIdArea())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
            }
        }
    }

    private void eliminar() {
        int seleccionado = vista.getTablaAreaCarrera().getSelectedRow();
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdarea.eliminar(lista.get(seleccionado).getIdArea())) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }

    }

    private void seleccionar() {
        int select = vista.getTablaAreaCarrera().getSelectedRow();
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        lista = bdarea.mostrardatos();
        for (PerfilMD perfil : listaPerfiles){
            if (perfil.getCodigo() == lista.get(select).getIdPerfil()){
                vista.getComboPerfil().setSelectedItem(perfil.getNombre());
            }
        }
        for (CarreraMD carrera : listaCarrera){
            if (carrera.getCodigo_carrera()== lista.get(select).getIdCarrera()){
                vista.getComboCarrera().setSelectedItem(carrera.getNombre_carrera());
            }
        }
    }

    public void lista(){
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        
        modelo.addColumn("Id");
        modelo.addColumn("Cédula Persona");
        modelo.addColumn("Perfil");
        
        lista = bdarea.mostrardatos();
        for (AreaCarreraMD user : lista) {
            Object[] fila = new Object[3];
            fila[0] = user.getIdPerfil();
            fila[1] = user.getIdCarrera();
            fila[2] = user.getIdPerfil();
            fila[3] = user.getIdResponsable();
            modelo.addRow(fila);
        }
        
        vista.getTablaAreaCarrera().setModel(modelo);

    }
}
