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
import java.util.List;
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
    //PerfilBD bdperfil = new PerfilBD();
    List<AreaCarreraMD> listaa = bdarea.mostrardatos();
    private DefaultTableModel modelo = new DefaultTableModel();

    public Con_Materia(Vis_Materias vista) {
        this.vista = vista;
        vista.setVisible(true);
        campocarrera();
        campoarea();
//        buscar();
        vista.getBtncancelar().addActionListener(e -> cancelar());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getBtnimprimir().addActionListener(e -> imprimir());
        vista.getTablamateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        listam();
    }

    public void guardar() {

//        String idCarrera = "";
//        String nombre = (String) vista.getComboCarrera_mat().getSelectedItem();
//        for (int i = 0; i < listac.size(); i++) {
//            if (nombre.equals(listac.get(i).getNombre_carrera())) {
//                idCarrera = listac.get(i).getCodigo_carrera();
//            }
//        }
//        materia.setNombre_carrera(nombre);
        String eje = (String) vista.getComboejeformacion().getSelectedItem();
        materia.setEje_formacion(eje);
        materia.setCod_materia(vista.getTxtcodmateria().getText());
        materia.setNombre_materia(vista.getTxtnombremateria().getText());
        String ciclo = (String) vista.getCombociclo().getSelectedItem();
        materia.setCiclo(ciclo);
        materia.setCreditos(vista.getTxtcreditos().getText());
        String plan = (String) vista.getComboplan().getSelectedItem();
        materia.setPlan(plan);
//        String areac = (String) vista.getComboareacarrera().getSelectedItem();
//        materia.setArea(areac);
//        materia.setArea(areacarrera);
//        bdcarrera.setCodigo_carrera(idCarrera);
//        bdarea.setIdArea(campoarea());
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
////        System.out.println(codigo);
        List<MateriaMD> lista = materia.mostrardatos();
        materia.setNombre_carrera(lista.get(select).getNombre_carrera());
        materia.setEje_formacion(lista.get(select).getEje_formacion());
        materia.setCod_materia(lista.get(select).getCod_materia());
        materia.setNombre_materia(lista.get(select).getNombre_materia());
        materia.setCiclo(lista.get(select).getCiclo());
        materia.setCreditos(lista.get(select).getCreditos());
        materia.setPlan(lista.get(select).getPlan());
        materia.setArea(lista.get(select).getArea());

        vista.getComboCarrera_mat().setSelectedItem(materia.getNombre_carrera());
        vista.getComboejeformacion().setSelectedItem(materia.getEje_formacion());
        vista.getTxtcodmateria().setText(materia.getCod_materia());
        vista.getTxtnombremateria().setText(materia.getNombre_materia());
        vista.getCombociclo().setSelectedItem(materia.getCiclo());
        vista.getTxtcreditos().setText(materia.getCreditos());
        vista.getComboplan().setSelectedItem(materia.getPlan());
        vista.getComboareacarrera().setSelectedItem(materia.getArea());

//        String nombre = "[" + materia.getNombre_carrera()+ "]" + bdcarrera.getCodigo_carrera();
//        vista.getLblNombre().setText(nombre);
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

    public void nuevo() {

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
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < listaa.size(); i++) {
                if (Integer.toString(listaa.get(i).getIdArea()) == lista.get(j).getArea()) {
                    vista.getComboareacarrera().addItem(Integer.toString(listaa.get(i).getIdArea()));
                }
            }
        }
//        for (int i = 0; i < listaa.size(); i++) {
//            vista.getComboCarrera_mat().addItem(listaa.get(i).getNombre_carrera());
//        }
//        String id_area;
//        for (AreaCarreraMD areac : listaa){
//            if (((vista.getComboareacarrera()).getSelectedItem()).equals(areac.getIdArea())){
//                    id_area = Integer.toString(areac.getIdArea());
//                }
//            }
    }
    
//    public void buscar() {
//        listac = bdcarrera.mostrardatos();
//        vista.getComboCarrera_mat().addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                for (CarreraMD carre : listac) {
//                    if (carre.getNombre_carrera().equals(vista.getComboCarrera_mat().getSelectedItem())) {
//                        vista.getLblNombre().setText(carre.getCodigo_carrera());
//                    }
//                }
//                if (vista.getComboCarrera_mat().getSelectedItem().equals("")) {
//                    vista.getLblNombre().setText("");
//                }
//            }
//        });
//    }

    private void eliminar() {
        int seleccionado = vista.getTablamateria().getSelectedRow();
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE ELIMINAR");
        if (resp2 == 0) {
            if (materia.Eliminar(lista.get(seleccionado).getCod_materia())) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
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

    }

}
