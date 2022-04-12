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
/**
 *
 * @author sebastian
 */
public class PoaBD extends PoaMD{
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
    public List<PoaMD> obtenerdatos(int identificador) {
        try {
             ArrayList<PoaMD> lista = new ArrayList<>();
            String sql = "select * from poa where \"id_poa\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                PoaMD m = new PoaMD();
                m.setId_POA(rs.getInt("id_poa"));
                m.setId_carrera(rs.getInt("id_carrera"));
                m.setAnio(rs.getString("anio"));
                m.setEstado(rs.getString("estado"));
                lista.add(m);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(EvidenciaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void guardar(int id_carrera, String anio, String estado){
        
        String sql = "insert into poa (anio, id_carrera, estado) VALUES ('" + 
                anio + "', " + id_carrera + ", '" + estado + "');";
        
        conectar.noQuery(sql);
        
    }
    public boolean modificar(String codigo) {
        String nsql = "uPDATE poa set \"id_carrera\"='" + getId_carrera()+ "',\"anio\"='" + getAnio()+"'"
                + " where \"id_poa\"='" + codigo + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
}
