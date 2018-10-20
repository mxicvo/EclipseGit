package SistemaPeliculas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Usuarios.Usuario;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField password;
	public static Usuario UserOk;
	static Login frameL = new Login();
    public static SistGestionVentaEntradas sistema = new SistGestionVentaEntradas();
    public static MenuPrincipal mp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameL.setVisible(true);
					sistema.crearUsuario(3043856, "testO@gmail.com", "12345", "testO", "Lanus", LocalDate.now(), "Operador");
					sistema.crearUsuario(4343224, "testA@gmail.com", "12345", "testA", "Tigre", LocalDate.now(), "Administrador");
					sistema.crearUsuario(6575676, "testSA@gmail.com", "12345", "testSA", "Tigre", LocalDate.now(), "SuperAdmin");
					sistema.crearUsuario(8454434, "testV@gmail.com", "12345", "testV", "Tigre", LocalDate.now(), "Vendedor");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Inicie sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField username = new JFormattedTextField();
		username.setBounds(151, 69, 137, 20);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setBounds(151, 120, 137, 20);
		contentPane.add(password);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsuario.setBounds(55, 70, 86, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblContrasea.setBounds(55, 121, 89, 19);
		contentPane.add(lblContrasea);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Usuario aux = sistema.buscarUsuario(username.getText());
				if (aux != null && aux.getPassword().equals(password.getText())) {
					UserOk=new Usuario(aux.getDni(), aux.getEmail(),aux.getPassword(), aux.getNombre(), aux.getDomicilio(),aux.getFechaNac(), aux.getTipoDeUsuario());
					username.setText("");
					password.setText("");
					mp = new MenuPrincipal();
					mp.setVisible(true);
					frameL.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
			}
		});
		btnLogin.setBounds(170, 178, 89, 23);
		contentPane.add(btnLogin);
	}
}
