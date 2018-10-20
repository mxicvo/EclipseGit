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
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class ModificarFuncion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static ModificarFuncion frameMF = new ModificarFuncion();
	private JTextField IdInput;


	/**
	 * Create the frame.
	 */
	public ModificarFuncion() {
		setTitle("Modifique su funcion");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 26, 70, 14);
		contentPane.add(lblId);
		
		JLabel lblSala = new JLabel("Nombre Pelicula:");
		lblSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSala.setBounds(37, 80, 114, 14);
		contentPane.add(lblSala);
		
		IdInput = new JTextField();
		IdInput.setBounds(101, 25, 168, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		JLabel lblIdEstablecimiento = new JLabel("ID Establecimiento:");
		lblIdEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento.setBounds(26, 132, 125, 14);
		contentPane.add(lblIdEstablecimiento);
		
		JLabel lblIdSala = new JLabel("ID Sala:");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdSala.setBounds(37, 157, 114, 14);
		contentPane.add(lblIdSala);
		
		JLabel lblIdPelicula = new JLabel("ID Pelicula:");
		lblIdPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdPelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdPelicula.setBounds(37, 182, 114, 20);
		contentPane.add(lblIdPelicula);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(87, 64, 242, 2);
		contentPane.add(separator);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setBounds(161, 77, 168, 20);
		contentPane.add(NombreOutput);
		
		JTextArea IdEstabOut = new JTextArea();
		IdEstabOut.setBounds(161, 129, 168, 20);
		contentPane.add(IdEstabOut);
		
		JTextArea IdSalaOutput = new JTextArea();
		IdSalaOutput.setBounds(161, 154, 168, 20);
		contentPane.add(IdSalaOutput);
		
		JTextArea IdPeliOut = new JTextArea();
		IdPeliOut.setBounds(161, 182, 168, 20);
		contentPane.add(IdPeliOut);
		
		JTextArea FechaOutput = new JTextArea();
		FechaOutput.setBounds(161, 104, 168, 20);
		contentPane.add(FechaOutput);
		
		JTextArea LugaresOutput = new JTextArea();
		LugaresOutput.setBounds(161, 207, 168, 20);
		contentPane.add(LugaresOutput);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.modificarFuncion(Integer.parseInt(IdInput.getText()), LocalDate.parse(FechaOutput.getText()),
					MenuPrincipal.sistema.buscarSala(Integer.parseInt(IdEstabOut.getText()),Integer.parseInt(IdSalaOutput.getText())),
					MenuPrincipal.sistema.buscarPelicula(Integer.parseInt(IdPeliOut.getText())), Integer.parseInt(LugaresOutput.getText()));
				JOptionPane.showMessageDialog(null, "Funcion modificada", "EM",JOptionPane.CLOSED_OPTION);
			}
			
		});
		btnModificar.setBounds(137, 238, 100, 20);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcion f = MenuPrincipal.sistema.buscarFuncion(Integer.parseInt(IdInput.getText()));
				if (f != null) {
					btnModificar.setVisible(true);
					NombreOutput.setText(f.getLaPelicula().getNombre());
					FechaOutput.setText(f.getFecha().toString());
					IdEstabOut.setText(Integer.toString(f.getElEstablecimiento().getId()));
					IdSalaOutput.setText(Integer.toString(f.getLaSala().getId()));
					IdPeliOut.setText(Integer.toString(f.getLaPelicula().getId()));
					LugaresOutput.setText(Integer.toString(f.getLugaresDisponibles()));
				}
				else
					JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		});
		btnBuscar.setBounds(279, 24, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblFechayymmdd = new JLabel("Fecha (YY-MM-DD):");
		lblFechayymmdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechayymmdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechayymmdd.setBounds(16, 107, 135, 14);
		contentPane.add(lblFechayymmdd);
		
		JLabel lblLugaresDisponibles = new JLabel("Lugares Disponibles:");
		lblLugaresDisponibles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugaresDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLugaresDisponibles.setBounds(10, 207, 141, 20);
		contentPane.add(lblLugaresDisponibles);
	}
}