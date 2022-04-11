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
    public static int id_pro;
    public static ArrayList<Integer> listasobjetivos = new ArrayList();
    public static ArrayList<Integer> listas_id_objetivos = new ArrayList();
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

    private boolean tablaSeleccionada = false;

    public Con_poa_proyectos(vis_poa_proyectos vista, int id_poa,String carrera, String anio) {
        this.vista = vista;
        poa = id_poa;
        vista.setVisible(true);
        vista.getBtn_eliminar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getBtn_guardar().setEnabled(false);
        vista.getTxtarea_obopera().setEnabled(false);
        vista.getBtnAñadir_op().setEnabled(false);
        vista.getTabla_proyecto().setEnabled(false);
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtn_guardar().addActionListener(e -> guardar());
        vista.getBtnAñadir_op().addActionListener(e -> guardarobjetivo());
        vista.getBtn_imprimir().addActionListener(e -> imprimirpro());
        vista.getBtnSiguiente().addActionListener(e -> abrirVentanaactividad());

        vista.getTabla_lista_proyectos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                seleccionarobjetivo();
                seleccionar();
            }

        });

        vista.getTabla_proyecto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                seleccionarob();
            }

        });
        vista.getLb_poa().setText(id_poa+"");
        vista.getLb_carrera().setText(carrera);
        vista.getLb_anio().setText(anio+"");

        lista_poa();

    }

    

    public void lista_poa() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);

        modelo.addColumn("Id_poa");
        modelo.addColumn("Id_proyecto");
        modelo.addColumn("Numero de Proyecto");
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
        modelo1.addColumn("ID proyecto");
        modelo1.addColumn("Numero_objetivo_proyecto");
        modelo1.addColumn("Objetivo");
        Object[] fila = new Object[3];

        listaoperativo = obbd.mostrarDatos();

        for (int i = 0; i < listaoperativo.size(); i++) {
            if (listaoperativo.get(i).getId_proyecto() == id_proyecto) {
                fila[0] = listaoperativo.get(i).getId_proyecto();
                fila[1] = listaoperativo.get(i).getNum_objetivo_proyecto();
                fila[2] = listaoperativo.get(i).getObjetivo();

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
        vista.getBtnAñadir_op().setEnabled(false);
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
            vista.getBtnAñadir_op().setEnabled(true);
            vista.getTabla_proyecto().setEnabled(true);
        }

    }

    public void seleccionarob() {
        try{
         modelo1 = (DefaultTableModel) vista.getTabla_proyecto().getModel();
        
        int cedula = (int) modelo1.getValueAt(vista.getTabla_proyecto().getSelectedRow(), 0);
        int cedulas = (int) modelo1.getValueAt(vista.getTabla_proyecto().getSelectedRow(), 1);
        
        List<ObjetivoOperativoMD> listas = obbd.obtenerdatosob(cedula, cedulas);
        if (listas.size() > 0) {
            obbd.setObjetivo(listas.get(0).getObjetivo());

            vista.getTxtarea_obopera().setText(obbd.getObjetivo() + "");

        }
        } catch(java.lang.ClassCastException e){
            
        }
//        
       

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

                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Poa_proyectos_completos.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);

                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
            }
        }
    }

    public void seleccionarobjetivo() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_lista_proyectos().getModel();
        listasobjetivos.clear();
        int ob = (int) modelo.getValueAt(vista.getTabla_lista_proyectos().getSelectedRow(), 1);
        tablaSeleccionada = true;
        listaoperativo = obbd.obtenerdatosparacombo(ob);
        for (int i = 0; i < listaoperativo.size(); i++) {
            if (listaoperativo.get(i).getId_proyecto() == ob) {

                listasobjetivos.add(listaoperativo.get(i).getId_objetivo_operativo());

                id_pro = listaoperativo.get(i).getId_proyecto();
                System.out.println(id_pro);

            }
        }

        System.out.println(ob);

    }

    public void abrirVentanaactividad() {

        if (tablaSeleccionada) {
            POA.Vista.vis_poa_actividad zap = new POA.Vista.vis_poa_actividad();
            Con_principal.vista.getESCRITORIO().add(zap);
            Dimension desktopSize = Con_principal.vista.getESCRITORIO().getSize();
            Dimension FrameSize = zap.getSize();
            zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            Con_poa_actividad proyectos = new Con_poa_actividad(zap, id_pro);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una actividad de la tabla");
        }
    }

    public static int getId_pro() {
        return id_pro;
    }
}
