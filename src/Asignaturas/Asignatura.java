package Asignaturas;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Asignatura {
	private String[] _nombre;
	private int _creditos;
	private String _codigo;
	
	public Asignatura (String[] nombre, int creditos, String codigo) {
		this._nombre = nombre;
		this._creditos = creditos;
		this._codigo = codigo;
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
