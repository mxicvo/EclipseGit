package Usuarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaPeliculas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AgregarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdInput;
	private JTextField EmailInput;
	private JTextField NombreInput;
	private JTextField DomicilioInput;
	private JTextField DniInput;
	private JTextField FechaNacInput;
	private JPasswordField passwordField;
	private JLabel tipoLabel;
	public static AgregarUsuario frameAU = new AgregarUsuario();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public AgregarUsuario() {
		setTitle("Agregue un usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IdLabel = new JLabel("ID:");
		IdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		IdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IdLabel.setBounds(10, 12, 119, 14);
		contentPane.add(IdLabel);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmailLabel.setBounds(10, 37, 119, 14);
		contentPane.add(EmailLabel);
		
		JLabel PassLabel = new JLabel("Password:");
		PassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PassLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PassLabel.setBounds(10, 62, 115, 14);
		contentPane.add(PassLabel);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NombreLabel.setBounds(10, 87, 115, 14);
		contentPane.add(NombreLabel);
		
		JLabel DomicilioLabel = new JLabel("Domicilio:");
		DomicilioLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		DomicilioLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DomicilioLabel.setBounds(10, 112, 115, 14);
		contentPane.add(DomicilioLabel);
		
		JLabel DniLabel = new JLabel("DNI:");
		DniLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		DniLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DniLabel.setBounds(10, 137, 115, 14);
		contentPane.add(DniLabel);
		
		JLabel FechaNacLabel = new JLabel("Fecha nacimiento:");
		FechaNacLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FechaNacLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FechaNacLabel.setBounds(0, 162, 125, 14);
		contentPane.add(FechaNacLabel);
		
		IdInput = new JTextField();
		IdInput.setBounds(135, 11, 222, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		EmailInput = new JTextField();
		EmailInput.setColumns(10);
		EmailInput.setBounds(135, 37, 222, 20);
		contentPane.add(EmailInput);
		
		NombreInput = new JTextField();
		NombreInput.setColumns(10);
		NombreInput.setBounds(135, 86, 222, 20);
		contentPane.add(NombreInput);
		
		DomicilioInput = new JTextField();
		DomicilioInput.setColumns(10);
		DomicilioInput.setBounds(135, 111, 222, 20);
		contentPane.add(DomicilioInput);
		
		DniInput = new JTextField();
		DniInput.setColumns(10);
		DniInput.setBounds(135, 136, 222, 20);
		contentPane.add(DniInput);
		
		FechaNacInput = new JTextField();
		FechaNacInput.setColumns(10);
		FechaNacInput.setBounds(135, 161, 222, 20);
		contentPane.add(FechaNacInput);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 61, 222, 20);
		contentPane.add(passwordField);
		
		tipoLabel = new JLabel("Tipo de usuario:");
		tipoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tipoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tipoLabel.setBounds(10, 187, 119, 15);
		contentPane.add(tipoLabel);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(135, 188, 69, 14);
		contentPane.add(rdbtnAdmin);
		
		JRadioButton rdbtnOperador = new JRadioButton("Operador");
		buttonGroup.add(rdbtnOperador);
		rdbtnOperador.setBounds(206, 185, 79, 22);
		contentPane.add(rdbtnOperador);
		
		JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
		buttonGroup.add(rdbtnVendedor);
		rdbtnVendedor.setBounds(287, 185, 98, 23);
		contentPane.add(rdbtnVendedor);
		
		JLabel lblyymmdd = new JLabel("(YY-MM-DD)");
		lblyymmdd.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblyymmdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblyymmdd.setBounds(355, 164, 69, 14);
		contentPane.add(lblyymmdd);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = MenuPrincipal.sistema.buscarUsuario(NombreInput.getText());
				if (u == null) {
					if (rdbtnAdmin.isSelected())
						MenuPrincipal.sistema.crearUsuario(Integer.parseInt(DniInput.getText()), EmailInput.getText(),String.valueOf(passwordField.getPassword()),
								NombreInput.getText(), DomicilioInput.getText(), LocalDate.parse(FechaNacInput.getText()), "Administrador");
					if (rdbtnOperador.isSelected())
						MenuPrincipal.sistema.crearUsuario(Integer.parseInt(DniInput.getText()), EmailInput.getText(),String.valueOf(passwordField.getPassword()),
								NombreInput.getText(), DomicilioInput.getText(), LocalDate.parse(FechaNacInput.getText()), "Operador");
					if (rdbtnVendedor.isSelected())
						MenuPrincipal.sistema.crearUsuario(Integer.parseInt(DniInput.getText()), EmailInput.getText(),String.valueOf(passwordField.getPassword()),
								NombreInput.getText(), DomicilioInput.getText(), LocalDate.parse(FechaNacInput.getText()), "Vendedor");
					IdInput.setText("");
					EmailInput.setText("");
					NombreInput.setText("");
					passwordField.setText("");
					DomicilioInput.setText("");
					DniInput.setText("");
					FechaNacInput.setText("");
					JOptionPane.showMessageDialog(null, "Usuario agregado", "EA", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe");
			}
		});
		btnAgregar.setBounds(145, 217, 132, 33);
		contentPane.add(btnAgregar);
	}
}
