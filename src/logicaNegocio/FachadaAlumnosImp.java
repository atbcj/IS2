package logicaNegocio;

import clases.Alumno;
import clases.Grupo;
import presentacion.InfoAlumno;

public class FachadaAlumnosImp implements IFachadaAlumnos{

	private SAAlumnos _saAlumnos;
	
	public FachadaAlumnosImp(Grupo grupo) {
		_saAlumnos = new SAAlumnosImp(grupo);
	}
	
	@Override
	public boolean altaAlumno(InfoAlumno al) throws Exception {
		return _saAlumnos.altaAlumno(al);
	}

	@Override
	public boolean bajaAlumno(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno consultarAlumno(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarAlumno(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
