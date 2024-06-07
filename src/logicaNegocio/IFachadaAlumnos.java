package logicaNegocio;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface IFachadaAlumnos {

	boolean altaAlumno(String[] al) throws Exception;
	
	boolean bajaAlumno(String nombre) throws Exception;
	
	Alumno consultarAlumno(String string) throws Exception;
	
	boolean modificarAlumno(String[] string) throws Exception;
}
