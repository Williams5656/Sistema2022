/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POA.Controlador;

import POA.Vista.*;
import POA.Controlador.*;
import POA.Modelo.Validadores.*;
import static POA.Controlador.Con_principal.vista;
import POA.Modelo.CarreraBD;
import POA.Modelo.PoaBD;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    public static List<POA.Modelo.CarreraMD> listaCarreras = new ArrayList<>();
    private POA.Modelo.PoaBD baseDatosPoa = new PoaBD();
    private POA.Modelo.CarreraBD baseDatosCarrera = new CarreraBD();
    private static int id_poa;
    private boolean tablaSeleccionada = false;

    public Con_Poa1(Vis_Poa1 vista) {
        this.vista = vista;
        listaCarreras = baseDatosCarrera.mostrardatos();
        listaPOA = baseDatosPoa.mostrarDatos();
        for (int i = 0; i < listaCarreras.size(); i++) {
            vista.getCbxCarrera().addItem(listaCarreras.get(i).getNombre_carrera());
        }
        vista.setVisible(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        vista.getBtnAniadirProyectos().setEnabled(false);
        vista.setTitle("POA");
        vista.getLbid_carrera().setText("");
        vista.getBtnGuardar().addActionListener(e -> guardar());
        vista.getBtnAniadirProyectos().addActionListener(e -> abrirVentanaProyectos());
        vista.getBtnNuevo().addActionListener(e -> limpiarCampos());

        vista.getTablaPoa().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        ;
        });
        validar();
        lista();

    }

    public void validar() {
        vista.getCbxCarrera().addItemListener(new id_carrera(vista.getCbxCarrera(), vista.getLbid_carrera()));
    }

    public void lista() {
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

            for (POA.Modelo.CarreraMD carr : listaCarreras) {
                if (user.getId_carrera() == Integer.parseInt(carr.getCodigo_carrera())) {
                    fila[1] = carr.getNombre_carrera();
                }
            }

            fila[2] = user.getAnio();
            fila[3] = user.getEstado();

            model.addRow(fila);
        }

        vista.getTablaPoa().setModel(model);
    }

    public void guardar() {
        int id_carrera = 0;
        listaCarreras = baseDatosCarrera.mostrardatos();
        for (POA.Modelo.CarreraMD carr : listaCarreras) {
            if (((String) vista.getCbxCarrera().getSelectedItem()).equals(carr.getNombre_carrera())) {
                id_carrera = Integer.parseInt(carr.getCodigo_carrera());
            }
        }
        boolean f = false;
        String anio = String.valueOf(vista.getyChooser().getValue());
        for (int i = 0; i < listaPOA.size(); i++) {
            if (listaPOA.get(i).getId_carrera() == id_carrera && listaPOA.get(i).getAnio().equalsIgnoreCase(anio)) {
                f = true;
            }
        }
        if (f == true) {
            JOptionPane.showMessageDialog(null, "Este Poa ya existe");
        } else {
            baseDatosPoa.guardar(id_carrera, vista.getyChooser().getValue() + "", "Activo");
            lista();
            JOptionPane.showMessageDialog(null, "Guardado");
            limpiarCampos();
        }
    }

    public void nuevo() {
        limpiarCampos();
    }

    public void limpiarCampos() {
        vista.getBtnGuardar().setEnabled(true);
        vista.getBtnModificar().setEnabled(false);
        vista.getBtnEliminar().setEnabled(false);
        vista.getyChooser().setValue(2022);
        tablaSeleccionada = false;

        vista.getTablaPoa().setCellSelectionEnabled(false);

    }

    public void seleccionar() {
        int seleccionado = vista.getTablaPoa().getSelectedRow();
        tablaSeleccionada = true;
        id_poa = listaPOA.get(seleccionado).getId_POA();
        vista.getBtnAniadirProyectos().setEnabled(true);
    }

    public void abrirVentanaProyectos() {

        if (tablaSeleccionada==true) {
            POA.Vista.vis_poa_proyectos zap = new vis_poa_proyectos();
            Con_principal.vista.getESCRITORIO().add(zap);
            Dimension desktopSize = Con_principal.vista.getESCRITORIO().getSize();
            Dimension FrameSize = zap.getSize();
            zap.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            Con_poa_proyectos proyectos = new Con_poa_proyectos(zap, id_poa);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un POA de la tabla");
        }
    }

    public static int getId_poa() {
        return id_poa;
    }

}
