/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC FACTORY
 */
public class DocumentacionBD extends DocumentacionMD{
    Conect conectar = new Conect();

    public DocumentacionBD() {
    }

    public DocumentacionBD(int id_plan, int numero, String id_asignacion, String fecha, String guias, int horasGuia, String estado) {
        super(id_plan, numero, id_asignacion, fecha, guias, horasGuia, estado);
    }

   
    public List<DocumentacionMD> mostrardatos() {
        try {
            List<DocumentacionMD> lista = new ArrayList<DocumentacionMD>();
            String sql = "select * from documentacion";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DocumentacionMD doc = new DocumentacionMD();
                doc.setId_plan(rs.getInt("id_plan"));
                doc.setNumero(rs.getInt("numero"));
                doc.setId_asignacion(rs.getString("id_asignacion"));
                doc.setFecha(rs.getString("fecha"));
                doc.setGuias(rs.getString("guia"));
                doc.setHorasGuia(rs.getInt("hora_guias"));
                doc.setEstado(rs.getString("estado"));
                lista.add(doc);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<DocumentacionMD> obtenerdatos(int id_plan) {
        try {
            List<DocumentacionMD> lista = new ArrayList<DocumentacionMD>();
            String sql = "select * from documentacion" + " where id_plan =" + id_plan + "";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                DocumentacionMD doc = new DocumentacionMD();
                doc.setId_plan(rs.getInt("id_plan"));
                doc.setNumero(rs.getInt("numero"));
                doc.setId_asignacion(rs.getString("id_asignacion"));
                doc.setFecha(rs.getString("fecha"));
                doc.setGuias(rs.getString("guia"));
                doc.setHorasGuia(rs.getInt("hora_guias"));
                doc.setEstado(rs.getString("estado"));
                lista.add(doc);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() {
        String sql = "INSERT INTO documentacion(numero, id_asignacion, fecha, guia, hora_guias, estado)" + "VALUES ('" + getNumero() + "','" + getId_asignacion() + "','" + getFecha()+ "','" + getGuias()+ "','" + getHorasGuia()+ "','" + getEstado() + "')";
        System.out.println(sql);

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean modificar(int id_plan) {
        String sql = "update documentacion set \"fecha\"='" + getFecha()+ "',\"guia\"='" + getGuias()+ "',\"hora_guias\"=" 
                + getHorasGuia()+",\"estado\"='" + getEstado()+ "'"
                + " where \"id_plan\"= " + id_plan + ";";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error al editar");

            return false;
        }
    }

    public boolean eliminar(int id_plan) {
        String sql = "delete from documentacion where \"id_plan\"=" + id_plan + ";";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }
    
    public int numfecha(String fecha,String id_asignacion) {
        int fecha1 = 0;
        String sql="select count (fecha) as num from documentacion where cast ('"+ fecha +"'as date) > fecha and id_asignacion = '"+id_asignacion+"'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                fecha1 = rs.getInt("num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha1;
    }
     public int fecha(String id_asignacion) {
        int fecha1 = 0;
        String sql="select count (fecha) as num from documentacion where id_asignacion = '"+id_asignacion+"'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                fecha1 = rs.getInt("num");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha1;
    }
     
     public  List<String> mostrarCiclo() {
        try{
        List<String> ciclos = new ArrayList<String>();
        String sql= "select distinct case when jornada='MATUTINA' then'M'||ciclo||paralelo when jornada='VESPERTINA' then 'V'||ciclo||paralelo when jornada='NOCTURNA' then'N'||ciclo||paralelo end as \"CICLO\" from asignacion_docentes";
        ResultSet rs = conectar.query(sql);
        
            while (rs.next()) {
               ciclos.add(rs.getString("CICLO"));
            }
            rs.close();
            return ciclos;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
       
      
    }
     
}
