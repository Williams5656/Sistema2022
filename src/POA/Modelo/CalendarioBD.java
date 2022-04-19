/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Myrian
 */
public class CalendarioBD extends CalendarioMD {

    Conect conectar = new Conect();

    public CalendarioBD() {
    }

    public CalendarioBD(int id_Actividad, String id_Carrera, int id_Periodo, int id_TipoActividad, String Nombre_Actividad, String Descripcion, String Fecha_Inicio, String Fecha_Limite, byte[] archivo) {
        super(id_Actividad, id_Carrera, id_Periodo, id_TipoActividad, Nombre_Actividad, Descripcion, Fecha_Inicio, Fecha_Limite, archivo);
    }

    public List<NomCalendarioMD> mostrardatos() {
        List<NomCalendarioMD> Listacale = new ArrayList<>();
        try {
            String sql = "select ca.id_actividad, c.nombre as Carrera,p.nombre as periodo, t.nombre_tipo_actividad as tipo_Actividad,ca.nombre_actividad,ca.descripcion,ca.fecha_inicio,ca.fecha_limite,ca.archivo "
                    + "from calendario ca "
                    + "join periodo_academico p on p.id_periodo=ca.id_periodo "
                    + "join carrera c on c.codigo=ca.id_carrera "
                    + "join tipo_actividad t on t.id_tipoactividad=ca.id_tipoactividad "
                    + "order by 1 ";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                NomCalendarioMD m = new NomCalendarioMD();
                m.setId_actividad(rs.getInt("id_actividad"));
                m.setId_carrera(rs.getString("Carrera"));
                m.setId_periodo(rs.getString("periodo"));
                m.setId_tipoactividad(rs.getString("tipo_Actividad"));
                m.setNombre_actividad(rs.getString("nombre_actividad"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setFecha_ini(rs.getString("fecha_inicio"));
                m.setFecha_lim(rs.getString("fecha_limite"));
                m.setArchivo(rs.getBytes("archivo"));
                Listacale.add(m);
            }
            rs.close();
            return Listacale;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public List<CalendarioMD> obtenerDatos(int id_actividad) {
        List<CalendarioMD> listaA = new ArrayList<CalendarioMD>();
        try {
            String sql = "select * from calendario where \"id_actividad\"='" + id_actividad + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                CalendarioMD m = new CalendarioMD();
                m.setId_Actividad(rs.getInt("id_actividad"));
                m.setId_Carrera(rs.getString("id_carrera"));
                m.setId_Periodo(rs.getInt("id_periodo"));
                m.setid_TipoActividad(rs.getInt("id_tipoactividad"));
                m.setNombre_Actividad(rs.getString("nombre_actividad"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setFecha_Inicio(rs.getString("fecha_inicio"));
                m.setFecha_Limite(rs.getString("fecha_limite"));
                m.setArchivo(rs.getBytes("archivo"));
                listaA.add(m);
            }
            rs.close();
            return listaA;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public int codigo() {
        try {
            int c = 0;
            String sql = "select max(id_responsable) as id_responsable from responsables_act";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("id_responsable");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int codigo_act() {
        try {
            int c = 0;
            String sql = "select max(id_actividad) as id_actividad from calendario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                c = rs.getInt("id_actividad");
            }
            return c + 1;
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean insertar() {
        String nsql = "INSERT INTO calendario(id_actividad,id_carrera,id_periodo,id_tipoactividad,nombre_actividad,descripcion,fecha_inicio,fecha_limite)" + "VALUES ('"
                + getId_Actividad() + "','" + getId_Carrera() + "','" + getId_Periodo() + "','" + getid_TipoActividad() + "','" + getNombre_Actividad() + "','" + getDescripcion() + "','" + getFecha_Inicio() + "','" + getFecha_Limite() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean modificar(File ruta) {
        //Transformo image a base64 encode para postgresl
        byte[] pdf1 = null;
        if (ruta != null) {

            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                pdf1 = pdf;
                setArchivo(pdf);
            } catch (IOException ex) {
                pdf1 = null;
            }
        }

        try {

            String sql = "UPDATE calendario SET id_carrera= ?, id_periodo=?, id_tipoactividad=?, nombre_actividad=?, descripcion=?, fecha_inicio=?,fecha_limite=?, archivo=? "
                    + " WHERE id_actividad = " + getId_Actividad();

            PreparedStatement ps = null;
            System.out.println("fecha" + getFecha_Inicio());
            ps = conectar.getCon().prepareStatement(sql);
            Date fecha = new Date();
            ps.setString(1, getId_Carrera());
            ps.setInt(2, getId_Periodo());
            ps.setInt(3, getId_TipoActividad());
            ps.setString(4, getNombre_Actividad());
            ps.setString(5, getDescripcion());
            ps.setTimestamp(6, Timestamp.valueOf(getFecha_Inicio()));
            ps.setTimestamp(7, Timestamp.valueOf(getFecha_Limite()));
            ps.setBytes(8, pdf1);
            boolean ejecutar = false;
            ps.execute();
            if (ps.executeUpdate() == 1) {
                ejecutar = true;
                System.out.println("aaaaa");
            }
            return ejecutar;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "", 0);
            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "", 0);
            return false;
        }

    }

    public void ejecutar_archivoPDF(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        try {
            ps = conectar.getCon().prepareStatement("SELECT archivo FROM calendario WHERE id_actividad = ?;");
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
            conectar.cierraConexion();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }

    }

    public int validar_Nombre_act(String nombre) {

        int fila = 0;
        try {
            System.out.println(getNombre_Actividad() + " nombre_actividad");
            String sql = "Select * from calendario where nombre_actividad = '" + nombre + "'";
            System.out.println("");
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                fila++;
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(CalendarioBD.class.getName()).log(Level.SEVERE, null, ex);
            return fila;
        }
    }

}
