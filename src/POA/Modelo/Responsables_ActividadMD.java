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
public class Responsables_ActividadMD {
     int id_responsable;
     int id_actividad;
     String cedula;

    public Responsables_ActividadMD(String cedula) {
        this.cedula = cedula;
    }
    
    public Responsables_ActividadMD(int id_responsable, int id_actividad, String cedula) {
        this.id_responsable = id_responsable;
        this.id_actividad = id_actividad;
        this.cedula = cedula;
    }

    public Responsables_ActividadMD() {
       
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
