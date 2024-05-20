package Launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.SwingUtilities;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import presentacion.Controller;
import presentacion.MainWindow;

public class Main {

	public static void main(String[] args) throws JSONException, Exception {
		JSONObject data = load_JSON_file(new FileInputStream(new File("examples/ex3.json")));
		Controller ctrl = new Controller(data);
		SwingUtilities.invokeLater(() -> new MainWindow(ctrl));
	}
	
	private static JSONObject load_JSON_file(InputStream in) {
		return new JSONObject(new JSONTokener(in));
	}

}
