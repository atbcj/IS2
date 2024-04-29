package Titulaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Cursos.Curso;

public class Titulacion {
    private Map<Titulacion, List<Curso>> _mapTitulacion;

    public Titulacion() {
        this._mapTitulacion = new HashMap<>();
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
    
    public boolean tieneCursos() {
        List<Curso> cursos = this._mapTitulacion.get(this);
        return cursos != null && !cursos.isEmpty();
    }
}
