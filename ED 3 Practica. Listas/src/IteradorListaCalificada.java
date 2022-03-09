public class IteradorListaCalificada {

	private NodoListaCalificada actual;

	public IteradorListaCalificada(NodoListaCalificada comienzo) {
		actual = comienzo;
	}

	public boolean hasNext() {
		return actual != null;
	}

	public Alumno next() {
		Alumno resultado = actual.getDato();
		actual = actual.getSiguiente();
		return resultado;
	}
}
