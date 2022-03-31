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
public class PoaBD {
    Conect conectar = new Conect();

    public ArrayList<PoaMD> mostrarDatos(){
        
        ArrayList<PoaMD> lista = new ArrayList<>();
        
        String sql = "select * from poa";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                PoaMD m = new PoaMD();
                m.setId_POA(rs.getInt("id_poa"));
                m.setId_carrera(rs.getInt("id_carrera"));
                m.setAnio(rs.getString("anio"));
                m.setEstado(rs.getString("estado"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PoaMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_carrera, String anio, String estado){
        
        String sql = "insert into poa (anio, id_carrera, estado) VALUES ('" + 
                anio + "', " + id_carrera + ", '" + estado + "');";
        
        conectar.noQuery(sql);
        
    }
}
