/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Vista.*;
import POA.Modelo.*;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        
        vista.getBtnindicador().addActionListener(e->ventindicador());
        vista.getBtnguardar().addActionListener(e->guardar());   
        //vista.getCombo_objetivo_operarivo().addActionListener(e-> buscar());
        vista.getComboproyectos().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                cargarObjetivos();
            }
        });
        
        
        
        vista.getCombo_objetivo_operarivo().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                buscar();
            }
        });
        
  
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
        listas.clear();
        
        
        for (ProyectoMD proyectos : listaProyectos){
            if (num_proyecto == proyectos.getNum_proyecto_carrera()){
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
        
        int objetivo = (int) vista.getCombo_objetivo_operarivo().getSelectedIndex();
  
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaactividades().getModel();
            List<ActividadesMD> lista1 = baseDatosactividades.obtenerdatos(objetivo);
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablaactividades().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista1.size(); i++) {
                    if (lista1.get(i).getId_objetivo_operativo()== objetivo) {
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
    
    
    
    
    
}