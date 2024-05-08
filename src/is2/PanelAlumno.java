/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package is2;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Titulaciones.Titulacion;

/**
 *
 * @author stele
 */
public class PanelAlumno extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Controller _ctrl;
	private DefaultComboBoxModel<String> _titulaciones;

	public PanelAlumno(Controller control) {
		super();
		_ctrl = control;
		initGUI();
	}
	
	
	private void initGUI() {
		setTitle("select your subjects");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(600,400));
		setContentPane(mainPanel);
		
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
		JLabel tits = new JLabel("Titulaciones: ");
		comboBoxPanel.add(tits);
		_titulaciones = new DefaultComboBoxModel<String>();
		for(Titulacion tit : _ctrl.getLista()) {
			_titulaciones.addElement(tit.getNombre());
		}
		comboBoxPanel.setPreferredSize(new Dimension(100,60));
		mainPanel.add(comboBoxPanel);
	}
	
	public void open(Frame parent) {
		setLocation(
				parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
}
