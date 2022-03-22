/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Asignacion;
import POA.Vista.Vis_Perfil;
import POA.Vista.Vis_Permisos;
import POA.Vista.Vis_Principal;
import POA.Vista.Vis_Roles;
import POA.Vista.Vis_Carrera;
import POA.Vista.Vis_Usuario;
import POA.Vista.vis_PeriodoAcademico;
import POA.Vista.vis_Persona;
import POA.Vista.vis_inicioSesion;
import POA.Vista.vis_poa;
import POA.Vista.vis_poa_actividad;
import POA.Vista.vis_poa_evidencia;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author USUARIO
 */
public class Con_principal {

    public static Vis_Principal vista;

    public Con_principal(Vis_Principal vista) {
       this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getBtn_perfil().addActionListener(e -> perfil());
        vista.getBtn_persona().addActionListener(e -> persona());
        vista.getBtn_roles().addActionListener(e -> roles());
        vista.getBtn_salir().addActionListener(e -> salir());
        vista.getBtn_usuario().addActionListener(e -> usuario());
        vista.getBtn_asignacion().addActionListener(e -> asignacion());
        vista.getBtn_carrera().addActionListener(e -> carrera());
        vista.getBtn_poa().addActionListener(e -> poa());
        vista.getBtn_actividades().addActionListener(e -> actividad());
         vista.getBtn_evidencias().addActionListener(e -> evidencia());
         vista.getBtn_periodos().addActionListener(e -> periodo());
    }

    private void periodo(){
        vis_PeriodoAcademico periodo = new vis_PeriodoAcademico();
        vista.getESCRITORIO().add(periodo);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = periodo.getSize();
        periodo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        con_periodoAcademico peri = new con_periodoAcademico(periodo);
    }
    private void perfil() {
        Vis_Perfil zap = new Vis_Perfil();
        vista.getESCRITORIO().add(zap);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = zap.getSize();
        zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_perfil zapatos = new Con_perfil(zap);

    }

    private void persona() {
        vis_Persona persona = new vis_Persona();
        Con_persona per = new Con_persona(persona);
        vista.getESCRITORIO().add(persona);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = persona.getSize();
        persona.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        

    }

    private void roles() {
        Vis_Roles user = new Vis_Roles();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_rol rol=new Con_rol(user);
    }
    
    

    private void salir() {
        vis_inicioSesion inicios = new vis_inicioSesion();
        vista.setVisible(false);
        inicios.setVisible(true);
        Con_inicio inicio = new Con_inicio(inicios);
    }

    private void usuario() {
        Vis_Usuario user = new Vis_Usuario();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        cont_usuario us = new cont_usuario(user);
    }

    private void asignacion() {
        Vis_Asignacion user = new Vis_Asignacion();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        ControladorAsignacion rol=new ControladorAsignacion(user);
    }   
     private void carrera() {
        Vis_Carrera carrera = new Vis_Carrera();
       
        vista.getESCRITORIO().add(carrera);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = carrera.getSize();
        carrera.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
         con_carrera concarrera = new con_carrera(carrera);

    }
     
     private void poa() {
         vis_poa user = new vis_poa();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa us = new Con_poa(user);
    }

    private void actividad() {
        vis_poa_actividad user = new vis_poa_actividad();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
       Con_poa_actividad rol=new Con_poa_actividad(user);
    }   
     private void evidencia() {
          vis_poa_evidencia user = new vis_poa_evidencia();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa_evidencia rol=new Con_poa_evidencia(user);

    }
}

