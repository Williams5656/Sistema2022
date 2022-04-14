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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MIGUEL
 */
public class doc_instrumento_evaluacionBD extends doc_instrumento_evaluacionMD{

    Conect conectar = new Conect();
        
    public doc_instrumento_evaluacionBD() {
    }
    
    public boolean crear_intrumentos() {
        int cod_max = 0;
        ResultSet rs;
        try {
            rs = conectar.query("select max (id_asignacion) from asignacion_docentes");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
            if (conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Interciclo')") == null
                && conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Final')") == null
                && conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Supletorio')") == null
                ); 
            else {
                System.out.println("Error al crear las notas");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de asignacion_docentes");
            return false;
        }
        return true;
    }
    
    public Object[][] datos_unidos(String carrera) {
        try {
            String sql = "select n.id_doc_instrumento, n.descripcion, ps.nombres||' '||ps.apellidos as docente,\n"
                    + "per.nombre as periodo, mt.materia, ad.ciclo, ad.jornada, ad.paralelo, n.documento\n"
                    + "from doc_instrumento_evaluacion n\n"
                    + "join asignacion_docentes ad on n.id_asignacion=ad.id_asignacion\n"
                    + "join persona ps on ad.identificacion=ps.cedula\n"
                    + "join periodo_academico per on ad.periodo=cast(per.id_periodo as varchar)\n"
                    + "join materia mt on ad.asignatura=mt.codigo"
                    + " where mt.nombre=(select codigo from carrera where nombre='" + carrera + "')";
            ResultSet rs = conectar.query(sql);
            int n_fil=0;
            while (rs.next()) { 
                n_fil++;
            }
            rs.close();
            ResultSet rs2 = conectar.query(sql);
            Object [][] m= new Object[n_fil][9];
            int f=0;                    
            while (rs2.next()) {                
                m[f][0]=rs2.getString(1);
                m[f][1]=rs2.getString(2);
                m[f][2]=rs2.getString(3);
                m[f][3]=rs2.getString(4);
                m[f][4]=rs2.getString(5);
                m[f][5]=rs2.getString(6);
                m[f][6]=rs2.getString(7);
                m[f][7]=rs2.getString(8);
                m[f][8]=rs2.getBytes(9);
                f++;
            }
            rs2.close();
            return m;
        } catch (SQLException e) {
            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
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
        String sql = "UPDATE doc_instrumento_evaluacion SET documento = ? WHERE id_doc_instrumento = ?;";
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
            ps = conectar.getCon().prepareStatement("SELECT documento FROM doc_instrumento_evaluacion WHERE id_doc_instrumento = ?;");
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

            out.close();
            bos.close();
            ps.close();
            rs.close();
            try {
                Desktop.getDesktop().open(new File("new.pdf"));
            } catch (Exception ex) {
            }

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
}
