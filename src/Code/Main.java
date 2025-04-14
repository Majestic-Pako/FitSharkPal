package Code;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JOptionPane.showMessageDialog(null, "hola soy esteban");
       //Prueba 1:
       Entrenador_Choose_Ejercicios_Cliente llamada= new Entrenador_Choose_Ejercicios_Cliente(null, null);
       llamada.getEjercicio_basico();;
       llamada.getEjercicio_personalizado();
       //Por ahora no hacen nada, pero esto seria una prueba de como llamar al metodo
	}

}
