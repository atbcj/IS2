package logicaNegocio;

import clases.Curso;
import clases.Titulacion;

public class FachadaCursosImp implements IFachadaCursos {
	
	private SACursosImp _saCursosImp;

	public FachadaCursosImp(Titulacion titulacion) {
		_saCursosImp = new SACursosImp(titulacion);
	}
	
	@Override
	public boolean altaCurso(int anio) throws Exception {
		return _saCursosImp.altaCurso(anio);
	}

	@Override
	public boolean bajaCurso(int anio) throws Exception {
		return _saCursosImp.bajaCurso(anio);
	}

	@Override
	public Curso consultarCurso(int anio) throws Exception {
		return _saCursosImp.consultarCurso(anio);
	}

	@Override
	public boolean modificarCurso(int anioAntiguo, int anioNuevo) throws Exception {
		return _saCursosImp.modificarCurso(anioAntiguo, anioNuevo);
	}

}
