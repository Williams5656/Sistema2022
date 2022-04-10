/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.awt.Image;

/**
 *
 * @author MIGUEL
 */
public class doc_planes_claseMD {
    
    private int id_clase;
    private int id_periodo;
    private String id_materia;
    private int numero;
    private Image documento;

    public doc_planes_claseMD() {
    }

    public doc_planes_claseMD(int id_clase, int id_periodo, String id_materia, int numero, Image documento) {
        this.id_clase = id_clase;
        this.id_periodo = id_periodo;
        this.id_materia = id_materia;
        this.numero = numero;
        this.documento = documento;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Image getDocumento() {
        return documento;
    }

    public void setDocumento(Image documento) {
        this.documento = documento;
    }
    
    
}
