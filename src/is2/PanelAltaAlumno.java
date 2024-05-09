/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package is2;

import java.awt.Dimension;
import is2.ViewUtils;
import java.awt.Frame;
import java.awt.geom.Dimension2D;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Asignaturas.Asignatura;
import Controller.Controller;
import Cursos.Curso;
import Grupos.Grupo;
import Titulaciones.Titulacion;
import Usuarios.Alumno;
import Usuarios.Tupla;

/**
 *
 * @author stele
 */
public class PanelAltaAlumno extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Alumno _al;
	private Controller _ctrl;
	private DefaultComboBoxModel<String> _titulaciones;
	private DefaultComboBoxModel<String> _cursos;
	private DefaultComboBoxModel<String> _asignaturas;
	private DefaultComboBoxModel<String> _grupos;
	private JButton _saveButton;
	private JButton _cancelButton;
	
	public PanelAltaAlumno(Controller control, Alumno al) {
		super();
		_ctrl = control;
		_al = al;
		initGUI();
	}
	
	
	private void initGUI() {
		setTitle(_al.getNombre() + " " + _al.get_apellidos());
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(600,400));
		setContentPane(mainPanel);
		
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.Y_AXIS));
		JLabel tits = new JLabel("Titulaciones: ");
		comboBoxPanel.add(tits);
		_titulaciones = new DefaultComboBoxModel<String>();
		for(Titulacion tit : _ctrl.getLista()) {
			_titulaciones.addElement(tit.getNombre());
		}
		JComboBox c1 = new JComboBox<String>(_titulaciones);
		comboBoxPanel.add(c1);
		c1.addActionListener((e) -> seleccionCursos(comboBoxPanel));
		
		_cursos = new DefaultComboBoxModel<String>();
		JLabel curs = new JLabel("Cursos: ");
		comboBoxPanel.add(curs);
		JComboBox c2 = new JComboBox<String>(_cursos);
		comboBoxPanel.add(c2);
		c2.addActionListener((e) -> seleccionAsignaturas(comboBoxPanel));
		
		_asignaturas = new DefaultComboBoxModel<String>();
		JLabel asig = new JLabel("Asignaturas: ");
		comboBoxPanel.add(asig);
		JComboBox c3 = new JComboBox<String>(_asignaturas);
		comboBoxPanel.add(c3);
		c3.addActionListener((e) -> seleccionGrupos(comboBoxPanel));
		
		_grupos = new DefaultComboBoxModel<String>();
		JLabel grup = new JLabel("Grupos: ");
		comboBoxPanel.add(grup);
		JComboBox c4 = new JComboBox<String>(_grupos);
		comboBoxPanel.add(c4);
		
		mainPanel.add(comboBoxPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		_saveButton = new JButton();
		_saveButton.setText("Save");
		_saveButton.addActionListener((e) -> saveAction());
		buttonPanel.add(_saveButton);
		
		_cancelButton = new JButton();
		_cancelButton.setText("Cancel");
		_cancelButton.addActionListener((e) -> cancelAction());
		buttonPanel.add(_cancelButton);
		
		mainPanel.add(buttonPanel);
	}
	
	private void cancelAction() {
		setVisible(false);
	}


	private void saveAction() {
		_al.añadirTupla(new Tupla(_titulaciones.getSelectedItem().toString(), _cursos.getSelectedItem().toString(), _asignaturas.getSelectedItem().toString(), _grupos.getSelectedItem().toString()),true);
	}


	private void seleccionGrupos(JPanel comboBoxPanel) {
		reset(_grupos);
		Asignatura asig = asigParse(_cursos.getSelectedItem().toString());
		for(Grupo grup : asig.getGrupos()) {
			_grupos.addElement(String.valueOf(grup.get_nombre()));
		}
	}


	private Asignatura asigParse(String nombre) {
		int i = 0;
		boolean encontrado = false;
		Curso curs = cursParse(_cursos.getSelectedItem().toString());
		while(i < curs.get_lista_asignaturas().size() && !encontrado) {
			if(nombre == String.valueOf(curs.get_lista_asignaturas().get(i).getNombre())){
				encontrado = true;
			}
			i++;
		}
		if(encontrado) {
			return curs.get_lista_asignaturas().get(i-1);
		}
		else {
			return null;
		}
		
	}


	private void seleccionAsignaturas(JPanel comboBoxPanel) {
		reset(_asignaturas);
		Curso curs = cursParse(_cursos.getSelectedItem().toString());
		for(Asignatura a : curs.get_lista_asignaturas()) {
			_asignaturas.addElement(a.getCodigo() + " " +  a.getNombre());
		}
	}


	private Curso cursParse(String nombre) {
		int i = 0;
		boolean encontrado = false;
		Titulacion tit = titulacionParse(_titulaciones.getSelectedItem().toString());
		while(i < tit.getCursos().size() && !encontrado) {
			if(nombre == String.valueOf(tit.getCursos().get(i).get_anio())) {
				encontrado = true;
			}
			i++;
		}
		if(encontrado) {
			return tit.getCursos().get(i-1);
		}
		else {
			return null;
		}
	}


	private void seleccionCursos(JPanel comboBoxPanel) {
		reset(_cursos);
		Titulacion tit = titulacionParse(_titulaciones.getSelectedItem().toString());
		for(Curso c : tit.getCursos()) {
			_cursos.addElement(String.valueOf(c.get_anio()));
		}
	}
	
	private Titulacion titulacionParse(String nombre) {
		int i = 0;
		boolean encontrado = false;
		while(i < _ctrl.getLista().size() && !encontrado) {
			if(nombre == _ctrl.getLista().get(i).getNombre()) {
				encontrado = true;
			}
			i++;
		}
		if(encontrado) {
			return _ctrl.getLista().get(i-1);
		}
		else {
			return null;
		}
	}
	
	public void open(Frame parent) {
		setLocation(
				parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
	
	private void reset(DefaultComboBoxModel<String> box) {
		box.removeAllElements();
	}
}
