package Code;

import java.sql.Connection;
import java.util.LinkedList;

public class Cliente extends Cuenta {
	
	private Cuenta cuenta;
	private LinkedList<String> Nivel;
	
	public Cliente(int id,String nombre, String usuario, String contrasenia, int edad, String genero, Boolean entrenador) {
		super(nombre, usuario, contrasenia, edad, genero, entrenador);
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
