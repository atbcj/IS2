package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Titulacion;
import clases.Curso;
import java.util.ArrayList;
import java.util.List;

public class TitulacionTest {

    @Test
    public void testTitulacionConstructor() {
        List<Curso> cursos = new ArrayList<>();
        Titulacion titulacion = new Titulacion("Ingeniería", cursos);
        assertEquals("Ingeniería", titulacion.getNombre());
        assertTrue(titulacion.getListaTitulacionCursos().isEmpty());
    }

    @Test
    public void testAñadeCurso() {
        Titulacion titulacion = new Titulacion("Ingeniería", null);
        Curso curso = new Curso(3, null);
        titulacion.añade_curso(curso);
        assertTrue(titulacion.getListaTitulacionCursos().contains(curso));
    }

    @Test
    public void testSetNombre() {
        Titulacion titulacion = new Titulacion("Ingeniería", null);
        titulacion.setNombre("Arquitectura");
        assertEquals("Arquitectura", titulacion.getNombre());
    }

    @Test
    public void testTieneCursos() {
        List<Curso> cursos = new ArrayList<>();
        Titulacion titulacion = new Titulacion("Ingeniería", cursos);
        assertFalse(titulacion.tieneCursos());

        Curso curso = new Curso(3, null);
        titulacion.añade_curso(curso);
        assertTrue(titulacion.tieneCursos());
    }

    @Test
    public void testGetCurso() {
        Curso curso1 = new Curso(3, null);
        Curso curso2 = new Curso(4, null);
        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        Titulacion titulacion = new Titulacion("Ingeniería", cursos);

        assertEquals(curso1, titulacion.getCurso("3"));
        assertEquals(curso2, titulacion.getCurso("4"));
        assertNull(titulacion.getCurso("5"));
    }
}
