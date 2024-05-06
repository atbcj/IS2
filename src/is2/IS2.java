/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package is2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

import Controller.Controller;
import Factorias.Factory;
import Titulaciones.Titulacion;

/**
 *
 * @author stele
 */
public class IS2 {
	
    public static void main(String[] args) throws FileNotFoundException, Exception {
    	Controller control = new Controller();
    	control.loadData(load_JSON_file(new FileInputStream(new File("examples/ex1.json"))));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia de NewJFrame y hacerla visible
                NewJFrame frame = new NewJFrame();
                frame.setVisible(true);
            }
        });
    }
    
    private static JSONObject load_JSON_file(InputStream in) {
		return new JSONObject(new JSONTokener(in));
	}
}
