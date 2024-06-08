package builders;

import org.json.JSONException;
import org.json.JSONObject;

import clases.Alumno;

public class AlumnBuilder extends Builder<Alumno> {

	public AlumnBuilder() {
		super("Alum", "Human");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Alumno create_instance(JSONObject data) throws JSONException, Exception {
		// TODO Auto-generated method stub
		String nombre = "";
		String apellidos = "";
		String DNI = "";
		String correo = "";
		if (data.has("nombre")) {
			nombre = data.getString("nombre");
		}
		if (data.has("apellidos")) {
			apellidos = data.getString("apellidos");
		}
		if (data.has("DNI")) {
			DNI = data.getString("DNI");
		}
		if (data.has("correo")) {
			correo = data.getString("correo");
		}
		return new Alumno(nombre, apellidos, DNI, correo);
	}
}
