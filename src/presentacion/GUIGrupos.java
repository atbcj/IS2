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
import clases.Grupo;
import logicaNegocio.FachadaGruposImp;

@SuppressWarnings("serial")
public class GUIGrupos extends JFrame{
	
	FachadaGruposImp _fachadGruposImp;
	
	Asignatura _asignatura;
	private DefaultTableModel _dataTableModel;
	

	private String[] _headers = { "Grupo", "#Alumnos", "#Profesores" };
	
	private DefaultComboBoxModel<String> gruposComboBox;
	private JTextField nombreTextField;
	
	public GUIGrupos(Asignatura asignatura) {
		_asignatura = asignatura;
		_fachadGruposImp = new FachadaGruposImp(_asignatura);
		initGUI();
	}

	private void initGUI() {
		setTitle("Gestion de Grupos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));
		
		gruposComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> cg = new JComboBox<String>(gruposComboBox);
		
		datosPanel.add(new JLabel("Grupos: "));
		datosPanel.add(cg);

		nombreTextField = new JTextField();
		
		datosPanel.add( new JLabel("Nombre: "));
		datosPanel.add(nombreTextField);
		
		JButton alta = new JButton("Crear");
		alta.addActionListener((e) -> crearGrupo());
		JButton baja = new JButton("Eliminar");
		baja.addActionListener((e) -> eliminarGrupo());
		JButton modificacion = new JButton("Modificar");
		modificacion.addActionListener((e) -> modificarGrupo());
		JButton consulta = new JButton("Consultar");
		consulta.addActionListener((e) -> new InfoGrupo(_fachadGruposImp.consultarGrupo(gruposComboBox.getSelectedItem().toString().charAt(0))));
		
		datosPanel.add(alta);
		datosPanel.add(baja);
		datosPanel.add(modificacion);
		datosPanel.add(consulta);
		
		mainPanel.add(datosPanel);
		
		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		InfoTable tab = new InfoTable("Grupos", _dataTableModel);
		
		mainPanel.add(tab);
		
		loadData();
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void loadData() {
		gruposComboBox.removeAllElements();
		_dataTableModel.setRowCount(0);
		for(Grupo g: _asignatura.getGrupos()) {
			gruposComboBox.addElement(String.valueOf(g.get_nombre()));
			String[] row = {String.valueOf(g.get_nombre()), String.valueOf(g.get_lista_alumnos().size()), String.valueOf(g.get_lista_profesores().size())};
			_dataTableModel.addRow(row);
		}
	}
	
	private void crearGrupo() {
		String nombre = nombreTextField.getText();
		if(!nombre.isEmpty()) {
			try {
				if(_fachadGruposImp.altaGrupo(nombre.charAt(0))) {
					loadData();
					JOptionPane.showMessageDialog(null, "El grupo se ha registrado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al crear el grupo.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void eliminarGrupo() {
		String nombre = nombreTextField.getText();
		if(!nombre.isEmpty()) {
			try {
				if(_fachadGruposImp.bajaGrupo(nombre.charAt(0))) {
					loadData();
					JOptionPane.showMessageDialog(null, "El grupo se ha eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al eliminar el grupo.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void modificarGrupo() {
		String nombre = nombreTextField.getText();
		if(!nombre.isEmpty()) {
			try {
				if(_fachadGruposImp.modificarGrupo(gruposComboBox.getSelectedItem().toString().charAt(0) , nombre.charAt(0))) {
					loadData();
					JOptionPane.showMessageDialog(null, "El grupo se ha eliminado correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Error al modificar el grupo.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
