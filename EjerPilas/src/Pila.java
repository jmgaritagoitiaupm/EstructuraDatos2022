public class Pila {
    private Nodo cima;
    private int numElementos;

    public Pila() {
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(int dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    public int desapilar() {
        int valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = -9999;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public int getCima() {
        int valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = -9999;
        } else valor = cima.getDato();
        return valor;
    }

    public void quitarCima() {
        if (this.vacia())
            System.out.println("Error, la pila está vacía");
        else {
            cima = cima.getSiguiente();
            numElementos--;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        Nodo auxiliar = cima;
        System.out.println("Contenido de la pila:");
        while (auxiliar != null) {
            System.out.println(auxiliar.getDato());
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }
}
