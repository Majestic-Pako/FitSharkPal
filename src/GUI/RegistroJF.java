package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Point;

public class RegistroJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroJF frame = new RegistroJF();
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
	public RegistroJF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 131, 152));
		panel.setBounds(0, 0, 504, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(33, 200, 89, 23);
		panel.add(btnNewButton);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBorder(null);
		txtNombre.setAlignmentY(Component.TOP_ALIGNMENT);
		txtNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setText("\nnombre"); //con n sale el espacio para que no se vea pegado al borde
		txtNombre.setBackground(new Color(72, 113, 153));
		txtNombre.setBounds(35, 90, 102, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setAlignmentY(Component.TOP_ALIGNMENT);
		passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBorder(null);
		passwordField.setBounds(33, 155, 117, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(35, 55, 90, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(35, 120, 90, 35);
		panel.add(lblNewLabel_1);
	}
}
