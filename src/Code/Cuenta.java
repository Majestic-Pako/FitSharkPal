package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cuenta<T extends Cuenta> implements Encriptador {
	private int id;
	private String nombre;
	private String usuario;
	private String contrasena;
	private int edad;
	private String genero;
	private Rol rol;

	public Cuenta(int id, String nombre, String usuario, String contrasena, int edad, String genero,
			Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.edad = edad;
		this.genero = genero;
		this.rol = rol;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}



	private static Connection con = Conexion.getInstance().getConnection();
	
	public static boolean crearCuenta(String usuario, String contrasena, String rol) {
	    try {
	        String sql = "INSERT INTO cuenta (usuario, contrasena, rol) VALUES (?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, usuario);
	        stmt.setString(2, contrasena);
	        stmt.setString(3, rol);
	        int filas = stmt.executeUpdate();
	        return filas > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	 public static Cuenta<?> login(String usuario, String contrasena) {
		 Cuenta cuenta = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM cuenta WHERE usuario = ? AND contrasena = ?"
	            );
	            stmt.setString(1, usuario);
	            //stmt.setString(2, new Cuenta<>().encriptar(contrasena));
	            stmt.setString(2, contrasena);
	            
	            System.out.println("Ejecutando consulta login para usuario: " + usuario);
	            
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                int id = rs.getInt("idCuenta");
	                String user = rs.getString("usuario");
	                String pass = rs.getString("contrasena");
	                String rolStr = rs.getString("rol");

	                Rol rol = Rol.valueOf(rolStr.toUpperCase());
	                
	                
	                if (rol == Rol.ENTRENADOR) {
	                    return new Entrenador(id, null, user, pass, 0, null, rol);
	                } else {
	                    return new Cliente(id, null, user, pass, 0, null, rol);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	 @Override
	 public String toString() {
	     return "Contraseña: " + contrasena + ", Usuario: " + usuario + ", Rol: " + rol;
	 }


}
