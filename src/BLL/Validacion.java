package BLL;

import java.util.LinkedList;
import javax.swing.JOptionPane;

import DLL.Cliente;
import DLL.CrudCoach;
import DLL.Cuenta;
import DLL.MenuCliente;
import DLL.MenuCoach;
import DLL.Nivel;

public interface Validacion {

    default boolean ValidarUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no puede estar vacío.");
            return false;
        }
        return true;
    }
    default boolean ValidarUsuario1(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
            return false;
        }
        return true;
    }

    default boolean ValidarRegistro(String usuario, String contrasena) {
        if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario y contraseña no pueden estar vacíos.");
            return false;
        } else {
            if (contrasena.length() < 6) {  // Cambié a 6 para que coincida con el mensaje
                JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.");
                return false;
            }
        }
        return true;
    }

    default void NavCliente(int idCuentaSesion) {
        MenuCliente opcion;
        do {
            opcion = (MenuCliente) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Cliente",
                    JOptionPane.QUESTION_MESSAGE, null, MenuCliente.values(), MenuCliente.Datos);

            if (opcion != null) {
                opcion.ejecutar(idCuentaSesion);
            }

        } while (opcion != null && opcion != MenuCliente.Salir);
    }

    default void NavCoach(int idCuentaSesion) {
        MenuCoach opcion;
        do {
            opcion = (MenuCoach) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Entrenador",
                    JOptionPane.QUESTION_MESSAGE, null, MenuCoach.values(), MenuCoach.Alumnos);

            if (opcion != null) {
                opcion.ejecutar(idCuentaSesion);
            }

        } while (opcion != null && opcion != MenuCoach.Salir);
    }

    default void Crud(int idCuentaSesion) {
        CrudCoach opcion;
        do {
            opcion = (CrudCoach) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú de Actividades",
                    JOptionPane.QUESTION_MESSAGE, null, CrudCoach.values(), CrudCoach.Crear_Perfil);

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

        String seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un alumno para ver sus datos:",
                "Lista de Alumnos", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    String datos = "Nombre: " + c.getNombre() + "\n" + "Edad: " + c.getEdad() + "\n" + "Género: "
                            + c.getGenero() + "\n" + "Nivel: " + c.getNivel();

                    JOptionPane.showMessageDialog(null, datos, "Datos del Alumno", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
    }

    default void CrearCuenta() {
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario a crear");
        String contraseña = JOptionPane.showInputDialog("Ingrese una contraseña");
        if (ValidarRegistro(usuario, contraseña)) {
            int Idnuevo = Cuenta.Registro(usuario, contraseña, "Cliente");
            if (Idnuevo != -1) {
                JOptionPane.showMessageDialog(null, "Nueva cuenta creada con éxito. ID: " + Idnuevo);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la nueva cuenta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos inválidos. No se pudo registrar la cuenta.");
        }
    }

    default void EditarAlumnos() {
        LinkedList<Cliente> lista = Cliente.Listado();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
            return;
        }

        String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);

        String seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un alumno para actualizar sus datos:",
                "Lista de Alumnos", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    String ActN = JOptionPane.showInputDialog("Actualice el nombre:", c.getNombre());
                    int ActE = Integer.parseInt(JOptionPane.showInputDialog("Actualice la edad:", c.getEdad()));
                    String ActG = (String) JOptionPane.showInputDialog(null, "Actualice el género:", "Género",
                            JOptionPane.QUESTION_MESSAGE, null, new String[] { "Hombre", "Mujer", "Otro" }, c.getGenero());
                    int ActP = Integer.parseInt(JOptionPane.showInputDialog("Actualice el peso:"));
                    int ActA = Integer.parseInt(JOptionPane.showInputDialog("Actualice la altura:"));
                    String ActL = (String) JOptionPane.showInputDialog(null, "Actualice el nivel:", "Nivel",
                            JOptionPane.QUESTION_MESSAGE, null,
                            new String[] { "Principiante", "Intermedio", "Avanzado" }, c.getNivel());
                    Nivel nivelAct = Nivel.valueOf(ActL.toUpperCase());

                    boolean actualizado = Cliente.ActCliente(c.getIdCuenta(), ActN, ActE, ActG.toUpperCase(), ActP, ActA,
                            nivelAct);

                    if (actualizado) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar datos.");
                    }
                    break;
                }
            }
        }
    }

    default void BorrarAlumno() {
        LinkedList<Cliente> lista = Cliente.Listado();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
            return;
        }

        String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);

        String seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un alumno para borrar sus datos:",
                "Lista de Alumnos", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro que deseas eliminar a " + c.getNombre() + "?", "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        boolean eliminado = Cliente.Delete(c.getIdCuenta());

                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente. Que la fuerza lo acompañe.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el alumno.");
                        }
                    }
                    break;
                }
            }
        }
    }
}
