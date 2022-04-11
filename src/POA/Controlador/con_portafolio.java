/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Modelo.*;
import POA.Vista.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
        vista.getBtnModulos().addActionListener(e -> tabla_modulo());
        vista.getBtnSilabo().addActionListener(e -> tabla_silabo());
        vista.getBtnNotas().addActionListener(e -> tabla_notas());
        vista.getBtnPlanesClase().addActionListener(e -> tabla_planes());
        vista.getBtnInstrumentosEv().addActionListener(e -> tabla_instrumentos());
        vista.getBtnInformesSilabo().addActionListener(e -> tabla_informes());
        vista.getBtnImprimir().addActionListener(e -> imprimir());
        vista.getBtn_buscar().addActionListener(e -> buscar());
        vista.getBtn_subir().addActionListener(e -> subir_datos());

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

    public void buscar() {
        if (vista.getBtnModulos().isSelected()) {
            tabla_buscar_modulo();
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

    public void tabla_buscar_modulo() {
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
        Object[][] modulos = mod.buscar_x_parametro(carrera, cod_periodo(vista.getComboPeriodAcademico().getSelectedItem().toString()),
                vista.getChk_periodo().isSelected(),
                vista.getTxt_materia().getText().toUpperCase(),
                vista.getChk_materia().isSelected());

        for (int i = 0; i < modulos.length; i++) {
            modelo.addRow(new Object[0]);
            modelo.setValueAt(modulos[i][0], i, 0);
            modelo.setValueAt(modulos[i][1], i, 1);
            modelo.setValueAt(modulos[i][2], i, 2);
            modelo.setValueAt((modulos[i][3] != null), i, 3);
        }

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

    public void subir_doc_modulo() {
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                bdmodulo.setDocumento(icono);

            } catch (IOException ex) {
                Logger.getLogger(con_portafolio.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdmodulo.insertar_doc(Integer.parseInt(vista.getTbl_Datos().getValueAt(vista.getTbl_Datos().getSelectedRow(), 0).toString()));
        }
    }

    public void subir_datos() {
        if (vista.getBtnModulos().isSelected() && vista.getTbl_Datos().getSelectedRow() > -1) {
            subir_doc_modulo();
        }
    }

}
