package GUI;

import javax.swing.JOptionPane;

import DLL.Cuenta;
import BLL.Validacion;
import DLL.Rol;

public class Main implements Validacion {

	public static void main(String[] args) {

		Main instancia = new Main(); // llama a los métodos default de la interfaz

		// int admin = Cuenta.Registro("admin", "123456", "Entrenador"); //Eto es pa
		// testear como anda el admin
		
		int idCuentaSesion = -1;
		int opcion;
		do {
			String[] opciones = { "Registrar", "Login", "Salir" };
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido a Fitshark", "Menu", 0, 3, null, opciones,
					opciones[0]);

			switch (opcion) {
			case 0:
				String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
				String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

				if (instancia.ValidarRegistro(usuario, contrasena)) {
					int idCuenta = Cuenta.Registro(usuario, contrasena, "CLIENTE");
					if (idCuenta != -1) {
						JOptionPane.showMessageDialog(null, "Registro exitoso.");
						idCuentaSesion = idCuenta;
					} else {
						JOptionPane.showMessageDialog(null, "Error en el registro.");
					}
				}
				break;

			case 1:
				usuario = JOptionPane.showInputDialog("Ingrese usuario:");
				contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");
				if (!instancia.ValidarUsuario(usuario, contrasena)) {
					break;
				}
				Cuenta<?> cuenta = Cuenta.Login(usuario, contrasena);
				if (cuenta != null) {
					JOptionPane.showMessageDialog(null, "Bienvenido " + cuenta.getUsuario());
					idCuentaSesion = cuenta.getIdCuenta();

					Rol rol = cuenta.getRol();

					switch (rol) {
					case CLIENTE:
						instancia.NavCliente(idCuentaSesion);
						break;
					case ENTRENADOR:
						instancia.NavCoach(idCuentaSesion);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Rol no reconocido.");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
				}
				break;
			case 2:
			default:
				JOptionPane.showMessageDialog(null, " fuiste :3");
				System.exit(0);
			}
		} while (true);

	}

}