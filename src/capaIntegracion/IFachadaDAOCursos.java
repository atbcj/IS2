package capaIntegracion;

import clases.Curso;
import clases.Titulacion;

public interface IFachadaDAOCursos {

	public boolean crearCurso(int anio);

	public boolean eliminarCurso(int anio);

	public boolean existeCurso(int anio);

	public boolean modificacionCurso(int anioAntiguo, int anioNuevo);

	public Curso getCurso(int anio);
}
