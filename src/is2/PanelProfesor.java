package is2;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Controller.Controller;

public class PanelProfesor extends JDialog {

	private static final long serialVersionUID = 1L;

	private Controller _ctrl;

	public PanelProfesor(Controller ctrl) {
		super();
		this._ctrl = ctrl;
		initGUI();
	}

	
	
	void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(600, 400));
		setContentPane(mainPanel);
	}

	public void open(Frame parent) {
		setLocation(parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
				parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
		pack();
		setVisible(true);
	}
}
