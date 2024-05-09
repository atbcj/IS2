package Asignaturas;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Grupos.Grupo;

public class Asignatura {
    private String _nombre;
    private int _creditos;
    private String _codigo;
    private List<Grupo> _grupos;

    public Asignatura(String nombre, int creditos, String codigo, List<Grupo> grupos) {
        this._nombre = nombre;
        this._creditos = creditos;
        this._codigo = codigo;
        if (grupos == null) {
        	this._grupos = new ArrayList<>();
        }
        else {
        	this._grupos = grupos;
        }
    }

    public int getCreditos() {
        return this._creditos;
    }

    public String getNombre() {
        return this._nombre;
    }

    public String getCodigo() {
        return this._codigo;
    }

    public boolean tieneGrupos() {
        return !_grupos.isEmpty();
    }

    public void asociarGrupos(List<Grupo> l) {
        for(Grupo g: l)
        	if(!_grupos.contains(g))
        		_grupos.add(g);
    }

    public List<Grupo> getGrupos() {
        return this._grupos;
    }

    public void setCreditos(int creditos) {
        this._creditos = creditos;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this._codigo = codigo;
    }

	public void setGrupos(List<Grupo> grupos) {
		this._grupos = grupos;
		
	}
	public void aniadirGrupo (Grupo g) {
		this._grupos.add(g);
	}
	
	public JSONObject saveData() {
		JSONObject jo = new JSONObject();
		jo.put("codigo", _codigo);
		jo.put("nombre", _nombre);
		jo.put("creditos", _creditos);
		
		JSONArray ja = new JSONArray();
		for(Grupo g: _grupos) {
			ja.put(g.saveData());
		}
		
		jo.put("grupos", ja);
		
		return jo;
	}
}
