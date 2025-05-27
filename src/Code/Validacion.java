package Code;

import javax.swing.JOptionPane;

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

	
}
