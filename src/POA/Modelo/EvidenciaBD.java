/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebastian
 */
public class EvidenciaBD extends EvidenciaMD {

    Conect conectar = new Conect();

    public EvidenciaBD() {

    }

    public EvidenciaBD(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, byte[] archivo) {
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
                m.setArchivo(rs.getBytes("archivo"));

                lista.add(m);
            }

//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void abrir(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conectar.getCon().prepareStatement("SELECT archivo FROM evidencia WHERE id_evidencia = ?;");
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

    public Object[][] datos_unidos(String carrera) {
        try {
            String sql = "select ev.id_evidencia,car.nombre ,pro.num_proyecto_carrera , poa.anio ,act.actividad , obj.objetivo , ev.archivo \n"
                    + "from actividades act, evidencia ev, carrera car, poa, proyecto pro, objetivo_operativo obj \n"
                    + "where act.id_actividades = ev.id_actividades \n"
                    + "and car.codigo = CAST( poa.id_carrera AS VARCHAR(10))\n"
                    + "and poa.id_poa = ev.id_poa \n"
                    + "and pro.id_proyecto = ev.id_proyecto \n"
                    + "and obj.id_objetivo_operativo = ev.id_objetivo";
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
                m[f][0] = rs2.getInt(1);
                m[f][1] = rs2.getString(2);
                m[f][2] = rs2.getString(3);
                m[f][3] = rs2.getString(4);
                m[f][4] = rs2.getString(5);
                m[f][5] = rs2.getString(5);
                m[f][6] = rs2.getBytes(7);
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
        System.out.println("ruta" + ruta);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                setArchivo(pdf);
            } catch (IOException ex) {
                System.out.println("Error al agregar archivo pdf, lin 54 " + ex.getMessage());
                return false;
            }
        }
        String sql = "UPDATE evidencia SET archivo= ? WHERE id_evidencia = ?;";
        PreparedStatement ps = null;
        try {
            ps = conectar.getCon().prepareStatement(sql);
            ps.setBytes(1, getArchivo());
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
                a.setArchivo(rs.getBytes("archivo"));
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
                + id_actividades + ", " + id_poa + ", " + id_proyecto + ", " + id_objetivo + ", " + archivo + ");";
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
