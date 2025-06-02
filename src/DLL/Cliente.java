package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import BLL.Encriptador;
import repository.Conexion;

public class Cliente extends Cuenta implements Encriptador {

	private Cuenta cuenta;
	private Nivel nivel;

	public Cliente(int idCuenta, String nombre, String usuario, String contrasena, int edad, String genero, Rol rol,
			Cuenta cuenta, Nivel nivel) {
		super(idCuenta, nombre, usuario, contrasena, edad, genero, rol);
		this.cuenta = cuenta;
		this.nivel = nivel;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	private static Connection con = Conexion.getInstance().getConnection();

	public static boolean registrarCliente(int idCuenta, String nombre, int edad, String genero, Nivel nivel) {
		try {
			String sql = "INSERT INTO cliente (nombre, edad, genero, nivel, Cuenta_idCuenta) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, genero);
			stmt.setString(4, nivel.name());
			stmt.setInt(5, idCuenta);
			int filas = stmt.executeUpdate();
			return filas > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Cliente InfoCliente(int idCuenta) {
	    try {
	        String sql = "SELECT * FROM cliente WHERE Cuenta_idCuenta = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idCuenta);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            int edad = rs.getInt("edad");
	            String genero = rs.getString("genero");
	            String nivelStr = rs.getString("nivel");
	            Nivel nivel = Nivel.valueOf(nivelStr.toUpperCase());

	            return new Cliente(idCuenta, nombre, null, null, edad, genero, Rol.CLIENTE, null, nivel);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}