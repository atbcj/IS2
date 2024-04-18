package Alumnos;

import Grupos.Grupo;

public class Alumno {
	
	private String[] _nombre;
	private String[] _apellido1;
	private String[] _apellido2;
	private String _correo;
		
	public Alumno(String[] nombre,String[] apellido1, String[] apellido2, String correo) {
		_nombre = nombre;
		_apellido1 = apellido1;
		_apellido2 = apellido2;
		_correo = correo + "@universidad.es";
	}
	
	public String[] getNombre() {
		return this._nombre;
	}
	
	public String[] get1erApellido() {
		return this._apellido1;
	}
	
	public String[] get2oApellido() {
		return this._apellido2;
	}
	
	public String getCorreo() {
		return this._correo;
	}
}
