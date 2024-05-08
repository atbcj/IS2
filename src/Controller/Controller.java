package Controller;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;
import Factorias.TitBuilder;
import Grupos.Grupo;
import Titulaciones.Titulacion;
import Usuarios.Alumno;
import Usuarios.AuxiliarAlumnos;
import Cursos.Curso;
import Asignaturas.Asignatura;

public class Controller {
	/*loaddata,alta,baja,mod,consulta;*/
	
	private List<Titulacion> titulaciones = new LinkedList<>();
	private AuxiliarAlumnos auxA = new AuxiliarAlumnos();
	
	public void loadData(JSONObject database) throws Exception {
		JSONArray titulacion = database.getJSONArray("titulaciones");
		TitBuilder factoria = new TitBuilder();
		if(titulacion != null) {
			for(int i = 0; i < titulacion.length(); i++) {
				JSONObject tit = titulacion.getJSONObject(i);
				factoria.create_instance(tit);  //crear builder de titulaciones
			}
		}
	}
	
	public void saveData(FileOutputStream out) {
		
	}
	
	public void run() {
		
	}

	public void altaAlumno(Alumno a) {
		auxA.altaAlumno(a);
	}
	
	public void altaGrupo(String titulacion, String curso, String asignatura, String nombre) {
		for(Titulacion t: titulaciones) {
			if(t.getNombre().equals(titulacion))
				for(Curso c: t.getCursos())
					if(String.valueOf(c.get_anio()).equals(curso))
						for(Asignatura a: c.get_lista_asignaturas())
							if(a.getNombre().equals(asignatura))
								a.aniadirGrupo(new Grupo(nombre.charAt(0), null, null));
							
						
		}
	}
	
	public List<Titulacion> getLista(){
		return Collections.unmodifiableList(this.titulaciones);
	}
}
