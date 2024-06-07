package capaIntegracion;

import clases.Alumno;
import clases.Grupo;
import presentacion.InfoAlumno;

public class FachadaDAOAlumnosImp implements IFachadaDAOAlumnos{

	private ISADAOAlumnos _daoAlumnos;
	
	public FachadaDAOAlumnosImp(Grupo grupo) {
		_daoAlumnos = new SADAOAlumnosImp(grupo);
	}
	
	@Override
	public boolean crearAlumno(String[] al) {
		return _daoAlumnos.crearAlumno(al);
	}

	@Override
	public boolean eliminarAlumno(String dni) {
		return _daoAlumnos.eliminarAlumno(dni);
	}

	@Override
	public boolean existeAlumno(String dni) {
		return _daoAlumnos.existeAlumno(dni);
	}
	
	@Override
	public boolean modificacionAlumno(String[] al) {
		return _daoAlumnos.modificacionAlumno(al);
	}

	@Override
	public Alumno getAlumno(String dni) {
		return _daoAlumnos.getAlumno(dni);	 
	}

}
