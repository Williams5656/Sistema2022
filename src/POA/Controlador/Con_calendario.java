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
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Myrian
 */
public class Con_calendario {

    int id = -1;
    int[] vector1;
    String ruta;
    int fila = -1, n;
    Responsables_ActividadBD resbd = new Responsables_ActividadBD();
    private final Vis_Calendar vista;
    CarreraBD carrerabd = new CarreraBD();
    CalendarioBD calen = new CalendarioBD();
    PersonaBD bdpersona = new PersonaBD();
    docenteBD baseDatosDocente = new docenteBD();
    List<docenteMD> listaDocente = new ArrayList<>();
    List<PersonaMD> listaPersona = new ArrayList<>();
    T_ActividadBD T_actividadbd = new T_ActividadBD();
    PeriodoacademicoBD periodobd = new PeriodoacademicoBD();
    DefaultTableModel modelo;
    Responsables_ActividadMD resp = new Responsables_ActividadMD();
    docenteMD docentemd = new docenteMD();
    CalendarioBD calendar = new CalendarioBD();
    List<CalendarioMD> listacalendario = new ArrayList<>();
    String vector[];
    TextAutoCompleter at, tp;
    String[] tabla;
    public static ArrayList<Responsables_ActividadMD> ListaResp = new ArrayList<>();

    public Con_calendario(Vis_Calendar vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getTxt_id_A().setEnabled(false);
        vista.getBtn_añadir().addActionListener(e -> añadir_responsables());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_n_actividad().addActionListener(e -> Crear_actividad());
        vista.getBtn_aceptar().addActionListener(e -> Imp_T_Actividad());
        vista.getBtn_responsables().addActionListener(e -> imprimir_resposables());
        vista.getD_Btn_Guardar().addActionListener(e -> guardarActividad());
        vista.getBtn_modificar().addActionListener(e -> Modificar());
        vista.getBtn_prueba().addActionListener(e -> imprimirpersona());
        vista.getBtn_cancelar().addActionListener(e -> vista.getT_Actividad_D().dispose());
        vista.getD_Btn_Cancelar().addActionListener(e -> vista.getT_Actividad_D().dispose());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtn_evidencia().addActionListener(e -> SeleccionarPdf());
        at = new TextAutoCompleter(vista.getTxt_responsables());
        vista.getTabla_calendario().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarCalendario();
                cargar_resp();
                tablaMouseClicked(evt);
            }

        });
        vista.getBtn_añadir_Tactividad().addActionListener(l -> {
            try {
                cargarDialogo(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        CargarDatos_Cale();
    }

    public void CargarDatos_Cale() {
        Cargardatos_c();
        carrera();
        cargarperiodo();
        tipo_actividad();
        cargarLista("");
        cargarListaAct(0);
        listaresponsable();
        Ihnabilitar();
        fecha();
        //lista();
        VisualizarTabla(vista.getTabla_calendario());
    }

    public void imprimir_resposables() {
        Conect con = new Conect();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/R_Responsables.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Imprimiendo Responsables");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
        int column = vista.getTabla_calendario().getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / vista.getTabla_calendario().getRowHeight();
        if (row < vista.getTabla_calendario().getRowCount() && row >= 0 && column < vista.getTabla_calendario().getColumnCount() && column >= 0) {
            fila = vista.getTabla_calendario().getSelectedRow();
            id = (int) vista.getTabla_calendario().getValueAt(row, 0);
            Object value = vista.getTabla_calendario().getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    CalendarioBD pd = new CalendarioBD();
                    pd.ejecutar_archivoPDF(id);
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (Exception ex) {
                    }
                }
            } else {
                String name = "" + vista.getTabla_calendario().getValueAt(row, 1);
            }
        }
    }

    public void imprimirpersona() {

        Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte por Actividad",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }
        if (resp.equals("Reporte por Actividad")) {
            try {
                cargarImprimir(1);
            } catch (SQLException ex) {
                Logger.getLogger(Con_rol.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (resp.equals("Reporte Completo")) {

            try {
                JOptionPane.showMessageDialog(null, "Imprimiendo Actividades");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/R_Actividad.jasper"));

                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void Imp_T_Actividad() {
        Conect con = new Conect();
        String aguja = "";
        try {
            // JOptionPane.showMessageDialog(null, "Imprimiendo Persona");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/R_Actividad_1.jasper"));
            Map<String, Object> params = new HashMap<String, Object>();

            aguja = (String) vista.getCombo_tipo_actividad_repor().getSelectedItem();
            System.out.println("Actividad;;;;" + aguja);
            params.put("Actividad", aguja);
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void Crear_actividad() {
        vista.getTxt_id_A().setText(String.valueOf(calen.codigo_act()));
        vista.getTxt_N_actividad().setEnabled(true);
        vista.getTxt_responsables().setEditable(true);
        vista.getComobo_carrera().setEnabled(true);
        vista.getCombo_periodo().setEnabled(true);
        vista.getCombo_actividad().setEnabled(true);
        vista.getBtn_añadir_Tactividad().setEnabled(true);

        vista.getBtn_añadir().setEnabled(true);
        vista.getTxt_descripcion().setEnabled(true);
        vista.getFecha_inicio().setEnabled(true);
        vista.getFecha_limite().setEnabled(true);
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_evidencia().setEnabled(false);
        limpiar();
        DefaultTableModel modelo2;
        modelo2 = (DefaultTableModel) vista.getTabla_responsables().getModel();
        modelo2.setNumRows(0);
        ListaResp.clear();
    }

    public void Ihnabilitar() {
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
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
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
            //tp.additem(listar.get(i).getNombre());
        }
    }

    public void Cargardatos_c() {
        listaPersona = resbd.nombres_docente();
        for (int i = 0; i < listaPersona.size(); i++) {
            at.addItem(listaPersona.get(i).getNombres());

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
            int nombre = calen.validar_Nombre_act(vista.getTxt_N_actividad().getText());
            if (nombre != 0) {
                JOptionPane.showMessageDialog(null, "Este nombre ya esta siendo utlizado", "", 0);
            } else {
                if (calendar.insertar()) {
                    cargarListaAct(0);
                    guadar_responsable_base();
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");                   
                    DefaultTableModel modelo2;
                    modelo2 = (DefaultTableModel) vista.getTabla_responsables().getModel();
                    modelo2.setNumRows(0);
                    //lista();
                    VisualizarTabla(vista.getTabla_calendario());
                    Ihnabilitar();
                    listaresponsable();
                    vista.getTxt_responsables().setText("");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRROR AL GUARDAR");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }

    }

    public void Modificar() {
        eliminarresp();
        Cargardatos();
        File rutafile = null;
        if (ruta != null) {
            rutafile = new File(ruta);
        }
        int res = JOptionPane.showConfirmDialog(null, "Confirme");
        if (res == 0) {
            if (calendar.modificar(rutafile)) {
                guadar_responsable_base();
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                VisualizarTabla(vista.getTabla_calendario());
                borrarTablaResp();
                listaresponsable();
                limpiar();
                vista.getBtn_modificar().setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    public void borrarTablaResp() {
        DefaultTableModel modelo2;
        modelo2 = (DefaultTableModel) vista.getTabla_responsables().getModel();
        modelo2.setNumRows(0);
    }

    private void eliminarresp() {
        resbd.eliminar(Integer.parseInt(vista.getTxt_id_A().getText()));
    }

    public void Cargardatos() {
        Date fecha = null, fecha1 = null;
       // SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // Tranformar la fecha a String
       
        List<PeriodoacademicoMD> lista = periodobd.lista_periodos();
        int idperiodo = vista.getCombo_periodo().getSelectedIndex();
        int nperiodo = lista.get(idperiodo).getIdperiodo();
        List<T_actividadMD> listaTA = T_actividadbd.mostrardatos();
        int idTA = vista.getCombo_actividad().getSelectedIndex();
        int nTA = listaTA.get(idTA).getId_T_actividad();
        List<CarreraMD> listaCA = carrerabd.mostrardatos();
        int idCA = vista.getComobo_carrera().getSelectedIndex();
        String nCA = listaCA.get(idCA).getCodigo_carrera();
        SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fechalim = formato6.format(vista.getFecha_limite().getDate());
        //String fechaini = formato6.format(vista.getFecha_limite().getDate());
        calendar.setId_Actividad(Integer.parseInt(vista.getTxt_id_A().getText()));
        calendar.setId_Carrera(nCA);
        calendar.setId_Periodo(nperiodo);
        calendar.setid_TipoActividad(nTA);
        calendar.setNombre_Actividad(vista.getTxt_N_actividad().getText());
        calendar.setDescripcion(vista.getTxt_descripcion().getText());
        calendar.setFecha_Inicio(fecha());
        calendar.setFecha_Limite(fechalim);
    }

    public String fecha() {
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha1 = sdf.format(fecha);
        return fecha1;
    }

    public void listaresponsable() {

        DefaultTableModel modelo1;

        modelo1 = (DefaultTableModel) vista.getTabla_responsable().getModel();
        List<Responsables_ActividadMD> listar = resbd.datos_responsables();
        for (int j = vista.getTabla_responsable().getRowCount() - 1; j >= 0; j--) {
            modelo1.removeRow(j);
        }

        int columnasp = modelo1.getColumnCount();
        for (int i = 0; i < listar.size(); i++) {
            int idtipo = listar.get(i).getId_actividad();
            List<CalendarioMD> listaca = calen.obtenerDatos(idtipo);

            modelo1.addRow(new Object[columnasp]);
            vista.getTabla_responsable().setValueAt(listaca.get(0).getNombre_Actividad(), i, 0);
            vista.getTabla_responsable().setValueAt(listar.get(i).getCedula(), i, 1);
        }
    }

    public void VisualizarTabla(JTable tabla) {
        //System.out.println("para imprimir la tabla");
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Num actividad");
        dt.addColumn("Carrera");
        dt.addColumn("Periodo");
        dt.addColumn("Tipo Actividad");
        dt.addColumn("Nombre Actividad");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha inicial");
        dt.addColumn("Fecha limite");
        dt.addColumn("Evidencia");
        ImageIcon icono = null;
        if (get_Image("/POA/Vista/img/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/POA/Vista/img/32pdf.png"));
            System.out.println("imagen");
        }
        calen = new CalendarioBD();
        NomCalendarioMD vo = new NomCalendarioMD();
        List<NomCalendarioMD> list = calen.mostrardatos();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("listaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + list.size());
            Object filas[] = new Object[9];
            vo = list.get(i);
            filas[0] = vo.getId_actividad();
            filas[1] = vo.getId_carrera();
            filas[2] = vo.getId_periodo();
            filas[3] = vo.getId_tipoactividad();
            filas[4] = vo.getNombre_actividad();
            filas[5] = vo.getDescripcion();
            filas[6] = vo.getFecha_ini();
            filas[7] = vo.getFecha_lim();
            if (vo.getArchivo() != null) {
                filas[8] = new JButton(icono);
            } else {
                filas[8] = new JButton("Vacio");
            }
            dt.addRow(filas);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(32);
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    public void cargarLista(String aguja) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTabla_responsable().getModel();
        tblModel.setNumRows(0);
        List<Responsables_ActividadMD> lista = resbd.obtenerdatos(aguja);
        lista.stream().forEach(r -> {
            String[] responsable = {String.valueOf(r.getId_actividad()), r.getCedula()};
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

    public void guadar_responsable_base() {
        listaPersona = resbd.nombres_docente();
        resbd.setId_actividad(Integer.parseInt(vista.getTxt_id_A().getText()));
        for (int i = 0; i < listaPersona.size(); i++) {
            for (int j = 0; j < vista.getTabla_responsables().getRowCount(); j++) {
                if (listaPersona.get(i).getNombres().equals(vista.getTabla_responsables().getValueAt(j, 0).toString())) {
                    resbd.setId_responsable(calen.codigo());
                    resbd.setCedula(listaPersona.get(i).getCedula());
                    resbd.insertarresponsable();
                    cargarLista("");
                }
            }
        }
        ListaResp.clear();
    }

    public void añadir_responsables() {
        int a = 0, b = 0;
        listaPersona = resbd.nombres_docente();
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getNombres().equals(vista.getTxt_responsables().getText())) {
                if (!vista.getTxt_responsables().getText().equals("")) {
                    DefaultTableModel modelo;
                    modelo = (DefaultTableModel) vista.getTabla_responsables().getModel();
                    String [] inf=new String [1];
                    inf[0]=vista.getTxt_responsables().getText();
                    modelo.addRow(inf);
                    vista.getTxt_responsables().setText("");
                    b = 1;
                }
                a = 1;
            }

        }
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "El nombre es incorrecto");
        } else if (b == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
        }

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

    private void cargarImprimir(int origen) throws SQLException {
        vista.getImprimir_D().setSize(560, 275);//dimensiones
        vista.getImprimir_D().setLocationRelativeTo(vista);//posicion
        vista.getCombo_tipo_actividad_repor().removeAllItems();
        D_tipo_actividad();
        vista.getImprimir_D().setTitle("Reporte Tipo Actividad");
        vista.getImprimir_D().setVisible(true);

    }

    public void D_tipo_actividad() {
        List<T_actividadMD> listar = T_actividadbd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getCombo_tipo_actividad_repor().addItem(listar.get(i).getNombre());
        }
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

    public void cargar_personas() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_responsables().getModel();
        modelo.setNumRows(0);
        listaPersona.stream().forEach(r -> {
            tabla = new String[]{r.getNombres()};
            modelo.addRow(tabla);
        });
    }

    public int id_actividad() {
        int fila = vista.getTabla_calendario().getSelectedRow();
        int cod = Integer.parseInt(vista.getTabla_calendario().getValueAt(fila, 0).toString());
        return cod;
    }

    public void cargar_resp() {
        int id = id_actividad();
        System.out.println("id" + id);
        listaPersona = resbd.nombres_responsables(id);
        System.out.println("per" + listaPersona.size());
        cargar_personas();
    }

    public void seleccionarCalendario() {
        DefaultTableModel modelo;
        Crear_actividad();
        //vista.getTxt_responsables().setEditable(false);
       // vista.getBtn_añadir().setEnabled(false);
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_evidencia().setEnabled(true);
        vista.getBtn_añadir_Tactividad().setEnabled(false);
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

        vista.getTxt_id_A().setText(calendar.getId_Actividad() + "");
        List<CarreraMD> listacarr = carrerabd.obtenerdatos(calendar.getId_Carrera());
        vista.getComobo_carrera().setSelectedItem(listacarr.get(0).getNombre_carrera());
        int idperiodo = listac.get(0).getId_Periodo();
        List<PeriodoacademicoMD> listaperiodo = periodobd.periodo_individual(idperiodo);
        vista.getCombo_periodo().setSelectedItem(listaperiodo.get(0).getNombre());
        int idTA = listac.get(0).getid_TipoActividad();
        List<T_actividadMD> listaTA = T_actividadbd.obtenerDatos(idTA);
        vista.getCombo_actividad().setSelectedItem(listaTA.get(0).getNombre());
        vista.getTxt_N_actividad().setText(calendar.getNombre_Actividad());
        vista.getTxt_descripcion().setText(calendar.getDescripcion());
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date d1 = formato.parse(calendar.getFecha_Inicio());
            vista.getFecha_inicio().setDate(d1);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date d2 = formato.parse(calendar.getFecha_Limite());
            vista.getFecha_limite().setDate(d2);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        DefaultTableModel modelo2;
        modelo2 = (DefaultTableModel) vista.getTabla_responsables().getModel();
        int fila = vista.getTabla_responsables().getSelectedRow();
        if (fila >= 0) {
            modelo2.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar Fila");
        }
    }

    public void SeleccionarPdf() {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        jfc.setFileFilter(fi);
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ruta = jfc.getSelectedFile().getAbsolutePath();
            vista.getBtn_evidencia().setText("" + jfc.getSelectedFile().getName());
        }
    }

}
