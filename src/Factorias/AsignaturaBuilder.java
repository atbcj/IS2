package Factorias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Cursos.Curso;
import Grupos.Grupo;

public class AsignaturaBuilder extends Builder{

	private GrupoBuilder grupo = new GrupoBuilder();
	
	public AsignaturaBuilder() {
		super(".", ".");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Asignatura create_instance(JSONObject data) throws JSONException, Exception {
		/*String codigo = null;
	    String[] nombre = null;
	    int creditos = 0;
		if (data.has("codigo")) {
			 codigo = data.getString("codigo");
		}
		else {
			codigo = null;
		}
	    if (data.has("nombre")) {
	    	JSONArray n= data.getJSONArray("nombre");
	        nombre = new String[n.length()];
	        for (int i = 0; i < n.length(); i++) {
	            nombre[i] = n.getString(i);
	        }
	    }
	    else {
	    	nombre = null;
	    }
	    if (data.has("creditos")) {  
	    	creditos = data.getInt("creditos");
	    }
	    
	    List<Grupo> grupos = new ArrayList<>();
	    if (data.has("grupos")) {
	        JSONArray _grupos = data.getJSONArray("grupos");
	        for (int i = 0; i < _grupos.length(); i++) {
	            Character nombreGrupo = _grupos.getString(i).charAt(0);
	            grupos.add(new Grupo(nombreGrupo,null,null));
	        }
	    }
	    
	    return new Asignatura(nombre, creditos, codigo, grupos);*/
		
		String codigo = data.getString("codigo");
		String nombre = data.getString("nombre");
		int creditos = data.getInt("creditos");
		JSONArray array = data.getJSONArray("grupos");
		List<Grupo> lista = new LinkedList();
		for(int i = 0; i< array.length(); i++) {
			lista.add(grupo.create_instance(array.getJSONObject(i)));
		}
        return new Asignatura(nombre, creditos, codigo, lista);
	}



}
