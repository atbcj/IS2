package Grupos;

import java.util.List;

import Usuarios.Alumno;

public class AuxiliarGrupos {
	
    List<Grupo> _grupos;

    public boolean altaGrupo(Character nombre) { 
    	if(comprueba_nombre(nombre)) {
    		if(existe_grupo(nombre)) {
    			System.out.println("Ya existe un grupo con ese nombre");
    			return false;
    		}else {
    			_grupos.add(new Grupo(nombre,null,null));
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
    
    public boolean actualizarGrupo(Character nombre, List<Alumno> alumnos) {
    	if(comprueba_nombre(nombre)) {
    		Grupo grupo = null;
    		for(Grupo g: _grupos)
        		if(g.get_nombre() == nombre) {
        			grupo = g;
        			break;
        	}
    		if(grupo != null) {
    			if(nombre == null && alumnos == null) {
    				System.out.println("Todos los argumentos son nulos");
    				return false;
    			}
    			if(nombre != null)
    				grupo.modifica_nombre(nombre);
    			if(alumnos != null)
    				for(Alumno a: alumnos)
    					grupo.añade_alumno(a);
    			return true;
    		}else {
    			System.out.println("No existe un grupo con ese nombre");
    			return false;
    		}
    	}else 
    		return false;
    }    

	public boolean visualizarAlumnos(Grupo grupo) {
		for(Alumno a: grupo.get_lista_alumnos())
			System.out.println(a);
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
}
