package clases;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Curso {
	
	private int _anio;
	private List<Asignatura> _lista_asignaturas;
	
	public Curso(int anio,List<Asignatura> lista) {
		_anio = anio;
		_lista_asignaturas = lista;
	}
	
	public int get_anio() {
		return _anio;
	}
	
	public void modifica_anio(int nuevo_anio) {
		if (nuevo_anio <= 0) {
	        throw new IllegalArgumentException("El año debe ser mayor que 0.");
	    }
	    _anio = nuevo_anio;
	}
	
	public List<Asignatura> get_lista_asignaturas(){
		return _lista_asignaturas;
	}
	
	public void añade_asignatura(Asignatura a) {
	    if (a == null) {
	        throw new IllegalArgumentException("La asignatura no puede ser nula.");
	    }
	    if (!_lista_asignaturas.contains(a)) {
	        _lista_asignaturas.add(a);
	    } else {
	        System.out.println("La asignatura ya está en la lista.");
	    }
	}
	
	public void elimina_asignatura(Asignatura a) {
	    if (a != null && _lista_asignaturas.contains(a)) {
	        _lista_asignaturas.remove(a);
	    }
	}
	
	public boolean contiene_asignatura(Asignatura a) {
	    return _lista_asignaturas.contains(a);
	}
	 public Asignatura buscar(String codigo) {
		 for (Asignatura a: this._lista_asignaturas) {
			 if (a.getCodigo().equals(codigo)) {
				 return a;
			 }
		 }
		 return null;
	 }
	
	public int contar_asignaturas() {
	    return _lista_asignaturas.size();
	}
	
	public Asignatura obtener_asignatura(int indice) {
	    if (indice >= 0 && indice < _lista_asignaturas.size()) {
	        return _lista_asignaturas.get(indice);
	    }
	    return null;
	}

	public JSONObject saveData() {
		JSONObject jo = new JSONObject();
		jo.put("anio", _anio);
		
		JSONArray ja = new JSONArray();
		for(Asignatura a: _lista_asignaturas) {
			ja.put(a.saveData());
		}
		
		jo.put("asignaturas", ja);
		
		return jo;
	}

	public Asignatura getAsignatura(String nombre) {
		Asignatura asignatura = null;
		for(Asignatura a: _lista_asignaturas)
			if(a.getNombre().equals(nombre))
				asignatura = a;
		return asignatura;
	}
	
	public Asignatura getAsignaturaCodigo(String codigo) {
		Asignatura asignatura = null;
		for(Asignatura a: _lista_asignaturas)
			if(a.getCodigo().equals(codigo))
				asignatura = a;
		return asignatura;
	}
	
	
}
