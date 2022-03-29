/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.CarreraMD;
import POA.Modelo.ProyectoMD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import POA.Vista.vis_poa_evidencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Con_poa_evidencia {
      private final vis_poa_evidencia vista;
      private ArrayList <ProyectoMD> listaProyectos = new ArrayList<>();
      private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
      private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
      private ProyectoBD baseDatosProyecto = new ProyectoBD();
      private CarreraBD baseDatosCarrera = new CarreraBD();
      private PoaBD baseDatosPoa = new PoaBD();
    
    public Con_poa_evidencia(vis_poa_evidencia vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    public void cargarComboProyecto(){
        vista.getCbx_proyecto().removeAllItems();
        listaProyectos = baseDatosProyecto.mostrarDatos();       
        for (ProyectoMD proyectos : listaProyectos){
            if (Con_Poa1.getId_poa() == proyectos.getId_Poa()){
                vista.getCbx_proyecto().addItem("Proyecto: " + proyectos.getNum_proyecto_carrera()); 
            }
        }
    }
    public void cargarComboCarrera(){
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPoa = baseDatosPoa.mostrarDatos();
        vista.getCbx_carrera().removeAllItems();
        for (int i = 0; i < listaPoa.size(); i++) {
            if(String.valueOf(listaPoa.get(i).getId_carrera()).equals(String.valueOf(listaCarreras.get(i).getCodigo_carrera()))){
                vista.getCbx_proyecto().addItem(listaCarreras.get(i).getNombre_carrera());
            }
        }
    }
}
