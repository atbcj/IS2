package JUnit;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import Usuarios.Profesor;

public class ProfesorTest {

    private Profesor profesor;

    @Before
    public void setUp() {
        String apellidos = "García Fernández";
        profesor = new Profesor("Juan", apellidos, "12345678A", "juan.garcia@example.com");
    }

    @Test
    public void testGetNombre() {
        assertEquals("Juan", profesor.getNombre());
    }

    @Test
    public void testSetNombre() {
        profesor.set_nombre("Carlos");
        assertEquals("Carlos", profesor.getNombre());
    }
}
