/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import static POA.Controlador.Con_principal.vista;
import POA.Modelo.*;
import POA.Vista.Vis_Principal.*;

import POA.Vista.vis_Docentes;
import POA.Vista.vis_Persona;
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

/**
 *
 * @author HP
 */
public class con_docentes {

    private final vis_Docentes vista;
    docenteBD bddocente = new docenteBD();
    PersonaBD bdpersona = new PersonaBD();

    public con_docentes(vis_Docentes vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtnmodificar().addActionListener(e -> modificar());
        buscarpersona();
        eventotabla();
        lista();
        persona();

    }

    public void buscarpersona() {
        vista.getTxtidentificacion().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar();
            }

        });
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_docentes().getModel();
        List<docenteMD> lista = bddocente.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_docentes().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_docentes().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTabla_docentes().setValueAt(lista.get(i).getTitulo(), i, 1);
            vista.getTabla_docentes().setValueAt(lista.get(i).getAbreviatura(), i, 2);
            vista.getTabla_docentes().setValueAt(lista.get(i).getTiempo(), i, 3);
            vista.getTabla_docentes().setValueAt(lista.get(i).getOcupacion(), i, 4);

        }
    }

    public void buscar() {

        List<PersonaMD> lista = bdpersona.obtenerdatos(vista.getTxtidentificacion().getText());
        int con = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (vista.getTxtidentificacion().getText().equalsIgnoreCase(lista.get(i).getCedula())) {
                String nombre = "[" + lista.get(i).getCedula() + "]" + lista.get(i).getNombres() + " " + lista.get(i).getApellidos();
                vista.getLbnombreycedula().setText(nombre);
                con = 1;

                Image img = lista.get(i).getFoto();
                if (img != null) {
                    Image newimg = img.getScaledInstance(vista.getLbfoto().getWidth(), vista.getLbfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(newimg);
                    vista.getLbfoto().setIcon(icon);
                } else {
                    vista.getLbfoto().setIcon(null);
                }
            }
        }
        if (con != 1) {
            vista.getLbnombreycedula().setText("");
            vista.getLbfoto().setIcon(null);
        }

    }

    public void guardar() {
        String ocupacion = "";
        if (vista.getRbdocentecapacitador().isSelected()) {
            ocupacion = "Docente Capacitador";
        } else if (vista.getRbotrotrabajo().isSelected()) {
            ocupacion = "Otro Trabajo";
        }

        String tiempo = (String) vista.getCombo_tiempo().getSelectedItem();
        bddocente.setCedula(vista.getTxtidentificacion().getText());
        bddocente.setTitulo(vista.getTxttitulo().getText());
        bddocente.setAbreviatura(vista.getTxtabreviatura().getText());
        bddocente.setTiempo(tiempo);
        bddocente.setOcupacion(ocupacion);

        if (bddocente.insertar()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }

    }

    public void modificar() {
        String ocupacion = "";
        if (vista.getRbdocentecapacitador().isSelected()) {
            ocupacion = "Docente Capacitador";
        } else if (vista.getRbotrotrabajo().isSelected()) {
            ocupacion = "Otro Trabajo";
        }

        String tiempo = (String) vista.getCombo_tiempo().getSelectedItem();
        bddocente.setCedula(vista.getTxtidentificacion().getText());
        bddocente.setTitulo(vista.getTxttitulo().getText());
        bddocente.setAbreviatura(vista.getTxtabreviatura().getText());
        bddocente.setTiempo(tiempo);
        bddocente.setOcupacion(ocupacion);

        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?");
        if (resp == 0) {
            if (bddocente.Modificar(vista.getTxtidentificacion().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }

        }
    }

    public void nuevo() {
        vista.getTxtidentificacion().setText("");
        vista.getTxtabreviatura().setText("");
        vista.getTxttitulo().setText("");
        vista.getLbnombreycedula().setText("");
        vista.getCombo_tiempo().setSelectedIndex(0);
        vista.getButtonGroup1().clearSelection();
        vista.getLbfoto().setIcon(null);
    }

    public void seleccionar() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_docentes().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTabla_docentes().getSelectedRow(), 0);
        List<PersonaMD> listaper = bdpersona.obtenerdatos(cedula);
        List<docenteMD> lista = bddocente.obtenerdatos(cedula);
        bddocente.setCedula(lista.get(0).getCedula());
        bddocente.setTitulo(lista.get(0).getTitulo());
        bddocente.setAbreviatura(lista.get(0).getAbreviatura());
        bddocente.setTiempo(lista.get(0).getTiempo());
        bddocente.setOcupacion(lista.get(0).getOcupacion());

        bdpersona.setFoto(listaper.get(0).getFoto());
        bdpersona.setNombres(listaper.get(0).getNombres());
        bdpersona.setApellidos(listaper.get(0).getApellidos());

        vista.getTxtidentificacion().setText(bddocente.getCedula());
        vista.getTxtabreviatura().setText(bddocente.getAbreviatura());
        vista.getCombo_tiempo().setSelectedItem(bddocente.getTiempo());
        vista.getTxttitulo().setText(bddocente.getTitulo());

        String nombre = "[" + bddocente.getCedula() + "]" + bdpersona.getNombres() + " " + bdpersona.getApellidos();
        vista.getLbnombreycedula().setText(nombre);

        String ocupacion = bddocente.getOcupacion();
        System.out.println(ocupacion);
        if (ocupacion.equalsIgnoreCase("Docente Capacitador")) {
            vista.getRbdocentecapacitador().setSelected(true);

        } else if (ocupacion.equalsIgnoreCase("Otro Trabajo")) {
            vista.getRbotrotrabajo().setSelected(true);

        }

        Image img = listaper.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLbfoto().getWidth(), vista.getLbfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLbfoto().setIcon(icon);
        } else {
            vista.getLbfoto().setIcon(null);
        }
    }

    public void eventotabla() {
        vista.getTabla_docentes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar(); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    private void persona() {

        vista.getLbbtnregistarpersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.setVisible(false);
                
                vis_Persona persona = new vis_Persona();
                Con_persona per = new Con_persona(persona);
                
                
                ESCRITORIO.add(persona);
                persona.show();
                Dimension desktopSize = ESCRITORIO.getSize();
                Dimension FrameSize = persona.getSize();
                persona.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                
                
            }

        });

    }
}
