/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.ProyectoMD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import POA.Controlador.Con_poa_evidencia;

/**
 *
 * @author ASUS
 */
public class proyecto_evidencia implements ItemListener {

    private JComboBox Cbx_carrera, Cbx_anio, Cbx_proyecto;
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private List<POA.Modelo.PoaMD> listaPoa = new ArrayList<>();
    private ArrayList<ProyectoMD> listaProyectos = new ArrayList<>();
    private ProyectoBD baseDatosProyecto = new ProyectoBD();
    private CarreraBD baseDatosCarrera = new CarreraBD();
    private PoaBD baseDatosPoa = new PoaBD();

    public proyecto_evidencia(JComboBox Cbx_carrera, JComboBox Cbx_anio, JComboBox Cbx_proyecto) {
        this.Cbx_carrera = Cbx_carrera;
        this.Cbx_anio = Cbx_anio;
        this.Cbx_proyecto = Cbx_proyecto;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        listaPoa = baseDatosPoa.mostrarDatos();
        listaProyectos = baseDatosProyecto.mostrarDatos();
        String carrera = (String) Cbx_carrera.getSelectedItem();
        Con_poa_evidencia.anio = (String) Cbx_anio.getSelectedItem();
        System.out.println(Con_poa_evidencia.anio);
        System.out.println(carrera);
        if (carrera != "Seleccionar" || Con_poa_evidencia.anio != "Seleccionar" || Con_poa_evidencia.anio!="null") {
            Cbx_proyecto.removeAllItems();
            Cbx_proyecto.addItem("Seleccionar");
            for (int i = 0; i < listaPoa.size(); i++) {
                if (listaPoa.get(i).getId_carrera() == Integer.parseInt(Con_poa_evidencia.id_carrera)) {
                    if (listaPoa.get(i).getAnio() == Con_poa_evidencia.anio) {
                        Con_poa_evidencia.id_poa=listaPoa.get(i).getId_POA();
                    }
                }

            }
            for (int j = 0; j < listaProyectos.size(); j++) {
                if (listaProyectos.get(j).getId_Poa() == Con_poa_evidencia.id_poa) {
                    Cbx_proyecto.addItem(listaProyectos.get(j).getNum_proyecto_carrera());
                }
            }
        } else {
            Cbx_proyecto.removeAllItems();
            Cbx_proyecto.addItem("Seleccionar");
        }
    }

}
