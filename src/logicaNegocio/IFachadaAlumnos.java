package logicaNegocio;

import clases.Alumno;

public interface IFachadaAlumnos {

	boolean altaAlumno(String nombre) throws Exception;
	
	boolean bajaAlumno(String nombre) throws Exception;
	
	Alumno consultarAlumno(String string) throws Exception;
	
	boolean modificarAlumno(String nombre) throws Exception;
}
