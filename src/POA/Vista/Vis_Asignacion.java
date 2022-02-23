/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import POA.Controlador.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Vis_Asignacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Asignacion
     */
    public Vis_Asignacion() {
        initComponents();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }
    

    

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JComboBox<String> getComboPerfil() {
        return comboPerfil;
    }

    public void setComboPerfil(JComboBox<String> comboPerfil) {
        this.comboPerfil = comboPerfil;
    }

    public JTable getTablaAsignacion() {
        return tablaAsignacion;
    }

    public void setTablaAsignacion(JTable tablaAsignacion) {
        this.tablaAsignacion = tablaAsignacion;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }


    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        comboPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAsignacion = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Asignacion");

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cédula:");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        panel.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, -1));

        panel.add(comboPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Perfil:");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        panel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btnModificar.setToolTipText("Modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        panel.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        tablaAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAsignacion);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 670, 170));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        panel.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 40));

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 390, 20));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir");
        btnImprimir.setBorderPainted(false);
        btnImprimir.setContentAreaFilled(false);
        panel.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, 40));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setBorderPainted(false);
        btn_buscar.setContentAreaFilled(false);
        panel.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));
        panel.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel3KeyReleased(evt);
            }
        });
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyReleased
    }//GEN-LAST:event_jLabel3KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaAsignacion;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
