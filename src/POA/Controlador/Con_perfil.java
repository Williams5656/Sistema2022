/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.Conect;
import POA.Modelo.ModeloAsignacion;
import POA.Modelo.PerfilBD;
import POA.Modelo.PerfilMD;
import POA.Modelo.Validadores.Letras;
import POA.Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
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
 * @author USUARIO
 */
public class Con_perfil {

    private final Vis_Perfil vista;
    private PerfilBD bdperfil = new PerfilBD();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<PerfilMD> lista = new ArrayList<>();

    public Con_perfil(Vis_Perfil vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtn_eliminar().addActionListener(e -> eliminar());
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_imprimir().addActionListener(e -> imprimir());
        Letras.solo_letras(vista.getTxtNombre());
        vista.getTablaPerfil().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        vista.getBtn_guardar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getTxtNombre().setEnabled(false);
        vista.getTxtDescripcion().setEnabled(false);
        vista.getPanel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                nuevo();
            }
        });
        lista();
    } ;
    public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReportePerfil.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    private void nuevo() {
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getTxtNombre().setEnabled(true);
        vista.getTxtDescripcion().setEnabled(true);
        vista.getTxtNombre().setText("");
        vista.getTxtDescripcion().setText("");
    }

    private void guardar() {
        if (vista.getTxtNombre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE");
        } else if (vista.getTxtDescripcion().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE LA DESCRIPCION");
        } else  {
            
            bdperfil.setNombre(vista.getTxtNombre().getText());
            bdperfil.setDescripcion(vista.getTxtDescripcion().getText());
            if (bdperfil.insertar()) {
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
        }

    }

    private void modificar() {
        int seleccionado = vista.getTablaPerfil().getSelectedRow();
        
        bdperfil.setNombre(vista.getTxtNombre().getText());
        bdperfil.setDescripcion(vista.getTxtDescripcion().getText());
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdperfil.modificar(lista.get(seleccionado).getCodigo())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
            }
        }
    }

    private void eliminar() {
        int seleccionado = vista.getTablaPerfil().getSelectedRow();
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI ESTA SEGURO DE MODIFICAR");
        if (resp2 == 0) {
            if (bdperfil.eliminar(lista.get(seleccionado).getCodigo())) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }
        }

    }

    private void seleccionar() {
        int select = vista.getTablaPerfil().getSelectedRow();
        vista.getBtn_modificar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(true);
        vista.getBtn_guardar().setEnabled(false);
        vista.getTxtNombre().setEnabled(true);;
        vista.getTxtDescripcion().setEnabled(true);
  
        lista = bdperfil.mostrardatos();
        vista.getTxtNombre().setText(lista.get(select).getNombre());
        vista.getTxtDescripcion().setText(lista.get(select).getDescripcion());
    }

    public void lista(){
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        
        lista = bdperfil.mostrardatos();
        for (PerfilMD user : lista) {
            Object[] fila = new Object[3];
            fila[0] = user.getCodigo();
            fila[1] = user.getNombre();
            fila[2] = user.getDescripcion();
            
            modelo.addRow(fila);
        }
        
        vista.getTablaPerfil().setModel(modelo);

    }
}
