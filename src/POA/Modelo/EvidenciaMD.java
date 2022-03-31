/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class EvidenciaMD {
    private int id_evidencia;
    private int id_actividades;
    private String archivo; // momentaneo

    public EvidenciaMD() {
    }

    public EvidenciaMD(int id_evidencia, int id_actividades, String archivo) {
        this.id_evidencia = id_evidencia;
        this.id_actividades = id_actividades;
        this.archivo = archivo;
    }

    public int getId_evidencia() {
        return id_evidencia;
    }

    public void setId_evidencia(int id_evidencia) {
        this.id_evidencia = id_evidencia;
    }

    public int getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(int id_actividades) {
        this.id_actividades = id_actividades;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
}
