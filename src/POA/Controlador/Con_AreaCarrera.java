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
import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Vista.Vis_AreaCarrera;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.docenteBD;
import POA.Modelo.docenteMD;
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
    private AreaCarreraBD bdarea = new AreaCarreraBD();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<AreaCarreraMD> lista = new ArrayList<>();
    private List<PerfilMD> listaPerfiles = new ArrayList<>();
    private List<CarreraMD> listaCarrera = new ArrayList<>();
    private List<docenteMD> listaDocente = new ArrayList<>();
    private List<PersonaMD> listaPersona = new ArrayList<>();
    private PerfilBD baseDatosPerfil = new PerfilBD();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private docenteBD baseDatosDocente = new docenteBD();
    private PersonaBD baseDatosPersona = new PersonaBD();
    String vector[];

    public Con_AreaCarrera(Vis_AreaCarrera vista) {
        this.vista = vista;
        cargarComboPerfil();
        cargarComboResponsable();
        cargarComboCarrera();
        vista.setVisible(true);
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getTablaAreaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        desactivarBotones();
        lista();
        listaCarrera = baseDatosCarrera.mostrardatos();
        listaPerfiles = baseDatosPerfil.mostrardatos();
        listaDocente = baseDatosDocente.mostrardatos();
        listaPersona = baseDatosPersona.mostrardatos();
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
        listaPersona = baseDatosPersona.mostrardatos();
        listaDocente = baseDatosDocente.mostrardatos();
        vector = new String[listaDocente.size()];
        int contador = 0;
        for (PersonaMD persona : listaPersona) {
            for (docenteMD docente : listaDocente) {
                if (persona.getCedula().equals(docente.getCedula())) {
                    vista.getComboResponsable().addItem(persona.getNombres() + " " + persona.getApellidos());
                    vector[contador] = persona.getCedula();
                    contador++;
                    System.out.println(persona.getNombres() + " " + contador);
                }
            }
        }

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
        vista.getComboCarrera().setEnabled(true);
        vista.getComboPerfil().setSelectedIndex(0);
        vista.getComboResponsable().setSelectedIndex(0);
        vista.getComboCarrera().setSelectedIndex(0);

    }

    private void insertarBase() {
        int posicion = vista.getComboResponsable().getSelectedIndex() - 1;
        String cedula = vector[posicion];
        bdarea.setIdResponsable(cedula);
        String perfilCombo = (String) vista.getComboPerfil().getSelectedItem();
        int codigoPerfil = 0;
        PerfilBD basePerfil = new PerfilBD();
        codigoPerfil = basePerfil.mostrarIdPerfil(perfilCombo);
        bdarea.setIdPerfil(codigoPerfil);
        String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
        String codigoCarrera = "";
        codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
        bdarea.setIdCarrera(codigoCarrera);
        if (bdarea.insertar()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    private void modificarBase() {
        int posicion = vista.getComboResponsable().getSelectedIndex() - 1;
        String cedula = vector[posicion];
        bdarea.setIdResponsable(cedula);
        String perfilCombo = (String) vista.getComboPerfil().getSelectedItem();
        int codigoPerfil = 0;
        PerfilBD basePerfil = new PerfilBD();
        codigoPerfil = basePerfil.mostrarIdPerfil(perfilCombo);
        bdarea.setIdPerfil(codigoPerfil);
        String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
        String codigoCarrera = "";
        codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
        bdarea.setIdCarrera(codigoCarrera);
        int seleccionado = vista.getTablaAreaCarrera().getSelectedRow();
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

    private void guardar() {

        if (vista.getComboCarrera().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione la Carrera");
        } else if (vista.getComboPerfil().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione el Perfil");
        } else if (vista.getComboResponsable().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione el Responsable");
        } else {
            insertarBase();

//            String docenteCombo = (String) vista.getComboCarrera().getSelectedItem();
//            String codigoDocente = "";
//            String responsableCombo = (String) vista.getComboResponsable().getSelectedItem();
//            for (CarreraMD carrera : listaCarrera) {
//                if (carreraCombo.equals(carrera.getNombre_carrera())) {
//                    codigoCarrera = carrera.getCodigo_carrera();
//                }
//            }
//            for (PersonaMD persona : listaPersona) {
//                for (docenteMD docente : listaDocente) {
//                    if (docenteCombo.equals(persona.getNombres() + " " + persona.getApellidos())) {
//                        codigoDocente = persona.getCedula();
//                    }
//                }
//            }
        }
    }

    private void modificar() {
//        int seleccionado = vista.getTablaAreaCarrera().getSelectedRow();
//        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
//        if (resp2 == 0) {
//            if (bdarea.modificar(lista.get(seleccionado).getIdArea())) {
//                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
//                lista();
//                nuevo();
//            } else {
//                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
//            }
//        }
modificarBase();
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
        vista.getComboCarrera().setEnabled(true);
        vista.getComboPerfil().setEnabled(true);
        vista.getComboResponsable().setEnabled(true);
        lista = bdarea.mostrardatos();
        for (PerfilMD perfil : listaPerfiles) {
            if (perfil.getCodigo() == lista.get(select).getIdPerfil()) {
                vista.getComboPerfil().setSelectedItem(perfil.getNombre());
            }
        }
        for (CarreraMD carrera : listaCarrera) {
            if (carrera.getCodigo_carrera().equals(lista.get(select).getIdCarrera())) {
                vista.getComboCarrera().setSelectedItem(carrera.getNombre_carrera());
            }
        }
        for (PersonaMD persona : listaPersona) {
            if (persona.getCedula().equals(lista.get(select).getIdResponsable())) {
                vista.getComboResponsable().setSelectedItem(persona.getNombres() + " " + persona.getApellidos());
            }
        }
    }

    public void lista() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.addColumn("Id");
        modelo.addColumn("Carrera");
        modelo.addColumn("Perfil");
        modelo.addColumn("Responsable");
        Object[] fila = new Object[4];

        lista = bdarea.mostrardatos();
        listaCarrera = baseDatosCarrera.mostrardatos();
        listaPerfiles = baseDatosPerfil.mostrardatos();
        listaDocente = baseDatosDocente.mostrardatos();
        listaPersona = baseDatosPersona.mostrardatos();
        for (AreaCarreraMD user : lista) {

            fila[0] = user.getIdArea();
            //fila[1] = user.getIdCarrera();
            for (CarreraMD carrera : listaCarrera) {
                if (carrera.getCodigo_carrera().equals(user.getIdCarrera())) {
                    fila[1] = carrera.getNombre_carrera();
                }
            }
            //fila[2] = user.getIdPerfil();
            for (PerfilMD perfil : listaPerfiles) {
                if (perfil.getCodigo() == user.getIdPerfil()) {
                    fila[2] = perfil.getNombre();
                }
            }
            //fila[3] = user.getIdResponsable();
            for (PersonaMD perfil : listaPersona) {
                for (docenteMD docente : listaDocente) {
                    if (docente.getCedula().equals(user.getIdResponsable())) {
                        fila[3] = docente.getCedula();
                    }
                }
            }

            modelo.addRow(fila);
        }

        vista.getTablaAreaCarrera().setModel(modelo);

    }

}
