package logicaNegocio;

import clases.Asignatura;

public interface IFachadaAsignaturas {
	
	boolean altaAsignatura(String nombre, int creditos, String codigo) throws Exception;
	
	boolean bajaAsignatura(String codigo) throws Exception;
	
	Asignatura consultarAsignatura(String codigo) throws Exception;
	
	boolean modificarAsignatura(String c, String codigo, String nombre, int creditos) throws Exception;
}
