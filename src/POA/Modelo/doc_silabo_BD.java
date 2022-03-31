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
public class doc_silabo_BD extends doc_silabo_MD {

    Conect conectar = new Conect();

    public doc_silabo_BD(int id_doc_silabo, String id_materia, Image documento, int id_periodo) {
        super(id_doc_silabo, id_materia, documento, id_periodo);
    }

    public doc_silabo_BD() {
    }

    public List<doc_silabo_MD> mostrardatos() {
        try {
            List<doc_silabo_MD> lista = new ArrayList<doc_silabo_MD>();
            String sql = "select * from doc_";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                doc_silabo_MD m = new doc_silabo_MD();
                m.setId_doc_silabo(rs.getInt("id_doc_modulo"));
                m.setId_periodo(rs.getInt("id_materia"));
                m.setId_materia(rs.getString("id_periodo"));
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

            Logger.getLogger(doc_silabo_MD.class.getName()).log(Level.SEVERE, null, e);
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

    public List<doc_silabo_MD> obtenerdatos(String id_doc_silabo) {
        try {
            List<doc_silabo_MD> lista = new ArrayList<doc_silabo_MD>();
            String sql = "select * from doc_silabo" + " where \"id_doc_silabo\"='" + id_doc_silabo + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                doc_silabo_MD m = new doc_silabo_MD();
                m.setId_doc_silabo(rs.getInt("id_doc_silabo"));
                m.setId_materia(rs.getString("id_materia"));
                m.setId_periodo(rs.getInt("id_periodo"));
                is = rs.getBytes("documento");

                is = rs.getBytes("documento");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("documento").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        m.setDocumento(getImage(is, false));
                    } catch (Exception ex) {
                        m.setDocumento(null);
                        Logger.getLogger(doc_silabo_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    m.setDocumento(null);
                }

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(doc_silabo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

                 public boolean insertar() {
        //Transformo image a base64 encode para postgresl
          String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getDocumento());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(doc_silabo_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String nsql = "INSERT INTO doc_silabo(id_doc_silabo,id_materia,documento,id_periodo)" + "VALUES ('" + getId_doc_silabo()+ "','" + getId_materia()+ "','" + ef+ "','" + getId_materia()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    

}
