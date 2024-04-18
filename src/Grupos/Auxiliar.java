package Grupos;
import java.util.List;

import Asignaturas.Asignatura;

public class Auxiliar {
    List<Grupo> _grupos;

    public boolean altaGrupo(String nombre) {
    	if(nombre == null||nombre.isEmpty())
    		throw new IllegalArgumentException("El nombre del grupo proporcionado no puede ser nulo no vacio");
    	for(Grupo g: _grupos)
    		if(g.getNombre() == nombre)
    			return false;
    	_grupos.add(new Grupo(nombre));
        return true;
    }

    public boolean bajaGrupo(String nombre) {
    	if(nombre == null||nombre.isEmpty())
    		throw new IllegalArgumentException("El nombre del grupo proporcionado no puede ser nulo no vacio");
    	for(Grupo g: _grupos)
    		if(g.getNombre() == nombre) {
    			_grupos.remove(g);
    			return true;
    		}
    	return false;
    }
    
    public boolean actualizarGrupo(Asignatura a, String nombre) {
    	if(nombre == null||nombre.isEmpty())
    		throw new IllegalArgumentException("El nombre del grupo proporcionado no puede ser nulo no vacio");
    	
    	return true;
    }
    public boolean visualizarGrupos(Asignatura asignatura) {
    	return true;
    }
}
