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

    private JComboBox Cbx_proyecto, Cbx_obje_opera;

    public objetivo_evidencia(JComboBox Cbx_proyecto, JComboBox Cbx_obje_opera) {
        this.Cbx_proyecto = Cbx_proyecto;
        this.Cbx_obje_opera = Cbx_obje_opera;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        listaProyectos = baseDatosProyecto.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjOperativo.mostrarDatos();
        String proyecto = (String) Cbx_proyecto.getSelectedItem();
        if (proyecto != "Seleccionar") {
            Cbx_obje_opera.removeAllItems();
            Cbx_obje_opera.addItem("Seleccionar");
            for (int i = 0; i < listaProyectos.size(); i++) {
                if ((listaProyectos.get(i).getNum_proyecto_carrera() == Integer.parseInt(proyecto)) && (listaProyectos.get(i).getId_Poa() == Con_poa_evidencia.id_poa)) {
                    Con_poa_evidencia.id_proyecto = listaProyectos.get(i).getId_proyecto();
                }
            }
            for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
                if (listaObjetivosOperativos.get(i).getId_proyecto() == Con_poa_evidencia.id_proyecto) {
                    Cbx_obje_opera.addItem(String.valueOf(listaObjetivosOperativos.get(i).getNum_objetivo_proyecto()));
                }
            }
        } else {
            Cbx_obje_opera.removeAllItems();
            Cbx_obje_opera.addItem("Seleccionar");
        }
    }
}
