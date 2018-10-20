package Usuarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaPeliculas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class ModificarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserInput;
	public static ModificarUsuario frameMU = new ModificarUsuario();
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public ModificarUsuario() {
		setTitle("Modifique el usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(24, 12, 69, 14);
		contentPane.add(lblUser);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(119, 101, 69, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTipo = new JLabel("Tipo de usuario: ");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(68, 223, 126, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomicilio.setBounds(119, 171, 69, 14);
		contentPane.add(lblDomicilio);
		
		UserInput = new JTextField();
		UserInput.setBounds(101, 11, 173, 20);
		contentPane.add(UserInput);
		UserInput.setColumns(10);
		
		JTextArea EmailOutput = new JTextArea();
		EmailOutput.setBounds(190, 98, 173, 20);
		contentPane.add(EmailOutput);
		
		JTextArea TipoOutput = new JTextArea();
		TipoOutput.setBounds(190, 220, 173, 20);
		contentPane.add(TipoOutput);
		
		JTextArea DomicilioOutput = new JTextArea();
		DomicilioOutput.setBounds(190, 168, 173, 23);
		contentPane.add(DomicilioOutput);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(92, 54, 242, 2);
		contentPane.add(separator);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(119, 76, 69, 14);
		contentPane.add(lblDni);
		
		JTextArea DniOutput = new JTextArea();
		DniOutput.setBounds(190, 73, 173, 20);
		contentPane.add(DniOutput);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(119, 123, 69, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 122, 173, 20);
		contentPane.add(passwordField);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(119, 148, 69, 14);
		contentPane.add(lblNombre);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setBounds(190, 145, 173, 20);
		contentPane.add(NombreOutput);
		
		JLabel lblFechaNac = new JLabel("Fecha nac (YY-MM-DD):");
		lblFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaNac.setBounds(-44, 196, 232, 14);
		contentPane.add(lblFechaNac);
		
		JTextArea FechaNacOutput = new JTextArea();
		FechaNacOutput.setBounds(190, 194, 173, 23);
		contentPane.add(FechaNacOutput);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setVisible(false);
		btnConfirmar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.sistema.modificarUsuario(Integer.parseInt(DniOutput.getText()),EmailOutput.getText(),passwordField.getText(),UserInput.getText(),DomicilioOutput.getText(),LocalDate.parse(FechaNacOutput.getText()),TipoOutput.getText());
				JOptionPane.showMessageDialog(null, "Usuario modificado", "UM",JOptionPane.CLOSED_OPTION);
			}
		});
		btnConfirmar.setBounds(153, 260, 121, 42);
		contentPane.add(btnConfirmar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario us = MenuPrincipal.sistema.buscarUsuario(UserInput.getText());
				if (us != null) {
					btnConfirmar.setVisible(true);
					DniOutput.setText(Integer.toString(us.getDni()));
					EmailOutput.setText(us.getEmail());
					passwordField.setText(us.getPassword());
					NombreOutput.setText(us.getNombre());
					DomicilioOutput.setText(us.getDomicilio());
					FechaNacOutput.setText(us.getFechaNac().toString());
					TipoOutput.setText(us.getTipoDeUsuario());
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			}
		});
		btnBuscar.setBounds(284, 10, 89, 23);
		contentPane.add(btnBuscar);
		
	
	}
}
