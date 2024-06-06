package capaIntegracion;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface IFachadaDAOAlumnos {
	
	public boolean crearAlumno(String[] al);
	
	public boolean eliminarAlumno(String nombre);
	
	public boolean existeAlumno(String nombre);
	
	public boolean modificacionAlumno(Character grupo, Character nombre);

	public Alumno getAlumno(String nombre);
}
