package Code;

public class Cuenta {
	
	private String nombre;
	private String usuario;
	private String contrasenia;
	private int edad;
	private String genero;
	private Boolean Entrenador;
	
	public Cuenta(String nombre, String usuario, String contrasenia, int edad, String genero, Boolean entrenador) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.edad = edad;
		this.genero = genero;
		Entrenador = entrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getEntrenador() {
		return Entrenador;
	}

	public void setEntrenador(Boolean entrenador) {
		Entrenador = entrenador;
	}
	
	
}
