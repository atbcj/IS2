package Asignaturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import Cursos.Curso;
import Grupos.Grupo;
import Titulaciones.Titulacion;

public class Auxiliar {
	private List<Asignatura> _asignaturas;

	/*public Auxiliar() {
		this._asignaturas = new ArrayList<Asignatura>();
	}*/

	public boolean altaAsignatura(int creditos, String nombre, String codigo) {
		if (comprobarNombreyCreditos(creditos, nombre)) {
			if (!ExisteAsignatura(nombre)) {
				System.out.println("Introduce un código único de la asignatura: ");
				if (comprobarCodigo(codigo)) {
					Asignatura asignatura = new Asignatura(nombre, creditos, codigo, null);
					_asignaturas.add(asignatura);
					System.out.println("Asignatura agregada con éxito");
					return true;
				} else {
					System.out.println("El codigo no puede ser nulo");
					return false;
				}
			} else {
				System.out.println("Ya existe una asignatura con ese nombre");
				return false;
			}
		} else {
			System.out.println("El nombre y los creditos no son validos");
			return false;
		}
	}

	public boolean bajaAsignatura(String codigo) {
		if (comprobarCodigo(codigo)) {
			Asignatura asignatura = obtenerAsignaturaPorCodigo(codigo);
			if (asignatura != null) {
				if (asignatura.tieneGrupos()) {
					System.out.println("No se puede eliminar la asignatura porque tiene grupos asociados");
					return false;
				} else {
					_asignaturas.remove(asignatura);
					return true;
				}
			} else {
				System.out.println("No existe ninguna asignatura con ese código");
				return false;
			}
		}
		return false;
	}

	private Asignatura obtenerAsignaturaPorCodigo(String codigo) {
		for (Asignatura asignatura : _asignaturas) {
			if (asignatura.getCodigo().equals(codigo)) {
				return asignatura;
			}
		}
		return null;
	}

	public boolean comprobarNombreyCreditos(int creditos, String nombre) {
		if (creditos <= 0) {
			throw new IllegalArgumentException("Los créditos deben ser mayores que cero.");
		}
		if (nombre == null || nombre.isEmpty()) {
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

	public boolean ExisteAsignatura(String nombre) {
		for (Asignatura asignatura : _asignaturas) {
			if (asignatura.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	public boolean visualizarGrupos(Asignatura a) {
		for (Grupo o: a.getGrupos()) {
			System.out.println(o);
		}
		return true;
	}

	public boolean AsignarAsignatura(Titulacion t, Curso c, Asignatura s) {
		if (comprobarTitulacion(t) && comprobarCurso(c)) {
			if (c != null && t.getCursos().contains(c)) {
				c.añade_asignatura(s);
				return true;
			} else {
				System.out.println("El curso no está asociado con la titulación.");
				return false;
			}
		} else {
			System.out.println("Los datos no son correctos");
			return false;
		}

	}

	public boolean ActualizarAsignatura(int creditos, String nombre, String codigo, String nuevoCod, List<Grupo> grupos) {
		Asignatura a = obtenerAsignaturaPorCodigo(codigo);
		if (a != null) {
			if (comprobarNombreyCreditos(creditos, nombre) && comprobarCodigo(nuevoCod)) {
				a.setCreditos(creditos);
				a.setNombre(nombre);
				if (!grupos.isEmpty()) {
					a.setGrupos(grupos);
					return true;
				}
				else {
					System.out.println("La lista de grupos no puede estar vacia");
					return false;
				}
			} else {
				System.out.println("Los datos para actualizar no son validos");
				return false;
			}
		}
		else {
			System.out.println("La asignatura no existe");
			return false;
		}
		
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
}
