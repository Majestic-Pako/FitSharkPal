package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class Cuenta<T extends Cuenta> implements Encriptador {
	private int idCuenta;
	private String nombre;
	private String usuario;
	private String contrasena;
	private int edad;
	private String genero;
	private Rol rol;

	public Cuenta(int idCuenta, String nombre, String usuario, String contrasena, int edad, String genero,
			Rol rol) {
		super();
		this.idCuenta = idCuenta;
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

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int id) {
		this.idCuenta = idCuenta;
	}
	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}



	private static Connection con = Conexion.getInstance().getConnection();
	
	public static int Registro(String usuario, String contrasena, String rol) {
		try {
	        String sql = "INSERT INTO cuenta (usuario, contrasena, rol) VALUES (?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        Encriptador cifrador = new Cuenta(); //no me dejaba encriptar si no ponia esto :v
	        stmt.setString(1, usuario);
	        stmt.setString(2, cifrador.encriptar(contrasena));
	        stmt.setString(3, rol);
	        int filas = stmt.executeUpdate();
	        if (filas > 0) {
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                return rs.getInt(1); //esta wea es para que me devuelva el idCuenta pa el Cliente
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return -1;
	}

	 public static Cuenta<?> Login(String usuario, String contrasena) {
		 Cuenta cuenta = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM cuenta WHERE usuario = ? AND contrasena = ?"
	            );
	            stmt.setString(1, usuario);
	            stmt.setString(2, new Cuenta<>().encriptar(contrasena));
	            
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

