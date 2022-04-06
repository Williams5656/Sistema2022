/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sebastian
 */
public class ObjetivoOperativoBD {
    Conect conectar = new Conect();
    
    public ArrayList<ObjetivoOperativoMD> mostrarDatos(){
        
        ArrayList<ObjetivoOperativoMD> lista = new ArrayList<>();
        
        String sql = "select * from objetivo_operativo Order by 1";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                ObjetivoOperativoMD m = new ObjetivoOperativoMD();
                m.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                m.setId_proyecto(rs.getInt("id_proyecto"));
                m.setNum_objetivo_proyecto(rs.getInt("num_objetivo_proyecto"));
                m.setObjetivo(rs.getString("objetivo"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoOperativoMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     public ArrayList<ObjetivoOperativoMD> obtenerdatos(int id){
        
        ArrayList<ObjetivoOperativoMD> lista = new ArrayList<>();
        
        String sql = "select DISTINCT* from objetivo_operativo"+ " where\"id_objetivo_operativo\"='" + id + "'";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                ObjetivoOperativoMD m = new ObjetivoOperativoMD();
                m.setId_objetivo_operativo(rs.getInt("id_objetivo_operativo"));
                m.setId_proyecto(rs.getInt("id_proyecto"));
                m.setNum_objetivo_proyecto(rs.getInt("num_objetivo_proyecto"));
                m.setObjetivo(rs.getString("objetivo"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoOperativoMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_proyecto, int num_objetivo_proyecto, String objetivo){
        
        String sql = "insert into objetivo_operativo (id_proyecto, num_objetivo_proyecto, objetivo) VALUES (" + 
                id_proyecto + ", " + num_objetivo_proyecto + ", '" + objetivo + "');";
        
        conectar.noQuery(sql);
        
    }
}
