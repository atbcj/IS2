package capaIntegracion;

import clases.Asignatura;

public interface ISADADOAsignaturas {

	public boolean crearAsignatura(String nombre, int creditos, String codigo);

	public boolean eliminarAsignatura(String codigo);

	public boolean existeAsignatura(String codigo);

	public boolean existeAsignaturaNombre(String nombre);

	public boolean modificacionAsignatura(String c, String codigo, String nombre, int creditos);

	public Asignatura getAsignatura(String codigo);
}
