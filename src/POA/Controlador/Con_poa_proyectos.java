/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.CarreraBD;
import POA.Modelo.Conect;
import POA.Modelo.ObjetivoOperativoBD;
import POA.Modelo.ObjetivoOperativoMD;

import POA.Modelo.PoaBD;
import POA.Modelo.PoaMD;
import POA.Modelo.ProyectoBD;
import POA.Modelo.ProyectoMD;
import POA.Vista.vis_poa_proyectos;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
    private DefaultTableModel modelo1 = new DefaultTableModel();
    private List<PoaMD> listapoa = new ArrayList<>();
    private PoaBD baseDatosPoa = new PoaBD();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private POA.Modelo.CarreraBD baseDatosCarrera = new CarreraBD();
    private static int id_proyecto;
    int poa = 0;

    public Con_poa_proyectos(vis_poa_proyectos vista, int id_poa) {
        this.vista = vista;
        poa = id_poa;
        vista.setVisible(true);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_guardar().setEnabled(false);
        vista.getTxtarea_obopera().setEnabled(false);
        vista.getBtnAñadir().setEnabled(false);
        vista.getTabla_proyecto().setEnabled(false);
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtnAñadir().addActionListener(e -> guardarobjetivo());
        vista.getBtn_imprimir().addActionListener(e -> imprimirpro());
        vista.getTabla_lista_proyectos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();//To change body of generated methods, choose Tools | Templates.
            }

        });
        vista.getBtnSiguiente().addActionListener(e -> abrirVentanaactividades());
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

        modelo1.setRowCount(0);
        modelo1.setColumnCount(0);
        modelo1.addColumn("Numero_objetivo_proyecto");
        modelo1.addColumn("Objetivo");
        Object[] fila = new Object[2];

        listaoperativo = obbd.mostrarDatos();
//        for (ObjetivoOperativoMD user : listaoperativo) {
////        for (int i = 0; i < listaoperativo.size(); i++) {
//            for (ProyectoMD usuario : lista) {
//                if (id_proyecto == user.getId_proyecto()) {
//                    fila[0] = user.getNum_objetivo_proyecto();
//                    fila[1] = user.getObjetivo();
//                    modelo1.addRow(fila);
//                }
//            }
//        }
        for (int i = 0; i < listaoperativo.size(); i++) {
            if (listaoperativo.get(i).getId_proyecto() == id_proyecto) {
                fila[0] = listaoperativo.get(i).getNum_objetivo_proyecto();
                fila[1] = listaoperativo.get(i).getObjetivo();
                System.out.println(id_proyecto);
                modelo1.addRow(fila);
            }

        }
        //  }
        vista.getTabla_proyecto().setModel(modelo1);

    }

    public void nuevo() {
        vista.getBtn_guardar().setEnabled(true);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getTxtarea_obopera().setEnabled(false);
        vista.getBtnAñadir().setEnabled(false);
        vista.getTabla_proyecto().setEnabled(false);
        int idpoa = vista.getTabla_lista_proyectos().getSelectedRow();
        int idpoas = vista.getTabla_proyecto().getSelectedRow();
        vista.getTxt_estrategia().setText("");
        vista.getTxt_obestra().setText("");
        vista.getTxt_obtac().setText("");
        vista.getTxtarea_obopera().setText("");

        int a = 0;
        vista.getN_proyectos().setText(vista.getTabla_lista_proyectos().getRowCount() + 1 + "");

    }

    public void guardar() {

        if (vista.getTxt_obestra().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN OBJETIVO ESTRATEGICO");
        } else if (vista.getTxt_obtac().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN OBJETIVO TACTICO");
        } else if (vista.getTxt_estrategia().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UNA ESTRATEGIA");
        } else {
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

    }

    public void guardarobjetivo() {
        if (vista.getTxtarea_obopera().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN OBJETIVO OPERATIVO");
        } else if (vista.getTxt_obestra().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN PROYECTO");
        } else {
            int num = 0;
            int ob = 0;
            String objetivo = "";
            num = Integer.parseInt(vista.getN_proyectos().getText());
            ob = (vista.getTabla_proyecto().getRowCount() + 1);
            objetivo = (vista.getTxtarea_obopera().getText());
            if (vista.getTxtarea_obopera().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE UN OBJETIVO OPERATIVO");
            } else {
                obbd.guardar(num, ob, objetivo);
                lista_objetivo();
            }
        }
    }

    public void seleccionar() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_lista_proyectos().getModel();
        int cedula = (int) modelo.getValueAt(vista.getTabla_lista_proyectos().getSelectedRow(), 1);
        List<ProyectoMD> listas = poabd.obtenerdatos(cedula);
        if (listas.size() > 0) {
            poabd.setId_Poa(listas.get(0).getId_Poa());
            poabd.setId_proyecto(listas.get(0).getId_proyecto());
            poabd.setNum_proyecto_carrera((listas.get(0).getNum_proyecto_carrera()));
            poabd.setObjetivo_estrategico(listas.get(0).getObjetivo_estrategico());
            poabd.setObjetivo_tactico(listas.get(0).getObjetivo_tactico());
            poabd.setEstrategia(listas.get(0).getEstrategia());

            vista.getN_proyectos().setText(poabd.getId_proyecto() + "");
            System.out.println(vista.getN_proyectos());
            vista.getTxt_obestra().setText(poabd.getObjetivo_estrategico() + "");
            vista.getTxt_obtac().setText(poabd.getObjetivo_tactico() + "");
            vista.getTxt_estrategia().setText(poabd.getEstrategia() + "");
            id_proyecto = poabd.getId_proyecto();
            lista_objetivo();
            vista.getBtn_modificar().setEnabled(true);
            vista.getBtn_eliminar().setEnabled(true);
            vista.getBtn_guardar().setEnabled(false);
            vista.getTxtarea_obopera().setEnabled(true);
            vista.getBtnAñadir().setEnabled(true);
            vista.getTabla_proyecto().setEnabled(true);
        }

    }

    public void abrirVentanaactividades() {

        POA.Vista.vis_poa_actividad zap = new POA.Vista.vis_poa_actividad();
        Con_principal.vista.getESCRITORIO().add(zap);
        Dimension desktopSize = Con_principal.vista.getESCRITORIO().getSize();
        Dimension FrameSize = zap.getSize();
        zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa_actividad proyectos = new Con_poa_actividad(zap);

    }

    public void imprimir() {
        Conect con = new Conect();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Poa_proyectos.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);

            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
        }
    }

    public void imprimirpro() {
        Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte Con POA",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte De Proyectos",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }
        if (resp.equals("Reporte Con POA")) {

            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Poa_proyectos.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
                String aguja = JOptionPane.showInputDialog("Ingrese una numero de proyecto");
                int agujas = 0;
                agujas = Integer.parseInt(aguja);

                params.put("POA", agujas);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (resp.equals("Reporte Completo")) {
            try {
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Poa_proyectos.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
                int agujas = 0;
                for (int i = 0; i < lista.size(); i++) {
                    agujas = lista.get(i).getNum_proyecto_carrera();
                    params.put("POA", agujas);
                    JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                    JasperViewer jv = new JasperViewer(jp, false);
                    jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    jv.setVisible(true);
                }

            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
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
