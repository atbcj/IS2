package presentacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Grupo;
import logicaNegocio.FachadaAlumnosImp;
import logicaNegocio.FachadaGruposImp;
import logicaNegocio.IFachadaAlumnos;

public class GUIAlumnos {

	private Grupo _grupo;
	IFachadaAlumnos _fachadaAlumnos;
	
	private DefaultTableModel _dataTableModel;
	

	private String[] _headers = { "Nombre", "#Apellido", "#Correo" };
	
	private DefaultComboBoxModel<String> alumnosComboBox;
	private JTextField nombreTextField;
	
	public GUIAlumnos(Grupo grupo) {
		_grupo = grupo;
		_fachadaAlumnos = new FachadaAlumnosImp();
		initGUI();
	}

	private void initGUI() {
		
	}

}
