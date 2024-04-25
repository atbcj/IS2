package Factorias;

import java.util.List;


import org.json.JSONObject;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;

public class UsersFactory implements Factory<Usuario> {

	@Override
	public Usuario create_instance(JSONObject info) throws Exception {
		Usuario usuario = null;
		String tag = info.getString("type");
//		JSONObject data = o.optJSONObject("data");
		switch (tag) {
		case "Alum": {
			usuario = new Alumno(null, null, null, "");
			break;
		}
		case "Prof": {
			usuario = new Profesor(null, null, null, "");
			break;
		}
		}

		return usuario;
	}

	@Override
	public List<JSONObject> get_info() {
		// TODO Auto-generated method stub
		return null;
	}

}
