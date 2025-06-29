package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.ConfigRutina;
import BLL.Gamificacion;
import DLL.Cliente;

public class MenuCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private int idCuenta;

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

    public MenuCliente(int idCuenta) {
        this();
        this.idCuenta = idCuenta;
        setTitle("Menú Cliente - ID: " + idCuenta);
    }

    /**
     * Create the frame.
     */
    public MenuCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        tabbedPane.setBounds(0, 0, 504, 301);
        contentPane.add(tabbedPane);

        JLayeredPane layeredPane = new JLayeredPane();
        tabbedPane.addTab("Inicio", null, layeredPane, null);
        layeredPane.setLayout(null);

        JLabel lblBienvenido = new JLabel("Bienvenido Cliente");
        lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBienvenido.setForeground(new Color(255, 255, 255));
        lblBienvenido.setBounds(180, 25, 200, 31);
        layeredPane.add(lblBienvenido);

        JLabel lblNewLabel_2_1 = new JLabel("Ver mi rutina de entrenamiento");
        lblNewLabel_2_1.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(134, 66, 231, 23);
        layeredPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2 = new JLabel("Ver mi progreso y puntaje");
        lblNewLabel_2.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(134, 96, 231, 23);
        layeredPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Consultar mis datos personales");
        lblNewLabel_3.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(134, 129, 231, 23);
        layeredPane.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Editar mi perfil");
        lblNewLabel_5.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(134, 162, 231, 23);
        layeredPane.add(lblNewLabel_5);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 499, 273);
        lblNewLabel.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/banner-cliente.png")));
        layeredPane.add(lblNewLabel);

        JPanel panelRutinas = createMiRutinaPanel();
        tabbedPane.addTab("Mi Rutina", null, panelRutinas, null);

        JPanel panelPuntajes = createMiPuntajePanel();
        tabbedPane.addTab("Mi Progreso", null, panelPuntajes, null);

        JPanel panelSalir = createSalirPanel();
        tabbedPane.addTab("Salir", null, panelSalir, null);
    }

    private JPanel createMiRutinaPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] etiquetas = {
            "Cardio:", "Zona Media:", "Piernas:", "Brazos:", "Pecho:", 
            "Espalda:", "Duración cardio:", "Repeticiones:", "Series:", 
            "Peso (kg):", "Descanso (seg):"
        };

        JLabel[] valores = new JLabel[etiquetas.length];
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(new TitledBorder("Detalles de mi Rutina"));

        for (int i = 0; i < etiquetas.length; i++) {
            JPanel row = new JPanel(new BorderLayout(10, 0));
            JLabel label = new JLabel(etiquetas[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            label.setPreferredSize(new Dimension(120, 20));

            valores[i] = new JLabel("-");
            valores[i].setFont(new Font("Tahoma", Font.PLAIN, 12));

            row.add(label, BorderLayout.WEST);
            row.add(valores[i], BorderLayout.CENTER);
            row.setBorder(new EmptyBorder(5, 10, 5, 10));
            dataPanel.add(row);
        }

        // Cargar rutina del cliente actual
        ConfigRutina rutina = ConfigRutina.RutinaVer(idCuenta);
        if (rutina != null) {
            valores[0].setText(rutina.getCardio());
            valores[1].setText(rutina.getZonaMedia());
            valores[2].setText(rutina.getPiernas());
            valores[3].setText(rutina.getBrazos());
            valores[4].setText(rutina.getPecho());
            valores[5].setText(rutina.getEspalda());
            valores[6].setText(rutina.getTiempo() + " min");
            valores[7].setText(String.valueOf(rutina.getRepeticiones()));
            valores[8].setText(String.valueOf(rutina.getSeries()));
            valores[9].setText(rutina.getCantPeso() + " kg");
            valores[10].setText(rutina.getPausaEntreSerie() + " seg");
        } else {
            JOptionPane.showMessageDialog(mainPanel, 
                "No tienes rutina asignada. Contacta a tu entrenador.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(dataPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createMiPuntajePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] etiquetas = {
            "Puntaje actual:", "Carta actual:", "Progreso mensual:"
        };

        JLabel[] valores = new JLabel[etiquetas.length];
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(new TitledBorder("Mi Progreso"));

        for (int i = 0; i < etiquetas.length; i++) {
            JPanel row = new JPanel(new BorderLayout(10, 0));
            JLabel label = new JLabel(etiquetas[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            label.setPreferredSize(new Dimension(150, 20));

            valores[i] = new JLabel("-");
            valores[i].setFont(new Font("Tahoma", Font.PLAIN, 12));

            row.add(label, BorderLayout.WEST);
            row.add(valores[i], BorderLayout.CENTER);
            row.setBorder(new EmptyBorder(5, 10, 5, 10));
            dataPanel.add(row);
        }

        // Cargar gamificación del cliente actual
        Gamificacion gami = Gamificacion.GamiVer(idCuenta);
        if (gami != null) {
            valores[0].setText(String.valueOf(gami.getPts()));
            valores[1].setText(gami.getCarta().get(0));
            valores[2].setText("Gráfico de progreso aquí"); // Podrías añadir un JProgressBar o similar
        } else {
            JOptionPane.showMessageDialog(panel, 
                "No tienes datos de gamificación aún.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(dataPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSalirPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 240, 240));

        JLabel lblMensaje = new JLabel("¿Está seguro que desea cerrar sesión?", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setOpaque(false);

        JButton btnSi = new JButton("Sí, salir");
        btnSi.setBackground(new Color(220, 80, 80));
        btnSi.setForeground(Color.WHITE);
        btnSi.addActionListener(e -> {
            this.dispose();
            new Index().setVisible(true); // Vuelve al index
        });

        JButton btnNo = new JButton("No, cancelar");
        btnNo.setBackground(new Color(70, 130, 180));
        btnNo.setForeground(Color.WHITE);
        btnNo.addActionListener(e -> tabbedPane.setSelectedIndex(0));

        panelBotones.add(btnSi);
        panelBotones.add(btnNo);

        panel.add(lblMensaje, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }
}