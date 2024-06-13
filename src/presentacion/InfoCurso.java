package presentacion;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import clases.Curso;
import clases.Asignatura;
import clases.Titulacion;

@SuppressWarnings("serial")
public class InfoCurso extends JFrame {

    private Curso _curso;
    private Titulacion _titulacion;
    private String[] _headers = { "Asignaturas" };
    private JLabel _nombreTitulacion;
    private JLabel _anioCurso;

    public InfoCurso(Curso curso, Titulacion titulacion) {
        _curso = curso;
        _titulacion = titulacion;
        initGUI();
    }

    private void initGUI() {
        setTitle("Curso " + _curso.get_anio());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel titulacionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Alinea los componentes a la izquierda
        _nombreTitulacion = new JLabel();
        _nombreTitulacion.setText("Titulación: " + _titulacion.getNombre());
        titulacionPanel.add(_nombreTitulacion);
        titulacionPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
        mainPanel.add(titulacionPanel);

        JPanel anioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Alinea los componentes a la izquierda
        _anioCurso = new JLabel();
        _anioCurso.setText("Año del Curso: " + _curso.get_anio());
        anioPanel.add(_anioCurso);
        anioPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
        mainPanel.add(anioPanel);

        if (_curso.get_lista_asignaturas().isEmpty()) {
            JLabel sinAsignaturasLabel = new JLabel(
                    "El curso de " + _curso.get_anio() + " no tiene asignaturas asociadas.");
            sinAsignaturasLabel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
            mainPanel.add(sinAsignaturasLabel);
        } else {
            DefaultTableModel tablaAsignaturas = new DefaultTableModel();
            tablaAsignaturas.setColumnIdentifiers(_headers);
            for (Asignatura a : _curso.get_lista_asignaturas()) {
                Object[] row = { a.getNombre() };
                tablaAsignaturas.addRow(row);
            }
            InfoTable tablaA = new InfoTable("Información del curso", tablaAsignaturas);
            tablaA.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor de la tabla

            mainPanel.add(tablaA);
        }

        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
