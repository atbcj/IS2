/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package is2;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

/**
 *
 * @author stele
 */
public class PanelGrupo extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private String _nombre;
	
	private Controller _ctrl;
	private JTextField _titulacion = new JTextField();
	private JTextField _curso = new JTextField();
	private JTextField _asignatura = new JTextField();
	private JButton _save = new JButton("SAVE");

	public PanelGrupo(Controller control, String nombre) {
		super();
		_ctrl = control;
		_nombre = nombre;
		initGUI();
	}
	
	
	private void initGUI() {
		setTitle("Change Regions");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(600,400));
		setContentPane(mainPanel);
		
		mainPanel.add(_titulacion);
		mainPanel.add(_curso);
		mainPanel.add(_asignatura);
		mainPanel.add(_save);
		

		_save.addActionListener((e) -> save());

	}
	
	public void open(Frame parent) {
		setLocation(
				parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
	
	void save() {
		_ctrl.altaGrupo(_titulacion.getText(), _curso.getText(), _asignatura.getText(), _nombre);
	}
}
