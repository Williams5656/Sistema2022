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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Con_poa_actividad {
      private final vis_poa_actividad vista;
      private ObjetivoOperativoBD baseDatosObjetivoOperativo = new ObjetivoOperativoBD();
      private ArrayList <ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
      private ArrayList <ProyectoMD> listaProyectos = new ArrayList<>();
      private ProyectoBD baseDatosProyecto = new ProyectoBD();
      private ActividadesBD baseDatosactividades = new ActividadesBD();
      private ArrayList<Integer> listas = new ArrayList();
      private int idobjetivo=0;

      private docenteBD bdocente = new docenteBD();
      private PersonaBD bpersona = new PersonaBD();
      
      

    public Con_poa_actividad(vis_poa_actividad vista) {
       this.vista = vista;
        vista.setVisible(true);
        cargarComboProyecto();
        cargarObjetivos();
        cargarcombo();
        //cargarOB();
        vista.getBtnimprimir().addActionListener(e->imprimir());  
        vista.getBtnindicador().addActionListener(e->ventindicador());
        vista.getBtnguardar().addActionListener(e->guardar());   
        vista.getComboproyectos().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                cargarObjetivos();
            }
        });
        
        lista();
        //HOLAAAA
        
        vista.getCombo_objetivo_operarivo().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                buscar();
            }
        });
        
        buscar();
    }
    
    public void ventindicador(){
        vis_poa_actividad_indicador zap = new vis_poa_actividad_indicador();
        Con_principal.vista.getESCRITORIO().add(zap);
        Dimension desktopSize = Con_principal.vista.getESCRITORIO().getSize();
        Dimension FrameSize = zap.getSize();
        zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Con_poa_actividad_indicador proyectos = new Con_poa_actividad_indicador(zap);
        
        
        
    }
    
    public void cargarComboProyecto(){
        
        vista.getComboproyectos().removeAllItems();
        
        
        listaProyectos = baseDatosProyecto.mostrarDatos();
        
        for (ProyectoMD proyectos : listaProyectos){
            if (Con_Poa1.getId_poa() == proyectos.getId_Poa()){
                vista.getComboproyectos().addItem(String.valueOf(proyectos.getId_proyecto()));
                
                
            }
        }
    }
    
    public void cargarObjetivos(){
        String itemCombo = (String) vista.getComboproyectos().getSelectedItem();
        int num_proyecto = Integer.parseInt(String.valueOf(itemCombo.charAt(itemCombo.length() - 1)));
        
        
        vista.getCombo_objetivo_operarivo().removeAllItems();
        listaProyectos = baseDatosProyecto.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjetivoOperativo.mostrarDatos();
        listas.clear();

        for (ProyectoMD proyectos : listaProyectos){
            if (num_proyecto == proyectos.getId_proyecto()){
                for (ObjetivoOperativoMD objetivos : listaObjetivosOperativos){
                    if (objetivos.getId_proyecto() == proyectos.getId_proyecto()){
                        vista.getCombo_objetivo_operarivo().addItem(objetivos.getObjetivo() + "");
                        listas.add(objetivos.getId_objetivo_operativo());

                    }
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
        
        SimpleDateFormat formatos = new SimpleDateFormat("yyyy-MM-dd");
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


            //nuevo();
            
        }
    }
    
    
    public void buscar() {
        
        String objetivo = (String) vista.getCombo_objetivo_operarivo().getSelectedItem();
        String proyect = (String) vista.getComboproyectos().getSelectedItem();
        int idobj = 0;
        System.out.println(proyect);
        for (int i = 0; i < listaObjetivosOperativos.size(); i++) {
            if (listaObjetivosOperativos.get(i).getObjetivo().equals(objetivo)&&listaObjetivosOperativos.get(i).getId_proyecto()== Integer.valueOf(proyect)) {
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
                            vista.getTablaactividades().setValueAt(lista1.get(i).getId_objetivo_operativo(), i, 1);
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
    
    public void cargarOB(){
        vista.getCombo_objetivo_operarivo().addItemListener(new objetivo_evidencia(vista.getComboproyectos(), vista.getCombo_objetivo_operarivo()));
        
        

    }
    
    
//    public void seleccionar(){
//        
//        
//        //vista.getBtnguardar().setEnabled(false);
//        //vista.getBtnmodificar().setEnabled(true);
//        //vista.getTxtcodigo().setEditable(false);
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
//        String codigo = (String) modelo.getValueAt(vista.getTablaactividades().getSelectedRow(), 0);
//        System.out.println(codigo);
//        List<ActividadesMD> lista = baseDatosactividades.mostrarDatos;
//        bdproduct.setCodigo(lista.get(0).getCodigo());
//        bdproduct.setNombre(lista.get(0).getNombre());
//        bdproduct.setMarca(lista.get(0).getMarca());
//        bdproduct.setCantidad(lista.get(0).getCantidad());
//        bdproduct.setPrecio(lista.get(0).getPrecio());
//        bdproduct.setEstado(lista.get(0).getEstado());
//        bdproduct.setDescripcion(lista.get(0).getDescripcion());
//        
//        vista.getTxtcodigo().setText(bdproduct.getCodigo());
//        vista.getTxtnombre().setText(bdproduct.getNombre());
//        vista.getCombomarca().setSelectedItem(bdproduct.getMarca());
//        vista.getTxtcantidad().setText(bdproduct.getCantidad()+"");
//        
//        if (bdproduct.getEstado().equals("Activo")) {
//            vista.getBtnradioestado1().setSelected(true);
//        }
//        
//        if (bdproduct.getEstado().equals("Inactivo")) {
//            vista.getBtnradioestado().setSelected(true);
//        }
//        
//        
//        vista.getTxtprecio().setText(bdproduct.getPrecio()+"");
//        vista.getTxtdescripcion().setText(bdproduct.getDescripcion());
//         
//    }
    
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
            vista.getTablaactividades().setValueAt(lista.get(i).getId_objetivo_operativo(), i, 1);
            vista.getTablaactividades().setValueAt(lista.get(i).getActividad(), i, 2);
            vista.getTablaactividades().setValueAt(lista.get(i).getResponsable(), i, 3);
            vista.getTablaactividades().setValueAt(lista.get(i).getPlazo(), i, 4);
            vista.getTablaactividades().setValueAt(lista.get(i).getRecurso_financiero(), i, 5); 
        }
    }
    
    private void imprimir(){
          Conect con = new Conect();
            try {

                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteActividades.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
//                Map parametro = new HashMap();
//                parametro.clear();
//                parametro.put("logos",this.getClass().getResourceAsStream(imagen));
                JOptionPane.showMessageDialog(null, "Imprimiendo Actividades");
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_poa_actividad.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    
    
    
}