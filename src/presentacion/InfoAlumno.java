package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Alumno;
import logicaNegocio.IFachadaAlumnos;

@SuppressWarnings("serial")
public class InfoAlumno extends JFrame{
	
	private String _nombre;
	private String _apellidos;
	private String _dni;
	private String _correo;
	private JTextField _nombreTextField;
	private JTextField _apellidosTextField;
	private JTextField _correoTextField;
	private JButton _saveButton;
	private JButton _backButton;
	private GUIAlumnos _gui;
	private IFachadaAlumnos _fach;
	private boolean _alta;

	
	public InfoAlumno(String dni, GUIAlumnos al, IFachadaAlumnos fach, boolean alta) {
		_dni = dni;
		_fach = fach;
		_gui = al;
		_alta = alta;
		initGUI();
	}
	
	public InfoAlumno(Alumno a, GUIAlumnos al, IFachadaAlumnos fach, boolean alta) {
		_dni = a.get_DNI();
		_nombre = a.getNombre();
		_apellidos = a.get_apellidos();
		_correo = a.getCorreo();
		_fach = fach;
		_gui = al;
		_alta = alta;
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
		
		datosPanel.add( new JLabel("Nombre: "));
		_nombreTextField = new JTextField();
		datosPanel.add(_nombreTextField);
		
		datosPanel.add( new JLabel("Apellido: "));
		_apellidosTextField = new JTextField();
		datosPanel.add(_apellidosTextField);
		
		datosPanel.add( new JLabel("Correo: "));
		_correoTextField = new JTextField();
		datosPanel.add(_correoTextField);
		
		if(!_alta) {
			_nombreTextField.setText(_nombre);
			_apellidosTextField.setText(_apellidos);
			_correoTextField.setText(_correo);
		}
		
		mainPanel.add(datosPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		_saveButton = new JButton("Save");
		_saveButton.addActionListener((e) -> saveAction(_nombreTextField.getText(),_apellidosTextField.getText(),_correoTextField.getText(),_alta));
		buttonPanel.add(_saveButton);
		
		_backButton = new JButton("Back");
		_backButton.addActionListener((e) -> setVisible(false));
		buttonPanel.add(_backButton);
		
		mainPanel.add(buttonPanel);
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void saveAction(String nombre, String apellidos, String correo, boolean alta) {
		_nombre = nombre;
		_apellidos = apellidos;
		_correo = correo;
		try {
			if(alta) {
				if(_fach.altaAlumno(getInfo())) {
				_gui.loadData();
				JOptionPane.showMessageDialog(null, "El alumno se ha registrado correctamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				if(_fach.modificarAlumno(getInfo())) {
					_gui.loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha modificado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Error al crear el alumno.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}
	
	public String[] getInfo() {
		String[] info = {_nombre,_apellidos,_dni,_correo};
		return info;
	}
}
