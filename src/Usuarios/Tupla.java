package Usuarios;

public class Tupla {
	
	private String _grado;
	private String _curso;
	private String _asignatura;
	private String _grupo;
	public Tupla(String grado, String curso, String asignatura, String grupo) {
		_grado = grado;
		_curso = curso;
		_asignatura = grupo;
		_grupo = asignatura;
	}
	
	public String getGrado() {
		return _grado;
	}
	
	public String getcurso() {
		return _curso;
	}
	
	public String getAsignatura() {
		return _asignatura;
	}
	
	public String getGrupo() {
		return _grupo;
	}
	
	public void setGrado(String grado) {
		this._grado = grado;
	}
	
	public void setCurso(String curso) {
		this._curso = curso;
	}
	
	public void setAsignatura(String asignatura) {
		this._asignatura = asignatura;
	}
	
	public void setGrupo(String grupo) {
		this._grupo = grupo;
	}
	
	public String toString() {
		return _grado + " " + _curso + " " + _asignatura + " " + _grupo;
	}
}
