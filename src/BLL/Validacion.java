package BLL;

import javax.swing.JOptionPane;

import DLL.CrudCoach;
import DLL.MenuCliente;
import DLL.MenuCoach;

public interface Validacion {
	
	default boolean ValidarUsuario(String usuario, String contrasena) {
        if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario y contraseña no pueden estar vacíos.");
            return false;
        }
        return true;
    }

	default boolean ValidarRegistro(String usuario, String contrasena) {
	    if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Usuario y contraseña no pueden estar vacíos.");
	        return false;

	    }else {
	    	if (contrasena.length() < 6) {
		    	JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.");
		    	return false;
	    	}
	    	
	    }

	    return true;
	}

	default void NavCliente(int idCuentaSesion) {
        MenuCliente opcion;
        do {
            opcion = (MenuCliente) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Cliente",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    MenuCliente.values(),
                    MenuCliente.Datos
            );

            if (opcion != null) {
                opcion.ejecutar(idCuentaSesion);
            }

        } while (opcion != null && opcion != MenuCliente.Salir);
    }

    default void NavCoach(int idCuentaSesion) {
        MenuCoach opcion;
        do {
            opcion = (MenuCoach) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Entrenador",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    MenuCoach.values(),
                    MenuCoach.Alumnos
            );

            if (opcion != null) {
                opcion.ejecutar(idCuentaSesion);
            }

        } while (opcion != null && opcion != MenuCoach.Salir);
    }
    
    default void Crud(int idCuentaSesion) {
    	CrudCoach opcion;
        do {
            opcion = (CrudCoach) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Actividades",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    CrudCoach.values(),
                    CrudCoach.Crear_Perfil
            );

            if (opcion != null) {
                opcion.ejecutar(idCuentaSesion);
            }

        } while (opcion != null && opcion != CrudCoach.Volver);
    }
	
}
