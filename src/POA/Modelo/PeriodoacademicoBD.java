/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANNY
 */
public class PeriodoacademicoBD extends PeriodoacademicoMD {

    Conect conectar = new Conect();


    public PeriodoacademicoBD() {
    }

    public List<PeriodoacademicoMD> mostrardatos() {
        try {
            List<PeriodoacademicoMD> lista = new ArrayList<PeriodoacademicoMD>();
            String sql = "select * from peridoacademico";
            ResultSet rs = conectar.query(sql);

            while (rs.next()) {
                PeriodoacademicoMD m = new PeriodoacademicoMD();
                m.setIdperiodo(rs.getInt("idperiodo"));
                m.setFechainicio(rs.getDate("fechainicio"));
                m.setFechafin(rs.getDate("fechafin"));
                m.setCarrera(rs.getString("carrera"));
                m.setEstado(rs.getBoolean("estado"));

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(PeriodoacademicoMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<PeriodoacademicoMD> obtenerdatos(int idperiodo) {
        try {
            List<PeriodoacademicoMD> lista = new ArrayList<PeriodoacademicoMD>();
            String sql = "select * from periodoacademico" + " where \"idperiodo\"='" + idperiodo + "'";
            ResultSet rs = conectar.query(sql);

            while (rs.next()) {
                PeriodoacademicoMD m = new PeriodoacademicoMD();
                m.setIdperiodo(rs.getInt("idperiodo"));
                m.setFechainicio(rs.getDate("fechainicio"));
                m.setFechafin(rs.getDate("fechafin"));
                m.setCarrera(rs.getString("carrera"));
                m.setEstado(rs.getBoolean("estado"));

                lista.add(m);

            }
            rs.close();
            return lista;
        } catch (SQLException e) {

            Logger.getLogger(PeriodoacademicoMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {

        String nsql = "INSERT INTO periodoacademico(nombre,fechainicio,fechafin,carrera,estado)" + "VALUES ('" + getNombre()+ "','" + getFechainicio()+ "','" + getFechafin()+ "','" + getCarrera()+ "','" + isEstado()+ "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }







}
