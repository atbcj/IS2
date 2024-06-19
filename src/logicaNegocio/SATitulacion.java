package logicaNegocio;

import clases.Titulacion;

public interface SATitulacion {
	
	boolean altaTitulacion(String nombre) throws Exception;

	boolean bajaTitulacion(String nombre) throws Exception;

	Titulacion consultarTitulacion(String nombre) throws Exception;

	boolean modificarTitulacion(String nombreAntiguo, String nombreNuevo) throws Exception;
}
