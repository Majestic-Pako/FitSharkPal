package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.ConfigRutina;
import BLL.Gamificacion;
import DLL.Cliente;

import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class MenuCoach extends JFrame {

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
					MenuCoach frame = new MenuCoach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
    public MenuCoach(int idCuenta) {
        this(); // Llama al constructor sin parámetros
        this.idCuenta = idCuenta;
        setTitle("Menú Entrenador - ID: " + idCuenta); // Ejemplo de uso
    }
	/**
	 * Create the frame.
	 */
	public MenuCoach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 504, 301);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Menu de Alumnos", null, layeredPane, null);
		layeredPane.setLayout(null);
		
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.setBounds(191, 228, 89, 23);
		btnIngreso.setBackground(new Color(0, 128, 128));
		btnIngreso.setForeground(Color.WHITE);
		btnIngreso.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnIngreso.setMaximumSize(new Dimension(100, 40));
		layeredPane.add(btnIngreso);
		
	    btnIngreso.addActionListener(e -> {
	        this.dispose();
	        CrudJF crud = new CrudJF(idCuenta);
	        crud.setVisible(true);
	    });
		
		JLabel lblNewLabel_1 = new JLabel("Acceso a Menu de Alumnos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(146, 25, 219, 31);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Crear Cuentas para Clientes");
		lblNewLabel_2.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/boton.png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(134, 96, 231, 23);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Asignar Rutinas a los Alumnos");
		lblNewLabel_3.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/boton.png")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(134, 162, 231, 23);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Eliminar Cuenta");
		lblNewLabel_4.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/boton.png")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(134, 195, 130, 23);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Editar Perfiles de los Clientes");
		lblNewLabel_5.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/boton.png")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(134, 129, 231, 23);
		layeredPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(294, 50, 54, 3);
		layeredPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ver Alumnos");
		lblNewLabel_2_1.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/boton.png")));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(134, 66, 231, 23);
		layeredPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 499, 273);
		lblNewLabel.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/banner-coach.png")));
		layeredPane.add(lblNewLabel);
		
		JPanel panelRutinas = createVerRutinaPanel();
		tabbedPane.addTab("Ver Rutinas Activas", null, panelRutinas, null);
		
		JPanel panelPuntajes = createPuntajesPanel();
		tabbedPane.addTab("Visualizar Puntajes", null, panelPuntajes, null);
		
		JPanel panelSalir = createSalirPanel();
		tabbedPane.addTab("Salir", null, panelSalir, null);
	}
	
	private JPanel createVerRutinaPanel() {
	    JPanel mainPanel = new JPanel(new BorderLayout());
	    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

	    LinkedList<Cliente> listaClientes = Cliente.Listado();
	    JComboBox<Cliente> comboClientes = new JComboBox<>();
	    
	    for(Cliente cliente : listaClientes) {
	        comboClientes.addItem(cliente);
	    }
	    
	    comboClientes.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, 
	                boolean isSelected, boolean cellHasFocus) {
	            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            if (value instanceof Cliente) {
	                setText(((Cliente)value).getNombre());
	            }
	            return this;
	        }
	    });
	    
	    JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    selectionPanel.setBorder(new TitledBorder("Seleccionar Alumno"));
	    selectionPanel.add(new JLabel("Alumno:"));
	    selectionPanel.add(comboClientes);
	    mainPanel.add(selectionPanel, BorderLayout.NORTH);

	    String[] etiquetas = {
	        "Cardio:", "Zona Media:", "Piernas:", "Brazos:", "Pecho:", 
	        "Espalda:", "Duración cardio:", "Repeticiones:", "Series:", 
	        "Peso (kg):", "Descanso (seg):", "Puntaje:", "Carta:"
	    };
	    
	    JLabel[] valores = new JLabel[etiquetas.length];
	    JPanel dataPanel = new JPanel();
	    dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
	    dataPanel.setBorder(new TitledBorder("Detalles de la Rutina"));
	    
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
	    
	    comboClientes.addActionListener(e -> {
	        Cliente cliente = (Cliente) comboClientes.getSelectedItem();
	        if (cliente != null) {
	            ConfigRutina rutina = ConfigRutina.RutinaVer(cliente.getIdCuenta());
	            Gamificacion gami = Gamificacion.GamiVer(cliente.getIdCuenta());
	            
	            if (rutina != null && gami != null) {
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
	                valores[11].setText(String.valueOf(gami.getPts()));
	                valores[12].setText(gami.getCarta().get(0));
	            } else {
	                for (JLabel valor : valores) {
	                    valor.setText("-");
	                }
	                JOptionPane.showMessageDialog(mainPanel, 
	                    cliente.getNombre() + " no tiene rutina asignada",
	                    "Información", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    });

	    if (comboClientes.getItemCount() > 0) {
	        comboClientes.setSelectedIndex(0);
	    }
	    
	    JScrollPane scrollPane = new JScrollPane(dataPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    mainPanel.add(scrollPane, BorderLayout.CENTER);
	    return mainPanel;
	}
	
	
	private JPanel createPuntajesPanel() {
	    JPanel panel = new JPanel(new BorderLayout());
	    
	    DefaultTableModel model = new DefaultTableModel(new String[]{"Alumno", "Puntaje", "Carta"}, 0);
	    
	    LinkedList<Cliente> clientes = Cliente.Listado();
	    for (Cliente cliente : clientes) {
	        Gamificacion gami = Gamificacion.GamiVer(cliente.getIdCuenta());
	        if (gami != null) {
	            model.addRow(new Object[]{
	                cliente.getNombre(),
	                gami.getPts(),
	                gami.getCarta().get(0)
	            });
	        }
	    }
	    
	    JTable table = new JTable(model);
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    panel.add(scrollPane, BorderLayout.CENTER);
	    tabbedPane.addTab("Puntajes", panel);
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
