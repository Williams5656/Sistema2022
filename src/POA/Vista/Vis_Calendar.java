/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author KEVIN LANDIVAR
 */
public class Vis_Calendar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_Calendar
     */
    public Vis_Calendar() {
        initComponents();
    }

    public JTable getTabla_responsable() {
        return tabla_responsable;
    }

    public void setTabla_responsable(JTable tabla_responsable) {
        this.tabla_responsable = tabla_responsable;
    }
    

    public JDateChooser getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(JDateChooser Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public JDateChooser getFecha_limite() {
        return Fecha_limite;
    }

    public void setFecha_limite(JDateChooser Fecha_limite) {
        this.Fecha_limite = Fecha_limite;
    }

    public JLabel getJl_evidencia() {
        return Jl_evidencia;
    }

    public void setJl_evidencia(JLabel Jl_evidencia) {
        this.Jl_evidencia = Jl_evidencia;
    }

    public JTable getTabla_responsables() {
        return jTable1;
    }

    public void setTabla_responsables(JTable tabla_responsables) {
        this.jTable1 = tabla_responsables;
    }

    public JTable getTabla_calendario() {
        return Tabla_calendario;
    }

    public void setTabla_calendario(JTable Tabla_calendario) {
        this.Tabla_calendario = Tabla_calendario;
    }

    public JButton getBtn_añadir() {
        return btn_añadir;
    }

    public void setBtn_añadir(JButton btn_añadir) {
        this.btn_añadir = btn_añadir;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_evidencia() {
        return btn_evidencia;
    }

    public void setBtn_evidencia(JButton btn_evidencia) {
        this.btn_evidencia = btn_evidencia;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_imprimir() {
        return btn_imprimir;
    }

    public void setBtn_imprimir(JButton btn_imprimir) {
        this.btn_imprimir = btn_imprimir;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JButton getBtn_n_actividad() {
        return btn_n_actividad;
    }

    public void setBtn_n_actividad(JButton btn_n_actividad) {
        this.btn_n_actividad = btn_n_actividad;
    }

    public JComboBox getCombo_actividad() {
        return combo_actividad;
    }

    public void setCombo_actividad(JComboBox combo_actividad) {
        this.combo_actividad = combo_actividad;
    }

    public JComboBox getCombo_periodo() {
        return combo_periodo;
    }

    public void setCombo_periodo(JComboBox combo_periodo) {
        this.combo_periodo = combo_periodo;
    }

    public JTextField getTxt_N_actividad() {
        return txt_N_actividad;
    }

    public void setTxt_N_actividad(JTextField txt_N_actividad) {
        this.txt_N_actividad = txt_N_actividad;
    }

    public JComboBox<String> getComobo_carrera() {
        return comobo_carrera;
    }

    public void setComobo_carrera(JComboBox<String> comobo_carrera) {
        this.comobo_carrera = comobo_carrera;
    }

    public JTextArea getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(JTextArea txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    public JTextField getTxt_id_A() {
        return txt_id_A;
    }

    public void setTxt_id_A(JTextField txt_id_A) {
        this.txt_id_A = txt_id_A;
    }

    public JTextField getTxt_responsables() {
        return txt_responsables;
    }

    public void setTxt_responsables(JTextField txt_responsables) {
        this.txt_responsables = txt_responsables;
    }

    public JDialog getImprimir_D() {
        return Imprimir_D;
    }

    public void setImprimir_D(JDialog Imprimir_D) {
        this.Imprimir_D = Imprimir_D;
    }

    public JButton getBtn_aceptar() {
        return btn_aceptar;
    }

    public void setBtn_aceptar(JButton btn_aceptar) {
        this.btn_aceptar = btn_aceptar;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JComboBox getCombo_tipo_actividad_repor() {
        return combo_tipo_actividad_repor;
    }

    public void setCombo_tipo_actividad_repor(JComboBox combo_tipo_actividad_repor) {
        this.combo_tipo_actividad_repor = combo_tipo_actividad_repor;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_tipo_actividad_repor = new javax.swing.JComboBox();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_n_actividad = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id_A = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_responsables = new javax.swing.JTextField();
        txt_N_actividad = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        combo_actividad = new javax.swing.JComboBox();
        combo_periodo = new javax.swing.JComboBox();
        Fecha_limite = new com.toedter.calendar.JDateChooser();
        Fecha_inicio = new com.toedter.calendar.JDateChooser();
        comobo_carrera = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_calendario = new javax.swing.JTable();
        btn_evidencia = new javax.swing.JButton();
        Jl_evidencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_responsable = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setText("SELECCIONE EL TIPO DE ACTIVIDAD PARA EL REPORTE");

        jLabel7.setText("TIPO ACTIVIDAD:");

        combo_tipo_actividad_repor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_cancelar.setText("CANCELAR");

        btn_aceptar.setText("ACEPTAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel7)
                                .addGap(140, 140, 140))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_aceptar)
                                .addGap(99, 99, 99)))
                        .addComponent(btn_cancelar)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Imprimir_DLayout = new javax.swing.GroupLayout(Imprimir_D.getContentPane());
        Imprimir_D.getContentPane().setLayout(Imprimir_DLayout);
        Imprimir_DLayout.setHorizontalGroup(
            Imprimir_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Imprimir_DLayout.setVerticalGroup(
            Imprimir_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_n_actividad.setText("CREAR ACTIVIDAD");
        getContentPane().add(btn_n_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, -1, -1));

        btn_modificar.setText("MODIFICAR");
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 56, -1, -1));

        btn_guardar.setText("GUARDAR");
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 56, -1, -1));

        btn_imprimir.setText("IMPRIMIR");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1108, 56, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID ACTIVIDAD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 15, -1, -1));
        jPanel1.add(txt_id_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 12, 150, -1));

        jLabel2.setText("NOMBRE CARRERA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 58, -1, -1));

        jLabel3.setText("TIPO DE ACTIVIDAD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 173, -1, -1));

        jLabel4.setText("PERIODIO ACADÉMICO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 108, -1, -1));

        jLabel8.setText("NOMBRE DE  LA ACTIVIDAD:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 243, -1, -1));

        jLabel11.setText("DESCRIPCION:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 281, -1, -1));

        jLabel13.setText("RESPONSABLES DE LA ACRTIVIDAD:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 383, -1, -1));

        jLabel14.setText("FECHA INICO:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, 20));

        jLabel15.setText("FECHA LIMITE:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, -1, 20));
        jPanel1.add(txt_responsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 404, 150, -1));
        jPanel1.add(txt_N_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 240, 150, -1));

        btn_eliminar.setText("ELIMINAR");
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 403, -1, -1));

        btn_añadir.setText("AÑADIR");
        jPanel1.add(btn_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 403, -1, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 281, -1, -1));

        combo_actividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "POA", "Titulacion", "Calendario ", "Examen Complexión", "Graduacion", "Todos " }));
        combo_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_actividadActionPerformed(evt);
            }
        });
        jPanel1.add(combo_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 170, 148, -1));

        combo_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Jun21-Oct21", "Dic21-Abr22" }));
        jPanel1.add(combo_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 105, 148, -1));
        jPanel1.add(Fecha_limite, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 720, 160, 20));
        jPanel1.add(Fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 640, 160, 20));

        comobo_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jPanel1.add(comobo_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 55, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "responsables"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 432, 153, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, -1, 770));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel6.setText("CALENDARIO ACADÉMICO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 0, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 760));

        Tabla_calendario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Tabla_calendario);

        btn_evidencia.setText("SUBIR EVIDENCIA");

        Jl_evidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabla_responsable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_responsable", "id_actividad", "Responsable"
            }
        ));
        jScrollPane1.setViewportView(tabla_responsable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_evidencia)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btn_evidencia))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 920, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_actividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_actividadActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_imprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha_inicio;
    private com.toedter.calendar.JDateChooser Fecha_limite;
    private javax.swing.JDialog Imprimir_D;
    private javax.swing.JLabel Jl_evidencia;
    private javax.swing.JTable Tabla_calendario;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_evidencia;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_n_actividad;
    private javax.swing.JComboBox combo_actividad;
    private javax.swing.JComboBox combo_periodo;
    private javax.swing.JComboBox combo_tipo_actividad_repor;
    private javax.swing.JComboBox<String> comobo_carrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla_responsable;
    private javax.swing.JTextField txt_N_actividad;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_id_A;
    private javax.swing.JTextField txt_responsables;
    // End of variables declaration//GEN-END:variables
}
