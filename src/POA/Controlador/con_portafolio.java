/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    doc_silabo_BD bdsilabo = new doc_silabo_BD();
    doc_planes_claseBD bdplanes = new doc_planes_claseBD();
    doc_notas_BD bdnotas = new doc_notas_BD();
    doc_informes_BD bdinformes = new doc_informes_BD();
    doc_instrumento_evaluacionBD bdinstrumentos = new doc_instrumento_evaluacionBD();
    private String carrera;
    MateriaBD materiabd = new MateriaBD();
    List<MateriaMD> listMat = materiabd.mostrardatos();
    PeriodoacademicoBD periodobd = new PeriodoacademicoBD();
    List<PeriodoacademicoMD> listPer = periodobd.lista_periodos();

    public con_portafolio(vis_portafolio vista, String carrera) {
        this.vista = vista;
        this.carrera = carrera;
        vista.setVisible(true);
        llenarCombo();
        btns_apagados();
        vista.getBtnModulos().addActionListener(e -> tabla_modulo());
        vista.getBtnModulos().addActionListener(l -> botones());
        vista.getBtnSilabo().addActionListener(l -> botones());
        vista.getBtnInstrumentosEv().addActionListener(l -> botones());
        vista.getBtnInformesSilabo().addActionListener(l -> botones());
        vista.getBtnPlanesClase().addActionListener(l -> botones());
        vista.getBtnNotas().addActionListener(l -> botones());
        vista.getBtnSilabo().addActionListener(e -> tabla_silabo());
        vista.getBtnNotas().addActionListener(e -> tabla_notas());
        vista.getBtnPlanesClase().addActionListener(e -> tabla_planes());
        vista.getBtnInstrumentosEv().addActionListener(e -> tabla_instrumentos());
        vista.getBtnInformesSilabo().addActionListener(e -> tabla_informes());
        vista.getBtnImprimir().addActionListener(e -> imprimir());
        vista.getBtn_buscar().addActionListener(e -> tabla_buscar());
        vista.getBtn_subir().addActionListener(e -> subir_datos());
        abrir();

    }

    public void btns_apagados() {
        vista.getComboPeriodAcademico().setEnabled(false);
        vista.getComboCiclo().setEnabled(false);
        vista.getComboSeccion().setEnabled(false);
        vista.getChk_ciclo().setEnabled(false);
        vista.getChk_materia().setEnabled(false);
        vista.getChk_periodo().setEnabled(false);
        vista.getChk_seccion().setEnabled(false);
        vista.getChk_paralelo().setEnabled(false);
        vista.getComboparalelo().setEnabled(false);
        vista.getCombodocu().setEnabled(false);
        vista.getBtn_buscar().setEnabled(false);
        vista.getBtnImprimir().setEnabled(false);
        vista.getBtn_subir().setEnabled(false);
        vista.getChk_doc().setEnabled(false);
        vista.getTxt_materia().setEditable(false);
    }

    public void botones() {
        if (vista.getBtnModulos().isSelected() == true || vista.getBtnSilabo().isSelected() == true || vista.getBtnPlanesClase().isSelected() == true) {
            vista.getComboPeriodAcademico().setEnabled(true);
            vista.getComboCiclo().setEnabled(false);
            vista.getComboSeccion().setEnabled(false);
            vista.getChk_ciclo().setEnabled(false);
            vista.getChk_materia().setEnabled(true);
            vista.getChk_periodo().setEnabled(true);
            vista.getChk_seccion().setEnabled(false);
            vista.getChk_paralelo().setEnabled(false);
            vista.getComboparalelo().setEnabled(false);
            vista.getCombodocu().setEnabled(true);
            vista.getBtn_buscar().setEnabled(true);
            vista.getBtnImprimir().setEnabled(true);
            vista.getBtn_subir().setEnabled(true);
            vista.getChk_doc().setEnabled(true);
            vista.getTxt_materia().setEditable(true);
            limpiar();
        }

        if (vista.getBtnInstrumentosEv().isSelected() == true || vista.getBtnInformesSilabo().isSelected() == true || vista.getBtnNotas().isSelected() == true) {
            vista.getComboPeriodAcademico().setEnabled(true);
            vista.getComboCiclo().setEnabled(true);
            vista.getComboSeccion().setEnabled(true);
            vista.getChk_ciclo().setEnabled(true);
            vista.getChk_materia().setEnabled(true);
            vista.getChk_periodo().setEnabled(true);
            vista.getChk_seccion().setEnabled(true);
            vista.getChk_paralelo().setEnabled(true);
            vista.getComboparalelo().setEnabled(true);
            vista.getCombodocu().setEnabled(true);
            vista.getBtn_buscar().setEnabled(true);
            vista.getBtnImprimir().setEnabled(true);
            vista.getBtn_subir().setEnabled(true);
            vista.getChk_doc().setEnabled(true);
            vista.getTxt_materia().setEditable(true);
            limpiar();
        }
    }

    public void limpiar() {
        vista.getTxt_materia().setText("");

        vista.getChk_periodo().setSelected(false);
        vista.getChk_paralelo().setSelected(false);
        vista.getChk_materia().setSelected(false);
        vista.getChk_ciclo().setSelected(false);
        vista.getChk_seccion().setSelected(false);
        vista.getChk_doc().setSelected(false);

        vista.getComboPeriodAcademico().setSelectedIndex(0);
        vista.getComboCiclo().setSelectedIndex(0);
        vista.getComboparalelo().setSelectedIndex(0);
        vista.getCombodocu().setSelectedIndex(0);
        vista.getComboSeccion().setSelectedIndex(0);
    }

    public void llenarCombo() {
        for (int i = 0; i < listPer.size(); i++) {
            vista.getComboPeriodAcademico().addItem(listPer.get(i).getNombre());
        }
    }

    public class noeditablemodelo extends DefaultTableModel {

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public void tabla_modulo() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
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

        doc_modulo_BD mod = new doc_modulo_BD();
        Object[][] modulos;

        modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt((modulos[i][3] != null), i, 3);
        }
        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_buscar() {
        noeditablemodelo modelo = (noeditablemodelo) vista.getTbl_Datos().getModel();

        //MODULOS---SILABOS---------------------------------------------------------------------------------
        if (vista.getBtnModulos().isSelected() || vista.getBtnSilabo().isSelected()) {

            if (vista.getChk_periodo().isSelected() == true) {
                String com = vista.getComboPeriodAcademico().getSelectedItem().toString();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 1).toString().equals(com)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_materia().isSelected() == true) {
                String com = vista.getTxt_materia().getText().toUpperCase();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 2).toString().toUpperCase().matches(".*" + com + ".*")) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_doc().isSelected() == true) {
                boolean res;
                if (vista.getCombodocu().getSelectedItem().toString() == "Subidos") {
                    res = true;
                } else {
                    res = false;
                }
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if ((boolean) modelo.getValueAt(i, 3) != res) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }
        }

        //PLANES DE CLASES------------------------------------------------------------------------------------
        if (vista.getBtnPlanesClase().isSelected()) {

            if (vista.getChk_periodo().isSelected() == true) {
                String com = vista.getComboPeriodAcademico().getSelectedItem().toString();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 1).toString().equals(com)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_materia().isSelected() == true) {
                String com = vista.getTxt_materia().getText().toUpperCase();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 2).toString().toUpperCase().matches(".*" + com + ".*")) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_doc().isSelected() == true) {
                boolean res;
                if (vista.getCombodocu().getSelectedItem().toString() == "Subidos") {
                    res = true;
                } else {
                    res = false;
                }
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if ((boolean) modelo.getValueAt(i, 4) != res) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }
        }

        //INSTRUMENTOS DE EVALUACION---NOTAS---INFORMES------------------------------------------------------------------------------
        if (vista.getBtnInstrumentosEv().isSelected() || vista.getBtnInformesSilabo().isSelected() || vista.getBtnNotas().isSelected()) {

            if (vista.getChk_periodo().isSelected() == true) {
                String com = vista.getComboPeriodAcademico().getSelectedItem().toString();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 1).toString().equals(com)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_materia().isSelected() == true) {
                String com = vista.getTxt_materia().getText().toUpperCase();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 2).toString().toUpperCase().matches(".*" + com + ".*")) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_doc().isSelected() == true) {
                boolean res;
                if (vista.getCombodocu().getSelectedItem().toString() == "Subidos") {
                    res = true;
                } else {
                    res = false;
                }
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if ((boolean) modelo.getValueAt(i, 8) != res) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_paralelo().isSelected() == true) {
                String com = vista.getComboparalelo().getSelectedItem().toString();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 7).toString().equals(com)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_ciclo().isSelected() == true) {
                String ciclo = vista.getComboCiclo().getSelectedItem().toString();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 5).toString().equals(ciclo)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }

            if (vista.getChk_seccion().isSelected() == true) {
                String seccion = vista.getComboSeccion().getSelectedItem().toString().toUpperCase();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (!modelo.getValueAt(i, 6).toString().toUpperCase().equals(seccion)) {
                        modelo.removeRow(i);
                        i = i - 1;
                    }
                }
            }
        }
        vista.getBtn_buscar().setEnabled(false);
        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_silabo() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
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

        doc_silabo_BD mod = new doc_silabo_BD();
        Object[][] modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt((modulos[i][3] != null), i, 3);
        }

        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_planes() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("N° Plan");
        modelo.addColumn("Documento");

        doc_planes_claseBD mod = new doc_planes_claseBD();
        Object[][] modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt(modulos[i][3], i, 3);
            modelo.setValueAt((modulos[i][4] != null), i, 4);
        }

        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_notas() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Seccion");
        modelo.addColumn("Docente");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Jornada");
        modelo.addColumn("Paralelo");
        modelo.addColumn("Documento");

        doc_notas_BD mod = new doc_notas_BD();
        Object[][] modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt(modulos[i][3], i, 3);
            modelo.setValueAt(modulos[i][4], i, 4);
            modelo.setValueAt(modulos[i][5], i, 5);
            modelo.setValueAt(modulos[i][6], i, 6);
            modelo.setValueAt(modulos[i][7], i, 7);
            modelo.setValueAt((modulos[i][8] != null), i, 8);
        }

        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_instrumentos() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Instrumento");
        modelo.addColumn("Docente");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Jornada");
        modelo.addColumn("Paralelo");
        modelo.addColumn("Documento");

        doc_instrumento_evaluacionBD mod = new doc_instrumento_evaluacionBD();
        Object[][] modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt(modulos[i][3], i, 3);
            modelo.setValueAt(modulos[i][4], i, 4);
            modelo.setValueAt(modulos[i][5], i, 5);
            modelo.setValueAt(modulos[i][6], i, 6);
            modelo.setValueAt(modulos[i][7], i, 7);
            modelo.setValueAt((modulos[i][8] != null), i, 8);
        }

        vista.getTbl_Datos().setModel(modelo);
    }

    public void tabla_informes() {
        noeditablemodelo modelo = new noeditablemodelo() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Informe");
        modelo.addColumn("Docente");
        modelo.addColumn("Periodo");
        modelo.addColumn("Materia");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Jornada");
        modelo.addColumn("Paralelo");
        modelo.addColumn("Documento");

        doc_informes_BD mod = new doc_informes_BD();
        Object[][] modulos = mod.datos_unidos(carrera);

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt(modulos[i][3], i, 3);
            modelo.setValueAt(modulos[i][4], i, 4);
            modelo.setValueAt(modulos[i][5], i, 5);
            modelo.setValueAt(modulos[i][6], i, 6);
            modelo.setValueAt(modulos[i][7], i, 7);
            modelo.setValueAt((modulos[i][8] != null), i, 8);
        }

        vista.getTbl_Datos().setModel(modelo);
    }

    public String nom_periodo(int cod) {
        for (int i = 0; i < listPer.size(); i++) {
            if (listPer.get(i).getIdperiodo() == cod) {
                return listPer.get(i).getNombre();
            }
        }
        return null;
    }

    public String nom_materia(String cod) {
        for (int i = 0; i < listMat.size(); i++) {
            if (listMat.get(i).getCod_materia().equals(cod)) {
                return listMat.get(i).getNombre_materia();
            }
        }
        return null;
    }

    public int cod_periodo(String nomb) {
        for (int i = 0; i < listPer.size(); i++) {
            if (listPer.get(i).getNombre().equals(nomb)) {
                return listPer.get(i).getIdperiodo();
            }
        }
        return 0;
    }

    public String cod_materia(String nom) {
        for (int i = 0; i < listMat.size(); i++) {
            if (listMat.get(i).getNombre_materia().toLowerCase().contains(nom) == true) {
                return listMat.get(i).getCod_materia();
            }
        }
        return null;
    }

    public void imprimir() {
        Conect con = new Conect();
        String reporte="";
        if (vista.getBtnModulos().isSelected()) {
            reporte="/Reportes/r_modulo.jasper";
        }
        try {               
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource(reporte));
                Map<String, Object> params = new HashMap<String, Object>();
                String carrera = this.carrera;
                String cod="";
                for (int i = 0; i < vista.getTbl_Datos().getRowCount(); i++) {
                    if (i!=vista.getTbl_Datos().getRowCount()-1){
                        cod=cod+vista.getTbl_Datos().getValueAt(i, 0).toString()+",";
                    }
                    else{
                        cod=cod+vista.getTbl_Datos().getValueAt(i, 0).toString();
                    }
                }
                params.put("Carrera",carrera);
                params.put("Codigos",cod);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
    }

    public void subir_datos() {
        if (vista.getBtnModulos().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdmodulo.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
        if (vista.getBtnSilabo().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdsilabo.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
        if (vista.getBtnPlanesClase().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdplanes.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
        if (vista.getBtnNotas().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdnotas.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
        if (vista.getBtnInformesSilabo().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdinformes.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
        if (vista.getBtnInstrumentosEv().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            if (bdinstrumentos.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()), vista)) {
                System.out.println("Archivos subido");
            } else {
                System.out.println("Error al subir el archivo");
            }
        }
    }

    public void abrir() {
        vista.getTbl_Datos().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (vista.getTbl_Datos().getSelectedRow() > -1) {
                        try {
                            if (vista.getBtnModulos().isSelected()) {
                                bdmodulo.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                            if (vista.getBtnSilabo().isSelected()) {
                                bdsilabo.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                            if (vista.getBtnPlanesClase().isSelected()) {
                                bdplanes.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                            if (vista.getBtnNotas().isSelected()) {
                                bdnotas.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                            if (vista.getBtnInformesSilabo().isSelected()) {
                                bdinformes.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                            if (vista.getBtnInstrumentosEv().isSelected()) {
                                bdinstrumentos.abrir(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
                            }
                        } catch (Exception ex) {
                            System.out.println("Seleccione un archivo con documento");
                        }
                    }
                }
            }
        });
    }

}
