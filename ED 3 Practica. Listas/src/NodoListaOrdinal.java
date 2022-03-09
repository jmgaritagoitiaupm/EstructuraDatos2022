public class NodoListaOrdinal {

	private int dato;
	private NodoListaOrdinal siguiente;

	public NodoListaOrdinal(int dato, NodoListaOrdinal siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public NodoListaOrdinal getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaOrdinal siguiente) {
		this.siguiente = siguiente;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
}
