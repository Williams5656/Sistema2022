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
    private int id_poa;
    private int id_proyecto;
    private int id_objetivo;
    private byte[] archivo; // momentaneo

    public EvidenciaMD() {
    }

    public EvidenciaMD(int id_evidencia, int id_actividades, int id_poa, int id_proyecto, int id_objetivo, byte[] archivo) {
        this.id_evidencia = id_evidencia;
        this.id_actividades = id_actividades;
        this.id_poa = id_poa;
        this.id_proyecto = id_proyecto;
        this.id_objetivo = id_objetivo;
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

    public int getId_poa() {
        return id_poa;
    }

    public void setId_poa(int id_poa) {
        this.id_poa = id_poa;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_objetivo() {
        return id_objetivo;
    }

    public void setId_objetivo(int id_objetivo) {
        this.id_objetivo = id_objetivo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

   
    
    
}
