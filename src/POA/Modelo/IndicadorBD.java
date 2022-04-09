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
public class IndicadorBD extends IndicadorMD{
    Conect conectar = new Conect();

    public IndicadorBD() {
    }

    public IndicadorBD(int id_indicador, int id_actividades, int linea_base, int meta, String indicador) {
        super(id_indicador, id_actividades, linea_base, meta, indicador);
    }
    
    
    
    public ArrayList<IndicadorMD> mostrarDatos(){
        
        ArrayList<IndicadorMD> lista = new ArrayList<>();
        
        String sql = "select * from indicador";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                IndicadorMD m = new IndicadorMD();
                m.setId_indicador(rs.getInt("id_indicador"));
                m.setId_actividades(rs.getInt("id_actividades"));
                m.setLinea_base(rs.getInt("linea_base"));
                m.setMeta(rs.getInt("meta"));
                m.setIndicador(rs.getString("indicador"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(IndicadorMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_actividades, int linea_base, int meta, String indicador){
        
        String sql = "insert into indicador (id_actividades, linea_base, meta, indicador) VALUES (" + 
                id_actividades + ", " + linea_base + ", " + meta + ", '" + indicador + "');";
        
        conectar.noQuery(sql);
        
    }
    
    public int valid(){
        
        String sql = "select MAX(id_indicador) as id from indicador";
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
    
    public List<IndicadorMD> obtenerdatos(int id) {
        try {
            List<IndicadorMD> lista = new ArrayList<IndicadorMD>();
            String sql = "select * from indicador"+" where \"id_indicador\"='"+id+"'";
            ResultSet rs = conectar.query(sql);
            byte[] is;

            while (rs.next()) {
                IndicadorMD m = new IndicadorMD();
                m.setId_indicador(rs.getInt("id_indicador"));
                m.setIndicador(rs.getString("indicador"));
                m.setLinea_base(rs.getInt("linea_base"));
                m.setMeta(rs.getInt("meta"));
                m.setId_actividades(rs.getInt("id_actividades"));                
                
                
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            
            Logger.getLogger(IndicadorBD.class.getName()).log(Level.SEVERE,null,e);
        
        }
        return null;

    }
    
    public List<IndicadorMD> obtenerdatosxactividad(int id) {
        try {
            List<IndicadorMD> lista = new ArrayList<IndicadorMD>();
            String sql = "select * from indicador"+" where \"id_actividades\"='"+id+"'";
            ResultSet rs = conectar.query(sql);
            byte[] is;

            while (rs.next()) {
                IndicadorMD m = new IndicadorMD();
                m.setId_indicador(rs.getInt("id_indicador"));
                m.setIndicador(rs.getString("indicador"));
                m.setLinea_base(rs.getInt("linea_base"));
                m.setMeta(rs.getInt("meta"));
                m.setId_actividades(rs.getInt("id_actividades"));                
                
                
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            
            Logger.getLogger(IndicadorBD.class.getName()).log(Level.SEVERE,null,e);
        
        }
        return null;

    }
    
    public boolean modificar(int id){
        
            String sql= "UPDATE indicador set \"indicador\"='"+getIndicador()+ "',\"linea_base\"='"+getLinea_base()+  "',\"meta\"='"+getMeta()+ "'"
                    + " where \"id_indicador\"='"+id+"'";
            
            if(conectar.noQuery(sql)==null){
                return true;
                }
                else{
                    System.out.println("error al editar");
   
        return false;
                }
            
            }
    
    
     public boolean Eliminar(int id){
                String nsql= " delete from indicador where \"id_indicador\"='" + id + "'";
                if(conectar.noQuery(nsql)==null){
                return true;
                }
                else{
                    System.out.println("error eliminar");
                    return false;
                }        
    }
}
