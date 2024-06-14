package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Curso;
import clases.Asignatura;
import java.util.ArrayList;
import java.util.List;

public class CursoTest {

    @Test
    public void testCursoConstructor() {
        List<Asignatura> asignaturas = new ArrayList<>();
        Curso curso = new Curso(3, asignaturas);
        assertEquals(3, curso.get_anio());
        assertTrue(curso.get_lista_asignaturas().isEmpty());
    }

    @Test
    public void testAñadeAsignatura() {
        Curso curso = new Curso(3, null);
        Asignatura asignatura = new Asignatura("Matematicas", 6, "MATH101", null);
        curso.añade_asignatura(asignatura);
        assertTrue(curso.get_lista_asignaturas().contains(asignatura));
    }
}
