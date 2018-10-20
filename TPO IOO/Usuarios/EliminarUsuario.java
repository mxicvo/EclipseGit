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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class EliminarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsuarioInput;
	
	public static EliminarUsuario frameEU = new EliminarUsuario();
	


	/**
	 * Create the frame.
	 */
	public EliminarUsuario() {
		setTitle("Elimine un usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 24, 120, 26);
		contentPane.add(lblUsuario);
		
		UsuarioInput = new JTextField();
		UsuarioInput.setBounds(140, 26, 164, 26);
		contentPane.add(UsuarioInput);
		UsuarioInput.setColumns(10);
		
		JTextArea DniOutput = new JTextArea();
		DniOutput.setEditable(false);
		DniOutput.setBounds(140, 95, 207, 23);
		contentPane.add(DniOutput);
		
		JTextArea EmailOutput = new JTextArea();
		EmailOutput.setEditable(false);
		EmailOutput.setBounds(140, 132, 207, 23);
		contentPane.add(EmailOutput);
		
		JTextArea TipoOutput = new JTextArea();
		TipoOutput.setEditable(false);
		TipoOutput.setBounds(140, 170, 207, 26);
		contentPane.add(TipoOutput);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.eliminarUsuario(UsuarioInput.getText());
				JOptionPane.showMessageDialog(null, "Usuario eliminado", "UE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(140, 218, 101, 32);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario us = MenuPrincipal.sistema.buscarUsuario(UsuarioInput.getText());
				if (us != null) {
					btnEliminar.setVisible(true);
					DniOutput.setText(Integer.toString(us.getDni()));
					EmailOutput.setText(us.getEmail());
					TipoOutput.setText(us.getTipoDeUsuario());
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			}
		});
		btnBuscar.setBounds(314, 28, 89, 23);
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 74, 279, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("DNI:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(19, 98, 111, 14);
		contentPane.add(lblNombre);
		
		JLabel lblGenero = new JLabel("Email:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(19, 135, 111, 14);
		contentPane.add(lblGenero);
		
		JLabel lblDuracion = new JLabel("Tipo de usuario:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracion.setBounds(19, 168, 111, 24);
		contentPane.add(lblDuracion);
	}
}