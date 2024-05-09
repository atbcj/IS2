package Factorias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Grupos.AuxiliarGrupos;

public class AsignaturaBuilder extends Builder{

	private GrupoBuilder grupo = new GrupoBuilder();
	private AuxiliarGrupos auxGrupo = new AuxiliarGrupos();
	
	public AsignaturaBuilder() {
		super(".", ".");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Asignatura create_instance(JSONObject data) throws JSONException, Exception {
		String codigo = data.getString("codigo");
		String nombre = data.getString("nombre");
		int creditos = data.getInt("creditos");
		JSONArray array = data.getJSONArray("grupos");
		auxGrupo.getListaGrupos().add(grupo.create_instance(array.getJSONObject(0)));
		for(int i = 1; i< array.length(); i++) {
			auxGrupo.getListaGrupos().add(grupo.create_instance(array.getJSONObject(i)));
		}
		Asignatura a = new Asignatura(nombre, creditos, codigo, auxGrupo.getListaGrupos());
        return a;
	}



}
