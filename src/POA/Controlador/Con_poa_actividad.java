/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.*;
import POA.Modelo.*;
import POA.Modelo.Validadores.*;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import POA.Controlador.Con_poa_proyectos.*;

/**
 *
 * @author USUARIO
 */
public class Con_poa_actividad {
      private final vis_poa_actividad vista;
      public static int id_act;
      private ObjetivoOperativoBD baseDatosObjetivoOperativo = new ObjetivoOperativoBD();
      private ArrayList <ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
      private ArrayList <ProyectoMD> listaProyectos = new ArrayList<>();
      private ArrayList<ActividadesMD> listactividades = new ArrayList();
      private ProyectoBD baseDatosProyecto = new ProyectoBD();
      private ActividadesBD baseDatosactividades = new ActividadesBD();
      private ArrayList<Integer> listas = new ArrayList();
      private int idobjetivo=0;
      private SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd");
      private SimpleDateFormat formatosd = new SimpleDateFormat("yyyy/MM/dd");
      
      private boolean tablaSeleccionada = false;
      
      
      private docenteBD bdocente = new docenteBD();
      private PersonaBD bpersona = new PersonaBD();
      
      

    public Con_poa_actividad(vis_poa_actividad vista) {
       this.vista = vista;
        vista.setVisible(true);
        vista.getCombo_objetivo_operarivo().setEnabled(false);
        

        cargarObjetivos();
        cargarcombo();
        desactivar();
        //cargarOB();
        vista.getBtnnuevo().addActionListener(e->nuevo());  
        vista.getBtnimprimir().addActionListener(e->imprimirpersona()); 
        vista.getBtnlistar().addActionListener(e->lista()); 
        vista.getBtnindicador().addActionListener(e->abrirVentanaindicador());
        vista.getBtnguardar().addActionListener(e->guardar()); 
        vista.getTablaactividades().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
                
                seleccionartabla();
            }
            
        });
        
        
        
        

        
        vista.getCombo_objetivo_operarivo().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                buscar();
            }
        });
        
        validar();
    }
    
    
    
    
    
    public void cargarObjetivos(){
//        String itemCombo = (String) vista.getComboproyectos().getSelectedItem();
//        int num_proyecto = Integer.parseInt(String.valueOf(itemCombo.charAt(itemCombo.length() - 1)));
//        
//        
//        vista.getCombo_objetivo_operarivo().removeAllItems();
//        listaProyectos = baseDatosProyecto.mostrarDatos();
//        listaObjetivosOperativos = baseDatosObjetivoOperativo.mostrarDatos();
//        listas.clear();
//
//        for (ProyectoMD proyectos : listaProyectos){
//            if (num_proyecto == proyectos.getId_proyecto()){
//                for (ObjetivoOperativoMD objetivos : listaObjetivosOperativos){
//                    if (objetivos.getId_proyecto() == proyectos.getId_proyecto()){
//                        vista.getCombo_objetivo_operarivo().addItem(objetivos.getObjetivo() + "");
//                        listas.add(objetivos.getId_objetivo_operativo());
//
//                    }
//                }
//            }
//        }

        for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
            for (int j = 0; j < Con_poa_proyectos.listasobjetivos.size(); j++) {
                if (listaObjetivosOperativos.get(i).getId_objetivo_operativo()==Con_poa_proyectos.listasobjetivos.get(j)) {
                    vista.getCombo_objetivo_operarivo().addItem(listaObjetivosOperativos.get(i).getObjetivo());
                }
            }
        }
        
            
    }
    
    public void guardar(){
        
        
        
        
        String actividad;
        
        
        
        String recursost;
        baseDatosactividades.setId_actividades(baseDatosactividades.valid());

        int objetivo = (int) vista.getCombo_objetivo_operarivo().getSelectedIndex();
        idobjetivo= listas.get(objetivo);
        
        baseDatosactividades.setId_objetivo_operativo(listas.get(objetivo));
   
        baseDatosactividades.setActividad(String.valueOf( vista.getTxtactividad().getText()));
        actividad=String.valueOf( vista.getTxtactividad().getText());
        
        String responsable = (String) vista.getCombo_responsable().getSelectedItem();         
        baseDatosactividades.setResponsable(responsable);
        
        
        String fecha = formatos.format(vista.getFecha_plazo().getDate());

        baseDatosactividades.setPlazo(fecha);
        
        String recursof = (String) vista.getComborecursos().getSelectedItem();
        
        baseDatosactividades.setRecurso_financiero(recursof+" $ "+vista.getTxtrecursos_financieros().getText());
        
        recursost=recursof+" $ "+vista.getTxtrecursos_financieros().getText();
        
        System.out.println(baseDatosactividades.valid());
        System.out.println(idobjetivo);
        System.out.println(actividad);
        System.out.println(fecha);
        System.out.println(recursost);
        System.out.println(responsable);
        System.out.println("LISTA "+listas.get(objetivo));
 
        if (vista.getTxtactividad().getText().equals("")||responsable.equals("Seleccionar")||vista.getTxtrecursos_financieros().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            //nuevo();
        }else{
            baseDatosactividades.guardar(idobjetivo, actividad, responsable,fecha, recursost);
            
            lista();

            nuevo();
            
        }
    }
    
    public void nuevo(){
        vista.getBtnguardar().setEnabled(true);
        vista.getBtnmodificar().setEnabled(false);
        

        vista.getCombo_objetivo_operarivo().setEnabled(true);
        vista.getTxtactividad().setText("");
        vista.getComborecursos().setSelectedItem("Seleccionar");
        vista.getTxtrecursos_financieros().setText("");    
        vista.getFecha_plazo().setDate(null);
        
        vista.getTxtactividad().setEditable(true);
        vista.getComborecursos().setEditable(true);
        vista.getTxtrecursos_financieros().setEnabled(true);
        vista.getFecha_plazo().setEnabled(true);
    }
    
    public void seleccionar(){
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);

        vista.getCombo_objetivo_operarivo().setEnabled(false);
        vista.getBtneliminar().setEnabled(true);
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablaactividades().getSelectedRow(), 1);
        
         List<ObjetivoOperativoMD> listar = baseDatosObjetivoOperativo.mostrarDatos();
         int ob = (int) modelo.getValueAt(vista.getTablaactividades().getSelectedRow(), 0);
         

         for (int i = 0; i < 10; i++) {
            if (listar.get(i).getObjetivo().equals(cedula)) {
                List<ActividadesMD>lista1 = baseDatosactividades.obtenerdatosxpor(listar.get(i).getId_objetivo_operativo(),ob);
                baseDatosactividades.setId_actividades(lista1.get(0).getId_actividades());
            baseDatosactividades.setId_objetivo_operativo(lista1.get(0).getId_objetivo_operativo());
            baseDatosactividades.setActividad((lista1.get(0).getActividad()));
            baseDatosactividades.setResponsable(lista1.get(0).getResponsable());
            baseDatosactividades.setPlazo(lista1.get(0).getPlazo());
            baseDatosactividades.setRecurso_financiero(lista1.get(0).getRecurso_financiero());
            }
        }

            vista.getTxtactividad().setText(baseDatosactividades.getActividad());
            vista.getTxtrecursos_financieros().setText(baseDatosactividades.getRecurso_financiero());
            vista.getCombo_responsable().setSelectedItem(baseDatosactividades.getResponsable()+ "");
            vista.getComborecursos().setSelectedItem(baseDatosactividades.getRecurso_financiero()+ "");

            
            try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d = formato.parse(baseDatosactividades.getPlazo());
            vista.getFecha_plazo().setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            String[] cadena = baseDatosactividades.getRecurso_financiero().split(" ");
            
            String part1 = cadena[0];
            String part2 = cadena[2];
            // 123
            System.out.println(part1);
            System.out.println(part2);
            vista.getComborecursos().setSelectedItem(part1);
            vista.getTxtrecursos_financieros().setText(part2);
            
            
            
            
            
            
            
            
//            id_proyecto = poabd.getId_proyecto();
//            lista_objetivo();
//            vista.getBtn_modificar().setEnabled(true);
//            vista.getBtn_eliminar().setEnabled(true);
//            vista.getBtn_guardar().setEnabled(false);
//            vista.getTxtarea_obopera().setEnabled(true);
//            vista.getBtnAñadir().setEnabled(true);
//            vista.getTabla_proyecto().setEnabled(true);
        
        
        
        
    }
    
    
    public void buscar() {
        
        String objetivo = (String) vista.getCombo_objetivo_operarivo().getSelectedItem();

        int idobj = 0;

        for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
            if (listaObjetivosOperativos.get(i).getObjetivo().equals(objetivo)) {
                idobj=listaObjetivosOperativos.get(i).getId_objetivo_operativo();
                 
            }
        }
        
        System.out.println(idobj);
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
            List<ActividadesMD> lista1 = baseDatosactividades.obtenerdatos(idobj);
            System.out.println(lista1.size());
            if (lista1.size()!=0) {
                    
              
                int columnas = modelo.getColumnCount();
                for (int j = vista.getTablaactividades().getRowCount() - 1; j >= 0; j--) {
                    modelo.removeRow(j);



                    for (int i = 0; i < lista1.size(); i++) {

                            modelo.addRow(new Object[columnas]);
                            vista.getTablaactividades().setValueAt(lista1.get(i).getId_actividades(), i, 0);
                            int idrol = lista1.get(i).getId_objetivo_operativo();
                            List<ObjetivoOperativoMD> listar2 = baseDatosObjetivoOperativo.obtenerdatos(idrol);
                            vista.getTablaactividades().setValueAt(listar2.get(0).getObjetivo(), i, 1);
                            vista.getTablaactividades().setValueAt(lista1.get(i).getActividad(), i, 2);
                            vista.getTablaactividades().setValueAt(lista1.get(i).getResponsable(), i, 3);
                            vista.getTablaactividades().setValueAt(lista1.get(i).getRecurso_financiero(), i, 4);
                            vista.getTablaactividades().setValueAt(lista1.get(i).getPlazo(), i, 5);

                    }

                }
                
            }
        
    }
    
    public void cargarcombo(){
        
        
        List<docenteMD> listar = bdocente.mostrardatos();
        List<PersonaMD> listap = bpersona.mostrardatos();
        
        
        for (int i = 0; i < listap.size(); i++) {
            for (int j = 0; j < listar.size(); j++) {
                
            
                if (listar.get(j).getCedula().equals(listap.get(i).getCedula())) {
                    vista.getCombo_responsable().addItem(listap.get(i).getNombres()+" "+listap.get(i).getApellidos());

                    System.out.println(listap.get(i).getNombres()+" "+listap.get(i).getApellidos());
                }
            
            }
        }
        
        
         
        
        
        
    }
    
    
    
    
  
    public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
        List<ActividadesMD> lista = baseDatosactividades.mostrarDatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaactividades().getRowCount()-1;j >= 0; j--) {
            modelo.removeRow(j);        }
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaactividades().setValueAt(lista.get(i).getId_actividades(), i, 0);
            int idrol = lista.get(i).getId_objetivo_operativo();
            List<ObjetivoOperativoMD> listar1 = baseDatosObjetivoOperativo.obtenerdatos(idrol);
            vista.getTablaactividades().setValueAt(listar1.get(0).getObjetivo(), i, 1);
            vista.getTablaactividades().setValueAt(lista.get(i).getActividad(), i, 2);
            vista.getTablaactividades().setValueAt(lista.get(i).getResponsable(), i, 3);
            vista.getTablaactividades().setValueAt(lista.get(i).getPlazo(), i, 4);
            vista.getTablaactividades().setValueAt(lista.get(i).getRecurso_financiero(), i, 5); 
        }
        
        
    }
    
    
    
    
    public void imprimirpersona(){
       Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte Por Actividad",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte De Actividades",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }
        if (resp.equals("Reporte Por Actividad")) {
 
            try {
               // JOptionPane.showMessageDialog(null, "Imprimiendo Persona");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteActividades_Id.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
 String aguja = JOptionPane.showInputDialog("Ingrese la actividad");
////                String aguja = vista.getTxtBuscar().getText();
                System.out.println("actividad;;;;"+ aguja);
                params.put("actividad",aguja);
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

                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteActividades.jasper"));

                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    
    
    public void seleccionartabla(){
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
        int ob = (int) modelo.getValueAt(vista.getTablaactividades().getSelectedRow(), 0);
        tablaSeleccionada = true;
        
        id_act = ob;
        
        System.out.println(ob);
        
        
        
       
        
        
    }
     
    public void abrirVentanaindicador(){
       
       if (tablaSeleccionada){
        vis_poa_actividad_indicador zap = new vis_poa_actividad_indicador();
        Con_principal.vista.getESCRITORIO().add(zap);
        Dimension desktopSize = Con_principal.vista.getESCRITORIO().getSize();
        Dimension FrameSize = zap.getSize();
        zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa_actividad_indicador proyectos = new Con_poa_actividad_indicador(zap,id_act);
       }
       else{
           JOptionPane.showMessageDialog(null, "Debe seleccionar una actividad de la tabla");
       }
    }
    
    
    
    public void validar(){

        Numeros.solo_numeros(vista.getTxtrecursos_financieros());
    }
    
    public void desactivar(){
        vista.getTxtactividad().setEditable(false);
        vista.getComborecursos().setEditable(false);
        vista.getTxtrecursos_financieros().setEnabled(false);
        vista.getFecha_plazo().setEnabled(false);
        vista.getBtneliminar().setEnabled(false);
        vista.getBtnguardar().setEnabled(false);
    }

    public static int getId_act() {
        return id_act;
    }

    
    
    
}