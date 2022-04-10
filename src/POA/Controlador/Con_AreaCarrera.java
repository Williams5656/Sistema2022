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
import POA.Modelo.Conect;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
    PerfilBD basePerfil = new PerfilBD();
    int select = 0;

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
        vista.getBtn_imprimir().addActionListener(e -> imprimirArea());
        vista.getComboCarrera().addActionListener(e -> accion_combobox());
        vista.getTablaAreaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        desactivarBotones();
        listaCarrera = baseDatosCarrera.mostrardatos();
        listaPerfiles = baseDatosPerfil.mostrardatos();
        listaDocente = baseDatosDocente.mostrardatos();
        listaPersona = baseDatosPersona.mostrardatos();
    }

    public void accion_combobox() {
        lista();
    }

    public void imprimirArea() {
        Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte por Carrera",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "REPORTE DE AREAS DE CARRERA",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " Seleccione uno de los campos");

        }
        if (resp.equals("Reporte por Carrera")) {
            String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
            String codigoCarrera = "";
            codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
            try {
                // JOptionPane.showMessageDialog(null, "Imprimiendo Persona");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteAreaCarrera1.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
                //String aguja = JOptionPane.showInputDialog("Ingrese una Cedula de persona");
                String aguja = codigoCarrera;
                //String aguja = vista.getTxtBuscar().getText();
                //System.out.println("cedula;;;;" + aguja);
                params.put("carrera", aguja);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (resp.equals("Reporte Completo")) {
            try {

                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteAreaCarrera.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteAreaCarrera.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void desactivarBotones() {
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getComboPerfil().setEnabled(false);
        vista.getComboResponsable().setEnabled(false);
        vista.getComboCarrera().setEnabled(false);
        vista.getBtn_nuevo().setEnabled(true);
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
                if (persona.getCedula().equals(docente.getCedula()) && docente.getEstado().equals("ACTIVO")) {
                    vista.getComboResponsable().addItem(persona.getNombres() + " " + persona.getApellidos());
                    vector[contador] = persona.getCedula();
                    contador++;
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
        //vista.getComboCarrera().setSelectedIndex(0);

    }

    private void insertarBase() {
        int posicion = vista.getComboResponsable().getSelectedIndex() - 1;
        String cedula = vector[posicion];
        bdarea.setIdResponsable(cedula);
        String perfilCombo = (String) vista.getComboPerfil().getSelectedItem();
        int codigoPerfil = 0;
        codigoPerfil = basePerfil.mostrarIdPerfil(perfilCombo);
        bdarea.setIdPerfil(codigoPerfil);
        String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
        String codigoCarrera = "";
        codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
        bdarea.setIdCarrera(codigoCarrera);
        int comparacion = 0;
        int com = 0;
        comparacion = basePerfil.verificarPerfil(codigoCarrera, codigoPerfil);
        com = basePerfil.verificarResponsable(codigoCarrera, cedula);
        
        if (comparacion != 0) {
            JOptionPane.showMessageDialog(null, "El perfil ya existe");
            vista.getComboPerfil().setSelectedIndex(0);
        }
        if (com != 0) {
            JOptionPane.showMessageDialog(null, "Ya existe este responsable");
            vista.getComboResponsable().setSelectedIndex(0);
        }
        if (comparacion == 0 && com == 0) {
            if (bdarea.insertar()) {
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                lista();
                nuevo();
                desactivarBotones();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
        }

    }

    private void modificarBase() {
        int id = 0;
        id = Integer.parseInt(vista.getTablaAreaCarrera().getValueAt(select, 0).toString());
        int posicion = vista.getComboResponsable().getSelectedIndex() - 1;
        String cedula = vector[posicion];
        bdarea.setIdResponsable(cedula);
        String perfilCombo = (String) vista.getComboPerfil().getSelectedItem();
        int codigoPerfil = 0;
        codigoPerfil = basePerfil.mostrarIdPerfil(perfilCombo);
        bdarea.setIdPerfil(codigoPerfil);
        String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
        String codigoCarrera = "";
        codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
        bdarea.setIdCarrera(codigoCarrera);
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
            if (resp2 == 0) {
                if (bdarea.modificar(id)) {
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
            
        }
    }

    private void modificar() {
        modificarBase();
    }

    private void eliminar() {
        int id = 0;
        id = Integer.parseInt(vista.getTablaAreaCarrera().getValueAt(select, 0).toString());
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE ELIMINAR");
        if (resp2 == 0) {
            if (bdarea.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }

    }

    private void seleccionar() {
        int id = 0;
        String c = "";
        String p = "";
        String r = "";
        select = vista.getTablaAreaCarrera().getSelectedRow();
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getComboCarrera().setEnabled(true);
        vista.getComboPerfil().setEnabled(true);
        vista.getComboResponsable().setEnabled(true);

        id = Integer.parseInt(vista.getTablaAreaCarrera().getValueAt(select, 0).toString());
        c = vista.getTablaAreaCarrera().getValueAt(select, 1).toString();
        p = vista.getTablaAreaCarrera().getValueAt(select, 2).toString();
        r = vista.getTablaAreaCarrera().getValueAt(select, 3).toString();
        //vista.getComboCarrera().setSelectedItem(c);
        vista.getComboPerfil().setSelectedItem(p);
        vista.getComboResponsable().setSelectedItem(basePerfil.mostrarIdDocente(r));

//        for (CarreraMD carrera : listaCarrera) {
//            if (carrera.getCodigo_carrera().equals(lista.get(id).getIdCarrera())) {
//                vista.getComboCarrera().setSelectedItem(carrera.getNombre_carrera());
//                System.out.println(lista.get(select).getIdCarrera() + " hola");
//            }
//        }
//        for (PerfilMD perfil : listaPerfiles) {
//            if (perfil.getCodigo() == lista.get(select).getIdPerfil()) {
//                vista.getComboPerfil().setSelectedItem(perfil.getNombre());
//            }
//        }
//        for (PersonaMD persona : listaPersona) {
//            if (persona.getCedula().equals(lista.get(select).getIdResponsable())) {
//                vista.getComboResponsable().setSelectedItem(persona.getNombres() + " " + persona.getApellidos());
//            }
//        }
    }

    public void lista() {
        try {
            String carreraCombo = (String) vista.getComboCarrera().getSelectedItem();
            String codigoCarrera = "";
            codigoCarrera = basePerfil.mostrarIdCarrera(carreraCombo);
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
                if (user.getIdCarrera().equals(codigoCarrera)) {
                    fila[0] = user.getIdArea();
                    for (CarreraMD carrera : listaCarrera) {
                        if (carrera.getCodigo_carrera().equals(user.getIdCarrera())) {
                            fila[1] = carrera.getNombre_carrera();
                        }
                    }
                    for (PerfilMD perfil : listaPerfiles) {
                        if (perfil.getCodigo() == user.getIdPerfil()) {
                            fila[2] = perfil.getNombre();
                        }
                    }
                    for (PersonaMD perfil : listaPersona) {
                        for (docenteMD docente : listaDocente) {
                            if (docente.getCedula().equals(user.getIdResponsable())) {
                                fila[3] = docente.getCedula();
                            }
                        }
                    }

                    modelo.addRow(fila);
                }

            }

            vista.getTablaAreaCarrera().setModel(modelo);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

}
