package logicaNegocio;

import clases.Grupo;

public interface IFachadaGrupos {

	boolean altaGrupo(Character nombre) throws Exception;

	boolean bajaGrupo(Character nombre) throws Exception;

	Grupo consultarGrupo(Character nombre) throws Exception;

	boolean modificarGrupo(Character grupo, Character nombre) throws Exception;
}
