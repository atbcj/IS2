package logicaNegocio;

import capaIntegracion.FachadaDAOAsignaturasImp;
import clases.Asignatura;
import clases.Curso;
import clases.Grupo;

public class SAAsignaturasImp implements SAAsignaturas {

	private FachadaDAOAsignaturasImp _fachada;

	public SAAsignaturasImp(Curso curso) {
		_fachada = new FachadaDAOAsignaturasImp(curso);
	}

	@Override
	public boolean altaAsignatura(String nombre, int creditos, String codigo) throws Exception {
		// TODO Auto-generated method stub
		if (_fachada.existeAsignatura(codigo))
			throw new Exception("Ya existe una asignatura con ese codigo");
		if (_fachada.existeAsignaturaNombre(nombre))
			throw new Exception("Ya existe una asignatura con ese nombre");

		return _fachada.crearAsignatura(nombre, creditos, codigo);
	}

	@Override
	public boolean bajaAsigantura(String codigo) throws Exception {
		// TODO Auto-generated method stub
		if (!_fachada.eliminarAsignatura(codigo))
			throw new Exception("La asignatura no debe tener grupos asociados para poder ser eliminada");
		return true;
	}

	@Override
	public Asignatura consultaAsignatura(String codigo) {
		// TODO Auto-generated method stub
		return _fachada.getAsignatura(codigo);
	}

	@Override
	public boolean modificacionAsignatura(String c, String codigo, String nombre, int creditos) throws Exception {
		// TODO Auto-generated method stub
		return _fachada.modificacionAsignatura(c, codigo, nombre, creditos);
	}

}
