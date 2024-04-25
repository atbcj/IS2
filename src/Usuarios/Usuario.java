package Usuarios;

import java.util.List;

public abstract class Usuario {
	protected String _nombre;
	protected String[] _apellidos;
	protected String _DNI;
	protected String _correo;
	protected List<Tupla> tupla;
	
	public Usuario(String nombre, String[] apellidos, String DNI, String correo) {
		_nombre = nombre;
		_apellidos = apellidos;
		_DNI = DNI;
		_correo = correo;
	}
	
	public String getNombre() {
		return this._nombre;
	}
	
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	
	public String[] get_apellidos() {
		return _apellidos;
	}
	
	public String get_Apellido1() {
		return _apellidos[0];
	}
	
	public String get_Apellido2() {
		return _apellidos[1];
	}

	public void set_apellidos(String[] _apellidos) {
		this._apellidos = _apellidos;
	}

	public String get_DNI() {
		return _DNI;
	}

	public void set_DNI(String _DNI) {
		this._DNI = _DNI;
	}
	
}
