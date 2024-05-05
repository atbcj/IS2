package is2;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Alta extends JFrame {
    
    public Alta() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Alta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel labelProfesor = new JLabel("Profesor:");
        labelProfesor.setBounds(30, 30, 100, 20);
        panel.add(labelProfesor);
        
        // Agregar campos para datos del profesor
        
        JLabel labelAlumno = new JLabel("Alumno:");
        labelAlumno.setBounds(30, 100, 100, 20);
        panel.add(labelAlumno);
        
        // Agregar campos para datos del alumno
        
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(120, 200, 100, 30);
        panel.add(botonGuardar);

        add(panel);
    }
}
