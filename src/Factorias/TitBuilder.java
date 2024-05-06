package Factorias;


import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Cursos.Curso;
import Titulaciones.Titulacion;

public class TitBuilder extends Builder<Titulacion>{

	private CursoBuilder cursos;
	
	public TitBuilder(String type_tag, String desc) {
		super(type_tag, desc);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Titulacion create_instance(JSONObject data) throws JSONException, Exception {
		String nombre = data.getString("nombre");
		JSONArray array = data.getJSONArray("cursos");
		List<Curso> lista = new LinkedList();
		for(int i = 0; i< array.length(); i++) {
			lista.add(cursos.create_instance(array.getJSONObject(i)));
		}
		return new Titulacion(nombre,lista);
	}

}
