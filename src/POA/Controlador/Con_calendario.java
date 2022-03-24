/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.Vis_Calendar;
import POA.Modelo.CarreraBD;
import POA.Modelo.CarreraMD;
import java.util.List;

/**
 *
 * @author Myrian
 */
public class Con_calendario {
     private final Vis_Calendar vista;
     private CarreraBD carrerabd = new CarreraBD();

    public Con_calendario(Vis_Calendar vista) {
        this.vista = vista;
         vista.setVisible(true);
         
         carrera();
    }
    
   public void carrera(){
        
        List<CarreraMD> listar = carrerabd.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            vista.getComobo_carrera().addItem(listar.get(i).getNombre_carrera());
        }  
    } 
   
   public int TipoActividad(){
       int id = 0;
       String tipo_actividad = (String) vista.getCombo_tipo_actividad_repor().getSelectedItem();
       if (tipo_actividad.equalsIgnoreCase("POA")){
           id=01;
       }else if(tipo_actividad.equalsIgnoreCase("Titulacion")){
           id=02;
       }else if(tipo_actividad.equalsIgnoreCase("Calendario")){
           id=03;
       }else if(tipo_actividad.equalsIgnoreCase("Examen Complexión")){
           id=04;
       }else if(tipo_actividad.equalsIgnoreCase("Graduación")){
           id=05;
       }else if(tipo_actividad.equalsIgnoreCase("Todos")){
           id=06;
       }else if(tipo_actividad.equalsIgnoreCase("Seleccionar")){
           
       }
       return id;
   }
}
