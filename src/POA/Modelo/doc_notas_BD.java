/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIGUEL
 */
public class doc_notas_BD extends doc_notas_MD {

    Conect conectar = new Conect();

    public doc_notas_BD() {
    }

    public boolean crear_silabos() {
        int cod_max = 0;
        ResultSet rs;
        try {
            rs = conectar.query("select max (id_asignacion) from asignacion_docentes");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
            if (conectar.noQuery("INSERT INTO doc_nota(id_periodo,descripcion)" + "VALUES ('" + cod_max + "','Interciclo)") == null
                    && conectar.noQuery("INSERT INTO doc_nota(id_periodo,descripcion)" + "VALUES ('" + cod_max + "','Finales)") == null); else {
                System.out.println("Error al crear las notas");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de asignacion_docentes");
            return false;
        }
        return true;
    }

    public Object[][] datos_unidos() {
        try {
            String sql = "select n.id_doc_nota, n.descripcion, ps.nombres||' '||ps.apellidos as docente,\n"
                    + "per.nombre as periodo, mt.materia, ad.ciclo, ad.jornada, ad.paralelo, n.documento\n"
                    + "from doc_nota n\n"
                    + "join asignacion_docentes ad on n.id_asignacion=ad.id_asignacion\n"
                    + "join persona ps on ad.identificacion=ps.cedula\n"
                    + "join periodo_academico per on ad.periodo=cast(per.id_periodo as varchar)\n"
                    + "join materia mt on ad.asignatura=mt.codigo";
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
                m[f][0]=rs2.getObject(1);
                m[f][1]=rs2.getObject(2);
                m[f][2]=rs2.getObject(3);
                m[f][3]=rs2.getObject(4);
                m[f][4]=rs2.getObject(5);
                m[f][5]=rs2.getObject(6);
                m[f][6]=rs2.getObject(7);
                m[f][7]=rs2.getObject(8);
                m[f][8]=rs2.getObject(9);
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
