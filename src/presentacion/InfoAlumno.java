package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InfoAlumno extends JFrame{
	
	private String _nombre;
	private String _apellidos;
	private String _dni;
	private String _correo;
	private JButton _saveButton;
	
	public InfoAlumno(String dni) {
		_dni = dni;
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
		buttonPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.Y_AXIS));
		
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
	}
	
	public String[] getInfo() {
		String[] info = {_nombre,_apellidos,_dni,_correo};
		return info;
	}
}
