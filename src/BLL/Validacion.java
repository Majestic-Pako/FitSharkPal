package BLL;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import DLL.Cliente;
import DLL.CrudCoach;
import DLL.Cuenta;
import DLL.Ejercicios;
import DLL.MenuCliente;
import DLL.MenuCoach;
import DLL.Nivel;
import DLL.Rutina;

public interface Validacion {

    default boolean ValidarUsuario(String usuario, String contrasena) {
        if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no pueden estar vacíos.");

            return false;
        }else if (usuario == null || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El usuario no puede estar vacío.");
            return false;
        } else if (contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
            return false;
        }
        return true;
    }

    default boolean ValidarRegistro(String usuario, String contrasena) {
        if ((usuario == null || usuario.isEmpty()) && (contrasena == null || contrasena.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no pueden estar vacíos.");
            return false;

        } else if (usuario == null || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El usuario no puede estar vacío.");
            return false;
        } else {
            if (contrasena.length() < 3) { 
                JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 3 caracteres.");
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

    default void AsignarEj() {
    	 LinkedList<Cliente> lista = Cliente.Listado();

         if (lista.isEmpty()) {
             JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
             return;
         }

         String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);

         String seleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un alumno para ver Asignar Rutina:",
                 "Lista de Alumnos", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

         if (seleccionado != null) {
             for (Cliente c : lista) {
                 if (c.getNombre().equals(seleccionado)) {
                	 int idCuenta = c.getIdCuenta();
                     int idCliente = Cliente.obtenerIdCliente(idCuenta); 

                     ConfigRutina rutina = ConfigRutina.Form();

                     try {
                         int idEjercicios = Ejercicios.EjercicioBD(rutina);

                         int idGamificacion = Gamificacion.IdGami(idCliente, idCuenta);

                         boolean guardado = Rutina.RutinaBD(idCuenta, idEjercicios, idGamificacion);
                         //Ete de abajo hay que probarlo ndea si anda con el cambio
                         int puntaje = Ejercicios.Calculo(idCliente, idEjercicios, idGamificacion);
                         Gamificacion.ActPts(idGamificacion, puntaje);

                         if (guardado) {
                             JOptionPane.showMessageDialog(null, "Rutina y gamificación registradas correctamente.");
                         } else {
                             JOptionPane.showMessageDialog(null, "Error al registrar la rutina.");
                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la rutina.");
                     }

                     break;
                 }
             }
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
    
    default boolean validarDatos(String nombre, int edad, String genero, int peso, int altura, Nivel nivel) {
        boolean valido = true;
        StringBuilder errores = new StringBuilder("Errores:\n");

        if (nombre == null || nombre.trim().isEmpty()) {
            errores.append("- El nombre no puede estar vacío.\n");
            valido = false;
        }

        if (edad <= 0 || edad >= 200) {
            errores.append("- Edad inválida (1-199).\n");
            valido = false;
        }

        if (genero == null || 
            !(genero.equalsIgnoreCase("HOMBRE") || genero.equalsIgnoreCase("MUJER") || genero.equalsIgnoreCase("OTRO"))) {
            errores.append("- Género inválido (Hombre, Mujer u Otro).\n");
            valido = false;
        }

        if (peso <= 0 || peso >= 200) {
            errores.append("- Peso inválido (1-199kg).\n");
            valido = false;
        }

        if (altura <= 0 || altura >= 300) {
            errores.append("- Altura inválida (1-299cm).\n");
            valido = false;
        }

        if (nivel == null) {
            errores.append("- Nivel inválido.\n");
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(null, errores.toString(), "Errores de validación", JOptionPane.ERROR_MESSAGE);
        }

        return valido;
    }

    default void verRutinas() {
        LinkedList<Cliente> lista = Cliente.Listado();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);
        String seleccionado = (String) JOptionPane.showInputDialog(null,
            "Seleccione un cliente para ver su rutina:", "Rutinas",
            JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    int idCuenta = c.getIdCuenta();
                    ConfigRutina rutina = Rutina.RutinaVer(idCuenta);

                    if (rutina != null) {
                        int puntaje = Ejercicios.Calculo(idCuenta, idCuenta, idCuenta);
                        String carta = (puntaje <= 0) ? "Bronce" :
                                       (puntaje <= 20) ? "Plata" :
                                       (puntaje <= 46) ? "Oro" : "";
                        ArrayList<String> cartas = new ArrayList<>();
                        cartas.add(carta);

                        Rutina.Ver(
                            puntaje, puntaje, cartas,
                            rutina.getPiernas(), rutina.getBrazos(), rutina.getPecho(), rutina.getEspalda(),
                            rutina.getZonaMedia(), rutina.getCardio(),
                            rutina.getRepeticiones(), rutina.getSeries(), rutina.getCantPeso(),
                            rutina.getPausaEntreSerie(), rutina.getTiempo()
                        );
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no tiene rutina asignada.");
                    }
                    break;
                }
            }
        }
    }

    default void verGamificacion() {
        LinkedList<Cliente> lista = Cliente.Listado();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        String[] nombres = lista.stream().map(Cliente::getNombre).toArray(String[]::new);
        String seleccionado = (String) JOptionPane.showInputDialog(null,
            "Seleccione un cliente para ver su gamificación:", "Gamificación",
            JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);

        if (seleccionado != null) {
            for (Cliente c : lista) {
                if (c.getNombre().equals(seleccionado)) {
                    int idCuenta = c.getIdCuenta();
                    Gamificacion datos = Gamificacion.GamiVer(idCuenta);

                    if (datos != null) {
                        JOptionPane.showMessageDialog(null,
                            "Puntaje actual: " + datos.getPts() +
                            "\nCarta: " + (datos.getCarta().isEmpty() ? "No asignada" : datos.getCarta().get(0)));
                    } else {
                        JOptionPane.showMessageDialog(null, "Este cliente aún no tiene datos de gamificación.");
                    }
                    break;
                }
            }
        }
    }
    
}
