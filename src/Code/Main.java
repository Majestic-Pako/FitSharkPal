package Code;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Bienvenido a FitSharkPal");
		
		 boolean creado = Cuenta.crearCuenta("agus123", "asd", "CLIENTE");
		    if (creado) {
		        System.out.println("Cuenta creada correctamente");
		    } else {
		        System.out.println("Error al crear cuenta");
		    }

		    // Luego probar login
		    Cuenta c = Cuenta.login("agus123", "asd");

		    if (c != null) {
		        System.out.println("Bienvenido " + c.getUsuario());
		    } else {
		        System.out.println("Credenciales incorrectas");
		    }
		int opcion;
		do {
			String convertir[] = { "Datos", "Entrenamientos", "Historial", "Calificacion", "Salir" };
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", null, 0, 0, null, convertir,
					convertir[0]);
			switch (opcion) {
			case 0:
				JOptionPane.showMessageDialog(null, "Seccion Cliente \n Aca el cliente podria modificar sus datos");
				JOptionPane.showMessageDialog(null,
						"Seccion Entrenador \n Aca el entrenador podra visaulizar sus alumnos "
						+ "y tendra la posibilidad de modificar sus datos, eliminar o agregar nuevos clientes");
				break;
			case 1:
				JOptionPane.showMessageDialog(null,
						"Seccion Cliente\n Aca podra visualizar sus entrenamientos que tiene activo");
				JOptionPane.showMessageDialog(null,
						"Seccion Entrenador \n Aca podra dar ejercicios a sus alumnos "
						+ "y ver los ejercicios de sus alumnos y marcar si ya completaron su entrenamiento");
				break;
			case 2:
				JOptionPane.showMessageDialog(null,
						"Seccion Cliente\n Aca podra visualizar los entrenamientos que completo con anterioridad");
				JOptionPane.showMessageDialog(null, "Seccion Entrenador\n No tiene acciones aca");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Seccion\n Aca podra revisar su calificacion de progreso reflejado en una carta");
				JOptionPane.showMessageDialog(null, "Seccion Entrenador\n Aca podra ver las puntuaciones de sus alumnos");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Bye Bye");
				break;
			}

		} while (opcion != 4);
	}

}
