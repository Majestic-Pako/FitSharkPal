package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;

public class MenuCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JTextField textFieldEdad;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuCliente frame = new MenuCliente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 340);
        setTitle("Menú del Cliente");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        tabbedPane.setBounds(0, 0, 504, 301);
        contentPane.add(tabbedPane);
        
        // Panel 1: Rutinas actuales
        JLayeredPane panel_rutinh = new JLayeredPane();
        tabbedPane.addTab("Rutinas actuales", null, panel_rutinh, null);
        panel_rutinh.setLayout(null);
        
        JButton boton_salir = new JButton("Salir");
        boton_salir.setBounds(410, 250, 89, 23);
        panel_rutinh.add(boton_salir);
        
        JLabel lblRutinaActual = new JLabel("Rutina actual");
        lblRutinaActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblRutinaActual.setForeground(new Color(255, 255, 255));
        lblRutinaActual.setBounds(173, 71, 138, 23);
        panel_rutinh.add(lblRutinaActual);
        
        JLabel lblRutinasFinalizadas = new JLabel("Rutinas finalizadas");
        lblRutinasFinalizadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblRutinasFinalizadas.setForeground(new Color(255, 255, 255));
        lblRutinasFinalizadas.setBounds(173, 105, 130, 23);
        panel_rutinh.add(lblRutinasFinalizadas);
        
        JLabel lblPuntosActuales = new JLabel("Cantidad de puntos");
        lblPuntosActuales.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPuntosActuales.setForeground(new Color(255, 255, 255));
        lblPuntosActuales.setBounds(173, 141, 117, 23);
        panel_rutinh.add(lblPuntosActuales);
        
        JLabel lblPuntosObtener = new JLabel("Puntos a obtener");
        lblPuntosObtener.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPuntosObtener.setForeground(new Color(255, 255, 255));
        lblPuntosObtener.setBounds(173, 175, 121, 23);
        panel_rutinh.add(lblPuntosObtener);
        
        // Valores de ejemplo (deberías reemplazarlos con datos reales)
        JLabel lblValorRutinaActual = new JLabel("Rutina de fuerza");
        lblValorRutinaActual.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorRutinaActual.setForeground(Color.WHITE);
        lblValorRutinaActual.setBounds(320, 71, 150, 23);
        panel_rutinh.add(lblValorRutinaActual);
        
        JLabel lblValorRutinasFin = new JLabel("3");
        lblValorRutinasFin.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorRutinasFin.setForeground(Color.WHITE);
        lblValorRutinasFin.setBounds(320, 105, 50, 23);
        panel_rutinh.add(lblValorRutinasFin);
        
        JLabel lblValorPuntosAct = new JLabel("150 pts");
        lblValorPuntosAct.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorPuntosAct.setForeground(Color.WHITE);
        lblValorPuntosAct.setBounds(320, 141, 80, 23);
        panel_rutinh.add(lblValorPuntosAct);
        
        JLabel lblValorPuntosObt = new JLabel("50 pts");
        lblValorPuntosObt.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblValorPuntosObt.setForeground(Color.WHITE);
        lblValorPuntosObt.setBounds(320, 175, 80, 23);
        panel_rutinh.add(lblValorPuntosObt);
        
        JLabel imagen_fondo = new JLabel("");
        imagen_fondo.setBounds(0, 0, 504, 301);
        imagen_fondo.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/fondo-alumnos.png")));
        panel_rutinh.add(imagen_fondo);
        
        // Panel 2: Ingreso de datos
        JLayeredPane panel_rutinaf = new JLayeredPane();
        tabbedPane.addTab("Ingreso de datos", null, panel_rutinaf, null);
        panel_rutinaf.setLayout(null);
        
        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPeso.setBounds(50, 50, 100, 20);
        panel_rutinaf.add(lblPeso);
        
        textFieldPeso = new JTextField();
        textFieldPeso.setBounds(160, 50, 100, 20);
        panel_rutinaf.add(textFieldPeso);
        textFieldPeso.setColumns(10);
        
        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAltura.setBounds(50, 80, 100, 20);
        panel_rutinaf.add(lblAltura);
        
        textFieldAltura = new JTextField();
        textFieldAltura.setBounds(160, 80, 100, 20);
        panel_rutinaf.add(textFieldAltura);
        textFieldAltura.setColumns(10);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEdad.setBounds(50, 110, 100, 20);
        panel_rutinaf.add(lblEdad);
        
        textFieldEdad = new JTextField();
        textFieldEdad.setBounds(160, 110, 100, 20);
        panel_rutinaf.add(textFieldEdad);
        textFieldEdad.setColumns(10);
        
        JLabel lblObjetivo = new JLabel("Nivel:");
        lblObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblObjetivo.setBounds(50, 140, 100, 20);
        panel_rutinaf.add(lblObjetivo);
        
        JComboBox<String> comboBoxObjetivo = new JComboBox<>();
        comboBoxObjetivo.setBounds(160, 140, 150, 20);
        comboBoxObjetivo.addItem("Perder peso");
        comboBoxObjetivo.addItem("Ganar masa muscular");
        comboBoxObjetivo.addItem("Mantener estado físico");
        comboBoxObjetivo.addItem("Mejorar resistencia");
        panel_rutinaf.add(comboBoxObjetivo);
        
        JButton btnGuardarDatos = new JButton("Guardar Datos");
        btnGuardarDatos.setBounds(160, 180, 120, 25);
        panel_rutinaf.add(btnGuardarDatos);
        
        // Panel 3: Puntaje
        JLayeredPane panel_cantpts = new JLayeredPane();
        tabbedPane.addTab("Puntaje", null, panel_cantpts, null);
        panel_cantpts.setLayout(null);
        
        // Tabla de puntajes
        String[] columnNames = {"Rutina Completada", "Puntos Obtenidos"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable tablePuntajes = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Rutina Completada", "Puntos Obtenidos"
        	}
        ));
        tablePuntajes.setColumnSelectionAllowed(true);
        
        // Datos de ejemplo
        model.addRow(new Object[]{"2023-05-10", "50", "Rutina Cardio"});
        model.addRow(new Object[]{"2023-05-15", "75", "Rutina Fuerza"});
        model.addRow(new Object[]{"2023-05-20", "60", "Rutina Flexibilidad"});
        
        JScrollPane scrollPane = new JScrollPane(tablePuntajes);
        scrollPane.setBounds(20, 20, 450, 200);
        panel_cantpts.add(scrollPane);
        
        JLabel lblTotalPuntos = new JLabel("Total de puntos: ");
        lblTotalPuntos.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTotalPuntos.setBounds(20, 230, 200, 20);
        panel_cantpts.add(lblTotalPuntos);
        
        // Panel 4: Puntos a obtener
        JLayeredPane panel_ptsobt = new JLayeredPane();
        tabbedPane.addTab("Puntos a obtener", null, panel_ptsobt, null);
        panel_ptsobt.setLayout(null);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Completar rutina de cardio (50 puntos)");
        listModel.addElement("Completar rutina de fuerza (75 puntos)");
        listModel.addElement("Completar rutina de flexibilidad (40 puntos)");
        listModel.addElement("Asistir a 5 sesiones consecutivas (100 puntos)");
        listModel.addElement("Alcanzar objetivo mensual (200 puntos)");
        
        JList<String> listPuntos = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(listPuntos);
        listScrollPane.setBounds(20, 20, 450, 200);
        panel_ptsobt.add(listScrollPane);
        
        JLabel lblInfoPuntos = new JLabel("Selecciona una actividad para ver detalles");
        lblInfoPuntos.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblInfoPuntos.setBounds(20, 230, 300, 20);
        panel_ptsobt.add(lblInfoPuntos);
    }
}