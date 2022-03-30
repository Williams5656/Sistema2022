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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
        vista.getBtn_n_actividad().addActionListener(e -> Crear_actividad());
        at = new TextAutoCompleter(vista.getTxt_responsables());
        vista.getBtn_añadir_Tactividad().addActionListener(l -> {
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getD_Btn_Guardar().addActionListener(e -> guardarActividad());
        vista.getD_Btn_Cancelar().addActionListener(e -> vista.getT_Actividad_D().dispose());
        vista.getTabla_calendario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarCalendario();
            }

        });
        Cargardatos_c();
        carrera();
        cargarperiodo();
        tipo_actividad();
        cargarLista("");
        cargarListaAct(0);
        lista();
        Ihnabilitar();

    }

    public void Crear_actividad() {
        vista.getTxt_id_A().setText(String.valueOf(calen.codigo_act()));
        vista.getTxt_N_actividad().setEnabled(true);
        vista.getTxt_descripcion().setEnabled(true);
        vista.getComobo_carrera().setEnabled(true);
        vista.getCombo_periodo().setEnabled(true);
        vista.getCombo_actividad().setEnabled(true);
        vista.getBtn_añadir_Tactividad().setEnabled(true);
        vista.getFecha_inicio().setEnabled(true);
        vista.getFecha_limite().setEnabled(true);
        vista.getBtn_añadir().setEnabled(true);

    }
    public void Ihnabilitar(){
            vista.getTxt_N_actividad().setEnabled(false);
        vista.getTxt_descripcion().setEnabled(false);
        vista.getComobo_carrera().setEnabled(false);
        vista.getCombo_periodo().setEnabled(false);
        vista.getCombo_actividad().setEnabled(false);
        vista.getBtn_añadir_Tactividad().setEnabled(false);
        vista.getFecha_inicio().setEnabled(false);
        vista.getFecha_limite().setEnabled(false);
        vista.getBtn_añadir().setEnabled(false);
        vista.getBtn_evidencia().setEnabled(false);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_imprimir().setEnabled(false);
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

    public void Cargardatos_c() {
        List<PersonaMD> listar = bdpersona.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            at.addItem(listar.get(i).getNombres());
        }
    }
    public void cargarperiodo() {
        List<PeriodoacademicoMD> listap = periodobd.lista_periodos();
        for (int i = 0; i < listap.size(); i++) {
            vista.getCombo_periodo().addItem(listap.get(i).getNombre());
        }
    }

    public void guardar() {
        if (!vista.getTxt_id_A().getText().equals("") && !vista.getComobo_carrera().getSelectedItem().equals("Seleccione") && !vista.getCombo_periodo().getSelectedItem().equals("Seleccione") && !vista.getCombo_actividad().getSelectedItem().equals("Seleccione")
                && !vista.getTxt_N_actividad().getText().equals("") && !vista.getTxt_N_actividad().getText().equals("") && !vista.getTxt_descripcion().getText().equals("")) {
            Cargardatos();
            if (calendar.insertar()) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                cargarListaAct(0);
                guardarResp();
                lista();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }

    }

    public void Cargardatos() {
        List<PeriodoacademicoMD> lista = periodobd.lista_periodos();
        int idperiodo = vista.getCombo_periodo().getSelectedIndex();
        int nperiodo = lista.get(idperiodo).getIdperiodo();
        List<T_actividadMD> listaTA = T_actividadbd.mostrardatos();
        int idTA = vista.getCombo_actividad().getSelectedIndex();
        int nTA = listaTA.get(idTA).getId_T_actividad();
        List<CarreraMD> listaCA = carrerabd.mostrardatos();
        int idCA = vista.getComobo_carrera().getSelectedIndex();
        String nCA = listaCA.get(idCA).getCodigo_carrera();
        SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
        String fechaini = formato6.format(vista.getFecha_inicio().getDate());
        String fechalim = formato6.format(vista.getFecha_limite().getDate());
        calendar.setId_Actividad(Integer.parseInt(vista.getTxt_id_A().getText()));
        calendar.setId_Carrera(nCA);
        calendar.setId_Periodo(nperiodo);
        calendar.setid_TipoActividad(nTA);
        calendar.setNombre_Actividad(vista.getTxt_N_actividad().getText());
        calendar.setDescripcion(vista.getTxt_descripcion().getText());
        calendar.setFecha_Inicio(fechaini);
        calendar.setFecha_Limite(fechalim);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_calendario().getModel();
        List<CalendarioMD> listacale = calen.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_calendario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < listacale.size(); i++) {
            modelo.addRow(new Object[columnas]);
            String idcarr = listacale.get(i).getId_Carrera();
            List<CarreraMD> listaCA = carrerabd.obtenerdatos(idcarr);
            int idtipo = listacale.get(i).getid_TipoActividad();
            List<T_actividadMD> listaTA = T_actividadbd.obtenerDatos(idtipo);
            int idp = listacale.get(i).getId_Periodo();
            List<PeriodoacademicoMD> listap = periodobd.periodo_individual(idp);
            periodobd.periodo_individual(idp);
            vista.getTabla_calendario().setValueAt(listacale.get(i).getId_Actividad(), i, 0);
            vista.getTabla_calendario().setValueAt(listaCA.get(0).getNombre_carrera(), i, 1);
            vista.getTabla_calendario().setValueAt(listap.get(0).getNombre(), i, 2);
            vista.getTabla_calendario().setValueAt(listaTA.get(0).getNombre(), i, 3);
            vista.getTabla_calendario().setValueAt(listacale.get(i).getNombre_Actividad(), i, 4);
            vista.getTabla_calendario().setValueAt(listacale.get(i).getDescripcion(), i, 5);
            vista.getTabla_calendario().setValueAt(listacale.get(i).getFecha_Inicio(), i, 6);
            vista.getTabla_calendario().setValueAt(listacale.get(i).getFecha_Limite(), i, 7);
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

    public void cargarListaAct(int aguja) {
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
    public void seleccionarCalendario(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_calendario().getModel();
         int idactividad = (int) modelo.getValueAt(vista.getTabla_calendario().getSelectedRow(), 0);
         List<CalendarioMD> listac = calendar.obtenerDatos(idactividad);
         calendar.setId_Actividad(listac.get(0).getId_Actividad());
         calendar.setId_Carrera(listac.get(0).getId_Carrera());
         calendar.setid_TipoActividad(listac.get(0).getid_TipoActividad());
         calendar.setNombre_Actividad(listac.get(0).getNombre_Actividad());
         calendar.setDescripcion(listac.get(0).getDescripcion());
         calendar.setFecha_Inicio(listac.get(0).getFecha_Inicio());
         calendar.setFecha_Limite(listac.get(0).getFecha_Limite());
         
         
         vista.getTxt_id_A().setText(calendar.getId_Actividad()+"");
         List<CarreraMD>listacarr = carrerabd.obtenerdatos(calendar.getId_Carrera());
         vista.getComobo_carrera().setSelectedItem(listacarr.get(0).getNombre_carrera());
         int idperiodo = listac.get(0).getId_Periodo();
         List<PeriodoacademicoMD>listaperiodo = periodobd.periodo_individual(idperiodo);
         vista.getCombo_periodo().setSelectedItem(listaperiodo.get(0).getNombre());
         int idTA = listac.get(0).getid_TipoActividad();
         List<T_actividadMD> listaTA = T_actividadbd.obtenerDatos(idTA);
         vista.getCombo_actividad().setSelectedItem(listaTA.get(0).getNombre());
         vista.getTxt_N_actividad().setText(calendar.getNombre_Actividad());
         vista.getTxt_descripcion().setText(calendar.getDescripcion());
          try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = formato.parse(calendar.getFecha_Inicio());
            vista.getFecha_inicio().setDate(d1);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }
           try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d2 = formato.parse(calendar.getFecha_Limite());
            vista.getFecha_limite().setDate(d2);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
