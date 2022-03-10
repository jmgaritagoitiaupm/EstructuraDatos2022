public class Principal {

    public int comprobarUltimo(ListaOrdinal lista){
        if(lista.vacia()){
            return 0;
        }
        IteradorListaOrdinal it = lista.getIterador();
        int numelementos = 0;
        int ultimo = 0;
        while(it.hasNext()){
            ultimo = it.next();
            numelementos++;
        }
        if(ultimo ==numelementos){
            return 0;
        }else if (ultimo<numelementos){
            return -1;
        }else{
            return 1;
        }
    }
    public ListaOrdinal interseccion(ListaOrdinal lista1,
                                     ListaOrdinal lista2){
        ListaOrdinal resultado = new ListaOrdinal();
        IteradorListaOrdinal it = lista1.getIterador();
        while (it.hasNext()){
            int e = it.next();
            if(lista2.contiene(e) && !resultado.contiene(e)){
                resultado.insertar(e);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        ListaOrdinal lista = new ListaOrdinal()    ;
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.mostrar();
    }
}
