package Profesores;

public class Profesor {

	// atributos
	private String _nombre;
	private String[] _apellidos;
	private String _DNI;
	private String _correo;

	public Profesor(String _nombre, String[] _apellidos, String DNI, String correo) {
		
		this._nombre = _nombre;
		this._apellidos = _apellidos;
		this._DNI = DNI;
		this._correo = correo;
	}
	
	// metodos
	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String[] get_apellidos() {
		return _apellidos;
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
