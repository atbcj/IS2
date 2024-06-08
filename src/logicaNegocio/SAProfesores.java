package logicaNegocio;

import clases.Profesor;

public interface SAProfesores {

	public boolean altaProfesor(String[] datos) throws Exception;

	public boolean bajaProfesor(String DNI) throws Exception;

	public Profesor consultarProfesor(String DNI);

	public boolean modificarProfesor(String[] datos) throws Exception;
}
