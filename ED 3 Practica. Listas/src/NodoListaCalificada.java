public class NodoListaCalificada {

	private int clave;
	private Alumno dato;
	private NodoListaCalificada siguiente;

	public NodoListaCalificada(int clave, Alumno dato, NodoListaCalificada siguiente) {
		this.clave = clave;
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public NodoListaCalificada getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaCalificada siguiente) {
		this.siguiente = siguiente;
	}

	public Alumno getDato() {
		return dato;
	}

	public void setDato(Alumno dato) {
		this.dato = dato;
	}

	public int getClave() {
		return clave;
	}
}
