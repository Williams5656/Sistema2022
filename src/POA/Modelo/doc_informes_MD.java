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
public class doc_informes_MD {
    
    private int id_doc_informe;
    private String id_asignacion;
    private String descripcion;
    private byte[] documento; 

    public doc_informes_MD() {
    }

    public doc_informes_MD(int id_doc_informe, String id_asignacion, String descripcion, byte[] documento) {
        this.id_doc_informe = id_doc_informe;
        this.id_asignacion = id_asignacion;
        this.descripcion = descripcion;
        this.documento = documento;
    }

    public int getId_doc_informe() {
        return id_doc_informe;
    }

    public void setId_doc_informe(int id_doc_informe) {
        this.id_doc_informe = id_doc_informe;
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

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }
    
    
}
