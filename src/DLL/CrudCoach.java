package DLL;

import javax.swing.JOptionPane;

public enum CrudCoach {
	Crear_Perfil("Crear nueva Cuenta"){
		@Override
		public void ejecutar(int idCuentaSesion) {
			JOptionPane.showMessageDialog(null, "Creando nueva cuenta para Cliente");
		}
	} ,
	Editar_Perfil("Editar perfiles de clientes") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Editando cuentas del Cliente");
        }
    },
	Eliminar_Perfil("Eliminar Cuenta"){
    	@Override
    	public void ejecutar(int idCuentaSesion) {
    	JOptionPane.showMessageDialog(null, "Eliminando cuenta de Cliente");	
    	}
    },
	Asignar_Actividad("Asignar Actividad al Alumno"){
    	@Override
    	public void ejecutar(int idCuentaSesion) {
    	JOptionPane.showMessageDialog(null, "Asignando Activadad.....");	
    	}
    },
	Volver("Volver") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Volviendo al menu anterior......");
        }
    };
	
	public abstract void ejecutar(int idCuentaSesion);
	
    private final String descripcion;

    CrudCoach(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
