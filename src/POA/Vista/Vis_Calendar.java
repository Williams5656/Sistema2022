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

    public JButton getBtn_actividades() {
        return btn_actividades;
    }

    public JButton getBtn_prueba() {
        return btn_prueba;
    }

    public void setBtn_prueba(JButton btn_prueba) {
        this.btn_prueba = btn_prueba;
    }

    public JButton getValidar_n() {
        return Validar_n;
    }

    public void setValidar_n(JButton Validar_n) {
        this.Validar_n = Validar_n;
    }

    public void setBtn_actividades(JButton btn_actividades) {
        this.btn_actividades = btn_actividades;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_tipo_actividad_repor = new javax.swing.JComboBox();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
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
        comobo_carrera = new javax.swing.JComboBox<String>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_añadir_Tactividad = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Fecha_inicio = new com.toedter.calendar.JDateChooser();
        Fecha_limite = new com.toedter.calendar.JDateChooser();
        Validar_n = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_calendario = new javax.swing.JTable();
        btn_evidencia = new javax.swing.JButton();
        Jl_evidencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_responsable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_n_actividad = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_actividades = new javax.swing.JButton();
        btn_responsables = new javax.swing.JButton();
        btn_prueba = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setText("SELECCIONE EL TIPO DE ACTIVIDAD PARA EL REPORTE");

        jLabel7.setText("TIPO ACTIVIDAD:");

        btn_cancelar.setText("CANCELAR");

        btn_aceptar.setText("ACEPTAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btn_aceptar)
                                .addGap(103, 103, 103)
                                .addComponent(btn_cancelar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_tipo_actividad_repor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(42, Short.MAX_VALUE))
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

        T_Actividad_D.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Id Tipo Actividad:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel10.setText("Nombre:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel12.setText("Descripción:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        D_txt_idTipoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_txt_idTipoAActionPerformed(evt);
            }
        });
        jPanel4.add(D_txt_idTipoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 175, -1));
        jPanel4.add(D_txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 175, -1));
        jPanel4.add(D_txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 175, -1));

        D_Btn_Guardar.setText("Añadir");
        jPanel4.add(D_Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        D_Btn_Cancelar.setText("Cancelar");
        jPanel4.add(D_Btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        T_Actividad_D.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 270));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 173, -1, -1));

        jLabel4.setText("Periodo Académico:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 108, -1, -1));

        jLabel8.setText("Nombre de la actividad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel11.setText("Descripción:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel13.setText("Responsables de la actividad:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));
        jPanel1.add(txt_responsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 210, -1));
        jPanel1.add(txt_N_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/delete.jpg"))); // NOI18N
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, -1, -1));

        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        jPanel1.add(btn_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 230, 110));

        combo_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_actividadActionPerformed(evt);
            }
        });
        jPanel1.add(combo_actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 170, 148, -1));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 210, 140));

        Btn_añadir_Tactividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        Btn_añadir_Tactividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_añadir_TactividadActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_añadir_Tactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jLabel14.setText("Fecha inicio:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 20));

        jLabel15.setText("Fecha limite:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        Fecha_inicio.setDateFormatString("yyyy-MM-dd hh:mm:ss");
        jPanel1.add(Fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 160, 20));

        Fecha_limite.setDateFormatString("yyyy-MM-dd hh:mm:ss");
        jPanel1.add(Fecha_limite, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 160, 20));

        Validar_n.setText("V");
        jPanel1.add(Validar_n, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, 440, 700));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel6.setText("CALENDARIO ACADÉMICO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 0, -1, -1));

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
                "Actividad", "Carrera", "Periodo Academico", "Tipo Actividad", "Nombre Actividad", "Descripcion", "Fecha Inicio", "Fecha Limite"
            }
        ));
        jScrollPane3.setViewportView(Tabla_calendario);

        btn_evidencia.setText("Subir evidencia");
        btn_evidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_evidenciaActionPerformed(evt);
            }
        });

        Jl_evidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabla_responsable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_actividad", "Responsable"
            }
        ));
        jScrollPane1.setViewportView(tabla_responsable);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Lista de actividades");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setText("Lista Responsables ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btn_evidencia))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel17)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_evidencia)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(Jl_evidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 920, 700));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Aciones"));

        btn_n_actividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        btn_n_actividad.setText("Crear Actividad");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/guardar.png"))); // NOI18N

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/modificar.png"))); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btn_n_actividad))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_n_actividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 250, 110));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Imprimir"));

        btn_actividades.setText("ACTIVIDADES");

        btn_responsables.setText("RESPONSABLES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btn_actividades, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_responsables, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_responsables, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_actividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 260, 80));

        btn_prueba.setText("IMP");
        getContentPane().add(btn_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_actividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_actividadActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_evidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_evidenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_evidenciaActionPerformed

    private void Btn_añadir_TactividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_añadir_TactividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_añadir_TactividadActionPerformed

    private void D_txt_idTipoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_txt_idTipoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D_txt_idTipoAActionPerformed

    private void txt_id_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_AActionPerformed


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
    private javax.swing.JButton Validar_n;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_actividades;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
