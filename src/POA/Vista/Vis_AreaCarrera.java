/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class Vis_AreaCarrera extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vis_AreaCarrera
     */
    public Vis_AreaCarrera() {
        initComponents();
    }

    public JComboBox<String> getComboCarrera() {
        return comboCarrera;
    }

    public void setComboCarrera(JComboBox<String> comboCarrera) {
        this.comboCarrera = comboCarrera;
    }

    

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
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

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JComboBox<String> getComboPerfil() {
        return comboPerfil;
    }

    public void setComboPerfil(JComboBox<String> comboPerfil) {
        this.comboPerfil = comboPerfil;
    }

  

    public JComboBox<String> getComboResponsable() {
        return comboResponsable;
    }

    public void setComboResponsable(JComboBox<String> comboResponsable) {
        this.comboResponsable = comboResponsable;
    }

    public JTable getTablaAreaCarrera() {
        return tablaAreaCarrera;
    }

    public void setTablaAreaCarrera(JTable tablaAreaCarrera) {
        this.tablaAreaCarrera = tablaAreaCarrera;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox<>();
        comboResponsable = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAreaCarrera = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboPerfil = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Area de Carrera");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Perfil:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setText("Responsable:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel1.add(comboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 139, -1));

        jPanel1.add(comboResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 139, -1));

        tablaAreaCarrera.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAreaCarrera);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 364, 162));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btn_guardar.setText("Guardar");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        btn_imprimir.setText("Imprimir");
        jPanel1.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        btn_eliminar.setText("Eliminar");
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel3.setText("Carrera:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.add(comboPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 139, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JComboBox<String> comboResponsable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAreaCarrera;
    // End of variables declaration//GEN-END:variables
}
