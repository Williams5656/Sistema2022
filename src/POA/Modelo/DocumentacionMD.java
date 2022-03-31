/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author PC FACTORY
 */
public class DocumentacionMD {
    private int id_plan;
    private String id_asignacion;
    private String fecha;
    private String guias;
    private int horasGuia;
    private String estado;

    public DocumentacionMD() {
    }
    

    public DocumentacionMD(int id_plan, String id_asignacion, String fecha, String guias, int horasGuia, String estado) {
        this.id_plan = id_plan;
        this.id_asignacion = id_asignacion;
        this.fecha = fecha;
        this.guias = guias;
        this.horasGuia = horasGuia;
        this.estado = estado;
    }

    public String getGuias() {
        return guias;
    }

    public void setGuias(String guias) {
        this.guias = guias;
    }

    public int getHorasGuia() {
        return horasGuia;
    }

    public void setHorasGuia(int horasGuia) {
        this.horasGuia = horasGuia;
    }

    

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(String id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
