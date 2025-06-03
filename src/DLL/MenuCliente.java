package DLL;

import javax.swing.JOptionPane;

import GUI.Main;

public enum MenuCliente {
	Datos("Ingresar datos") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Se le solicitará ingresar sus datos");

            String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
            String genero = (String) JOptionPane.showInputDialog(null, "Seleccione su género:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Hombre", "Mujer", "Otro"}, "Hombre");
            int peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su peso en centimetros"));
            int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su altura en centimetros"));
            String nivel = (String) JOptionPane.showInputDialog(null, "Seleccione su nivel:", "Opciones", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Principiante", "Intermedio", "Avanzado"}, "Principiante");
     
            Nivel nivelAct = Nivel.valueOf(nivel.toUpperCase());
            Main llamada= new Main();
            llamada.ValidarDatos(nombre, edad, genero, peso, altura, nivelAct);
            boolean registrado = Cliente.registrarCliente(idCuentaSesion, nombre, edad, genero.toUpperCase(), peso, altura ,nivelAct);
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
