/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class ProyectoMD {
    private int id_proyecto;
    private int id_Poa;
    private int num_proyecto_carrera;
    private String objetivo_estrategico;
    private String objetivo_tactico;
    private String estrategia;

    public ProyectoMD() {
    }

        
    public ProyectoMD(int id_proyecto, int id_Poa, int num_proyecto_carrera, String objetivo_estrategico, String objetivo_tactico, String estrategia) {
        this.id_proyecto = id_proyecto;
        this.id_Poa = id_Poa;
        this.num_proyecto_carrera = num_proyecto_carrera;
        this.objetivo_estrategico = objetivo_estrategico;
        this.objetivo_tactico = objetivo_tactico;
        this.estrategia = estrategia;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_Poa() {
        return id_Poa;
    }

    public void setId_Poa(int id_Poa) {
        this.id_Poa = id_Poa;
    }

    public int getNum_proyecto_carrera() {
        return num_proyecto_carrera;
    }

    public void setNum_proyecto_carrera(int num_proyecto_carrera) {
        this.num_proyecto_carrera = num_proyecto_carrera;
    }

    public String getObjetivo_estrategico() {
        return objetivo_estrategico;
    }

    public void setObjetivo_estrategico(String objetivo_estrategico) {
        this.objetivo_estrategico = objetivo_estrategico;
    }

    public String getObjetivo_tactico() {
        return objetivo_tactico;
    }

    public void setObjetivo_tactico(String objetivo_tactico) {
        this.objetivo_tactico = objetivo_tactico;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }
    
    
    
}
