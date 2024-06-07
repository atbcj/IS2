package presentacion;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Asignatura;
import clases.Curso;
import clases.Titulacion;

@SuppressWarnings("serial")
public class SeleccionAsignaturas extends JFrame{
	
	Controller _ctrl;
	
	private DefaultComboBoxModel<String> titulacionComboBox;
	private DefaultComboBoxModel<String> cursosComboBox;
	
	Titulacion _tit;
	Curso _curso;

	public SeleccionAsignaturas(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		setTitle("Seleccion de Asignaturas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 150);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		titulacionComboBox = new DefaultComboBoxModel<>();
		for(Titulacion t: _ctrl.getTitulaciones())
			titulacionComboBox.addElement(t.getNombre());
		JComboBox<String> ct = new JComboBox<String>(titulacionComboBox);
		ct.addActionListener((e) -> actualizarTitulacion((String) ct.getSelectedItem()));
		
		cursosComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> cc = new JComboBox<String>(cursosComboBox);
		cc.addActionListener((e) -> actualizarCursos((String) cc.getSelectedItem()));
		
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(new JLabel("Titulaciones"));
		comboBoxPanel.add(ct);
		comboBoxPanel.add(new JLabel("Cursos"));
		comboBoxPanel.add(cc);
		
		mainPanel.add(comboBoxPanel);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JPanel savePanel = new JPanel();
		savePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton save = new JButton("Guardar");
		save.addActionListener((e) -> {new GUIAsignaturas(_curso); setVisible(false);});
		savePanel.add(save);
		
		mainPanel.add(savePanel);
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void actualizarTitulacion(String nombre) {
		_tit = _ctrl.getTitulacion(nombre);
		cursosComboBox.removeAllElements();
		for(Curso c: _tit.getCursos())
			cursosComboBox.addElement(String.valueOf(c.get_anio()));
	}
	
	private void actualizarCursos(String nombre) {
		_curso = _tit.getCurso(nombre);
	}
	
	
}
