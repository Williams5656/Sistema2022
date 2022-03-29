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
    PeriodoacademicoBD periodo;
    private String carrera;

    public con_periodoAcademico(vis_PeriodoAcademico vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void ingresar() {
        periodo.setNombre(mes_anio(vista.getDateFechaInicio().getDate().getMonth(),
                                vista.getDateFechaInicio().getDate().getYear())
                            + "-"
                            + mes_anio(vista.getDateFechaFin().getDate().getMonth(),
                                vista.getDateFechaFin().getDate().getYear()));
        periodo.setCarrera(carrera);
        periodo.setFechainicio(vista.getDateFechaInicio().getDate());
        periodo.setFechafin(vista.getDateFechaFin().getDate());
        periodo.setEstado(combo_esta());
        
        if (periodo.insertar()==true)System.out.println("periodo_creado");
        else System.out.println("error val crear periodo");
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
                res = "ENE";
                break;
            case 1:
                res = "FEB";
                break;
            case 2:
                res = "MAR";
                break;
            case 3:
                res = "ABR";
                break;
            case 4:
                res = "MAY";
                break;
            case 5:
                res = "JUN";
                break;
            case 6:
                res = "JUL";
                break;
            case 7:
                res = "AGO";
                break;
            case 8:
                res = "SEP";
                break;
            case 9:
                res = "OCT";
                break;
            case 10:
                res = "NOV";
                break;
            case 11:
                res = "DIC";
                break;
        }
        String[] dec = String.valueOf(a).split("");
        res = res + dec[2] + dec[3];
        return res;
    }

}
