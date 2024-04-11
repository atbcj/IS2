package Asignaturas;
import java.util.Scanner;

public class Auxiliar {
    ListadoAsignaturas _asignaturas;

    public boolean altaAsignatura(int creditos, String[] nombre) {
        if (creditos <= 0 || nombre == null) {
            throw new IllegalArgumentException("El nombre o los creditos no puede ser nulo");
        } else {
            Scanner lectura = new Scanner(System.in);
            boolean ok = true;

            for (Asignatura asignatura : this._asignaturas.getAsignaturas()) {
                if (asignatura.getNombre().equals(nombre)) {
                    ok = false;
                    System.out.println("Ya existe una asignatura con ese nombre");
                    break;
                }
            }

            if (ok) {
                System.out.println("Introduce un codigo unico de la asignatura: ");
                String codigo = lectura.next();
                Asignatura asignatura = new Asignatura(nombre, creditos, codigo);
                _asignaturas.addAsignatura(asignatura);
                System.out.println("Asignatura agregada con éxito");
            }

            lectura.close();
            return ok;
        }
    }

    public boolean bajaAsignatura(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
        	throw new IllegalArgumentException("El codigo de la asignatura no puede ser nulo ni vacio");
        } else {
        	boolean ok = false;
        	Asignatura a = null;
        	 for (Asignatura asignatura : this._asignaturas.getAsignaturas()) {
        		 if (asignatura.getCodigo().equals(codigo)) {
        			 ok = true;
        			 a = asignatura;
        			 break;
        		 }
        	 }
        	if (true) {
        		// COMPROBAR SI LA ASIGNATURA TIENE GRUPOS ASOCIADOS
        		/*if (this._asignaturas.getAsignaturas().getGrupos().isEmpty()) {
        			this._asignaturas.getAsignaturas().remove(a);
        			return true;
        		} else {
        			System.out.println("No se puede eliminar la asignatura porque tiene grupos asociados");
        			return false;
        		}*/
        	}
        	else {
        		System.out.println("No existe ninguna asignatura con ese codigo");
        		return false;
        	}
        }
        
    }
    /*public boolean visualizarAsignaturas(Titulacion titulacion) {
    	if (titulacion == null) {
    		throw new IllegalArgumentException("La titulacion no puede ser nula");
    	}
    	else {
    		
    	}
    	return false;
    }*/
}
