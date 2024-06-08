package builders;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import clases.Asignatura;
import clases.Grupo;

public class AsignaturaBuilder extends Builder<Asignatura> {

	private GrupoBuilder grupo = new GrupoBuilder();

	public AsignaturaBuilder() {
		super(".", ".");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Asignatura create_instance(JSONObject data) throws JSONException, Exception {
		String codigo = data.getString("codigo");
		String nombre = data.getString("nombre");
		int creditos = data.getInt("creditos");
		JSONArray array = data.getJSONArray("grupos");
		List<Grupo> lista = new LinkedList<Grupo>();
		for (int i = 0; i < array.length(); i++) {
			lista.add(grupo.create_instance(array.getJSONObject(i)));
		}
		Asignatura a = new Asignatura(nombre, creditos, codigo, lista);
		return a;
	}

}
