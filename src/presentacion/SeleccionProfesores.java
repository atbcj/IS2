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

public class SeleccionProfesores extends JFrame {

    private static final long serialVersionUID = 1L;

    private Controller _ctrl;
    
    private DefaultComboBoxModel<String> titulacionComboBox;
    private DefaultComboBoxModel<String> cursoComboBox;
    private DefaultComboBoxModel<String> asignaturaComboBox;
    private DefaultComboBoxModel<String> grupoComboBox;
    
    private Titulacion _titulacion;
    private Curso _curso;
    private Asignatura _asignatura;
    private Grupo _grupo;

    public SeleccionProfesores(Controller cntr){
        _ctrl = cntr;
        initGUI();
    }
    
    private void initGUI() {
        setTitle("Seleccion de Profesores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 200);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        titulacionComboBox = new DefaultComboBoxModel<>();
        for(Titulacion t: _ctrl.getTitulaciones())
            titulacionComboBox.addElement(t.getNombre());
        JComboBox<String> ct = new JComboBox<>(titulacionComboBox);
        ct.addActionListener((e) -> actualizarTitulacion((String) ct.getSelectedItem()));
        
        cursoComboBox = new DefaultComboBoxModel<>();
        JComboBox<String> cc = new JComboBox<>(cursoComboBox);
        cc.addActionListener((e) -> actualizarCursos((String) cc.getSelectedItem()));
        
        asignaturaComboBox = new DefaultComboBoxModel<>();
        JComboBox<String> ca = new JComboBox<>(asignaturaComboBox);
        ca.addActionListener((e) -> actualizarAsignaturas((String) ca.getSelectedItem()));
        
        grupoComboBox = new DefaultComboBoxModel<>();
        JComboBox<String> cg = new JComboBox<>(grupoComboBox);
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
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una titulación, curso, asignatura y grupo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	//He comentado pq sale error
                //new GUIProfesores();
                setVisible(false);
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

    private void actualizarTitulacion(String nombre) {
        _titulacion = _ctrl.getTitulacion(nombre);
        cursoComboBox.removeAllElements();
        if (_titulacion != null) {
            for(Curso c: _titulacion.getCursos())
                cursoComboBox.addElement(String.valueOf(c.get_anio()));
        } 
        else {
            System.err.println("Titulacion no encontrada: " + nombre);
        }
    }
    
    private void actualizarCursos(String nombre) {
        if (_titulacion != null) {
            _curso = _titulacion.getCurso(nombre);
            asignaturaComboBox.removeAllElements();
            if (_curso != null) {
                for(Asignatura a: _curso.get_lista_asignaturas())
                    asignaturaComboBox.addElement(a.getNombre());
            } 
            else {
                System.err.println("Curso no encontrado: " + nombre);
            }
        } 
        else {
            System.err.println("No se ha seleccionado ninguna titulación.");
        }
    }
    
    private void actualizarAsignaturas(String nombre) {
        if (_curso != null) {
            _asignatura = _curso.getAsignatura(nombre);
            grupoComboBox.removeAllElements();
            if (_asignatura != null) {
                for(Grupo g: _asignatura.getGrupos())
                    grupoComboBox.addElement(String.valueOf(g.get_nombre()));
            } 
            else {
                System.err.println("Asignatura no encontrada: " + nombre);
            }
        } 
        else {
            System.err.println("No se ha seleccionado ningún curso.");
        }
    }
    
    private void actualizarGrupos(String nombre) {
        if (_asignatura != null) {
            _grupo = _asignatura.getGrupo(nombre);
        } 
        else {
            System.err.println("No se ha seleccionado ninguna asignatura.");
        }
    }
}

