/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;
import POA.Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Renato Llivisaca
 */
public class T_ActividadBD extends T_actividadMD{
      Conect conectar = new Conect();
    public T_ActividadBD() {
    }

    public T_ActividadBD(int id_T_actividad, String Nombre, String Descripcion) {
        super(id_T_actividad, Nombre, Descripcion);
    }

    
    
      public boolean guardarTActividad() {
        String nsql = "INSERT INTO tipo_actividad(id_tipoactividad,nombre_tipo_actividad,descripcion)" + "VALUES ('"
                + getId_T_actividad() + "','" + getNombre() + "','"+ getDescripcion()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
      
       public int codigo() {
        try {
            int c = 0;
            String sql = "select max(id_tipoactividad) as id_tipoactividad from tipo_actividad";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("id_tipoactividad");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
       
        public List<T_actividadMD> mostrardatos() {
        List<T_actividadMD> listaA = new ArrayList<T_actividadMD>();
        try {
            String sql = "select * from tipo_actividad";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                T_actividadMD m = new T_actividadMD();
                m.setId_T_actividad(rs.getInt("id_tipoactividad"));
                m.setNombre(rs.getString("nombre_tipo_actividad"));
                m.setDescripcion(rs.getString("descripcion"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
        public List<T_actividadMD> obtenerDatos(int id) {
        List<T_actividadMD> listaA = new ArrayList<T_actividadMD>();
        try {
            String sql = "select * from tipo_actividad" + " where id_tipoactividad ='"+ id +"'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                T_actividadMD m = new T_actividadMD();
                m.setId_T_actividad(rs.getInt("id_tipoactividad"));
                m.setNombre(rs.getString("nombre_tipo_actividad"));
                m.setDescripcion(rs.getString("descripcion"));
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
