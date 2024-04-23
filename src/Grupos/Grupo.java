package Grupos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Alumnos.Alumno;
import Asignaturas.Asignatura;

public class Grupo {
	private char _nombre;
	private Map<Asignatura, List<Alumno>> _mapa_alumnos;
	private List<Asignatura> _lista_asignaturas;
	
	public Grupo(char nombre) {
		_nombre = nombre;
		_mapa_alumnos = new HashMap<>();
		_lista_asignaturas = new LinkedList<>();
	}
	
	public char get_nombre() {
		return _nombre;
	}
	
	public List<Alumno> get_lista_alumnos(Asignatura a){
		return _mapa_alumnos.get(a);
	}
	
	public List<Asignatura> get_lista_asignaturas(){
		return _lista_asignaturas;
	}
	
	public void modifica_nombre(Character nombre) {
		_nombre = nombre;
	}
}
