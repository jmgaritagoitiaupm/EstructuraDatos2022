public class Evaluacion {

	private String nombreAsignatura;
	private String convocatoria;
	private double nota;

	public Evaluacion(String nombreAsignatura, String convocatoria, double nota) {
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
		this.convocatoria = convocatoria;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public double getNota() {
		return nota;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void mostrar() {
		if (nota >= 0.0) {
			System.out.println("    " + nombreAsignatura + " (" + convocatoria + "): " + nota);
		} else {
			System.out.println("    " + nombreAsignatura + " (" + convocatoria + "): NP");
		}
	}
}
