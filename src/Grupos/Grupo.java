package Grupos;

import java.util.LinkedList;

import java.util.List;

import Usuarios.Alumno;
import Usuarios.Profesor;

public class Grupo {
	
	private char _nombre;
	private List<Alumno> _lista_alumnos;
	private List<Profesor> _lista_profesores;
	
	public Grupo(char nombre, List<Alumno> listal, List<Profesor> listpr) {
		_nombre = nombre;
		if(listal == null)
			_lista_alumnos = new LinkedList<>();
		else
			_lista_alumnos = listal;
		if(listpr == null)
			_lista_profesores = new LinkedList<>();
		else
			_lista_profesores = listpr;
	}
	
	public char get_nombre() {
		return _nombre;
	}
	
	public List<Alumno> get_lista_alumnos(){
		return _lista_alumnos;
	}
	
	public List<Profesor> get_lista_profesores(){
		return _lista_profesores;
	}
	
	public void modifica_nombre(Character nombre) {
		if(nombre != null)
			_nombre = nombre;
	}
	
	public void añade_alumno(Alumno a) {
		if(!_lista_alumnos.contains(a))
			_lista_alumnos.add(a);
	}
	
	public void añade_profesor(Profesor p) {
		if(!_lista_profesores.contains(p))
			_lista_profesores.add(p);
	}
	
	public void elimina_alumno(Alumno a) {
		if(_lista_alumnos.contains(a))
			_lista_alumnos.remove(a);
	}
	
	public void elimina_profesor(Profesor p) {
		if(!_lista_profesores.contains(p))
			_lista_profesores.remove(p);
	}
}
