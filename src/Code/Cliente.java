package Code;

import java.sql.Connection;
import java.util.LinkedList;

public class Cliente extends Cuenta implements Encriptador{
	
	private Cuenta cuenta;
	private LinkedList<String> Nivel;
	
	public Cliente(int id,String nombre, String usuario, String contrasena, int edad, String genero, Rol rol) {
		super(id, nombre, usuario, contrasena, edad, genero, rol);
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
	
}
