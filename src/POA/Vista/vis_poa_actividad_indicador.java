/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import POA.Modelo.ActividadesBD;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
        btnguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("INDICADOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 19, -1, 35));

        jLabel9.setText("Actividad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 20));

        getContentPane().add(comboactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 210, -1));

        jLabel17.setText("Indicador:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 20));

        txtindicador.setColumns(20);
        txtindicador.setRows(5);
        jScrollPane2.setViewportView(txtindicador);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 210, 90));

        jLabel10.setText("Linea Base%:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 20));

        lineabase.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 10));
        getContentPane().add(lineabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 70, -1));

        jLabel2.setText("Meta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 20));

        meta.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 10));
        getContentPane().add(meta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 70, -1));

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

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 370, 230));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 140, 40));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> comboactividad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner lineabase;
    private javax.swing.JSpinner meta;
    private javax.swing.JTable tablaindicador;
    private javax.swing.JTextArea txtindicador;
    // End of variables declaration//GEN-END:variables
}
