/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac Mejia
 */
public class con_portafolio {
    private final vis_portafolio vista;
    doc_modulo_BD bdmodulo = new doc_modulo_BD();    
    private String carrera = "1";
    MateriaBD materiabd = new MateriaBD();
    List<MateriaMD> listMat = materiabd.mostrardatos();
    PeriodoacademicoBD periodobd = new PeriodoacademicoBD();
    List<PeriodoacademicoMD> listPer = periodobd.lista_periodos();
    

    public con_portafolio(vis_portafolio vista) {
        this.vista = vista;
        vista.setVisible(true);
        llenarCombo();
        vista.getBtnGuardar().addActionListener(e-> guardar());        
        
    }
    
    public void guardar(){
        int idPeriodo = 0;
        String idMateria = "";
        String nomPeriodo = (String) vista.getComboPeriodAcademico().getSelectedItem();
        String nomMateria = (String) vista.getComboMateria().getSelectedItem();
        for (int i = 0; i < listMat.size(); i++) {
            if(nomMateria.equals(listMat.get(i).getNombre_materia())){
                idMateria = listMat.get(i).getCod_materia();
            }
        }
        for (int i = 0; i < listPer.size(); i++) {
            if(nomMateria.equals(listPer.get(i).getNombre())){
                idPeriodo = listPer.get(i).getIdperiodo();
            }
        }
        bdmodulo.setId_materia(idMateria);
        bdmodulo.setId_periodo(idPeriodo);
        if(bdmodulo.insertar()){
          JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");  
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
        
    }
    
    public void llenarCombo(){
        
        for (int i = 0; i < listMat.size(); i++) {
            //if(listMat.get(i).getNombre_carrera().equals(vista.getLblCarrera().getText()))
            vista.getComboMateria().addItem(listMat.get(i).getNombre_materia());
        }        
        
        for (int i = 0; i < listPer.size(); i++) {
            vista.getComboPeriodAcademico().addItem(listPer.get(i).getNombre());
        }
        
        
    }
}
