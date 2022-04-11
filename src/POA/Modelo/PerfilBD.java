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
import org.postgresql.util.Base64;

/**
 *
 * @author Usuario
 */
public class PerfilBD extends PerfilMD {

    Conect conectar = new Conect();

    public PerfilBD(int codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }

    public PerfilBD() {
    }

    public int codigo() {
        try {
            int c = 0;
            String sql = "select max(codigo) as codigo from perfil";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("codigo");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<PerfilMD> mostrardatos() {
        try {
            List<PerfilMD> lista = new ArrayList<PerfilMD>();
            String sql = "select * from perfil";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PerfilMD perfil = new PerfilMD();
                perfil.setCodigo(rs.getInt("codigo"));
                perfil.setNombre(rs.getString("nombre"));
                perfil.setDescripcion(rs.getString("descripcion"));
                lista.add(perfil);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<PerfilMD> obtenerdatos(String identificador) {
        try {
            List<PerfilMD> lista = new ArrayList<PerfilMD>();
            String sql = "select * from perfil" + " where \"codigo\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PerfilMD perfil = new PerfilMD();
                perfil.setCodigo(rs.getInt("codigo"));
                perfil.setNombre(rs.getString("nombre"));
                perfil.setDescripcion(rs.getString("descripcion"));
                lista.add(perfil);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() {
        String sql = "INSERT INTO perfil(nombre, descripcion)" + "VALUES ('" + getNombre() + "','" + getDescripcion() + "')";
        System.out.println(sql);
        
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
        public boolean modificar(int identificador) {
        String sql = "update perfil set \"nombre\"='"+getNombre()+ "',\"descripcion\"='" + getDescripcion()+"'"
                + " where \"codigo\"= " + identificador + ";";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error al editar");

            return false;
        }
    }
    public boolean eliminar(int identificador){
        String sql = "delete from perfil where \"codigo\"=" + identificador + ";";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }
    public int mostrarIdPerfil(String nombre) {
        int idPerfil=0;
        String sql="select codigo from perfil where nombre= '" + nombre+ "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPerfil=rs.getInt("codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPerfil;
    }
    
        public String mostrarIdCarrera(String nombre) {
        String idCarrera="";
        String sql="select codigo from carrera where nombre= '" + nombre+ "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idCarrera=rs.getString("codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCarrera;
    }
     public String mostrarIdDocente(String nombre) {
        String idDocente="";
        
        String sql="select nombres ||' '|| apellidos as nombre  from persona where cedula= '" + nombre+ "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idDocente=rs.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idDocente;
    }
     public int verificarPerfil(String carrera,int perfil) {
        int idPerfil=0;
        
        String sql="select * from area_carrera where carrera= '" + carrera+ "' and perfil = " + perfil;
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPerfil++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPerfil;
    }  
    public int verificarResponsable(String carrera,String cedula) {
        int idPerfil=0;
        
        String sql="select * from area_carrera where carrera= '" + carrera+ "' and responsable = '" + cedula +"'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPerfil++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPerfil;
    } 
    public int vPerfil(int codigo, String carrera,int cedula) {
        int idPerfil=0;
        
        String sql="select * from area_carrera where id_area= " + codigo+ " and carrera='" + carrera + "' and perfil =" + cedula;
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPerfil++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPerfil;
    } 
    public int vResponsable(int codigo, String carrera,String cedula) {
        int idPerfil=0;
        
        String sql="select * from area_carrera where id_area= " + codigo+ " and carrera='" + carrera + "' and responsable = '" + cedula +"'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPerfil++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPerfil;
    } 
}
