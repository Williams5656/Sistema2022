
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

    public AsignacionMateriaDocenteBD(String id_asignacio, String identificacion, String asignatura, String ciclo, String paralelo, String jornada, String periodo) {
        super(id_asignacio, identificacion, asignatura, ciclo, paralelo, jornada, periodo);
    }

    
    public AsignacionMateriaDocenteBD() {
    }
    public List<AsignacionMateriaDocentesMD> mostrardatos() {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();
            String sql = "select * from asignacion_docentes";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setId_asignacio(rs.getString("id_asignacion"));
                asignacion.setIdentificacion(rs.getString("identificacion"));
                asignacion.setPeriodo(rs.getString("periodo"));
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
    public List<AsignacionMateriaDocentesMD> obtenerdatos(String id_asignacion) {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();

            String sql = "select * from asignacion_docentes" + " where\"id_asignacion\"='" + id_asignacion + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setId_asignacio(rs.getString("id_asignacion"));
                asignacion.setIdentificacion(rs.getString("identificacion"));
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
        String nsql = "INSERT INTO asignacion_docentes(id_asignacion, identificacion, periodo, asignatura, ciclo, jornada, paralelo)" + "VALUES ('" + getId_asignacio()+ "','" + getIdentificacion()+ "','" + getPeriodo()+ "','" + getAsignatura()+ "','" + getCiclo()+ "','" + getJornada()+ "','" + getParalelo()+ "')";
                                                                                                                                                                                                                                                          
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }
    public boolean Modificar(String id_asignacion) {
       
        String nsql = "UPDATE asignacion_docentes set \"ciclo\"='" + getCiclo()+ "',\"paralelo\"='" + getParalelo()+ "',\"jornada\"='" + getJornada()+ "',\"asignatura\"='" + getAsignatura()+ "'"
                + " where \"id_asignacion\"='" + id_asignacion + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    public boolean eliminar(String id_asignacion) {
        String sql = "delete from asignacion_docentes where \"id_asignacion\"=" + id_asignacion + ";";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
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
