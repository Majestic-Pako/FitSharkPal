package Code;

import java.util.ArrayList;

public class Entrenador extends Cuenta{
	
	private Cuenta cuenta;
	private ArrayList<String> acciones;

	public Entrenador(int id, String nombre, String usuario, String contrasena, int edad, String genero,
			Boolean entrenador, Cuenta cuenta, ArrayList<String> acciones) {
		super(id, nombre, usuario, contrasena, edad, genero, entrenador);
		this.cuenta = cuenta;
		this.acciones = acciones;
	}
	public Entrenador(int id, String nombre, String usuario, String contrasena, int edad, String genero, Boolean entrenador) {
	    super(id, nombre, usuario, contrasena, edad, genero, entrenador);
	    this.cuenta = this; 
	    this.acciones = new ArrayList<>(); 
	}
	@Override
	public String toString() {
		return "Entrenador [cuenta=" + cuenta + ", acciones=" + acciones + "]";
	}
	
}
