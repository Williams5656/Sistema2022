/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        tabla_modulo();
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
            if(nomPeriodo.equals(listPer.get(i).getNombre())){
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
    
    public class noeditablemodelo extends DefaultTableModel
    {
        public boolean isCellEditable (int row, int column)
        {
       return false;
        }
    }
    
    public void tabla_modulo(){
        noeditablemodelo modelo= new noeditablemodelo();
        modelo.addColumn("Codigo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        
        doc_modulo_BD mod=new doc_modulo_BD();
        List<doc_modulo_MD> modulos=mod.mostrardatos();
        
        for (int i = 0; i < modulos.size(); i++) {
            modelo.addRow(new Object[3]);
            modelo.setValueAt(modulos.get(i).getId_doc_modulo(), i, 0);
            modelo.setValueAt(nom_periodo(modulos.get(i).getId_periodo()), i, 1);
            modelo.setValueAt(nom_materia(modulos.get(i).getId_materia()), i, 2);            
        }
        
        vista.getTbl_Datos().setModel(modelo);             
    }
    
    public String nom_periodo(int cod){
        for (int i = 0; i < listPer.size(); i++) {
            if (listPer.get(i).getIdperiodo()==cod) return listPer.get(i).getNombre();
        }
        return null;
    }
    
    public String nom_materia(String cod){
        for (int i = 0; i < listMat.size(); i++) {
            if (listMat.get(i).getCod_materia().equals(cod)) return listMat.get(i).getNombre_materia();
        }
        return null;
    }
    
}
