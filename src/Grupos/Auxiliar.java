package Grupos;
import java.util.List;
import java.util.Scanner;

import Asignaturas.Asignatura;

public class Auxiliar {
	
    List<Grupo> _grupos;

    public boolean altaGrupo(Character nombre) { 
    	if(comprueba_nombre(nombre)) {
    		if(existe_grupo(nombre)) {
    			System.out.println("Ya existe un grupo con ese nombre");
    			return false;
    		}else {
    			_grupos.add(new Grupo(nombre));
    			return true;
    		}
    	}else 
    		return false;
    }

    public boolean bajaGrupo(Character nombre) {
    	if(comprueba_nombre(nombre)) {
    		Grupo grupo = null;
    		for(Grupo g: _grupos)
        		if(g.get_nombre() == nombre) {
        			grupo = g;
        			break;
        	}
    		if(grupo != null) {
    			_grupos.remove(grupo);
    			return true;
    		}else {
    			System.out.println("No existe un grupo con ese nombre");
    			return false;
    		}
    	}else
    		return false;
    }
    
    public boolean actualizarGrupo(Asignatura a, Character nombre) {
    	if(comprueba_nombre(nombre)) {
    		Grupo grupo = null;
    		for(Grupo g: _grupos)
        		if(g.get_nombre() == nombre) {
        			grupo = g;
        			break;
        	}
    		if(grupo != null) {
    			modifica_grupo(grupo, a);
    			return true;
    		}else {
    			System.out.println("No existe un grupo con ese nombre");
    			return false;
    		}
    	}else 
    		return false;
    }    

	public boolean visualizarGrupos(Asignatura asignatura) {
    	return true;
    }
    
    private boolean comprueba_nombre(Character nombre) {
    	if(nombre == null||nombre.toString().isBlank())
    		throw new IllegalArgumentException("El nombre del grupo proporcionado no puede ser nulo no vacio");
    	return true;
    }
    
    private boolean existe_grupo(Character nombre) {
    	for(Grupo g: _grupos)
    		if(g.get_nombre() == nombre)
    			return false;
    	return true;
    }
    
    @SuppressWarnings("resource")
	private void modifica_grupo(Grupo grupo, Asignatura a) {
    	boolean completado = false;
    	Scanner lectura = new Scanner(System.in);
    	System.out.println("Elige opción:");
    	System.out.println("\tNombre - Cambia el nombre del grupo seleccionado.");
    	System.out.println("\tElimina - Elimina la asignatura proporcionada del grupo seleccionado.");
    	System.out.println("\tAñade - Añade la asignatura proporcionadad al grupo seleccionado.");
    	String opcion = lectura.next();
    	switch (opcion.toUpperCase()) {
    		case "NOMBRE":{
    			String nombre = lectura.next();
    			if(nombre.length()==1) {
    				Character n = nombre.charAt(0);
    				if(comprueba_nombre(n)) {
    					grupo.modifica_nombre(n);
    					completado = true;
    				}
    			}
    			break;
    		}
    		case "ELIMINA":{break;}
    		case "AÑADE":{break;}
    		default:{System.out.println("La opcion introducida por teclado no es válida"); break;}
    	}
    	
    	if(completado)
			System.out.println("La operacion ha terminado con exito");
		else
			System.out.println("La operacion ha fallado");
	}
}
