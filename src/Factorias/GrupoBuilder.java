package Factorias;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Grupos.Grupo;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;

public class GrupoBuilder extends Builder <Grupo> {

	private AlumnBuilder alu = new AlumnBuilder();
	private ProfBuilder prof = new ProfBuilder();
	
	public GrupoBuilder() {
		super(".", ".");
	}

	@Override
	protected Grupo create_instance(JSONObject data) throws JSONException, Exception {
		char nombre = data.getString("nombre");
		
		JSONArray arrayAlumnos = data.getJSONArray("alumnos");
		
		List<Alumno> listaAlumnos = new LinkedList<>();
		
		for(int i = 0; i< arrayAlumnos.length(); i++) {
			listaAlumnos.add((alu.create_instance(arrayAlumnos.getJSONObject(i))));
		}
		
		JSONArray arrayProfesores = data.getJSONArray("profesores"); 
	    
		List<Profesor> listaProfesores = new LinkedList<>();
	    
		for (int i = 0; i < arrayProfesores.length(); i++) {
	        listaProfesores.add(prof.create_instance(arrayProfesores.getJSONObject(i)));
	    }
	    
		return new Grupo(nombre, listaAlumnos, listaProfesores);
	}

}
