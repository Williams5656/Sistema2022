/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class ObjetivoOperativoMD {
    private int id_objetivo_operativo;
    private int id_proyecto;
    private int num_objetivo_proyecto;
    private String objetivo;

    public ObjetivoOperativoMD() {
    }

    public ObjetivoOperativoMD(int id_objetivo_operativo, int id_proyecto, int num_objetivo_proyecto, String objetivo) {
        this.id_objetivo_operativo = id_objetivo_operativo;
        this.id_proyecto = id_proyecto;
        this.num_objetivo_proyecto = num_objetivo_proyecto;
        this.objetivo = objetivo;
    }

    public int getId_objetivo_operativo() {
        return id_objetivo_operativo;
    }

    public void setId_objetivo_operativo(int id_objetivo_operativo) {
        this.id_objetivo_operativo = id_objetivo_operativo;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getNum_objetivo_proyecto() {
        return num_objetivo_proyecto;
    }

    public void setNum_objetivo_proyecto(int num_objetivo_proyecto) {
        this.num_objetivo_proyecto = num_objetivo_proyecto;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    
}
