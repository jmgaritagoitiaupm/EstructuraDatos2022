public class GrupoAlumnos {
    private String nombre;
    private int numAlumnos;
    private int maximo;
    private Alumno[] listaAlumnos;

    public GrupoAlumnos(){
        maximo = 10;
        nombre = "GrupoDesconocido";
        listaAlumnos = new Alumno[maximo];
        numAlumnos = 0;
    }

    public GrupoAlumnos(String nombre, int maximo) {
        this.nombre = nombre;
        this.maximo = maximo;
        listaAlumnos = new Alumno[maximo];
        numAlumnos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaximo() {
        return maximo;
    }
    public boolean insertarAlumno(Alumno alumno){
        if(numAlumnos < maximo){
            listaAlumnos[numAlumnos++]=alumno;
            return true;
        }
        return false;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public Alumno getAlumno (int i){
        if(i < numAlumnos){
            return listaAlumnos[i];
        }
        return null;
    }
    public void mostrarGrupo(){
        System.out.println("GRUPO " + nombre + ": " +
                numAlumnos + " alumnos");
        for(int i=0; i<numAlumnos; i++){
            listaAlumnos[i].mostrarAlumno();
        }
    }
    public double mediaCalificaciones(){
        double media = 0;
        for(int i=0; i<numAlumnos; i++){
            media += listaAlumnos[i].getCalificacion();
        }
        if(numAlumnos > 0){
            media = media / numAlumnos;
            return media;
        }
        return -1;
    }
    public Alumno mejorAlumno(){
        if(numAlumnos>0){
            int mayor = 0;
            for(int i=1; i<numAlumnos; i++){
                if(listaAlumnos[i].getCalificacion() >
                        listaAlumnos[mayor].getCalificacion()){
                    mayor = i;
                }
            }
            return listaAlumnos[mayor];
        }
        return null;
    }
    public boolean eliminarAlumno (String nombre){
        if(numAlumnos > 0){
            boolean encontrado = false;
            int i=0;
            while (i<numAlumnos && !encontrado){
                if(listaAlumnos[i].getNombre().equals(nombre)){
                    encontrado = true;
                }else{
                    i++;
                }
            }
            if(encontrado){
                for(int j=i; j<numAlumnos-1;j++){
                    listaAlumnos[j] = listaAlumnos[j+1];
                }
                numAlumnos--;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
