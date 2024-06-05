package logicaNegocio;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface SAAlumnos {
	
	public boolean altaAlumno(String[] al) throws Exception;
	
	public boolean bajaAlumno(Character nombre) throws Exception;
	
	public Alumno consultaAlumno(Character nombre);
	
	public boolean modificacionAlumno(Character grupo, Character nombre) throws Exception;
}
