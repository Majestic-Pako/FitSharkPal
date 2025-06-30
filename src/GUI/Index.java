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
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarse = new JButton(" Registrarse");
		btnRegistrarse.setIcon(new ImageIcon(Index.class.getResource("/img/editar.png")));
		btnRegistrarse.setBounds(174, 202, 163, 31);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.setBackground(new Color(255, 255, 255));
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnIniciarSesion = new JButton(" Iniciar Sesion");
		btnIniciarSesion.setIcon(new ImageIcon(Index.class.getResource("/img/perfil-del-usuario.png")));
		btnIniciarSesion.setBounds(174, 161, 163, 31);
		contentPane.add(btnIniciarSesion);
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSalir = new JButton(" Salir");
		btnSalir.setIcon(new ImageIcon(Index.class.getResource("/img/cerrar-sesion.png")));
		btnSalir.setBounds(174, 243, 163, 31);
		contentPane.add(btnSalir);
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 132, 506, 171);
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/img/banner.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Index.class.getResource("/img/fit.png")));
		lblNewLabel.setBounds(0, 0, 150, 135);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(149, 0, 357, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("FitSharkPal");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(71, 40, 197, 51);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 128));
		panel_1.setBounds(160, 81, 53, 6);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
        btnRegistrarse.addActionListener(e -> {
            this.dispose(); 
            RegistroJF registro = new RegistroJF();
            registro.setVisible(true);
        });
        
        btnIniciarSesion.addActionListener(e -> {
            this.dispose(); 
            LoginJF login = new LoginJF();
            login.setVisible(true);
        });
        
        btnSalir.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(
                this, 
                "¿Está seguro que desea salir?", 
                "Confirmar salida", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
	}
}
