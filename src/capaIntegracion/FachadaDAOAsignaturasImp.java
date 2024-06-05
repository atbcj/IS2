package capaIntegracion;

import clases.Asignatura;
import clases.Curso;

public class FachadaDAOAsignaturasImp implements IFachadaDAOAsignaturas{
	
	private SADAOAsignaturasImp _daoAsignaturas;
	
	public FachadaDAOAsignaturasImp(Curso curso) {
		_daoAsignaturas = new SADAOAsignaturasImp(curso);
	}
	@Override
	public boolean crearAsignatura(String nombre, int creditos, String codigo) {
		// TODO Auto-generated method stub
		return _daoAsignaturas.crearAsignatura(nombre, creditos, codigo);
	}

	@Override
	public boolean eliminarAsignatura(String codigo) {
		// TODO Auto-generated method stub
		return _daoAsignaturas.eliminarAsignatura(codigo);
	}

	@Override
	public boolean existeAsignatura(String codigo) {
		// TODO Auto-generated method stub
		return _daoAsignaturas.existeAsignatura(codigo);
	}
	
	@Override
	public Asignatura getAsignatura(String codigo) {
		// TODO Auto-generated method stub
		return _daoAsignaturas.getAsignatura(codigo);
	}
	@Override
	public boolean modificacionAsignatura(String c, String codigo, String nombre, int creditos) {
		// TODO Auto-generated method stub
		return _daoAsignaturas.modificacionAsignatura(c, codigo, nombre, creditos);
	}

}
