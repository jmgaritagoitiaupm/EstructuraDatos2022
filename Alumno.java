package com.company;

public class Alumno {
    private String nombre, matricula;
    double calificacion;
    private int numAsignaturas;
    private String asignaturas[];
    private final int maxAsignaturas = 5;

    public Alumno() {
        this.nombre = null;
        this.matricula=null;
        this.calificacion=0;
        this.numAsignaturas=0;
        this.asignaturas = new String[maxAsignaturas];
    }

    public Alumno(String nombre, String matricula, double calificacion) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificacion = calificacion;
        this.numAsignaturas=0;
        this.asignaturas = new String[maxAsignaturas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void matricularAsignatura(String asignatura){
        if(this.numAsignaturas < this.maxAsignaturas){
            this.asignaturas[this.numAsignaturas++]=asignatura;
        }else{
            System.out.println("No puedes introducir la asignatura");
        }
    }

    public int getNumAsignaturas() {
        return numAsignaturas;
    }

    public void mostrarAsignaturas(){
        if(this.numAsignaturas==0){
            System.out.println("No esta matriculado en ninguna asignatura");
        }else{
            System.out.println(this.numAsignaturas + " asignaturas:");
            for(int i=0; i<this.numAsignaturas; i++){
                System.out.println("\t- " + this.asignaturas[i]);
            }
        }
    }

    public void mostraralumno(){
        System.out.println(this.nombre + " Matr:" + this.matricula
            + " (" + this.calificacion + ")");
        this.mostrarAsignaturas();
    }
}
