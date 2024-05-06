package Factorias;


import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Cursos.Curso;
import Titulaciones.Titulacion;

public class TitBuilder extends Builder<Titulacion>{

	private CursoBuilder cursos = new CursoBuilder();
	
	public TitBuilder() {
		super(".", ".");
		
	}

	@Override
	public Titulacion create_instance(JSONObject data) throws JSONException, Exception {
		String nombre = data.getString("nombre");
		JSONArray array = data.getJSONArray("cursos");
		List<Curso> lista = new LinkedList();
		for(int i = 0; i< array.length(); i++) {
			lista.add(cursos.create_instance(array.getJSONObject(i)));
		}
		return new Titulacion(nombre,lista);
	}

}
