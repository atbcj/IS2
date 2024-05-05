package Asignaturas;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Grupos.Grupo;

public class Asignatura {
	private String[] _nombre;
	private int _creditos;
	private String _codigo;
	private Map<Asignatura, List<Grupo>> _map;

	public Asignatura(String[] nombre, int creditos, String codigo, List<Grupo> grupos) {
		this._nombre = nombre;
		this._creditos = creditos;
		this._codigo = codigo;
		this._map = new HashMap<>();
	}

	public int getCreditos() {
		return this._creditos;
	}

	public String[] getNombre() {
		return this._nombre;
	}

	public String getCodigo() {
		return this._codigo;
	}

	public boolean tieneGrupos() {
		return !this._map.get(this).isEmpty();
	}

	public void asociarGrupos(List<Grupo> l) {
		this._map.put(this, l);
	}

	public List<Grupo> getGrupos() {
		return this._map.get(this);
	}

	public List<Grupo> getGrupos(Asignatura a) {
		return this._map.get(a);
	}

	public void setCreditos(int creditos) {
		this._creditos = creditos;
	}

	public void setNombre(String[] nombre) {
		this._nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this._codigo = codigo;
	}

}
