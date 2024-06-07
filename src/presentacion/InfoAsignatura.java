package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

import clases.Asignatura;
import clases.Grupo;

@SuppressWarnings("serial")
public class InfoAsignatura extends JFrame {
    
    private Asignatura _asignatura;
    private String[] _headers = {"Grupos"}; // Ajusta los headers si es necesario
    private JLabel _codigoAsignatura;
    private JLabel _creditos;
    
    public InfoAsignatura(Asignatura asignatura) {
        _asignatura = asignatura;
        initGUI();
    }

    private void initGUI() {
        setTitle("Asignatura " + _asignatura.getNombre());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel codigoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Alinea los componentes a la izquierda
        _codigoAsignatura = new JLabel();
        _codigoAsignatura.setText("Código: " + _asignatura.getCodigo());
        codigoPanel.add(_codigoAsignatura);
        codigoPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
        mainPanel.add(codigoPanel);

        JPanel creditosPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Alinea los componentes a la izquierda
        _creditos = new JLabel();
        _creditos.setText("Créditos: " + _asignatura.getCreditos());
        creditosPanel.add(_creditos);
        creditosPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
        mainPanel.add(creditosPanel);
        
        if (_asignatura.getGrupos().isEmpty()) {
            JLabel sinGruposLabel = new JLabel("La asignatura de " + _asignatura.getNombre() + " no tiene grupos asociados.");
            sinGruposLabel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor del JLabel
            mainPanel.add(sinGruposLabel);
        } else {
            DefaultTableModel tablaGrupos = new DefaultTableModel();
            tablaGrupos.setColumnIdentifiers(_headers);
            for (Grupo g : _asignatura.getGrupos()) {
                Object[] row = {String.valueOf(g.get_nombre())}; // Convertimos el char a String y lo pasamos como Object[]
                tablaGrupos.addRow(row);
            }
            InfoTable tablaA = new InfoTable("Información de la asignatura", tablaGrupos);
            tablaA.setBorder(new EmptyBorder(10, 10, 10, 10)); // Deja un espacio alrededor de la tabla
            
            mainPanel.add(tablaA);
        }
        
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
