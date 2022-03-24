/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.util.Date;

/**
 *
 * @author DANNY
 */
public class PeriodoacademicoMD {
   private int idperiodo;
   private Date fechainicio;
   private Date fechafin;
   private String carrera;
   private String estado;

    public PeriodoacademicoMD(int idperiodo, Date fechainicio, Date fechafin, String carrera, String estado) {
        this.idperiodo = idperiodo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.carrera = carrera;
        this.estado = estado;
    }
    public PeriodoacademicoMD(){
        
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}
