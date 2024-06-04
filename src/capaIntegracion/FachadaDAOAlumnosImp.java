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
	public boolean crearAlumno(InfoAlumno al) {
		return _daoAlumnos.crearAlumno(al);
	}

	@Override
	public boolean eliminarAlumno(Character nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAlumno(String nombre) {
		return _daoAlumnos.existeAlumno(nombre);
	}
	
	@Override
	public boolean modificacionAlumno(Character grupo, Character nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno getAlumno(Character nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
