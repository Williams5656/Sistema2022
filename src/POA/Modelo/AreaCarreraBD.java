/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Usuario
 */
public class AreaCarreraBD extends AreaCarreraMD {

    Conect conectar = new Conect();

    public AreaCarreraBD() {
    }

    public AreaCarreraBD(int idArea, String idCarrera, int idPerfil, String idResponsable) {
        super(idArea, idCarrera, idPerfil, idResponsable);
    }

    public List<AreaCarreraMD> mostrardatos() {
        try {
            List<AreaCarreraMD> lista = new ArrayList<AreaCarreraMD>();
            String sql = "select * from area_carrera";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AreaCarreraMD area = new AreaCarreraMD();
                area.setIdArea(rs.getInt("id_area"));
                area.setIdCarrera(rs.getString("carrera"));
                area.setIdPerfil(rs.getInt("perfil"));
                area.setIdResponsable(rs.getString("responsable"));
                lista.add(area);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<AreaCarreraMD> obtenerdatos(String identificador) {
        try {
            List<AreaCarreraMD> lista = new ArrayList<AreaCarreraMD>();
            String sql = "select * from area_carrera" + " where \"id_area\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AreaCarreraMD area = new AreaCarreraMD();
                area.setIdArea(rs.getInt("id_area"));
                area.setIdCarrera(rs.getString("carrera"));
                area.setIdPerfil(rs.getInt("perfil"));
                area.setIdResponsable(rs.getString("responsable"));
                lista.add(area);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO area_carrera(carrera, perfil,responsable)" + "VALUES ('" + getIdCarrera() + "','" + getIdPerfil() + "','" + getIdResponsable() + "')";
        System.out.println(sql);

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(int identificador) {
        String sql = "update area_carrera set \"carrera\"='" + getIdCarrera() + "',\"perfil\"='" + getIdPerfil() + "',\"responsable\"='" + getIdResponsable() + "'"
                + " where \"id_area\"= " + identificador + ";";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error al editar");

            return false;
        }
    }

    public boolean eliminar(int identificador) {
        String sql = "delete from area_carrera where \"id_area\"=" + identificador + ";";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }
}
