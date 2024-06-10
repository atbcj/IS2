package presentacion;

import java.awt.Dimension;
import javax.swing.*;
import clases.Titulacion;
import clases.Curso;

@SuppressWarnings("serial")
public class SeleccionCursos extends JFrame {

	private Controller _ctrl;
	private DefaultComboBoxModel<String> titulacionComboBox;
	private Titulacion _tit;

	public SeleccionCursos(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		setTitle("Seleccion de Cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 150);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		titulacionComboBox = new DefaultComboBoxModel<>();
		for (Titulacion t : _ctrl.getTitulaciones()) {
			titulacionComboBox.addElement(t.getNombre());
		}
		JComboBox<String> ct = new JComboBox<>(titulacionComboBox);
		ct.addActionListener((e) -> actualizarTitulacion((String) ct.getSelectedItem()));
		
		if (titulacionComboBox.getSize() > 0) {
			ct.setSelectedIndex(0); // Selecciona automáticamente la primera titulación
			actualizarTitulacion((String) ct.getSelectedItem()); // Actualiza la titulación seleccionada
		}
		
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(new JLabel("Titulaciones"));
		comboBoxPanel.add(ct);

		mainPanel.add(comboBoxPanel);

		JPanel savePanel = new JPanel();
		savePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton save = new JButton("Guardar");
		save.addActionListener((e) -> {
			if (_tit == null) {
				JOptionPane.showMessageDialog(this, "Por favor, seleccione una titulación.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				new GUICursos(_tit);
				setVisible(false);
			}
		});
		savePanel.add(save);

		mainPanel.add(savePanel);

		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void actualizarTitulacion(String nombreTitulacion) {
		_tit = _ctrl.getTitulacion(nombreTitulacion);

	}


}
