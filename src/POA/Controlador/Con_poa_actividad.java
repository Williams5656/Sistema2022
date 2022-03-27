/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.*;
import POA.Modelo.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class Con_poa_actividad {
      private final vis_poa_actividad vista;
      private ObjetivoOperativoBD baseDatosObjetivoOperativo = new ObjetivoOperativoBD();
      private ArrayList <ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
      private ArrayList <ProyectoMD> listaProyectos = new ArrayList<>();
      private ProyectoBD baseDatosProyecto = new ProyectoBD();

    public Con_poa_actividad(vis_poa_actividad vista) {
       this.vista = vista;
        vista.setVisible(true);
        cargarComboProyecto();
        cargarObjetivos();
        vista.getComboproyectos().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                cargarObjetivos();
            }
        });
  
    }
    
    public void cargarComboProyecto(){
        
        vista.getComboproyectos().removeAllItems();
        
        
        listaProyectos = baseDatosProyecto.mostrarDatos();
        
        for (ProyectoMD proyectos : listaProyectos){
            if (Con_Poa1.getId_poa() == proyectos.getId_Poa()){
                vista.getComboproyectos().addItem("Proyecto: " + proyectos.getNum_proyecto_carrera());
                
            }
        }
    }
    
    public void cargarObjetivos(){
        String itemCombo = (String) vista.getComboproyectos().getSelectedItem();
        int num_proyecto = Integer.parseInt(String.valueOf(itemCombo.charAt(itemCombo.length() - 1)));
        System.out.println(num_proyecto);
        
        vista.getCombo_objetivo_operarivo().removeAllItems();
        listaProyectos = baseDatosProyecto.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjetivoOperativo.mostrarDatos();
        
        for (ProyectoMD proyectos : listaProyectos){
            if (num_proyecto == proyectos.getNum_proyecto_carrera()){
                for (ObjetivoOperativoMD objetivos : listaObjetivosOperativos){
                    if (objetivos.getId_proyecto() == proyectos.getId_proyecto()){
                        vista.getCombo_objetivo_operarivo().addItem(objetivos.getObjetivo() + "");
                    }
                }
            }
        }
        
        
        
            
    }
}
