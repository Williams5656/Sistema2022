/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author MIGUEL
 */
public class vis_Persona extends javax.swing.JInternalFrame {

    /**
     * Creates new form vis_Persona
     */
    public vis_Persona() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lbError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        btnCargarFoto = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        btnCamEstado = new javax.swing.JToggleButton();
        jLabel20 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1126, 608));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(6, 56, 107));
        jLabel3.setText("Persona");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 40));

        btnGuardar.setBackground(new java.awt.Color(235, 192, 36));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 50, 30));

        btnModificar.setBackground(new java.awt.Color(235, 192, 36));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        panel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 40, 30));

        btnNuevo.setBackground(new java.awt.Color(235, 192, 36));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        panel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 50, 30));
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 130, 120));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N
        btnImprimir.setBorderPainted(false);
        btnImprimir.setContentAreaFilled(false);
        panel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 40, 30));

        jLabel15.setText("Guardar");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel16.setText("Modificar");
        panel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        jLabel17.setText("Nuevo");
        panel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));

        jLabel18.setText("Imprimir");
        panel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        tablePersonas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellidos", "Fecha Nacimiento", "Direccion", "Correo", "Celular"
            }
        ));
        jScrollPane1.setViewportView(tablePersonas);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 640, 320));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Lista Persona");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        txtBuscar.setOpaque(false);
        panel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 250, 20));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 250, 10));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        panel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 40, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Foto");
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        panel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 170, -1));

        txtCedula.setForeground(new java.awt.Color(255, 255, 255));
        txtCedula.setBorder(null);
        txtCedula.setOpaque(false);
        panel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, 20));

        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.setOpaque(false);
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 170, 20));

        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(null);
        txtApellido.setOpaque(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        panel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 170, 20));

        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(null);
        txtCorreo.setOpaque(false);
        panel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 170, 20));

        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(null);
        txtDireccion.setOpaque(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        panel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 170, 20));

        txtCelular.setForeground(new java.awt.Color(255, 255, 255));
        txtCelular.setBorder(null);
        txtCelular.setOpaque(false);
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        panel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 170, 20));

        lbError.setForeground(new java.awt.Color(255, 51, 51));
        lbError.setText("Cedula Error");
        lbError.setVisible(false);
        panel1.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cedula:");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres:");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellidos:");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha Nacimiento:");
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Direccion:");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo:");
        panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Celular");
        panel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/imagen.png"))); // NOI18N
        panel1.add(lbFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, 110));

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 170, 10));

        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 170, 10));

        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 170, 10));

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 170, 10));

        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 170, 10));

        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        panel1.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 170, 10));

        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/cargar foto.png"))); // NOI18N
        btnCargarFoto.setBorderPainted(false);
        btnCargarFoto.setContentAreaFilled(false);
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        panel1.add(btnCargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 40, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        fondo.setText("jLabel21");
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(6, 56, 107)));
        panel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 390, 480));

        btnCamEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/CAMBIAR ESTADO (1).png"))); // NOI18N
        btnCamEstado.setBorderPainted(false);
        btnCamEstado.setContentAreaFilled(false);
        panel1.add(btnCamEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 50, 30));

        jLabel20.setText("Cambiar Estado");
        panel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    public JLabel getLbError() {
        return lbError;
    }

    public void setLbError(JLabel lbError) {
        this.lbError = lbError;
    }

    public JDateChooser getFecha() {
        return fecha;
    }

    public void setFecha(JDateChooser fecha) {
        this.fecha = fecha;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCargarFoto() {
        return btnCargarFoto;
    }

    public void setBtnCargarFoto(JButton btnCargarFoto) {
        this.btnCargarFoto = btnCargarFoto;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JLabel getLbFoto() {
        return lbFoto;
    }

    public void setLbFoto(JLabel lbFoto) {
        this.lbFoto = lbFoto;
    }

    public JTable getTablePersonas() {
        return tablePersonas;
    }

    public void setTablePersonas(JTable tablePersonas) {
        this.tablePersonas = tablePersonas;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton btnCamEstado;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbFoto;
    private java.awt.Panel panel1;
    private javax.swing.JTable tablePersonas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
