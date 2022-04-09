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
import POA.Controlador.Con_poa_actividad.*;
import POA.Modelo.Validadores.*;

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
    int actividad=0;


    public Con_poa_actividad_indicador(vis_poa_actividad_indicador vista,int id_act) {
        this.vista = vista;
        actividad = id_act;
        vista.setVisible(true);
        cargarcombo();
        validadores();
        buscar();

        
//        cargarComboProyectos();
//        cargarComboObjetivos();
        
  
        //vista.getBtnnuevo().addActionListener(e->nuevo());
        vista.getBtnguardar().addActionListener(e->guardar());
        //vista.getBtnmodificar().addActionListener(e->modificar());
        //vista.getBtncambiarest().addActionListener(e->cambiarestado());
        //vista.getBtneliminar().addActionListener(e->eliminar());
        vista.getTablaindicador().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
            
        });
         vista.getComboactividad().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                buscar();
            }
        });
        

        //lista();
        
        
        
        
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
        
          System.out.println(actividad);
        
        
        listaActividades = baseDatosactividades.mostrarDatos();
          for (ActividadesMD act : listaActividades) {
              if (actividad==act.getId_actividades()) {
                  
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
    public void validadores(){
        Numeros.solo_numerosspiner(vista.getLineabase());
    }
    
    public void seleccionar(){
        String actividad;
        vista.getBtnguardar().setEnabled(false);
        vista.getBtnmodificar().setEnabled(true);
        vista.getComboactividad().setEnabled(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaindicador().getModel();
        int placa = (int) modelo.getValueAt(vista.getTablaindicador().getSelectedRow(), 0);
        System.out.println(placa);
        List<IndicadorMD> lista = bdindicador.obtenerdatos(placa);
        bdindicador.setId_indicador(lista.get(0).getId_indicador());
        bdindicador.setIndicador(lista.get(0).getIndicador());
        bdindicador.setLinea_base(lista.get(0).getLinea_base());
        bdindicador.setMeta(lista.get(0).getMeta());
        bdindicador.setId_actividades(lista.get(0).getId_actividades());
        
        
        vista.getTxtindicador().setText(bdindicador.getIndicador());
        int idrol = lista.get(0).getId_actividades();
        List<ActividadesMD> listar1 = baseDatosactividades.obtenerdatosxind(idrol);
        vista.getComboactividad().addItem(listar1.get(0).getActividad()+"");
        System.out.println(listar1.get(0).getActividad());
        vista.getLineabase().setValue(bdindicador.getLinea_base());
        vista.getMeta().setValue(bdindicador.getMeta());
        
         
    }
    
    public void buscar() {
        
        
       
        
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaindicador().getModel();
            int actividad = (int) vista.getComboactividad().getSelectedIndex();
            idactividad= listaact.get(actividad);
            List<IndicadorMD> lista = bdindicador.obtenerdatosxactividad(idactividad);
            
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablaindicador().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getId_actividades()==idactividad) {
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
            
    
    }
      
      
      
}
