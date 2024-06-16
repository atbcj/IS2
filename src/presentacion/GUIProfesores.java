package presentacion;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Grupo;
import clases.Profesor;
import logicaNegocio.FachadaProfesoresImp;

public class GUIProfesores extends JFrame {

	private static final long serialVersionUID = 1L;

	private Grupo _grupo;
	private FachadaProfesoresImp _fachadaProfesoresImp;

	private JButton alta;
	private JButton baja;
	private JButton modificacion;

	private DefaultTableModel _dataTableModel;
	private String[] _headers = { "NOMBRE", "APELLIDOS", "DNI", "CORREO" };

	private DefaultComboBoxModel<String> pComboBox;
	private JTable tabla;

	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField dniField;
	private JTextField correoField;

	public GUIProfesores(Grupo grupo) {
		_grupo = grupo;
		_fachadaProfesoresImp = new FachadaProfesoresImp(_grupo);
		initGUI();
	}

	private void initGUI() {

		setTitle("Gestion de Profesores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 500);

		pComboBox = new DefaultComboBoxModel<>();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));
		mainPanel.add(datosPanel);

		datosPanel.add(new JLabel("Nombre"));
		nombreField = new JTextField(10);
		datosPanel.add(nombreField);

		datosPanel.add(new JLabel("Apellidos"));
		apellidosField = new JTextField(10);
		datosPanel.add(apellidosField);

		datosPanel.add(new JLabel("DNI"));
		dniField = new JTextField(10);
		datosPanel.add(dniField);

		datosPanel.add(new JLabel("Correo"));
		correoField = new JTextField(10);
		datosPanel.add(correoField);

		JPanel botonesPanel = new JPanel();
		botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.X_AXIS));
		mainPanel.add(botonesPanel);

		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		tabla = new JTable(_dataTableModel);
		JScrollPane scrollPane = new JScrollPane(tabla);

		alta = new JButton("Alta");
		alta.addActionListener((e) -> altaProfesor());
		botonesPanel.add(alta);

		baja = new JButton("Baja");
		baja.addActionListener((e) -> bajaProfesor());
		botonesPanel.add(baja);

		modificacion = new JButton("Modificacion");
		modificacion.addActionListener((e) -> modificarProfesor());
		botonesPanel.add(modificacion);

		mainPanel.add(scrollPane);

		loadData();

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadData() {

		pComboBox.removeAllElements();

		_dataTableModel.setRowCount(0);

		for (Profesor profesor : _grupo.get_lista_profesores()) {
			pComboBox.addElement(profesor.getNombre());
			String[] row = { profesor.getNombre(), profesor.get_apellidos(), profesor.get_DNI(), profesor.getCorreo() };
			_dataTableModel.addRow(row);
		}
	}

	private void altaProfesor() {
		String[] datos = { nombreField.getText(), apellidosField.getText(), dniField.getText(), correoField.getText() };

		try {
			boolean result = _fachadaProfesoresImp.altaProfesor(datos);
			if (result) {
				JOptionPane.showMessageDialog(this, "Profesor dado de alta correctamente.");
				loadData();
			} else {
				JOptionPane.showMessageDialog(this, "Error al dar de alta el profesor.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void bajaProfesor() {

		int selectedRow = getSelectedRow();

		if (selectedRow != -1) {

			String dni = (String) _dataTableModel.getValueAt(selectedRow, 2);

			try {
				boolean result = _fachadaProfesoresImp.bajaProfesor(dni);

				if (result) {
					JOptionPane.showMessageDialog(this, "Profesor dado de baja correctamente.");
					loadData();
					_dataTableModel.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(this, "Error al dar de baja el profesor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione un profesor para dar de baja.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void modificarProfesor() {

		int selectedRow = getSelectedRow();

		if (selectedRow != -1) {

			String[] datos = { nombreField.getText(), apellidosField.getText(), dniField.getText(),
					correoField.getText() };

			try {
				boolean result = _fachadaProfesoresImp.modificarProfesor(datos);
				if (result) {
					JOptionPane.showMessageDialog(this, "Profesor modificado correctamente.");
					loadData();
				} else {
					JOptionPane.showMessageDialog(this, "Error al modificar el profesor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione un profesor para modificar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private int getSelectedRow() {
		return tabla.getSelectedRow();
	}
}
