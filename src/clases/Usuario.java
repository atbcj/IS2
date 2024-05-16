package clases;

import org.json.JSONObject;

public abstract class Usuario {
	protected String _nombre;
	protected String _apellidos;
	protected String _DNI;
	protected String _correo;
	//protected List<Tupla> _tupla;

	public Usuario(String nombre, String apellidos, String DNI, String correo) {
		_nombre = nombre;
		_apellidos = apellidos;
		_DNI = DNI;
		_correo = correo;
		//_tupla = new ArrayList<Tupla>();
	}

	public String getNombre() {
		return this._nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_apellidos() {
		return _apellidos;
	}

	/*public String get_Apellido1() {
		return _apellidos[0];
	}

	public String get_Apellido2() {
		return _apellidos[1];
	}
	 */
	public void set_apellidos(String _apellidos) {
		this._apellidos = _apellidos;
	}

	public String get_DNI() {
		return _DNI;
	}

	public void set_DNI(String _DNI) {
		this._DNI = _DNI;
	}

	public String getCorreo() {
		return _correo;
	}

	public void setCorreo(String correo) {
		this._correo = correo;
	}

	/*public List<Tupla> getTupla() {
		return this._tupla;
	}

	public void añadirTupla(Tupla tupla,boolean alumno) {
		int i=0;
		boolean existe = false, asigRep = false;
		while(i < _tupla.size() && !existe && !asigRep) {
			if(_tupla.get(i).equals(tupla)) {
				existe = true;
				ViewUtils.showErrorMsg("Ya te has matriculado en esta asignatura");
			}
			if(_tupla.get(i).getAsignatura().equals(tupla.getAsignatura()) && alumno) {
				asigRep = true;
				ViewUtils.showErrorMsg("No puedes estar en dos grupos de la misma asigantura a la vez");
			}
			i++;
		}
		if(!existe && !asigRep) {
			_tupla.add(tupla);
		}	
	}

	public void quitarTupla(Tupla tupla) {
		_tupla.remove(tupla);
	}*/

	public boolean equals(Usuario a) {
		return this._DNI.equals(a.get_DNI());
	}
	
	public JSONObject saveData() {
		JSONObject jo = new JSONObject();
		jo.put("nombre", _nombre);
		jo.put("apellidos", _apellidos);
		jo.put("correo", _correo);
		jo.put("DNI", _DNI);
		
		return jo;
	}
}
