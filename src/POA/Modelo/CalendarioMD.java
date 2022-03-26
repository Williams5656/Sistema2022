/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author Renato Llivisaca
 */
public class CalendarioMD {
   private int id_Actividad;
    private String id_Carrera;
    private int id_Periodo;
    private int id_TipoActividad;
    private String Nombre_Actividad;
    private String Descripcion;
    private String Fecha_Inicio;
    private String Fecha_Limite;

    public CalendarioMD() {
    }

    public CalendarioMD(int id_Actividad, String id_Carrera, int id_Periodo, int id_TipoActividad, String Nombre_Actividad, String Descripcion, String Fecha_Inicio, String Fecha_Limite) {
        this.id_Actividad = id_Actividad;
        this.id_Carrera = id_Carrera;
        this.id_Periodo = id_Periodo;
        this.id_TipoActividad = id_TipoActividad;
        this.Nombre_Actividad = Nombre_Actividad;
        this.Descripcion = Descripcion;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Limite = Fecha_Limite;
    }

   

   

    public String getId_Carrera() {
        return id_Carrera;
    }

    public void setId_Carrera(String id_Carrera) {
        this.id_Carrera = id_Carrera;
    }

    public int getId_TipoActividad() {
        return id_TipoActividad;
    }

    public void setId_TipoActividad(int id_TipoActividad) {
        this.id_TipoActividad = id_TipoActividad;
    }


    public int getId_Periodo() {
        return id_Periodo;
    }

    public void setId_Periodo(int id_Periodo) {
        this.id_Periodo = id_Periodo;
    }

    public int getid_TipoActividad() {
        return id_TipoActividad;
    }

    public void setid_TipoActividad(int id_Actividad) {
        this.id_TipoActividad = id_Actividad;
    }

    public int getId_Actividad() {
        return id_Actividad;
    }

    public void setId_Actividad(int id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public String getNombre_Actividad() {
        return Nombre_Actividad;
    }

    public void setNombre_Actividad(String Nombre_Actividad) {
        this.Nombre_Actividad = Nombre_Actividad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Limite() {
        return Fecha_Limite;
    }

    public void setFecha_Limite(String Fecha_Limite) {
        this.Fecha_Limite = Fecha_Limite;
    }
    
    
}
