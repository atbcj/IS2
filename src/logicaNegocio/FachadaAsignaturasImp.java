package logicaNegocio;

import clases.Asignatura;
import clases.Curso;

public class FachadaAsignaturasImp implements IFachadaAsignaturas {

	private SAAsignaturasImp _saAsignaturasImp;

	public FachadaAsignaturasImp(Curso curso) {
		_saAsignaturasImp = new SAAsignaturasImp(curso);
	}

	@Override
	public boolean altaAsignatura(String nombre, int creditos, String codigo) throws Exception {
		// TODO Auto-generated method stub
		return _saAsignaturasImp.altaAsignatura(nombre, creditos, codigo);
	}

	@Override
	public boolean bajaAsignatura(String codigo) throws Exception {
		// TODO Auto-generated method stub
		return _saAsignaturasImp.bajaAsigantura(codigo);
	}

	@Override
	public Asignatura consultarAsignatura(String codigo) {
		// TODO Auto-generated method stub
		return _saAsignaturasImp.consultaAsignatura(codigo);
	}

	@Override
	public boolean modificarAsignatura(String c, String codigo, String nombre, int creditos) throws Exception {
		// TODO Auto-generated method stub
		return _saAsignaturasImp.modificacionAsignatura(c, codigo, nombre, creditos);
	}

}
