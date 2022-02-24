public class Principal {
    public static int eliminarDato (Pila p, int dato){
        int resul = 0;
        if(!p.vacia()){
            int e = p.desapilar();
            resul = eliminarDato(p,dato);
            if(e != dato){
                p.apilar(e);
            }else{
                resul++;
            }
        }
        return resul;
    }
    public static int mayorElemento (Pila p){
        int resul = -1;
        if(!p.vacia()){
            int e = p.desapilar();
            resul = mayorElemento(p);
            if(e > resul){
                resul = e;
            }
            p.apilar(e);
        }
        return resul;
    }
    public static void sumaAcumulaFinalAux (Pila p, int acumulador){
        if(!p.vacia()){
            int e = p.desapilar();
            acumulador+=e;
            sumaAcumulaFinalAux(p, acumulador);
            p.apilar(e);
        }else{
            p.apilar(acumulador);
        }
    }

    public static void sumaAcumulaFinal (Pila p){
        if(!p.vacia()){
            int acumulador = 0;
            sumaAcumulaFinalAux(p,acumulador);
        }
    }
    public static void main(String[] args) {
        Pila p = new Pila();
        p.apilar(3);
        p.apilar(2);
        p.apilar(1);
        p.apilar(3);
        p.apilar(4);
        p.apilar(6);
        p.apilar(3);
        sumaAcumulaFinal(p);
        p.mostrar();
    }
}
