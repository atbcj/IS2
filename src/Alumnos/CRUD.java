package Alumnos;

import Usuarios.Tupla;

import java.util.List;

import Usuarios.Alumno;

public class CRUD {
	
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
	
	public void mostrarAlumno(Alumno alumno) {
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
