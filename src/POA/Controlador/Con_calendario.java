/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.CalendarioBD;
import POA.Vista.Vis_Calendar;
import POA.Modelo.CarreraBD;
import POA.Modelo.CarreraMD;
import POA.Modelo.Responsables_ActividadMD;
import POA.Modelo.Responsables_ActividadBD;
import POA.Modelo.docenteMD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Myrian
 */
public class Con_calendario {
    int[] vector1;
    Responsables_ActividadBD resbd = new Responsables_ActividadBD();
    private final Vis_Calendar vista;
    CarreraBD carrerabd = new CarreraBD();
    CalendarioBD calen = new CalendarioBD();
    private DefaultTableModel modelo;
    Responsables_ActividadMD resp = new Responsables_ActividadMD();
    private docenteMD docentemd = new docenteMD();

    public static ArrayList<Responsables_ActividadMD> ListaResp = new ArrayList<>();

    public Con_calendario(Vis_Calendar vista) {

        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_añadir().addActionListener(e -> responsable());
        vista.getBtn_guardar().addActionListener(e -> guardarResp());
        carrera();
        cargarLista("");

    }

    public void carrera() {

        List<CarreraMD> listar = carrerabd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getComobo_carrera().addItem(listar.get(i).getNombre_carrera());
        }
    }

    public void guardarResp() {
        
        for (int i = 0; i < ListaResp.size(); i++) {
            String cedula = ListaResp.get(i).getCedula();
            resbd.setId_responsable(calen.codigo());
            resbd.setId_actividad(Integer.parseInt(vista.getTxt_id_A().getText()));
            resbd.setCedula(cedula);
            if (resbd.insertarresponsable()) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                cargarLista("");
            } else {
                JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
            }
        }
        vista.getTxt_id_A().setText("");
    }

    public void cargarLista(String aguja) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTabla_responsable().getModel();
        tblModel.setNumRows(0);
        List<Responsables_ActividadMD> lista = resbd.obtenerdatos(aguja);
        lista.stream().forEach(r -> {
            String[] responsable = {String.valueOf(r.getId_responsable()), String.valueOf(r.getId_actividad()), r.getCedula()};
            tblModel.addRow(responsable);
        });
    }

    public void responsable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_responsables().getModel();
        Responsables_ActividadMD l = new Responsables_ActividadMD(vista.getTxt_responsables().getText());
        ListaResp.add(l);
        modelo.setNumRows(0);
        ListaResp.stream().forEach(r -> {
            String[] tabla = {r.getCedula()};
            modelo.addRow(tabla);
        });
        vista.getTxt_responsables().setText("");
        vector1=new int[1];
    }

    public int TipoActividad() {
        int id = 0;
        String tipo_actividad = (String) vista.getCombo_tipo_actividad_repor().getSelectedItem();
        if (tipo_actividad.equalsIgnoreCase("POA")) {
            id = 01;
        } else if (tipo_actividad.equalsIgnoreCase("Titulacion")) {
            id = 02;
        } else if (tipo_actividad.equalsIgnoreCase("Calendario")) {
            id = 03;
        } else if (tipo_actividad.equalsIgnoreCase("Examen Complexión")) {
            id = 04;
        } else if (tipo_actividad.equalsIgnoreCase("Graduación")) {
            id = 05;
        } else if (tipo_actividad.equalsIgnoreCase("Todos")) {
            id = 06;
        } else if (tipo_actividad.equalsIgnoreCase("Seleccionar")) {

        }
        return id;
    }
}
