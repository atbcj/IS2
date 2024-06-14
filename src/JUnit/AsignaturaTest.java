package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Asignatura;
import clases.Grupo;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaTest {

    @Test
    public void testAsignaturaConstructor() {
        List<Grupo> grupos = new ArrayList<>();
        Asignatura asignatura = new Asignatura("Matematicas", 6, "MATH101", grupos);
        assertEquals("Matematicas", asignatura.getNombre());
        assertEquals(6, asignatura.getCreditos());
        assertEquals("MATH101", asignatura.getCodigo());
        assertTrue(asignatura.getGrupos().isEmpty());
    }

    @Test
    public void testAñadeGrupo() {
        Asignatura asignatura = new Asignatura("Matematicas", 6, "MATH101", null);
        Grupo grupo = new Grupo('A', null, null);
        asignatura.añade_grupo(grupo);
        assertTrue(asignatura.getGrupos().contains(grupo));
    }
}

