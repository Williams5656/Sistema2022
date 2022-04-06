/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author sebastian
 */
public class EvidenciaBD extends EvidenciaMD {

    Conect conectar = new Conect();

    public EvidenciaBD() {

    }

    public EvidenciaBD(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, String archivo) {
        super(id_evidencia, id_actividades, id_poa, id_proyecto, id_objetivo, archivo);
    }

    public ArrayList<EvidenciaMD> mostrarDatos() {

        ArrayList<EvidenciaMD> lista = new ArrayList<>();

        String sql = "select * from evidencia";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
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

    public List<EvidenciaMD> obtenerdatos(int identificador) {
        try {
            List<EvidenciaMD> lista = new ArrayList<EvidenciaMD>();
            String sql = "select * from evidencia where \"id_evidencia\"='" + identificador + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                EvidenciaMD a = new EvidenciaMD();
                a.setId_objetivo(rs.getInt("id_evidencia"));
                a.setId_actividades(rs.getInt("id_actividades"));
                a.setId_poa(rs.getInt("id_poa"));
                a.setId_proyecto(rs.getInt("id_proyecto"));
                a.setId_objetivo(rs.getInt("id_objetivo"));
                a.setArchivo(rs.getString("archivo"));
                lista.add(a);
            }
            rs.close();//cerramos conexion base.
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(EvidenciaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void guardar(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, String archivo) {

        String sql = "insert into evidencia (id_evidencia, id_actividades, id_poa, id_proyecto, id_objetivo,archivo) VALUES (" + id_evidencia + ", "
                + id_actividades + ", " + id_poa + ", " + id_proyecto + ", " + id_objetivo + ", '" + archivo + "');";
        conectar.noQuery(sql);

    }

    public boolean modificar(String codigo) {
        String nsql = "uPDATE evidencia set \"id_actividades\"='" + getId_actividades() + "',\"id_poa\"='" + getId_poa() + "',\"id_proyecto\"='" + getId_proyecto() + "',\"id_objetivo\"='" + getId_objetivo() + "',\"archivo\"='" + getArchivo() + "'"
                + " where \"id_evidencia\"='" + codigo + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String codigo) {
        String nsql = "DELETE FROM evidencia WHERE \"id_evidencia\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }
    }
}
