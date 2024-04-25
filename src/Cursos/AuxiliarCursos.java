package Cursos;

import java.util.*;

import Asignaturas.Asignatura;

public class AuxiliarCursos {
    
    private List<Curso> _cursos;

    public AuxiliarCursos() {
        _cursos = new ArrayList<>();
    }

    public boolean altaCurso(int anio) {
        if (existe_curso(anio)) {
            System.out.println("Ya existe un curso para ese año");
            return false;
        } else {
            _cursos.add(new Curso(anio));
            return true;
        }
    }
    
    public boolean bajaCurso(int anio) {
        Curso curso = obtenerCursoPorAnio(anio);
        if (curso != null) {
            _cursos.remove(curso);
            return true;
        } else {
            System.out.println("No existe un curso para ese año");
            return false;
        }
    }
    
    public boolean actualizarCurso(int anio, Integer nuevo_anio, Asignatura nueva_asignatura) {
        Curso curso = obtenerCursoPorAnio(anio);
        if (curso != null) {
            if (nuevo_anio != null) {
                curso.modifica_anio(nuevo_anio);
            }
            if (nueva_asignatura != null) {
                curso.añade_asignatura(nueva_asignatura);
            }
            return true;
        } else {
            System.out.println("No existe un curso para ese año");
            return false;
        }
    }
    
    public void visualizarCursos() {
        if (_cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles");
        } else {
            for (Curso curso : _cursos) {
                System.out.println("Curso para el año: " + curso.get_anio());
            }
        }
    }
    
    private boolean existe_curso(int anio) {
        return obtenerCursoPorAnio(anio) != null;
    }

    private Curso obtenerCursoPorAnio(int anio) {
        for (Curso curso : _cursos) {
            if (curso.get_anio() == anio) {
                return curso;
            }
        }
        return null;
    }

}

