package Cursos;


import java.util.List;
import java.util.ArrayList;

import Alumnos.Alumno;
import Asignaturas.Asignatura;

public class Curso {
	
	private int _anio;
	private List<Asignatura> _lista_asignaturas;
	
	public Curso(int anio) {
		_anio = anio;
		_lista_asignaturas = new ArrayList<>();
	}
	
	public char get_anio() {
		return _anio;
	}
	
	public List<Asignatura> get_lista_asignaturas(){
		return _lista_asignaturas;
	}
	
	
}
