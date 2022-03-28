/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author KEVIN LANDIVAR
 */
public class T_actividadMD {
    private int id_T_actividad;
    private String Nombre;
    private String Descripcion;

    public T_actividadMD() {
    }

    public T_actividadMD(int id_T_actividad, String Nombre, String Descripcion) {
        this.id_T_actividad = id_T_actividad;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getId_T_actividad() {
        return id_T_actividad;
    }

    public void setId_T_actividad(int id_T_actividad) {
        this.id_T_actividad = id_T_actividad;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
    
}
