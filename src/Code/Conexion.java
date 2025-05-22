package Code;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Conexion {
	private static String URL ="jdbc:mysql://localhost:3306/fitshark";
	private static String USER = "root";
	private static String PASSWORD ="";
	private static Connection conect;
	private static Conexion instance;
	private Conexion() {
		try {
			conect =  (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Se conectó");
		} catch (SQLException e) {
			System.out.println("No se conectó");

		}
	}
	public static Conexion getInstance() {
		if(instance ==null) {
			instance = new Conexion();
		}
		return instance;	
	}
	public Connection getConnection() {
		return conect;
	}
	
}
