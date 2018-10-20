package Funciones;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import SistemaPeliculas.MenuPrincipal;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class EliminarFuncion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdFuncion;
	public static EliminarFuncion frameEF = new EliminarFuncion();


	/**
	 * Create the frame.
	 */
	public EliminarFuncion() {
		setTitle("Elimine la funcion");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IdFuncion = new JTextField();
		IdFuncion.setBounds(121, 24, 181, 26);
		contentPane.add(IdFuncion);
		IdFuncion.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.eliminarFuncion(Integer.parseInt(IdFuncion.getText()));
				JOptionPane.showMessageDialog(null, "Funcion eliminada", "FE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(148, 216, 101, 34);
		contentPane.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(105, 70, 215, 2);
		contentPane.add(separator);
		
		JLabel lblNombrePelicula = new JLabel("Nombre Pelicula:");
		lblNombrePelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombrePelicula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePelicula.setBounds(44, 95, 130, 26);
		contentPane.add(lblNombrePelicula);
		
		JLabel lblIdFuncion = new JLabel("ID Funcion:");
		lblIdFuncion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdFuncion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdFuncion.setBounds(10, 25, 101, 20);
		contentPane.add(lblIdFuncion);
		
		JLabel lblNombreSala = new JLabel("Nombre Sala:");
		lblNombreSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreSala.setBounds(44, 135, 130, 25);
		contentPane.add(lblNombreSala);
		
		JLabel lblLugaresDisponibles = new JLabel("Lugares Disponibles:");
		lblLugaresDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLugaresDisponibles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugaresDisponibles.setBounds(34, 171, 140, 23);
		contentPane.add(lblLugaresDisponibles);
		
		JTextArea PeliculaOutput = new JTextArea();
		PeliculaOutput.setEditable(false);
		PeliculaOutput.setBounds(184, 92, 181, 26);
		contentPane.add(PeliculaOutput);
		
		JTextArea SalaOutput = new JTextArea();
		SalaOutput.setEditable(false);
		SalaOutput.setBounds(184, 132, 181, 26);
		contentPane.add(SalaOutput);
		
		JTextArea LugaresOutput = new JTextArea();
		LugaresOutput.setEditable(false);
		LugaresOutput.setBounds(184, 168, 181, 26);
		contentPane.add(LugaresOutput);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcion f = MenuPrincipal.sistema.buscarFuncion(Integer.parseInt(IdFuncion.getText()));
				if (f != null) {
					btnEliminar.setVisible(true);
					PeliculaOutput.setText(f.getLaPelicula().getNombre());
					SalaOutput.setText(f.getLaSala().getNombre());
					LugaresOutput.setText(Integer.toString(f.getLugaresDisponibles()));
				}
				else
					JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		});
		btnBuscar.setBounds(312, 26, 89, 23);
		contentPane.add(btnBuscar);
	}
}
