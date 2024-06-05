package logicaNegocio;

import capaIntegracion.FachadaDAOAlumnosImp;
import capaIntegracion.IFachadaDAOAlumnos;
import clases.Alumno;
import clases.Grupo;
import presentacion.InfoAlumno;

public class SAAlumnosImp implements SAAlumnos{

	private IFachadaDAOAlumnos _fachada;
	
	public SAAlumnosImp(Grupo grupo) {
		_fachada = new FachadaDAOAlumnosImp(grupo);
	}
	@Override
	public boolean altaAlumno(String[] al) throws Exception {
		if(_fachada.existeAlumno(al[2])) {
			throw new Exception("Ya existe un alumno con ese DNI.");
		}
		return _fachada.crearAlumno(al);
	}

	@Override
	public boolean bajaAlumno(Character nombre) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno consultaAlumno(Character nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificacionAlumno(Character grupo, Character nombre) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
