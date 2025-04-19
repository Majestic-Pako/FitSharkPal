package Code;

import java.util.ArrayList;

public class Entrenador extends Cuenta{
	
	private Cuenta cuenta;
	private ArrayList<String> acciones;
	
	public Entrenador(String nombre, String usuario, String contrasenia, int edad, String genero, Boolean entrenador) {
		super(nombre, usuario, contrasenia, edad, genero, entrenador);
	}
}
