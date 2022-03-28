/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.vis_poa_actividad_indicador;
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
    private ArrayList<Integer> listaact = new ArrayList();
    int idactividad=0;
    String indicador;


    public Con_poa_actividad_indicador(vis_poa_actividad_indicador vista) {
        this.vista = vista;
        vista.setVisible(true);
        cargarcombo();
        for (int i = 0; i < listaact.size(); i++) {
            System.out.println(listaact.get(i));
        }
        
  
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
    
      public void cargarcombo(){
         vista.getComboactividad().removeAllItems();
        
        
        listaActividades = baseDatosactividades.mostrarDatos();
        
        for (ActividadesMD act : listaActividades){
            
                vista.getComboactividad().addItem(act.getActividad());
                listaact.add(act.getId_actividades());
                
                
            
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
            vista.getTablaindicador().setValueAt(lista.get(i).getId_actividades(), i, 1);
            vista.getTablaindicador().setValueAt(lista.get(i).getIndicador(), i, 2);
            vista.getTablaindicador().setValueAt(lista.get(i).getLinea_base(), i, 3);
            vista.getTablaindicador().setValueAt(lista.get(i).getMeta(), i, 4);
        }
    }
      
      

}
