
package POA.Controlador;
import static POA.Controlador.Con_principal.vista;
import POA.Modelo.*;
import POA.Vista.Vis_Principal.*;

import POA.Modelo.AsignacionMateriaDocenteBD;
import POA.Vista.vis_asignacionmateriadocentes;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static POA.Vista.Vis_Principal.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author PC FACTORY
 */
public class Con_Asignacion {
    private final vis_asignacionmateriadocentes vista;
    AsignacionMateriaDocenteBD bdasignacion = new AsignacionMateriaDocenteBD();
    docenteBD bddocente = new docenteBD();
    PersonaBD bdpersona = new PersonaBD();
    
    public Con_Asignacion(vis_asignacionmateriadocentes vista) {
        this.vista = vista;
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
        vista.getBtnagregar().addActionListener(e->nuevo());
        buscardocente();
    }
    
    public void nuevo() {
        vista.getTxtdocente().setText("");
        vista.getTxtnombredocente().setText("");
        vista.getCboxasignatura().setSelectedIndex(0);
        vista.getCboxciclo().setSelectedIndex(0);
        vista.getCboxidentificacion().setSelectedIndex(0);
        vista.getCboxjornada().setSelectedIndex(0);
        vista.getCboxparalelo().setSelectedIndex(0);
        vista.getCboxperiodo().setSelectedIndex(0);
        
        vista.getBtnguardar().setEnabled(false);
    }
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        List<AsignacionMateriaDocentesMD> lista = bdasignacion.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaasignaciondocentemateria().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaasignaciondocentemateria().setValueAt(lista.get(i).getIdentificacio(), i, 0);
            vista.getTablaasignaciondocentemateria().setValueAt(lista.get(i).getAsignatura(), i, 1);
            vista.getTablaasignaciondocentemateria().setValueAt(lista.get(i).getCiclo(), i, 2);
        }
    }
    public void buscar() {

        List<PersonaMD> lista = bdpersona.obtenerdatos(vista.getTxtdocente().getText());
        List<docenteMD> listadoc = bddocente.obtenerdatos(vista.getTxtdocente().getText());
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.obtenerdatos(vista.getTxtdocente().getText());
        int con = 0;        

        for (int i = 0; i < lista.size(); i++) {
            if (vista.getTxtdocente().getText().equalsIgnoreCase(lista.get(i).getCedula())) {

                String nombre = "[" + lista.get(i).getNombres() + " " + lista.get(i).getApellidos();
                vista.getTxtnombredocente().setText(nombre);
                con = 1;                
            }
        }
            
        if (con != 1) {
            vista.getTxtnombredocente().setText("");
        }
    }
    public void guardar() {
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        String identificacio = (String) vista.getCboxidentificacion().getSelectedItem();
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String ciclo = (String) vista.getCboxciclo().getSelectedItem();
        String jornada = (String) vista.getCboxjornada().getSelectedItem();
        String paralelo = (String) vista.getCboxparalelo().getSelectedItem();
        bdasignacion.setIdentificacio(vista.getTxtdocente().getText());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(asignatura);
        bdasignacion.setCiclo(ciclo);
        bdasignacion.setJornada(jornada);
        bdasignacion.setParalelo(paralelo);

        if (bdasignacion.insertar()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
    public void modificar() {
        String periodo = (String) vista.getCboxperiodo().getSelectedItem();
        String identificacio = (String) vista.getCboxidentificacion().getSelectedItem();
        String asignatura = (String) vista.getCboxasignatura().getSelectedItem();
        String ciclo = (String) vista.getCboxciclo().getSelectedItem();
        String jornada = (String) vista.getCboxjornada().getSelectedItem();
        String paralelo = (String) vista.getCboxparalelo().getSelectedItem();
        bdasignacion.setIdentificacio(vista.getTxtdocente().getText());
        bdasignacion.setPeriodo(periodo);
        bdasignacion.setAsignatura(asignatura);
        bdasignacion.setCiclo(ciclo);
        bdasignacion.setJornada(jornada);
        bdasignacion.setParalelo(paralelo);

        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?");
        if (resp == 0) {
            if (bdasignacion.Modificar(vista.getTxtdocente().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }
    public void buscardocente() {
        vista.getTxtdocente().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar();
            }

        });
    }
    public void seleccionar() {
        vista.getBtnmodificar().setEnabled(true);
        vista.getBtnguardar().setEnabled(false);
            
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaasignaciondocentemateria().getModel();
        String identificacion = (String) modelo.getValueAt(vista.getTablaasignaciondocentemateria().getSelectedRow(), 0);
        List<PersonaMD> listaper = bdpersona.obtenerdatos(identificacion);
        List<docenteMD> lista = bddocente.obtenerdatos(identificacion);
        List<AsignacionMateriaDocentesMD> listaasig = bdasignacion.obtenerdatos(identificacion);
        bdasignacion.setIdentificacio(listaasig.get(0).getIdentificacio());
        bdasignacion.setPeriodo(listaasig.get(0).getPeriodo());
        bdasignacion.setAsignatura(listaasig.get(0).getAsignatura());
        bdasignacion.setParalelo(listaasig.get(0).getParalelo());
        bdasignacion.setJornada(listaasig.get(0).getJornada());
        bdasignacion.setCiclo(listaasig.get(0).getCiclo());

        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());

        vista.getTxtdocente().setText(bdasignacion.getIdentificacio());
        vista.getCboxperiodo().setSelectedItem(bdasignacion.getPeriodo());
        vista.getCboxasignatura().setSelectedItem(bdasignacion.getAsignatura());
        vista.getCboxciclo().setSelectedItem(bdasignacion.getCiclo());
        vista.getCboxjornada().setSelectedItem(bdasignacion.getJornada());
        vista.getCboxparalelo().setSelectedItem(bdasignacion.getParalelo());
        String nombre = "[" + bdasignacion.getIdentificacio() + "]" + bdpersona.getNombres() + " " + bdpersona.getApellidos();
        vista.getTxtnombredocente().setText(nombre);     
    }
    public void eventotabla() {
        vista.getTablaasignaciondocentemateria().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar(); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }
}
    
    

