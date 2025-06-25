package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrudJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudJF frame = new CrudJF();
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
	public CrudJF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tabbedPane.setBounds(0, 0, 482, 293);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab(" Datos", null, layeredPane, null);
		
		JLabel lblNewLabel = new JLabel("Listado de los Alumnos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(161, 10, 154, 19);
		layeredPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 31, 477, 231);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab(" Registro", null, layeredPane_1, null);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab(" Editar", null, layeredPane_2, null);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab(" Asignar Rutina", null, layeredPane_3, null);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab(" Eliminar", null, layeredPane_4, null);
		
		JLayeredPane layeredPane_5 = new JLayeredPane();
		tabbedPane.addTab(" Volver", null, layeredPane_5, null);
	}
}
