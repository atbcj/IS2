package Factorias;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Asignaturas.Asignatura;
import Controller.Controller;
import Cursos.Curso;
import Titulaciones.Titulacion;

public class CursoBuilder extends Builder<Curso> {
	
	private Controller _ctrl;
	private AsignaturaBuilder asignatura;
	
	public CursoBuilder(Controller control) {
        super("Curso", "Builder para la clase Curso ");
        _ctrl = control;
        asignatura = new AsignaturaBuilder(_ctrl);
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
