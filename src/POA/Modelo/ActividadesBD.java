/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author sebastian
 */
public class ActividadesBD extends ActividadesMD{
    Conect conectar = new Conect();

    public ActividadesBD() {
    }

    public ActividadesBD(int id_actividades, int id_objetivo_operativo, String actividad, String responsable, String plazo, String recurso_financiero) {
        super(id_actividades, id_objetivo_operativo, actividad, responsable, plazo, recurso_financiero);
    }
    
    
    
    
    
    public ArrayList<ActividadesMD> mostrarDatos(){
        
        ArrayList<ActividadesMD> lista = new ArrayList<>();
        
        String sql = "select * from actividades";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                ActividadesMD m = new ActividadesMD();
                m.setId_actividades(rs.getInt("id_actividades"));
                m.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                m.setActividad(rs.getString("actividad"));
                m.setResponsable(rs.getString("responsable"));
                m.setRecurso_financiero(rs.getString("recurso_financiero"));
                m.setPlazo(rs.getString("plazo"));

                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_objetivo_operativo, String actividad, String responsable, String plazo, String recurso_financiero){
        
        String sql = "insert into actividades (id_objetivo_operativo, actividad, responsable, plazo, recurso_financiero) VALUES (" + 
                id_objetivo_operativo + ", '" + actividad + "', '" + responsable + "', '" + plazo + "', '" + recurso_financiero + "');";
        
        conectar.noQuery(sql);
        
    }
    
    public int valid(){
        
        String sql = "select MAX(id_actividades) as id from actividades";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                return rs.getInt("id")+1;
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesMD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }
    
    
    
    public List<ActividadesMD> obtenerdatos(int identificador) {
        try {
            List<ActividadesMD> lista = new ArrayList<ActividadesMD>();
            String sql = "select * from actividades where \"id_objetivo_operativo\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                ActividadesMD p = new ActividadesMD();
                p.setId_actividades(rs.getInt("id_actividades"));
                p.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                p.setActividad(rs.getString("actividad"));
                p.setResponsable(rs.getString("responsable"));
                p.setRecurso_financiero(rs.getString("recurso_financiero"));
                p.setPlazo(rs.getString("plazo"));
               
                lista.add(p);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<ActividadesMD> obtenerdatosxind(int identificador) {
        try {
            List<ActividadesMD> lista = new ArrayList<ActividadesMD>();
            String sql = "select  * from actividades where \"id_actividades\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                ActividadesMD p = new ActividadesMD();
                p.setId_actividades(rs.getInt("id_actividades"));
                p.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                p.setActividad(rs.getString("actividad"));
                p.setResponsable(rs.getString("responsable"));
                p.setRecurso_financiero(rs.getString("recurso_financiero"));
                p.setPlazo(rs.getString("plazo"));
               
                lista.add(p);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<ActividadesMD> obtenerdatosxpor(int id_ob, int id_act) {
        try {
            List<ActividadesMD> lista = new ArrayList<ActividadesMD>();
            String sql = "select * from actividades where \"id_objetivo_operativo\"='" + id_ob + "' and \"id_actividades\"='"+ id_act + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                ActividadesMD p = new ActividadesMD();
                p.setId_actividades(rs.getInt("id_actividades"));
                p.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                p.setActividad(rs.getString("actividad"));
                p.setResponsable(rs.getString("responsable"));
                p.setRecurso_financiero(rs.getString("recurso_financiero"));
                p.setPlazo(rs.getString("plazo"));
               
                lista.add(p);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
  
}