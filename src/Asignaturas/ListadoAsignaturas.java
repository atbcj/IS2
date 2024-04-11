package Asignaturas;
import java.util.ArrayList;
import java.util.List;

public class ListadoAsignaturas {
    private List<Asignatura> _asignaturas;

    public ListadoAsignaturas(Asignatura[] asignaturas) {
        this._asignaturas = new ArrayList<>();
    }

    public List<Asignatura> getAsignaturas() {
        return this._asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this._asignaturas = asignaturas;
    }
    
    public void addAsignatura(Asignatura nueva) {
    	this._asignaturas.add(nueva);
    }
    
    public void removeAsignatura(Asignatura a) {
    	this._asignaturas.remove(a);
    }
}
