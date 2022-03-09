public class IteradorListaOrdinal {

	private NodoListaOrdinal actual;

	public IteradorListaOrdinal(NodoListaOrdinal comienzo) {
		actual = comienzo;
	}

	public boolean hasNext() {
		return actual != null;
	}

	public int next() {
		int resultado = actual.getDato();
		actual = actual.getSiguiente();
		return resultado;
	}
}
