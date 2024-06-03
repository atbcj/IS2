package presentacion;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	Controller _ctrl;
	static Dimension DIM = new Dimension(200, 30);
	
	public MainWindow(Controller ctrl){
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 85)));
		initUpperPanel(mainPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 85)));
		initCenterPanel(mainPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 85)));
		initLowerPanel(mainPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 85)));
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					_ctrl.save_data();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowDeactivated(WindowEvent e) {}
		});
		
		setContentPane(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initUpperPanel(JPanel mainPanel) {
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));

		JButton titulaciones = new JButton("Titulaciones");
		JButton cursos = new JButton("Cursos");
		
		titulaciones.setMaximumSize(DIM);
		cursos.setMaximumSize(DIM);
		
		upperPanel.add(Box.createRigidArea(new Dimension(150, 0)));
		upperPanel.add(titulaciones);
		upperPanel.add(Box.createRigidArea(new Dimension(100, 0)));
		upperPanel.add(cursos);
		upperPanel.add(Box.createRigidArea(new Dimension(150, 0)));
		
		mainPanel.add(upperPanel);
	}
	
	private void initCenterPanel(JPanel mainPanel) {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
		
		JButton asignaturas = new JButton("Asignaturas");
		JButton grupos = new JButton("Grupos");
		asignaturas.setMaximumSize(DIM);
		grupos.setMaximumSize(DIM);
		
		grupos.addActionListener((e) -> new SeleccionGrupos(_ctrl));
		
		JLabel imageLabel = new JLabel(new ImageIcon(
				new ImageIcon("resources/icons/exit.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
		
		centerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		centerPanel.add(asignaturas);
		centerPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		centerPanel.add(imageLabel);
		centerPanel.add(Box.createRigidArea(new Dimension(40, 0)));
		centerPanel.add(grupos);
		
		mainPanel.add(centerPanel);
	}
	
	private void initLowerPanel(JPanel mainPanel) {
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));

		JButton alumnos = new JButton("Alumnos");
		JButton profesores = new JButton("Profesores");
		
		alumnos.setMaximumSize(DIM);
		profesores.setMaximumSize(DIM);
		
		alumnos.addActionListener((e) -> new SeleccionAlumnos(_ctrl));		
		lowerPanel.add(Box.createRigidArea(new Dimension(150, 0)));
		lowerPanel.add(alumnos);
		lowerPanel.add(Box.createRigidArea(new Dimension(100, 0)));
		lowerPanel.add(profesores);
		lowerPanel.add(Box.createRigidArea(new Dimension(150, 0)));
		
		mainPanel.add(lowerPanel);
	}
}
