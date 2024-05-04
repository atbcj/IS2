package Factorias;

import org.json.JSONException;
import org.json.JSONObject;

import Cursos.Curso;

public class CursoBuilder extends Builder<Curso> {
	
	public CursoBuilder() {
        super("Curso", "Builder para la clase Curso ");
    }

	@Override
	protected Curso create_instance(JSONObject data) throws JSONException, Exception {
		int anio = data.getInt("anio");
        Curso curso = new Curso(anio);
        
        return curso;
	}
}
