/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_AreaCarrera;
import POA.Vista.Vis_Asignacion;
import POA.Vista.Vis_Calendar;
import POA.Vista.Vis_Perfil;
import POA.Vista.Vis_Permisos;
import POA.Vista.Vis_Principal;
import POA.Vista.Vis_Roles;
import POA.Vista.Vis_Carrera;
import POA.Vista.Vis_Usuario;
import POA.Vista.vis_Docentes;
import POA.Vista.vis_PeriodoAcademico;
import POA.Vista.vis_Persona;
import POA.Vista.Vis_Materias;
import POA.Vista.Vis_Poa1;
import POA.Vista.vis_inicioSesion;
import POA.Vista.vis_poa_proyectos;
import POA.Vista.vis_poa_actividad;
import POA.Vista.vis_poa_evidencia;
import POA.Vista.vis_asignacionmateriadocentes;
import POA.Vista.vis_portafolio;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author USUARIO
 */
public class Con_principal {

    public static Vis_Principal vista;

    public Con_principal(Vis_Principal vista,String nom, String carr) {
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
         vista.getBtn_evidencias().addActionListener(e -> evidencia());
         vista.getBtn_periodos().addActionListener(e -> periodo());
         vista.getBtn_docentes().addActionListener(e -> docentes());
         vista.getBtn_materia().addActionListener(e -> materias());
         vista.getBtn_calendario().addActionListener(e-> calendario());
         vista.getBtn_AreaCarrera().addActionListener(e-> areaCarrera());
         vista.getBtn_asignaciondocentes().addActionListener(e -> asignaciondocentes());
         vista.getBtnPortafolio().addActionListener(e-> portafolio());
         vista.getLbUsuario().setText(nom);
         vista.getLbCarrera().setText(carr);
    }

    private void portafolio(){
        vis_portafolio port = new vis_portafolio();
        vista.getESCRITORIO().add(port);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = port.getSize();
        port.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        con_portafolio p = new con_portafolio(port);
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
         Vis_Poa1 user = new Vis_Poa1();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_Poa1 us = new Con_Poa1(user);
    }
 
     private void evidencia() {
          vis_poa_evidencia user = new vis_poa_evidencia();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa_evidencia rol=new Con_poa_evidencia(user);

    }
     
     private void docentes() {
          vis_Docentes user = new vis_Docentes();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
       con_docentes rol=new con_docentes(user);

    }
     private void asignaciondocentes() {
         vis_asignacionmateriadocentes user = new vis_asignacionmateriadocentes();
        vista.getESCRITORIO().add(user);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_Asignacion_Docente rol=new Con_Asignacion_Docente(user);

    }

    private void materias() {
        Vis_Materias subject = new Vis_Materias();
        vista.getESCRITORIO().add(subject);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = subject.getSize();
        subject.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_Materia mate = new Con_Materia(subject);
    }
    private void calendario() {
        Vis_Calendar cale = new Vis_Calendar();
        Con_calendario calendario= new Con_calendario(cale);
        vista.getESCRITORIO().add(cale);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = cale.getSize();
        cale.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

    }
    
    private void areaCarrera() {
        Vis_AreaCarrera area = new Vis_AreaCarrera();
        Con_AreaCarrera acarrera = new Con_AreaCarrera(area);
        vista.getESCRITORIO().add(area);
        Dimension desktopSize = vista.getESCRITORIO().getSize();
        Dimension FrameSize = area.getSize();
        area.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    
}

