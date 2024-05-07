package Controller;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factorias.Factory;
import Factorias.TitBuilder;
import Titulaciones.Titulacion;
import Usuarios.Usuario;

public class Controller {
	/*loaddata,alta,baja,mod,consulta;*/
	
	List<Titulacion> titulaciones = new LinkedList<>();
	
	public void loadData(JSONObject database) throws Exception {
		JSONArray titulacion = database.getJSONArray("titulaciones");
		TitBuilder factoria = new TitBuilder();
		if(titulacion != null) {
			for(int i = 0; i < titulacion.length(); i++) {
				JSONObject tit = titulacion.getJSONObject(i);
				factoria.create_instance(tit);  //crear builder de titulaciones
				//falta añadir el alumno a la lista general de alumnos y a la lista específica de cada asignatura,grupo y curso
			}
		}
	}
	
	public void saveData(JSONObject database) {
		
	}
}
