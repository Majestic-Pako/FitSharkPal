package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DLL.Cliente;
import DLL.Nivel;
import BLL.ConfigRutina;
import BLL.Gamificacion;
import BLL.Validacion;

public class MenuCliente extends JFrame implements Validacion {

    private int idCuenta;
    private Cliente cliente;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;


    public MenuCliente(int idCuenta) {
        this.idCuenta = idCuenta;
        this.cliente = Cliente.InfoCliente(idCuenta);
        
        setTitle("Menú Cliente - FitSharkPal");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initUI();
        if (cliente == null) {
        	showRegistro();
        }
    }
    
    private void showRegistro() {
        JPanel registerPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JComboBox<String> generoCombo = new JComboBox<>(new String[]{"HOMBRE", "MUJER", "OTRO"});
        JTextField pesoField = new JTextField();
        JTextField alturaField = new JTextField();
        JComboBox<Nivel> nivelCombo = new JComboBox<>(Nivel.values());
        
        registerPanel.add(new JLabel("Nombre:"));
        registerPanel.add(nombreField);
        registerPanel.add(new JLabel("Edad:"));
        registerPanel.add(edadField);
        registerPanel.add(new JLabel("Género:"));
        registerPanel.add(generoCombo);
        registerPanel.add(new JLabel("Peso (kg):"));
        registerPanel.add(pesoField);
        registerPanel.add(new JLabel("Altura (cm):"));
        registerPanel.add(alturaField);
        registerPanel.add(new JLabel("Nivel:"));
        registerPanel.add(nivelCombo);
        
        int result = JOptionPane.showConfirmDialog(
            this, 
            registerPanel, 
            "Completar Registro - Ingrese sus datos personales", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE
        );
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String genero = (String) generoCombo.getSelectedItem();
                int peso = Integer.parseInt(pesoField.getText());
                int altura = Integer.parseInt(alturaField.getText());
                Nivel nivel = (Nivel) nivelCombo.getSelectedItem();
                
                // Usamos el método de validación de la interfaz
                if (validarDatos(nombre, edad, genero, peso, altura, nivel)) {
                    int idCliente = Cliente.registrarCliente(
                        idCuenta, nombre, edad, genero, peso, altura, nivel
                    );
                    
                    if (idCliente != -1) {
                        JOptionPane.showMessageDialog(this, 
                            "Datos registrados correctamente", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        cliente = Cliente.InfoCliente(idCuenta);
                        updateUI();
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Error al registrar los datos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese valores numéricos válidos para edad, peso y altura", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                showRegistro();
            }
        } else {
            this.dispose();
            new Index().setVisible(true);
        }
    }
    
    public void initUI() {
        mainPanel = new JPanel(new BorderLayout());
        
        JPanel infoPanel = createInfoPanel();
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        
        tabbedPane = new JTabbedPane();
        
        JPanel dataPanel = createDataPanel();
        tabbedPane.addTab("Mis Datos", dataPanel);
        
        JPanel workoutsPanel = createWorkoutsPanel();
        tabbedPane.addTab("Mis Rutinas", workoutsPanel);
        
        JPanel progressPanel = createProgressPanel();
        tabbedPane.addTab("Mi Progreso", progressPanel);
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        JButton logoutButton = new JButton("Cerrar Sesión");
        logoutButton.addActionListener(e -> {
            this.dispose();
            new Index().setVisible(true);
        });
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(logoutButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        getContentPane().add(mainPanel);
    }

    public JPanel createInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Información del Cliente"));
        
        if (cliente != null) {
            addInfoRow(panel, "Nombre:", cliente.getNombre());
            addInfoRow(panel, "Edad:", String.valueOf(cliente.getEdad()));
            addInfoRow(panel, "Género:", cliente.getGenero());
            addInfoRow(panel, "Peso:", cliente.getPeso() + " kg");
            addInfoRow(panel, "Altura:", cliente.getAltura() + " cm");
            addInfoRow(panel, "Nivel:", cliente.getNivel().toString());
        } else {
            panel.add(new JLabel("No se encontraron datos del cliente"));
        }
        
        return panel;
    }

    public void addInfoRow(JPanel panel, String label, String value) {
        panel.add(new JLabel(label));
        panel.add(new JLabel(value));
    }

    public JPanel createDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Campo", "Valor"};
        Object[][] data = cliente != null ? 
            new Object[][] {
                {"Nombre", cliente.getNombre()},
                {"Edad", cliente.getEdad()},
                {"Género", cliente.getGenero()},
                {"Peso", cliente.getPeso() + " kg"},
                {"Altura", cliente.getAltura() + " cm"},
                {"Nivel", cliente.getNivel().toString()}
            } : new Object[][] {{"Error", "No se encontraron datos"}};
        
        JTable dataTable = new JTable(data, columnNames);
        dataTable.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton editButton = new JButton("Editar Datos");
        editButton.addActionListener(e -> showEditDialog());
        panel.add(editButton, BorderLayout.SOUTH);
        
        return panel;
    }

    public void showEditDialog() {
        if (cliente == null) return;
        
        JPanel editPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        JTextField nombreField = new JTextField(cliente.getNombre());
        JTextField edadField = new JTextField(String.valueOf(cliente.getEdad()));
        JComboBox<String> generoCombo = new JComboBox<>(new String[]{"HOMBRE", "MUJER", "OTRO"});
        generoCombo.setSelectedItem(cliente.getGenero());
        JTextField pesoField = new JTextField(String.valueOf(cliente.getPeso()));
        JTextField alturaField = new JTextField(String.valueOf(cliente.getAltura()));
        JComboBox<Nivel> nivelCombo = new JComboBox<>(Nivel.values());
        nivelCombo.setSelectedItem(cliente.getNivel());
        
        editPanel.add(new JLabel("Nombre:"));
        editPanel.add(nombreField);
        editPanel.add(new JLabel("Edad:"));
        editPanel.add(edadField);
        editPanel.add(new JLabel("Género:"));
        editPanel.add(generoCombo);
        editPanel.add(new JLabel("Peso (kg):"));
        editPanel.add(pesoField);
        editPanel.add(new JLabel("Altura (cm):"));
        editPanel.add(alturaField);
        editPanel.add(new JLabel("Nivel:"));
        editPanel.add(nivelCombo);
        
        int result = JOptionPane.showConfirmDialog(
            this, 
            editPanel, 
            "Editar Datos Personales", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE
        );
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String genero = (String) generoCombo.getSelectedItem();
                int peso = Integer.parseInt(pesoField.getText());
                int altura = Integer.parseInt(alturaField.getText());
                Nivel nivel = (Nivel) nivelCombo.getSelectedItem();
                
                if (validarDatos(nombre, edad, genero, peso, altura, nivel)) {
                    boolean updated = Cliente.ActCliente(
                        idCuenta, nombre, edad, genero, peso, altura, nivel
                    );
                    
                    if (updated) {
                        JOptionPane.showMessageDialog(this, 
                            "Datos actualizados correctamente", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        cliente = Cliente.InfoCliente(idCuenta); 
                        updateUI();
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Error al actualizar los datos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese valores numéricos válidos para edad, peso y altura", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public JPanel createWorkoutsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        ConfigRutina rutina = ConfigRutina.RutinaVer(idCuenta);
        
        if (rutina == null) {
            panel.add(new JLabel("No tienes rutinas asignadas", SwingConstants.CENTER), BorderLayout.CENTER);
        } else {
            String[] columnNames = {"Tipo", "Ejercicio"};
            Object[][] data = {
                {"Cardio", rutina.getCardio()},
                {"Zona Media", rutina.getZonaMedia()},
                {"Piernas", rutina.getPiernas()},
                {"Brazos", rutina.getBrazos()},
                {"Pecho", rutina.getPecho()},
                {"Espalda", rutina.getEspalda()}
            };
            
            JTable exercisesTable = new JTable(data, columnNames);
            exercisesTable.setEnabled(false);
            
            String[] paramsColumnNames = {"Parámetro", "Valor"};
            Object[][] paramsData = {
                {"Duración", rutina.getTiempo() + " minutos"},
                {"Repeticiones", rutina.getRepeticiones()},
                {"Series", rutina.getSeries()},
                {"Peso", rutina.getCantPeso() + " kg"},
                {"Descanso", rutina.getPausaEntreSerie() + " segundos"}
            };
            
            JTable paramsTable = new JTable(paramsData, paramsColumnNames);
            paramsTable.setEnabled(false);
            
            JTabbedPane workoutTabs = new JTabbedPane();
            workoutTabs.addTab("Ejercicios", new JScrollPane(exercisesTable));
            workoutTabs.addTab("Parámetros", new JScrollPane(paramsTable));
            
            panel.add(workoutTabs, BorderLayout.CENTER);
        }
        
        return panel;
    }

    public JPanel createProgressPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        Gamificacion gami = Gamificacion.GamiVer(idCuenta);
        
        if (gami == null) {
            panel.add(new JLabel("No tienes datos de progreso aún", SwingConstants.CENTER), BorderLayout.CENTER);
        } else {
            String[] columnNames = {"Concepto", "Valor"};
            Object[][] data = {
                {"Puntaje Total", gami.getPts()},
                {"Carta Actual", gami.getCarta()}
            };
           
            JTable progressTable = new JTable(data, columnNames);
            progressTable.setEnabled(false); 
            
            panel.add(new JScrollPane(progressTable), BorderLayout.CENTER);
        }
        
        return panel;
    }

    private void updateUI() {
        mainPanel.removeAll();
        initUI();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuCliente frame = new MenuCliente(1); 
            frame.setVisible(true);
        });
    }
}