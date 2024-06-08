package logicaNegocio;

import capaIntegracion.FachadaDAOGruposImp;
import clases.Asignatura;
import clases.Grupo;

public class SAGruposImp implements SAGrupos {

	private FachadaDAOGruposImp _fachada;

	public SAGruposImp(Asignatura asignatura) {
		_fachada = new FachadaDAOGruposImp(asignatura);
	}

	@Override
	public boolean altaGrupo(Character nombre) throws Exception {
		if (_fachada.existeGrupo(nombre))
			throw new Exception("Ya existe un grupo con ese nombre.");
		return _fachada.crearGrupo(nombre);
	}

	@Override
	public boolean bajaGrupo(Character nombre) throws Exception {
		if (!_fachada.existeGrupo(nombre))
			throw new Exception("No existe un grupo con ese nombre.");
		if (!_fachada.eliminarGrupo(nombre))
			throw new Exception("El grupo debe estar vacio para poder ser eliminado.");
		return true;
	}

	@Override
	public Grupo consultaGrupo(Character nombre) {
		return _fachada.getGrupo(nombre);
	}

	@Override
	public boolean modificacionGrupo(Character grupo, Character nombre) throws Exception {
		if (_fachada.existeGrupo(nombre))
			throw new Exception("Ya existe un grupo con ese nombre.");
		return _fachada.modificacionGrupo(grupo, nombre);
	}

}
