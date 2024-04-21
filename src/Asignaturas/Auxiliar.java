package Asignaturas;
import java.util.Scanner;

public class Auxiliar {
    ListadoAsignaturas _asignaturas;
    
    public boolean altaAsignatura(int creditos, String[] nombre) {
        if (comprobarDatos(creditos, nombre)) {
            Scanner lectura = new Scanner(System.in);

            if (ExisteAsignatura(nombre)) {
                System.out.println("Introduce un código único de la asignatura: ");
                String codigo = lectura.next();
                if (comprobarCodigo(codigo)) {
                Asignatura asignatura = new Asignatura(nombre, creditos, codigo, null);
                _asignaturas.addAsignatura(asignatura);
                System.out.println("Asignatura agregada con éxito");
                }
            }
            else {
            	System.out.println("Ya existe una asignatura con ese nombre");
            }
            lectura.close();
            return true;
        } else {
            return false;
        }
    }


    public boolean bajaAsignatura(String codigo) {
        if (comprobarCodigo(codigo)) {
        	if (ExisteCodigo(codigo)) {
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
		return false;
        
    }
    
    public boolean comprobarDatos(int creditos, String[] nombre) {
        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser mayores que cero.");
        }
        if (nombre == null || nombre.length == 0) {
            throw new IllegalArgumentException("Debe proporcionarse al menos un nombre.");
        }
        return true;
    }

    
    public boolean comprobarCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }
        return true;
    }

    
    public boolean ExisteAsignatura(String[] nombre) {
    	int i = 0;
    	boolean ok = false;
    	 while (i < this._asignaturas.getAsignaturas().size() && !ok) {
    		 if (this._asignaturas.getAsignaturas().get(i).getNombre().equals(nombre)) 
    			 ok = true;
    	 }
    		 return ok;
    }
    
    public boolean ExisteCodigo(String codigo) {
    	int i = 0;
    	boolean ok = false;
    	 while (i < this._asignaturas.getAsignaturas().size() && !ok) {
    		 if (this._asignaturas.getAsignaturas().get(i).getCodigo().equals(codigo)) 
    			 ok = true;
    	 }
    		 return ok;
    }
    
    public boolean visualizarAsignaturas(Titulacion titulacion) {
    	if (titulacion == null || titulacion.isEmpty()) {
    		throw new IllegalArgumentException("La titulacion no puede ser nula o ser vacia ");
    	}
    	else {
    		Scanner lectura = new Scanner(System.in);
    		// MOSTRAR LOS CURSOS QUE  TIENE LA TITULACION
    		for (Curso curso: titulacion.getCursos()) {
    			// MOSTRAR LOS CURSOS DISPONIBLES
    			
    		}
    		System.out.println("Elige el curso para visualizar el listado de asignaturas: ");
    		String c = lectura.next();
    	}
    	return false;
    }
    
    public boolean actualizarAsignatura (Titulacion titulacion, Curso curso) {
    	
    }
}
