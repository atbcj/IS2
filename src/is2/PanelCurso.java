package is2;

import javax.swing.*;

import Controller.Controller;
import Cursos.Curso;
import Titulaciones.Titulacion;

import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;

public class PanelCurso extends JDialog {
    private static final long serialVersionUID = 1L;

    private Controller _ctrl;
    private DefaultComboBoxModel<String> _cursos;

    public PanelCurso(Controller control) {
        super();
        this._ctrl = control;
        initGUI();
    }

    private void initGUI() {
        setTitle("Gestión de Cursos");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(600, 400));
        setContentPane(mainPanel);

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));

        JLabel cursoLabel = new JLabel("Cursos: ");
        comboBoxPanel.add(cursoLabel);

        _cursos = new DefaultComboBoxModel<>();
        List<Titulacion> titulaciones = _ctrl.getLista();
        if (!titulaciones.isEmpty()) {
            for (Curso curso : titulaciones.get(0).getCursos()) { //  se toman los cursos de la primera titulación
                _cursos.addElement(String.valueOf(curso.get_anio()));
            }
        }
        JComboBox<String> comboBoxCursos = new JComboBox<>(_cursos);
        comboBoxPanel.add(comboBoxCursos);

        mainPanel.add(comboBoxPanel);

        // Añadir más componentes según necesidad
    }

    public void open(Frame parent) {
        setLocation(parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2,
                    parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
        pack();
        setVisible(true);
    }
}

