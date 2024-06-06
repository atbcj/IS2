package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logicaNegocio.IFachadaAlumnos;

@SuppressWarnings("serial")
public class InfoAlumno extends JFrame{
	
	private String _nombre;
	private String _apellidos;
	private String _dni;
	private String _correo;
	private JButton _saveButton;
	private GUIAlumnos _gui;
	private IFachadaAlumnos _fach;

	
	public InfoAlumno(String dni, GUIAlumnos al, IFachadaAlumnos fach) {
		_dni = dni;
		_fach = fach;
		_gui = al;
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
		JTextField nombre = new JTextField();
		datosPanel.add(nombre);
		
		datosPanel.add( new JLabel("Apellido: "));
		JTextField apellidos = new JTextField();
		datosPanel.add(apellidos);
		
		datosPanel.add( new JLabel("Correo: "));
		JTextField correo = new JTextField();
		datosPanel.add(correo);
		
		mainPanel.add(datosPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		_saveButton = new JButton("Save");
		_saveButton.addActionListener((e) -> saveAction(nombre.getText(),apellidos.getText(),correo.getText()));
		buttonPanel.add(_saveButton);
		
		mainPanel.add(buttonPanel);
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void saveAction(String nombre, String apellidos, String correo) {
		_nombre = nombre;
		_apellidos = apellidos;
		_correo = correo;
		try {
			if(_fach.altaAlumno(getInfo())) {
				_gui.loadData();
				JOptionPane.showMessageDialog(null, "El alumno se ha registrado correctamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
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
