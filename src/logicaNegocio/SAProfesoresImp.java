package logicaNegocio;

import capaIntegracion.FachadaDAOProfesoresImp;

import clases.Grupo;
import clases.Profesor;

public class SAProfesoresImp implements SAProfesores {

	private FachadaDAOProfesoresImp _fachadaP;

	public SAProfesoresImp(Grupo grupo) {

		_fachadaP = new FachadaDAOProfesoresImp(grupo);
	}

	@Override
	public boolean bajaProfesor(String DNI) throws Exception {

		if (!_fachadaP.existeProfesor(DNI)) {
			throw new Exception(" No existe un profesor con el DNI indicado para eliminar. ");
		}

		return _fachadaP.bajaProfesor(DNI);
	}

	@Override
	public boolean altaProfesor(String[] datos) throws Exception {

		if (_fachadaP.existeProfesor(datos[2])) {
			throw new Exception(" Ya existe un profesor con el DNI indicado. ");
		}

		return _fachadaP.altaProfesor(datos);
	}

	@Override
	public Profesor consultarProfesor(String DNI) {

		return _fachadaP.getProfesor(DNI);
	}

	@Override
	public boolean modificarProfesor(String[] datos) throws Exception {

		if (!_fachadaP.existeProfesor(datos[2]))
			throw new Exception(" No existe un profesor con ese DNI.");

		return _fachadaP.modificacionProfesor(datos);
	}

}
