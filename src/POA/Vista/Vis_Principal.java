/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author USUARIO
 */
public class Vis_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Vista_inicio
     */
    public Vis_Principal() {
        initComponents();

    }

    public JDesktopPane getESCRITORIO() {
        return ESCRITORIO;
    }

    public void setESCRITORIO(JDesktopPane ESCRITORIO) {
        this.ESCRITORIO = ESCRITORIO;
    }

    public JMenuItem getBtn_asignaciondocentes() {
        return btn_asignaciondocentes;
    }

    public void setBtn_asignaciondocentes(JMenuItem btn_asignaciondocentes) {
        this.btn_asignaciondocentes = btn_asignaciondocentes;
    }

    public JMenuItem getBtn_asignacion() {
        return btn_asignacion;
    }

    public void setBtn_asignacion(JMenuItem btn_asignacion) {
        this.btn_asignacion = btn_asignacion;
    }

    public JMenuItem getBtn_carrera() {
        return btn_carrera;
    }

    public void setBtn_carrera(JMenuItem btn_carrera) {
        this.btn_carrera = btn_carrera;
    }

    public JMenuItem getBtn_evidencias() {
        return btn_evidencias;
    }

    public void setBtn_evidencias(JMenuItem btn_evidencias) {
        this.btn_evidencias = btn_evidencias;
    }

    public JMenuItem getBtn_perfil() {
        return btn_perfil;
    }

    public void setBtn_perfil(JMenuItem btn_perfil) {
        this.btn_perfil = btn_perfil;
    }

    public JMenuItem getBtn_periodos() {
        return btn_periodos;
    }

    public void setBtn_periodos(JMenuItem btn_periodos) {
        this.btn_periodos = btn_periodos;
    }

    public JMenuItem getBtn_permisos() {
        return btn_permisos;
    }

    public void setBtn_permisos(JMenuItem btn_permisos) {
        this.btn_permisos = btn_permisos;
    }

    public JMenuItem getBtn_persona() {
        return btn_persona;
    }

    public void setBtn_persona(JMenuItem btn_persona) {
        this.btn_persona = btn_persona;
    }

    public JMenuItem getBtn_poa() {
        return btn_poa;
    }

    public void setBtn_poa(JMenuItem btn_poa) {
        this.btn_poa = btn_poa;
    }

    public JMenuItem getBtn_roles() {
        return btn_roles;
    }

    public void setBtn_roles(JMenuItem btn_roles) {
        this.btn_roles = btn_roles;
    }

    public JMenuItem getBtn_salir() {
        return btn_salir;
    }

    public void setBtn_salir(JMenuItem btn_salir) {
        this.btn_salir = btn_salir;
    }

    public JMenuItem getBtn_usuario() {
        return btn_usuario;
    }

    public void setBtn_usuario(JMenuItem btn_usuario) {
        this.btn_usuario = btn_usuario;
    }

    public JMenuItem getBtn_docentes() {
        return btn_docentes;
    }

    public void setBtn_docentes(JMenuItem btn_docentes) {
        this.btn_docentes = btn_docentes;
    }

    public JMenuItem getBtn_materia() {
        return btn_materia;
    }

    public void setBtn_materia(JMenuItem btn_materia) {
        this.btn_materia = btn_materia;
    }

    public JMenuItem getBtn_calendario() {
        return btn_calendario;
    }

    public void setBtn_calendario(JMenuItem btn_calendario) {
        this.btn_calendario = btn_calendario;
    }

    public JMenuItem getBtn_AreaCarrera() {
        return Btn_AreaCarrera;
    }

    public void setBtn_AreaCarrera(JMenuItem Btn_AreaCarrera) {
        this.Btn_AreaCarrera = Btn_AreaCarrera;
    }

    public JMenu getMenuPortafolio() {
        return menuPortafolio;
    }

    public void setMenuPortafolio(JMenu menuPortafolio) {
        this.menuPortafolio = menuPortafolio;
    }

    public JMenuItem getBtnPortafolio() {
        return btnPortafolio;
    }

    public void setBtnPortafolio(JMenuItem btnPortafolio) {
        this.btnPortafolio = btnPortafolio;
    }

   

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ESCRITORIO = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MENU_USUARIO = new javax.swing.JMenu();
        btn_usuario = new javax.swing.JMenuItem();
        btn_salir = new javax.swing.JMenuItem();
        MENU_ACADEMICO = new javax.swing.JMenu();
        btn_perfil = new javax.swing.JMenuItem();
        btn_asignacion = new javax.swing.JMenuItem();
        btn_persona = new javax.swing.JMenuItem();
        btn_roles = new javax.swing.JMenuItem();
        btn_carrera = new javax.swing.JMenuItem();
        btn_permisos = new javax.swing.JMenuItem();
        btn_periodos = new javax.swing.JMenuItem();
        btn_docentes = new javax.swing.JMenuItem();
        btn_materia = new javax.swing.JMenuItem();
        Btn_AreaCarrera = new javax.swing.JMenuItem();
        btn_asignaciondocentes = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btn_poa = new javax.swing.JMenuItem();
        btn_evidencias = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btn_calendario = new javax.swing.JMenuItem();
        menuPortafolio = new javax.swing.JMenu();
        btnPortafolio = new javax.swing.JMenuItem();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/ISTA.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/logo2222.png"))); // NOI18N

        ESCRITORIO.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ESCRITORIOLayout = new javax.swing.GroupLayout(ESCRITORIO);
        ESCRITORIO.setLayout(ESCRITORIOLayout);
        ESCRITORIOLayout.setHorizontalGroup(
            ESCRITORIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ESCRITORIOLayout.createSequentialGroup()
                .addGap(0, 740, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );
        ESCRITORIOLayout.setVerticalGroup(
            ESCRITORIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ESCRITORIOLayout.createSequentialGroup()
                .addGap(0, 398, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N

        MENU_USUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_Cat_Profile_25px.png"))); // NOI18N
        MENU_USUARIO.setText("USUARIO");

        btn_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icono_agregar.png"))); // NOI18N
        btn_usuario.setText("Nuevo");
        btn_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuarioActionPerformed(evt);
            }
        });
        MENU_USUARIO.add(btn_usuario);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_Double_Left_20px.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        MENU_USUARIO.add(btn_salir);

        jMenuBar1.add(MENU_USUARIO);

        MENU_ACADEMICO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/consulta_silabo.png"))); // NOI18N
        MENU_ACADEMICO.setText("ACADEMICO");

        btn_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_School_Director_20px.png"))); // NOI18N
        btn_perfil.setText("Perfil");
        btn_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perfilActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(btn_perfil);

        btn_asignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/consultar_silabo_menu.png"))); // NOI18N
        btn_asignacion.setText("Asignacion");
        MENU_ACADEMICO.add(btn_asignacion);

        btn_persona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_User_20px.png"))); // NOI18N
        btn_persona.setText("Persona");
        btn_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_personaActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(btn_persona);

        btn_roles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_User_Groups_20px.png"))); // NOI18N
        btn_roles.setText("Roles");
        btn_roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rolesActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(btn_roles);

        btn_carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_Permanent_Job_20px.png"))); // NOI18N
        btn_carrera.setText("Carrera");
        MENU_ACADEMICO.add(btn_carrera);

        btn_permisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POA/Vista/img/icons8_Report_Card_20px.png"))); // NOI18N
        btn_permisos.setText("Permisos");
        MENU_ACADEMICO.add(btn_permisos);

        btn_periodos.setText("Periodo_Academico");
        btn_periodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_periodosActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(btn_periodos);

        btn_docentes.setText("Docentes");
        MENU_ACADEMICO.add(btn_docentes);

        btn_materia.setText("Materias");
        btn_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_materiaActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(btn_materia);

        Btn_AreaCarrera.setText("Areas de Carrera");
        Btn_AreaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AreaCarreraActionPerformed(evt);
            }
        });
        MENU_ACADEMICO.add(Btn_AreaCarrera);

        btn_asignaciondocentes.setText("Asignacion Docentes");
        MENU_ACADEMICO.add(btn_asignaciondocentes);

        jMenuBar1.add(MENU_ACADEMICO);

        jMenu1.setText("POA");

        btn_poa.setText("INICIO");
        jMenu1.add(btn_poa);

        btn_evidencias.setText("EVIDENCIAS");
        jMenu1.add(btn_evidencias);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Calendario");

        btn_calendario.setText("Nuevo");
        jMenu2.add(btn_calendario);

        jMenuBar1.add(jMenu2);

        menuPortafolio.setText("Portafolio");

        btnPortafolio.setText("Portafolios");
        menuPortafolio.add(btnPortafolio);

        jMenuBar1.add(menuPortafolio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ESCRITORIO)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ESCRITORIO)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_personaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_personaActionPerformed

    private void btn_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perfilActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_perfilActionPerformed

    private void btn_rolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rolesActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rolesActionPerformed

    private void btn_periodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_periodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_periodosActionPerformed

    private void btn_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_materiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_materiaActionPerformed

    private void Btn_AreaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AreaCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AreaCarreraActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Btn_AreaCarrera;
    public static javax.swing.JDesktopPane ESCRITORIO;
    private javax.swing.JMenu MENU_ACADEMICO;
    private javax.swing.JMenu MENU_USUARIO;
    private javax.swing.JMenuItem btnPortafolio;
    private javax.swing.JMenuItem btn_asignacion;
    private javax.swing.JMenuItem btn_asignaciondocentes;
    private javax.swing.JMenuItem btn_calendario;
    private javax.swing.JMenuItem btn_carrera;
    private javax.swing.JMenuItem btn_docentes;
    private javax.swing.JMenuItem btn_evidencias;
    private javax.swing.JMenuItem btn_materia;
    private javax.swing.JMenuItem btn_perfil;
    private javax.swing.JMenuItem btn_periodos;
    private javax.swing.JMenuItem btn_permisos;
    private javax.swing.JMenuItem btn_persona;
    private javax.swing.JMenuItem btn_poa;
    private javax.swing.JMenuItem btn_roles;
    private javax.swing.JMenuItem btn_salir;
    private javax.swing.JMenuItem btn_usuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuPortafolio;
    // End of variables declaration//GEN-END:variables
}
