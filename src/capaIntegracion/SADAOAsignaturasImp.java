package capaIntegracion;

import clases.Asignatura;
import clases.Curso;
import clases.Grupo;

public class SADAOAsignaturasImp implements ISADADOAsignaturas {

	private Curso _curso;

	public SADAOAsignaturasImp(Curso curso) {
		_curso = curso;
	}

	@Override
	public boolean crearAsignatura(String nombre, int creditos, String codigo) {
		_curso.añade_asignatura(new Asignatura(nombre, creditos, codigo, null));
		return true;
	}

	@Override
	public boolean eliminarAsignatura(String codigo) {
		Asignatura asignatura = null;
		asignatura = _curso.buscar(codigo);
		if (asignatura.getGrupos().isEmpty()) {
			_curso.get_lista_asignaturas().remove(asignatura);
			return true;
		} else
			return false;
	}

	@Override
	public boolean existeAsignatura(String codigo) {
		for (Asignatura a : _curso.get_lista_asignaturas()) {
			if (String.valueOf(a.getCodigo()).equals(codigo))
				return true;
		}
		return false;
	}

	@Override
	public boolean modificacionAsignatura(String c, String codigo, String nombre, int creditos) {
		for (Asignatura a : _curso.get_lista_asignaturas()) {
			if (String.valueOf(a.getCodigo()).equals(c)) {
				if (codigo != null) {
					a.modifica_codigo(codigo);
				}
				if (creditos != -1) {
					a.modifica_creditos(creditos);
				}
				if (nombre != null) {
					a.modifica_nombre(nombre);
				}
				return true;
			}
		}
		return true;

	}

	@Override
	public Asignatura getAsignatura(String codigo) {
		for (Asignatura a : _curso.get_lista_asignaturas()) {
			if (String.valueOf(a.getCodigo()).equals(codigo))
				return a;
		}
		return null;
	}

	@Override
	public boolean existeAsignaturaNombre(String nombre) {
		for (Asignatura a : _curso.get_lista_asignaturas()) {
			if (String.valueOf(a.getNombre()).equals(nombre))
				return true;
		}
		return false;
	}

}
