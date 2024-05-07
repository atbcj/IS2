package Factorias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Usuarios.Profesor;
import Usuarios.Usuario;

public class ProfBuilder extends Builder<Usuario> {

	private final static String _type_tag = "Prof";
	private final static String _desc = "Usuario";

	public ProfBuilder() {
		super(_type_tag, _desc);
	}

	@Override
	protected Profesor create_instance(JSONObject data) throws JSONException, Exception {

		String _nombre = null, _DNI = null, _correo = null;
		String[] _apellido = new String[2];

		if (data.has("nombre"))
			_nombre = data.getString("nombre");
		if (data.has("apellido")) {
			
			JSONArray apellidoArray = data.getJSONArray("apellidos");
			
			if (apellidoArray.length() >= 2) {
				_apellido[0] = apellidoArray.getString(0); 
				_apellido[1] = apellidoArray.getString(1); 
			}
		}
		if (data.has("DNI")) {
			_DNI = data.getString("DNI");
		}
		if (data.has("correo")) {
			_correo = data.getString("nombre");
		}
		
		return new Profesor(_nombre, _apellido, _DNI, _correo);
	}

}
