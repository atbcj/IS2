package capaIntegracion;

import clases.Alumno;
import presentacion.InfoAlumno;

public interface IFachadaDAOAlumnos {
	
	public boolean crearAlumno(InfoAlumno al);
	
	public boolean eliminarAlumno(Character nombre);
	
	public boolean existeAlumno(String nombre);
	
	public boolean modificacionAlumno(Character grupo, Character nombre);

	public Alumno getAlumno(Character nombre);
}
