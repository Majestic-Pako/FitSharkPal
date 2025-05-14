package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cuenta implements Encriptador {
	private int id;
	private String nombre;
	private String usuario;
	private String contrasena;
	private int edad;
	private String genero;
	private Boolean Entrenador;
	
	public Cuenta(int id,String nombre, String usuario, String contrasena, int edad, String genero, Boolean entrenador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.edad = edad;
		this.genero = genero;
		Entrenador = entrenador;
	}

	public Cuenta() {
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
		return contrasena;
	}

	public void setContrasenia(String contrasena) {
		this.contrasena = contrasena;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	public static Cuenta login(String usuario, String contrasena) {
	    Cuenta cuenta = null;
	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "SELECT * FROM cuenta WHERE usuario = ? AND contrasena = ?"
	        );
	        stmt.setString(1, usuario);
	        stmt.setString(2, new Cuenta().encriptar(contrasena));

	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            int edad = rs.getInt("edad");
	            String genero = rs.getString("genero");
	            Boolean entrenador = rs.getBoolean("entrenador");

	            if (entrenador) {
	            	cuenta = new Entrenador(id, nombre, usuario, contrasena, edad, genero, true);
	            } else {
	                cuenta = new Cliente(id, nombre, usuario, contrasena, edad, genero, false);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cuenta;
	}
	
}
