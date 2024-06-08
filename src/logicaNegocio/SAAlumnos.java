package logicaNegocio;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface SAAlumnos {

	public boolean altaAlumno(String[] al) throws Exception;

	public boolean bajaAlumno(String dni) throws Exception;

	public Alumno consultaAlumno(String nombre);

	public boolean modificacionAlumno(String[] al) throws Exception;
}
