/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author HP
 */
public class vis_poa_proyectos extends javax.swing.JInternalFrame {

    /**
     * Creates new form vis_poa
     */
    public vis_poa_proyectos() {
        initComponents();
    }

    

    public JTable getTabla_lista_proyectos() {
        return Tabla_lista_proyectos;
    }

    public void setTabla_lista_proyectos(JTable Tabla_lista_proyectos) {
        this.Tabla_lista_proyectos = Tabla_lista_proyectos;
    }

    public JTable getTabla_proyecto() {
        return Tabla_proyecto;
    }

    public void setTabla_proyecto(JTable Tabla_proyecto) {
        this.Tabla_proyecto = Tabla_proyecto;
    }

    

    public JToggleButton getBtnAñadir() {
        return btnAñadir;
    }

    public void setBtnAñadir(JToggleButton btnAñadir) {
        this.btnAñadir = btnAñadir;
    }

    public JToggleButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public void setBtnSiguiente(JToggleButton btnSiguiente) {
        this.btnSiguiente = btnSiguiente;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JToggleButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JToggleButton btn_guardar) {
        this.btn_guardar = btn_guardar;
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

    public JTextField getTxt_estrategia() {
        return txt_estrategia;
    }

    public void setTxt_estrategia(JTextField txt_estrategia) {
        this.txt_estrategia = txt_estrategia;
    }

    public JTextField getTxt_obestra() {
        return txt_obestra;
    }

    public void setTxt_obestra(JTextField txt_obestra) {
        this.txt_obestra = txt_obestra;
    }

    public JTextField getTxt_obtac() {
        return txt_obtac;
    }

    public void setTxt_obtac(JTextField txt_obtac) {
        this.txt_obtac = txt_obtac;
    }

    public JTextArea getTxtarea_obopera() {
        return txtarea_obopera;
    }

    public void setTxtarea_obopera(JTextArea txtarea_obopera) {
        this.txtarea_obopera = txtarea_obopera;
    }

    public JTextField getN_proyectos() {
        return n_proyectos;
    }

    public void setN_proyectos(JTextField n_proyectos) {
        this.n_proyectos = n_proyectos;
    }

    public JButton getBtn_imprimir() {
        return btn_imprimir;
    }

    public void setBtn_imprimir(JButton btn_imprimir) {
        this.btn_imprimir = btn_imprimir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_obestra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnAñadir = new javax.swing.JToggleButton();
        txt_obtac = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_lista_proyectos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_estrategia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        n_proyectos = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarea_obopera = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_proyecto = new javax.swing.JTable();
        btn_guardar = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        btn_imprimir = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("OBJETIVO OPÉRATIVO:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 316, -1, 30));

        jLabel9.setText("OBJETIVO ESTRATÉGICO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));
        getContentPane().add(txt_obestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 270, 20));

        jLabel10.setText("OBJETIVO TÁCTICO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        btnAñadir.setText("Añadir Objetivo");
        btnAñadir.setBorderPainted(false);
        btnAñadir.setContentAreaFilled(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 390, -1, -1));
        getContentPane().add(txt_obtac, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 270, -1));

        Tabla_lista_proyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CARRERA", "ANIOS", "ESTADO"
            }
        ));
        jScrollPane2.setViewportView(Tabla_lista_proyectos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 430, 230));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("LISTA PROYECTOS:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jLabel14.setText("ESTRATEGIA");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));
        getContentPane().add(txt_estrategia, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 270, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("PROYECTOS:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jLabel15.setText("Eliminar");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel16.setText("Modificar");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel17.setText("Nuevo");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/WhatsApp Image 2022-02-15 at 00.32.29.jpeg"))); // NOI18N
        jPanel2.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 40, 40));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 50, 40));

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/nuevo.png"))); // NOI18N
        jPanel2.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 40, 40));
        jPanel2.add(n_proyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 30, -1));

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/siguiente.png"))); // NOI18N
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setContentAreaFilled(false);
        jPanel2.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 60, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 270, 50));

        txtarea_obopera.setColumns(20);
        txtarea_obopera.setRows(5);
        jPanel3.add(txtarea_obopera, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 220, 70));

        Tabla_proyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NUMERO", "OBJETIVO "
            }
        ));
        jScrollPane1.setViewportView(Tabla_proyecto);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 490, 90));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 510, 250));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btn_guardar.setBorderPainted(false);
        btn_guardar.setContentAreaFilled(false);
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 50, 40));

        jLabel12.setText("Guardar");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/impresion.png"))); // NOI18N
        jPanel2.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 40, 40));

        jLabel18.setText("Imprimir");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 560, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAñadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_lista_proyectos;
    private javax.swing.JTable Tabla_proyecto;
    private javax.swing.JToggleButton btnAñadir;
    private javax.swing.JToggleButton btnSiguiente;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JToggleButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField n_proyectos;
    private javax.swing.JTextField txt_estrategia;
    private javax.swing.JTextField txt_obestra;
    private javax.swing.JTextField txt_obtac;
    private javax.swing.JTextArea txtarea_obopera;
    // End of variables declaration//GEN-END:variables
}
