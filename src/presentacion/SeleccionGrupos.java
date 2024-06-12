package presentacion;

import java.awt.Dimension;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Asignatura;
import clases.Curso;
import clases.Titulacion;

@SuppressWarnings("serial")
public class SeleccionGrupos extends JFrame {

	Controller _ctrl;

	private DefaultComboBoxModel<String> titulacionComboBox;
	private DefaultComboBoxModel<String> cursosComboBox;
	private DefaultComboBoxModel<String> asignaturasComboBox;

	Titulacion _tit;
	Curso _curso;
	Asignatura _asignatura;

	public SeleccionGrupos(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		setTitle("Seleccion de Grupos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 150);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		titulacionComboBox = new DefaultComboBoxModel<>();
		for (Titulacion t : _ctrl.getTitulaciones())
			titulacionComboBox.addElement(t.getNombre());
		JComboBox<String> ct = new JComboBox<String>(titulacionComboBox);
		ct.addActionListener((e) -> actualizarTitulacion((String) ct.getSelectedItem()));

		cursosComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> cc = new JComboBox<String>(cursosComboBox);
		cc.addActionListener((e) -> actualizarCursos((String) cc.getSelectedItem()));

		asignaturasComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> ca = new JComboBox<String>(asignaturasComboBox);
		ca.addActionListener((e) -> actualizarAsignaturas((String) ca.getSelectedItem()));

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(new JLabel("Titulaciones"));
		comboBoxPanel.add(ct);
		comboBoxPanel.add(new JLabel("Cursos"));
		comboBoxPanel.add(cc);
		comboBoxPanel.add(new JLabel("Asignaturas"));
		comboBoxPanel.add(ca);

		mainPanel.add(comboBoxPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel savePanel = new JPanel();
		savePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton save = new JButton("Guardar");
		save.addActionListener((e) -> {
			if (_asignatura == null) {
				JOptionPane.showMessageDialog(this, "Por favor, seleccione una titulación, curso y asignatura.",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new GUIGrupos(_asignatura);
				setVisible(false);
			}
		});
		savePanel.add(save);

		mainPanel.add(savePanel);

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void actualizarTitulacion(String nombre) {
		_tit = _ctrl.getTitulacion(nombre);
		cursosComboBox.removeAllElements();
		//Para ordenar los anios
		List<Curso> cursos = _tit.getCursos();
        Collections.sort(cursos, Comparator.comparingInt(Curso::get_anio));
		
		for (Curso c : _tit.getCursos())
			cursosComboBox.addElement(String.valueOf(c.get_anio()));
	}

	private void actualizarCursos(String nombre) {
		_curso = _tit.getCurso(nombre);
		asignaturasComboBox.removeAllElements();
		for (Asignatura a : _curso.get_lista_asignaturas())
			asignaturasComboBox.addElement(a.getNombre());
	}

	private void actualizarAsignaturas(String nombre) {
		_asignatura = _curso.getAsignatura(nombre);
	}

}
