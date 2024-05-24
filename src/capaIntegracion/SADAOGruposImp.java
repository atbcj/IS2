package capaIntegracion;

import clases.Asignatura;
import clases.Grupo;

public class SADAOGruposImp implements ISADAOGrupos{
	
	private Asignatura _asignatura;
	
	public SADAOGruposImp(Asignatura asignatura) {
		_asignatura = asignatura;
	}

	@Override
	public boolean crearGrupo(Character nombre) {
		_asignatura.aniadirGrupo(new Grupo(nombre, null, null));
		return true;
	}

	@Override
	public boolean eliminarGrupo(Character nombre) {
		Grupo grupo = null;
		for(Grupo g: _asignatura.getGrupos())
			if(Character.valueOf(g.get_nombre()).equals(nombre))
				grupo = g;
		if(grupo.get_lista_alumnos().isEmpty() && grupo.get_lista_profesores().isEmpty()) {
			_asignatura.getGrupos().remove(grupo);
			return true;
		}else
			return false;
	}

	@Override
	public boolean existeGrupo(Character nombre) {
		for(Grupo g: _asignatura.getGrupos()) {
    		if(Character.valueOf(g.get_nombre()).equals(nombre))
    				return true;
    	}
    	return false;
	}

	@Override
	public boolean modificacionGrupo(Character grupo, Character nombre) {
		for(Grupo g: _asignatura.getGrupos()) {
    		if(Character.valueOf(g.get_nombre()).equals(grupo))
    				g.modifica_nombre(nombre);
    	}
		return true;
	}
	
	@Override
	public Grupo getGrupo(Character nombre) {
		for(Grupo g: _asignatura.getGrupos()) {
    		if(Character.valueOf(g.get_nombre()).equals(nombre))
    				return g;
    	}
		return null;
	}

}
