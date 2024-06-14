package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Grupo;
import clases.Alumno;

public class GrupoTest {

    @Test
    public void testGrupoConstructor() {
        Grupo grupo = new Grupo('A', null, null);
        assertEquals('A', grupo.get_nombre());
        assertTrue(grupo.get_lista_alumnos().isEmpty());
        assertTrue(grupo.get_lista_profesores().isEmpty());
    }

    @Test
    public void testAñadeAlumno() {
        Grupo grupo = new Grupo('A', null, null);
        Alumno alumno = new Alumno("John", "Doe", "1234", "john.doe@example.com");
        grupo.añade_alumno(alumno);
        assertTrue(grupo.get_lista_alumnos().contains(alumno));
    }
}
