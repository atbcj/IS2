package capaIntegracion;

import clases.Curso;
import clases.Titulacion;

public class SADAOCursosImp implements ISADAOCursos {

	private Titulacion _titulacion;

	public SADAOCursosImp(Titulacion titulacion) {
		_titulacion = titulacion;
	}

	@Override
	public boolean crearCurso(int anio) {
		_titulacion.añade_curso(new Curso(anio, null));
		return true;
	}

	@Override
	public boolean eliminarCurso(int anio) {
		Curso curso = null;
		for (Curso c : _titulacion.getCursos())
			if (c.get_anio() == anio)
				curso = c;
		if (curso.get_lista_asignaturas().isEmpty()) {
			_titulacion.getCursos().remove(curso);
			return true;
		} else
			return false;
	}

	@Override
	public boolean existeCurso(int anio) {
		for (Curso c : _titulacion.getCursos()) {
			if (c.get_anio() == anio)
				return true;
		}
		return false;
	}

	@Override
	public boolean modificacionCurso(int anioAntiguo, int anioNuevo) {
		for (Curso c : _titulacion.getCursos()) {
			if (c.get_anio() == anioAntiguo) {
				c.modifica_anio(anioNuevo);
				return true;
			}
		}
		return false;
	}

	@Override
	public Curso getCurso(int anio) {
		for (Curso c : _titulacion.getCursos()) {
			if (c.get_anio() == anio)
				return c;
		}
		return null;
	}

}
