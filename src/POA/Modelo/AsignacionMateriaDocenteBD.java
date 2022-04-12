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
public class AsignacionMateriaDocenteBD extends AsignacionMateriaDocentesMD {

    Conect conectar = new Conect();

    public AsignacionMateriaDocenteBD(int id_asignacio, String identificacion, String asignatura, String ciclo, String paralelo, String jornada, String periodo) {
        super(id_asignacio, identificacion, asignatura, ciclo, paralelo, jornada, periodo);
    }

    public AsignacionMateriaDocenteBD() {
    }

    public List<AsignacionMateriaDocentesMD> mostrardatos() {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();
            String sql = "select * from asignacion_docentes where estado = 1";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setId_asignacio(rs.getInt("id_asignacion"));
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

    public List<AsignacionMateriaDocentesMD> obtenerdatos(String identificacion) {

        try {
            List<AsignacionMateriaDocentesMD> lista = new ArrayList<AsignacionMateriaDocentesMD>();

            String sql = "select * from asignacion_docentes" + " where\"identificacion\"='" + identificacion + "' and estado = 1";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                AsignacionMateriaDocentesMD asignacion = new AsignacionMateriaDocentesMD();
                asignacion.setId_asignacio(rs.getInt("id_asignacion"));
                asignacion.setIdentificacion(rs.getString("identificacion"));
                asignacion.setAsignatura(rs.getString("asignatura"));
                asignacion.setCiclo(rs.getString("ciclo"));
                asignacion.setJornada(rs.getString("jornada"));
                asignacion.setParalelo(rs.getString("paralelo"));
                asignacion.setPeriodo(rs.getString("periodo"));
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
        String nsql = "INSERT INTO asignacion_docentes(id_asignacion, identificacion, periodo, asignatura, ciclo, jornada, paralelo, estado)" + "VALUES ('" + getId_asignacio() + "','" + getIdentificacion() + "','" + getPeriodo() + "','" + getAsignatura() + "','" + getCiclo() + "','" + getJornada() + "','" + getParalelo() + "', 1)";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(int id_asignacion) {

        String sql = "UPDATE asignacion_docentes set \"ciclo\"='" + getCiclo() + "',\"paralelo\"='" + getParalelo() + "',\"jornada\"='" + getJornada() + "',\"asignatura\"='" + getAsignatura() + "'"
                + " where \"id_asignacion\"='" + id_asignacion + "';";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String id_asignacion) {
        String sql = "update asignacion_docentes set estado=0 where \"id_asignacion\"='" + id_asignacion + "';";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }

    public int mostrarIdPeriodo(String nombre) {
        int idPeriodo = 0;
        String sql = "select id_periodo from periodo_academico where nombre= '" + nombre + "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                idPeriodo = rs.getInt("id_periodo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPeriodo;
    }

    public String mostrarPeriodo(int idPeriodo) {
        String periodo = "";
        String sql = "select nombre from periodo_academico where id_periodo= '" + idPeriodo + "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {

                periodo = rs.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return periodo;
    }

    public String mostrarIdMateria(String nombre) {
        String idMateria = "";
        String sql = "select codigo from materia where materia= '" + nombre + "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {

                idMateria = rs.getString("codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idMateria;
    }

    public String mostrarCarrera(String identificacion) {
        String carrera = "";
        String sql = "select c.nombre as carrera from carrera c \n"
                + "join materia m\n"
                + "on m.nombre = c.codigo\n"
                + "join asignacion_docentes ac \n"
                + "on m.codigo = ac.asignatura\n"
                + "where ac.identificacion = '" + identificacion + "'";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {

                carrera = rs.getString("carrera");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carrera;
    }

    public int id() {
        int id_asigancion = 1;
        String sql = "select max(id_asignacion) as id from asignacion_docentes";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {

                id_asigancion = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerfilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_asigancion;
    }
}
