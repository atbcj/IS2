package Factorias;

import org.json.JSONException;
import org.json.JSONObject;

import Grupos.Grupo;

public class GrupoBuilder extends Builder<Grupo>{

	public GrupoBuilder(String type_tag, String desc) {
		super(type_tag, desc);
	}

	@Override
	protected Grupo create_instance(JSONObject data) throws JSONException, Exception {
		return new Grupo((char) data.get("nombre"));
	}

}
