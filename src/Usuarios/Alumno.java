package Usuarios;

public class Alumno extends Usuario{	
	public Alumno(String nombre,String apellidos, String DNI, String correo) {
		super(nombre,apellidos,DNI,correo);
	}
	
	public boolean equals(Alumno a) {
		return this._DNI == a.get_DNI();
	}
}
