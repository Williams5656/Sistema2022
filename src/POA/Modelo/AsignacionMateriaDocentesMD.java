
package POA.Modelo;

/**
 *
 * @author PC FACTORY
 */
public class AsignacionMateriaDocentesMD {
    private String identificacio;
    private String asignatura;
    private String ciclo;
    private String paralelo;
    private String jornada;
    private String periodo;

    public AsignacionMateriaDocentesMD() {
    }

    public AsignacionMateriaDocentesMD(String identificacio, String asignatura, String ciclo, String paralelo, String jornada, String periodo) {
        this.identificacio = identificacio;
        this.asignatura = asignatura;
        this.ciclo = ciclo;
        this.paralelo = paralelo;
        this.jornada = jornada;
        this.periodo = periodo;
    }

    public String getIdentificacio() {
        return identificacio;
    }

    public void setIdentificacio(String identificacio) {
        this.identificacio = identificacio;
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
