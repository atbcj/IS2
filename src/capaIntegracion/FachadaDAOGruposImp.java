package capaIntegracion;

import clases.Asignatura;
import clases.Grupo;

public class FachadaDAOGruposImp implements IFachadaDAOGrupos {

	private SADAOGruposImp _daoGrupos;

	public FachadaDAOGruposImp(Asignatura asignatura) {
		_daoGrupos = new SADAOGruposImp(asignatura);
	}

	@Override
	public boolean crearGrupo(Character nombre) {
		return _daoGrupos.crearGrupo(nombre);
	}

	@Override
	public boolean eliminarGrupo(Character nombre) {
		return _daoGrupos.eliminarGrupo(nombre);
	}

	@Override
	public boolean existeGrupo(Character nombre) {
		return _daoGrupos.existeGrupo(nombre);
	}

	@Override
	public boolean modificacionGrupo(Character grupo, Character nombre) {
		return _daoGrupos.modificacionGrupo(grupo, nombre);
	}

	@Override
	public Grupo getGrupo(Character nombre) {
		return _daoGrupos.getGrupo(nombre);
	}

}
