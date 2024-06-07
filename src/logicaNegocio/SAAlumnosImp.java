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
	public boolean bajaAlumno(String nombre) throws Exception {
		if(!_fachada.existeAlumno(nombre)) {
			throw new Exception("No existe un alumno con ese DNI para eliminar.");
		}
		return _fachada.eliminarAlumno(nombre);
	}

	@Override
	public Alumno consultaAlumno(String nombre) {
		return _fachada.getAlumno(nombre);
	}

	@Override
	public boolean modificacionAlumno(String[] al) throws Exception{
		return _fachada.modificacionAlumno(al);
	}

}
