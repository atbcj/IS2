package Alumnos;

public class Alumno {
	//atributos
	private String _nombre;
	private String[] _apellidos;
	private String _correo;
	private Grupo _grupo;
	private Curso _curso;
	
	public Alumno(String nombre,String[] apellidos, String correo, Grupo grupo, Curso curso) {
		_nombre = nombre;
		_apellidos = apellidos;
		_correo = correo + "@universidad.es";
		_grupo = grupo;
		_curso = curso;
	}
}
