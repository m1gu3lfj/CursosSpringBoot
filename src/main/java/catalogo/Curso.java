package catalogo;

public class Curso {
	
	private final boolean activo;
	private final String titulo;
	private final String profesor;
	private final String nivel;
	private final int horas;
	
	public Curso(boolean activo, String titulo, String profesor, String nivel, int horas) {
		this.activo = activo;
		this.titulo = titulo;
		this.profesor = profesor;
		this.nivel = nivel;
		this.horas = horas;
	}

	public boolean isActivo() {
		return activo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getProfesor() {
		return profesor;
	}

	public String getNivel() {
		return nivel;
	}

	public int getHoras() {
		return horas;
	}
}
