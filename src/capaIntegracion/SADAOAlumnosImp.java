package capaIntegracion;

import clases.Alumno;
import clases.Grupo;
import presentacion.InfoAlumno;

public class SADAOAlumnosImp implements ISADAOAlumnos{

	Grupo _grupo;
	
	public SADAOAlumnosImp(Grupo grupo) {
		_grupo = grupo;
	}
	
	@Override
	public boolean crearAlumno(String[] al) {
		_grupo.añade_alumno(new Alumno(al[0],al[1],al[2],al[3]));
		return true;
	}

	@Override
	public boolean eliminarAlumno(Character nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeAlumno(String dni) {
		for(Alumno a: _grupo.get_lista_alumnos()) {
			if(String.valueOf(a.get_DNI()).equals(dni)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificacionAlumno(Character grupo, Character nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno getAlumno(Character nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
