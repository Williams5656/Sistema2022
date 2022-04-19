/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class PoaMD {
    private int id_POA;
    private String id_carrera;
    private String anio;
    private String estado;

    public PoaMD() {
    }

    public PoaMD(int id_POA, String id_carrera, String anio, String estado) {
        this.id_POA = id_POA;
        this.id_carrera = id_carrera;
        this.anio = anio;
        this.estado = estado;
    }
    
    

    public int getId_POA() {
        return id_POA;
    }

    public void setId_POA(int id_POA) {
        this.id_POA = id_POA;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
