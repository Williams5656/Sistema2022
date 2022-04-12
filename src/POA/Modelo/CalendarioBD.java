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

     public List<CalendarioMD> mostrardatos() {
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
   
    public List<CalendarioMD> obtenerDatos(int id_actividad) {
        List<CalendarioMD> listaA = new ArrayList<CalendarioMD>();
        try {
            String sql = "select * from calendario" + " where \"id_actividad\"='" + id_actividad + "'";
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

    public boolean modificar(int id_actividad) {
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
    
        public String validar_nombre(String nombre) {
            String n ="";
        try {
            String sql1 ="Select DISTINCT nombre_actividad as nombres \n" + "from calendario" +
               " where nombre_actividad = '"+nombre+"'";
            ResultSet rs = conectar.query(sql1);
            while (rs.next()) {
                n = (rs.getString("nombres"));
            }
            rs.close();
            return n;
        } catch (Exception e) {
            Logger.getLogger(Responsables_ActividadBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
         public int validar_Nombre_act() {

        int fila = 0;
        try {
            System.out.println(getNombre_Actividad() + " nombre_actividad");
            String sql = "Select * from responsables_act nombre_actividad= '" + getNombre_Actividad() + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                fila++;
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(CalendarioBD.class.getName()).log(Level.SEVERE, null, ex);
            return fila;
        }
    }

//            public boolean validar_nombre(String nombre) {
//            String sql1 ="Select DISTINCT nombre_actividad as nombres \n" + "from calendario" +
//               " where nombre_actividad = '"+nombre+"'";
//
//            if (conectar.noQuery(sql1) == null) {
//            return false;
//        } else {
//            System.out.println("Error");
//            return true;
//        }
//    }
}
