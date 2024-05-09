/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Grupos;

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
public class PanelBajaGrupo extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private String _nombre;
	
	private Controller _ctrl;
	private JTextField _titulacion = new JTextField();
	private JTextField _curso = new JTextField();
	private JTextField _asignatura = new JTextField();
	private JButton _save = new JButton("SAVE");

	public PanelBajaGrupo(Controller control, String nombre) {
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
		
		JPanel titPanel = new JPanel();
		titPanel.setLayout(new BoxLayout(titPanel, BoxLayout.Y_AXIS));
		titPanel.add(new JLabel("Titulación"));
		titPanel.add(_titulacion);
		
		JPanel cursoPanel = new JPanel();
		cursoPanel.setLayout(new BoxLayout(cursoPanel, BoxLayout.Y_AXIS));
		cursoPanel.add(new JLabel("Curso"));
		cursoPanel.add(_curso);
		
		JPanel asPanel = new JPanel();
		asPanel.setLayout(new BoxLayout(asPanel, BoxLayout.Y_AXIS));
		asPanel.add(new JLabel("Asignatura"));
		asPanel.add(_asignatura);
		
		mainPanel.add(titPanel);
		mainPanel.add(cursoPanel);
		mainPanel.add(asPanel);

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
		_ctrl.bajaGrupo(_titulacion.getText(), _curso.getText(), _asignatura.getText(), _nombre);
	}
}
