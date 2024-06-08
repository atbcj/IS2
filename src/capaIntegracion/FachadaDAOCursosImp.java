package capaIntegracion;

import clases.Curso;
import clases.Titulacion;

public class FachadaDAOCursosImp implements IFachadaDAOCursos {
	private SADAOCursosImp _daoCursos;

	public FachadaDAOCursosImp(Titulacion titulacion) {
		_daoCursos = new SADAOCursosImp(titulacion);
	}

	@Override
	public boolean crearCurso(int anio) {
		return _daoCursos.crearCurso(anio);
	}

	@Override
	public boolean eliminarCurso(int anio) {
		return _daoCursos.eliminarCurso(anio);
	}

	@Override
	public boolean existeCurso(int anio) {
		return _daoCursos.existeCurso(anio);
	}

	@Override
	public boolean modificacionCurso(int anioAntiguo, int anioNuevo) {
		return _daoCursos.modificacionCurso(anioAntiguo, anioNuevo);
	}

	@Override
	public Curso getCurso(int anio) {
		return _daoCursos.getCurso(anio);
	}
}
