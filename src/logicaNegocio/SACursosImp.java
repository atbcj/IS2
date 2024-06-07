package logicaNegocio;

import capaIntegracion.FachadaDAOCursosImp;
import clases.Curso;
import clases.Titulacion;

public class SACursosImp implements SACursos{
	
	private FachadaDAOCursosImp _fachada;
	
	public SACursosImp(Titulacion titulacion) {
		_fachada = new FachadaDAOCursosImp(titulacion);
	}
	
	@Override
	public boolean altaCurso(int anio) throws Exception {
		if(_fachada.existeCurso(anio))
			throw new Exception("Ya existe un curso con ese anio.");
		return _fachada.crearCurso(anio);
	}

	@Override
	public boolean bajaCurso(int anio) throws Exception {
		if(!_fachada.existeCurso(anio))
			throw new Exception("No existe un curso con ese anio.");
		if(!_fachada.eliminarCurso(anio))
			throw new Exception("El curso debe estar vacio para poder ser eliminado.");
		return true;
	}

	@Override
	public Curso consultarCurso(int anio) throws Exception {
		return _fachada.getCurso(anio);
	}

	@Override
	public boolean modificarCurso(int anioAntiguo, int anioNuevo) throws Exception {
		if(_fachada.existeCurso(anioNuevo))
			throw new Exception("Ya existe un curso con ese anio.");
		return _fachada.modificacionCurso(anioAntiguo, anioNuevo);
	}

}
