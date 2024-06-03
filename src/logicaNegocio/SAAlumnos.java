package logicaNegocio;

import clases.Alumno;

public interface SAAlumnos {
	
	public boolean altaAlumno(Character nombre) throws Exception;
	
	public boolean bajaAlumno(Character nombre) throws Exception;
	
	public Alumno consultaAlumno(Character nombre);
	
	public boolean modificacionAlumno(Character grupo, Character nombre) throws Exception;
}
