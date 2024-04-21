package Asignaturas;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Grupos.Grupo;



public class Asignatura {
	private String[] _nombre;
	private List<Grupo> _grupos;
	private int _creditos;
	private String _codigo;
	private Map<Asignatura, List<Grupo>> _map;
	
	public Asignatura (String[] nombre, int creditos, String codigo, List<Grupo> grupos) {
		this._nombre = nombre;
		this._creditos = creditos;
		this._codigo = codigo;
		this._map = new HashMap<>();
	}
	
	public int getCreditos() {
		return this._creditos;
	}
	
	public String[] getNombre () {
		return this._nombre;
	}
	
	public String getCodigo() {
		return this._codigo;
	}
	
	public Grupo[] getGrupos() {
		return this.grupos;
	}
	
	public void setCreditos(int creditos) {
		this._creditos = creditos;
	}
	
	public void setNombre (String[] nombre) {
		this._nombre = nombre;
	}
	
	public void setCodigo(String codigo) {
		this._codigo = codigo;
	}
	
	public static void leerAsignaturas(JSONObject curso) {
	   JSONArray asignaturas = curso.getJSONArray("asignaturas");
	}
	    
}
