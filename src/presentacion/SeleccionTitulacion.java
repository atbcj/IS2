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

import clases.Titulacion;

@SuppressWarnings("serial")
public class SeleccionTitulacion extends JFrame {
	private Controller _ctrl;
	private DefaultComboBoxModel<String> titulacionComboBox;
	private Titulacion _tit;

	public SeleccionTitulacion(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		setTitle("Seleccion de Titulaciones");
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
				new GUITitulacion(_tit);
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
