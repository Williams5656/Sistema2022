/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myrian
 */
public class CalendarioBD extends CalendarioMD {

    Conect conectar = new Conect();

    public CalendarioBD() {
    }

    public CalendarioBD(int id_Actividad, String id_Carrera, int id_Periodo, int id_TipoActividad, String Nombre_Actividad, String Descripcion, String Fecha_Inicio, String Fecha_Limite) {
        super(id_Actividad, id_Carrera, id_Periodo, id_TipoActividad, Nombre_Actividad, Descripcion, Fecha_Inicio, Fecha_Limite);
    }

   
    public List<CalendarioMD> obtenerDatos(String id_actividad) {
        List<CalendarioMD> listaA = new ArrayList<CalendarioMD>();
        try {
            String sql = "select * from calendario";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                CalendarioMD m = new CalendarioMD();
                m.setId_Actividad(rs.getInt("id_actividad"));
                m.setId_Carrera(rs.getString("id_carrera"));
                m.setId_Periodo(rs.getInt("id_periodo"));
                m.setid_TipoActividad(rs.getInt("id_tipoactividad"));
                m.setNombre_Actividad(rs.getString("nombre_actividad"));
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
   

    
     public int codigo() {
        try {
            int c = 0;
            String sql = "select max(id_responsable) as id_responsable from responsables_act";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("id_responsable");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
          public int codigo_act() {
        try {
            int c = 0;
            String sql = "select max(id_actividad) as id_actividad from calendario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("id_actividad");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO calendario(id_actividad,id_carrera,id_periodo,id_tipoactividad,nombre_actividad,descripcion,fecha_inicio,fecha_limite)" + "VALUES ('"
                + getId_Actividad() + "','" + getId_Carrera() + "','" + getId_Periodo() + "','" + getid_TipoActividad()  + "','" + getNombre_Actividad() + "','" + getDescripcion() + "','" + getFecha_Inicio() + "','" + getFecha_Limite() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(String id_actividad) {
        //Transformo image a base64 encode para postgresl

        String nsql = "update calendario set id_carrera='" + getId_Carrera()+ "',id_periodo='" + getId_Periodo() + "',id_tipoactividad='" + getid_TipoActividad()+ "',nombre_actividad='" + getNombre_Actividad() + 
                 "',descripcion='" + getDescripcion() + "',fecha_inicio='" + getFecha_Inicio() + "',fecha_limite='" + getFecha_Limite()+ "'"
                + " where id_actividad='" + id_actividad + "'";
        

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");
            return false;
        }

    }
    
    
}
