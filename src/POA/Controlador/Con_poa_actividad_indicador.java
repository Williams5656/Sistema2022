/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.vis_poa_actividad_indicador;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Con_poa_actividad_indicador {
    private final vis_poa_actividad_indicador vista;
    private IndicadorBD bdindicador = new IndicadorBD();
    private ActividadesBD baseDatosactividades = new ActividadesBD();
    private ArrayList <ActividadesMD> listaActividades = new ArrayList<>();
    private ObjetivoOperativoBD baseDatosObjetivoOperativo = new ObjetivoOperativoBD();
    private ArrayList <ObjetivoOperativoMD> listaObjetivosOperativos = new ArrayList();
    private ArrayList <ProyectoMD> listaProyectos = new ArrayList<>();
    private ProyectoBD baseDatosProyecto = new ProyectoBD();

    private ArrayList<Integer> listaact = new ArrayList();
    int idactividad=0;
    String indicador;


    public Con_poa_actividad_indicador(vis_poa_actividad_indicador vista) {
        this.vista = vista;
        vista.setVisible(true);
        //cargarcombo();
        
        cargarComboProyectos();
        cargarComboObjetivos();
        
  
        //vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        //vista.getBtnmodificar().addActionListener(e->modificar());
        //vista.getBtncambiarest().addActionListener(e->cambiarestado());
        //vista.getBtneliminar().addActionListener(e->eliminar());

//        vista.getTablaproductos().addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                seleccionar();
//            }
//            
//        });

        vista.getComboproyecto().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                cargarComboObjetivos();
            }
        });
        

        lista();
        
        
        
        
    }
    
    public void guardar(){
        
        
        
        bdindicador.setId_indicador(bdindicador.valid());
        
        int actividad = (int) vista.getComboactividad().getSelectedIndex();
        idactividad= listaact.get(actividad);
        
        bdindicador.setId_actividades(listaact.get(actividad));
        
        bdindicador.setIndicador(vista.getTxtindicador().getText());
        
        indicador=vista.getTxtindicador().getText();
        
        
        
        int lineab = (int) vista.getLineabase().getValue();
        
        bdindicador.setLinea_base(lineab);
        
        int meta = (int) vista.getMeta().getValue();
        bdindicador.setMeta(meta);
        
        if (vista.getTxtindicador().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            
        }else{
            bdindicador.guardar(idactividad, lineab, meta, indicador);
            
            lista();
            
        }
        
    }
    
    public void cargarComboProyectos(){
        
        vista.getComboproyecto().removeAllItems();
        
        
        listaProyectos = baseDatosProyecto.mostrarDatos();
        
        for (ProyectoMD proyectos : listaProyectos){
            if (Con_Poa1.getId_poa() == proyectos.getId_Poa()){
                vista.getComboproyecto().addItem(String.valueOf(proyectos.getId_proyecto()));
                
                
            }
        }
    }
    
    public void cargarComboObjetivos(){
        String itemCombo = (String) vista.getComboproyecto().getSelectedItem();
        int num_proyecto = Integer.parseInt(String.valueOf(itemCombo.charAt(itemCombo.length() - 1)));
        
        
        vista.getComboobjetivo().removeAllItems();
        listaProyectos = baseDatosProyecto.mostrarDatos();
        listaObjetivosOperativos = baseDatosObjetivoOperativo.mostrarDatos();
        

        for (ProyectoMD proyectos : listaProyectos){
            if (num_proyecto == proyectos.getId_proyecto()){
                for (ObjetivoOperativoMD objetivos : listaObjetivosOperativos){
                    if (objetivos.getId_proyecto() == proyectos.getId_proyecto()){
                        vista.getComboobjetivo().addItem(objetivos.getObjetivo() + "");
                        

                    }
                }
            }
        }
        
            
    }
    
      public void cargarcombo(){
        
        int obj = (int) vista.getComboobjetivo().getSelectedIndex();
        
        
        
        listaActividades = baseDatosactividades.mostrarDatos();
          for (ActividadesMD act : listaActividades) {
              if (obj==act.getId_objetivo_operativo()) {
                  
                    vista.getComboactividad().addItem(act.getActividad());
                    listaact.add(act.getId_actividades());
  
              }
          }
          
          
        
        
        
        
        
    }
      
      public void lista(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaindicador().getModel();
        List<IndicadorMD> lista = bdindicador.mostrarDatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaindicador().getRowCount()-1;j >= 0; j--) {
            modelo.removeRow(j);        }
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaindicador().setValueAt(lista.get(i).getId_indicador(), i, 0);
            int idrol = lista.get(i).getId_actividades();
            List<ActividadesMD> listar1 = baseDatosactividades.obtenerdatosxind(idrol);
            vista.getTablaindicador().setValueAt(listar1.get(0).getActividad(), i, 1);
            vista.getTablaindicador().setValueAt(lista.get(i).getIndicador(), i, 2);
            vista.getTablaindicador().setValueAt(lista.get(i).getLinea_base(), i, 3);
            vista.getTablaindicador().setValueAt(lista.get(i).getMeta(), i, 4);
        }
        
        
    }
      
      

}
