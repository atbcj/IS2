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
		if(nombre != null)
			_nombre = nombre;
	}
	
	public void añade_asignatura(Asignatura a) {
		if(!_mapa_alumnos.containsKey(a)) {
			_lista_asignaturas.add(a);
			List<Alumno> lista_vacia = new LinkedList<>();
			_mapa_alumnos.put(a, lista_vacia);
		}
	}
	
	public boolean tiene_asignatura(Asignatura a) {
		return _mapa_alumnos.containsKey(a);
	}
	
	public void añade_alumno(Alumno al, Asignatura a) {
		if(!_mapa_alumnos.containsKey(a)) {
			_lista_asignaturas.add(a);
			List<Alumno> lista_vacia = new LinkedList<>();
			_mapa_alumnos.put(a, lista_vacia);
		}
		List<Alumno> lista = _mapa_alumnos.get(a);
		lista.add(al);
		_mapa_alumnos.put(a, lista);
	}
}
