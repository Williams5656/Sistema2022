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
public class doc_planes_claseBD extends doc_planes_claseMD {

    Conect conectar = new Conect();

    public doc_planes_claseBD() {
    }

    public boolean crear_planes(String carrera) {
        int cod_max = 0;
        ResultSet rs;
        ResultSet rs2;
        ResultSet rs3;
        try {
            rs = conectar.query("select max (id_periodo) from periodo_academico");
            while (rs.next()) {
                cod_max = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod maximo de periodo");
            return false;
        }

        List<String> lista_mat = new ArrayList<>();

        try {
            rs2 = conectar.query("select codigo from materia where nombre=(select codigo from carrera where nombre='" + carrera + "')");
            while (rs2.next()) {
                lista_mat.add(rs2.getString(1));
            }
            rs2.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el cod de materia");
            return false;
        }

        List<Integer> lista_planes = new ArrayList<>();

        for (int i = 0; i < lista_mat.size(); i++) {
            try {
                rs3 = conectar.query("select plan from materia where codigo='" + lista_mat.get(i) + "'");
                while (rs3.next()) {
                    lista_planes.add(rs3.getInt(1));
                }
                rs3.close();
            } catch (Exception e) {
                System.out.println("Error al seleccionar los planes de materia");
                return false;
            }
        }

        for (int i = 0; i < lista_mat.size(); i++) {
            for (int j = 0; j < lista_planes.get(i); j++) {
                if (conectar.noQuery("INSERT INTO doc_planes_clase(id_periodo,id_materia,numero)" + "VALUES ('" + cod_max + "','" + lista_mat.get(i) + "',"+ (j+1) +");") == null){
                   System.out.println("plan "+lista_mat.get(i)+ " plan n° "+lista_planes.get(j)); 
                }                
                else {
                    System.out.println("Error al crear los doc de planes de clase " + lista_mat.get(i));
                    return false;
                }
            }
        }
        return true;
    }

    public Object[][] datos_unidos(String carrera) {
        try {
            String sql = "select sb.id_doc_silabo, per.nombre, mt.materia, sb.documento\n"
                    + "from doc_silabo sb \n"
                    + "join periodo_academico per on sb.id_periodo=per.id_periodo\n"
                    + "join materia mt on sb.id_materia=mt.codigo"
                    + " where mt.nombre=(select codigo from carrera where nombre='" + carrera + "')";
            ResultSet rs = conectar.query(sql);
            int n_fil = 0;
            while (rs.next()) {
                n_fil++;
            }
            rs.close();
            ResultSet rs2 = conectar.query(sql);
            Object[][] m = new String[n_fil][4];
            int f = 0;
            while (rs2.next()) {
                m[f][0] = rs2.getString(1);
                m[f][1] = rs2.getString(2);
                m[f][2] = rs2.getString(3);
                m[f][3] = rs2.getBytes(4);
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
