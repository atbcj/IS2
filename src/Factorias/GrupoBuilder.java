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

public class GrupoBuilder extends Builder<Grupo>{

	private AlumnBuilder alu;
	private ProfBuilder prof;
	
	public GrupoBuilder(String type_tag, String desc) {
		super(type_tag, desc);
	}

	@Override
	protected Grupo create_instance(JSONObject data) throws JSONException, Exception {
		char nombre = (char) data.get("nombre");
		JSONArray array = data.getJSONArray("alumnos");
		List<Alumno> listal = new LinkedList();
		for(int i = 0; i<array.length(); i++) {
			listal.add((alu.create_instance(array.getJSONObject(i)));
		}
		
		JSONArray array2 = data.getJSONArray("alumnos");
		List<Profesor> listaprof = new LinkedList();
		for(int i = 0; i<array.length(); i++) {
			listaprof.add((prof.create_instance(array.getJSONObject(i)));
		}
		return new Grupo(nombre,listal,listaprof);
	}

}
