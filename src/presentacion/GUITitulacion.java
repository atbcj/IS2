package presentacion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import clases.Titulacion;
import clases.Curso;
import logicaNegocio.FachadaTitulacionImp;

@SuppressWarnings("serial")
public class GUITitulacion extends JFrame {

    private FachadaTitulacionImp _fachadaTitulacionImp;
    private Titulacion _titulacion;
    
    private DefaultTableModel _dataTableModel;
    private String[] _headers = { "Titulaciones", "Num. Cursos" };
    private JTextField nombreTextField;

    public GUITitulacion(Titulacion titulacion) {
        _titulacion = titulacion;
        _fachadaTitulacionImp = new FachadaTitulacionImp(_titulacion);
        initGUI();
    }

    private void initGUI() {
        setTitle("Gestión de Titulaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel datosPanel = new JPanel();
        datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));

        nombreTextField = new JTextField();

        datosPanel.add(new JLabel("Nombre: "));
        datosPanel.add(nombreTextField);

        JButton alta = new JButton("Crear");
        alta.addActionListener((e) -> crearTitulacion());
        JButton baja = new JButton("Eliminar");
        baja.addActionListener((e) -> eliminarTitulacion());
        JButton modificacion = new JButton("Modificar");
        modificacion.addActionListener((e) -> modificarTitulacion());
        JButton consulta = new JButton("Consultar");
        consulta.addActionListener((e) -> consultarTitulacion());

        datosPanel.add(alta);
        datosPanel.add(baja);
        datosPanel.add(modificacion);
        datosPanel.add(consulta);

        mainPanel.add(datosPanel);

        _dataTableModel = new DefaultTableModel();
        _dataTableModel.setColumnIdentifiers(_headers);
        InfoTable tab = new InfoTable("Titulaciones", _dataTableModel);

        mainPanel.add(tab);

        loadData();

        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
        _dataTableModel.setRowCount(0);

        List<Curso> cursos = _titulacion.getCursos();
        Collections.sort(cursos, Comparator.comparingInt(Curso::get_anio));

        String[] row = { _titulacion.getNombre(),
                         String.valueOf(_titulacion.getCursos().size()) };
        _dataTableModel.addRow(row);
    }

    private void crearTitulacion() {
        String nombre = nombreTextField.getText();
        if (!nombre.isEmpty()) {
            try {
                if (_fachadaTitulacionImp.altaTitulacion(nombre)) {
                    loadData();
                    JOptionPane.showMessageDialog(this,
                        "La titulación se ha creado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede estar vacío.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarTitulacion() {
        String nombre = nombreTextField.getText();
        if (!nombre.isEmpty()) {
            try {
                if (_fachadaTitulacionImp.bajaTitulacion(nombre)) {
                    loadData();
                    JOptionPane.showMessageDialog(this,
                        "La titulación se ha eliminado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede estar vacío.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarTitulacion() {
        String nombreAntiguo = _titulacion.getNombre();
        String nombreNuevo = nombreTextField.getText();
        if (!nombreNuevo.isEmpty()) {
            try {
                if (_fachadaTitulacionImp.modificarTitulacion(nombreAntiguo, nombreNuevo)) {
                    loadData();
                    JOptionPane.showMessageDialog(this,
                        "La titulación se ha modificado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "El nombre no puede estar vacío.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultarTitulacion() {
        try {
            Titulacion titulacion = _fachadaTitulacionImp.consultarTitulacion(_titulacion.getNombre());
            if (titulacion != null) {
                new InfoTitulacion(titulacion);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Titulación no encontrada.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
