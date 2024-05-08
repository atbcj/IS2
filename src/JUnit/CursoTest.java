package JUnit;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import Asignaturas.Asignatura;
import Cursos.Curso;
import Grupos.Grupo;

public class CursoTest {

    private Curso curso;
    private Asignatura asignatura;

    @Before
    public void setUp() {
        // Crear una asignatura con los parámetros actualizados
        String[] nombreAsignatura = {"Matemática Discreta 1"};
        List<Grupo> grupos = new ArrayList<>(); // Sin grupos inicialmente
        asignatura = new Asignatura(nombreAsignatura, 6, "MDL1", grupos);

        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(asignatura);
        curso = new Curso(2023, asignaturas);
    }

    @Test
    public void testGetAnio() {
        assertEquals(2023, curso.get_anio());
    }

    @Test
    public void testModificaAnio() {
        curso.modifica_anio(2024);
        assertEquals(2024, curso.get_anio());
    }

    @Test
    public void testAñadeAsignatura() {
        String[] nombreNuevaAsignatura = {"Física"};
        Asignatura nuevaAsignatura = new Asignatura(nombreNuevaAsignatura, 4, "FIS1", new ArrayList<>());
        curso.añade_asignatura(nuevaAsignatura);
        assertTrue(curso.get_lista_asignaturas().contains(nuevaAsignatura));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModificaAnioConAñoInvalido() {
        curso.modifica_anio(0);
    }
}
