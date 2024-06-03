package logicaNegocio;

import clases.Alumno;

public interface IFachadaAlumnos {

	boolean altaAlumno(Character nombre) throws Exception;
	
	boolean bajaAlumno(Character nombre) throws Exception;
	
	Alumno consultarAlumno(Character nombre) throws Exception;
	
	boolean modificarAlumno(Character grupo, Character nombre) throws Exception;
}
