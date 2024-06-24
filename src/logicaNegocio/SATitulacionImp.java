package logicaNegocio;

import capaIntegracion.FachadaDAOTitulacionImp;
import clases.Titulacion;
import presentacion.Controller;


public class SATitulacionImp implements SATitulacion {

	private FachadaDAOTitulacionImp _fachada;

	public SATitulacionImp(Controller control) {
		_fachada = new FachadaDAOTitulacionImp(control);
	}

	@Override
	public boolean altaTitulacion(String nombre) throws Exception {
		if (_fachada.existeTitulacion(nombre))
			throw new Exception("Ya existe una titulación con ese nombre.");
		return _fachada.crearTitulacion(nombre);
	}

	@Override
	public boolean bajaTitulacion(String nombre) throws Exception {
		if (!_fachada.existeTitulacion(nombre))
			throw new Exception("No existe una titulación con ese nombre.");
		if (!_fachada.eliminarTitulacion(nombre))
			throw new Exception("La titulación debe estar vacío para poder ser eliminado.");
		return true;
	}

	@Override
	public Titulacion consultarTitulacion(String nombre) throws Exception {
		return _fachada.getTitulacion(nombre);
	}

	@Override
	public boolean modificarTitulacion(String nombreAntiguo, String nombreNuevo) throws Exception {
		if (_fachada.existeTitulacion(nombreNuevo))
			throw new Exception("Ya existe una titulación.");
		return _fachada.modificacionTitulacion(nombreAntiguo, nombreNuevo);
	}

	
}
