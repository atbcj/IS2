package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Profesor;

public class ProfesorTest {

    @Test
    public void testProfesorConstructor() {
        Profesor profesor = new Profesor("Dr. Smith", "Johnson", "5678", "dr.smith@example.com");
        assertEquals("Dr. Smith", profesor.getNombre());
        assertEquals("Johnson", profesor.get_apellidos());
        assertEquals("5678", profesor.get_DNI());
        assertEquals("dr.smith@example.com", profesor.getCorreo());
    }

    @Test
    public void testProfesorSetters() {
        Profesor profesor = new Profesor("Dr. Smith", "Johnson", "5678", "dr.smith@example.com");
        profesor.set_nombre("Dr. John");
        profesor.set_apellidos("Smith");
        profesor.set_DNI("8765");
        profesor.setCorreo("dr.john@example.com");
        assertEquals("Dr. John", profesor.getNombre());
        assertEquals("Smith", profesor.get_apellidos());
        assertEquals("8765", profesor.get_DNI());
        assertEquals("dr.john@example.com", profesor.getCorreo());
    }
}
