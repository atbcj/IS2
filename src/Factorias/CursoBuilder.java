package Factorias;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Cursos.Curso;
import Titulaciones.Titulacion;

public class CursoBuilder extends Builder<Curso> {
	
	private AsignaturaBuilder asignatura;
	
	public CursoBuilder() {
        super("Curso", "Builder para la clase Curso ");
    }

	@Override
	protected Curso create_instance(JSONObject data) throws JSONException, Exception {
		int anio = data.getInt("anio");
		JSONArray array = data.getJSONArray("asignaturas");
		List<Asignatura> lista = new LinkedList();
		for(int i = 0; i< array.length(); i++) {
			lista.add(asignatura.create_instance(array.getJSONObject(i)));
		}
        return new Curso(anio,lista);
	}
}
