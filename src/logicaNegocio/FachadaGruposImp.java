package logicaNegocio;

import clases.Asignatura;
import clases.Grupo;

public class FachadaGruposImp implements IFachadaGrupos {

	private SAGruposImp _saGruposImp;

	public FachadaGruposImp(Asignatura asignatura) {
		_saGruposImp = new SAGruposImp(asignatura);
	}

	@Override
	public boolean altaGrupo(Character nombre) throws Exception {
		return _saGruposImp.altaGrupo(nombre);
	}

	@Override
	public boolean bajaGrupo(Character nombre) throws Exception {
		return _saGruposImp.bajaGrupo(nombre);
	}

	@Override
	public Grupo consultarGrupo(Character nombre) {
		return _saGruposImp.consultaGrupo(nombre);
	}

	@Override
	public boolean modificarGrupo(Character grupo, Character nombre) throws Exception {
		return _saGruposImp.modificacionGrupo(grupo, nombre);
	}

}
