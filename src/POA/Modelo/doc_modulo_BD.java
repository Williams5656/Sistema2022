/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import static POA.Modelo.PersonaBD.toBufferedImage;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author DANNY
 */
public class doc_modulo_BD extends doc_modulo_MD {

    Conect conectar = new Conect();

    public doc_modulo_BD(int id_doc_modulo, int id_periodo, String id_materia, Image documento) {
        super(id_doc_modulo, id_periodo, id_materia, documento);
    }

    public doc_modulo_BD() {
    }

    public List<doc_modulo_MD> mostrardatos() {
        try {
            List<doc_modulo_MD> lista = new ArrayList<doc_modulo_MD>();
            String sql = "select * from doc_modulo";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                doc_modulo_MD m = new doc_modulo_MD();
                m.setId_doc_modulo(rs.getInt("id_doc_modulo"));
                m.setId_periodo(rs.getInt("id_periodo"));
                m.setId_materia(rs.getString("id_materia"));
                is = rs.getBytes("documento");

                is = rs.getBytes("documento");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("documento").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setDocumento(getImage(is, false));
                    } catch (Exception ex) {
                        m.setDocumento(null);
                        Logger.getLogger(doc_modulo_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setDocumento(null);
                }

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {
            param.setSourceSubsampling(4, 4, 0, 0);
        }
        return reader.read(0, param);
    }

    public List<doc_modulo_MD> obtenerdatos(String id_doc_modulo) {
        try {
            List<doc_modulo_MD> lista = new ArrayList<doc_modulo_MD>();
            String sql = "select * from doc_modulo" + " where \"id_doc_modulo\"='" + id_doc_modulo + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                doc_modulo_MD m = new doc_modulo_MD();
                m.setId_doc_modulo(rs.getInt("id_doc_modulo"));
                m.setId_periodo(rs.getInt("id_periodo"));
                m.setId_materia(rs.getString("id_materia"));
                is = rs.getBytes("documento");

                is = rs.getBytes("documento");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("documento").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setDocumento(getImage(is, false));
                    } catch (Exception ex) {
                        m.setDocumento(null);
                        Logger.getLogger(doc_modulo_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setDocumento(null);
                }

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar_doc(int cod) {
        //Transformo image a base64 encode para postgresl
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getDocumento());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(doc_modulo_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        //borrado el documento del iserte
        String nsql = "update doc_modulo set documento = '" + ef + "' where id_doc_modulo = " +  cod + ";";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean crear_modulos() {
        int cod_max=0;
        ResultSet rs;
        try {
            rs = conectar.query("select max (id_periodo) from periodo_academico");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de periodo");
            return false;
        }
        
        List<String> lista_mat=new ArrayList<>();
        
        try {
            rs = conectar.query("select codigo from materia");//auemntar un where en la consulta cuado materia se relacione con carrera
            while (rs.next()) {
                lista_mat.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod de materia");
            return false;
        }
        
        for (int i = 0; i < lista_mat.size(); i++) {
            if (conectar.noQuery("INSERT INTO doc_modulo(id_periodo,id_materia)" + "VALUES ('" + cod_max + "','" + lista_mat.get(i) + "');") == null);
            else {
                System.out.println("Error al crear el modulo "+lista_mat.get(i));
                return false;
            }
        }
        return true;
    }

    public List<doc_modulo_MD> buscar_x_parametro(int id_periodo, boolean periodo, String nom_materia, boolean materia) {
        try {
            List<doc_modulo_MD> lista = new ArrayList<doc_modulo_MD>();
            String sql = "select * from doc_modulo " ;
            if(periodo == true && materia == false){
                sql = sql + "where \"id_periodo\"='" + id_periodo + "'";
            }
            if(periodo == false && materia == true){
                sql = sql + "where \"id_materia\"= (select codigo from materia where upper (materia) LIKE '%" + nom_materia + "%')" ;
            }
            if(periodo == true && materia == true ){
               sql = sql + "where \"id_periodo\"='" + id_periodo + "' and "
                       + "\"id_materia\"= (select codigo from materia where upper (materia) LIKE '%" + nom_materia + "%')" ;
            }
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                doc_modulo_MD m = new doc_modulo_MD();
                m.setId_doc_modulo(rs.getInt("id_doc_modulo"));
                m.setId_periodo(rs.getInt("id_periodo"));
                m.setId_materia(rs.getString("id_materia"));
                is = rs.getBytes("documento");

                is = rs.getBytes("documento");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("documento").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setDocumento(getImage(is, false));
                    } catch (Exception ex) {
                        m.setDocumento(null);
                        Logger.getLogger(doc_modulo_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setDocumento(null);
                }

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
