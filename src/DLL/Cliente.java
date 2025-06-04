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

	public Cliente(int idCuenta, String nombre, String usuario, String contrasena, int edad, String genero, int peso,
			int altura, Rol rol, Cuenta cuenta, Nivel nivel) {
		super(idCuenta, nombre, usuario, contrasena, edad, genero, peso, altura, rol);
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

	public static boolean registrarCliente(int idCuenta, String nombre, int edad, String genero, int peso, int altura,
			Nivel nivel) {
		try {
			String sql = "INSERT INTO cliente (nombre, edad, genero, peso, altura, nivel, Cuenta_idCuenta) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, genero);
			stmt.setInt(4, peso);
			stmt.setInt(5, altura);
			stmt.setString(6, nivel.name());
			stmt.setInt(7, idCuenta);
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
				int peso = rs.getInt("peso");
				int altura = rs.getInt("altura");
				String nivelStr = rs.getString("nivel");
				Nivel nivel = Nivel.valueOf(nivelStr.toUpperCase());

				return new Cliente(idCuenta, nombre, null, null, edad, genero, peso, altura, Rol.CLIENTE, null, nivel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static LinkedList<Cliente> Listado() {
		LinkedList<Cliente> clientes = new LinkedList<>();
		try {
			String sql = "SELECT * FROM cuenta INNER JOIN cliente ON cuenta.idCuenta = cliente.Cuenta_idCuenta WHERE cuenta.rol = 'CLIENTE'";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idCuenta");
				String nombre = rs.getString("nombre");
				String genero = rs.getString("genero");
				int edad = rs.getInt("edad");
				int peso = rs.getInt("peso");
				int altura = rs.getInt("altura");
				String nivelStr = rs.getString("nivel");
				Nivel nivel = Nivel.valueOf(nivelStr.toUpperCase());

				Cliente cliente = new Cliente(id, nombre, null, null, edad, genero, peso, altura, Rol.CLIENTE, null,
						nivel);
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public static boolean ActCliente(int idCuenta, String nombre, int edad, String genero, int peso, int altura,
			Nivel nivel) {
		try {
			String sql = "UPDATE cliente SET nombre = ?, edad = ?, genero = ?, peso = ?, altura = ?, nivel = ? WHERE Cuenta_idCuenta = ?";
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombre);
			stmt.setInt(2, edad);
			stmt.setString(3, genero);
			stmt.setInt(4, peso);
			stmt.setInt(5, altura);
			stmt.setString(6, nivel.name());
			stmt.setInt(7, idCuenta);
			int filas = stmt.executeUpdate();
			return filas > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}