package logicaNegocio;

import clases.Asignatura;
import clases.Grupo;

public interface SAAsignaturas {

	public boolean altaAsignatura(String nombre, int creditos, String codigo) throws Exception;

	public boolean bajaAsigantura(String codigo) throws Exception;

	public Asignatura consultaAsignatura(String codigo);

	public boolean modificacionAsignatura(String c, String codigo, String nombre, int creditos) throws Exception;

}
