package logicaNegocio;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface IFachadaAlumnos {

	boolean altaAlumno(InfoAlumno al) throws Exception;
	
	boolean bajaAlumno(String nombre) throws Exception;
	
	Alumno consultarAlumno(String string) throws Exception;
	
	boolean modificarAlumno(String nombre) throws Exception;
}
