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

public class MenuCoach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

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
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(191, 218, 89, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Acceso a Menu de Alumnos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(146, 25, 202, 31);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Crear Cuentas para Clientes");
		lblNewLabel_2.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/flecha.png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(134, 106, 231, 23);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Asignar Rutinas a los Alumnos");
		lblNewLabel_3.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/flecha.png")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(134, 157, 231, 23);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Eliminar Cuenta");
		lblNewLabel_4.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/flecha.png")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(177, 184, 130, 23);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Editar Perfiles de los Clientes");
		lblNewLabel_5.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/flecha.png")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(134, 130, 231, 23);
		layeredPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Poder Visualizar los Datos de los Alumnos");
		lblNewLabel_6.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/flecha.png")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(109, 84, 280, 23);
		layeredPane.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBounds(294, 50, 54, 3);
		layeredPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(87, 63, 10, 23);
		layeredPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(87, 63, 28, 10);
		layeredPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(349, 197, 28, 10);
		layeredPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(367, 174, 10, 23);
		layeredPane.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 499, 273);
		lblNewLabel.setIcon(new ImageIcon(MenuCoach.class.getResource("/img/banner-coach.png")));
		layeredPane.add(lblNewLabel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Ver Rutinas Activas", null, layeredPane_1, null);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Visualizar Puntajes", null, layeredPane_2, null);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Salir", null, layeredPane_3, null);
	}
}
