/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo.Validadores;

import POA.Controlador.Con_poa_evidencia;
import POA.Modelo.CarreraBD;
import POA.Modelo.ObjetivoOperativoBD;
import POA.Modelo.ObjetivoOperativoMD;
import POA.Modelo.PoaBD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.ProyectoMD;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class objetivo_evidencia implements ItemListener {

     private ArrayList<ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
    private ArrayList<ProyectoMD> listaProyectos = new ArrayList<>();
    private ProyectoBD baseDatosProyecto = new ProyectoBD();
    private ObjetivoOperativoBD baseDatosObjOperativo = new ObjetivoOperativoBD();
    JComboBox comboProyecto, comboObjetivo;

    public objetivo_evidencia(JComboBox comboProyecto, JComboBox comboObjetivo) {
        this.comboProyecto = comboProyecto;
        this.comboObjetivo = comboObjetivo;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String proyecto = (String) comboProyecto.getSelectedItem();
        if (Con_poa_evidencia.proyecto.equals("")) {
            comboObjetivo.removeAllItems();
            comboObjetivo.addItem("Seleccionar");
        } else if (Con_poa_evidencia.proyecto.equalsIgnoreCase("yes")) {
            if (proyecto != null) {
                listaObjetivosOperativos = baseDatosObjOperativo.mostrarDatos();
                int id_proyecto = id_proyecto(comboProyecto);
                comboObjetivo.removeAllItems();
                comboObjetivo.addItem("Seleccionar");
                for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
                    if (listaObjetivosOperativos.get(i).getId_proyecto() == id_proyecto) {
                        comboObjetivo.addItem(String.valueOf(listaObjetivosOperativos.get(i).getObjetivo()));
                        Con_poa_evidencia.actividad="Yes";
                    }
                }
                Con_poa_evidencia.proyecto_id=id_proyecto;
                System.out.println("Proyecto: "+Con_poa_evidencia.proyecto_id);
            } else {
                comboObjetivo.removeAllItems();
                comboObjetivo.addItem("Seleccionar");
            }
        }
    }

    public int id_proyecto(JComboBox comboproyecto) {
        listaProyectos = baseDatosProyecto.mostrarDatos();
        String proyecto = (String) comboproyecto.getSelectedItem();
        int id_proyecto = 0;
        if (Con_poa_evidencia.proyecto.equalsIgnoreCase("yes")) {
            if (proyecto != null) {
                if (proyecto != "Seleccionar") {
                    id_proyecto = Integer.parseInt(proyecto.trim());
                    for (int i = 0; i < listaProyectos.size(); i++) {
                        if (listaProyectos.get(i).getId_Poa() == Con_poa_evidencia.id_poa) {
                            if ((String.valueOf(listaProyectos.get(i).getId_proyecto()).equalsIgnoreCase(proyecto))) {
                                id_proyecto = listaProyectos.get(i).getId_proyecto();
                            }
                        }
                    }
                }
            }
        }
        return id_proyecto;
    }
}
