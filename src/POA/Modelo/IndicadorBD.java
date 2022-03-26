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
public class IndicadorBD {
    Conect conectar = new Conect();
    
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
        
        String sql = "insert into poa (id_actividades, linea_base, meta, indicador) VALUES (" + 
                id_actividades + ", " + linea_base + ", " + meta + ", '" + indicador + "');";
        
        conectar.noQuery(sql);
        
    }
}
