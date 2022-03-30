
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC FACTORY
 */
public class AsignacionMateriaDocenteBD extends AsignacionMateriaDocentesMD{
    Conect conectar = new Conect();

    public AsignacionMateriaDocenteBD(String identificacio, String asignatura, String ciclo, String paralelo, String jornada, String periodo) {
        super(identificacio, asignatura, ciclo, paralelo, jornada, periodo);
    }
    
    public AsignacionMateriaDocenteBD() {
    }
    public List<AsignacionMateriaDocentesMD> mostrardatos() {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();
            String sql = "select * from asignacion_docentes";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setIdentificacio(rs.getString("identificacion"));
                asignacion.setAsignatura(rs.getString("asignatura"));
                asignacion.setCiclo(rs.getString("ciclo"));
                asignacion.setJornada(rs.getString("jornada"));
                asignacion.setParalelo(rs.getString("paralelo"));
                lista.add(asignacion);
            }

            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(docenteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public List<AsignacionMateriaDocentesMD> obtenerdatos(String identificacion) {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();

            String sql = "select * from asignacion_docentes" + " where\"identificacion\"='" + identificacion + "'";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setIdentificacio(rs.getString("identificacion"));
                asignacion.setAsignatura(rs.getString("asignatura"));
                asignacion.setCiclo(rs.getString("ciclo"));
                asignacion.setJornada(rs.getString("jornada"));
                asignacion.setParalelo(rs.getString("paralelo"));
                lista.add(asignacion);
            }

            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(docenteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }
    public boolean insertar() {
        String nsql = "INSERT INTO asignacion_docentes(identificacion, periodo, asignatura, ciclo, jornada, paralelo)" + "VALUES ('" + getIdentificacio()+ "','" + getPeriodo()+ "','" + getAsignatura()+ "','" + getCiclo()+ "','" + getJornada()+ "','" + getParalelo()+ "')";
                                                                                                                                                                                                                                                          
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean Modificar(String identificacion) {
       
        String nsql = "UPDATE asignacion_docentes set \"ciclo\"='" + getCiclo()+ "',\"paralelo\"='" + getParalelo()+ "',\"jornada\"='" + getJornada()+ "',\"asignatura\"='" + getAsignatura()+ "'"
                + " where \"identificacion\"='" + identificacion + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
        public int mostrarIdPeriodo(String nombre) {
        int idPeriodo=0;
        String sql="select id_periodo from periodo_academico where nombre= '" + nombre+ "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idPeriodo=rs.getInt("id_periodo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPeriodo;
    }
    
        public String mostrarIdMateria(String nombre) {
        String idMateria="";
        String sql="select codigo from materia where materia= '" + nombre+ "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                
                idMateria=rs.getString("codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idMateria;
    }
}
