package capaIntegracion;

import clases.Titulacion;

public interface IFachadaDAOTitulacion {
	
	public boolean crearTitulacion(String nombre);

	public boolean eliminarTitulacion(String nombre);

	public boolean existeTitulacion(String nombre);

	public boolean modificacionTitulacion(String nombre, String nuevo);

	public Titulacion getTitulacion(String nombre);
}
