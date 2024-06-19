package capaIntegracion;

import clases.Titulacion;

public class SADAOTitulacionImp implements ISADAOTitulacion{
	
	private Titulacion _titulacion;

	public SADAOTitulacionImp(Titulacion titulacion) {
		_titulacion = titulacion;
	}

	@Override
	public boolean crearTitulacion(String nombre) {
		_titulacion = new Titulacion(nombre, null);
		return true;
	}

	@Override
	public boolean eliminarTitulacion(String nombre) {
		if (_titulacion != null && _titulacion.getNombre().equals(nombre)) {
			_titulacion = null;
			return true;
		}
		return false;
	}

	@Override
	public boolean existeTitulacion(String nombre) {
		return _titulacion != null && _titulacion.getNombre().equals(nombre);
	}

	@Override
	public boolean modificacionTitulacion(String nombreAntiguo, String nombreNuevo) {
		if (_titulacion != null && _titulacion.getNombre().equals(nombreAntiguo)) {
			_titulacion.setNombre(nombreNuevo);
			return true;
		}
		return false;
	}

	@Override
	public Titulacion getTitulacion(String nombre) {
		 if (_titulacion != null && _titulacion.getNombre().equals(nombre)) {
	            return _titulacion;
	        }
	        return null;
	}

	
}
