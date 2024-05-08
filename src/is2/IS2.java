/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package is2;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.SwingUtilities;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import Controller.Controller;

/**
 *
 * @author stele
 */
public class IS2 {

    public static void main(String[] args) throws FileNotFoundException, Exception {
    	
		
		
        FileOutputStream out = new FileOutputStream(new File("examples/ex3.json"));
        Controller control = new Controller();
    	control.loadData(load_JSON_file(new FileInputStream(new File("examples/ex1.json"))));
    	SwingUtilities.invokeAndWait(() -> {
			NewJFrame frame = new NewJFrame(control);
			frame.setVisible(true);
		});
    	//control.run();
    }
    

    private static JSONObject load_JSON_file(InputStream in) {
		return new JSONObject(new JSONTokener(in));
	}
}
