/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Miguel
 */
public class doc_modulo_BD extends doc_modulo_MD {

    Conect conectar = new Conect();

    public doc_modulo_BD() {
    }

    public boolean insertar_doc(int cod, JInternalFrame vista) {

        String ruta_archivo = "";
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(vista);
        if (se == 0) {
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        }
        String nombre = cod + "";
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                setDocumento(pdf);
            } catch (IOException ex) {
                System.out.println("Error al agregar archivo pdf, lin 54 " + ex.getMessage());
                return false;
            }
        }
        String sql = "UPDATE doc_modulo SET documento = ? WHERE id_doc_modulo = ?;";
        PreparedStatement ps = null;
        try {
            ps = conectar.getCon().prepareStatement(sql);
            ps.setBytes(1, getDocumento());
            ps.setInt(2, cod);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error linea 65 " + ex.getMessage());
            return false;
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
        return true;
    }

    public void abrir(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conectar.getCon().prepareStatement("SELECT documento FROM doc_modulo WHERE id_doc_modulo = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            conectar.cierraConexion();
            try {
                Desktop.getDesktop().open(new File("new.pdf"));
            } catch (Exception ex) {
            }

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

    public boolean crear_modulos(String carrera) {
        int cod_max = 0;
        ResultSet rs;
        ResultSet rs2;
        try {
            rs = conectar.query("select max (id_periodo) from periodo_academico");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de periodo");
            return false;
        }

        List<String> lista_mat = new ArrayList<>();

        try {
            rs2 = conectar.query("select codigo from materia where nombre=(select codigo from carrera where nombre='" + carrera + "')");
            while (rs2.next()) {
                lista_mat.add(rs2.getString(1));
            }
            rs2.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod de materia");
            return false;
        }

        for (int i = 0; i < lista_mat.size(); i++) {
            if (conectar.noQuery("INSERT INTO doc_modulo(id_periodo,id_materia)" + "VALUES ('" + cod_max + "','" + lista_mat.get(i) + "');") == null) {
                System.out.println("modulo " + lista_mat.get(i));
            } else {
                System.out.println("Error al crear el modulo " + lista_mat.get(i));
                return false;
            }
        }

        return true;
    }

    public Object[][] datos_unidos(String carrera) {
        try {
            String sql = "select md.id_doc_modulo, per.nombre, mt.materia, md.documento as estado\n"
                    + "from doc_modulo md \n"
                    + "join periodo_academico per on md.id_periodo=per.id_periodo\n"
                    + "join materia mt on md.id_materia=mt.codigo"
                    + " where mt.nombre=(select codigo from carrera where nombre='" + carrera + "')";
            ResultSet rs = conectar.query(sql);
            int n_fil = 0;
            while (rs.next()) {
                n_fil++;
            }
            rs.close();
            ResultSet rs2 = conectar.query(sql);
            Object[][] m = new Object[n_fil][4];
            int f = 0;
            while (rs2.next()) {
                m[f][0] = rs2.getString(1);
                m[f][1] = rs2.getString(2);
                m[f][2] = rs2.getString(3);
                m[f][3] = rs2.getBytes(4);
                f++;
            }
            rs2.close();
            return m;
        } catch (SQLException e) {
            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /*public Object[][] buscar_x_parametro(String carrera, int id_periodo, boolean periodo, String nom_materia, boolean materia) {
        try {
            String sql = "select md.id_doc_modulo, per.nombre, mt.materia, md.documento\n"
                    + "from doc_modulo md \n"
                    + "join periodo_academico per on md.id_periodo=per.id_periodo\n"
                    + "join materia mt on md.id_materia=mt.codigo ";
            if (periodo == true && materia == false) {
                sql = sql + "where md.id_periodo='" + id_periodo + "'";
            }
            if (periodo == false && materia == true) {
                sql = sql + "where md.id_materia= (select codigo from materia where upper (materia) LIKE '%" + nom_materia + "%')";
            }
            if (periodo == true && materia == true) {
                sql = sql + "where md.id_periodo='" + id_periodo + "' and "
                        + "md.id_materia= (select codigo from materia where upper (materia) LIKE '%" + nom_materia + "%')";
            }
            sql = sql + " and mt.nombre=(select codigo from carrera where nombre='" + carrera + "')";
            ResultSet rs = conectar.query(sql);
            int n_fil = 0;
            while (rs.next()) {
                n_fil++;
            }
            rs.close();
            ResultSet rs2 = conectar.query(sql);
            Object[][] m = new String[n_fil][4];
            int f = 0;
            while (rs2.next()) {
                m[f][0] = rs2.getString(1);
                m[f][1] = rs2.getString(2);
                m[f][2] = rs2.getString(3);
                m[f][3] = rs2.getBytes(4);
                f++;
            }
            rs2.close();
            return m;
        } catch (SQLException e) {
            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }*/
}
