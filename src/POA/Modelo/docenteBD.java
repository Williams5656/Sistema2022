/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.postgresql.util.Base64;

/**
 *
 * @author HP
 */
public class docenteBD extends docenteMD {
    Conect conectar= new Conect();

    public docenteBD() {
    }

    public docenteBD(String cedula, String titulo, String abreviatura, String tiempo, String ocupacion) {
        super(cedula, titulo, abreviatura, tiempo, ocupacion);
    }
    
    public List<docenteMD> mostrardatos() {

        try {
            List<docenteMD> lista = new ArrayList<docenteMD>();
            String sql = "select * from docente";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                docenteMD docente = new docenteMD();
                docente.setCedula(rs.getString("cedula"));
                docente.setTitulo(rs.getString("titulo"));
                docente.setAbreviatura(rs.getString("abreviatura"));
                docente.setTiempo(rs.getString("tiempo"));
                docente.setOcupacion(rs.getString("ocupacion"));
                lista.add(docente);
            }

            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(docenteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insertar() {
        String nsql = "INSERT INTO docente(cedula,titulo,abreviatura,tiempo,ocupacion)" + "VALUES ('" + getCedula() + "','" + getTitulo() + "','" + getAbreviatura() + "','" + getTiempo() + "','" + getOcupacion()+ "')";
        
                                                                                                                                                                                                                                                                                       

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
    
    
    public boolean Modificar(String cedula) {
       
        String nsql = "UPDATE docente set \"titulo\"='" + getTitulo() + "',\"abreviatura\"='" + getAbreviatura() + "',\"tiempo\"='" + getTiempo()+ "',\"ocupacion\"='" + getOcupacion()+ "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
    
    public List<docenteMD> obtenerdatos(String cedula) {

        try {
            List<docenteMD> lista = new ArrayList<docenteMD>();

            String sql = "select * from docente" + " where\"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                docenteMD docente = new docenteMD();
                docente.setCedula(rs.getString("cedula"));
                docente.setTitulo(rs.getString("titulo"));
                docente.setAbreviatura(rs.getString("abreviatura"));
                docente.setTiempo(rs.getString("tiempo"));
                docente.setOcupacion(rs.getString("ocupacion"));
                lista.add(docente);
            }

            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(docenteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }
}
