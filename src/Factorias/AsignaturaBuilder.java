package Factorias;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Grupos.Grupo;

public class AsignaturaBuilder extends Builder{

	public AsignaturaBuilder(String type_tag, String desc) {
		super(type_tag, desc);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Asignatura create_instance(JSONObject data) throws JSONException, Exception {
		String codigo = null;
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
	    
	    return new Asignatura(nombre, creditos, codigo, grupos);
	}



}
