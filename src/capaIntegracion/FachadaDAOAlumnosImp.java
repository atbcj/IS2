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
	public boolean modificacionAlumno(Character grupo, Character nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno getAlumno(String dni) {
		_daoAlumnos.getAlumno(dni);
		return null;
	}

}
