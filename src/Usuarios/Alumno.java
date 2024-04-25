package Usuarios;

import Grupos.Grupo;

public class Alumno extends Usuario{
	
	private Grupo[] _cursos;
		
	public Alumno(String nombre,String[] apellidos, String correo, String DNI ,Grupo[] cursos) {
		super(nombre,apellidos,correo,DNI);
	}
}
