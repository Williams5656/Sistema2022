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
public class EvidenciaBD extends EvidenciaMD{
    Conect conectar = new Conect();

    public EvidenciaBD() {
        
    }

    public EvidenciaBD(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, String archivo) {
        super(id_evidencia, id_actividades, id_poa, id_proyecto, id_objetivo, archivo);
    }
    
    
    
    public ArrayList<EvidenciaMD> mostrarDatos(){
        
        ArrayList<EvidenciaMD> lista = new ArrayList<>();
        
        String sql = "select * from evidencia";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                EvidenciaMD m = new EvidenciaMD();
                m.setId_evidencia(rs.getInt("id_evidencia"));
                m.setId_actividades(rs.getInt("id_actividades"));
                m.setId_poa(rs.getInt("id_poa"));
                m.setId_proyecto(rs.getInt("id_proyecto"));
                m.setId_objetivo(rs.getInt("id_objetivo"));
                m.setArchivo(rs.getString("archivo"));

                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, String archivo){
        
        String sql = "insert into evidencia (id_evidencia, id_actividades, id_poa, id_proyecto, id_objetivo,archivo) VALUES (" + id_evidencia+", "+
                id_actividades + ", "+ id_poa+ ", "+id_proyecto+ ", "+id_objetivo+", '" + archivo + "');";
        conectar.noQuery(sql);
        
    }
}
