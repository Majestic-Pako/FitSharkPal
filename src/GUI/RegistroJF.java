package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DLL.Cuenta;
import BLL.Validacion;

public class RegistroJF extends JFrame implements Validacion {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

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
        setTitle("Registro de Cuenta - FitSharkPal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 520, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtUsuario = new JTextField();
        txtUsuario.setBounds(155, 112, 200, 25);
        contentPane.add(txtUsuario);
        
        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(155, 167, 200, 25);
        contentPane.add(txtContrasena);
        
        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(179, 234, 120, 30);
        contentPane.add(btnRegistrar);
        btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRegistrar.setBackground(new Color(70, 130, 180));
        btnRegistrar.setForeground(Color.WHITE);
        
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(35, 169, 104, 17);
        contentPane.add(lblContrasena);
        lblContrasena.setForeground(new Color(255, 255, 255));
        lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(54, 114, 71, 17);
        contentPane.add(lblUsuario);
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel lblTitulo = new JLabel("Crear Nueva Cuenta", SwingConstants.CENTER);
        lblTitulo.setBounds(193, 37, 164, 20);
        contentPane.add(lblTitulo);
        lblTitulo.setBackground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(0, 64, 128));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RegistroJF.class.getResource("/img/banner-jf.png")));
        lblNewLabel.setBounds(0, 0, 502, 293);
        contentPane.add(lblNewLabel);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarCuenta();
            }
        });
    }
    
    private void registrarCuenta() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());
        
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Usuario y contraseña son requeridos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ValidarRegistro(usuario, contrasena)) {
            int idNuevo = Cuenta.Registro(usuario, contrasena, "cliente");
            
            if (idNuevo != -1) {
                JOptionPane.showMessageDialog(this, 
                    "Cuenta creada exitosamente. ID: ", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Index().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Error al registrar la cuenta", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Datos inválidos. Usuario debe tener al menos 4 caracteres y contraseña al menos 6", 
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}