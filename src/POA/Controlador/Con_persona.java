/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Controlador;

import POA.Modelo.Conect;
import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Modelo.Validadores.Cedula;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.Validadores.Numeros;
import POA.Vista.vis_Persona;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * @author MIGUEL
 */
public class Con_persona {

    private final vis_Persona vista;
    PersonaBD per = new PersonaBD();
    protected static String Orig;
    String error;

    public Con_persona(vis_Persona vista) {
        this.vista = vista;
        validadores();
        vista.setVisible(true);
        vista.getLbError().setVisible(false);
        vista.getBtnNuevo().addActionListener(e -> nuevo());
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnModificar().addActionListener(e -> modificar());
        vista.getBtnCargarFoto().addActionListener(e -> obtieneImagen());
        vista.getBtnCamEstado().addActionListener(e -> cambiarestado());
        vista.getBtnImprimir().addActionListener(e -> imprimirpersona());
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnCamEstado().setEnabled(false);
        vista.getBtnImprimir().setEnabled(false);
        vista.getTxtCedula().setEnabled(false);
        vista.getTxtNombre().setEnabled(false);
        vista.getTxtApellido().setEnabled(false);
        vista.getTxtCelular().setEnabled(false);
        vista.getTxtDireccion().setEnabled(false);
        vista.getFecha().setEnabled(false);
        vista.getTxtCorreo().setEnabled(false);
        lista();

    }
    public void imprimir(){
          Conect con = new Conect();
            try {
               
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Personas.jasper"));
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                JOptionPane.showMessageDialog(null, "Imprimiendo Personas");
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    public void imprimirpersona(){
       Conect con = new Conect();
        String[] reportes = {
            "Seleccione Una Opcion",
            "Reporte Con Cedula",
            "Reporte Completo"
        };
        //Ctrl_MYICON icon = new Ctrl_MYICON(40, 50);
        String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un reporte", "Reporte De Personas",
                JOptionPane.DEFAULT_OPTION, null, reportes, reportes[0]);
        if (resp.equals("Seleccione Una Opcion")) {
            JOptionPane.showMessageDialog(null, " seleccione uno de los campos");

        }
        if (resp.equals("Reporte Con Cedula")) {
 
            try {
               // JOptionPane.showMessageDialog(null, "Imprimiendo Persona");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Personas.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
 String aguja = JOptionPane.showInputDialog("Ingrese una Cedula de persona");
////                String aguja = vista.getTxtBuscar().getText();
                System.out.println("cedula;;;;"+ aguja);
                params.put("cedula",aguja);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        if (resp.equals("Reporte Completo")) {

            try {
                JOptionPane.showMessageDialog(null, "imprimiendo Docentes");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteDocente.jasper"));

                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void seleccionar() throws ParseException {
        vista.getBtnGuardar().setEnabled(false);
        vista.getBtnModificar().setEnabled(true);
        vista.getBtnCamEstado().setEnabled(true);
        vista.getBtnImprimir().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablePersonas().getSelectedRow(), 0);
        System.out.println(cedula);
        List<PersonaMD> lista = per.obtenerdatos(cedula);
        per.setCedula(lista.get(0).getCedula());
        per.setNombres(lista.get(0).getNombres());
        per.setApellidos(lista.get(0).getApellidos());
        per.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());
        per.setDireccion(lista.get(0).getDireccion());
        per.setCorreo(lista.get(0).getCorreo());
        per.setTelefono(lista.get(0).getTelefono());
        per.setEstado(lista.get(0).getEstado());

        vista.getTxtCedula().setText(per.getCedula());
        vista.getTxtNombre().setText(per.getNombres());
        vista.getTxtApellido().setText(per.getApellidos());
        vista.getTxtDireccion().setText(per.getDireccion());
        vista.getTxtCorreo().setText(per.getCorreo());
        vista.getTxtCelular().setText(per.getTelefono());

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d = formato.parse(per.getFecha_nacimiento());
            vista.getFecha().setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLbFoto().setIcon(icon);
        } else {
            vista.getLbFoto().setIcon(null);
        }
    }

    public void comprobar_ced() {
        vista.getTxtCedula().addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!Cedula.valcedula(vista.getTxtCedula())) {
                    men_error(1);
                }
            }
        }
        );

    }

    public void val_correo() {
        vista.getTxtCorreo().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher mather = pattern.matcher(vista.getTxtCorreo().getText());
                if (!mather.find()) {
                    men_error(5);
                }
            }

        }
        );
    }

    public void men_error(int a) {
        switch (a) {
            case 1: {
                error = "Cedula Erronea";
                break;
            }
            case 2: {
                error = "Nombre Erroneo";
                break;
            }
            case 3: {
                error = "Apellido Erroneo";
                break;
            }
            case 4: {
                error = "Correo Erroneo";
                break;
            }
            case 5: {
                error = "Direccion Erronea";
                break;
            }
            case 6: {
                error = "Celular Erroneo";
                break;
            }
            case 7: {
                error = "Fecha Erronea";
                break;
            }
        }
        Timer tiempo = new Timer();
        TimerTask men_erro;
        vista.getLbError().setText(error);
        vista.getLbError().setVisible(true);
        men_erro = new TimerTask() {
            @Override
            public void run() {
                vista.getLbError().setText("");
                vista.getLbError().setVisible(false);
            }
        };

        tiempo.schedule(men_erro, 3000);

    }

    public void guardar() {
        if (vista.getTxtNombre().getText().equals("") || vista.getTxtNombre().getText().equals("") || vista.getTxtApellido().getText().equals("") || vista.getTxtDireccion().getText().equals("") || vista.getTxtCorreo().getText().equals("") || vista.getTxtCelular().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            per.setCedula(vista.getTxtCedula().getText());
            per.setNombres(vista.getTxtNombre().getText());
            per.setApellidos(vista.getTxtApellido().getText());
            per.setDireccion(vista.getTxtDireccion().getText());
            per.setCorreo(vista.getTxtCorreo().getText());
            per.setTelefono(vista.getTxtCelular().getText());
            per.setEstado("ACTIVO");
            ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
            per.setFoto(ic.getImage());
            SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formato6.format(vista.getFecha().getDate());
            per.setFecha_nacimiento(fecha);
            int b = JOptionPane.showConfirmDialog(null, "Confirme los datos: \nCedula: " + vista.getTxtCedula().getText() + "\nNombre: " + vista.getTxtNombre().getText() + "\nApellidos: " + vista.getTxtApellido().getText() + "\nDireccion: " + vista.getTxtDireccion().getText() + "\nCorreo: " + vista.getTxtCorreo().getText() + "\nTelefono: " + vista.getTxtCelular().getText() + "\nEstado: " + per.getEstado(), "Confirmar Compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            int a = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar", "Confirmar persona", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a == 0 && b == 0) {
                if (per.insertar()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    nuevo();
                    lista();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }
        }
    }

    public void nuevo() {
        vista.getTxtCedula().setEnabled(true);
        vista.getTxtNombre().setEnabled(true);
        vista.getTxtApellido().setEnabled(true);
        vista.getTxtCelular().setEnabled(true);
        vista.getTxtDireccion().setEnabled(true);
        vista.getFecha().setEnabled(true);
        vista.getTxtCorreo().setEnabled(true);
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnImprimir().setEnabled(false);
        vista.getBtnCamEstado().setEnabled(false);
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getTxtNombre().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtDireccion().setText("");
        vista.getTxtCorreo().setText("");
        vista.getFecha().setDate(null);
        //setImage("/POA/Vista/img/instituto.jpg");
        Orig = "src/img/imagen.png";
        ImageIcon icon = new ImageIcon(Orig);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT));
        vista.getLbFoto().setText(null);
        vista.getLbFoto().setIcon(icono);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
        List<PersonaMD> lista9 = per.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablePersonas().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
            for (int i = 0; i < lista9.size(); i++) {
                modelo.addRow(new Object[columnas]);
                vista.getTablePersonas().setValueAt(lista9.get(i).getCedula(), i, 0);
                vista.getTablePersonas().setValueAt(lista9.get(i).getNombres(), i, 1);
                vista.getTablePersonas().setValueAt(lista9.get(i).getApellidos(), i, 2);
                vista.getTablePersonas().setValueAt(lista9.get(i).getFecha_nacimiento(), i, 3);
                vista.getTablePersonas().setValueAt(lista9.get(i).getDireccion(), i, 4);
                vista.getTablePersonas().setValueAt(lista9.get(i).getCorreo(), i, 5);
                vista.getTablePersonas().setValueAt(lista9.get(i).getTelefono(), i, 6);
                vista.getTablePersonas().setValueAt(lista9.get(i).getEstado(), i, 7);
            }

        }

    }

    private void obtieneImagen() {
        vista.getLbFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLbFoto().getWidth(), vista.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLbFoto().setIcon(new ImageIcon(icono));
                vista.getLbFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificar() {

        per.setCedula(vista.getTxtCedula().getText());
        per.setNombres(vista.getTxtNombre().getText());
        per.setApellidos(vista.getTxtApellido().getText());
        SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato6.format(vista.getFecha().getDate());
        per.setFecha_nacimiento(fecha);

        per.setDireccion(vista.getTxtDireccion().getText());
        per.setCorreo(vista.getTxtCorreo().getText());
        per.setTelefono(vista.getTxtCelular().getText());
        ImageIcon ic = (ImageIcon) vista.getLbFoto().getIcon();
        per.setFoto(ic.getImage());

        int resp2 = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?");
        if (resp2 == 0) {
            if (per.Modificar(vista.getTxtCedula().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }

        }

    }

    public void buscar() {
        if (vista.getTxtBuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablePersonas().getModel();
            List<PersonaMD> lista1 = per.mostrardatos();
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablePersonas().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
                for (int i = 0; i < lista1.size(); i++) {
                    if (lista1.get(i).getCedula().equals(vista.getTxtBuscar().getText())) {
                        modelo.addRow(new Object[columnas]);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getCedula(), i, 0);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getNombres(), i, 1);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getApellidos(), i, 2);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getDireccion(), i, 3);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getCorreo(), i, 4);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getTelefono(), i, 5);
                        vista.getTablePersonas().setValueAt(lista1.get(i).getFecha_nacimiento(), i, 6);
                    }
                }
            }
        }
        nuevo();
    }

    public void cambiarestado() {
        List<PersonaMD> lista = per.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equalsIgnoreCase(vista.getTxtCedula().getText())) {
                if (lista.get(i).getEstado().equalsIgnoreCase("ACTIVO")) {
                    per.setEstado("INACTIVO");

                } else {
                    per.setEstado("ACTIVO");
                }
            }
        }
        if (per.cambiarestado((vista.getTxtCedula().getText()))) {
            JOptionPane.showMessageDialog(null, "ESTADO MODIFICADO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }

    }

    public void validadores() {

        ////////validaciones ced///////
        Letras.no_espacios(vista.getTxtCedula());
        Letras.numero_letras(vista.getTxtCedula(), 9);
        Numeros.solo_numeros(vista.getTxtCedula());
        comprobar_ced();
        ///////////////val nombre///////////////
        Letras.solo_letras(vista.getTxtNombre());
        Letras.dosespacios(vista.getTxtNombre());
        //////////////val apellidos////////////
        Letras.solo_letras(vista.getTxtApellido());
        Letras.dosespacios(vista.getTxtApellido());
        ///////////////// resto ///////////////////
        Numeros.solo_numeros(vista.getTxtCelular());
        Letras.numero_letras(vista.getTxtCelular(), 9);
        Letras.no_espacios(vista.getTxtCorreo());
        val_correo();
        vista.getTablePersonas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccionar();
                } catch (ParseException ex) {
                    Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
