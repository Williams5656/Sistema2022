/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            if (conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Interciclo')") == null
                && conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Final')") == null
                && conectar.noQuery("INSERT INTO doc_instrumento_evaluacion(id_asignacion,descripcion) VALUES ('" + cod_max + "','Supletorio')") == null
                ); 
            else {
                System.out.println("Error al crear las notas");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de asignacion_docentes");
            return false;
        }
        return true;
    }
    
    public Object[][] datos_unidos(String carrera) {
        try {
            String sql = "select n.id_doc_instrumento, n.descripcion, ps.nombres||' '||ps.apellidos as docente,\n"
                    + "per.nombre as periodo, mt.materia, ad.ciclo, ad.jornada, ad.paralelo, n.documento\n"
                    + "from doc_instrumento_evaluacion n\n"
                    + "join asignacion_docentes ad on n.id_asignacion=ad.id_asignacion\n"
                    + "join persona ps on ad.identificacion=ps.cedula\n"
                    + "join periodo_academico per on ad.periodo=cast(per.id_periodo as varchar)\n"
                    + "join materia mt on ad.asignatura=mt.codigo"
                    + " where mt.nombre=(select codigo from carrera where nombre='" + carrera + "')";
            ResultSet rs = conectar.query(sql);
            int n_fil=0;
            while (rs.next()) { 
                n_fil++;
            }
            rs.close();
            ResultSet rs2 = conectar.query(sql);
            Object [][] m= new String[n_fil][9];
            int f=0;                    
            while (rs2.next()) {                
                m[f][0]=rs2.getString(1);
                m[f][1]=rs2.getString(2);
                m[f][2]=rs2.getString(3);
                m[f][3]=rs2.getString(4);
                m[f][4]=rs2.getString(5);
                m[f][5]=rs2.getString(6);
                m[f][6]=rs2.getString(7);
                m[f][7]=rs2.getString(8);
                m[f][8]=rs2.getBytes(9);
                f++;
            }
            rs2.close();
            return m;
        } catch (SQLException e) {
            Logger.getLogger(doc_modulo_MD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
