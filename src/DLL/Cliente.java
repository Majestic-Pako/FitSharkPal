package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import BLL.Encriptador;
import repository.Conexion;

public class Cliente extends Cuenta implements Encriptador{
	
	private Cuenta cuenta;
	private LinkedList<String> Nivel;
	
	public Cliente(int idCuenta,String nombre, String usuario, String contrasena, int edad, String genero, Rol rol) {
		super(idCuenta, nombre, usuario, contrasena, edad, genero, rol);
		Nivel = new LinkedList<>();
        Nivel.add("Principiante");
        Nivel.add("Intermedio");
        Nivel.add("Avanzado");
        
	}

	public LinkedList<String> getNivel() {
		return Nivel;
	}

	public void setNivel(LinkedList<String> nivel) {
		Nivel = nivel;
	}
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	public static boolean registrarCliente(int idCuenta, String nombre, int edad, String genero, String nivel) {
	    try {
	        String sql = "INSERT INTO cliente (nombre, edad, genero, nivel, Cuenta_idCuenta) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, nombre);
	        stmt.setInt(2, edad);
	        stmt.setString(3, genero);
	        stmt.setString(4, nivel);
	        stmt.setInt(5, idCuenta);
	        int filas = stmt.executeUpdate();
	        return filas > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	

}