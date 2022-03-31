/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class ActividadesMD {
    private int id_actividades;
    private int id_objetivo_operativo;
    private String actividad;
    private String responsable;
    private String plazo;
    private String recurso_financiero;

    public ActividadesMD() {
    }

    public ActividadesMD(int id_actividades, int id_objetivo_operativo, String actividad, String responsable, String plazo, String recurso_financiero) {
        this.id_actividades = id_actividades;
        this.id_objetivo_operativo = id_objetivo_operativo;
        this.actividad = actividad;
        this.responsable = responsable;
        this.plazo = plazo;
        this.recurso_financiero = recurso_financiero;
    }

    public int getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(int id_actividades) {
        this.id_actividades = id_actividades;
    }

    public int getId_objetivo_operativo() {
        return id_objetivo_operativo;
    }

    public void setId_objetivo_operativo(int id_objetivo_operativo) {
        this.id_objetivo_operativo = id_objetivo_operativo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getRecurso_financiero() {
        return recurso_financiero;
    }

    public void setRecurso_financiero(String recurso_financiero) {
        this.recurso_financiero = recurso_financiero;
    }
    
    
}
