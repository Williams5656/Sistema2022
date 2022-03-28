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
import POA.Modelo.*;
import POA.Modelo.Responsables_ActividadMD;
import POA.Modelo.Responsables_ActividadBD;
import POA.Modelo.docenteMD;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    T_ActividadBD T_actividadbd = new T_ActividadBD();
     PeriodoacademicoBD periodobd = new PeriodoacademicoBD();
    private DefaultTableModel modelo;
    Responsables_ActividadMD resp = new Responsables_ActividadMD();
    private docenteMD docentemd = new docenteMD();
       CalendarioMD calendar = new CalendarioMD();
    public static ArrayList<Responsables_ActividadMD> ListaResp = new ArrayList<>();

    public Con_calendario(Vis_Calendar vista) {

        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_añadir().addActionListener(e -> responsable());
        vista.getBtn_guardar().addActionListener(e -> guardarResp());
         vista.getBtn_añadir().addActionListener(e->responsable());
         vista.getBtn_añadir_Tactividad().addActionListener(l -> {
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
        vista.getD_Btn_Guardar().addActionListener(e-> guardarActividad());
        vista.getD_Btn_Cancelar().addActionListener(e-> vista.getT_Actividad_D().dispose());
        
        carrera();
        tipo_actividad();
        cargarLista("");

    }

    public void carrera() {

        List<CarreraMD> listar = carrerabd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getComobo_carrera().addItem(listar.get(i).getNombre_carrera());
        }
    }
    public void tipo_actividad(){
        List<T_actividadMD> listar = T_actividadbd.mostrardatos();
         for (int i = 0; i < listar.size(); i++) {
            vista.getCombo_actividad().addItem(listar.get(i).getNombre());
        }  
    }
//    public void periodo() {
//
//        List<PeriodoacademicoMD> listar = periodobd.mostrardatos();
//        for (int i = 0; i < listar.size(); i++) {
//            vista.getComobo_carrera().addItem(listar.get(i).get());
//        }
//    }
    public void guardar() {
        SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
        String fechaini = formato6.format(vista.getFecha_inicio().getDate());
        String fechalim = formato6.format(vista.getFecha_inicio().getDate());
        calendar.setId_Actividad(Integer.parseInt(vista.getTxt_responsables().getText()));
        calendar.setId_Carrera(vista.getComobo_carrera().getSelectedItem().toString());
        calendar.setId_Periodo(Integer.parseInt(vista.getCombo_periodo().getSelectedItem().toString()));
        calendar.setId_TipoActividad(Integer.parseInt(vista.getCombo_actividad().getSelectedItem().toString()));
        calendar.setNombre_Actividad(vista.getTxt_N_actividad().getText());
        calendar.setDescripcion(vista.getTxt_descripcion().getText());
        calendar.setFecha_Inicio(fechaini);
        calendar.setFecha_Inicio(fechalim);
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
           
  private void cargarDialogo(int origen) throws SQLException {
        vista.getT_Actividad_D().setSize(460, 320);//dimensiones
        vista.getT_Actividad_D().setLocationRelativeTo(vista);//posicion
        nuevoTAct();
            vista.getT_Actividad_D().setTitle("Ingresar Actividad");

            vista.getD_txt_idTipoA().setText(String.valueOf(T_actividadbd.codigo()));
            vista.getT_Actividad_D().setVisible(true);
            vista.getD_txt_idTipoA().setEditable(false);
    }
    public void guardarActividad(){
        if (!vista.getD_txt_idTipoA().getText().equals("") && !vista.getD_txt_Nombre().getText().equals("") && !vista.getD_txt_Descripcion().getText().equals("")) {
            T_actividadbd.setId_T_actividad(Integer.parseInt(vista.getD_txt_idTipoA().getText()));
            T_actividadbd.setNombre(vista.getD_txt_Nombre().getText());
            T_actividadbd.setDescripcion(vista.getD_txt_Descripcion().getText());
                if (T_actividadbd.guardarTActividad()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    nuevoTAct();
                    vista.getCombo_actividad().removeAllItems();
                    tipo_actividad();
                    vista.getD_txt_idTipoA().setText(String.valueOf(T_actividadbd.codigo()));
                } else {
                    JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
                }
        } else {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS L0S CAMPOS");
        }


    }
    
    public void nuevoTAct(){
        vista.getD_txt_Nombre().setText("");
        vista.getD_txt_Descripcion().setText("");
    }
        
    

}
