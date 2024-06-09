package clases;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Titulacion {
	private List<Curso> _listCursos;
	private String _nombre;

	public Titulacion(String nombre, List<Curso> lista) {
		this._listCursos = lista;
		if (lista == null)
			_listCursos = new LinkedList<Curso>();
		this._nombre = nombre;
	}

	public List<Curso> getListaTitulacionCursos() {
		return this._listCursos;
	}

	public void setMapaTitulacionCursos(List<Curso> listaTitulacionCursos) {
		this._listCursos = listaTitulacionCursos;
	}
	
	public void añade_curso(Curso c) {
		if (!_listCursos.contains(c))
			_listCursos.add(c);
	}

	public List<Curso> getCursos() {
		return this._listCursos;
	}

	public String getNombre() {
		return this._nombre;
	}

	public boolean tieneCursos() {
		return _listCursos != null && !_listCursos.isEmpty();
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public JSONObject saveData() {
		JSONObject jo = new JSONObject();
		jo.put("nombre", _nombre);

		JSONArray ja = new JSONArray();
		if (!_listCursos.isEmpty())
			for (Curso c : _listCursos) {
				ja.put(c.saveData());
			}

		jo.put("cursos", ja);
		return jo;
	}

	public Curso getCurso(String nombre) {
		Curso curso = null;
		for (Curso c : _listCursos)
			if (String.valueOf(c.get_anio()).equals(nombre))
				curso = c;
		return curso;
	}

}
