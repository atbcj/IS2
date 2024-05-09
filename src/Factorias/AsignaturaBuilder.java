package Factorias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Controller.Controller;
import Grupos.AuxiliarGrupos;

public class AsignaturaBuilder extends Builder{

	private Controller _ctrl;
	private GrupoBuilder grupo;
	private AuxiliarGrupos auxGrupo = new AuxiliarGrupos();
	
	public AsignaturaBuilder(Controller control) {
		super(".", ".");
		_ctrl = control;
		grupo = new GrupoBuilder(_ctrl);
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
