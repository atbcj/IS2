package capaIntegracion;

import clases.Grupo;

public interface IFachadaDAOGrupos {
	
	public boolean crearGrupo(Character nombre);
	
	public boolean eliminarGrupo(Character nombre);
	
	public boolean existeGrupo(Character nombre);
	
	public boolean modificacionGrupo(Character grupo, Character nombre);

	public Grupo getGrupo(Character nombre);
	
}
