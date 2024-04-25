package Factorias;

import org.json.JSONException;
import org.json.JSONObject;

import Usuarios.Alumno;
import Usuarios.Usuario;

public class AlumnBuilder extends Builder<Usuario>{

	public AlumnBuilder() {
		super("Alum","Human");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Usuario create_instance(JSONObject data) throws JSONException, Exception {
		// TODO Auto-generated method stub
		String nombre = "";
		String[] apellidos = new String[2];
		String DNI = "";
		String correo = "";
		String[] tupla = new String[4];
		if(data.has("nombre")) {
			nombre = data.getString("nombre");
		}
		if(data.has("apellidos")) {
			apellidos = JSONObject.getNames(data);
		}
		if(data.has("DNI")) {
			DNI = data.getString("DNI");
		}
		if(data.has("correo")) {
			correo = data.getString("nombre");
		}
		return new Alumno(nombre, apellidos, correo, DNI);
	}
	
	
}
