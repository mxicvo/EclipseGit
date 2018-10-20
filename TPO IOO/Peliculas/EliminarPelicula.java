package Peliculas;

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

public class EliminarPelicula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdInput;
	
	public static EliminarPelicula frameEP = new EliminarPelicula();
	


	/**
	 * Create the frame.
	 */
	public EliminarPelicula() {
		setTitle("Elimine una pelicula");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdPelicula = new JLabel("ID Pelicula");
		lblIdPelicula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdPelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdPelicula.setBounds(10, 24, 120, 26);
		contentPane.add(lblIdPelicula);
		
		IdInput = new JTextField();
		IdInput.setBounds(140, 26, 164, 26);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setEditable(false);
		NombreOutput.setBounds(159, 95, 164, 23);
		contentPane.add(NombreOutput);
		
		JTextArea GeneroOutput = new JTextArea();
		GeneroOutput.setEditable(false);
		GeneroOutput.setBounds(159, 132, 164, 23);
		contentPane.add(GeneroOutput);
		
		JTextArea DuracionOutput = new JTextArea();
		DuracionOutput.setEditable(false);
		DuracionOutput.setBounds(159, 170, 164, 26);
		contentPane.add(DuracionOutput);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.eliminarPelicula(Integer.parseInt(IdInput.getText()));
				JOptionPane.showMessageDialog(null, "Pelicula eliminada", "PE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(140, 218, 101, 32);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pe = MenuPrincipal.sistema.buscarPelicula(Integer.parseInt(IdInput.getText()));
				if (pe != null) {
					btnEliminar.setVisible(true);
					NombreOutput.setText(pe.getNombre());
					GeneroOutput.setText(pe.getGenero());
					DuracionOutput.setText(pe.getDuracion());
				}
				else
					JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		});
		btnBuscar.setBounds(314, 28, 89, 23);
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 74, 279, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(38, 98, 111, 14);
		contentPane.add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(38, 135, 111, 14);
		contentPane.add(lblGenero);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracion.setBounds(10, 168, 139, 24);
		contentPane.add(lblDuracion);
	}
}