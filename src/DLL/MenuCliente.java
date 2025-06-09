package DLL;

import javax.swing.JOptionPane;

import BLL.Validacion;

public enum MenuCliente implements Validacion{
	Datos("Ingresar datos") {
		public void ejecutar(int idCuentaSesion) {
	        JOptionPane.showMessageDialog(null, "Se le solicitará ingresar sus datos");

	        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");

	        int edad;
	        try {
	            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Edad inválida.");
	            return;
	        }

	        String genero = (String) JOptionPane.showInputDialog(null, "Seleccione su género:", "Opciones",
	                JOptionPane.QUESTION_MESSAGE, null,
	                new Object[]{"Hombre", "Mujer", "Otro"}, "Hombre");

	        int peso;
	        try {
	            peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su peso en kilogramos"));
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Peso inválido.");
	            return;
	        }

	        int altura;
	        try {
	            altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su altura en centímetros"));
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Altura inválida.");
	            return;
	        }

	        String nivelStr = (String) JOptionPane.showInputDialog(null, "Seleccione su nivel:", "Opciones",
	                JOptionPane.QUESTION_MESSAGE, null,
	                new Object[]{"Principiante", "Intermedio", "Avanzado"}, "Principiante");

	        Nivel nivel;
	        try {
	            nivel = Nivel.valueOf(nivelStr.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, "Nivel inválido.");
	            return;
	        }

	        if (!validarDatos(nombre, edad, genero, peso, altura, nivel)) {
	            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente. Revise los datos.");
	            return;
	        }

	        boolean registrado = Cliente.registrarCliente(idCuentaSesion, nombre, edad, genero.toUpperCase(), peso, altura, nivel);
	        if (registrado) {
	            JOptionPane.showMessageDialog(null, "Registro exitoso.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al registrar datos del cliente.");
	        }
	    }
	},

	Entrenamientos("Entrenamientos activos") {
		@Override
		public void ejecutar(int idCuentaSesion) {
			Cliente cliente = Cliente.InfoCliente(idCuentaSesion);
			if (cliente != null) {
				JOptionPane.showMessageDialog(null, "Nivel actual: " + cliente.getNivel());
				JOptionPane.showMessageDialog(null, "Visualizando entrenamientos activos...");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo obtener el nivel del cliente. Ingresa los datos pa");
			}
		}
	},

	Historial("Historial de entrenamientos") {
		@Override
		public void ejecutar(int idCuentaSesion) {
			JOptionPane.showMessageDialog(null, "Mostrando historial de entrenamientos completados...");
		}
	},

	Calificacion("Ver calificación") {
		@Override
		public void ejecutar(int idCuentaSesion) {
			JOptionPane.showMessageDialog(null, "Mostrando calificación de progreso...");
		}
	},

	Salir("Salir") {
		@Override
		public void ejecutar(int idCuentaSesion) {
			JOptionPane.showMessageDialog(null, "Cerrando sesión...");
		}
	};

	private final String descripcion;

	MenuCliente(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	public abstract void ejecutar(int idCuentaSesion);

}
