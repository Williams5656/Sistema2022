/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author PC FACTORY
 */
public class Vis_Documentacion extends javax.swing.JInternalFrame  {

    /**
     * Creates new form Documentacion
     */
    public Vis_Documentacion() {
        initComponents();
    }

    public JButton getBtneditar() {
        return btneditar;
    }

    public void setBtneditar(JButton btneditar) {
        this.btneditar = btneditar;
    }

    public JButton getBtnnuevo() {
        return btnnuevo;
    }

    public void setBtnnuevo(JButton btnnuevo) {
        this.btnnuevo = btnnuevo;
    }

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
    }

    public JTextField getTxt_ciclo() {
        return txt_ciclo;
    }

    public void setTxt_ciclo(JTextField txt_ciclo) {
        this.txt_ciclo = txt_ciclo;
    }

    public JTextField getTxt_gestor() {
        return txt_gestor;
    }

    public void setTxt_gestor(JTextField txt_gestor) {
        this.txt_gestor = txt_gestor;
    }

    public JTextField getTxt_jornada() {
        return txt_jornada;
    }

    public void setTxt_jornada(JTextField txt_jornada) {
        this.txt_jornada = txt_jornada;
    }

    public JTextField getTxt_materia() {
        return txt_materia;
    }

    public void setTxt_materia(JTextField txt_materia) {
        this.txt_materia = txt_materia;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public JTextField getTxt_numPlan() {
        return txt_numPlan;
    }

    public void setTxt_numPlan(JTextField txt_numPlan) {
        this.txt_numPlan = txt_numPlan;
    }

    public JTextField getTxt_paralelo() {
        return txt_paralelo;
    }

    public void setTxt_paralelo(JTextField txt_paralelo) {
        this.txt_paralelo = txt_paralelo;
    }

    public JTextField getTxt_periodo() {
        return txt_periodo;
    }

    public void setTxt_periodo(JTextField txt_periodo) {
        this.txt_periodo = txt_periodo;
    }

    public JButton getBtn_regresar() {
        return btn_regresar;
    }

    public void setBtn_regresar(JButton btn_regresar) {
        this.btn_regresar = btn_regresar;
    }

    public JRadioButton getRadioNo() {
        return radioNo;
    }

    public void setRadioNo(JRadioButton radioNo) {
        this.radioNo = radioNo;
    }

    public JRadioButton getRadioSi() {
        return radioSi;
    }

    public void setRadioSi(JRadioButton radioSi) {
        this.radioSi = radioSi;
    }

    public JTextField getTxt_plan() {
        return txt_plan;
    }

    public JComboBox<String> getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(JComboBox<String> comboEstado) {
        this.comboEstado = comboEstado;
    }

    public JDateChooser getFecha() {
        return fecha;
    }

    public void setFecha(JDateChooser fecha) {
        this.fecha = fecha;
    }

    public void setTxt_plan(JTextField txt_plan) {
        this.txt_plan = txt_plan;
    }

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public ButtonGroup getGuias() {
        return Guias;
    }

    public void setGuias(ButtonGroup Guias) {
        this.Guias = Guias;
    }

    public JTable getTablaDocumentacion() {
        return tablaDocumentacion;
    }

    public void setTablaDocumentacion(JTable tablaDocumentacion) {
        this.tablaDocumentacion = tablaDocumentacion;
    }

    public JTextField getTxt_horaguia() {
        return txt_horaguia;
    }

    public void setTxt_horaguia(JTextField txt_horaguia) {
        this.txt_horaguia = txt_horaguia;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Guias = new javax.swing.ButtonGroup();
        btnnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumentacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_paralelo = new javax.swing.JTextField();
        txt_periodo = new javax.swing.JTextField();
        txt_ciclo = new javax.swing.JTextField();
        txt_gestor = new javax.swing.JTextField();
        txt_jornada = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_materia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        comboEstado = new javax.swing.JComboBox<>();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_numPlan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_plan = new javax.swing.JTextField();
        radioSi = new javax.swing.JRadioButton();
        radioNo = new javax.swing.JRadioButton();
        btn_regresar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_horaguia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, 40));

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        getContentPane().add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 50, -1));

        tablaDocumentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDocumentacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 480, 180));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CEDULA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PERIODO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ASIGNATURA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PARALELO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("JORNADA:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CICLO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GEST. ACADEMICO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DOCENTE:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/ISTA.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 70));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("REVICIÓN DE DOCUMENTOS ACADEMICOS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        txt_paralelo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_paralelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 70, -1));

        txt_periodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 240, -1));

        txt_ciclo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_ciclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cicloActionPerformed(evt);
            }
        });
        getContentPane().add(txt_ciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 70, -1));

        txt_gestor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_gestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 260, -1));

        txt_jornada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_jornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 140, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 340, -1));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 150, -1));

        txt_materia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_materia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 700, 10));

        jLabel12.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Guia:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estado:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 50, 40));

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 110, -1));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 110, -1));

        jLabel14.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fecha:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Planes:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        txt_numPlan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(txt_numPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nº Plan:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        getContentPane().add(txt_plan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 110, -1));

        radioSi.setText("Si");
        getContentPane().add(radioSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        radioNo.setText("No");
        getContentPane().add(radioNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        btn_regresar.setText("Regresar");
        getContentPane().add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Hora Guia:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));
        getContentPane().add(txt_horaguia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 100, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarActionPerformed

    private void txt_cicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cicloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cicloActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Guias;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> comboEstado;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioNo;
    private javax.swing.JRadioButton radioSi;
    private javax.swing.JTable tablaDocumentacion;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_ciclo;
    private javax.swing.JTextField txt_gestor;
    private javax.swing.JTextField txt_horaguia;
    private javax.swing.JTextField txt_jornada;
    private javax.swing.JTextField txt_materia;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numPlan;
    private javax.swing.JTextField txt_paralelo;
    private javax.swing.JTextField txt_periodo;
    private javax.swing.JTextField txt_plan;
    // End of variables declaration//GEN-END:variables
}
