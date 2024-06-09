package presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import clases.Curso;
import clases.Titulacion;
import logicaNegocio.FachadaCursosImp;

@SuppressWarnings("serial")
public class GUICursos extends JFrame {

	private FachadaCursosImp _fachadaCursosImp;
	private Titulacion _titulacion;

	private DefaultTableModel _dataTableModel;
	private String[] _headers = { "Cursos", "Num. Asignaturas" };
	private DefaultComboBoxModel<String> aniosComboBox;
	private JTextField anioTextField;

	public GUICursos(Titulacion titulacion) {
		_titulacion = titulacion;
		_fachadaCursosImp = new FachadaCursosImp(_titulacion);
		initGUI();
	}

	private void initGUI() {
		setTitle("Gestion de Cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));

		aniosComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> ca = new JComboBox<>(aniosComboBox);

		anioTextField = new JTextField();

		datosPanel.add(new JLabel("Año: "));
		datosPanel.add(ca);
		datosPanel.add(new JLabel("Año Curso: "));
		datosPanel.add(anioTextField);

		JButton alta = new JButton("Crear");
		alta.addActionListener((e) -> crearCurso());
		JButton baja = new JButton("Eliminar");
		baja.addActionListener((e) -> eliminarCurso());
		JButton modificacion = new JButton("Modificar");
		modificacion.addActionListener((e) -> modificarCurso());
		JButton consulta = new JButton("Consultar");
		consulta.addActionListener((e) -> consultarCurso());

		datosPanel.add(alta);
		datosPanel.add(baja);
		datosPanel.add(modificacion);
		datosPanel.add(consulta);

		mainPanel.add(datosPanel);

		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		InfoTable tab = new InfoTable("Cursos", _dataTableModel);

		mainPanel.add(tab);

		loadData();

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadData() {
		aniosComboBox.removeAllElements();
		_dataTableModel.setRowCount(0);
		for (Curso curso : _titulacion.getCursos()) {
			aniosComboBox.addElement(String.valueOf(curso.get_anio()));
			String[] row = { String.valueOf(curso.get_anio()),
					String.valueOf(curso.get_lista_asignaturas().size()) };
			_dataTableModel.addRow(row);
		}
	}

	private void crearCurso() {
		String anioStr = anioTextField.getText();
        if (!anioStr.isEmpty()) {
            try {
                int anio = Integer.parseInt(anioStr);
                if (_fachadaCursosImp.altaCurso(anio)) {
                    loadData();
                    JOptionPane.showMessageDialog(this, 
                    		"El curso se ha creado correctamente.", 
                    		"Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                		"El año debe ser un número.",
                		"Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                		"Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
            		"El año no puede estar vacío.",
            		"Error", JOptionPane.ERROR_MESSAGE);
        }
	}

    private void eliminarCurso() {
        String anioStr = anioTextField.getText();
        if (!anioStr.isEmpty()) {
            try {
                int anio = Integer.parseInt(anioStr);
                if (_fachadaCursosImp.bajaCurso(anio)) {
                    loadData();
                    JOptionPane.showMessageDialog(this, 
                            "El curso se ha eliminado correctamente.", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                        "El año debe ser un número.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "El año no puede estar vacío.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	private void modificarCurso() {

	}
	
	private void consultarCurso() {
		
	}
}
