/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author KEVIN LANDIVAR
 */
public class Vis_Permisos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Permisos
     */
    public Vis_Permisos() {
        initComponents();
    }

    public JTable getTablapermisos() {
        return tablapermisos;
    }

    public void setTablapermisos(JTable tablapermisos) {
        this.tablapermisos = tablapermisos;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JTextField getTxtidRol() {
        return txtidRol;
    }

    public void setTxtidRol(JTextField txtidRol) {
        this.txtidRol = txtidRol;
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapermisos = new javax.swing.JTable();
        txtidRol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERMISOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 11, 256, 62));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/Save-icon (4).png"))); // NOI18N
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        jButton2.setText("Seleccionar todo");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        tablapermisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablapermisos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 220));
        getContentPane().add(txtidRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 30, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Rol:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablapermisos;
    private javax.swing.JTextField txtidRol;
    // End of variables declaration//GEN-END:variables
}
