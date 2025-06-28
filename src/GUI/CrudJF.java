package GUI;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import BLL.ConfigRutina;
import BLL.Validacion;
import DLL.Cliente;
import java.awt.event.*;

public class CrudJF extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableClientes;
    private DefaultTableModel tableModel;
	private int idCuenta;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CrudJF frame = new CrudJF();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public CrudJF(int idCuenta) {
        this(); 
        this.idCuenta = idCuenta;
        setTitle("Menú Entrenador - ID: " + idCuenta); 
    }

    public CrudJF() {
        setTitle("Sistema de Gestión de Gimnasio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450); 
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panelAlumnos = createAlumnosPanel();
        tabbedPane.addTab("Alumnos", null, panelAlumnos, null);
        
        JPanel panelRegistro = createRegistroPanel();
        tabbedPane.addTab("Registro", null, panelRegistro, null);
        
        JPanel panelEdicion = createEdicionPanel();
        tabbedPane.addTab("Editar", null, panelEdicion, null);
        
        JPanel panelRutina = createRutinaPanel();
        tabbedPane.addTab("Rutina", null, panelRutina, null);
        
        JPanel panelEliminar = createEliminarPanel();
        tabbedPane.addTab("Eliminar", null, panelEliminar, null);

        JPanel panelVolver = createVolverPanel();
        tabbedPane.addTab("Volver", null, panelVolver, null);
        
        loadClientesData();
    }

    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Edad", "Género", "Nivel"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
            	Main validacion = new Main();
                validacion.crearJF(getWarningString(), getName(), panel);;
                return false;
            }
        };
        
        tableClientes = new JTable(tableModel);
        tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tableClientes.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(tableClientes);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createRegistroPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(null);
        JLabel label = new JLabel("Usuario:");
        label.setBounds(5, 8, 64, 13);
        panelUsuario.add(label);
        JTextField txtUsuario = new JTextField(20);
        txtUsuario.setBounds(59, 5, 166, 19);
        panelUsuario.add(txtUsuario);
        panel.add(panelUsuario);
        
        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPassword.add(new JLabel("Contraseña:"));
        JPasswordField txtPassword = new JPasswordField(20);
        panelPassword.add(txtPassword);
        panel.add(panelPassword);
        
        JButton btnRegistrar = new JButton("Crear Cuenta");
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnRegistrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());
            Validacion validador = new Main();
            validador.CrearCuenta(); 
            JOptionPane.showMessageDialog(this, "Cuenta creada para: " + usuario);
        });
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnRegistrar);
        
        return panel;
    }

    private JPanel createEdicionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        LinkedList<Cliente> listaClientes = Cliente.Listado();
        
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Cliente> comboClientes = new JComboBox<>();
        comboClientes.setPreferredSize(new Dimension(200, 25));
        
        for(Cliente cliente : listaClientes) {
            comboClientes.addItem(cliente);
        }
        
        comboClientes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre()); 
                }
                return this;
            }
        });
        
        panelSeleccion.add(new JLabel("Seleccionar alumno:"));
        panelSeleccion.add(comboClientes);
        panel.add(panelSeleccion, BorderLayout.NORTH);
        
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(new TitledBorder("Datos del Alumno"));
        
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNombre.add(new JLabel("Nombre:"));
        JTextField txtNombre = new JTextField(15);
        panelNombre.add(txtNombre);
        panelDatos.add(panelNombre);
        
        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEdad.add(new JLabel("Edad:"));
        JTextField txtEdad = new JTextField(5);
        panelEdad.add(txtEdad);
        panelDatos.add(panelEdad);
        
        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelGenero.add(new JLabel("Género:"));
        JComboBox<String> comboGenero = new JComboBox<>(new String[]{"Hombre", "Mujer", "Otro"});
        panelGenero.add(comboGenero);
        panelDatos.add(panelGenero);
        
        JPanel panelPeso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPeso.add(new JLabel("Peso (kg):"));
        JTextField txtPeso = new JTextField(5);
        panelPeso.add(txtPeso);
        panelDatos.add(panelPeso);
        
        JPanel panelAltura = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAltura.add(new JLabel("Altura (cm):"));
        JTextField txtAltura = new JTextField(5);
        panelAltura.add(txtAltura);
        panelDatos.add(panelAltura);
        
        JPanel panelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNivel.add(new JLabel("Nivel:"));
        JComboBox<String> comboNivel = new JComboBox<>(new String[]{"Principiante", "Intermedio", "Avanzado"});
        panelNivel.add(comboNivel);
        panelDatos.add(panelNivel);
        
        panel.add(panelDatos, BorderLayout.CENTER);
        
        JButton btnGuardar = new JButton("Guardar Cambios");
        
        btnGuardar.addActionListener(e -> {
        	Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            String nuevoNombre = txtNombre.getText();
            int nuevaEdad = Integer.parseInt(txtEdad.getText());
            String nuevoGenero = (String) comboGenero.getSelectedItem();
            int nuevoPeso = Integer.parseInt(txtPeso.getText());
            int nuevaAltura = Integer.parseInt(txtAltura.getText());
            String nuevoNivel = (String) comboNivel.getSelectedItem();
            
            Validacion validador = new Main();
            validador.EditarJF(cliente, nuevoNombre, nuevaEdad, nuevoGenero, 
                              nuevoPeso, nuevaAltura, nuevoNivel, this);
            JOptionPane.showMessageDialog(this, "Datos actualizados");
        });
        panel.add(btnGuardar, BorderLayout.SOUTH);
        
        return panel;
    }

    private JPanel createRutinaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        LinkedList<Cliente> listaClientes = Cliente.Listado();
        
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Cliente> comboClientes = new JComboBox<>();
        comboClientes.setPreferredSize(new Dimension(200, 25));
        
        for(Cliente cliente : listaClientes) {
            comboClientes.addItem(cliente);
        }
        
        comboClientes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre()); 
                }
                return this;
            }
        });
        
        panelSeleccion.add(new JLabel("Seleccionar alumno:"));
        panelSeleccion.add(comboClientes);
        panel.add(panelSeleccion, BorderLayout.NORTH);
        
        JPanel panelEjercicios = new JPanel();
        panelEjercicios.setLayout(new BoxLayout(panelEjercicios, BoxLayout.Y_AXIS));
        panelEjercicios.setBorder(new TitledBorder("Configurar Rutina"));
        
        JScrollPane scrollPane = new JScrollPane(panelEjercicios);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 300)); 
        
        JPanel panelCardio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCardio.add(new JLabel("Cardio:"));
        JComboBox<String> comboCardio = new JComboBox<>(new String[]{"Incline Walk", "Biking", "Jogging"});
        panelCardio.add(comboCardio);
        panelEjercicios.add(panelCardio);
        
        JPanel panelZonaMedia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelZonaMedia.add(new JLabel("Zona Media:"));
        JComboBox<String> comboZonaMedia = new JComboBox<>(new String[]{"Crunches", "Planche", "Leg Raises"});
        panelZonaMedia.add(comboZonaMedia);
        panelEjercicios.add(panelZonaMedia);
        
        JPanel panelPiernas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPiernas.add(new JLabel("Piernas:"));
        JComboBox<String> comboPiernas = new JComboBox<>(new String[]{"Deadlift", "Bulgarian Split Squat", "Hip Adductor/Abductor Machine"});
        panelPiernas.add(comboPiernas);
        panelEjercicios.add(panelPiernas);
        
        JPanel panelBrazos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBrazos.add(new JLabel("Brazos:"));
        JComboBox<String> comboBrazos = new JComboBox<>(new String[]{"Face Away Bayesian Cable Curls", "Preacher Hammer Curls", "EZ Bar Skull Crushers"});
        panelBrazos.add(comboBrazos);
        panelEjercicios.add(panelBrazos);
        
        JPanel panelPecho = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPecho.add(new JLabel("Pecho:"));
        JComboBox<String> comboPecho = new JComboBox<>(new String[]{"Bench Press", "Incline Shoulder Press", "Dumbbell Fly"});
        panelPecho.add(comboPecho);
        panelEjercicios.add(panelPecho);
        
        JPanel panelEspalda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEspalda.add(new JLabel("Espalda:"));
        JComboBox<String> comboEspalda = new JComboBox<>(new String[]{"Narrow Grip Lat Pulldowns", "Wide Grip Chest Supported Row", "One-Arm Cable Row"});
        panelEspalda.add(comboEspalda);
        panelEjercicios.add(panelEspalda);
        
        JPanel panelTiempo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTiempo.add(new JLabel("Duración cardio (min):"));
        JTextField txtTiempo = new JTextField(5);
        panelTiempo.add(txtTiempo);
        panelEjercicios.add(panelTiempo);
        
        JPanel panelRepeticiones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRepeticiones.add(new JLabel("Repeticiones:"));
        JTextField txtRepeticiones = new JTextField(5);
        panelRepeticiones.add(txtRepeticiones);
        panelEjercicios.add(panelRepeticiones);
        
        JPanel panelSeries = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSeries.add(new JLabel("Series:"));
        JTextField txtSeries = new JTextField(5);
        panelSeries.add(txtSeries);
        panelEjercicios.add(panelSeries);
        
        JPanel panelPeso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPeso.add(new JLabel("Peso (kg):"));
        JTextField txtPeso = new JTextField(5);
        panelPeso.add(txtPeso);
        panelEjercicios.add(panelPeso);
        
        JPanel panelDescanso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescanso.add(new JLabel("Descanso (seg):"));
        JTextField txtDescanso = new JTextField(5);
        panelDescanso.add(txtDescanso);
        panelEjercicios.add(panelDescanso);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton btnAsignar = new JButton("Asignar Rutina");
        
        btnAsignar.addActionListener(e -> {
        	Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            
            ConfigRutina rutina = new ConfigRutina(
                (String) comboPiernas.getSelectedItem(),
                (String) comboBrazos.getSelectedItem(),
                (String) comboPecho.getSelectedItem(),
                (String) comboEspalda.getSelectedItem(),
                (String) comboZonaMedia.getSelectedItem(),
                (String) comboCardio.getSelectedItem(),
                Integer.parseInt(txtRepeticiones.getText()),
                Integer.parseInt(txtSeries.getText()),
                Integer.parseInt(txtPeso.getText()),
                Integer.parseInt(txtDescanso.getText()),
                Integer.parseInt(txtTiempo.getText())
            );
            
            Validacion validador = new Main();
            validador.RutinaJF(cliente, rutina, this); 
            JOptionPane.showMessageDialog(this, "Rutina asignada");
        });
        panel.add(btnAsignar, BorderLayout.SOUTH);
        
        return panel;
    }

    private JPanel createEliminarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        LinkedList<Cliente> listaClientes = Cliente.Listado();
        
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Cliente> comboClientes = new JComboBox<>();
        comboClientes.setPreferredSize(new Dimension(200, 25));
        
        for(Cliente cliente : listaClientes) {
            comboClientes.addItem(cliente);
        }
        
        comboClientes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNombre()); 
                }
                return this;
            }
        });
        
        panelSeleccion.add(new JLabel("Seleccionar alumno:"));
        panelSeleccion.add(comboClientes);
        panel.add(panelSeleccion, BorderLayout.NORTH);
        
        JPanel panelConfirmacion = new JPanel();
        panelConfirmacion.setBorder(new TitledBorder("Confirmar eliminación"));
        panelConfirmacion.add(new JLabel("¿Está seguro de eliminar este alumno?"));
        panel.add(panelConfirmacion, BorderLayout.CENTER);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.RED);
        btnEliminar.addActionListener(e -> {
        	Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            if (cliente != null) {
                int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar a " + cliente.getNombre() + "?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    Validacion validador = new Main();
                    validador.EliminarJF(cliente, this);
                    comboClientes.removeItem(cliente);
                }
            }
        });
        panel.add(btnEliminar, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createVolverPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 240, 240));
        
        JLabel lblTitulo = new JLabel("Volver al Menú de Coach", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(70, 130, 180));
        panel.add(lblTitulo, BorderLayout.NORTH);
        
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setBackground(new Color(240, 240, 240));
        
        JLabel lblInstruccion = new JLabel("Para volver al menú anterior:", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblInstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(lblInstruccion);
        
        panelCenter.add(Box.createVerticalStrut(20));
        
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setBackground(new Color(70, 130, 180));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setMaximumSize(new Dimension(200, 40));
        panelCenter.add(btnVolver);
        
        panel.add(panelCenter, BorderLayout.CENTER);
        
        btnVolver.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnVolver);
            currentFrame.dispose();
            new MenuCoach(idCuenta).setVisible(true);
        });
        
        return panel;
    }

    private void loadClientesData() {
        LinkedList<Cliente> lista = Cliente.Listado();
        tableModel.setRowCount(0); 
        
        for (Cliente c : lista) {
            tableModel.addRow(new Object[]{
                c.getNombre(),
                c.getEdad(),
                c.getGenero(),
                c.getNivel().name()
            });
        }
    }

    private void mostrarDetallesAlumno() {
        int selectedRow = tableClientes.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno primero", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nombre = (String) tableModel.getValueAt(selectedRow, 0);
        String edad = (String) tableModel.getValueAt(selectedRow, 1);
        String genero = (String) tableModel.getValueAt(selectedRow, 2);
        String nivel = (String) tableModel.getValueAt(selectedRow, 3);
        
        String mensaje = String.format(
            "Nombre: %s\nEdad: %s\nGénero: %s\nNivel: %s",
            nombre, edad, genero, nivel
        );
        
        JOptionPane.showMessageDialog(this, mensaje, "Detalles del Alumno", JOptionPane.INFORMATION_MESSAGE);
    }
}
