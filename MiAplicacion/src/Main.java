public class Main {

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Felipe Arias González","aa1253", 3.50);
        Alumno a2 = new Alumno("Manuel García Sacedón", "ax0074", 8.35);
        Alumno a3 = new Alumno("Margarita López Medina", "mj7726", 7.70);
        Alumno a4 = new Alumno("Estela Sánchez Arellano", "bc2658", 6.75);
        a1.matricularAsignatura("Estructura de Datos");
        a2.matricularAsignatura("Estructura de Datos");
        a3.matricularAsignatura("Estructura de Datos");
        a4.matricularAsignatura("Estructura de Datos");
        a4.matricularAsignatura("Algebra");
        a4.matricularAsignatura("Estructura de Computadores");

        a4.mostrarAsignaturas();
        a1.mostrarAlumno();
        a4.mostrarAlumno();
        GrupoAlumnos grupoAlumnos = new GrupoAlumnos("GX11",20);
        grupoAlumnos.insertarAlumno(a1);
        grupoAlumnos.insertarAlumno(a2);
        grupoAlumnos.insertarAlumno(a3);
        grupoAlumnos.insertarAlumno(a4);
        grupoAlumnos.mostrarGrupo();
        /*
        grupoAlumnos.getAlumno(1).mostrarAlumno();
        System.out.println(grupoAlumnos.mediaCalificaciones());
        grupoAlumnos.mejorAlumno().mostrarAlumno();
        */
        System.out.println("------- Despues de borrar -----------");
        grupoAlumnos.eliminarAlumno("Manuel García Sacedón");
        grupoAlumnos.mostrarGrupo();
    }
}
