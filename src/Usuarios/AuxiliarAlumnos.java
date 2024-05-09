package Usuarios;

import java.util.LinkedList;
import java.util.List;

public class AuxiliarAlumnos {
	private List<Alumno> alumnos;

	public AuxiliarAlumnos() {
		alumnos = new LinkedList<>();
	}

	public void altaAlumno(Alumno alumno) {
		boolean existe = false;
		int i = 0;

		while (i < alumnos.size() && !existe) {
			Alumno a = alumnos.get(i);
			if (a.equals(alumno)) {
				existe = true;
			}
			i++;
		}
		if (!existe) {
			alumnos.add(alumno);
		}
	}

	public void bajaAlumno(Alumno alumno) {
		if (alumnos.contains(alumno)) {
			alumnos.remove(alumno);
		}
	}

	public void mostrarAlumno(Alumno alumno) {
		if (alumno != null) {
			mostrarAlumno(alumno); // Función de la GUI para mostrar al usuario
		}
	}

	public void mostrarListaAlumnos(Tupla condicion) {
		for (Alumno a : alumnos) {
			if (a.getTupla() == condicion) {
				mostrarAlumno(a); // Función de la GUI para mostrar al usuario
			}
		}
	}

	public void mostrarListaAlumnos(String condicion) {
		for (Alumno a : alumnos) {
			for (Tupla i : a.getTupla()) {
				if (i.getGrupo() == condicion) {
					mostrarAlumno(a); // Función de la GUI para mostrar al usuario
				} else if (i.getCurso() == condicion) {
					mostrarAlumno(a);
				} else if (i.getGrado() == condicion) {
					mostrarAlumno(a);
				}
			}
		}
	}

	public void modificarAlumno(Alumno alumno) {
		if (alumno != null) {
			// sacar panel de opciones de que se quiere
			// cambiar(Grado,Curso,Asignatura,Grupo)
			// o (DNI,correo,nombre)

		}
	}

	public Alumno buscarAlumno(String DNI) {
		int i = 0;
		boolean encontrado = false;
		while(i < alumnos.size() && !encontrado) {
			if(alumnos.get(i).get_DNI().equals(DNI)) {
				encontrado = true;
			}
			i++;
		}
		if(encontrado) {
			return alumnos.get(i-1);
		}
		else {
			return null;
		}
	}
}
