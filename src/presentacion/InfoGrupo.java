package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import clases.Alumno;
import clases.Grupo;
import clases.Profesor;

@SuppressWarnings("serial")
public class InfoGrupo extends JFrame{
	
	private Grupo _grupo;
	private String[] _headers = {"DNI", "Nombre", "Apellidos", "Correo" };
	
	public InfoGrupo(Grupo grupo) {
		_grupo = grupo;
		initGUI();
	}

	private void initGUI() {
		setTitle("Grupo "+_grupo.get_nombre());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		DefaultTableModel tablaAlumnos = new DefaultTableModel();
		tablaAlumnos.setColumnIdentifiers(_headers);
		for(Alumno a: _grupo.get_lista_alumnos()) {
			String[] row = {a.get_DNI(), a.getNombre(), a.get_apellidos(), a.getCorreo()};
			tablaAlumnos.addRow(row);
		}
		InfoTable tablaA = new InfoTable("Alumnos", tablaAlumnos);
		
		DefaultTableModel tablaProfesores = new DefaultTableModel();
		tablaProfesores.setColumnIdentifiers(_headers);
		for(Profesor a: _grupo.get_lista_profesores()) {
			String[] row = {a.get_DNI(), a.getNombre(), a.get_apellidos(), a.getCorreo()};
			tablaProfesores.addRow(row);
		}
		InfoTable tablaP = new InfoTable("Profesores", tablaProfesores);
		
		mainPanel.add(tablaA);
		mainPanel.add(tablaP);
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
