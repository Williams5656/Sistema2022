/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.Conect;
import POA.Modelo.PeriodoacademicoBD;
import POA.Modelo.doc_modulo_BD;
import POA.Modelo.doc_silabo_BD;
import POA.Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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
public class con_periodoAcademico {

    private final vis_PeriodoAcademico vista;
    PeriodoacademicoBD periodo = new PeriodoacademicoBD();
    private String carrera = "1";

    public con_periodoAcademico(vis_PeriodoAcademico vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.getBtnestado().setEnabled(false);
        vista.getBtnCrear().addActionListener(e -> ingresar());
        vista.getBtn_repor().addActionListener(e -> imprimir());
        vista.getBtnestado().addActionListener(e -> modificar());
        vista.getTabla().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.getTabla().getSelectedRow()>-1){
                    vista.getBtnestado().setEnabled(true);                    
                }else vista.getBtnestado().setEnabled(false);
            }
        }
        );        
        periodo.llenar_tabla(vista.getTabla());
    }

    public void ingresar() {
        if (check() == true) {
            periodo.setNombre(mes_anio(vista.getDateFechaInicio().getDate().getMonth(),
                    vista.getDateFechaInicio().getDate().getYear())
                    + "-"
                    + mes_anio(vista.getDateFechaFin().getDate().getMonth(),
                            vista.getDateFechaFin().getDate().getYear()));
            periodo.setCarrera(carrera);
            periodo.setFechainicio(vista.getDateFechaInicio().getDate());
            periodo.setFechafin(vista.getDateFechaFin().getDate());
            periodo.setEstado(combo_esta());

            if (periodo.insertar() == true) {
                System.out.println("periodo_creado");
            } else {
                System.out.println("error val crear periodo");
            }
            
            doc_modulo_BD mod=new doc_modulo_BD();
            if (mod.crear_modulos() == true) {
                System.out.println("Modulos creados");
            } else {
                System.out.println("error al crear modulos del periodo");}
            
            doc_silabo_BD sil=new doc_silabo_BD();
            if (sil.crear_silabos()== true) {
                System.out.println("Silabos creados");
            } else {
                System.out.println("error al crear modulos del periodo");}
            
            periodo.llenar_tabla(vista.getTabla());
            
        } else; //colocar un joption despues desde una clase general;        
    }

    public boolean combo_esta() {
        if (vista.getComboEstado().getSelectedIndex() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String mes_anio(int m, int a) {
        String res = "";
        switch (m) {
            case 0:
                res = "Ene";
                break;
            case 1:
                res = "Feb";
                break;
            case 2:
                res = "Mar";
                break;
            case 3:
                res = "Abr";
                break;
            case 4:
                res = "May";
                break;
            case 5:
                res = "Jun";
                break;
            case 6:
                res = "Jul";
                break;
            case 7:
                res = "Ago";
                break;
            case 8:
                res = "Sep";
                break;
            case 9:
                res = "Oct";
                break;
            case 10:
                res = "Nov";
                break;
            case 11:
                res = "Dic";
                break;
        }
        a = a + 1900;//el año es devuelto la resta del actual - 1900
        String[] dec = String.valueOf(a).split("");
        res = res + dec[2] + dec[3];
        System.out.println(res);
        return res;
    }

    public boolean check() {
        if (vista.getDateFechaInicio().getDate() == null) {
            return false;
        }
        if (vista.getDateFechaFin().getDate() == null) {
            return false;
        }
        if (vista.getDateFechaFin().getDate().before(vista.getDateFechaInicio().getDate())) {
            return false;
        }
        if (periodo.validar_fechas(carrera, vista.getDateFechaInicio().getDate(), vista.getDateFechaFin().getDate()) == false) {
            return false;
        }
        return true;
    }
    
    public void imprimir(){
          Conect con = new Conect();
            try {
               
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/R_periodo_academico_lista.jasper"));
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
    
    public boolean estado_fila(){
        if (vista.getTabla().getValueAt(vista.getTabla().getSelectedRow(),5).toString().equals("Activo")) return false;
        else return true;
    }
    
    public void modificar(){
        periodo.modificar(estado_fila(),Integer.parseInt(vista.getTabla().getValueAt(vista.getTabla().getSelectedRow(),0).toString()));
        periodo.llenar_tabla(vista.getTabla());
        vista.getBtnestado().setEnabled(false);
    }

}
