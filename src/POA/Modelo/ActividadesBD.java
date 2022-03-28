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
                id_objetivo_operativo + ", '" + actividad + "', '" + responsable + "', '" + plazo + "', '" + recurso_financiero + ");";
        
        conectar.noQuery(sql);
        
    }
}
