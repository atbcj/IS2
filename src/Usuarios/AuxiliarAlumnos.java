package Usuarios;

import java.util.List;

public abstract class AuxiliarAlumnos {
	private List<Alumno> alumnos;
	
	public void altaAlumno(Alumno alumno) {
		if(!alumnos.contains(alumno)) {
			alumnos.add(alumno);
		}
	}
	
	public void bajaAlumno(Alumno alumno) {
		if(alumnos.contains(alumno)) {
			alumnos.remove(alumno);
		}
	}
	
	private void mostrarAlumno(Alumno alumno) {
		if(alumno != null) {
			mostrarAlumno(alumno); //Función de la GUI para mostrar al usuario
		}
	}
	
	public void mostrarListaAlumnos(Tupla condicion) {
		for(Alumno a : alumnos) {
			if(a.getTupla() == condicion){
				mostrarAlumno(a); //Función de la GUI para mostrar al usuario
			}
		}
	}
	
	public void mostrarListaAlumnos(String condicion) {
		for(Alumno a : alumnos) {
			for(Tupla i: a.getTupla()) {
				if(i.getGrupo() == condicion) {
					mostrarAlumno(a); //Función de la GUI para mostrar al usuario
				}else if(i.getCurso() == condicion) {
					mostrarAlumno(a);
				}else if(i.getGrado() == condicion) {
					mostrarAlumno(a);
				}
			}
		}
	}
	
	public void modificarAlumno(Alumno alumno) {
		if(alumno != null) {
			//sacar panel de opciones de que se quiere cambiar(Grado,Curso,Asignatura,Grupo)
			// o (DNI,correo,nombre)
			
		}
	}
}
