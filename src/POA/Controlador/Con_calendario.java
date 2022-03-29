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
import com.mxrck.autocompleter.TextAutoCompleter;
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
    private PersonaBD bdpersona = new PersonaBD();
    private TextAutoCompleter at;
    T_ActividadBD T_actividadbd = new T_ActividadBD();
    PeriodoacademicoBD periodobd = new PeriodoacademicoBD();
    private DefaultTableModel modelo;
    Responsables_ActividadMD resp = new Responsables_ActividadMD();
    private docenteMD docentemd = new docenteMD();
    CalendarioBD calendar = new CalendarioBD();
    public static ArrayList<Responsables_ActividadMD> ListaResp = new ArrayList<>();

    public Con_calendario(Vis_Calendar vista) {

        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_añadir().addActionListener(e -> responsable());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getTxt_id_A().setEnabled(false);
        vista.getBtn_n_actividad().addActionListener(e->C_actividad());
        at= new TextAutoCompleter(vista.getTxt_responsables());
        vista.getBtn_añadir_Tactividad().addActionListener(l -> {
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        vista.getD_Btn_Guardar().addActionListener(e -> guardarActividad());
        vista.getD_Btn_Cancelar().addActionListener(e -> vista.getT_Actividad_D().dispose());
        Cargardatos_c();
        carrera();
        tipo_actividad();
        cargarLista("");
        cargarListaAct("");
        cargarperiodo();

    }
        public void C_actividad(){
            vista.getTxt_id_A().setText(String.valueOf(calen.codigo_act()));
        
    }
    public void carrera() {

        List<CarreraMD> listar = carrerabd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getComobo_carrera().addItem(listar.get(i).getNombre_carrera());
        }
    }

    public void tipo_actividad() {
        List<T_actividadMD> listar = T_actividadbd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getCombo_actividad().addItem(listar.get(i).getNombre());
        }
    }
          public void Cargardatos_c(){
            List<PersonaMD> listar = bdpersona.mostrardatos();
            for (int i = 0; i < listar.size(); i++) {
                at.addItem(listar.get(i).getNombres());
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
        if (!vista.getTxt_id_A().getText().equals("") && !vista.getComobo_carrera().getSelectedItem().equals("Seleccione") && !vista.getCombo_periodo().getSelectedItem().equals("Seleccione") && !vista.getCombo_actividad().getSelectedItem().equals("Seleccione")
                && !vista.getTxt_N_actividad().getText().equals("") && !vista.getTxt_N_actividad().getText().equals("") && !vista.getTxt_descripcion().getText().equals("")) {
            
            List<PeriodoacademicoMD> lista =periodobd.mostrardatos();
            int idrol = vista.getCombo_periodo().getSelectedIndex();
            System.out.println("Combo" + idrol);
            int nrol = lista.get(idrol).getIdperiodo();
            SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaini = formato6.format(vista.getFecha_inicio().getDate());
            String fechalim = formato6.format(vista.getFecha_inicio().getDate());
            calendar.setId_Actividad(Integer.parseInt(vista.getTxt_id_A().getText()));
            calendar.setId_Carrera(vista.getComobo_carrera().getSelectedItem().toString());
            calendar.setId_Periodo(nrol);
            calendar.setId_TipoActividad(Integer.parseInt(vista.getCombo_actividad().getSelectedItem().toString()));
            calendar.setNombre_Actividad(vista.getTxt_N_actividad().getText());
            calendar.setDescripcion(vista.getTxt_descripcion().getText());
            
            calendar.setFecha_Inicio(fechaini);
            calendar.setFecha_Inicio(fechalim);
            if (calendar.insertar()) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                cargarListaAct("");
                guardarResp();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
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
                JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR RESPONSABLE");
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

    public void cargarListaAct(String aguja) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTabla_calendario().getModel();
        tblModel.setNumRows(0);
        List<CalendarioMD> lista = calendar.obtenerDatos(aguja);
        lista.stream().forEach(r -> {
            String[] calendario = {String.valueOf(r.getId_Actividad()), String.valueOf(r.getId_Carrera()), String.valueOf(r.getId_Periodo()), String.valueOf(r.getid_TipoActividad()), r.getNombre_Actividad(),
                r.getDescripcion(), r.getFecha_Inicio(), r.getFecha_Limite()
            };
            tblModel.addRow(calendario);
        });
    }
    
    public void cargarperiodo(){
        List<String> listap=new ArrayList();
        listap=calen.obtenerPeriodo();
        for (int i = 0; i < listap.size(); i++) {
            vista.getCombo_periodo().addItem(listap.get(i));
        }
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

    public void guardarActividad() {
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

    public void limpiar() {
        vista.getComobo_carrera().setSelectedIndex(0);
        vista.getCombo_periodo().setSelectedIndex(0);
        vista.getCombo_actividad().setSelectedIndex(0);
        vista.getTxt_N_actividad().setText("");
        vista.getTxt_descripcion().setText("");
        vista.getFecha_inicio().setDate(null);
        vista.getFecha_limite().setDate(null);
    }

    public void nuevoTAct() {
        vista.getD_txt_Nombre().setText("");
        vista.getD_txt_Descripcion().setText("");
    }

}
