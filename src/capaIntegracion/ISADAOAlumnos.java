package capaIntegracion;

import clases.Alumno;

public interface ISADAOAlumnos {
	
	public boolean crearAlumno(Character nombre);
	
	public boolean eliminarAlumno(Character nombre);
	
	public boolean existeAlumno(Character nombre);
	
	public boolean modificacionAlumno(Character grupo, Character nombre);

	public Alumno getAlumno(Character nombre);
}
