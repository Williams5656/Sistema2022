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
public class doc_instrumento_evaluacionMD {
    private int id_doc_instrumento;
    private String id_materia;
    private byte[] documento;
    private int id_periodo;

    public doc_instrumento_evaluacionMD() {
    }

    public doc_instrumento_evaluacionMD(int id_doc_instrumento, String id_materia, byte[] documento, int id_periodo) {
        this.id_doc_instrumento = id_doc_instrumento;
        this.id_materia = id_materia;
        this.documento = documento;
        this.id_periodo = id_periodo;
    }

    public int getId_doc_instrumento() {
        return id_doc_instrumento;
    }

    public void setId_doc_instrumento(int id_doc_instrumento) {
        this.id_doc_instrumento = id_doc_instrumento;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }
    
    
}
