package logicaNegocio;

import clases.Titulacion;

public class FachadaTitulacionImp implements IFachadaTitulacion{
	
	private SATitulacionImp _saTitulacionesImp;

	public FachadaTitulacionImp(Titulacion titulacion) {
		_saTitulacionesImp = new SATitulacionImp(titulacion);
	}

	@Override
	public boolean altaTitulacion(String nombre) throws Exception {
		return _saTitulacionesImp.altaTitulacion(nombre);
	}

	@Override
	public boolean bajaTitulacion(String nombre) throws Exception {
		return _saTitulacionesImp.bajaTitulacion(nombre);
	}

	@Override
	public Titulacion consultarTitulacion(String nombre) throws Exception {
		return _saTitulacionesImp.consultarTitulacion(nombre);
	}

	@Override
	public boolean modificarTitulacion(String nombreAntiguo, String nombreNuevo) throws Exception {
		return _saTitulacionesImp.modificarTitulacion(nombreAntiguo, nombreNuevo);
	}
}
