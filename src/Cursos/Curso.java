package Cursos;


import java.util.List;
import java.util.ArrayList;

import Asignaturas.Asignatura;

public class Curso {
	
	private int _anio;
	private List<Asignatura> _lista_asignaturas;
	
	public Curso(int anio,List<Asignatura> lista) {
		_anio = anio;
		_lista_asignaturas = lista;
	}
	
	public int get_anio() {
		return _anio;
	}
	
	public void modifica_anio(int nuevo_anio) {
		if (nuevo_anio <= 0) {
	        throw new IllegalArgumentException("El año debe ser mayor que 0.");
	    }
	    _anio = nuevo_anio;
	}
	
	public List<Asignatura> get_lista_asignaturas(){
		return _lista_asignaturas;
	}
	
	public void añade_asignatura(Asignatura a) {
	    if (a == null) {
	        throw new IllegalArgumentException("La asignatura no puede ser nula.");
	    }
	    if (!_lista_asignaturas.contains(a)) {
	        _lista_asignaturas.add(a);
	    } else {
	        System.out.println("La asignatura ya está en la lista.");
	    }
	}
	
	public void elimina_asignatura(Asignatura a) {
	    if (a != null && _lista_asignaturas.contains(a)) {
	        _lista_asignaturas.remove(a);
	    }
	}
	
	public boolean contiene_asignatura(Asignatura a) {
	    return _lista_asignaturas.contains(a);
	}

	
	public int contar_asignaturas() {
	    return _lista_asignaturas.size();
	}
	
	public Asignatura obtener_asignatura(int indice) {
	    if (indice >= 0 && indice < _lista_asignaturas.size()) {
	        return _lista_asignaturas.get(indice);
	    }
	    return null;
	}


	
	
}
