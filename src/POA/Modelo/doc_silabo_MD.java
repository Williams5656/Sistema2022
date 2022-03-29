/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.awt.Image;

/**
 *
 * @author DANNY
 */
public class doc_silabo_MD {

    private int id_doc_silabo;
    private String id_materia;
    private Image documento;
    private int id_periodo;

    public doc_silabo_MD(int id_doc_silabo, String id_materia, Image documento, int id_periodo) {
        this.id_doc_silabo = id_doc_silabo;
        this.id_materia = id_materia;
        this.documento = documento;
        this.id_periodo = id_periodo;
    }
    public doc_silabo_MD(){
        
    }

    public int getId_doc_silabo() {
        return id_doc_silabo;
    }

    public void setId_doc_silabo(int id_doc_silabo) {
        this.id_doc_silabo = id_doc_silabo;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public Image getDocumento() {
        return documento;
    }

    public void setDocumento(Image documento) {
        this.documento = documento;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }
    
    

}
