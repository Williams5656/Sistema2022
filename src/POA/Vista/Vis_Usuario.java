/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Renato Llivisaca
 */
public class Vis_Usuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Usuario
     */
    public Vis_Usuario() {
        initComponents();
    }

    public JTextField getTxtbuscar() {
        return txtbuscar;
    }

    public void setTxtbuscar(JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }
    
    public JButton getBtnbuscar() {
        return btnbuscar;
    }

    public void setBtnbuscar(JButton btnbuscar) {
        this.btnbuscar = btnbuscar;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public JButton getBtnimprimir() {
        return btnimprimir;
    }

    public void setBtnimprimir(JButton btnimprimir) {
        this.btnimprimir = btnimprimir;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JButton getBtnnuevo() {
        return btnnuevo;
    }

    public void setBtnnuevo(JButton btnnuevo) {
        this.btnnuevo = btnnuevo;
    }

    public JPasswordField getTxtcontra() {
        return txtcontra;
    }

    public void setTxtcontra(JPasswordField txtcontra) {
        this.txtcontra = txtcontra;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTable getTableUsuario() {
        return tableUsuario;
    }

    public void setTableUsuario(JTable tableUsuario) {
        this.tableUsuario = tableUsuario;
    }

    public JComboBox<String> getComboestado() {
        return comboestado;
    }

    public void setComboestado(JComboBox<String> comboestado) {
        this.comboestado = comboestado;
    }

    public JComboBox<String> getComborol() {
        return comborol;
    }

    public void setComborol(JComboBox<String> comborol) {
        this.comborol = comborol;
    }

    public JLabel getLblnombre() {
        return lblnombre;
    }

    public void setLblnombre(JLabel lblnombre) {
        this.lblnombre = lblnombre;
    }

    public JButton getBtncedula() {
        return btncedula;
    }

    public void setBtncedula(JButton btncedula) {
        this.btncedula = btncedula;
    }

    public JLabel getLblmensaje() {
        return lblmensaje;
    }

    public void setLblmensaje(JLabel lblmensaje) {
        this.lblmensaje = lblmensaje;
    }

    public JButton getBtn_r_aceptar() {
        return btn_r_aceptar;
    }

    public void setBtn_r_aceptar(JButton btn_r_aceptar) {
        this.btn_r_aceptar = btn_r_aceptar;
    }

    public JButton getBtn_r_cancelar() {
        return btn_r_cancelar;
    }

    public void setBtn_r_cancelar(JButton btn_r_cancelar) {
        this.btn_r_cancelar = btn_r_cancelar;
    }

    public JComboBox getCombo_rol_repor() {
        return combo_rol_repor;
    }

    public void setCombo_rol_repor(JComboBox combo_rol_repor) {
        this.combo_rol_repor = combo_rol_repor;
    }

    public JDialog getImprimir_D() {
        return Imprimir_D;
    }

    public void setImprimir_D(JDialog Imprimir_D) {
        this.Imprimir_D = Imprimir_D;
    }
    
    
    
    
    
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imprimir_D = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_r_aceptar = new javax.swing.JButton();
        btn_r_cancelar = new javax.swing.JButton();
        combo_rol_repor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        txtcedula = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnmodificar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        txtcontra = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        comboestado = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        comborol = new javax.swing.JComboBox<>();
        jSeparator11 = new javax.swing.JSeparator();
        lblnombre = new javax.swing.JLabel();
        btncedula = new javax.swing.JButton();
        lblmensaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Imprimir_D.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SELECCIONE EL ROL PARA EL REPORTE");
        Imprimir_D.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rol:");
        Imprimir_D.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        btn_r_aceptar.setText("ACEPTAR");
        Imprimir_D.getContentPane().add(btn_r_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        btn_r_cancelar.setText("CANCELAR");
        Imprimir_D.getContentPane().add(btn_r_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        Imprimir_D.getContentPane().add(combo_rol_repor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 179, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        Imprimir_D.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 240));

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setText("Cedula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, 30));

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        txtUsuario.setBorder(null);
        txtUsuario.setOpaque(false);
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, 30));

        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Usuario", "Contraseña", "Rol", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tableUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 510, 180));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        btnbuscar.setText("Buscar");
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 40));

        txtbuscar.setBorder(null);
        txtbuscar.setOpaque(false);
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 160, 40));

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 150, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 510, 60));

        txtcedula.setBorder(null);
        txtcedula.setOpaque(false);
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
        });
        getContentPane().add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, 30));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btnmodificar.setText("Modificar");
        jPanel2.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 10, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 400, 60));

        txtcontra.setBorder(null);
        txtcontra.setOpaque(false);
        getContentPane().add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, 30));

        jLabel7.setText("Rol:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 60, 30));

        comboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(comboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 140, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 10, 360));

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        btneliminar.setText("Cambiar estado");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 190, 60));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 10));

        jLabel8.setText("Estado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 60, 30));

        getContentPane().add(comborol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 30));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, 10));

        lblnombre.setForeground(new java.awt.Color(0, 0, 204));
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 230, 20));

        btncedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        btncedula.setBorder(null);
        btncedula.setBorderPainted(false);
        btncedula.setContentAreaFilled(false);
        btncedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncedulaActionPerformed(evt);
            }
        });
        getContentPane().add(btncedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 40, 40));

        lblmensaje.setForeground(new java.awt.Color(255, 0, 0));
        lblmensaje.setText("*PERSONA NO REGISTRADA");
        getContentPane().add(lblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 200, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/My project.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncedulaActionPerformed

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Imprimir_D;
    private javax.swing.JButton btn_r_aceptar;
    private javax.swing.JButton btn_r_cancelar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncedula;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox combo_rol_repor;
    private javax.swing.JComboBox<String> comboestado;
    private javax.swing.JComboBox<String> comborol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTable tableUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JPasswordField txtcontra;
    // End of variables declaration//GEN-END:variables
}
