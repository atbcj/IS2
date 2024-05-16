package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

public class InfoTable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	String _title;
	TableModel _tableModel;

	InfoTable(String title, TableModel tableModel) {
		_title = title;
		_tableModel = tableModel;
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout());
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), _title, TitledBorder.LEFT, TitledBorder.TOP));
		
		JTable t = new JTable(_tableModel);
		t.setShowVerticalLines(true);
		add(new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
}
