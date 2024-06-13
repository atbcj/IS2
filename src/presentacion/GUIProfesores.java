package presentacion;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

	public GUIProfesores(Grupo grupo) {
		_grupo = grupo;
		_fachadaProfesoresImp = new FachadaProfesoresImp(_grupo);
		initGUI();
	}

	private void initGUI() {
		
		setTitle("Gestion de Profesores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);

		pComboBox = new DefaultComboBoxModel<String>();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel datosPanel = new JPanel();
		datosPanel.setLayout(new BoxLayout(datosPanel, BoxLayout.X_AXIS));
		mainPanel.add(datosPanel);

		JPanel botonesPanel = new JPanel();
		botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.X_AXIS));
		mainPanel.add(botonesPanel);

		_dataTableModel = new DefaultTableModel();
		_dataTableModel.setColumnIdentifiers(_headers);
		InfoTable tabla = new InfoTable("Profesores", _dataTableModel);

		alta = new JButton("Alta");
		alta.addActionListener((e)-> altaProfesor());
		botonesPanel.add(alta);
		
		baja = new JButton("Baja");
		baja.addActionListener((e)-> bajaProfesor());
		botonesPanel.add(baja);
		
		modificacion = new JButton("Modificacion");
		modificacion.addActionListener((e)-> modificarProfesor());
		botonesPanel.add(modificacion);
		

		mainPanel.add(tabla);

		loadData();

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void loadData() {
		pComboBox.removeAllElements();
		_dataTableModel.setRowCount(0);
		
		for (Profesor profesor : _grupo.get_lista_profesores()) {
			
			pComboBox.addElement(String.valueOf(profesor.getNombre()));
			
			String[] row = {profesor.getNombre(), profesor.get_apellidos(), profesor.get_DNI(), profesor.getCorreo() };
			_dataTableModel.addRow(row);
		}
	}

	private void altaProfesor() {

	}

	private void bajaProfesor() {

	}

	private void modificarProfesor() {

	}
}
