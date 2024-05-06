package Usuarios;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Factorias.Factory;

public class Jsonclass {
	public void saveData(JSONObject database) {
		
	}
	
	public void loadData(JSONObject database, Factory<Usuario> factoria) throws Exception {
		JSONArray alumnos = database.getJSONArray("alumnos");
		for(int i = 0; i < alumnos.length(); i++) {
			JSONObject al = alumnos.getJSONObject(i);
			factoria.create_instance(al);
			//falta añadir el alumno a la lista general de alumnos y a la lista específica de cada asignatura,grupo y curso
		}
	}
	
	private static JSONObject load_JSON_file(InputStream in) {
		return new JSONObject(new JSONTokener(in));
	}
	
	
}
