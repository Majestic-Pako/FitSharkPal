package GUI;

import javax.swing.JOptionPane;

import BLL.Validacion;
import DLL.Cliente;
import DLL.Cuenta;
import DLL.Fuerza;

public class Main implements Validacion {

	public static void main(String[] args) {

		Main instancia = new Main(); // llama a los métodos default de la interfaz
		int idCuentaSesion = -1;
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
					int idCuenta = Cuenta.Registro(usuario, contrasena,"CLIENTE");
					if (idCuenta != -1){
						JOptionPane.showMessageDialog(null, "Registro exitoso."+ idCuenta);
						idCuentaSesion = idCuenta;
					}else {
						JOptionPane.showMessageDialog(null, "Error en el registro.");
					}
				}
				break;

			case 1:
				usuario = JOptionPane.showInputDialog("Ingrese usuario:");
				contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

				if (instancia.ValidarUsuario(usuario, contrasena)) {
					Cuenta<?> cuenta = Cuenta.Login(usuario, contrasena);
					if (cuenta != null) {
						JOptionPane.showMessageDialog(null, "Bienvenido " + cuenta.getUsuario());
						idCuentaSesion = cuenta.getIdCuenta();
						int o;
						do {
							String convertir[] = { "Datos", "Entrenamientos", "Historial", "Calificacion", "Salir" };
							o = JOptionPane.showOptionDialog(null, "Seleccione una opcion", null, 0, 0, null, convertir,
									convertir[0]);
							switch (o) {
							case 0:
								
								JOptionPane.showMessageDialog(null, "Se le solicitara ingresar sus datos");
								String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
								int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Edad"));
								String genero = (String) JOptionPane.showInputDialog(null, "Seleccione su genero:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
										 new Object[]{"Hombre", "Mujer", "Otro"}, "Hombre");
								String nivel = (String) JOptionPane.showInputDialog(null, "Seleccione su nivel:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
										 new Object[]{"Principiante", "Intermedio", "Avanzado"}, "Principiante");
						
								boolean registrado = Cliente.registrarCliente(idCuentaSesion, nombre, edad, genero.toUpperCase(), nivel.toUpperCase());
								if (registrado) {
					                JOptionPane.showMessageDialog(null, "Registro exitoso.");
								}else {
					                JOptionPane.showMessageDialog(null, "Error al registrar datos del cliente.");
								}
								
								JOptionPane.showMessageDialog(null, nivel);
								Fuerza.afk(nivel);
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
