package Factorias;

import org.json.JSONException;
import org.json.JSONObject;

import Controller.Controller;
import Usuarios.Alumno;
import Usuarios.Usuario;

public class AlumnBuilder extends Builder<Usuario>{

	private Controller _ctrl;
	
	public AlumnBuilder(Controller control) {
		super("Alum","Human");
		_ctrl = control;
	}

	@Override
	public Alumno create_instance(JSONObject data) throws JSONException, Exception {
		// TODO Auto-generated method stub
		String nombre = "";
		String apellidos = "";
		String DNI = "";
		String correo = "";
		if(data.has("nombre")) {
			nombre = data.getString("nombre");
		}
		if(data.has("apellidos")) {
			apellidos = data.getString("apellidos");
		}
		if(data.has("DNI")) {
			DNI = data.getString("DNI");
		}
		if(data.has("correo")) {
			correo = data.getString("correo");
		}
		Alumno a = new Alumno(nombre, apellidos, DNI, correo);
		_ctrl.altaAlumno(a);
		return a;
	}
}
