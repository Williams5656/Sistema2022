/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import POA.Modelo.ActividadesBD;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author HP
 */
public class vis_poa_actividad_indicador extends javax.swing.JInternalFrame {
private ActividadesBD baseDatosactividades = new ActividadesBD();
    /**
     * Creates new form vis_poa_actividad_indicador
     */
    public vis_poa_actividad_indicador() {
        initComponents();
        
        
    }

    public JLabel getLblid_indicador() {
        return lblid_indicador;
    }

    public void setLblid_indicador(JLabel lblid_indicador) {
        this.lblid_indicador = lblid_indicador;
    }
    
    
    
    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
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

    
 
    
    

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public JComboBox<String> getComboactividad() {
        return comboactividad;
    }

    public void setComboactividad(JComboBox<String> comboactividad) {
        this.comboactividad = comboactividad;
    }

    public JSpinner getLineabase() {
        return lineabase;
    }

    public void setLineabase(JSpinner lineabase) {
        this.lineabase = lineabase;
    }

    public JSpinner getMeta() {
        return meta;
    }

    public void setMeta(JSpinner meta) {
        this.meta = meta;
    }

    public JTable getTablaindicador() {
        return tablaindicador;
    }

    public void setTablaindicador(JTable tablaindicador) {
        this.tablaindicador = tablaindicador;
    }

    public JTextArea getTxtindicador() {
        return txtindicador;
    }

    public void setTxtindicador(JTextArea txtindicador) {
        this.txtindicador = txtindicador;
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
        jLabel9 = new javax.swing.JLabel();
        comboactividad = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtindicador = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        lineabase = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        meta = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaindicador = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblid_indicador = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("INDICADOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 35));

        jLabel9.setText("Actividad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 90, 20));

        getContentPane().add(comboactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 210, -1));

        jLabel17.setText("Indicador:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 110, 20));

        txtindicador.setColumns(20);
        txtindicador.setRows(5);
        jScrollPane2.setViewportView(txtindicador);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 210, 90));

        jLabel10.setText("Linea Base%:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 110, 20));

        lineabase.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 10));
        getContentPane().add(lineabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 70, -1));

        jLabel2.setText("Meta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 110, 20));

        meta.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 10));
        getContentPane().add(meta, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 70, -1));

        tablaindicador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Indicador", "Actividad", "Indicador", "Linea Base%", "Meta"
            }
        ));
        jScrollPane4.setViewportView(tablaindicador);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 400, 340));

        jLabel7.setText("ID:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 20, -1));

        lblid_indicador.setText("--");
        getContentPane().add(lblid_indicador, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 20, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        btnnuevo.setBorderPainted(false);
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 50));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btnmodificar.setBorderPainted(false);
        btnmodificar.setContentAreaFilled(false);
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 50, 50));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, 50));

        jLabel3.setText("ELIMINAR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel4.setText("NUEVO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel5.setText("GUARDAR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jLabel6.setText("MODIFICAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 360, 80));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (2).jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 440, 370));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 860, 10));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/logo Instituto.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, -80, 270, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnnuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> comboactividad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblid_indicador;
    private javax.swing.JSpinner lineabase;
    private javax.swing.JSpinner meta;
    private javax.swing.JTable tablaindicador;
    private javax.swing.JTextArea txtindicador;
    // End of variables declaration//GEN-END:variables
}
