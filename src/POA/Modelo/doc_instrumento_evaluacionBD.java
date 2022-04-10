/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;

/**
 *
 * @author MIGUEL
 */
public class doc_instrumento_evaluacionBD extends doc_instrumento_evaluacionMD{

    Conect conectar = new Conect();
        
    public doc_instrumento_evaluacionBD() {
    }
    
    public boolean crear_intrumentos() {
        int cod_max = 0;
        ResultSet rs;
        try {
            rs = conectar.query("select max (id_asignacion) from asignacion_docentes");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
            if (conectar.noQuery("INSERT INTO doc_nota(id_asignacion,descripcion) VALUES ('" + cod_max + "','Interciclo')") == null
                    && conectar.noQuery("INSERT INTO doc_nota(id_asignacion,descripcion) VALUES ('" + cod_max + "','Finales')") == null); else {
                System.out.println("Error al crear las notas");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de asignacion_docentes");
            return false;
        }
        return true;
    }
}
