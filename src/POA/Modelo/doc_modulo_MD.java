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
public class doc_modulo_MD {
    private int id_doc_modulo;
    private int id_periodo;
    private String id_materia;
    private Image documento;

    public doc_modulo_MD(int id_doc_modulo, int id_periodo, String id_materia, Image documento) {
        this.id_doc_modulo = id_doc_modulo;
        this.id_periodo = id_periodo;
        this.id_materia = id_materia;
        this.documento = documento;
    }

    public doc_modulo_MD(){
        
    }
    public int getId_doc_modulo() {
        return id_doc_modulo;
    }

    public void setId_doc_modulo(int id_doc_modulo) {
        this.id_doc_modulo = id_doc_modulo;
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

    public Image getDocumento() {
        return documento;
    }

    public void setDocumento(Image documento) {
        this.documento = documento;
    }
    
    
    
    
    
    
}
