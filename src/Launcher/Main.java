package Launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import Controller.Controller;
import is2.NewJFrame;

public class Main {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException, FileNotFoundException {
		FileOutputStream out = new FileOutputStream(new File("examples/ex3.json"));
        Controller control = new Controller();
    	control.loadData(load_JSON_file(new FileInputStream(new File("examples/ex1.json"))));
    	SwingUtilities.invokeAndWait(() -> {
			NewJFrame frame = new NewJFrame(control);
			frame.setVisible(true);
		});
    	//control.run();
	}

}
