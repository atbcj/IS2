package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clases.Alumno;

public class AlumnoTest {
    
    @Test
    public void testAlumnoConstructor() {
        Alumno alumno = new Alumno("John", "Doe", "1234", "john.doe@example.com");
        assertEquals("John", alumno.getNombre());
        assertEquals("Doe", alumno.get_apellidos());
        assertEquals("1234", alumno.get_DNI());
        assertEquals("john.doe@example.com", alumno.getCorreo());
    }

    @Test
    public void testAlumnoSetters() {
        Alumno alumno = new Alumno("John", "Doe", "1234", "john.doe@example.com");
        alumno.set_nombre("Jane");
        alumno.set_apellidos("Smith");
        alumno.set_DNI("4321");
        alumno.setCorreo("jane.smith@example.com");
        assertEquals("Jane", alumno.getNombre());
        assertEquals("Smith", alumno.get_apellidos());
        assertEquals("4321", alumno.get_DNI());
        assertEquals("jane.smith@example.com", alumno.getCorreo());
    }
}
