/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.CarreraBD;
import POA.Modelo.ObjetivoOperativoBD;
import POA.Modelo.ObjetivoOperativoMD;

import POA.Modelo.PoaBD;
import POA.Modelo.PoaMD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.ProyectoMD;
import POA.Vista.vis_poa_proyectos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Con_poa_proyectos {

    private final vis_poa_proyectos vista;
    ProyectoBD poabd = new ProyectoBD();
    ObjetivoOperativoBD obbd = new ObjetivoOperativoBD();
    private List<ProyectoMD> lista = new ArrayList<>();
    private List<ObjetivoOperativoMD> listaoperativo = new ArrayList<>();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<PoaMD> listapoa = new ArrayList<>();
    private PoaBD baseDatosPoa = new PoaBD();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private POA.Modelo.CarreraBD baseDatosCarrera = new CarreraBD();
    int poa = 0;

    public Con_poa_proyectos(vis_poa_proyectos vista, int id_poa) {
        this.vista = vista;
        poa = id_poa;
        vista.setVisible(true);
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtnAñadir().addActionListener(e -> guardarobjetivo());
        vista.getTabla_lista_proyectos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();//To change body of generated methods, choose Tools | Templates.
            }

        });
        lista_poa();
    }

    public void lista_poa() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.addColumn("Id_poa");
        modelo.addColumn("Id_proyecto");
        modelo.addColumn("Numero_carrera");
        modelo.addColumn("Objetivo estrategico");
        modelo.addColumn("Objetivo tactico");
        modelo.addColumn("estrategia");
        Object[] fila = new Object[6];

        lista = poabd.mostrarDatos();
        listapoa = baseDatosPoa.mostrarDatos();
        listaCarreras = baseDatosCarrera.mostrardatos();

        //  for (ProyectoMD user : lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId_Poa() == poa) {
                fila[0] = poa;
                fila[1] = lista.get(i).getId_proyecto();
                fila[2] = lista.get(i).getNum_proyecto_carrera();
                fila[3] = lista.get(i).getObjetivo_estrategico();
                fila[4] = lista.get(i).getObjetivo_tactico();
                fila[5] = lista.get(i).getEstrategia();
                modelo.addRow(fila);
            }

        }

        //  }
        vista.getTabla_lista_proyectos().setModel(modelo);
    }

    public void lista_objetivo() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.addColumn("Numero_objetivo_proyecto");
        modelo.addColumn("Objetivo");
        Object[] fila = new Object[1];

        listaoperativo = obbd.mostrarDatos();
        //  for (ProyectoMD user : lista) {
        for (int i = 0; i < listaoperativo.size(); i++) {
            if (listaoperativo.get(i).getId_proyecto() == lista.get(i).getId_proyecto()) {
                
                fila[0] = listaoperativo.get(i).getNum_objetivo_proyecto();
                fila[1] = listaoperativo.get(i).getObjetivo();
                modelo.addRow(fila);
            }

        }

        //  }
        vista.getTabla_proyecto().setModel(modelo);
    }

    public void nuevo() {
        int idpoa = vista.getTabla_lista_proyectos().getSelectedRow();
        vista.getTxt_estrategia().setText("");
        vista.getTxt_obestra().setText("");
        vista.getTxt_obtac().setText("");
        vista.getTxtarea_obopera().setText("");
        int a = 0;
        vista.getN_proyectos().setText(vista.getTabla_lista_proyectos().getRowCount() + 1 + "");

    }

    public void guardar() {
        int num = 0;
        int poas = 0;
        String ob = "", tac = "", est = "";
        num = Integer.parseInt(vista.getN_proyectos().getText());
        ob = (vista.getTxt_obestra().getText());
        tac = vista.getTxt_obtac().getText();
        est = vista.getTxt_estrategia().getText();

        poabd.guardar(poa, num, ob, tac, est);
        lista_poa();
    }

    public void guardarobjetivo() {
        int num = 0;
        int ob = 0;
        String objetivo = "";
        num = Integer.parseInt(vista.getN_proyectos().getText());
        ob = (vista.getTabla_proyecto().getRowCount() + 1);
        objetivo = (vista.getTxtarea_obopera().getText());

        obbd.guardar(num, ob, objetivo);
        lista_objetivo();
    }

    public void seleccionar() {
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_lista_proyectos().getModel();
        int select = vista.getTabla_lista_proyectos().getSelectedRow();

        lista = poabd.mostrarDatos();
        poabd.setId_Poa(lista.get(0).getId_Poa());
        poabd.setId_proyecto(lista.get(0).getId_proyecto());
        poabd.setNum_proyecto_carrera((lista.get(0).getNum_proyecto_carrera()));
        poabd.setObjetivo_estrategico(lista.get(0).getObjetivo_estrategico());
        poabd.setObjetivo_tactico(lista.get(0).getObjetivo_tactico());
        poabd.setEstrategia(lista.get(0).getEstrategia());

        vista.getN_proyectos().setText(lista.get(select).getNum_proyecto_carrera() + "");
        vista.getTxt_obestra().setText(lista.get(select).getObjetivo_estrategico() + "");
        vista.getTxt_obtac().setText(lista.get(select).getObjetivo_tactico() + "");
        vista.getTxt_estrategia().setText(lista.get(select).getEstrategia() + "");
        
    }

//    public void seleccionarobjetivo() {
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTabla_proyecto().getModel();
//        int select = vista.getTabla_proyecto().getSelectedRow();
//
//        listaoperativo = obbd.mostrarDatos();
//        obbd.setObjetivo(listaoperativo.get(0).getObjetivo());
//
//        vista.getTxtarea_obopera().setText(listaoperativo.get(select).getObjetivo() + "");
//
//    }
}
