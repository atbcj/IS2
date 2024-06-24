package capaIntegracion;

import clases.Titulacion;
import presentacion.Controller;

public class SADAOTitulacionImp implements ISADAOTitulacion{
	
	private Controller _ctrl;

	public SADAOTitulacionImp(Controller control) {
		_ctrl = control;
	}

	@Override
	public boolean crearTitulacion(String nombre) {
		_ctrl.getTitulaciones().add(new Titulacion(nombre, null));
		return true;
	}

	@Override
	public boolean eliminarTitulacion(String nombre) {
		Titulacion tit = null;
		
		for(Titulacion t :_ctrl.getTitulaciones()) {
			if(t.getNombre().equals(nombre)) {
				tit = t;
			}
		}
		if(tit.getListaTitulacionCursos().isEmpty()) {
			_ctrl.getTitulaciones().remove(tit);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean existeTitulacion(String nombre) {
		for(Titulacion t :_ctrl.getTitulaciones()) {
			if(t.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificacionTitulacion(String nombreAntiguo, String nombreNuevo) {
		for(Titulacion t :_ctrl.getTitulaciones()) {
			if(t.getNombre().equals(nombreAntiguo)) {
				t.setNombre(nombreNuevo);
			}
		}
		return true;
	}

	@Override
	public Titulacion getTitulacion(String nombre) {
		for(Titulacion t :_ctrl.getTitulaciones()) {
			if(t.getNombre().equals(nombre)) {
				return t;
			}
		}
		return null;
	}
}
