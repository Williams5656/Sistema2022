/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class vis_asignacionmateriadocentes extends javax.swing.JInternalFrame {

    /**
     * Creates new form vis_asignacionmateriadocentes
     */
    public vis_asignacionmateriadocentes() {
        initComponents();
    }

    public JTextField getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(JTextField id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public JButton getBtncrearplan() {
        return btncrearplan;
    }

    public void setBtncrearplan(JButton btncrearplan) {
        this.btncrearplan = btncrearplan;
    }

    public JLabel getLbdocente() {
        return lbdocente;
    }

    public void setLbdocente(JLabel lbdocente) {
        this.lbdocente = lbdocente;
    }

    public JTextField getTxtnombredocente() {
        return txtnombredocente;
    }

    public void setTxtnombredocente(JTextField txtnombredocente) {
        this.txtnombredocente = txtnombredocente;
    }

    

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public void setBtnagregar(JButton btnagregar) {
        this.btnagregar = btnagregar;
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

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JComboBox<String> getCboxasignatura() {
        return cboxasignatura;
    }

    public void setCboxasignatura(JComboBox<String> cboxasignatura) {
        this.cboxasignatura = cboxasignatura;
    }

    public JComboBox<String> getCboxciclo() {
        return cboxciclo;
    }

    public void setCboxciclo(JComboBox<String> cboxciclo) {
        this.cboxciclo = cboxciclo;
    }

    public JComboBox<String> getCboxidentificacion() {
        return cboxidentificacion;
    }

    public void setCboxidentificacion(JComboBox<String> cboxidentificacion) {
        this.cboxidentificacion = cboxidentificacion;
    }

    public JComboBox<String> getCboxjornada() {
        return cboxjornada;
    }

    public void setCboxjornada(JComboBox<String> cboxjornada) {
        this.cboxjornada = cboxjornada;
    }

    public JComboBox<String> getCboxparalelo() {
        return cboxparalelo;
    }

    public void setCboxparalelo(JComboBox<String> cboxparalelo) {
        this.cboxparalelo = cboxparalelo;
    }

    public JComboBox<String> getCboxperiodo() {
        return cboxperiodo;
    }

    public void setCboxperiodo(JComboBox<String> cboxperiodo) {
        this.cboxperiodo = cboxperiodo;
    }

    public JTable getTablaasignaciondocentemateria() {
        return tablaasignaciondocentemateria;
    }

    public void setTablaasignaciondocentemateria(JTable tablaasignaciondocentemateria) {
        this.tablaasignaciondocentemateria = tablaasignaciondocentemateria;
    }

    public JTextField getTxtdocente() {
        return txtdocente;
    }

    public void setTxtdocente(JTextField txtdocente) {
        this.txtdocente = txtdocente;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaasignaciondocentemateria = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        id_asignacion = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btncrearplan = new javax.swing.JButton();
        cboxciclo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboxjornada = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxasignatura = new javax.swing.JComboBox<>();
        txtnombredocente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboxparalelo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboxperiodo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        cboxidentificacion = new javax.swing.JComboBox<>();
        txtdocente = new javax.swing.JTextField();
        lbdocente = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaasignaciondocentemateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DOCENTE", "CICLO", "ASIGNATURA"
            }
        ));
        jScrollPane1.setViewportView(tablaasignaciondocentemateria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 278, 420, 140));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, 40));
        getContentPane().add(id_asignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 70, -1));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        btncrearplan.setText("CREAR PLAN");
        getContentPane().add(btncrearplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        cboxciclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(cboxciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 120, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ASIGNATURA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        cboxjornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINA", "VESPERTINA", "NOCTURNA" }));
        getContentPane().add(cboxjornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JORNADA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 188, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CICLO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        getContentPane().add(cboxasignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, -1));

        txtnombredocente.setForeground(new java.awt.Color(255, 255, 255));
        txtnombredocente.setBorder(null);
        txtnombredocente.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnombredocente.setOpaque(false);
        getContentPane().add(txtnombredocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 470, 20));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PARALELO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        cboxparalelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));
        cboxparalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxparaleloActionPerformed(evt);
            }
        });
        getContentPane().add(cboxparalelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 120, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR POR:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 58, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DOCENTE:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 58, -1, -1));

        cboxperiodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "DIC 2021 ABR 2022", "JUN 2022 OCT 2022" }));
        getContentPane().add(cboxperiodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 147, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PERIODO ACADEMICO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 23, -1, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        cboxidentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IDENTIFICACION", "NOMBRES", "APELLIDOS" }));
        getContentPane().add(cboxidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 160, -1));
        getContentPane().add(txtdocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 170, 20));

        lbdocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        getContentPane().add(lbdocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxparaleloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxparaleloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxparaleloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncrearplan;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox<String> cboxasignatura;
    private javax.swing.JComboBox<String> cboxciclo;
    private javax.swing.JComboBox<String> cboxidentificacion;
    private javax.swing.JComboBox<String> cboxjornada;
    private javax.swing.JComboBox<String> cboxparalelo;
    private javax.swing.JComboBox<String> cboxperiodo;
    private javax.swing.JTextField id_asignacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdocente;
    private javax.swing.JTable tablaasignaciondocentemateria;
    private javax.swing.JTextField txtdocente;
    private javax.swing.JTextField txtnombredocente;
    // End of variables declaration//GEN-END:variables
}
