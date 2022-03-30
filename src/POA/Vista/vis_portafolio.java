/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package POA.Vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;

/**
 *
 * @author Isaac Mejia
 */
public class vis_portafolio extends javax.swing.JInternalFrame {

    /**
     * Creates new form vis_portafolio
     */
    public vis_portafolio() {
        initComponents();
        botones_grupo.add(btnNotas);
        botones_grupo.add(btnModulos);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JToggleButton getBtnGuiasPracticas() {
        return btnGuiasPracticas;
    }

    public void setBtnGuiasPracticas(JToggleButton btnGuiasPracticas) {
        this.btnGuiasPracticas = btnGuiasPracticas;
    }

    public JToggleButton getBtnInformesSilabo() {
        return btnInformesSilabo;
    }

    public void setBtnInformesSilabo(JToggleButton btnInformesSilabo) {
        this.btnInformesSilabo = btnInformesSilabo;
    }

    public JToggleButton getBtnInstrumentosEv() {
        return btnInstrumentosEv;
    }

    public void setBtnInstrumentosEv(JToggleButton btnInstrumentosEv) {
        this.btnInstrumentosEv = btnInstrumentosEv;
    }

    public JToggleButton getBtnModulos() {
        return btnModulos;
    }

    public void setBtnModulos(JToggleButton btnModulos) {
        this.btnModulos = btnModulos;
    }

    public JToggleButton getBtnNotas() {
        return btnNotas;
    }

    public void setBtnNotas(JToggleButton btnNotas) {
        this.btnNotas = btnNotas;
    }

    public JToggleButton getBtnPlanesClase() {
        return btnPlanesClase;
    }

    public void setBtnPlanesClase(JToggleButton btnPlanesClase) {
        this.btnPlanesClase = btnPlanesClase;
    }

    public JToggleButton getBtnSilabo() {
        return btnSilabo;
    }

    public void setBtnSilabo(JToggleButton btnSilabo) {
        this.btnSilabo = btnSilabo;
    }

    public JButton getBtnSubirArchivo() {
        return btnSubirArchivo;
    }

    public void setBtnSubirArchivo(JButton btnSubirArchivo) {
        this.btnSubirArchivo = btnSubirArchivo;
    }

    public JComboBox<String> getComboCiclo() {
        return comboCiclo;
    }

    public void setComboCiclo(JComboBox<String> comboCiclo) {
        this.comboCiclo = comboCiclo;
    }

    public JComboBox<String> getComboMateria() {
        return comboMateria;
    }

    public void setComboMateria(JComboBox<String> comboMateria) {
        this.comboMateria = comboMateria;
    }

    public JComboBox<String> getComboSeccion() {
        return comboSeccion;
    }

    public void setComboSeccion(JComboBox<String> comboSeccion) {
        this.comboSeccion = comboSeccion;
    }

    public JLabel getLblCarrera() {
        return lblCarrera;
    }

    public void setLblCarrera(JLabel lblCarrera) {
        this.lblCarrera = lblCarrera;
    }

    public JRadioButton getRadbutA() {
        return radbutA;
    }

    public void setRadbutA(JRadioButton radbutA) {
        this.radbutA = radbutA;
    }

    public JRadioButton getRadbutB() {
        return radbutB;
    }

    public void setRadbutB(JRadioButton radbutB) {
        this.radbutB = radbutB;
    }

    public ButtonGroup getRadiogroupParalelo() {
        return radiogroupParalelo;
    }

    public void setRadiogroupParalelo(ButtonGroup radiogroupParalelo) {
        this.radiogroupParalelo = radiogroupParalelo;
    }

    public JComboBox<String> getComboPeriodAcademico() {
        return comboPeriodAcademico;
    }

    public void setComboPeriodAcademico(JComboBox<String> comboPeriodAcademico) {
        this.comboPeriodAcademico = comboPeriodAcademico;
    }

    public JTable getTbl_Datos() {
        return tbl_Datos;
    }

    public void setTbl_Datos(JTable tbl_Datos) {
        this.tbl_Datos = tbl_Datos;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogroupParalelo = new javax.swing.ButtonGroup();
        botones_grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnGuiasPracticas = new javax.swing.JToggleButton();
        btnModulos = new javax.swing.JToggleButton();
        btnInstrumentosEv = new javax.swing.JToggleButton();
        btnNotas = new javax.swing.JToggleButton();
        btnInformesSilabo = new javax.swing.JToggleButton();
        btnPlanesClase = new javax.swing.JToggleButton();
        btnSilabo = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboPeriodAcademico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboCiclo = new javax.swing.JComboBox<>();
        btnSubirArchivo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboMateria = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        radbutA = new javax.swing.JRadioButton();
        radbutB = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        comboSeccion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DOCUMENTO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botones_grupo.add(btnGuiasPracticas);
        btnGuiasPracticas.setText("GUIAS PRACTICAS");
        jPanel1.add(btnGuiasPracticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        botones_grupo.add(btnModulos);
        btnModulos.setText("MODULOS");
        jPanel1.add(btnModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        botones_grupo.add(btnInstrumentosEv);
        btnInstrumentosEv.setText("INSTRUMENTOS DE EVALUACION");
        btnInstrumentosEv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstrumentosEvActionPerformed(evt);
            }
        });
        jPanel1.add(btnInstrumentosEv, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        botones_grupo.add(btnNotas);
        btnNotas.setText("NOTAS");
        jPanel1.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        botones_grupo.add(btnInformesSilabo);
        btnInformesSilabo.setText("INFORMES DE SILABO");
        jPanel1.add(btnInformesSilabo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        botones_grupo.add(btnPlanesClase);
        btnPlanesClase.setText("PLANES DE CLASE");
        jPanel1.add(btnPlanesClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        botones_grupo.add(btnSilabo);
        btnSilabo.setText("SILABO");
        jPanel1.add(btnSilabo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTROS"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PERIODO ACADEMICO:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel2.add(comboPeriodAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 180, -1));

        jLabel2.setText("CARRERA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        lblCarrera.setForeground(new java.awt.Color(0, 0, 255));
        jPanel2.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 180, 20));

        jLabel4.setText("CICLO:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        comboCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jPanel2.add(comboCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 40, -1));

        btnSubirArchivo.setText("SUBIR ARCHIVO");
        jPanel2.add(btnSubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jLabel5.setText("MATERIA:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jPanel2.add(comboMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 200, -1));

        btnGuardar.setText("GUARDAR");
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel6.setText("PARALELO:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        radiogroupParalelo.add(radbutA);
        radbutA.setText("A");
        jPanel2.add(radbutA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        radiogroupParalelo.add(radbutB);
        radbutB.setText("B");
        jPanel2.add(radbutB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel7.setText("SECCION:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        comboSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Nocturno" }));
        jPanel2.add(comboSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS INGRESADOS"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_Datos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 780, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInstrumentosEvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstrumentosEvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInstrumentosEvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botones_grupo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JToggleButton btnGuiasPracticas;
    private javax.swing.JToggleButton btnInformesSilabo;
    private javax.swing.JToggleButton btnInstrumentosEv;
    private javax.swing.JToggleButton btnModulos;
    private javax.swing.JToggleButton btnNotas;
    private javax.swing.JToggleButton btnPlanesClase;
    private javax.swing.JToggleButton btnSilabo;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JComboBox<String> comboCiclo;
    private javax.swing.JComboBox<String> comboMateria;
    private javax.swing.JComboBox<String> comboPeriodAcademico;
    private javax.swing.JComboBox<String> comboSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JRadioButton radbutA;
    private javax.swing.JRadioButton radbutB;
    private javax.swing.ButtonGroup radiogroupParalelo;
    private javax.swing.JTable tbl_Datos;
    // End of variables declaration//GEN-END:variables
}
