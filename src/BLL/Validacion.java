package BLL;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Cliente;
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
	    	if (contrasena.length() < 2) {
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
    
    default void MostrarAlumnos() {
        LinkedList<Cliente> lista = Cliente.Listado();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
            return;
        }

        String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);

        String seleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un alumno para ver sus datos:",
            "Lista de Alumnos",
            JOptionPane.PLAIN_MESSAGE,
            null,
            nombres,
            nombres[0]
        );

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    String datos = 
                        "Nombre: " + c.getNombre() + "\n" +
                        "Edad: " + c.getEdad() + "\n" +
                        "Género: " + c.getGenero() + "\n" +
                        "Nivel: " + c.getNivel();
                    
                    JOptionPane.showMessageDialog(null, datos, "Datos del Alumno", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
    }
	
}
