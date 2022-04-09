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
public class doc_notas_MD {
    
    private int id_doc_nota;
    private String id_asignacion;
    private String descripcion;
    private Image documento; 

    public doc_notas_MD() {
    }

    public doc_notas_MD(int id_doc_nota, String id_asignacion, String descripcion, Image documento) {
        this.id_doc_nota = id_doc_nota;
        this.id_asignacion = id_asignacion;
        this.descripcion = descripcion;
        this.documento = documento;
    }

    public int getId_doc_nota() {
        return id_doc_nota;
    }

    public void setId_doc_nota(int id_doc_nota) {
        this.id_doc_nota = id_doc_nota;
    }

    public String getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(String id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getDocumento() {
        return documento;
    }

    public void setDocumento(Image documento) {
        this.documento = documento;
    }
    
    
}
