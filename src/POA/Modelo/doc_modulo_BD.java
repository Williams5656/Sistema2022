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
            String sql = "select * from doc_modulo" + " where \"id_doc_modulo\"='"+id_doc_modulo+"'";
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
            Logger.getLogger(doc_modulo_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String nsql = "INSERT INTO doc_modulo(id_doc_modulo,id_periodo,id_materia,documento)" + "VALUES ('" + getId_doc_modulo()+ "','" + getId_periodo()+ "','" + getId_materia()+ "','" + ef+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    
}

  