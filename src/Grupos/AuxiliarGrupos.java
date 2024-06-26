package Grupos;

import java.util.LinkedList;
import java.util.List;

import Usuarios.Alumno;
import Usuarios.Profesor;

import is2.ViewUtils;

public class AuxiliarGrupos {
	
    public List<Grupo> _grupos = new LinkedList<Grupo>();

    public boolean altaGrupo(Character nombre) {
    	if(comprueba_nombre(nombre)) {
    		if(existe_grupo(nombre)) {
    			ViewUtils.showErrorMsg("Ya existe un grupo con ese nombre");
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
        		if(Character.compare(g.get_nombre(), nombre.charValue()) == 0) {
        			grupo = g;
        			break;
        	}
    		if(grupo != null) {
    			if(grupo.get_lista_alumnos().isEmpty() && grupo.get_lista_profesores().isEmpty()) {
    				_grupos.remove(grupo);
        			return true;
    			}else {
    				ViewUtils.showErrorMsg("No se puede eliminar un grupo si todavia hay alumnos o profesores en él");
        			return false;
    			}
    				
    		}else {
    			ViewUtils.showErrorMsg("No existe un grupo con ese nombre");
    			return false;
    		}
    	}else
    		return false;
    }
    
    public boolean actualizarGrupo(Character nombre, List<Alumno> alumnos, List<Profesor> profesores) {
    	if(comprueba_nombre(nombre)) {
    		Grupo grupo = null;
    		for(Grupo g: _grupos)
        		if(Character.valueOf(g.get_nombre()).equals(nombre)) {
        			grupo = g;
        			break;
        	}
    		if(grupo != null) {
    			if(nombre == null && alumnos == null && profesores == null) {
    				ViewUtils.showErrorMsg("Todos los argumentos son nulos");
    				return false;
    			}
    			if(nombre != null)
    				grupo.modifica_nombre(nombre);
    			if(alumnos != null)
    				for(Alumno a: alumnos)
    					grupo.añade_alumno(a);
    			if(profesores != null)
    				for(Profesor p: profesores)
    					grupo.añade_profesor(p);
    			return true;
    		}else {
    			ViewUtils.showErrorMsg("No existe un grupo con ese nombre");
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
	
	public boolean visualizarProfesores(Grupo grupo) {
		for(Profesor p: grupo.get_lista_profesores())
			System.out.println(p);
    	return true;
    }
    
    private boolean comprueba_nombre(Character nombre) {
    	if(nombre == null||nombre.toString().isBlank())
    		ViewUtils.showErrorMsg("El nombre del grupo proporcionado no puede ser nulo no vacio");
    	return true;
    }
    
    private boolean existe_grupo(Character nombre) {
    	for(Grupo g: _grupos) {
    		if(Character.valueOf(g.get_nombre()).equals(nombre))
    				return true;
    	}
    	return false;
    }
    
    public List<Grupo> getListaGrupos(){
    	return _grupos;
    }
}
