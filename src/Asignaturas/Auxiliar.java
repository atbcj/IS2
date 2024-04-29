package Asignaturas;

import java.util.List;
import java.util.Scanner;

import Cursos.Curso;
import Titulaciones.Titulacion;

public class Auxiliar {
	ListadoAsignaturas _asignaturas;

	public boolean altaAsignatura(int creditos, String[] nombre) {
		if (comprobarNombreyCreditos(creditos, nombre)) {
			Scanner lectura = new Scanner(System.in);

			if (ExisteAsignatura(nombre)) {
				System.out.println("Introduce un código único de la asignatura: ");
				String codigo = lectura.next();
				if (comprobarCodigo(codigo)) {
					Asignatura asignatura = new Asignatura(nombre, creditos, codigo, null);
					_asignaturas.addAsignatura(asignatura);
					System.out.println("Asignatura agregada con éxito");
				}
			} else {
				System.out.println("Ya existe una asignatura con ese nombre");
			}
			lectura.close();
			return true;
		} else {
			return false;
		}
	}

	public boolean bajaAsignatura(String codigo) {
		Asignatura asignatura = null;
		if (comprobarCodigo(codigo)) {
			if (ExisteCodigo(codigo)) {
				asignatura = obtenerAsignaturaPorCodigo(codigo);
				// COMPROBAR SI LA ASIGNATURA TIENE GRUPOS ASOCIADOS
				if (asignatura.tieneGrupos())
					System.out.println("No se puede eliminar la asignatura porque tiene grupos asociados");
				return false;
			} else {
				this._asignaturas.getAsignaturas().remove(asignatura);
				return true;
			}
		} else {
			System.out.println("No existe ninguna asignatura con ese codigo");
			return false;
		}
	}

	private Asignatura obtenerAsignaturaPorCodigo(String codigo) {
		for (Asignatura asignatura : this._asignaturas.getAsignaturas()) {
			if (asignatura.getCodigo().equals(codigo)) {
				return asignatura;
			}
		}
		return null;
	}

	public boolean comprobarNombreyCreditos(int creditos, String[] nombre) {
		if (creditos <= 0) {
			throw new IllegalArgumentException("Los créditos deben ser mayores que cero.");
		}
		if (nombre == null || nombre.length == 0) {
			throw new IllegalArgumentException("Debe proporcionarse al menos un nombre.");
		}
		return true;
	}

	public boolean comprobarCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new IllegalArgumentException("El código no puede ser nulo o vacío");
		}
		return true;
	}

	public boolean ExisteAsignatura(String[] nombre) {
		int i = 0;
		boolean ok = false;
		while (i < this._asignaturas.getAsignaturas().size() && !ok) {
			if (this._asignaturas.getAsignaturas().get(i).getNombre().equals(nombre))
				ok = true;
		}
		return ok;
	}

	public boolean ExisteCodigo(String codigo) {
		int i = 0;
		boolean ok = false;
		while (i < this._asignaturas.getAsignaturas().size() && !ok) {
			if (this._asignaturas.getAsignaturas().get(i).getCodigo().equals(codigo))
				ok = true;
		}
		return ok;
	}

	public boolean comprobarTitulacion(Titulacion titulacion) {
		if (titulacion == null) {
			throw new IllegalArgumentException("La titulacion no puede ser nula o ser vacia ");
		}
		return true;
	}

	public boolean comprobarCurso(Curso c) {
		if (c == null) {
			throw new IllegalArgumentException("El curso no puede ser nulo o ser vacio");
		}
		return true;
	}

	public boolean visualizarAsignaturas(Titulacion titulacion) {
		Scanner lectura = new Scanner(System.in);
		Curso aux = null;
		if (comprobarTitulacion(titulacion)) {
			for (Curso curso : titulacion.getCursos()) {
				System.out.println("Elige el curso para visualizar el listado de asignaturas: \n" + curso.toString());
			}
			String c = lectura.next();
			// Verificar si el curso ingresado es válido para esta titulación
			boolean cursoValido = false;
			for (Curso curso : titulacion.getCursos()) {
				if (curso.toString().equals(c)) {
					cursoValido = true;
					aux = curso;
					break;
				}
			}
			if (cursoValido) {
				System.out.println(aux.get_lista_asignaturas().toString());
				return true;
			} else {
				System.out.println("El curso seleccionado no es válido para esta titulación.");
				return false;
			}
		} else {
			System.out.println("La titulacion seleccionada no es valida");
			return false;
		}
	}

	public boolean AsignarAsignatura(Titulacion t, Curso c, Asignatura s) {
		if (comprobarTitulacion(t) && comprobarCurso(c)) {
			List<Curso> cursos = t.getMapaTitulacionCursos().get(t);
			if (cursos != null && cursos.contains(c)) {
				c.añade_asignatura(s);
				return true;
			} else {
				System.out.println("El curso no está asociado con la titulación.");
				return false;
			}
		} else {
			System.out.println("La titulación o el curso proporcionados no son válidos.");
			return false;
		}
	}

	public boolean ActualizarAsignatura(int creditos, String[] nombre, Asignatura a) {
		if (comprobarNombreyCreditos(creditos, nombre)) {
			a.setCreditos(creditos);
			a.setNombre(nombre);
			return true;
		}
		else 
			return false; 

	}

}
