package presentacion;

import java.awt.Dimension;

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
import clases.Grupo;
import clases.Titulacion;

@SuppressWarnings("serial")
public class SeleccionAlumnos extends JFrame {

	private Controller _ctrl;

	private DefaultComboBoxModel<String> titulacionComboBox;
	private DefaultComboBoxModel<String> cursosComboBox;
	private DefaultComboBoxModel<String> asignaturasComboBox;
	private DefaultComboBoxModel<String> gruposComboBox;

	Titulacion _tit;
	Curso _curso;
	Asignatura _asignatura;
	Grupo _grupo;

	public SeleccionAlumnos(Controller control) {
		_ctrl = control;
		initGUI();
	}

	private void initGUI() {
		setTitle("Seleccion de Alumnos");
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

		gruposComboBox = new DefaultComboBoxModel<>();
		JComboBox<String> cg = new JComboBox<String>(gruposComboBox);
		cg.addActionListener((e) -> actualizarGrupos((String) cg.getSelectedItem()));

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(new JLabel("Titulaciones"));
		comboBoxPanel.add(ct);
		comboBoxPanel.add(new JLabel("Cursos"));
		comboBoxPanel.add(cc);
		comboBoxPanel.add(new JLabel("Asignaturas"));
		comboBoxPanel.add(ca);
		comboBoxPanel.add(new JLabel("Grupos"));
		comboBoxPanel.add(cg);

		mainPanel.add(comboBoxPanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel savePanel = new JPanel();
		savePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton save = new JButton("Guardar");
		save.addActionListener((e) -> {
			if (_grupo == null) {
				JOptionPane.showMessageDialog(this, "Por favor, seleccione una titulación, curso, asignatura y grupo.",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new GUIAlumnos(_grupo);
			}
		});
		savePanel.add(save);
		JButton back = new JButton("Back");
		back.addActionListener((e) -> setVisible(false));
		savePanel.add(back);

		mainPanel.add(savePanel);

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void actualizarGrupos(String nombre) {
		if (_asignatura != null) {
			_grupo = _asignatura.getGrupo(nombre);
		}
	}

	private void actualizarAsignaturas(String nombre) {
		if (_curso != null) {
			_asignatura = _curso.getAsignatura(nombre);
			gruposComboBox.removeAllElements();
			for (Grupo g : _asignatura.getGrupos()) {
				gruposComboBox.addElement(String.valueOf(g.get_nombre()));
			}
		}
	}

	private void actualizarCursos(String nombre) {
		_curso = _tit.getCurso(nombre);
		if(_curso != null) {
			asignaturasComboBox.removeAllElements();
			for (Asignatura a : _curso.get_lista_asignaturas()) {
				asignaturasComboBox.addElement(a.getNombre());
			}
		}
	}

	private void actualizarTitulacion(String nombre) {
		_tit = _ctrl.getTitulacion(nombre);
		cursosComboBox.removeAllElements();
		for (Curso c : _tit.getCursos()) {
			cursosComboBox.addElement(String.valueOf(c.get_anio()));
		}
	}
}
