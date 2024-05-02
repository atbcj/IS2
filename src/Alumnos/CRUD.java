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
			mostrar(alumno); //Función de la GUI para mostrar al usuario
		}
	}
	
	public void mostrarListaAlumnos(Tupla condicion) {
		for(Alumno a : alumnos) {
			if(a.getTupla() == condicion){
				mostrar(a); //Función de la GUI para mostrar al usuario
			}
		}
	}
	
	public void mostrarListaAlumnos(String condicion) {
		for(Alumno a : alumnos) {
			for(Tupla i: a.getTupla()) {
				if(i.getGrupo() == condicion) {
					mostrar(a); //Función de la GUI para mostrar al usuario
				}else if(i.getCurso() == condicion) {
					mostrar(a);
				}else if(i.getGrado() == condicion) {
					mostrar(a);
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
