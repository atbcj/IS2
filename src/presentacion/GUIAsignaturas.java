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

import clases.Asignatura;
import clases.Curso;
import logicaNegocio.FachadaAsignaturasImp;

public class GUIAsignaturas extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FachadaAsignaturasImp _fachadaAsignaturasImp;

	Curso _curso;
	private DefaultTableModel _dataTableModel;

	private String[] _headers = { "Nombre", "#Grupos"};

	private DefaultComboBoxModel<String> asignaturasComboBox;
	private JTextField nombreTextField;
	private JTextField codigoTextField;
	private JTextField creditosTextField;

	public GUIAsignaturas(Curso curso) {
		_curso = curso;
		_fachadaAsignaturasImp = new FachadaAsignaturasImp(_curso);
		initGUI();
	}

	private void initGUI() {
		setTitle("Gestion de Asignaturas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));

		asignaturasComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> cg = new JComboBox<String>(asignaturasComboBox);

		datosPanel.add(new JLabel("Asignaturas: "));
		datosPanel.add(cg);

		nombreTextField = new JTextField();
		creditosTextField = new JTextField();
		codigoTextField = new JTextField();

		datosPanel.add(new JLabel("Nombre: "));
		datosPanel.add(nombreTextField);
		datosPanel.add(new JLabel("Creditos: "));
		datosPanel.add(creditosTextField);
		datosPanel.add(new JLabel ("Codigo: "));
		datosPanel.add(codigoTextField);
		

		mainPanel.add(datosPanel);

		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		InfoTable tab = new InfoTable("Asignaturas", _dataTableModel);

		mainPanel.add(tab);

		JPanel botonesPanel = new JPanel();
		botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.X_AXIS));

		JButton alta = new JButton("Crear");
		alta.addActionListener((e) -> crearAsignatura());
		JButton baja = new JButton("Eliminar");
		baja.addActionListener((e) -> eliminarAsignatura());
		JButton modificacion = new JButton("Modificar");
		modificacion.addActionListener((e) -> modificarAsignatura());
		JButton consulta = new JButton("Consultar");
		consulta.addActionListener((e) -> {
			Asignatura a = _curso.getAsignatura(asignaturasComboBox.getSelectedItem().toString());
			System.out.println(_fachadaAsignaturasImp.consultarAsignatura(asignaturasComboBox.getSelectedItem().toString()));
			new InfoAsignatura(_fachadaAsignaturasImp.consultarAsignatura(a.getCodigo()));
				// TODO Auto-generated catch block

		});

		botonesPanel.add(alta);
		botonesPanel.add(baja);
		botonesPanel.add(modificacion);
		botonesPanel.add(consulta);

		mainPanel.add(botonesPanel);

		loadData();

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadData() {
		asignaturasComboBox.removeAllElements();
		_dataTableModel.setRowCount(0);
		for (Asignatura a  : _curso.get_lista_asignaturas()) {
			asignaturasComboBox.addElement(String.valueOf(a.getNombre()));
			String[] row = { String.valueOf(a.getNombre()), String.valueOf(a.getGrupos().size())};
			_dataTableModel.addRow(row);
		}
	}

	private void crearAsignatura() {
	    String nombre = nombreTextField.getText();
	    String creditosText = creditosTextField.getText();
	    String codigo = codigoTextField.getText();

	    if (!nombre.isEmpty() && !creditosText.isEmpty() && !codigo.isEmpty()) {
	        try {
	            int creditos = Integer.parseInt(creditosText);
	            
	            if (_fachadaAsignaturasImp.altaAsignatura(nombre, creditos, codigo)) {
	                loadData();
	                JOptionPane.showMessageDialog(null, "La asignatura se ha registrado correctamente.", "Éxito",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "El campo de créditos debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            JOptionPane.showMessageDialog(null, "Error al crear la asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void eliminarAsignatura() {
		String selected = asignaturasComboBox.getSelectedItem().toString();
	    Asignatura asignatura = _curso.getAsignatura(selected);
	    
		if (!asignatura.getCodigo().isEmpty()) {
			try {
				if (_fachadaAsignaturasImp.bajaAsignatura(asignatura.getCodigo())) {
					loadData();
					JOptionPane.showMessageDialog(null, "La asignatura se ha eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al eliminar la asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void modificarAsignatura() {
	    String selected = asignaturasComboBox.getSelectedItem().toString();
	    Asignatura asignatura = _curso.getAsignatura(selected);
	    String antiguoCodigo = asignatura.getCodigo();
	    String antiguoNombre = asignatura.getNombre();

	    String nombre = null, codigo = null;
	    int creditos = -1;
	    boolean modificado = false;

	    if (!nombreTextField.getText().isEmpty()) {
	        nombre = nombreTextField.getText();
	        if (!_curso.getAsignatura(nombre).equals(asignatura)) {
	            JOptionPane.showMessageDialog(null, "El nombre de la asignatura ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        modificado = true;
	    }
	    if (!creditosTextField.getText().isEmpty()) {
	        String creditosText = creditosTextField.getText();
	        try {
	            creditos = Integer.parseInt(creditosText);
	            modificado = true;
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "El campo de créditos debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    }
	    if (!codigoTextField.getText().isEmpty()) {
	        codigo = codigoTextField.getText();
	        if (!_curso.getAsignaturaCodigo(codigo).equals(asignatura)) {
	            JOptionPane.showMessageDialog(null, "El código de la asignatura ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        modificado = true;
	    }

	    if (modificado) {
	        try {
	            if (_fachadaAsignaturasImp.modificarAsignatura(antiguoCodigo, codigo, nombre, creditos)) {
	                loadData();
	                JOptionPane.showMessageDialog(null, "La asignatura se ha modificado correctamente.", "Éxito",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            JOptionPane.showMessageDialog(null, "Error al modificar la asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "No se han realizado cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
	    }
	}


	/*private void modificarAsignatura() {
	    String nombre = nombreTextField.getText();
	    String creditosText = creditosTextField.getText();
	    String codigo = codigoTextField.getText();
	    
	    if (!nombre.isEmpty() && !creditosText.isEmpty() && !codigo.isEmpty()) {
	        try {
	            int creditos = Integer.parseInt(creditosText);
	            
	            if (_fachadaAsignaturasImp.modificarAsignatura(asignaturasComboBox.getSelectedItem().toString(),
	                    codigo, nombre, creditos)) {
	                loadData();
	                JOptionPane.showMessageDialog(null, "La asignatura se ha modificado correctamente.", "Éxito",
	                        JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "El campo de créditos debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            JOptionPane.showMessageDialog(null, "Error al modificar la asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}*/

}
