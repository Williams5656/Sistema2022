/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.Base64;

/**
 *
 * @author Myrian
 */
public class Responsables_ActividadBD extends Responsables_ActividadMD  {
    Conect conectar = new Conect();
    
    public  boolean insertarresponsable() {  
        String nsql = "INSERT INTO responsables_act(id_responsable,id_actividad,cedula)" + "VALUES ('" + getId_responsable() + "','" + getId_actividad() + "','" + getCedula() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    public List<Responsables_ActividadMD> obtenerdatos(String buscar) {
  
        try {
            String sql1 ="select * from responsables_act";         
            List<Responsables_ActividadMD> lista = new ArrayList<Responsables_ActividadMD>();
            ResultSet rs = conectar.query(sql1);
            while (rs.next()) {
                Responsables_ActividadMD m = new Responsables_ActividadMD();
                m.setId_responsable(rs.getInt("id_responsable"));
                m.setId_actividad(rs.getInt("id_actividad"));
                m.setCedula(rs.getString("cedula"));
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(Responsables_ActividadBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
