/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.PeriodoacademicoBD;
import POA.Vista.*;

/**
 *
 * @author Isaac Mejia
 */
public class con_periodoAcademico {

    private final vis_PeriodoAcademico vista;
    PeriodoacademicoBD periodo = new PeriodoacademicoBD();
    private String carrera = "1";

    public con_periodoAcademico(vis_PeriodoAcademico vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnCrear().addActionListener(e -> ingresar());
        periodo.llenar_tabla(vista.getTabla());
    }

    public void ingresar() {
        if (check() == true) {
            periodo.setNombre(mes_anio(vista.getDateFechaInicio().getDate().getMonth(),
                    vista.getDateFechaInicio().getDate().getYear())
                    + "-"
                    + mes_anio(vista.getDateFechaFin().getDate().getMonth(),
                            vista.getDateFechaFin().getDate().getYear()));
            periodo.setCarrera(carrera);
            periodo.setFechainicio(vista.getDateFechaInicio().getDate());
            periodo.setFechafin(vista.getDateFechaFin().getDate());
            periodo.setEstado(combo_esta());

            if (periodo.insertar() == true) {
                System.out.println("periodo_creado");
            } else {
                System.out.println("error val crear periodo");
            }
            periodo.llenar_tabla(vista.getTabla());
        } else; //colocar un joption despues desde una clase general;        
    }

    public boolean combo_esta() {
        if (vista.getComboEstado().getSelectedIndex() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String mes_anio(int m, int a) {
        String res = "";
        switch (m) {
            case 0:
                res = "Ene";
                break;
            case 1:
                res = "Feb";
                break;
            case 2:
                res = "Mar";
                break;
            case 3:
                res = "Abr";
                break;
            case 4:
                res = "May";
                break;
            case 5:
                res = "Jun";
                break;
            case 6:
                res = "Jul";
                break;
            case 7:
                res = "Ago";
                break;
            case 8:
                res = "Sep";
                break;
            case 9:
                res = "Oct";
                break;
            case 10:
                res = "Nov";
                break;
            case 11:
                res = "Dic";
                break;
        }
        a = a + 1900;//el año es devuelto la resta del actual - 1900
        String[] dec = String.valueOf(a).split("");
        res = res + dec[2] + dec[3];
        System.out.println(res);
        return res;
    }

    public boolean check() {
        if (vista.getDateFechaInicio().getDate() == null) {
            return false;
        }
        if (vista.getDateFechaFin().getDate() == null) {
            return false;
        }
        if (vista.getDateFechaFin().getDate().before(vista.getDateFechaInicio().getDate())) {
            return false;
        }
        if (periodo.validar_fechas(carrera, vista.getDateFechaInicio().getDate(), vista.getDateFechaFin().getDate()) == false) {
            return false;
        }
        return true;
    }

}
