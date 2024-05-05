package Titulaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Cursos.Curso;

public class Titulacion {
    private Map<Titulacion, List<Curso>> _mapTitulacion;
    private String[] _nombre;

    public Titulacion(String[] nombre) {
        this._mapTitulacion = new HashMap<>();
        this._nombre = nombre;
    }

    public Map<Titulacion, List<Curso>> getMapaTitulacionCursos() {
        return this._mapTitulacion;
    }

    public void setMapaTitulacionCursos(Map<Titulacion, List<Curso>> mapaTitulacionCursos) {
        this._mapTitulacion = mapaTitulacionCursos;
    }
    
    public List<Curso> getCursos() {
        return this._mapTitulacion.get(this);
    }
    
    public String[] getNombre() {
    	return this._nombre;
    }
    
    public boolean tieneCursos() {
        List<Curso> cursos = this._mapTitulacion.get(this);
        return cursos != null && !cursos.isEmpty();
    }

	public void setNombre(String[] nombre) {
		this._nombre = nombre;
	}
}
