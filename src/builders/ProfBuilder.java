package builders;

import org.json.JSONException;
import org.json.JSONObject;

import clases.Profesor;

public class ProfBuilder extends Builder<Profesor> {

	private final static String _type_tag = "Prof";
	private final static String _desc = "Usuario";

	public ProfBuilder() {
		super(_type_tag, _desc);
	}

	@Override
	protected Profesor create_instance(JSONObject data) throws JSONException, Exception {

		String _nombre = null, _DNI = null, _correo = null;
		String _apellido = "";

		if (data.has("nombre"))
			_nombre = data.getString("nombre");
		if (data.has("apellidos")) {
			_apellido = data.getString("apellidos");
		}
		if (data.has("DNI")) {
			_DNI = data.getString("DNI");
		}
		if (data.has("correo")) {
			_correo = data.getString("correo");
		}
		
		return new Profesor(_nombre, _apellido, _DNI, _correo);
	}

}
