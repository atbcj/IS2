package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
import Usuarios.AuxiliarProfesores;
import Usuarios.Profesor;
import Cursos.*;
import Asignaturas.Asignatura;
import Asignaturas.Auxiliar;
import Grupos.AuxiliarGrupos;

public class Controller {
	/* loaddata,alta,baja,mod,consulta; */

	private List<Titulacion> titulaciones = new LinkedList<>();
	private AuxiliarAlumnos auxAlumnos = new AuxiliarAlumnos();
	private Auxiliar auxAsignaturas = new Auxiliar();
	private AuxiliarGrupos auxGrupos = new AuxiliarGrupos();
	private AuxiliarProfesores auxP = new AuxiliarProfesores();
	private AuxiliarCursos auxCursos = new AuxiliarCursos();

	public void loadData(JSONObject database) throws Exception {
		JSONArray titulacion = database.getJSONArray("titulaciones");
		TitBuilder factoria = new TitBuilder();
		if (titulacion != null) {
			for (int i = 0; i < titulacion.length(); i++) {
				JSONObject tit = titulacion.getJSONObject(i);
				titulaciones.add(factoria.create_instance(tit));
			}
		}
	}

	public void saveData(FileOutputStream out) {
		JSONObject jo = new JSONObject();
		
		JSONArray ja = new JSONArray();
		for(Titulacion t: titulaciones) {
			ja.put(t.saveData());
		}
		
		jo.put("titulaciones", ja);
		
		PrintStream p = new PrintStream(out);
		p.print(jo.toString(2));
	}

	public void run() {

	}

	public void altaAlumno(Alumno a) {
		auxAlumnos.altaAlumno(a);
	}

	public void altaGrupo(String titulacion, String curso, String asignatura, String nombre) {
		for (Titulacion t : titulaciones) {
			if (t.getNombre().equals(titulacion))
				for (Curso c : t.getCursos())
					if (String.valueOf(c.get_anio()).equals(curso))
						for (Asignatura a : c.get_lista_asignaturas())
							if (a.getNombre().equals(asignatura)) {
								auxGrupos.altaGrupo(nombre.charAt(0));
								a.asociarGrupos(auxGrupos.getListaGrupos());
							}
		}
	}
	public void bajaGrupo(String titulacion, String curso, String asignatura, String nombre) {
		for (Titulacion t : titulaciones) {
			if (t.getNombre().equals(titulacion))
				for (Curso c : t.getCursos())
					if (String.valueOf(c.get_anio()).equals(curso))
						for (Asignatura a : c.get_lista_asignaturas())
							if (a.getNombre().equals(asignatura)) {
								auxGrupos.bajaGrupo(nombre.charAt(0));
								a.asociarGrupos(auxGrupos.getListaGrupos());
							}
		}
	}

	// alta de profesor
	public void altaProfesor(Profesor prof) {
		auxP.altaProfesor(prof.getNombre(), prof.get_apellidos(), prof.get_DNI(), prof.getCorreo());
	}
	
	
	public List<Titulacion> getLista() {
		return Collections.unmodifiableList(this.titulaciones);
	}

	public void altaAsignatura(String nombre, int creditos, String codigo, String curso, String titulacion) {
		for (Titulacion t : titulaciones) {
			if (t.getNombre().equals(titulacion))
				for (Curso c : t.getCursos())
					if (String.valueOf(c.get_anio()).equals(curso))
						c.añade_asignatura(new Asignatura(nombre, creditos, codigo, null));

		}
	}
	
	public boolean altaCurso(int anio) {
	    return auxCursos.altaCurso(anio);
	}
	
	public Alumno buscarAlumno(String dni) {
		return auxAlumnos.buscarAlumno(dni);
	}

	public void eliminarAlumno(Alumno al) {
		auxAlumnos.bajaAlumno(al);
	}

	

}
