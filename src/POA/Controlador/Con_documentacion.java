
package POA.Controlador;

import POA.Modelo.DocumentacionBD;
import POA.Modelo.DocumentacionMD;
import POA.Vista.Vis_Documentacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC FACTORY
 */
public class Con_documentacion {
    public final Vis_Documentacion vista;
    DocumentacionBD bddocumentacion = new DocumentacionBD();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<DocumentacionMD> listadocumentacion = new ArrayList<>();
    public Con_documentacion(Vis_Documentacion vista) {
        this.vista = vista;
    }
}
