package presentacion;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SeleccionTitulacion extends JFrame {
	private Controller _ctrl;

	public SeleccionTitulacion(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		new GUITitulacion(_ctrl);
	}
}
