import java.sql.BatchUpdateException;

public class ListaOrdinal {

	private NodoListaOrdinal inicio;
	private int numElementos;

	public ListaOrdinal() {
		inicio = null;		
		numElementos = 0;
	}

	public ListaOrdinal(int[] elementos){
		inicio = null;
		numElementos = elementos.length;
		NodoListaOrdinal actual = null;
		for(int i=0; i<elementos.length; i++){
			NodoListaOrdinal nuevo = new NodoListaOrdinal(elementos[i], null);
			if(actual==null){
				inicio=nuevo;
			}else{
				actual.setSiguiente(nuevo);
			}
			actual = nuevo;
		}
	}


	public void insertarAContinuacion(int base, int nuevo){
		NodoListaOrdinal actual = inicio;
		while(actual!=null){
			if(actual.getDato()!=base){
				actual=actual.getSiguiente();
			}else{
				NodoListaOrdinal nodo = new NodoListaOrdinal(nuevo, actual.getSiguiente());
				actual.setSiguiente(nodo);
				actual=nodo.getSiguiente();
			}
		}
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

	public boolean contieneEjer9 (int valor){
		NodoListaOrdinal actual, anterior;
		actual = inicio;
		anterior = null;
		while (actual!=null && actual.getDato()!=valor){
			anterior = actual;
			actual = actual.getSiguiente();
		}
		if(actual==null){
			return false;
		}else {
			anterior.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(inicio);
			inicio = actual;
			return true;
		}
	}
	public void imagenEspecular(){
		NodoListaOrdinal aux = inicio;
		while (aux!=null){
			NodoListaOrdinal nuevo = new NodoListaOrdinal(aux.getDato(), inicio);
			inicio = nuevo;
			aux = aux.getSiguiente();
		}
	}

	public void insertarCeros(){
		NodoListaOrdinal actual = inicio;
		int suma = 0;
		while (actual!=null){
			suma += actual.getDato();
			actual=actual.getSiguiente();
		}
		actual=inicio;
		while (actual!=null){
			if(actual.getDato()==suma){
				NodoListaOrdinal nuevo = new NodoListaOrdinal(0, actual.getSiguiente());
				actual.setSiguiente(nuevo);
				actual = actual.getSiguiente();
			}else{
				actual = actual.getSiguiente();
			}
		}
	}

	public void insertarCerosRec(){
		if(!this.vacia()){
			this.insertarCerosRecAux(0);
		}
	}

	private int insertarCerosRecAux(int suma){
		int x=0;
		if(!this.vacia()){
			int e = this.inicio.getDato();
			inicio = inicio.getSiguiente();
			x = this.insertarCerosRecAux(suma + e);
			if(x==e){
				NodoListaOrdinal nuevo = new NodoListaOrdinal(0,inicio);
				inicio = nuevo;
			}
			NodoListaOrdinal nuevo = new NodoListaOrdinal(e,inicio);
			inicio = nuevo;
			return x;
		}else
			return suma;
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
			NodoListaOrdinal aux = inicio;
			while (aux.getSiguiente()!=null){
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
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
