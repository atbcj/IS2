package Usuarios;

import java.util.ArrayList;
import java.util.List;

public class AuxiliarProfesores {

	private List<Profesor> _profesores;

	public AuxiliarProfesores() {
		_profesores = new ArrayList<>();
	}

	// funciones CRUD: alta, baja, listado, actualizar
	public boolean altaProfesor(String nombre, String[] apellidos, String DNI, String correo) {

		// Verificar si ya existe un profesor con el mismo DNI
		if (existe(DNI)) {
			System.out.println("Ya existe un profesor con ese DNI.");
			return false;

		} else {
			// Crear un nuevo profesor y agregarlo a la lista
			Profesor nuevoProfesor = new Profesor(nombre, apellidos, DNI, correo);
			_profesores.add(nuevoProfesor);
			System.out.println("Profesor agregado exitosamente.");
			return true;
		}
	}

	public boolean bajaProfesor(String DNI) {

		// Buscar el profesor por DNI
		Profesor profesor = obtenerProfesorPorDNI(DNI);

		if (profesor != null) {
			// Eliminar al profesor de la lista
			_profesores.remove(profesor);
			System.out.println("Profesor eliminado exitosamente.");
			return true;
		} else {
			System.out.println("No existe ningún profesor con ese DNI.");
			return false;
		}
	}

	public void listadoProfesores() {
		// lista vacia
		if (_profesores.isEmpty()) {
			System.out.println("No hay profesores registrados.");
		} else {
			System.out.println("Listado de profesores:");

			for (Usuario profesor : _profesores) {
				System.out.println(profesor.toString());
			}
		}
	}

	public boolean actualizarProfesor(String DNI, String nombre, String[] apellidos, String correo) {

		// Buscar el profesor por DNI
		Profesor profesor = obtenerProfesorPorDNI(DNI);
		
		if (profesor != null) {
			
			// Actualizar los datos del profesor
			profesor.set_nombre(nombre);
			profesor.set_apellidos(apellidos);
			profesor.setCorreo(correo);
			System.out.println("Profesor actualizado exitosamente.");
			return true;
		} else {
			System.out.println("No existe ningún profesor con ese DNI.");
			return false;
		}
	}

	private boolean existe(String DNI) {
		// Verificar si existe un profesor con el mismo DNI en la lista
		for (Usuario profesor : _profesores) {
			if (profesor.get_DNI().equals(DNI)) {
				return true;
			}
		}
		return false;
	}

	private Profesor obtenerProfesorPorDNI(String DNI) {
		// Buscar un profesor por su DNI en la lista
		for (Profesor profesor : _profesores) {
			if (profesor.get_DNI().equals(DNI)) {
				return profesor;
			}
		}
		return null;
	}
}
