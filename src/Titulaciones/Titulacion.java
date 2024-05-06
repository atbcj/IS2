package Titulaciones;

import java.util.LinkedList;
import java.util.List;

import Cursos.Curso;

public class Titulacion {
    private List<Curso> _listTitulacion;
    private String _nombre;

    public Titulacion(String nombre, List<Curso> lista) {
        this._listTitulacion = lista;
        this._nombre = nombre;
    }

    public List<Curso> getListaTitulacionCursos() {
        return this._listTitulacion;
    }

    public void setMapaTitulacionCursos(List<Curso> listaTitulacionCursos) {
        this._listTitulacion = listaTitulacionCursos;
    }
    
    public List<Curso> getCursos() {
        return this._listTitulacion;
    }
    
    public String getNombre() {
    	return this._nombre;
    }
    
    public boolean tieneCursos() {
        return _listTitulacion != null && !_listTitulacion.isEmpty();
    }

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
}
