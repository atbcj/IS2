package is2;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Usuarios.Alumno;
import Usuarios.Tupla;

public class PanelBajaAlumno extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private Controller _ctrl;
	private Alumno _alumno;
	private DefaultComboBoxModel<String> _tuplas;
	private JButton _eliminarSistema;
	private JButton _eliminarTupla;
	private JButton _cancelar;

	public PanelBajaAlumno(Controller control, String dni) {
		super();
		_ctrl = control;
		_alumno = _ctrl.buscarAlumno(dni);
		initGUI();
	}
	
	private void initGUI() {
		setTitle(_alumno.getNombre() + " " + _alumno.get_apellidos());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(600,400));
		setContentPane(mainPanel);
		
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.Y_AXIS));
		JLabel tuplas = new JLabel("Tuplas: ");
		comboBoxPanel.add(tuplas);
		_tuplas = new DefaultComboBoxModel<String>();
		for(Tupla tupla: _alumno.getTupla()) {
			_tuplas.addElement(tupla.toString());
		}
		JComboBox c1 = new JComboBox<String>(_tuplas);
		comboBoxPanel.add(c1);
		
		mainPanel.add(comboBoxPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		_eliminarSistema = new JButton();
		_eliminarSistema.setText("Eliminar alumno");
		_eliminarSistema.addActionListener((e) -> eliminarSistemaAction());
		buttonPanel.add(_eliminarSistema);
		
		_eliminarTupla = new JButton();
		_eliminarTupla.setText("Eliminar del grupo");
		_eliminarTupla.addActionListener((e) -> eliminarTuplaAction());
		buttonPanel.add(_eliminarTupla);
		
		_cancelar = new JButton();
		_cancelar.setText("Cancel");
		_cancelar.addActionListener((e) -> cancelAction());
		buttonPanel.add(_cancelar);
		
		mainPanel.add(buttonPanel);
	}
	
	private void cancelAction() {
		this.setVisible(false);
	}

	private void eliminarTuplaAction() {
		_alumno.quitarTupla(buscarTupla(_tuplas.getSelectedItem().toString()));
	}

	private Tupla buscarTupla(String tupla) {
		int i=0;
		boolean encontrada = false;
		while(i < _alumno.getTupla().size() && !encontrada) {
			if(tupla.equals(_alumno.getTupla().get(i).toString())) {
				encontrada = true;
			}
			i++;
		}
		if(encontrada) {
			return _alumno.getTupla().get(i-1);
		}else {
			return null;
		}
	}

	private void eliminarSistemaAction() {
		_ctrl.eliminarAlumno(_alumno);
	}

	public void open(Frame parent) {
		setLocation(
				parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
	
	

}
