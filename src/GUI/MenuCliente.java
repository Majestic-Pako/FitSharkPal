package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import BLL.ConfigRutina;
import BLL.Gamificacion;
import DLL.Cliente;

public class MenuCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private int idCuenta;

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
        cargarDatosCliente(); // Cargar datos al iniciar
    }

    public MenuCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        tabbedPane.setBounds(0, 0, 504, 301);
        contentPane.add(tabbedPane);

        crearPanelInicio();
        tabbedPane.addTab("Mi Rutina", null, crearPanelRutina(), null);
        tabbedPane.addTab("Mi Progreso", null, crearPanelProgreso(), null);
        tabbedPane.addTab("Salir", null, crearPanelSalir(), null);
    }

    private void cargarDatosCliente() {
        // Puedes cargar datos adicionales del cliente aquí si es necesario
        Cliente cliente = Cliente.Buscar(idCuenta);
        if (cliente != null) {
            setTitle("Menú Cliente - " + cliente.getNombre());
        }
    }

    private void crearPanelInicio() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        JLabel lblBienvenido = new JLabel("Bienvenido Cliente");
        lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBienvenido.setForeground(new Color(255, 255, 255));
        lblBienvenido.setBounds(180, 25, 200, 31);
        layeredPane.add(lblBienvenido);

        JLabel lblRutina = new JLabel("Ver mi rutina de entrenamiento");
        lblRutina.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblRutina.setForeground(Color.WHITE);
        lblRutina.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblRutina.setBounds(134, 66, 231, 23);
        layeredPane.add(lblRutina);

        JLabel lblProgreso = new JLabel("Ver mi progreso y puntaje");
        lblProgreso.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblProgreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblProgreso.setForeground(Color.WHITE);
        lblProgreso.setBounds(134, 96, 231, 23);
        layeredPane.add(lblProgreso);

        JLabel lblDatos = new JLabel("Consultar mis datos personales");
        lblDatos.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDatos.setForeground(Color.WHITE);
        lblDatos.setBounds(134, 126, 231, 23);
        layeredPane.add(lblDatos);

        JLabel lblEditar = new JLabel("Editar mi perfil");
        lblEditar.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/boton.png")));
        lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setBounds(134, 156, 231, 23);
        layeredPane.add(lblEditar);

        JButton btnEditarPerfil = new JButton("Editar Perfil");
        btnEditarPerfil.setBounds(180, 200, 120, 25);
        btnEditarPerfil.setBackground(new Color(0, 128, 128));
        btnEditarPerfil.setForeground(Color.WHITE);
        layeredPane.add(btnEditarPerfil);

        JLabel fondo = new JLabel("");
        fondo.setBounds(0, 0, 499, 273);
        fondo.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/banner-cliente.png")));
        layeredPane.add(fondo);

        tabbedPane.addTab("Inicio", null, layeredPane, null);
    }

    private JPanel crearPanelRutina() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] etiquetas = {
            "Cardio:", "Zona Media:", "Piernas:", "Brazos:", "Pecho:", 
            "Espalda:", "Duración:", "Repeticiones:", "Series:", 
            "Peso (kg):", "Descanso (seg):"
        };

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(new TitledBorder("Mi Rutina de Entrenamiento"));

        // Cargar rutina del cliente actual
        ConfigRutina rutina = ConfigRutina.RutinaVer(idCuenta);

        for (int i = 0; i < etiquetas.length; i++) {
            JPanel row = new JPanel(new BorderLayout(10, 0));
            JLabel label = new JLabel(etiquetas[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            label.setPreferredSize(new Dimension(120, 20));

            JLabel valor = new JLabel("-");
            valor.setFont(new Font("Tahoma", Font.PLAIN, 12));

            // Llenar con datos si existen
            if (rutina != null) {
                switch (i) {
                    case 0: valor.setText(rutina.getCardio()); break;
                    case 1: valor.setText(rutina.getZonaMedia()); break;
                    case 2: valor.setText(rutina.getPiernas()); break;
                    case 3: valor.setText(rutina.getBrazos()); break;
                    case 4: valor.setText(rutina.getPecho()); break;
                    case 5: valor.setText(rutina.getEspalda()); break;
                    case 6: valor.setText(rutina.getTiempo() + " min"); break;
                    case 7: valor.setText(String.valueOf(rutina.getRepeticiones())); break;
                    case 8: valor.setText(String.valueOf(rutina.getSeries())); break;
                    case 9: valor.setText(rutina.getCantPeso() + " kg"); break;
                    case 10: valor.setText(rutina.getPausaEntreSerie() + " seg"); break;
                }
            }

            row.add(label, BorderLayout.WEST);
            row.add(valor, BorderLayout.CENTER);
            row.setBorder(new EmptyBorder(5, 10, 5, 10));
            dataPanel.add(row);
        }

        if (rutina == null) {
            JOptionPane.showMessageDialog(panel, 
                "No tienes rutina asignada. Contacta a tu entrenador.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(dataPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelProgreso() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] etiquetas = {
            "Puntaje actual:", "Carta actual:", "Progreso mensual:", 
            "Última actualización:", "Nivel alcanzado:"
        };

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(new TitledBorder("Mi Progreso"));

        // Cargar gamificación del cliente actual
        Gamificacion gami = Gamificacion.GamiVer(idCuenta);

        for (int i = 0; i < etiquetas.length; i++) {
            JPanel row = new JPanel(new BorderLayout(10, 0));
            JLabel label = new JLabel(etiquetas[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            label.setPreferredSize(new Dimension(150, 20));

            JLabel valor = new JLabel("-");
            valor.setFont(new Font("Tahoma", Font.PLAIN, 12));

            // Llenar con datos si existen
            if (gami != null) {
                switch (i) {
                    case 0: valor.setText(String.valueOf(gami.getPts())); break;
                    case 1: 
                        if (!gami.getCarta().isEmpty()) {
                            valor.setText(gami.getCarta().get(0));
                        }
                        break;
                    case 2: valor.setText("Gráfico de progreso"); break;
                    case 3: valor.setText("01/06/2023"); break; // Ejemplo
                    case 4: valor.setText("Nivel " + (gami.getPts()/100)); break;
                }
            }

            row.add(label, BorderLayout.WEST);
            row.add(valor, BorderLayout.CENTER);
            row.setBorder(new EmptyBorder(5, 10, 5, 10));
            dataPanel.add(row);
        }

        if (gami == null) {
            JOptionPane.showMessageDialog(panel, 
                "No tienes datos de progreso aún.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(dataPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelSalir() {
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
            new Index().setVisible(true);
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