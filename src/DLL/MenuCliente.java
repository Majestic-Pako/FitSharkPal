package DLL;

import javax.swing.JOptionPane;

public enum MenuCliente {
	Datos("Ingresar datos") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Se le solicitará ingresar sus datos");

            String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
            String genero = (String) JOptionPane.showInputDialog(null, "Seleccione su género:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Hombre", "Mujer", "Otro"}, "Hombre");
            String nivel = (String) JOptionPane.showInputDialog(null, "Seleccione su nivel:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Principiante", "Intermedio", "Avanzado"}, "Principiante");

            boolean registrado = Cliente.registrarCliente(idCuentaSesion, nombre, edad, genero.toUpperCase(), nivel.toUpperCase());
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
            JOptionPane.showMessageDialog(null, "Visualizando entrenamientos activos...");
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
