package clases;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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

    public boolean existen_grupos() {
        return !_grupos.isEmpty();
    }

    public void añade_grupos(List<Grupo> l) {
        for(Grupo g: l)
        	if(!_grupos.contains(g))
        		_grupos.add(g);
    }

    public List<Grupo> getGrupos() {
        return this._grupos;
    }

    public void modifica_creditos(int creditos) {
        this._creditos = creditos;
    }

    public void modifica_nombre(String nombre) {
        this._nombre = nombre;
    }

    public void modifica_codigo(String codigo) {
        this._codigo = codigo;
    }

	public void modifica_grupos(List<Grupo> grupos) {
		this._grupos = grupos;
		
	}
	public void añade_grupo (Grupo g) {
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

	public Grupo getGrupo(String nombre) {
		Grupo grupo = null;
		for(Grupo g: _grupos)
			if(String.valueOf(g.get_nombre()).equals(nombre))
				grupo = g;
		return grupo;
	}
}
