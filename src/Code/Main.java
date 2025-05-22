package Code;

import javax.swing.JOptionPane;

public class Main implements Validacion {

	public static void main(String[] args) {

		Main instancia = new Main(); // llama a los métodos default de la interfaz

		int opcion;
		do {
			String[] opciones = { "Registrar", "Login", "Salir" };
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu", 0, 3, null, opciones,
					opciones[0]);

			switch (opcion) {
			case 0:
				String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
				String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

				if (instancia.ValidarRegistro(usuario, contrasena)) {
					boolean exito = Cuenta.Registro(usuario, contrasena,"CLIENTE");
					if (exito)
						JOptionPane.showMessageDialog(null, "Registro exitoso.");
					else
						JOptionPane.showMessageDialog(null, "Error en el registro.");
				}
				break;

			case 1:
				usuario = JOptionPane.showInputDialog("Ingrese usuario:");
				contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

				if (instancia.ValidarUsuario(usuario, contrasena)) {
					Cuenta<?> cuenta = Cuenta.Login(usuario, contrasena);
					if (cuenta != null) {
						JOptionPane.showMessageDialog(null, "Bienvenido " + cuenta.getUsuario());
						int o;
						do {
							String convertir[] = { "Datos", "Entrenamientos", "Historial", "Calificacion", "Salir" };
							o = JOptionPane.showOptionDialog(null, "Seleccione una opcion", null, 0, 0, null, convertir,
									convertir[0]);
							switch (o) {
							case 0:
								JOptionPane.showMessageDialog(null,
										"Seccion Cliente \n Aca el cliente podria modificar sus datos");
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
								JOptionPane.showMessageDialog(null,
										"Seccion\n Aca podra revisar su calificacion de progreso reflejado en una carta");
								JOptionPane.showMessageDialog(null,
										"Seccion Entrenador\n Aca podra ver las puntuaciones de sus alumnos");
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "Bye Bye");
								break;
							}

						} while (o != 4);
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
					}
				}
				break;

			case 2:
			default:
				JOptionPane.showMessageDialog(null, " fuiste");
				System.exit(0);
			}
		} while (true);
	}

}
