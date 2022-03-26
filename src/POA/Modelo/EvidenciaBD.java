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
public class EvidenciaBD {
    Conect conectar = new Conect();
    
    public ArrayList<EvidenciaMD> mostrarDatos(){
        
        ArrayList<EvidenciaMD> lista = new ArrayList<>();
        
        String sql = "select * from evidencia";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                EvidenciaMD m = new EvidenciaMD();
                m.setId_actividades(rs.getInt("id_actividades"));
                m.setId_evidencia(rs.getInt("id_evidencia"));
                m.setArchivo(rs.getString("archivo"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EvidenciaMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_actividades, String archivo){
        
        String sql = "insert into evidencia (id_actividades, archivo) VALUES (" + 
                id_actividades + ", '" + archivo + "');";
        
        conectar.noQuery(sql);
        
    }
}
