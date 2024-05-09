package Usuarios;

import org.json.JSONArray;
import org.json.JSONObject;

import Asignaturas.Asignatura;

public class Alumno extends Usuario{	
	public Alumno(String nombre,String apellidos, String DNI, String correo) {
		super(nombre,apellidos,DNI,correo);
	}
}
