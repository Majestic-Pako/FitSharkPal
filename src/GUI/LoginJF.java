package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.Cuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJF frame = new LoginJF();
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
	public LoginJF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 52, 53));
		panel.setBounds(143, 0, 213, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginJF.class.getResource("/img/tiburon.png")));
		lblNewLabel_1.setBounds(82, 27, 32, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FitSharkPal");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(53, 69, 103, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(41, 110, 57, 21);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(32, 140, 124, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contraseña");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(41, 180, 91, 21);
		panel.add(lblNewLabel_3_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(32, 208, 124, 21);
		panel.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIngresar.setBounds(53, 249, 103, 21);
		panel.add(btnIngresar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginJF.class.getResource("/img/perfil.png")));
		lblNewLabel_4.setBounds(10, 109, 24, 24);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(LoginJF.class.getResource("/img/cerrar-con-llave.png")));
		lblNewLabel_4_1.setBounds(10, 177, 24, 24);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(LoginJF.class.getResource("/img/banner-login.png")));
		lblNewLabel.setBounds(0, 0, 502, 293);
		contentPane.add(lblNewLabel);
		
		btnIngresar.addActionListener(e -> {
		    String usuario = textField.getText();
		    String contrasena = new String(passwordField.getPassword());
		    
		    Cuenta<?> cuenta = Cuenta.Login(usuario, contrasena);
		    
		    if (cuenta != null) {
		        this.dispose(); 
		        
		        switch(cuenta.getRol()) {
		            case ENTRENADOR:
		                MenuCoach menuCoach = new MenuCoach(cuenta.getIdCuenta());
		                menuCoach.setVisible(true);
		                break;
		            case CLIENTE:
		                // Aquí iría la apertura del menú de cliente.... si tuviera uno :,v
		                break;
		            default:
		                JOptionPane.showMessageDialog(this, "Rol no reconocido");
		                new Index().setVisible(true); 
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
		    }
		});
	}
}
