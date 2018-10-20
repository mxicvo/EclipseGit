package Funciones;

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

public class AgregarFuncion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static AgregarFuncion frameAF = new AgregarFuncion();
	private JTextField IdInput;
	private JTextField FechaInput;
	private JTextField SalaInput;
	private JTextField IdEstablInput;
	private JTextField IdSalaInput;
	private JTextField IdPeliInput;


	/**
	 * Create the frame.
	 */
	public AgregarFuncion() {
		setTitle("Agregue su funcion");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 12, 114, 14);
		contentPane.add(lblId);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(21, 43, 114, 14);
		contentPane.add(lblFecha);
		
		JLabel lblSala = new JLabel("Nombre:");
		lblSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSala.setBounds(21, 74, 114, 14);
		contentPane.add(lblSala);
		
		IdInput = new JTextField();
		IdInput.setBounds(145, 11, 168, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		FechaInput = new JTextField();
		FechaInput.setBounds(145, 42, 168, 20);
		contentPane.add(FechaInput);
		FechaInput.setColumns(10);
		
		SalaInput = new JTextField();
		SalaInput.setBounds(145, 73, 168, 20);
		contentPane.add(SalaInput);
		SalaInput.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcion f = MenuPrincipal.sistema.buscarFuncion(Integer.parseInt(IdInput.getText()));
				if (f == null) {
					MenuPrincipal.sistema.crearFuncion(Integer.parseInt(IdInput.getText()), LocalDate.parse(FechaInput.getText()),
							MenuPrincipal.sistema.buscarSala(Integer.parseInt(IdEstablInput.getText()),Integer.parseInt(IdSalaInput.getText())),
							MenuPrincipal.sistema.buscarEstablecimiento(Integer.parseInt(IdEstablInput.getText())),
							MenuPrincipal.sistema.buscarPelicula(Integer.parseInt(IdPeliInput.getText())));
					IdEstablInput.setText("");
					IdSalaInput.setText("");
					IdInput.setText("");
					FechaInput.setText("");
					IdPeliInput.setText("");
				}
				else
					JOptionPane.showMessageDialog(null, "ID de funcion ya existe");
			}
			
		});
		btnAgregar.setBounds(165, 210, 100, 27);
		contentPane.add(btnAgregar);
		
		JLabel lblIdEstablecimiento = new JLabel("ID Establecimiento:");
		lblIdEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento.setBounds(10, 136, 125, 14);
		contentPane.add(lblIdEstablecimiento);
		
		IdEstablInput = new JTextField();
		IdEstablInput.setBounds(145, 135, 168, 20);
		contentPane.add(IdEstablInput);
		IdEstablInput.setColumns(10);
		
		JLabel lblIdSala = new JLabel("ID Sala:");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdSala.setBounds(21, 167, 114, 14);
		contentPane.add(lblIdSala);
		
		IdSalaInput = new JTextField();
		IdSalaInput.setBounds(145, 166, 168, 20);
		contentPane.add(IdSalaInput);
		IdSalaInput.setColumns(10);
		
		JLabel lblIdPelicula = new JLabel("ID Pelicula:");
		lblIdPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdPelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdPelicula.setBounds(21, 105, 114, 20);
		contentPane.add(lblIdPelicula);
		
		IdPeliInput = new JTextField();
		IdPeliInput.setBounds(145, 104, 168, 20);
		contentPane.add(IdPeliInput);
		IdPeliInput.setColumns(10);
	}
}
