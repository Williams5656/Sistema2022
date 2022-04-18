/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package POA.Vista;

import POA.Modelo.Validadores.Fondos;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Isaac Mejia
 */
public class vis_portafolio extends Fondos.fondo_internalframe {

    /**
     * Creates new form vis_portafolio
     */
    public vis_portafolio() {
        initComponents();
        botones_grupo.add(btnNotas);
        botones_grupo.add(btnModulos);
        setImage("/POA/Vista/img/My project.png");
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

    public JButton getBtn_buscar() {
        return btn_buscar;
    }

    public void setBtn_buscar(JButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public JButton getBtn_subir() {
        return btn_subir;
    }

    public void setBtn_subir(JButton btn_subir) {
        this.btn_subir = btn_subir;
    }

    public JCheckBox getChk_ciclo() {
        return chk_ciclo;
    }

    public void setChk_ciclo(JCheckBox chk_ciclo) {
        this.chk_ciclo = chk_ciclo;
    }

    public JCheckBox getChk_materia() {
        return chk_materia;
    }

    public void setChk_materia(JCheckBox chk_materia) {
        this.chk_materia = chk_materia;
    }

    public JCheckBox getChk_paralelo() {
        return chk_paralelo;
    }

    public void setChk_paralelo(JCheckBox chk_paralelo) {
        this.chk_paralelo = chk_paralelo;
    }

    public JCheckBox getChk_periodo() {
        return chk_periodo;
    }

    public void setChk_periodo(JCheckBox chk_periodo) {
        this.chk_periodo = chk_periodo;
    }

    public JCheckBox getChk_seccion() {
        return chk_seccion;
    }

    public void setChk_seccion(JCheckBox chk_seccion) {
        this.chk_seccion = chk_seccion;
    }

    public JComboBox<String> getComboPeriodAcademico() {
        return comboPeriodAcademico;
    }

    public void setComboPeriodAcademico(JComboBox<String> comboPeriodAcademico) {
        this.comboPeriodAcademico = comboPeriodAcademico;
    }

    public JComboBox<String> getComboSeccion() {
        return comboSeccion;
    }

    public void setComboSeccion(JComboBox<String> comboSeccion) {
        this.comboSeccion = comboSeccion;
    }

    public JTable getTbl_Datos() {
        return tbl_Datos;
    }

    public void setTbl_Datos(JTable tbl_Datos) {
        this.tbl_Datos = tbl_Datos;
    }

    public JTextField getTxt_materia() {
        return txt_materia;
    }

    public void setTxt_materia(JTextField txt_materia) {
        this.txt_materia = txt_materia;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JComboBox<String> getComboCiclo() {
        return comboCiclo;
    }

    public void setComboCiclo(JComboBox<String> comboCiclo) {
        this.comboCiclo = comboCiclo;
    }

    public JCheckBox getChk_doc() {
        return chk_doc;
    }

    public void setChk_doc(JCheckBox chk_doc) {
        this.chk_doc = chk_doc;
    }

    public JComboBox<String> getCombodocu() {
        return combodocu;
    }

    public void setCombodocu(JComboBox<String> combodocu) {
        this.combodocu = combodocu;
    }

    public JComboBox<String> getComboparalelo() {
        return comboparalelo;
    }

    public void setComboparalelo(JComboBox<String> comboparalelo) {
        this.comboparalelo = comboparalelo;
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
        checks_buscar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnGuiasPracticas = new javax.swing.JToggleButton();
        btnModulos = new javax.swing.JToggleButton();
        btnInstrumentosEv = new javax.swing.JToggleButton();
        btnNotas = new javax.swing.JToggleButton();
        btnInformesSilabo = new javax.swing.JToggleButton();
        btnPlanesClase = new javax.swing.JToggleButton();
        btnSilabo = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        comboPeriodAcademico = new javax.swing.JComboBox<>();
        comboCiclo = new javax.swing.JComboBox<>();
        comboSeccion = new javax.swing.JComboBox<>();
        combodocu = new javax.swing.JComboBox<>();
        chk_periodo = new javax.swing.JCheckBox();
        chk_ciclo = new javax.swing.JCheckBox();
        chk_materia = new javax.swing.JCheckBox();
        txt_materia = new javax.swing.JTextField();
        chk_paralelo = new javax.swing.JCheckBox();
        chk_seccion = new javax.swing.JCheckBox();
        comboparalelo = new javax.swing.JComboBox<>();
        chk_doc = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Datos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        btn_subir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DOCUMENTO"));

        botones_grupo.add(btnGuiasPracticas);
        btnGuiasPracticas.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnGuiasPracticas.setText("GUIAS PRACTICAS");

        botones_grupo.add(btnModulos);
        btnModulos.setText("MODULOS");

        botones_grupo.add(btnInstrumentosEv);
        btnInstrumentosEv.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnInstrumentosEv.setText("INSTRUMENTOS DE EVALUACION");

        botones_grupo.add(btnNotas);
        btnNotas.setText("NOTAS");

        botones_grupo.add(btnInformesSilabo);
        btnInformesSilabo.setText("INFORMES DE SILABO");

        botones_grupo.add(btnPlanesClase);
        btnPlanesClase.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnPlanesClase.setText("PLANES DE CLASE");

        botones_grupo.add(btnSilabo);
        btnSilabo.setText("SILABO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModulos, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnSilabo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInstrumentosEv)
                    .addComponent(btnInformesSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPlanesClase, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btnGuiasPracticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(btnNotas)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModulos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInstrumentosEv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuiasPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInformesSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlanesClase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTROS"));

        comboCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        comboSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutina", "Vespertina", "Nocturna" }));

        combodocu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subidos", "Faltantes" }));

        chk_periodo.setText("PERIODO ACADEMICO");

        chk_ciclo.setText("CICLO");

        chk_materia.setText("MATERIA");

        chk_paralelo.setText("PARALELO");

        chk_seccion.setText("SECCION");

        comboparalelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));

        chk_doc.setText("DOCUMENTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chk_seccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chk_doc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combodocu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chk_periodo)
                        .addGap(8, 8, 8)
                        .addComponent(comboPeriodAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chk_paralelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboparalelo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chk_materia)
                        .addGap(12, 12, 12)
                        .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chk_ciclo)
                        .addGap(18, 18, 18)
                        .addComponent(comboCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_periodo)
                    .addComponent(comboPeriodAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_paralelo)
                    .addComponent(comboparalelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_materia)
                    .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_ciclo))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chk_doc)
                        .addComponent(combodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chk_seccion)
                        .addComponent(comboSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DOCUMENTACION"));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("ACCION"));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/buscar (2).png"))); // NOI18N

        btn_subir.setText("SUBIR");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_subir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_subir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel4.getAccessibleContext().setAccessibleName("ACCIONES");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botones_grupo;
    private javax.swing.JToggleButton btnGuiasPracticas;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JToggleButton btnInformesSilabo;
    private javax.swing.JToggleButton btnInstrumentosEv;
    private javax.swing.JToggleButton btnModulos;
    private javax.swing.JToggleButton btnNotas;
    private javax.swing.JToggleButton btnPlanesClase;
    private javax.swing.JToggleButton btnSilabo;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_subir;
    private javax.swing.ButtonGroup checks_buscar;
    private javax.swing.JCheckBox chk_ciclo;
    private javax.swing.JCheckBox chk_doc;
    private javax.swing.JCheckBox chk_materia;
    private javax.swing.JCheckBox chk_paralelo;
    private javax.swing.JCheckBox chk_periodo;
    private javax.swing.JCheckBox chk_seccion;
    private javax.swing.JComboBox<String> comboCiclo;
    private javax.swing.JComboBox<String> comboPeriodAcademico;
    private javax.swing.JComboBox<String> comboSeccion;
    private javax.swing.JComboBox<String> combodocu;
    private javax.swing.JComboBox<String> comboparalelo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup radiogroupParalelo;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTextField txt_materia;
    // End of variables declaration//GEN-END:variables
}
