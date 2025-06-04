package DLL;

import javax.swing.JOptionPane;

import BLL.Validacion;
import GUI.Main;

public enum CrudCoach {
	Crear_Perfil("Crear nueva Cuenta"){
		@Override
		public void ejecutar(int idCuentaSesion) {
			JOptionPane.showMessageDialog(null, "Creando nueva cuenta para Cliente");
			Main crear = new Main(); //Ndea porque no me tomaba validacion pero cuando puse Main lo acepto al toke :]
			crear.CrearCuenta();
		}
	} ,
	Editar_Perfil("Editar perfiles de clientes") {
        @Override
        public void ejecutar(int idCuentaSesion) {
            JOptionPane.showMessageDialog(null, "Editando cuentas del Cliente...");
            Main edit = new Main() {}; // se declara con {} para que detecte que es un arreglo
            edit.EditarAlumnos();
        }
    },
	Eliminar_Perfil("Eliminar Cuenta"){
    	@Override
    	public void ejecutar(int idCuentaSesion) {
    	JOptionPane.showMessageDialog(null, "Eliminando cuenta de Cliente");	
    	}
    },
	Ver_Alumnos("Listado de Alumnos"){
    	@Override
    	public void ejecutar(int idCuentaSesion) {
    	JOptionPane.showMessageDialog(null, "Mostrando a todos los alumnos.....");
    	Main validacion = new Main() {}; //Eta wea es lo mismo q hice en main pa llamar al default :b
        validacion.MostrarAlumnos();
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
