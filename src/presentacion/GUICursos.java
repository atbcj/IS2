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
        datosPanel.add(new JLabel("Año del Curso: "));
        datosPanel.add(anioTextField);
        
        JButton alta = new JButton("Crear");
        alta.addActionListener((e) -> crearCurso());
        JButton baja = new JButton("Eliminar");
        baja.addActionListener((e) -> eliminarCurso());
        JButton modificacion = new JButton("Modificar");
        modificacion.addActionListener((e) -> modificarCurso());
        
        datosPanel.add(alta);
        datosPanel.add(baja);
        datosPanel.add(modificacion);
        
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
            String[] row = {String.valueOf(curso.get_anio()), String.valueOf(curso.get_lista_asignaturas().size())};
			_dataTableModel.addRow(row);
        }
    }

    private void crearCurso() {
        // Implementar la lógica para crear un curso
    }

    private void eliminarCurso() {
        // Implementar la lógica para eliminar un curso
    }

    private void modificarCurso() {
        // Implementar la lógica para modificar un curso
    }
}
