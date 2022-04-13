package POA.Controlador;

import POA.Modelo.AreaCarreraBD;
import POA.Modelo.AreaCarreraMD;
import POA.Modelo.AsignacionMateriaDocenteBD;
import POA.Modelo.AsignacionMateriaDocentesMD;
import POA.Modelo.Conect;
import POA.Modelo.DocumentacionBD;
import POA.Modelo.DocumentacionMD;
import POA.Modelo.MateriaBD;
import POA.Modelo.MateriaMD;
import POA.Modelo.PeriodoacademicoBD;
import POA.Modelo.PeriodoacademicoMD;
import POA.Modelo.PersonaBD;
import POA.Modelo.PersonaMD;
import POA.Modelo.docenteMD;
import POA.Vista.Vis_Documentacion;
import static POA.Vista.Vis_Principal.ESCRITORIO;
import POA.Vista.vis_asignacionmateriadocentes;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import POA.Modelo.Validadores.Numeros;
import POA.Modelo.Validadores.Letras;
import POA.Modelo.Validadores.id_carrera;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PC FACTORY
 */
public class Con_documentacion {

    public final Vis_Documentacion vista;
    DocumentacionBD bddocumentacion = new DocumentacionBD();

    private DefaultTableModel modelo = new DefaultTableModel();
    private List<DocumentacionMD> lista = new ArrayList<>();
    private List<AsignacionMateriaDocentesMD> listaasignacion = new ArrayList<>();
    private AsignacionMateriaDocenteBD baseAsignacion = new AsignacionMateriaDocenteBD();
    private List<PeriodoacademicoMD> listaPeriodo = new ArrayList<>();
    private PeriodoacademicoBD basePeriodo = new PeriodoacademicoBD();
    private List<PersonaMD> listaPersona = new ArrayList<>();
    private MateriaBD baseMateria = new MateriaBD();
    private List<MateriaMD> listaMateria = new ArrayList<>();
    private PersonaBD baseDatosPersona = new PersonaBD();
    private List<AreaCarreraMD> listaArea = new ArrayList<>();
    private AreaCarreraBD baseArea = new AreaCarreraBD();
    int asignacion;
    boolean horas = false;
    private static int plan;

    public Con_documentacion(Vis_Documentacion vista, int id_asignacion) {

        this.vista = vista;
        validaciones();
        ESCRITORIO.add(vista);
        Dimension desktopSize = ESCRITORIO.getSize();
        Dimension FrameSize = vista.getSize();
        this.vista.getTablaDocumentacion().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        vista.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        vista.setVisible(true);
        vista.getGuias().add(vista.getRadioSi());
        vista.getGuias().add(vista.getRadioNo());
        asignacion = id_asignacion;
        System.out.println(asignacion + "=  ID");
        vista.getBtnnuevo().addActionListener(e -> nuevo());
        vista.getBtn_regresar().addActionListener(e -> regresar());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtneditar().addActionListener(e -> modificar());
        vista.getBtnimprimir().addActionListener(e-> imprimir());
    }
    public void imprimir(){
        Conect con = new Conect();
        String docente = vista.getTxt_nombre().getText();
            try {
                // JOptionPane.showMessageDialog(null, "Imprimiendo Persona");
                JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RPlanes.jasper"));
                Map<String, Object> params = new HashMap<String, Object>();
                //String aguja = JOptionPane.showInputDialog("Ingrese una Cedula de persona");
                String aguja = docente;
                //String aguja = vista.getTxtBuscar().getText();
                //System.out.println("cedula;;;;" + aguja);
                params.put("doc", aguja);
                JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, params, con.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jv.setVisible(true);
            } catch (JRException e) {
                System.out.println("no se pudo encontrar registros" + e.getMessage());
                Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, e);
            }
    }

    public void activarBotones() {
        vista.getBtnguardar().setEnabled(true);
        vista.getBtneditar().setEnabled(true);
        vista.getFecha().setEnabled(true);
        vista.getComboEstado().setEnabled(true);
        vista.getTxt_horaguia().setEnabled(true);
        vista.getTxt_plan().setText("");
        vista.getTxt_horaguia().setText("");
        vista.getComboEstado().setSelectedIndex(0);
        vista.getFecha().setDate(null);
        limpiarRadios();
        activarRadio();
    }

    public void desactivarBotones() {
        vista.getBtnguardar().setEnabled(false);
        vista.getBtneditar().setEnabled(false);
        vista.getTxt_plan().setEditable(false);
        vista.getFecha().setEnabled(false);
        vista.getComboEstado().setEnabled(false);
        vista.getTxt_horaguia().setEnabled(false);
        desactivarRadio();
    }

    public void activarRadio() {
        vista.getRadioSi().setEnabled(true);
        vista.getRadioNo().setEnabled(true);
    }

    public void desactivarRadio() {
        vista.getRadioSi().setEnabled(false);
        vista.getRadioNo().setEnabled(false);
    }

    public void limpiarRadios() {
        vista.getGuias().clearSelection();
    }

    public String Radio() {
        if (vista.getRadioSi().isSelected()) {
            return vista.getRadioSi().getText();
        }
        if (vista.getRadioNo().isSelected()) {
            return vista.getRadioNo().getText();
        } else {
            return "0";
        }
    }

    public void eventoHoraguiaSi() {
        vista.getRadioSi().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                horas = true;
                vista.getTxt_horaguia().setEditable(true);
                vista.getTxt_horaguia().setEnabled(true);
            }

        });
    }

    public void eventoHoraguiaNo() {
        vista.getRadioNo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                horas = false;
                vista.getTxt_horaguia().setEditable(false);
                vista.getTxt_horaguia().setEnabled(false);
            }

        });
    }

    public void nuevo() {
        activarBotones();
        if (vista.getTablaDocumentacion().getRowCount() < plan) {
            vista.getTxt_plan().setText(vista.getTablaDocumentacion().getRowCount() + 1 + "");
        } else {
            JOptionPane.showMessageDialog(null, "El numero de plan esta exedido");
        }

    }

    public void guardar() {
        if (Radio().equals("0")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTADO");
        } else {
            bddocumentacion.setNumero(Integer.parseInt(vista.getTxt_plan().getText()));
            bddocumentacion.setId_asignacion(asignacion + "");
            String estado = (String) vista.getComboEstado().getSelectedItem();
            bddocumentacion.setEstado(estado);
            bddocumentacion.setGuias(Radio());
            SimpleDateFormat formato6 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = formato6.format(vista.getFecha().getDate());
            if (bddocumentacion.numfecha(fecha, asignacion + "") == bddocumentacion.fecha(asignacion + "")) {
                if (horas && Integer.parseInt(vista.getTxt_horaguia().getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Las horas debe ser mayor a cero");
                } else {
                    bddocumentacion.setFecha(fecha);
                    if (vista.getTxt_horaguia().getText().equals("")) {
                        bddocumentacion.setHorasGuia(0);
                    } else {
                        bddocumentacion.setHorasGuia(Integer.parseInt(vista.getTxt_horaguia().getText()));
                    }
                    if (bddocumentacion.insertar()) {
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
                        lista();
                        nuevo();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "LA FECHA INGRESADA ES MENOR A EL ULTIMO PLAN");
            }
        }
    }

    public void seleccionar() {
        activarBotones();
        vista.getBtnguardar().setEnabled(false);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaDocumentacion().getModel();
        int id_plan = (int) modelo.getValueAt(vista.getTablaDocumentacion().getSelectedRow(), 0);
        String estado = (String) vista.getComboEstado().getSelectedItem();
        List<DocumentacionMD> listadoc = bddocumentacion.obtenerdatos(id_plan);
        bddocumentacion.setId_plan(listadoc.get(0).getId_plan());
        bddocumentacion.setGuias(listadoc.get(0).getGuias());
        bddocumentacion.setHorasGuia(listadoc.get(0).getHorasGuia());
        bddocumentacion.setFecha(listadoc.get(0).getFecha());
        bddocumentacion.setEstado(listadoc.get(0).getEstado());

        vista.getTxt_plan().setText(bddocumentacion.getId_plan() + "");
        String guia = bddocumentacion.getGuias();
        if (guia.equalsIgnoreCase("SI")) {
            vista.getRadioSi().setSelected(true);
        } else {
            vista.getRadioNo().setSelected(true);
        }
        System.out.println(bddocumentacion.getFecha());
        vista.getTxt_horaguia().setText(bddocumentacion.getHorasGuia() + "");
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = formato.parse(bddocumentacion.getFecha());
            vista.getFecha().setDate(d1);
        } catch (ParseException ex) {
            Logger.getLogger(Con_persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        vista.getComboEstado().setSelectedItem(bddocumentacion.getEstado());
    }

    public void modificar() {
        int plan = Integer.parseInt(vista.getTxt_plan().getText());
        String estado = (String) vista.getComboEstado().getSelectedItem();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(vista.getFecha().getDate());
        bddocumentacion.setId_plan(Integer.parseInt(vista.getTxt_numPlan().getText()));
        bddocumentacion.setHorasGuia(Integer.parseInt(vista.getTxt_horaguia().getText()));
        bddocumentacion.setFecha(fecha);
        bddocumentacion.setEstado(estado);
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?", "", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            if (bddocumentacion.modificar(plan)) {
                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    public void regresar() {
        vista.setVisible(false);
        vis_asignacionmateriadocentes doc = new vis_asignacionmateriadocentes();
        Con_Asignacion_Docente per = new Con_Asignacion_Docente(doc);

        ESCRITORIO.add(doc);
        Dimension desktopSize = ESCRITORIO.getSize();
        Dimension FrameSize = doc.getSize();
        doc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

    }

    public void datos() {
        vista.getTxt_cedula().setEditable(false);
        vista.getTxt_ciclo().setEditable(false);
        vista.getTxt_gestor().setEditable(false);
        vista.getTxt_jornada().setEditable(false);
        vista.getTxt_materia().setEditable(false);
        vista.getTxt_nombre().setEditable(false);
        vista.getTxt_numPlan().setEditable(false);
        vista.getTxt_paralelo().setEditable(false);
        vista.getTxt_periodo().setEditable(false);
    }

    public void cargarDatos() {
        listaasignacion = baseAsignacion.mostrardatos();
        listaPersona = baseDatosPersona.mostrardatos();
        listaPeriodo = basePeriodo.lista_periodos();
        listaMateria = baseMateria.mostrardatos();
        listaArea = baseArea.mostrardatos();
        System.out.println(asignacion);
        for (AsignacionMateriaDocentesMD asignacion1 : listaasignacion) {
            System.out.println(asignacion1.getAsignatura());
            if (asignacion1.getId_asignacio() == asignacion) {
                vista.getTxt_cedula().setText(asignacion1.getIdentificacion());
                vista.getTxt_ciclo().setText(asignacion1.getCiclo());
                vista.getTxt_jornada().setText(asignacion1.getJornada());
                vista.getTxt_paralelo().setText(asignacion1.getParalelo());
                for (PeriodoacademicoMD periodo : listaPeriodo) {
                    if (periodo.getIdperiodo() == Integer.parseInt(asignacion1.getPeriodo())) {
                        vista.getTxt_periodo().setText(periodo.getNombre());
                    }
                }
                for (PersonaMD persona : listaPersona) {
                    if (persona.getCedula().equals(asignacion1.getIdentificacion())) {
                        vista.getTxt_nombre().setText(persona.getApellidos() + " " + persona.getNombres());
                    }
                };
                for (MateriaMD materia : listaMateria) {
                    if (materia.getCod_materia().equals(asignacion1.getAsignatura())) {
                        vista.getTxt_materia().setText(materia.getNombre_materia());
                        vista.getTxt_numPlan().setText(materia.getPlan());
                        plan = Integer.parseInt(materia.getPlan());
                        for (AreaCarreraMD area : listaArea) {
                            if (area.getIdArea() == Integer.parseInt(materia.getArea())) {
                                for (PersonaMD persona : listaPersona) {
                                    if (area.getIdResponsable().equals(persona.getCedula())) {
                                        vista.getTxt_gestor().setText(persona.getApellidos() + " " + persona.getNombres());
                                    }
                                }
                            }

                        }

                    }
                }

            }

        }

    }

    public void lista() {
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.addColumn("Id_plan");
        modelo.addColumn("Numero");
        modelo.addColumn("Asignacion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Guias");
        modelo.addColumn("Horas");
        modelo.addColumn("Estado");
        Object[] fila = new Object[7];
        lista = bddocumentacion.mostrardatos();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId_asignacion().equals(asignacion + "")) {
                fila[0] = lista.get(i).getId_plan();
                fila[1] = lista.get(i).getNumero();
                fila[2] = asignacion + "";
                fila[3] = lista.get(i).getFecha();
                fila[4] = lista.get(i).getGuias();
                fila[5] = lista.get(i).getHorasGuia();
                fila[6] = lista.get(i).getEstado();
                modelo.addRow(fila);
            }

        }
        vista.getTablaDocumentacion().setModel(modelo);

    }

    public void validaciones() {

        Letras.numero_letras(vista.getTxt_horaguia(), 2);
        Letras.no_espacios(vista.getTxt_horaguia());
        vista.getTablaDocumentacion().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccionar();
                } catch (Exception ex) {
                    Logger.getLogger(Con_documentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
