/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
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
        vista.getBtnModulos().addActionListener(e-> tabla_modulo());
        vista.getBtnSilabo().addActionListener(e-> tabla_silabo());
        vista.getBtnImprimir().addActionListener(e-> imprimir());
        vista.getBtn_buscar().addActionListener(e-> tabla_buscar());
    }
    
    public void buscar(){
        String periodo = (String) vista.getComboPeriodAcademico().getSelectedItem().toString();
        bdmodulo.buscar_x_parametro(cod_periodo(periodo), vista.getChk_periodo().isSelected(), 
                vista.getTxt_materia().getText(), vista.getChk_materia().isSelected());
    }
    public void guardar(){
        int idPeriodo = 0;
        String idMateria = "";
        String nomPeriodo = (String) vista.getComboPeriodAcademico().getSelectedItem();
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
        noeditablemodelo modelo= new noeditablemodelo(){
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
        case 3:          
          return Boolean.class;
        default:
            return String.class;
        }
      }
    };
        modelo.addColumn("Codigo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Documento");
        
        doc_modulo_BD mod=new doc_modulo_BD();
        List<doc_modulo_MD> modulos=mod.mostrardatos();
        
        for (int i = 0; i < modulos.size(); i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos.get(i).getId_doc_modulo(), i, 0);
            modelo.setValueAt(nom_periodo(modulos.get(i).getId_periodo()), i, 1);
            modelo.setValueAt(nom_materia(modulos.get(i).getId_materia()), i, 2);
            modelo.setValueAt((modulos.get(i).getDocumento()!=null),i,3);            
        }
        
        vista.getTbl_Datos().setModel(modelo);             
    }
    
    public void tabla_buscar(){
        noeditablemodelo modelo= new noeditablemodelo(){
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
        case 3:          
          return Boolean.class;
        default:
            return String.class;
        }
      }
    };
        modelo.addColumn("Codigo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Documento");
        
        doc_modulo_BD mod=new doc_modulo_BD();
        List<doc_modulo_MD> modulos=mod.buscar_x_parametro(cod_periodo(vista.getComboPeriodAcademico().getSelectedItem().toString()), 
                vista.getChk_periodo().isSelected(), 
                vista.getTxt_materia().getText().toUpperCase(), vista.getChk_materia().isSelected());
        
        for (int i = 0; i < modulos.size(); i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos.get(i).getId_doc_modulo(), i, 0);
            modelo.setValueAt(nom_periodo(modulos.get(i).getId_periodo()), i, 1);
            modelo.setValueAt(nom_materia(modulos.get(i).getId_materia()), i, 2);
            modelo.setValueAt((modulos.get(i).getDocumento()!=null),i,3);            
        }
        
        vista.getTbl_Datos().setModel(modelo);             
    }
    
    
     public void tabla_silabo(){
        noeditablemodelo modelo= new noeditablemodelo(){
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
        case 3:          
          return Boolean.class;
        default:
            return String.class;
        }
      }
    };
        modelo.addColumn("Codigo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Documento");
        
        doc_silabo_BD mod=new doc_silabo_BD();
        List<doc_silabo_MD> modulos=mod.mostrardatos();
        
        for (int i = 0; i < modulos.size(); i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos.get(i).getId_doc_silabo(), i, 0);
            modelo.setValueAt(nom_periodo(modulos.get(i).getId_periodo()), i, 1);
            modelo.setValueAt(nom_materia(modulos.get(i).getId_materia()), i, 2);
            modelo.setValueAt((modulos.get(i).getDocumento()!=null),i,3);            
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
    public int cod_periodo(String nomb){
        for (int i = 0; i < listPer.size(); i++) {
            if (listPer.get(i).getNombre().equals(nomb)) return listPer.get(i).getIdperiodo();
        }
        return 0;
    }
    
    public String cod_materia(String nom){
        for (int i = 0; i < listMat.size(); i++) {
            if (listMat.get(i).getNombre_materia().toLowerCase().contains(nom)== true) return listMat.get(i).getCod_materia();
        }
        return null;
    }
    
     public void imprimir(){
          Conect con = new Conect();
            try {
               
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/r_modulo.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                JOptionPane.showMessageDialog(null, "Imprimiendo Periodo");
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    
}
