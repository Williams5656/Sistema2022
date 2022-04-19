/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author Myrian
 */
public class NomCalendarioMD {
    private int id_actividad;
    private String id_carrera;
    private String id_periodo;
    private String id_tipoactividad;
    private String nombre_actividad;
    private String descripcion;
    private String fecha_ini;
    private String fecha_lim;
    private byte[] archivo;

    public NomCalendarioMD(int id_actividad, String id_carrera, String id_periodo, String id_tipoactividad, String nombre_actividad, String descripcion, String fecha_ini, String fecha_lim, byte[] archivo) {
        this.id_actividad = id_actividad;
        this.id_carrera = id_carrera;
        this.id_periodo = id_periodo;
        this.id_tipoactividad = id_tipoactividad;
        this.nombre_actividad = nombre_actividad;
        this.descripcion = descripcion;
        this.fecha_ini = fecha_ini;
        this.fecha_lim = fecha_lim;
        this.archivo = archivo;
    }

    public NomCalendarioMD() {
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(String id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getId_tipoactividad() {
        return id_tipoactividad;
    }

    public void setId_tipoactividad(String id_tipoactividad) {
        this.id_tipoactividad = id_tipoactividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_lim() {
        return fecha_lim;
    }

    public void setFecha_lim(String fecha_lim) {
        this.fecha_lim = fecha_lim;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

   
    
}
