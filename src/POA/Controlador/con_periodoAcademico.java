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

    public con_periodoAcademico(vis_PeriodoAcademico vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void ingresar(){
        periodo.setFechainicio(vista.getDateFechaInicio().getDate());
        periodo.setFechafin(vista.getDateFechaFin().getDate());
    }
    
}
