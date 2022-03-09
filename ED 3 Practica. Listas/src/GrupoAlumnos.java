public class GrupoAlumnos {

	private String nombre;
	private ListaCalificada listaAlumnos;

	public GrupoAlumnos(String nombre) {
		this.nombre = nombre;
		listaAlumnos = new ListaCalificada();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void nuevoAlumno(Alumno alumno) {

	}

	public int getNumAlumnos() {
		return 0;  // Eliminar esta línea al codificar el método
	}

	public Alumno getAlumno(int matricula) {
		return null; // Eliminar esta línea al codificar el método
	}

	public double porcentajeAprobados(String nombreAsignatura) {
		return 0.0;  // Eliminar esta línea al codificar el método
	}
}