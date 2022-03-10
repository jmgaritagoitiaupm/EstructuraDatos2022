import java.sql.BatchUpdateException;

public class ListaOrdinal {

	private NodoListaOrdinal inicio, fin;
	private int numElementos;

	public ListaOrdinal() {
		inicio = null;
		fin = null;
		numElementos = 0;
	}
	public void eliminarRepetidos(int dato){
		NodoListaOrdinal actual = inicio;
		while (actual!=null && actual.getDato()!=dato){
			actual=actual.getSiguiente();
		}
		if(actual!=null){
			NodoListaOrdinal anterior = actual;
			actual = actual.getSiguiente();
			while (actual!=null){
				if(actual.getDato()==dato){
					anterior.setSiguiente(actual.getSiguiente());
					actual=actual.getSiguiente();
				}else{
					anterior=actual;
					actual=actual.getSiguiente();
				}
			}
		}
	}
	public void duplicarParesQuitarImpares(){
		NodoListaOrdinal actual, anterior=null;
		actual = inicio;
		while (actual!=null){
			if(actual.getDato()%2==0){
				NodoListaOrdinal nuevo = new NodoListaOrdinal(actual.getDato(), actual.getSiguiente());
				actual.setSiguiente(nuevo);
				actual = nuevo.getSiguiente();
				anterior = nuevo;
			}else{ // borrar nodo actual
				if(this.inicio== actual){
					inicio = inicio.getSiguiente();
				}else{
					anterior.setSiguiente(actual.getSiguiente());
				}
				actual=actual.getSiguiente();
			}
		}
	}

	public void triplicar(){
		NodoListaOrdinal actual = inicio;
		while (actual!=null){
			NodoListaOrdinal nuevo1 = new NodoListaOrdinal(actual.getDato(),actual.getSiguiente());
			NodoListaOrdinal nuevo2 = new NodoListaOrdinal(actual.getDato(),nuevo1);
			actual.setSiguiente(nuevo2);
			actual=nuevo1.getSiguiente();
		}
	}
	public void mostrar(){
		String cadena = "[";
		IteradorListaOrdinal it = getIterador();
		while(it.hasNext()){
			int e = it.next();
			cadena += e + " ";
		}
		cadena += "]";
		System.out.println(cadena);
	}
	public boolean vacia() {
		return inicio == null;
	}

	/**
	 * Inserta el dato en la última posición de la lista
	 */
	public void insertar(int dato) {
		NodoListaOrdinal nuevo = new NodoListaOrdinal(dato, null);
		if (this.vacia()) {
			inicio = nuevo;
		} else {
			fin.setSiguiente(nuevo);
		}
		fin = nuevo;
		numElementos++;
	}


	/**
	 * Busca el dato que ocupa la posición recibida como parámetro,
	 * en caso de existir.
	 */
	public int getElemento(int posicion) {
		NodoListaOrdinal actual;
		if ((posicion > numElementos - 1) || (posicion < 0)) {
			System.out.println("No existe la posición " + posicion);
			return -1;
		} else {
			actual = inicio;
			for (int i = 0; i < posicion; i++) {
				actual = actual.getSiguiente();
			}
			return actual.getDato();
		}
	}

	/**
	 * Borra el primer elemento de la lista cuyo dato coincide con el
	 * parámetro recibido.
	 */
	public void borrar(int dato) {
		NodoListaOrdinal actual = inicio;
		NodoListaOrdinal anterior = null;
		boolean borrado = false;
		while (actual != null && !borrado) {
			if (actual.getDato() == dato) {  // Borrar actual
				if (actual != inicio) {
					anterior.setSiguiente(actual.getSiguiente());
				} else {
					inicio = actual.getSiguiente();
				}
				if (actual == fin) {  // se borra el último
					fin = anterior;
				}
				numElementos--;
				borrado = true;
			} else {
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
	}

	/**
	 * Devuelve la primera posición en la que se encuentra el dato,
	 * en caso de existir. En caso contrario, devuelve -1
	 */

	public int posicion(int dato) {
		NodoListaOrdinal actual = inicio;
		int pos = 0;
		while (actual != null && actual.getDato() != dato) {
			actual = actual.getSiguiente();
			pos++;
		}
		if (actual != null) {
			return pos;
		} else {
			return -1;
		}
	}

	/**
	 * Determina si el dato recibido como parámetro existe en la lista.
	 */
	public boolean contiene(int dato) {
		return this.posicion(dato) >= 0;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public IteradorListaOrdinal getIterador() {
		return new IteradorListaOrdinal(inicio);
	}

	public int numConvocatorias(String nombreAsignatura) {
		return 0; // Eliminar esta líne al codificar el método
	}
}
