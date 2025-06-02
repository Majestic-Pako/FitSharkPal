package DLL;

import javax.swing.JOptionPane;

import BLL.Validacion;

public enum MenuCoach implements Validacion {
	Alumnos("Menu de alumnos") {
        @Override
        public void ejecutar(int idCuentaSesion) {
        	Crud(idCuentaSesion);
        }
    },
    Ver_Actividades("Ver actividades asignadas") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Mostrando actividades asignadas a los clientes...");
        }
    },
    Calificaciones("Ver calificaciones de clientes") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Mostrando calificaciones de progreso...");
        }
    },
    Salir("Salir") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Cerrando sesión de entrenador...");
        }
    };

	public abstract void ejecutar(int idCuentaSesion);
	
    private final String descripcion;

    MenuCoach(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    
}
