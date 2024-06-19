package presentacion;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import clases.Curso;
import clases.Titulacion;

@SuppressWarnings("serial")
public class InfoTitulacion extends JFrame {

    private Titulacion _titulacion;
    private String[] _headers = { "Cursos" };
    private JLabel _nombreTitulacion;

    public InfoTitulacion(Titulacion titulacion) {
        _titulacion = titulacion;
        initGUI();
    }

    private void initGUI() {
        setTitle("Titulación " + _titulacion.getNombre());
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

        if (_titulacion.getCursos().isEmpty()) {
            JLabel sinCursosLabel = new JLabel(
                    "La titulación " + _titulacion.getNombre() + " no tiene cursos asociados.");
            sinCursosLabel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
            mainPanel.add(sinCursosLabel);
        } else {
            DefaultTableModel tablaCursos = new DefaultTableModel();
            tablaCursos.setColumnIdentifiers(_headers);
            for (Curso c : _titulacion.getCursos()) {
                Object[] row = { "Curso " + c.get_anio() };
                tablaCursos.addRow(row);
            }
            InfoTable tablaC = new InfoTable("Información de la titulación", tablaCursos);
            tablaC.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor de la tabla

            mainPanel.add(tablaC);
        }

        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

