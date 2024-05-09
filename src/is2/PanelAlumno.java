/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package is2;

import java.awt.Dimension;
import is2.ViewUtils;
import java.awt.Frame;

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
public class PanelAlumno extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Alumno _al;
	private Controller _ctrl;
	private DefaultComboBoxModel<String> _titulaciones;
	private DefaultComboBoxModel<String> _cursos;
	private DefaultComboBoxModel<String> _asignaturas;
	private DefaultComboBoxModel<String> _grupos;
	private JButton _saveButton;
	private JButton _cancelButton;
	
	public PanelAlumno(Controller control,Alumno al) {
		super();
		_ctrl = control;
		_al = al;
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
		JLabel grup = new JLabel("Asignaturas: ");
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
		_al.añadirTupla(new Tupla(_titulaciones.getSelectedItem().toString(), _cursos.getSelectedItem().toString(), _asignaturas.getSelectedItem().toString(), _grupos.getSelectedItem().toString()));
	}


	private void seleccionGrupos(JPanel comboBoxPanel) {
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
		return curs.get_lista_asignaturas().get(i-1);
	}


	private void seleccionAsignaturas(JPanel comboBoxPanel) {
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
		return tit.getCursos().get(i-1);
	}


	private void seleccionCursos(JPanel comboBoxPanel) {
		Titulacion tit = titulacionParse(_titulaciones.getSelectedItem().toString());
		for(Curso c : tit.getCursos()) {
			_cursos.addElement(String.valueOf(c.get_anio()));
		}
	}
	
	public Titulacion titulacionParse(String nombre) {
		int i = 0;
		boolean encontrado = false;
		while(i < _ctrl.getLista().size() && !encontrado) {
			if(nombre == _ctrl.getLista().get(i).getNombre()) {
				encontrado = true;
			}
			i++;
		}
		return _ctrl.getLista().get(i-1);
	}
	
	public void open(Frame parent) {
		setLocation(
				parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
}
