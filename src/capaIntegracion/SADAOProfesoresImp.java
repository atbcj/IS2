package capaIntegracion;

import clases.Grupo;
import clases.Profesor;

public class SADAOProfesoresImp implements ISADAOProfesores {
	
	private Grupo _grupo;

	public SADAOProfesoresImp(Grupo grupo) {
		this._grupo = grupo;
	}

	@Override
	public boolean altaProfesor(String[] datos) {
		this._grupo.añade_profesor(new Profesor(datos[0],datos[1], datos[2], datos[3]));
		
		return true;
	}

	@Override
	public boolean bajaProfesor(String DNI) {
		this._grupo.elimina_profesor(this.getProfesor(DNI));
		
		return true;
	}

	@Override
	public boolean existeProfesor(String DNI) {
		
		for (Profesor a : _grupo.get_lista_profesores()) {
			
			if (a.get_DNI().equals(DNI)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificacionProfesor(String[] datos) {
		
		// Obtenemos el profesor por su DNI ( tercer elemento del array)
		Profesor p = getProfesor(datos[2]);
		
		if (datos[0] != null)
			p.set_nombre(datos[0]);
		if (datos[1] != null )
			p.set_apellidos(datos[1]);
		if (datos[2] != null)
			p.set_DNI(datos[2]);
		if (datos[3] != null)
			p.setCorreo(datos[3]);
		
		return true;
	}

	@Override
	public Profesor getProfesor(String DNI) {
		
		for (Profesor p : _grupo.get_lista_profesores()) {
			
			if (p.get_DNI().equals(DNI))
				return p;
		}
		
		return null;
	}
}