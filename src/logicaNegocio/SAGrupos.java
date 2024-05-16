package logicaNegocio;

import clases.Grupo;

public interface SAGrupos {
	
	public boolean altaGrupo(Character nombre) throws Exception;
	
	public boolean bajaGrupo(Character nombre) throws Exception;
	
	public Grupo consultaGrupo(Character nombre);
	
	public boolean modificacionGrupo(Character grupo, Character nombre) throws Exception;
	
}
