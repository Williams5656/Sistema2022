/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;
import POA.Vista.*;
import POA.Controlador.*;
import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sebastian
 */
public class Con_Poa1 {
    private final Vis_Poa1 vista;
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<POA.Modelo.PoaMD> listaPOA = new ArrayList();
    private List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private POA.Modelo.PoaBD baseDatosPoa = new PoaBD();
    private POA.Modelo.CarreraBD baseDatosCarrera = new CarreraBD();

    public Con_Poa1(Vis_Poa1 vista) {
        this.vista = vista;
        
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPOA = baseDatosPoa.mostrarDatos();
        for (POA.Modelo.CarreraMD carr : listaCarreras){
            vista.getCbxCarrera().addItem(carr.getNombre_carrera());
        }
        
        vista.setVisible(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        vista.setTitle("POA");
        vista.getBtnGuardar().addActionListener(e -> guardar());  
        lista();
        
    }
    
    public void lista(){
        model.setRowCount(0);
        model.setColumnCount(0);
        
        model.addColumn("Id_poa");
        model.addColumn("Carrera");
        model.addColumn("Año");
        model.addColumn("Estado");
        
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPOA = baseDatosPoa.mostrarDatos();
        for (POA.Modelo.PoaMD user : listaPOA) {
            Object[] fila = new Object[4];
            fila[0] = user.getId_POA();
            
            for (POA.Modelo.CarreraMD carr : listaCarreras){
                if (user.getId_carrera() == Integer.parseInt(carr.getCodigo_carrera())){
                    fila[1] = carr.getNombre_carrera();
                }
            }
            
            fila[2] = user.getAnio();
            fila[3] = user.getEstado();
            
            model.addRow(fila);
        }
        
        vista.getTablaPoa().setModel(model);
    }
    
    public void guardar(){
        int id_carrera;
        listaCarreras = baseDatosCarrera.mostrardatos();
        for (POA.Modelo.CarreraMD carr : listaCarreras){
                if (((String) vista.getCbxCarrera().getSelectedItem()).equals(carr.getNombre_carrera())){
                    id_carrera = Integer.parseInt(carr.getCodigo_carrera());
                    baseDatosPoa.guardar(id_carrera, vista.getyChooser().getValue() + "", "Activo");
                }
            }
        
        

        lista();
        JOptionPane.showMessageDialog(null, "Guardado");
        
        limpiarCampos();
        
    }
    
     public void limpiarCampos(){
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        vista.getyChooser().setValue(2022);
           
        vista.getTablaPoa().setCellSelectionEnabled(false);
 
    }
}
