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
public class Responsables_ActividadMD extends CalendarioMD {
     int id_responsable;
     int id_actividad;
     String cedula;

    public Responsables_ActividadMD(int id_responsable, int id_actividad, String cedula) {
        this.id_responsable = id_responsable;
        this.id_actividad = id_actividad;
        this.cedula = cedula;
    }

    public Responsables_ActividadMD(int id_responsable, int id_actividad, String cedula, int id_Actividad, String id_Carrera, int id_Periodo, int id_TipoActividad, String Nombre_Actividad, String Descripcion, String Fecha_Inicio, String Fecha_Limite) {
        super(id_Actividad, id_Carrera, id_Periodo, id_TipoActividad, Nombre_Actividad, Descripcion, Fecha_Inicio, Fecha_Limite);
        this.id_responsable = id_responsable;
        this.id_actividad = id_actividad;
        this.cedula = cedula;
    }
     

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
     
     
}
