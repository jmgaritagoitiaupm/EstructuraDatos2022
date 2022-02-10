package com.company;

public class Main {

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Felipe Arias González","aa1253", 3.50);
        Alumno a2 = new Alumno("Manuel García Sacedón", "ax0074", 8.35);
        Alumno a3 = new Alumno("Margarita López Medina", "mj7726", 7.70);
        Alumno a4 = new Alumno("Estela SánchezArellano", "bc2658", 6.75);
        a1.matricularAsignatura("Estructura de Datos");
        a2.matricularAsignatura("Estructura de Datos");
        a3.matricularAsignatura("Estructura de Datos");
        a4.matricularAsignatura("Estructura de Datos");
        a4.matricularAsignatura("Algebra");
        a4.matricularAsignatura("Estructura de Computadores");

        a4.mostrarAsignaturas();
        a1.mostraralumno();
        a4.mostraralumno();

    }
}
