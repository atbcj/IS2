package capaIntegracion;

import clases.Grupo;
import clases.Profesor;

public class FachadaDAOProfesoresImp implements IFachadaDAOProfesores {
	
	private SADAOProfesoresImp _daoProfesores;

	public FachadaDAOProfesoresImp(Grupo grupo) {
		_daoProfesores = new SADAOProfesoresImp(grupo);
	}

	@Override
	public boolean altaProfesor(String[] datos) {
		
		return _daoProfesores.altaProfesor(datos);
	}

	@Override
	public boolean bajaProfesor(String DNI) {
		
		return _daoProfesores.bajaProfesor(DNI);
	}

	@Override
	public boolean existeProfesor(String DNI) {
		
		return _daoProfesores.existeProfesor(DNI);
	}

	@Override
	public boolean modificacionProfesor(String[] datos) {
		
		return _daoProfesores.modificacionProfesor(datos);
	}

	@Override
	public Profesor getProfesor(String DNI) {

		return _daoProfesores.getProfesor(DNI);
	}

}
