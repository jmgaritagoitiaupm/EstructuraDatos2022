public class Nodo{
    private int dato;
    private Nodo siguiente;

    public Nodo(int dato, Nodo sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}
