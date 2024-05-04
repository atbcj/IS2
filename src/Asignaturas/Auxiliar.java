package Asignaturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import Cursos.Curso;
import Titulaciones.Titulacion;

public class Auxiliar {
    private List<Asignatura> _asignaturas;
    
    public Auxiliar () {
        this._asignaturas = new ArrayList<Asignatura>();
    }

    public boolean altaAsignatura(int creditos, String[] nombre) {
        if (comprobarNombreyCreditos(creditos, nombre)) {
            try (Scanner lectura = new Scanner(System.in)) {
                if (ExisteAsignatura(nombre)) {
                    System.out.println("Introduce un código único de la asignatura: ");
                    String codigo = lectura.next();
                    if (comprobarCodigo(codigo)) {
                        Asignatura asignatura = new Asignatura(nombre, creditos, codigo, null);
                        _asignaturas.add(asignatura);
                        System.out.println("Asignatura agregada con éxito");
                        return true;
                    }
                } else {
                    System.out.println("Ya existe una asignatura con ese nombre");
                }
            }
        }
        return false;
    }

    public boolean bajaAsignatura(String codigo) {
        if (comprobarCodigo(codigo)) {
            Asignatura asignatura = obtenerAsignaturaPorCodigo(codigo);
            if (asignatura != null) {
                if (asignatura.tieneGrupos()) {
                    System.out.println("No se puede eliminar la asignatura porque tiene grupos asociados");
                    return false;
                } else {
                    _asignaturas.remove(asignatura);
                    return true;
                }
            } else {
                System.out.println("No existe ninguna asignatura con ese código");
                return false;
            }
        }
        return false;
    }

    private Asignatura obtenerAsignaturaPorCodigo(String codigo) {
        for (Asignatura asignatura : _asignaturas) {
            if (asignatura.getCodigo().equals(codigo)) {
                return asignatura;
            }
        }
        return null;
    }

    public boolean comprobarNombreyCreditos(int creditos, String[] nombre) {
        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser mayores que cero.");
        }
        if (nombre == null || nombre.length == 0) {
            throw new IllegalArgumentException("Debe proporcionarse al menos un nombre.");
        }
        return true;
    }

    public boolean comprobarCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }
        return true;
    }

    public boolean ExisteAsignatura(String[] nombre) {
        for (Asignatura asignatura : _asignaturas) {
            if (Arrays.equals(asignatura.getNombre(), nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean visualizarAsignaturas(Titulacion titulacion) {
        try (Scanner lectura = new Scanner(System.in)) {
            if (comprobarTitulacion(titulacion)) {
                for (Curso curso : titulacion.getCursos()) {
                    System.out.println("Elige el curso para visualizar el listado de asignaturas: \n" + curso.toString());
                }
                String c = lectura.next();
                // Verificar si el curso ingresado es válido para esta titulación
                boolean cursoValido = false;
                for (Curso curso : titulacion.getCursos()) {
                    if (curso.toString().equals(c)) {
                        cursoValido = true;
                        System.out.println(curso.get_lista_asignaturas().toString());
                        break;
                    }
                }
                if (!cursoValido) {
                    System.out.println("El curso seleccionado no es válido para esta titulación.");
                }
                return cursoValido;
            } else {
                System.out.println("La titulacion seleccionada no es valida");
                return false;
            }
        }
    }

    public boolean AsignarAsignatura(Titulacion t, Curso c, Asignatura s) {
        if (comprobarTitulacion(t) && comprobarCurso(c)) {
            List<Curso> cursos = t.getMapaTitulacionCursos().get(c);
            if (cursos != null && cursos.contains(c)) {
                c.añade_asignatura(s);
                return true;
            } else {
                System.out.println("El curso no está asociado con la titulación.");
            }
        }
        return false;
    }

    public boolean ActualizarAsignatura(int creditos, String[] nombre, Asignatura a) {
        if (comprobarNombreyCreditos(creditos, nombre)) {
            a.setCreditos(creditos);
            a.setNombre(nombre);
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarTitulacion(Titulacion titulacion) {
        if (titulacion == null) {
            throw new IllegalArgumentException("La titulacion no puede ser nula o ser vacia ");
        }
        return true;
    }

    public boolean comprobarCurso(Curso c) {
        if (c == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo o ser vacio");
        }
        return true;
    }
}
