package logicaNegocio;

import clases.Grupo;
import clases.Profesor;

public class FachadaProfesoresImp implements IFachadaProfesores {

	private SAProfesoresImp _saProfesores;

	public FachadaProfesoresImp(Grupo grupo) {

		_saProfesores = new SAProfesoresImp(grupo);
	}

	@Override
	public boolean altaProfesor(String[] datos) throws Exception {

		return this._saProfesores.altaProfesor(datos);
	}

	@Override
	public boolean bajaProfesor(String DNI) throws Exception {

		return this._saProfesores.bajaProfesor(DNI);

	}

	@Override
	public Profesor consultarProfesor(String DNI) throws Exception {

		Profesor p = this._saProfesores.consultarProfesor(DNI);

		return p;
	}

	@Override
	public boolean modificarProfesor(String[] datos) throws Exception {

		return this.modificarProfesor(datos);
	}

}
