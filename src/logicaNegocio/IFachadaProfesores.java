package logicaNegocio;

import clases.Profesor;

public interface IFachadaProfesores {

	public boolean altaProfesor(String[] datos) throws Exception;

	public boolean bajaProfesor(String DNI) throws Exception;

	public Profesor consultarProfesor(String DNI) throws Exception;

	public boolean modificarProfesor(String[] datos) throws Exception;
}
