package Grupos;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Alumnos.Alumno;
import Asignaturas.Asignatura;
import Profesores.Profesor;

public class Grupo {
	private char _n;
	private String _nombre;
	private Map<Asignatura, List<Alumno>> _mapa_alumnos;
	private Map<Asignatura, List<Profesor>> _mapa_profesores;
	private List<Asignatura> lista_asignaturas;
	
	public Grupo(String nombre){
		_nombre = nombre;
	}
	
	public void cargaAlumnos(Asignatura a, Alumno al) {
		if(!_mapa_alumnos.containsKey(a)) {
			List<Alumno> lista_vacia = new LinkedList<Alumno>();
			_mapa_alumnos.put(a, lista_vacia);
		}
		List<Alumno> lista = _mapa_alumnos.get(a);
		lista.add(al);
		_mapa_alumnos.put(a, lista);
	}
	
	public void cargaProfesores(Asignatura a, Profesor p) {
		if(!_mapa_alumnos.containsKey(a)) {
			List<Profesor> lista_vacia = new LinkedList<Profesor>();
			_mapa_profesores.put(a, lista_vacia);
		}
		List<Profesor> lista = _mapa_profesores.get(a);
		lista.add(p);
		_mapa_profesores.put(a, lista);
	}
	
	public List<Asignatura> getListadoDeAsignaturas(){
		return lista_asignaturas;
	}
	
	public String getNombre() {
		return _nombre;
	}
}
