package Titulaciones;


import java.util.ArrayList;
import java.util.List;

public class AuxiliarTitulaciones {
    private List<Titulacion> titulaciones;

    public AuxiliarTitulaciones() {
        this.titulaciones = new ArrayList<>();
    }

    public boolean altaTitulacion(Titulacion titulacion) {
        if (titulacion != null && !titulaciones.contains(titulacion)) {
            titulaciones.add(titulacion);
            return true;
        }
        return false;
    }

    public boolean bajaTitulacion(Titulacion titulacion) {
        if (titulacion != null && titulaciones.contains(titulacion)) {
            titulaciones.remove(titulacion);
            return true;
        }
        return false;
    }

    public Titulacion buscarTitulacion(String[] nombreTitulacion) {
        for (Titulacion titulacion : titulaciones) {
            if (titulacion.getNombre().equals(nombreTitulacion)) {
                return titulacion;
            }
        }
        return null;
    }

    public boolean actualizarTitulacion(Titulacion t, String[] nombre) {
    	 if (comprobarNombre(nombre)) {
             t.setNombre(nombre);
             return true;
         } else {
             return false;
         }
    }
    
    public boolean visualizarTitulaciones () {
    	for (Titulacion t: titulaciones) {
    		System.out.println(t.toString());
    	}
    	return true;
    }

	private boolean comprobarNombre(String[] nombre) {
		 if (nombre == null) {
	            throw new IllegalArgumentException("La titulacion no puede ser nula o ser vacia ");
	        }
	        return true;
	}
}
