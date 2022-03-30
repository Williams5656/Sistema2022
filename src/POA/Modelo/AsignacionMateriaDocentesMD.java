
package POA.Modelo;

/**
 *
 * @author PC FACTORY
 */
public class AsignacionMateriaDocentesMD {
    private String id_asignacio;
    private String identificacion;
    private String asignatura;
    private String ciclo;
    private String paralelo;
    private String jornada;
    private String periodo;

    public AsignacionMateriaDocentesMD() {
    }

    public AsignacionMateriaDocentesMD(String id_asignacio, String identificacion, String asignatura, String ciclo, String paralelo, String jornada, String periodo) {
        this.id_asignacio = id_asignacio;
        this.identificacion = identificacion;
        this.asignatura = asignatura;
        this.ciclo = ciclo;
        this.paralelo = paralelo;
        this.jornada = jornada;
        this.periodo = periodo;
    }

    public String getId_asignacio() {
        return id_asignacio;
    }

    public void setId_asignacio(String id_asignacio) {
        this.id_asignacio = id_asignacio;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
}
