package Alumnos;

import Usuarios.Tupla;
import Usuarios.Alumno;

public class CRUD {
	public void altaAlumno() {
		
	}
	
	public void bajaAlumno(Alumno alumno) {
		
	}
	
	public void mostrarAlumno(Alumno alumno) {
		if(alumno != null) {
			mostrar(alumno); //Función de la GUI para mostrar al usuario
		}
	}
	
	public void mostrarListaAlumnos(Tupla condicion, Alumno[] listado) {
		for(Alumno a : listado) {
			if(a.getTupla() == condicion){
				mostrar(a); //Función de la GUI para mostrar al usuario
			}
		}
	}
	
	public void modificarAlumno(Alumno alumno) {
		if(alumno != null) {
			
		}
	}
}
