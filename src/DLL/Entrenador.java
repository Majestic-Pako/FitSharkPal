package DLL;

import java.util.ArrayList;

public class Entrenador extends Cuenta{
	
	private Cuenta cuenta;
	private ArrayList<String> acciones;

	public Entrenador(int idCuenta, String nombre, String usuario, String contrasena, int edad, String genero, int peso, int altura,
			Rol rol, Cuenta cuenta, ArrayList<String> acciones) {
		super(idCuenta, nombre, usuario, contrasena, edad, genero, peso, altura ,rol);
		this.cuenta = cuenta;
		this.acciones = acciones;
	}
	public Entrenador(int id, String nombre, String usuario, String contrasena, int edad, String genero, int peso, int altura, Rol rol) {
	    super(id, nombre, usuario, contrasena, edad, genero, peso, altura , rol);
	    this.cuenta = this; 
	    this.acciones = new ArrayList<>(); 
	}
	
	
	@Override
	public String toString() {
		return "Entrenador [cuenta=" + cuenta + ", acciones=" + acciones + "]";
	}
	
}
