package presentacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import builders.TitBuilder;
import clases.Titulacion;

public class Controller {
	
	List<Titulacion> _titulaciones;

	public Controller(JSONObject data) throws JSONException, Exception {
		_titulaciones = new LinkedList<Titulacion>();
		JSONArray titulacion = data.getJSONArray("titulaciones");
		TitBuilder factoria = new TitBuilder();
		if (titulacion != null) {
			for (int i = 0; i < titulacion.length(); i++) {
				JSONObject tit = titulacion.getJSONObject(i);
				Titulacion titulation= factoria.create_instance(tit);
				_titulaciones.add(titulation);
			}
		}
	}

	public void save_data() throws FileNotFoundException {
		
		JSONObject jo = new JSONObject();
		
		JSONArray ja = new JSONArray();
		for(Titulacion t: _titulaciones) {
			ja.put(t.saveData());
		}
		
		jo.put("titulaciones", ja);
		
		PrintStream p = new PrintStream(new FileOutputStream(new File("examples/in.json")));
		p.print(jo.toString(2));
		
	}
	
	public List<Titulacion> getTitulaciones(){
		return _titulaciones;
	}
	
	public Titulacion getTitulacion(String nombre) {
		Titulacion tit = null;
		for(Titulacion t: _titulaciones)
			if(t.getNombre().equals(nombre))
				tit = t;
		return tit;
	}

}
