package capaIntegracion;

import clases.Profesor;

public interface IFachadaDAOProfesores {
		
	public boolean altaProfesor(String[] datos);
	
	public boolean bajaProfesor(String DNI);
	
	public boolean existeProfesor(String DNI);
	
	public boolean modificacionProfesor(String[] datos);
	
	public Profesor getProfesor(String DNI);
	
}