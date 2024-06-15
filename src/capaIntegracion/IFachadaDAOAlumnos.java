package capaIntegracion;

import clases.Alumno;


public interface IFachadaDAOAlumnos {

	public boolean crearAlumno(String[] al);

	public boolean eliminarAlumno(String nombre);

	public boolean existeAlumno(String nombre);

	public Alumno getAlumno(String nombre);

	public boolean modificacionAlumno(String[] al);
}
