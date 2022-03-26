/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Modelo;

/**
 *
 * @author sebastian
 */
public class IndicadorMD {
    private int id_indicador;
    private int id_actividades;
    private int linea_base;
    private int meta;
    private String indicador;

    public IndicadorMD() {
    }

    public IndicadorMD(int id_indicador, int id_actividades, int linea_base, int meta, String indicador) {
        this.id_indicador = id_indicador;
        this.id_actividades = id_actividades;
        this.linea_base = linea_base;
        this.meta = meta;
        this.indicador = indicador;
    }

    public int getId_indicador() {
        return id_indicador;
    }

    public void setId_indicador(int id_indicador) {
        this.id_indicador = id_indicador;
    }

    public int getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(int id_actividades) {
        this.id_actividades = id_actividades;
    }

    public int getLinea_base() {
        return linea_base;
    }

    public void setLinea_base(int linea_base) {
        this.linea_base = linea_base;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    
    
}
