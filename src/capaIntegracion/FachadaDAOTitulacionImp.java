package capaIntegracion;

import clases.Titulacion;
import presentacion.Controller;

public class FachadaDAOTitulacionImp implements IFachadaDAOTitulacion {
	
	private SADAOTitulacionImp _daoTitulacion;

	public FachadaDAOTitulacionImp(Controller control) {
		_daoTitulacion = new SADAOTitulacionImp(control);
	}
	
	@Override
	public boolean crearTitulacion(String nombre) {
		return _daoTitulacion.crearTitulacion(nombre);
	}
	
	@Override
	public boolean eliminarTitulacion(String nombre) {
		return _daoTitulacion.eliminarTitulacion(nombre);
	}

	@Override
	public boolean existeTitulacion(String nombre) {
		return _daoTitulacion.existeTitulacion(nombre);
	}

	@Override
	public boolean modificacionTitulacion(String nombreAntiguo, String nombreNuevo) {
		return _daoTitulacion.modificacionTitulacion(nombreAntiguo, nombreNuevo);
	}

	@Override
	public Titulacion getTitulacion(String nombre) {
		return _daoTitulacion.getTitulacion(nombre);
	}
}
