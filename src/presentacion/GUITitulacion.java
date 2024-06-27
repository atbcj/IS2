package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import clases.Titulacion;
import logicaNegocio.FachadaTitulacionImp;

@SuppressWarnings("serial")
public class GUITitulacion extends JFrame {

    private FachadaTitulacionImp _fachadaTitulacionImp;
    private Controller _ctrl;
    
    private DefaultComboBoxModel<String> titComboBox;
    private DefaultTableModel _dataTableModel;
    private String[] _headers = { "Titulaciones", "Num. Cursos" };
    private JTextField nombreTextField;

    public GUITitulacion(Controller control) {

        _fachadaTitulacionImp = new FachadaTitulacionImp(control);
        _ctrl = control;
        initGUI();
    }

    private void initGUI() {
        setTitle("Gestión de Titulaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400); // Aumentamos el tamaño de la ventana
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel datosPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        titComboBox = new DefaultComboBoxModel<>();
        JComboBox<String> ct = new JComboBox<>(titComboBox);
        ct.setPreferredSize(new Dimension(200, 25));
        
        datosPanel.add(new JLabel("Titulaciones: "), gbc);
        gbc.gridx++;
        datosPanel.add(ct, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        datosPanel.add(new JLabel("Nombre: "), gbc);
        gbc.gridx++;
        nombreTextField = new JTextField(20);
        datosPanel.add(nombreTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttonPanel = new JPanel();
        JButton alta = new JButton("Crear");
        alta.setPreferredSize(new Dimension(100, 30));
        alta.addActionListener((e) -> crearTitulacion());
        JButton baja = new JButton("Eliminar");
        baja.setPreferredSize(new Dimension(100, 30));
        baja.addActionListener((e) -> eliminarTitulacion());
        JButton modificacion = new JButton("Modificar");
        modificacion.setPreferredSize(new Dimension(100, 30));
        modificacion.addActionListener((e) -> modificarTitulacion());
        JButton consulta = new JButton("Consultar");
        consulta.setPreferredSize(new Dimension(100, 30));
        consulta.addActionListener((e) -> consultarTitulacion());

        buttonPanel.add(alta);
        buttonPanel.add(baja);
        buttonPanel.add(modificacion);
        buttonPanel.add(consulta);

        datosPanel.add(buttonPanel, gbc);

        mainPanel.add(datosPanel, BorderLayout.NORTH);

        _dataTableModel = new DefaultTableModel();
        _dataTableModel.setColumnIdentifiers(_headers);
        InfoTable tab = new InfoTable("Titulaciones", _dataTableModel);
        JScrollPane scrollPane = new JScrollPane(tab);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        loadData();

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadData() {
    	titComboBox.removeAllElements();
        _dataTableModel.setRowCount(0);
        for (Titulacion t : _ctrl.getTitulaciones()) {
        	titComboBox.addElement(String.valueOf(t.getNombre()));
        	 String[] row = { t.getNombre(),
                         String.valueOf(t.getCursos().size()) };
        	 _dataTableModel.addRow(row);
        }
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
        String nombreAntiguo = titComboBox.getSelectedItem().toString();
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
            Titulacion titulacion = _fachadaTitulacionImp.consultarTitulacion(titComboBox.getSelectedItem().toString());
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
