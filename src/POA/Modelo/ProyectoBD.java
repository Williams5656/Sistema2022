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
public class ProyectoBD extends ProyectoMD{
    Conect conectar = new Conect();

    public ProyectoBD() {
    }

    public ProyectoBD(int id_proyecto, int id_Poa, int num_proyecto_carrera, String objetivo_estrategico, String objetivo_tactico, String estrategia) {
        super(id_proyecto, id_Poa, num_proyecto_carrera, objetivo_estrategico, objetivo_tactico, estrategia);
    }
    
    
    public ArrayList<ProyectoMD> mostrarDatos(){
        
        ArrayList<ProyectoMD> lista = new ArrayList<>();
        
        String sql = "select * from proyecto";
        ResultSet rs= conectar.query(sql);
        try {
            while(rs.next()){
                ProyectoMD m = new ProyectoMD();
                m.setId_proyecto(rs.getInt("id_proyecto"));
                m.setId_Poa(rs.getInt("id_poa"));
                m.setNum_proyecto_carrera(rs.getInt("num_proyecto_carrera"));
                m.setObjetivo_estrategico(rs.getString("objetivo_estrategico"));
                m.setObjetivo_tactico(rs.getString("objetivo_tactico"));
                m.setEstrategia(rs.getString("estrategia"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(int id_poa, int num_proyecto_carrera, String objetivo_estrategico, String objetivo_tactico, String estrategia){
        
        String sql = "insert into proyecto (id_poa, num_proyecto_carrera, objetivo_estrategico, "
                + "objetivo_tactico, estrategia) VALUES (" + id_poa + ", " + num_proyecto_carrera + ", '" + objetivo_estrategico +
                "', '" + objetivo_tactico + "', '" + estrategia + "');";
        
        conectar.noQuery(sql);
        
    }
}
