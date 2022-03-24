/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myrian
 */
public class CalendarioBD extends ActividadMD {

    Conect conectar = new Conect();

    public CalendarioBD() {
    }

    public CalendarioBD(String id_Carrera, int id_Periodo, int id_TipoActividad, int id_Actividad, String Nombre_Actividad, String Responsables, String Descripcion, String Fecha_Inicio, String Fecha_Limite) {
        super(id_Carrera, id_Periodo, id_TipoActividad, id_Actividad, Nombre_Actividad, Responsables, Descripcion, Fecha_Inicio, Fecha_Limite);
    }

    public List<ActividadMD> mostrardatos() {
        List<ActividadMD> listaA = new ArrayList<ActividadMD>();
        try {
            String sql = "select * from calendario";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                ActividadMD m = new ActividadMD();
                m.setId_Carrera(rs.getString("id_carrera"));
                m.setId_Periodo(rs.getInt("id_periodo"));
                m.setid_TipoActividad(rs.getInt("id_tipoactividad"));
                m.setId_Actividad(rs.getInt("id_actividad"));
                m.setNombre_Actividad(rs.getString("nombre_actividad"));
                m.setResponsables(rs.getString("responsables"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setFecha_Inicio(rs.getString("fecha_inicio"));
                m.setFecha_Limite(rs.getString("fecha_limite"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean guardar() {
        String nsql = "INSERT INTO calendario(id_carrera,id_periodo,id_tipoactividad,id_actividad,nombre_actividad,responsables,descripcion,fecha_inicio,fecha_limite)" + "VALUES ('"
                + getId_Carrera() + "','" + getId_Periodo() + "','" + getid_TipoActividad() + "','" + getId_Actividad() + "','" + getNombre_Actividad() + "','" + getResponsables()
                + "','" + getDescripcion() + "','" + getFecha_Inicio() + "','" + getFecha_Limite() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String id_actividad) {
        //Transformo image a base64 encode para postgresl

        String nsql = "update calendario set id_carrera='" + getId_Carrera()+ "',id_periodo='" + getId_Periodo() + "',id_tipoactividad='" + getId_TipoActividad()+ "',nombre_actividad='" + getNombre_Actividad() + 
                "',responsables='" + getResponsables() + "',descripcion='" + getDescripcion() + "',fecha_inicio='" + getFecha_Inicio() + "',fecha_limite='" + getFecha_Limite()+ "'"
                + " where id_actividad='" + id_actividad + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");
            return false;
        }

    }
    public List<CalendarioMD> obtenerDatos(String id_actividad) {
        List<CalendarioMD> listaA = new ArrayList<CalendarioMD>();
        try {
            String sql = "select * from calendario" + " where cedula='"+id_actividad+"'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                ActividadMD m = new ActividadMD();
                m.setId_Carrera(rs.getString("id_carrera"));
                m.setId_Periodo(rs.getInt("id_periodo"));
                m.setid_TipoActividad(rs.getInt("id_tipoactividad"));
                m.setId_Actividad(rs.getInt("id_actividad"));
                m.setNombre_Actividad(rs.getString("nombre_actividad"));
                m.setResponsables(rs.getString("responsables"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setFecha_Inicio(rs.getString("fecha_inicio"));
                m.setFecha_Limite(rs.getString("fecha_limite"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }
}
