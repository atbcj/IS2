package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
public class InfoAlumno extends JFrame {

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
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Nombre: "), gbc);
        
        gbc.gridx = 1;
        _nombreTextField = new JTextField(20);
        mainPanel.add(_nombreTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Apellido: "), gbc);

        gbc.gridx = 1;
        _apellidosTextField = new JTextField(20);
        mainPanel.add(_apellidosTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Correo: "), gbc);

        gbc.gridx = 1;
        _correoTextField = new JTextField(20);
        mainPanel.add(_correoTextField, gbc);

        if (!_alta) {
            _nombreTextField.setText(_nombre);
            _apellidosTextField.setText(_apellidos);
            _correoTextField.setText(_correo);
        }

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        _saveButton = new JButton("Save");
        _saveButton.setPreferredSize(new Dimension(100, 30));
        _saveButton.addActionListener((e) -> saveAction(_nombreTextField.getText(), _apellidosTextField.getText(),
                _correoTextField.getText(), _alta));
        buttonPanel.add(_saveButton);

        _backButton = new JButton("Back");
        _backButton.setPreferredSize(new Dimension(100, 30));
        _backButton.addActionListener((e) -> setVisible(false));
        buttonPanel.add(_backButton);

        mainPanel.add(buttonPanel, gbc);

        add(mainPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	private void saveAction(String nombre, String apellidos, String correo, boolean alta) {
		_nombre = nombre;
		_apellidos = apellidos;
		_correo = correo;
		try {
			if (alta) {
				if (_fach.altaAlumno(getInfo())) {
					_gui.loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha registrado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				if (_fach.modificarAlumno(getInfo())) {
					_gui.loadData();
					JOptionPane.showMessageDialog(null, "El alumno se ha modificado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Error al crear el alumno.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}

	public String[] getInfo() {
		String[] info = { _nombre, _apellidos, _dni, _correo };
		return info;
	}
}
