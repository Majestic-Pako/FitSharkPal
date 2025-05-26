package Code;

import javax.swing.JOptionPane;

public interface Validacion {
	
	default boolean validarUsuario(String usuario, String contrasena) {
        	try {
               return validarCredenciales(usuario, contrasena);
        	}catch(Exception e){
        		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        	        return false;
        	}
	}
	

	default boolean validarRegistro(String usuario, String contrasena) {
	      try {
	    	  return validarCredenciales(usuario, contrasena);
	      }catch(Exception e){
	    	  JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  	        return false;
	      }
	}


default boolean validarCredenciales(String usuario, String contrasena) {
	if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
        throw new IllegalArgumentException("Usuario y contraseña no pueden estar vacíos.");
    }

    if (usuario.length() < 4 || usuario.length() > 20) {
        throw new IllegalArgumentException("El usuario debe tener entre 4 y 20 caracteres.");
    }

    if (!usuario.matches("[a-zA-Z0-9_]+")) {
        throw new IllegalArgumentException("El usuario solo puede contener letras, números y guiones bajos.");
    }

    if (contrasena.length() < 6) {
        throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
    }

    if (!contrasena.matches(".*[A-Z].*")) {
        throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula.");
    }

    if (!contrasena.matches(".*\\d.*")) {
        throw new IllegalArgumentException("La contraseña debe contener al menos un número.");
    }

    return true;
}
}

