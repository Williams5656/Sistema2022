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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANNY
 */
public class PeriodoacademicoBD extends PeriodoacademicoMD {

    Conect conectar = new Conect();

    public PeriodoacademicoBD() {
    }

    public PeriodoacademicoBD(String nombre, Date fechainicio, Date fechafin, String carrera, boolean estado) {
        super(nombre, fechainicio, fechafin, carrera, estado);
    }

    public List<PeriodoacademicoMD> lista_periodos() {
        try {
            List<PeriodoacademicoMD> lista = new ArrayList<PeriodoacademicoMD>();
            String sql = "select * from periodo_academico";
            ResultSet rs = conectar.query(sql);

            while (rs.next()) {
                PeriodoacademicoMD m = new PeriodoacademicoMD();
                m.setIdperiodo(rs.getInt("id_periodo"));
                m.setNombre(rs.getString("nombre"));
                m.setFechainicio(rs.getDate("fecha_inicio"));
                m.setFechafin(rs.getDate("fecha_fin"));
                m.setCarrera(rs.getString("id_carrera"));
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
    
    public List<PeriodoacademicoMD> periodo_individual(int cod) {
       // PeriodoacademicoMD lista = new PeriodoacademicoMD();
        List<PeriodoacademicoMD> lista = new ArrayList<PeriodoacademicoMD>();
        try {
         
            //String sql = "select * from periodo_academico"+ "where \ "id_periodo\" ='"+cod+"'";
             String sql = "select * from periodo_academico" + " where \"id_periodo\"='" + cod + "'";
            ResultSet rs = conectar.query(sql);

            while (rs.next()) {
                PeriodoacademicoMD m = new PeriodoacademicoMD();
                m.setIdperiodo(rs.getInt("id_periodo"));
                m.setNombre(rs.getString("nombre"));
                m.setFechainicio(rs.getDate("fecha_inicio"));
                m.setFechafin(rs.getDate("fecha_fin"));
                m.setCarrera(rs.getString("id_carrera"));
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

    public void llenar_tabla(JTable t){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) t.getModel();
        int col = modelo.getRowCount();
        for (int j = t.getSelectedRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }        
        modelo.setRowCount(0);//pone el contador de filas en 0
        String sql = "select p.id_periodo,p.nombre,p.fecha_inicio,p.fecha_fin,c.nombre as carrera"
                + ",p.estado from periodo_academico p,carrera c\n" +
"                   where p.id_carrera=c.codigo";
        ResultSet rs = conectar.query(sql);
        try {
            int c=0;
            while (rs.next()){
                modelo.addRow(new Object[6]);
                t.setValueAt(rs.getInt(1),c,0);
                t.setValueAt(rs.getString(2),c,1);
                t.setValueAt(rs.getDate(3),c,2);
                t.setValueAt(rs.getDate(4),c,3);
                t.setValueAt(rs.getString(5),c,4);
                if (rs.getBoolean(6)==true) t.setValueAt("Activo",c,5);
                else t.setValueAt("Inactivo",c,5);
                c++;
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("error al mostrar periodos");
        }
    }

    public boolean insertar() {

        String nsql = "INSERT INTO periodo_academico(nombre,fecha_inicio,fecha_fin,id_carrera,estado)" + "VALUES ('" + getNombre() + "','" + getFechainicio() + "','" + getFechafin() + "','" + getCarrera() + "','" + isEstado() + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean validar_fechas(String car, Date fec_ini, Date fec_fin) {
        String sql = "select val_periodo('" + car + "','" + fec_ini + "','" + fec_ini + "');";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (Exception e) {
            System.out.println("Error  al comprovar validaciones de periodo en ssu funcion val_periodo");
        }
        return false;
    }

    public void ArrayList(JComboBox j){
        
    }
}
