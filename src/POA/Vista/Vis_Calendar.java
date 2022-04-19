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



    public JButton getBtn_prueba() {
        return btn_prueba;
    }

    public void setBtn_prueba(JButton btn_prueba) {
        this.btn_prueba = btn_prueba;
    }


    public JButton getBtn_responsables() {
        return btn_responsables;
    }

    public void setBtn_responsables(JButton btn_responsables) {
        this.btn_responsables = btn_responsables;
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

    public JButton getBtn_añadir_Tactividad() {
        return Btn_añadir_Tactividad;
    }

    public void setBtn_añadir_Tactividad(JButton Btn_añadir_Tactividad) {
        this.Btn_añadir_Tactividad = Btn_añadir_Tactividad;
    }

    public JButton getD_Btn_Cancelar() {
        return D_Btn_Cancelar;
    }

    public void setD_Btn_Cancelar(JButton D_Btn_Cancelar) {
        this.D_Btn_Cancelar = D_Btn_Cancelar;
    }

    public JButton getD_Btn_Guardar() {
        return D_Btn_Guardar;
    }

    public void setD_Btn_Guardar(JButton D_Btn_Guardar) {
        this.D_Btn_Guardar = D_Btn_Guardar;
    }

    public JTextField getD_txt_Descripcion() {
        return D_txt_Descripcion;
    }

    public void setD_txt_Descripcion(JTextField D_txt_Descripcion) {
        this.D_txt_Descripcion = D_txt_Descripcion;
    }

    public JTextField getD_txt_Nombre() {
        return D_txt_Nombre;
    }

    public void setD_txt_Nombre(JTextField D_txt_Nombre) {
        this.D_txt_Nombre = D_txt_Nombre;
    }

    public JTextField getD_txt_idTipoA() {
        return D_txt_idTipoA;
    }

    public void setD_txt_idTipoA(JTextField D_txt_idTipoA) {
        this.D_txt_idTipoA = D_txt_idTipoA;
    }

    public JDialog getT_Actividad_D() {
        return T_Actividad_D;
    }

    public void setT_Actividad_D(JDialog T_Actividad_D) {
        this.T_Actividad_D = T_Actividad_D;
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        combo_tipo_actividad_repor = new javax.swing.JComboBox();
        btn_cancelar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        T_Actividad_D = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        D_txt_idTipoA = new javax.swing.JTextField();
        D_txt_Nombre = new javax.swing.JTextField();
        D_txt_Descripcion = new javax.swing.JTextField();
        D_Btn_Guardar = new javax.swing.JButton();
        D_Btn_Cancelar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id_A = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_responsables = new javax.swing.JTextField();
        txt_N_actividad = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        combo_actividad = new javax.swing.JComboBox();
        combo_periodo = new javax.swing.JComboBox();
        comobo_carrera = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_añadir_Tactividad = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Fecha_inicio = new com.toedter.calendar.JDateChooser();
        Fecha_limite = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_calendario = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_responsables = new javax.swing.JButton();
        btn_prueba = new javax.swing.JButton();
        btn_n_actividad = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_responsable = new javax.swing.JTable();
        Jl_evidencia = new javax.swing.JLabel();
        btn_evidencia = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        Imprimir_D.setTitle("Reporte ");
        Imprimir_D.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SELECCIONE EL TIPO DE ACTIVIDAD PARA EL REPORTE");
        Imprimir_D.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 52, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TIPO ACTIVIDAD:");
        Imprimir_D.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 127, -1, -1));

        btn_aceptar.setText("ACEPTAR");
        Imprimir_D.getContentPane().add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        Imprimir_D.getContentPane().add(combo_tipo_actividad_repor, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 122, 179, -1));

        btn_cancelar.setText("CANCELAR");
        Imprimir_D.getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        Imprimir_D.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 559, 250));

        T_Actividad_D.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Id Tipo Actividad:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Descripción:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        D_txt_idTipoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_txt_idTipoAActionPerformed(evt);
            }
        });
        jPanel4.add(D_txt_idTipoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 175, -1));
        jPanel4.add(D_txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 175, -1));
        jPanel4.add(D_txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 175, -1));

        D_Btn_Guardar.setText("Añadir");
        jPanel4.add(D_Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        D_Btn_Cancelar.setText("Cancelar");
        D_Btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_Btn_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(D_Btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (1).jpg"))); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 270));

        T_Actividad_D.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 270));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id actividad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 15, -1, -1));

        txt_id_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_AActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 12, 150, -1));

        jLabel2.setText("Nombre Carrera:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 58, -1, -1));

        jLabel3.setText("Tipo actividad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setText("Periodo Académico:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 108, -1, -1));

        jLabel8.setText("Nombre de la actividad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel11.setText("Descripción:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jLabel13.setText("Responsables de la actividad:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));
        jPanel1.add(txt_responsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 240, -1));
        jPanel1.add(txt_N_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 150, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/delete.jpg"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, -1, -1));

        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        btn_añadir.setToolTipText("Agregar");
        jPanel1.add(btn_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 230, 110));

        combo_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_actividadActionPerformed(evt);
            }
        });
        jPanel1.add(combo_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 148, 30));

        jPanel1.add(combo_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 105, 148, 20));

        jPanel1.add(comobo_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 55, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "responsables"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 240, 120));

        Btn_añadir_Tactividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        Btn_añadir_Tactividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_añadir_TactividadActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_añadir_Tactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel14.setText("Fecha inicio:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        jLabel15.setText("Fecha limite:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 20));

        Fecha_inicio.setDateFormatString("yyyy-MM-dd hh:mm:ss");
        jPanel1.add(Fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 190, 20));

        Fecha_limite.setDateFormatString("yyyy-MM-dd hh:mm:ss");
        jPanel1.add(Fecha_limite, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 190, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 117, 430, 700));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CALENDARIO ACADÉMICO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 760));

        Tabla_calendario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Num  Actividad", "Carrera", "Periodo Academico", "Tipo Actividad", "Nombre Actividad", "Descripcion", "Fecha Inicio", "Fecha Limite"
            }
        ));
        jScrollPane3.setViewportView(Tabla_calendario);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Lista de actividades");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel16)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 890, 350));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Imprimir"));

        btn_responsables.setText("RESPONSABLES");
        btn_responsables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_responsablesActionPerformed(evt);
            }
        });

        btn_prueba.setText("ACTIVIDADES");
        btn_prueba.setToolTipText("Reporte");
        btn_prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(btn_prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_responsables, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_responsables, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btn_prueba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 270, 80));

        btn_n_actividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        btn_n_actividad.setText("Crear Actividad");
        getContentPane().add(btn_n_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar");
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, -1, -1));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setText("Lista Responsables ");

        tabla_responsable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Actividad", "Responsable"
            }
        ));
        jScrollPane1.setViewportView(tabla_responsable);

        Jl_evidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel17))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(Jl_evidencia)
                    .addContainerGap(444, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(159, Short.MAX_VALUE)
                    .addComponent(Jl_evidencia)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 890, 320));

        btn_evidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/subir.png"))); // NOI18N
        btn_evidencia.setToolTipText("Subir evidencia");
        getContentPane().add(btn_evidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 60, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/fondo azul (2).jpg"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void D_txt_idTipoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_txt_idTipoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D_txt_idTipoAActionPerformed

    private void btn_pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pruebaActionPerformed

    private void btn_responsablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_responsablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_responsablesActionPerformed

    private void Btn_añadir_TactividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_añadir_TactividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_añadir_TactividadActionPerformed

    private void combo_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_actividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_actividadActionPerformed

    private void txt_id_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_AActionPerformed

    private void D_Btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_Btn_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D_Btn_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_añadir_Tactividad;
    private javax.swing.JButton D_Btn_Cancelar;
    private javax.swing.JButton D_Btn_Guardar;
    private javax.swing.JTextField D_txt_Descripcion;
    private javax.swing.JTextField D_txt_Nombre;
    private javax.swing.JTextField D_txt_idTipoA;
    private com.toedter.calendar.JDateChooser Fecha_inicio;
    private com.toedter.calendar.JDateChooser Fecha_limite;
    private javax.swing.JDialog Imprimir_D;
    private javax.swing.JLabel Jl_evidencia;
    private javax.swing.JDialog T_Actividad_D;
    private javax.swing.JTable Tabla_calendario;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_evidencia;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_n_actividad;
    private javax.swing.JButton btn_prueba;
    private javax.swing.JButton btn_responsables;
    private javax.swing.JComboBox combo_actividad;
    private javax.swing.JComboBox combo_periodo;
    private javax.swing.JComboBox combo_tipo_actividad_repor;
    private javax.swing.JComboBox<String> comobo_carrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
