package presentacion;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Alumno;
import clases.Grupo;
import logicaNegocio.FachadaAlumnosImp;
import logicaNegocio.FachadaGruposImp;
import logicaNegocio.IFachadaAlumnos;

@SuppressWarnings("serial")
public class GUIAlumnos extends JFrame{

	private Grupo _grupo;
	IFachadaAlumnos _fachadaAlumnos;
	
	private DefaultTableModel _dataTableModel;
	

	private String[] _headers = {"DNI" ,"Nombre", "Apellido", "Correo" };
	
	private DefaultComboBoxModel<String> alumnosComboBox;
	private JTextField dniTextField;
	
	public GUIAlumnos(Grupo grupo) {
		_grupo = grupo;
		_fachadaAlumnos = new FachadaAlumnosImp(grupo);
		initGUI();
	}

	private void initGUI() {
		setTitle("Gestion de Alumnos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));
		
		alumnosComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> ca = new JComboBox<String>(alumnosComboBox);
		
		datosPanel.add(new JLabel("Alumnos: "));
		datosPanel.add(ca);
		
		dniTextField = new JTextField();
		
		datosPanel.add( new JLabel("DNI: "));
		datosPanel.add(dniTextField);
		
		JButton alta = new JButton("Crear");
		alta.addActionListener((e) -> crearAlumno());
		JButton baja = new JButton("Eliminar");
		baja.addActionListener((e) -> eliminarAlumno());
		JButton modificacion = new JButton("Modificar");
		modificacion.addActionListener((e) -> modificarAlumno());
		JButton consulta = new JButton("Consultar");
		consulta.addActionListener((e) -> consultarAlumno(alumnosComboBox.getSelectedItem().toString()));
		
		datosPanel.add(alta);
		datosPanel.add(baja);
		datosPanel.add(modificacion);
		datosPanel.add(consulta);
		
		mainPanel.add(datosPanel);
		
		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		InfoTable tab = new InfoTable("Alumnos", _dataTableModel);
		mainPanel.add(tab);
		
		loadData();
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadData() {
		alumnosComboBox.removeAllElements();
		_dataTableModel.setRowCount(0);
		for(Alumno a: _grupo.get_lista_alumnos()) {
			alumnosComboBox.addElement(String.valueOf(a.getNombre()));
			String[] row = {String.valueOf(a.get_DNI()),String.valueOf(a.getNombre()), String.valueOf(a.get_apellidos()), String.valueOf(a.getCorreo())};
			_dataTableModel.addRow(row);
		}
	}

	private void consultarAlumno(String selectedItem) {
		
	}

	private void modificarAlumno() {
		String nombre = dniTextField.getText();
		if(!nombre.isEmpty()) {
			try {
				if(_fachadaAlumnos.modificarAlumno(alumnosComboBox.getSelectedItem().toString())) {
					loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al modificar el alumno.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void eliminarAlumno() {
		String nombre = dniTextField.getText();
		if(!nombre.isEmpty()) {
			try {
				if(_fachadaAlumnos.bajaAlumno(nombre)) {
					loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al eliminar el alumno.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void crearAlumno() {
		String dni = dniTextField.getText();
		
		if(!dni.isEmpty()) {
			InfoAlumno al = new InfoAlumno(dni);
			try {
				if(_fachadaAlumnos.altaAlumno(al)) {
					loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha registrado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al crear el alumno.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
