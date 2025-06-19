package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Validacion;
import DLL.Cuenta;
import DLL.Rol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Index extends JFrame implements Validacion {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
	private JTextField txtBienvenidoAFitshark;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(Index.class.getResource("/img/shark.png")));
		lblNewLabel.setBounds(0, 0, 637, 150);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 149, 637, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtBienvenidoAFitshark = new JTextField();
		txtBienvenidoAFitshark.setBounds(223, 10, 223, 31);
		txtBienvenidoAFitshark.setBackground(new Color(128, 128, 128));
		txtBienvenidoAFitshark.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBienvenidoAFitshark.setText("Bienvenido a Fitsharkpal");
		panel.add(txtBienvenidoAFitshark);
		txtBienvenidoAFitshark.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(273, 68, 134, 31);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(new Color(128, 128, 128));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIniciarSesion.setBounds(273, 113, 134, 31);
		panel.add(btnIniciarSesion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(128, 128, 128));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(273, 159, 134, 31);
		panel.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/img/agregar-usuario.png")));
		lblNewLabel_1.setBounds(223, 73, 24, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Index.class.getResource("/img/usuario.png")));
		lblNewLabel_1_1.setBounds(223, 120, 24, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(Index.class.getResource("/img/salida.png")));
		lblNewLabel_1_2.setBounds(223, 166, 24, 24);
		panel.add(lblNewLabel_1_2);
		
		btnNewButton.addActionListener(e -> {
			String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
			String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

			if (ValidarRegistro(usuario, contrasena)) {
				int idCuenta = Cuenta.Registro(usuario, contrasena, "CLIENTE");
				if (idCuenta != -1) {
					JOptionPane.showMessageDialog(null, "Registro exitoso.");
				} else {
					JOptionPane.showMessageDialog(null, "Error en el registro.");
				}
			}
		});

		btnIniciarSesion.addActionListener(e -> {
			String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
			String contrasena = JOptionPane.showInputDialog("Ingrese contraseña:");

			if (!ValidarUsuario(usuario, contrasena)) return;

			Cuenta<?> cuenta = Cuenta.Login(usuario, contrasena);
			if (cuenta != null) {
				JOptionPane.showMessageDialog(null, "Bienvenido " + cuenta.getUsuario());
				int idCuentaSesion = cuenta.getIdCuenta();

				Rol rol = cuenta.getRol();
				switch (rol) {
					case CLIENTE:
						NavCliente(idCuentaSesion);
						break;
					case ENTRENADOR:
						NavCoach(idCuentaSesion);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Rol no reconocido.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
			}
		});

		btnSalir.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "fuiste :3");
			System.exit(0);
		});
	}
}
