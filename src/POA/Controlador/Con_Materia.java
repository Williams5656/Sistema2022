/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.*;

import POA.Vista.Vis_Materias;
import POA.Modelo.MateriaBD;
import POA.Modelo.MateriaMD;
import POA.Modelo.CarreraBD;
import POA.Modelo.CarreraMD;
import POA.Modelo.PerfilBD;
import POA.Modelo.PerfilMD;
import POA.Modelo.AreaCarreraBD;
import POA.Modelo.AreaCarreraMD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import POA.Modelo.Validadores.Numeros;
import POA.Modelo.Validadores.Letras;
import javax.swing.JTextField;

/**
 *
 * @author A
 */
public class Con_Materia {

    public static Vis_Materias vista;
    private MateriaBD materia = new MateriaBD();
    private List<MateriaMD> lista = new ArrayList<>();
    CarreraBD bdcarrera = new CarreraBD();
    List<CarreraMD> listac = bdcarrera.mostrardatos();
    private AreaCarreraBD bdarea = new AreaCarreraBD();
    List<AreaCarreraMD> listaa = bdarea.mostrardatos();
    private PerfilBD bdperfil = new PerfilBD();
    List<PerfilMD> listap = bdperfil.mostrardatos();
    private DefaultTableModel modelo = new DefaultTableModel();

    public Con_Materia(Vis_Materias vista) {
        this.vista = vista;
        vista.setVisible(true);
        desactivarbotones();
        campocarrera();
        campoarea();
        validarcod();
        validarmateria();
        validaciones();
//        buscar();
        vista.getBtncancelar().addActionListener(e -> cancelar());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getBtnimprimir().addActionListener(e -> imprimirmateria());
        vista.getBtnnuevo().addActionListener(e -> nuevo());
        vista.getTablamateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        listam();
    }

    public void guardar() {

//        String nombre = (String) vista.getComboCarrera_mat().getSelectedItem();
//        materia.setNombre_carrera(nombre);
        String carreraCombo = (String) vista.getComboCarrera_mat().getSelectedItem();
        String codigoCarrera = "";
        codigoCarrera = bdperfil.mostrarIdCarrera(carreraCombo);
        materia.setNombre_carrera(codigoCarrera);
        String eje = (String) vista.getComboejeformacion().getSelectedItem();
        materia.setEje_formacion(eje);
        materia.setCod_materia(vista.getTxtcodmateria().getText());
        materia.setNombre_materia(vista.getTxtnombremateria().getText());
        String ciclo = (String) vista.getCombociclo().getSelectedItem();
        materia.setCiclo(ciclo);
        materia.setCreditos(vista.getTxtcreditos().getText());
        String plan = (String) vista.getComboplan().getSelectedItem();
        materia.setPlan(plan);
        String areaCombo = (String) vista.getComboareacarrera().getSelectedItem();
        String codigoArea = "";
        codigoArea = bdarea.mostrarIdArea(areaCombo);
        materia.setArea(codigoArea);
//        String areac = (String) vista.getComboareacarrera().getSelectedItem();
//        materia.setArea(areac);
//        materia.setArea(areacarrera);

        if (materia.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            listam();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }

    public void seleccionar() {

        int select = vista.getTablamateria().getSelectedRow();
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablamateria().getModel();
//        String codigo = (String) modelo.getValueAt(vista.getTablamateria().getSelectedRow(), 0);
//        System.out.println(codigo);
        List<MateriaMD> lista = materia.mostrardatos();
//        List<MateriaMD> lista = materia.obtenerdatos(codigo);
        materia.setNombre_carrera(lista.get(select).getNombre_carrera());
        materia.setEje_formacion(lista.get(select).getEje_formacion());
        materia.setCod_materia(lista.get(select).getCod_materia());
        materia.setNombre_materia(lista.get(select).getNombre_materia());
        materia.setCiclo(lista.get(select).getCiclo());
        materia.setCreditos(lista.get(select).getCreditos());
        materia.setPlan(lista.get(select).getPlan());
        materia.setArea(lista.get(select).getArea());

        for (CarreraMD carrera : listac) {
            if (carrera.getCodigo_carrera().equals(lista.get(select).getNombre_carrera())) {
                vista.getComboCarrera_mat().setSelectedItem(carrera.getNombre_carrera());
            }
        }

        vista.getComboCarrera_mat().setSelectedItem(materia.getNombre_carrera());
        vista.getComboejeformacion().setSelectedItem(materia.getEje_formacion());
        vista.getTxtcodmateria().setText(materia.getCod_materia());
        vista.getTxtnombremateria().setText(materia.getNombre_materia());
        vista.getCombociclo().setSelectedItem(materia.getCiclo());
        vista.getTxtcreditos().setText(materia.getCreditos());
        vista.getComboplan().setSelectedItem(materia.getPlan());
        vista.getComboareacarrera().setSelectedItem(materia.getArea());

    }

    public void listam() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablamateria().getModel();
        List<MateriaMD> lista = materia.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablamateria().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablamateria().setValueAt(lista.get(i).getNombre_carrera(), i, 0);
            vista.getTablamateria().setValueAt(lista.get(i).getEje_formacion(), i, 1);
            vista.getTablamateria().setValueAt(lista.get(i).getCod_materia(), i, 2);
            vista.getTablamateria().setValueAt(lista.get(i).getNombre_materia(), i, 3);
            vista.getTablamateria().setValueAt(lista.get(i).getCiclo(), i, 4);
            vista.getTablamateria().setValueAt(lista.get(i).getCreditos(), i, 5);
            vista.getTablamateria().setValueAt(lista.get(i).getPlan(), i, 6);
            vista.getTablamateria().setValueAt(lista.get(i).getArea(), i, 7);
        }
    }

    public void desactivarbotones() {

        vista.getBtnguardar().setEnabled(false);
        vista.getBtnnuevo().setEnabled(true);
        vista.getBtnimprimir().setEnabled(true);
        vista.getBtneliminar().setEnabled(false);
        vista.getBtncancelar().setEnabled(false);
        vista.getComboCarrera_mat().setEnabled(false);
        vista.getComboareacarrera().setEnabled(false);
        vista.getCombociclo().setEnabled(false);
        vista.getComboejeformacion().setEnabled(false);
        vista.getComboplan().setEnabled(false);
        vista.getTxtcodmateria().setEnabled(false);
        vista.getTxtcreditos().setEnabled(false);
        vista.getTxtnombremateria().setEnabled(false);

    }

    public void activarbotones() {

        vista.getBtnguardar().setEnabled(true);
//        vista.getBtnnuevo().setEnabled(true);
        vista.getBtnimprimir().setEnabled(true);
        vista.getBtneliminar().setEnabled(true);
        vista.getBtncancelar().setEnabled(true);
        vista.getComboCarrera_mat().setEnabled(true);
        vista.getComboareacarrera().setEnabled(true);
        vista.getCombociclo().setEnabled(true);
        vista.getComboejeformacion().setEnabled(true);
        vista.getComboplan().setEnabled(true);
        vista.getTxtcodmateria().setEnabled(true);
        vista.getTxtcreditos().setEnabled(true);
        vista.getTxtnombremateria().setEnabled(true);

    }

    public void nuevo() {

        activarbotones();
        vista.getComboCarrera_mat().setSelectedItem("");
        vista.getComboejeformacion().setSelectedItem("");
        vista.getTxtcodmateria().setText("");
        vista.getTxtnombremateria().setText("");
        vista.getCombociclo().setSelectedItem("");
        vista.getTxtcreditos().setText("");
        vista.getComboplan().setSelectedItem("");
        vista.getComboareacarrera().setSelectedItem("");
    }

    public void campocarrera() {
        vista.getComboCarrera_mat().removeAllItems();
        vista.getComboCarrera_mat().addItem("");
        for (int i = 0; i < listac.size(); i++) {
            vista.getComboCarrera_mat().addItem(listac.get(i).getNombre_carrera());
        }
    }

    public void campoarea() {
        vista.getComboareacarrera().removeAllItems();
        vista.getComboareacarrera().addItem("");
        for (int i = 0; i < listaa.size(); i++) {
            vista.getComboareacarrera().addItem(Integer.toString(listaa.get(i).getIdArea()));
        }
    }

    private void eliminar() {
        int resp1 = JOptionPane.showConfirmDialog(null, "CONFIRME SI DESEA ELIMINAR");
        if (resp1 == 0) {
            if (materia.Eliminar(vista.getTxtcodmateria().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                listam();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }
    }

    public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepMaterias.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Imprimiendo Materias");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_Materia.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void cancelar() {
        int select = JOptionPane.showConfirmDialog(null, "DESEA CANCELAR!", "", JOptionPane.YES_NO_OPTION);
        if (select == 0) {
            vista.setVisible(true);
        }
    }

    boolean validarcod() {
        String codigo = (String) vista.getTxtcodmateria().getText();
        List<MateriaMD> lista_cod = materia.obtenerdatos(codigo);
        for (int i = 0; i < lista_cod.size(); i++) {
            if (codigo == (lista_cod.get(i).getCod_materia())) {
                JOptionPane.showMessageDialog(null, "Còdigo ya existe!", "Verifique", 0);
                return false;
            }
        }
        return true;
    }

    boolean validarmateria() {
        String codigo = (String) vista.getTxtnombremateria().getText();
        List<MateriaMD> lista_cod = materia.obtenerdatos(codigo);
        for (int i = 0; i < lista_cod.size(); i++) {
            if (codigo == (lista_cod.get(i).getNombre_materia())) {
                JOptionPane.showMessageDialog(null, "Materia ya existe!", "Verifique", 0);
                return false;
            }
        }
        return true;
    }

    private void only_num(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < '0' | e.getKeyChar() > '9' | (vista.getTxtcreditos().getText().length() >= 3)) {
                    e.consume();
                }
            }
        }
        );
    }

    public void validaciones() {

        Letras.solo_letras(vista.getTxtnombremateria());
        Letras.dosespacios(vista.getTxtnombremateria());
        only_num(vista.getTxtcreditos());
//        Numeros.solo_numeros(vista.getTxtcreditos());
        Letras.numero_letras(vista.getTxtcodmateria(), 4);
        Letras.no_espacios(vista.getTxtcodmateria());
        vista.getTablamateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccionar();
                } catch (Exception ex) {
                    Logger.getLogger(Con_Materia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void imprimirmateria() {
        Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte Con Nombre de Materia",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte De Materias",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }
        if (resp.equals("Reporte Con Nombre de Materia")) {

            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepMaterias.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
                String aguja = JOptionPane.showInputDialog("Ingrese la materia");
                System.out.println("materia;;;;" + aguja);
                params.put("materia", aguja);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_Materia.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (resp.equals("Reporte Completo")) {
            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepMaterias.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                Logger.getLogger(Con_Materia.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
