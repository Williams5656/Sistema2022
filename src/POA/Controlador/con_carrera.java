package POA.Controlador;

import POA.Vista.Vis_Carrera;
import POA.Modelo.CarreraMD;
import POA.Modelo.CarreraBD;
import POA.Vista.*;
import POA.Modelo.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import POA.Modelo.Validadores.Numeros;
import POA.Modelo.Validadores.Letras;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class con_carrera {

    private final Vis_Carrera vista;
    private CarreraBD carrera = new CarreraBD();
    private PerfilBD bdperfil = new PerfilBD();
//
    private PersonaBD bdpersona = new PersonaBD();
    private List<PersonaMD> listaPersonas = new ArrayList<>();

    public con_carrera(Vis_Carrera vista) {
        this.vista = vista;
        vista.setVisible(true);
        desactivarbotones();
        validaciones();
        //vista.setLocationRelativeTo(null);
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnImprimir().addActionListener(e -> imprimir());
//        vista.getBtnBuscarc().addActionListener(e->buscarced());
        vista.getTablaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        listam();
        buscar();
    }

    public void desactivarbotones() {

        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnNuevo().setEnabled(true);
//      vista.getBtnimprimir().setEnabled(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        vista.getComboCarrera().setEnabled(false);
        vista.getTxtCodigo_carrera().setEnabled(false);
        vista.getTxtFecha_inicio().setEnabled(false);
        vista.getTxtCoordinador().setEnabled(false);

    }

    public void activarbotones() {

        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnNuevo().setEnabled(true);
//      vista.getBtnimprimir().setEnabled(true);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnEliminar().setEnabled(true);
        vista.getComboCarrera().setEnabled(true);
        vista.getTxtCodigo_carrera().setEnabled(true);
        vista.getTxtFecha_inicio().setEnabled(true);
        vista.getTxtCoordinador().setEnabled(true);

    }

    public void buscar() {
        listaPersonas = bdpersona.mostrardatos();
        vista.getTxtCoordinador().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                for (PersonaMD person : listaPersonas) {
                    if (person.getCedula().equals(vista.getTxtCoordinador().getText())) {
                        vista.getLblNombre().setText(person.getNombres() + " " + person.getApellidos());
                    }
                }
                if (vista.getTxtCoordinador().getText().equals("")) {
                    vista.getLblNombre().setText("");
                }

            }

        });
    }

    public void guardar() {
        boolean c=true;
        String n_carrera = (String) vista.getComboCarrera().getSelectedItem();
        carrera.setNombre_carrera(n_carrera);
//        carrera.setCodigo_carrera(vista.getTxtCodigo_carrera().getText());
        String codigo = (String) vista.getTxtCodigo_carrera().getText();
        List<CarreraMD> lista_cod = carrera.obtenerdatos(codigo);
        for (int i = 0; i < lista_cod.size(); i++) {
            if (lista_cod.get(i).getCodigo_carrera().equals(vista.getTxtCodigo_carrera().getText())) {
                JOptionPane.showMessageDialog(null, "Còdigo ya existe!","\n Verifique",0);
                vista.getTxtCodigo_carrera().setText("");
                c = false;
                break;
            }
        }
        carrera.setFecha_inicio(vista.getTxtFecha_inicio().getText());
        String modalidad = (String) vista.getCmbModalidad().getSelectedItem();
        carrera.setModalidad(modalidad);
        carrera.setCoordinador(vista.getTxtCoordinador().getText());  
        if (c == true) {
            if (carrera.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            listam();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        } 
      }
    }

    public void seleccionar() {

//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
//        String codigo = (String) modelo.getValueAt(vista.getTablaCarrera().getSelectedRow(), 0);
//        System.out.println(codigo);
        int select = vista.getTablaCarrera().getSelectedRow();
        List<CarreraMD> lista = carrera.mostrardatos();
        List<PersonaMD> listaper = bdpersona.mostrardatos();
        carrera.setCodigo_carrera(lista.get(select).getCodigo_carrera());
        carrera.setNombre_carrera(lista.get(select).getNombre_carrera());
        carrera.setFecha_inicio(lista.get(select).getFecha_inicio());
        carrera.setModalidad(lista.get(select).getModalidad());
        carrera.setCoordinador(lista.get(select).getCoordinador());

        bdpersona.setNombres(listaper.get(select).getNombres());
        bdpersona.setApellidos(listaper.get(select).getApellidos());

        vista.getTxtCodigo_carrera().setText(carrera.getCodigo_carrera());
        vista.getComboCarrera().setSelectedItem(carrera.getNombre_carrera());
        vista.getTxtFecha_inicio().setText(carrera.getFecha_inicio());
        vista.getCmbModalidad().setSelectedItem(carrera.getModalidad());
        vista.getTxtCoordinador().setText(carrera.getCoordinador());

        String nombre = bdpersona.getNombres() + " " + bdpersona.getApellidos();
        vista.getLblNombre().setText(nombre);

    }

    public void listam() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
        List<CarreraMD> lista = carrera.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaCarrera().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }

        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaCarrera().setValueAt(lista.get(i).getCodigo_carrera(), i, 0);
            vista.getTablaCarrera().setValueAt(lista.get(i).getNombre_carrera(), i, 1);
            vista.getTablaCarrera().setValueAt(lista.get(i).getFecha_inicio(), i, 2);
            vista.getTablaCarrera().setValueAt(lista.get(i).getModalidad(), i, 3);
            vista.getTablaCarrera().setValueAt(lista.get(i).getCoordinador(), i, 4);

        }

    }

    public void modificar() {
//        carrera.setNombre_carrera(vista.getTxtNombre_carrera().getText());
        String n_carrera = (String) vista.getComboCarrera().getSelectedItem();
        carrera.setNombre_carrera(n_carrera);
        carrera.setCodigo_carrera(vista.getTxtCodigo_carrera().getText());
//        String cuenta=Integer.toString(generacodi());
//        carrera.setCodigo_carrera(cuenta);
        carrera.setFecha_inicio(vista.getTxtFecha_inicio().getText());
        String modalidad = (String) vista.getCmbModalidad().getSelectedItem();
        carrera.setModalidad(modalidad);
        carrera.setCoordinador(vista.getTxtCoordinador().getText());
        int resp2 = JOptionPane.showConfirmDialog(null, "CONFIRME SI DESEA MODIFICAR");
        if (resp2 == 0) {
            if (carrera.modificar(vista.getTxtCodigo_carrera().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                listam();
                nuevo();

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    public void eliminar() {
        int resp1 = JOptionPane.showConfirmDialog(null, "CONFIRME SI DESEA ELIMINAR");
        if (resp1 == 0) {
            if (carrera.Eliminar(vista.getTxtCodigo_carrera().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                listam();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
            }

        }
    }

    public void nuevo() {

        activarbotones();
        vista.getTxtCodigo_carrera().setText("");
        vista.getComboCarrera().setSelectedItem("");
        vista.getTxtFecha_inicio().setText("");
        vista.getCmbModalidad().setSelectedItem("");
        vista.getTxtCoordinador().setText("");
    }

    public void buscar_c() {
        if (vista.getTxtCoordinador().getText().equals("")) {
            listam();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablaCarrera().getModel();
            List<CarreraMD> listac = carrera.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablaCarrera().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < listac.size(); i++) {
                    if (listac.get(i).getCodigo_carrera().equals(vista.getTxtCoordinador().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCodigo_carrera(), i, 0);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getNombre_carrera(), i, 1);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getFecha_inicio(), i, 2);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getModalidad(), i, 3);
                        vista.getTablaCarrera().setValueAt(listac.get(i).getCoordinador(), i, 4);
                    }
                }
            }
        }
        nuevo();
    }

        public void imprimir() {
        Conect con = new Conect();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteCarreras.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
//            JOptionPane.showMessageDialog(null, "Imprimiendo Materias");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(con_carrera.class.getName()).log(Level.SEVERE, null, e);
        }

    }
        
    private void only_num(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < '0' | e.getKeyChar() > '9' | (vista.getTxtCoordinador().getText().length() >= 10)) {
                    System.out.println("Ingrese cèdula");
                    e.consume();
                }
            }
        }
        );
    }

    public void validaciones() {

        Numeros.solo_numeros(vista.getTxtCoordinador());
        only_num(vista.getTxtCoordinador());
//        Numeros.solo_numeros(vista.getTxtCodigo_carrera());
        Letras.numero_letras(vista.getTxtCodigo_carrera(), 4);
        Letras.no_espacios(vista.getTxtCodigo_carrera());
        vista.getTablaCarrera().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccionar();
                } catch (Exception ex) {
                    Logger.getLogger(con_carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
