package logicaNegocio;

import clases.Curso;

public interface IFachadaCursos {

	boolean altaCurso(int anio) throws Exception;

	boolean bajaCurso(int anio) throws Exception;

	Curso consultarCurso(int anio) throws Exception;

	boolean modificarCurso(int anioAntiguo, int anioNuevo) throws Exception;

}
