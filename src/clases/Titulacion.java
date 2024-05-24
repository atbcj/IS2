package clases;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Titulacion {
    private List<Curso> _listTitulacion;
    private String _nombre;

    public Titulacion(String nombre, List<Curso> lista) {
        this._listTitulacion = lista;
        if(lista == null)
    		_listTitulacion = new LinkedList<Curso>();
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
	
	public JSONObject saveData() {
		JSONObject jo = new JSONObject();
		jo.put("nombre", _nombre);
		
		JSONArray ja = new JSONArray();
		if(!_listTitulacion.isEmpty())
			for(Curso c: _listTitulacion) {
				ja.put(c.saveData());
			}
		
		jo.put("cursos", ja);
		return jo;
	}

	public Curso getCurso(String nombre) {
		Curso curso = null;
		for(Curso c: _listTitulacion)
			if(String.valueOf(c.get_anio()).equals(nombre))
				curso = c;
		return curso;
	}
}
