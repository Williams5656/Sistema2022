/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

/**
 *
 * @author HP
 */
public class docenteMD {
    private String cedula;
    private String titulo;
    private String abreviatura;
    private String tiempo;
    private String ocupacion;

    public docenteMD() {
    }

    public docenteMD(String cedula, String titulo, String abreviatura, String tiempo, String ocupacion) {
        this.cedula = cedula;
        this.titulo = titulo;
        this.abreviatura = abreviatura;
        this.tiempo = tiempo;
        this.ocupacion = ocupacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
}
