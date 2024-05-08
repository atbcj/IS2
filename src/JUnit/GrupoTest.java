package JUnit;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Grupos.Grupo;

import java.util.List;
import java.util.ArrayList;
import Usuarios.Alumno;
import Usuarios.Profesor;

public class GrupoTest {

    private Grupo grupo;
    private Alumno alumno;
    private Profesor profesor;

    @Before
    public void setUp() {
        // Inicializando las listas como nulas para que el constructor las maneje
        grupo = new Grupo('A', null, null);
        alumno = new Alumno("Juan","Garcia", "12345678A", "juan@example.com");
        profesor = new Profesor("Ana","Jimenez", "98765432B", "ana@example.com");
    }

    @Test
    public void testGetNombre() {
        assertEquals('A', grupo.get_nombre());
    }

    @Test
    public void testModificaNombre() {
        grupo.modifica_nombre('B');
        assertEquals('B', grupo.get_nombre());
    }

    @Test
    public void testAñadeAlumno() {
        // Asegurarse que la lista de alumnos es inicialmente vacía
        assertTrue(grupo.get_lista_alumnos().isEmpty());

        // Añadir un alumno y comprobar que se añade correctamente
        grupo.añade_alumno(alumno);
        assertTrue(grupo.get_lista_alumnos().contains(alumno));
        assertEquals(1, grupo.get_lista_alumnos().size());
    }

    @Test
    public void testAñadeProfesor() {
        // Asegurarse que la lista de profesores es inicialmente vacía
        assertTrue(grupo.get_lista_profesores().isEmpty());

        // Añadir un profesor y comprobar que se añade correctamente
        grupo.añade_profesor(profesor);
        assertTrue(grupo.get_lista_profesores().contains(profesor));
        assertEquals(1, grupo.get_lista_profesores().size());
    }
}
