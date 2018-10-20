package Salas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaPeliculas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarSala extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SalaInput;
	private JTextField EstablecimientoInput;
	public static EliminarSala frameES = new EliminarSala();

	/**
	 * Create the frame.
	 */
	public EliminarSala() {
		setTitle("Elimine una sala");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdSala = new JLabel("ID Sala:");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdSala.setBounds(45, 52, 88, 19);
		contentPane.add(lblIdSala);
		
		JLabel lblNombreSala = new JLabel("Nombre Sala:");
		lblNombreSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreSala.setBounds(20, 112, 133, 19);
		contentPane.add(lblNombreSala);
		
		JLabel lblCantidadDeLugares = new JLabel("Cantidad de lugares:");
		lblCantidadDeLugares.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeLugares.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadDeLugares.setBounds(20, 150, 133, 19);
		contentPane.add(lblCantidadDeLugares);
		
		SalaInput = new JTextField();
		SalaInput.setBounds(143, 53, 182, 20);
		contentPane.add(SalaInput);
		SalaInput.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(95, 84, 242, 2);
		contentPane.add(separator);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setEditable(false);
		NombreOutput.setBounds(163, 111, 182, 20);
		contentPane.add(NombreOutput);
		
		JTextArea LugaresOutput = new JTextArea();
		LugaresOutput.setEditable(false);
		LugaresOutput.setBounds(163, 149, 182, 19);
		contentPane.add(LugaresOutput);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.sistema.eliminarSala(Integer.parseInt(EstablecimientoInput.getText()), Integer.parseInt(SalaInput.getText()));
				JOptionPane.showMessageDialog(null, "Sala eliminada", "FE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(132, 198, 108, 36);
		contentPane.add(btnEliminar);
		
		JLabel lblIdEstablecimiento_1 = new JLabel("ID Establecimiento:");
		lblIdEstablecimiento_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdEstablecimiento_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento_1.setBounds(10, 27, 125, 14);
		contentPane.add(lblIdEstablecimiento_1);
		
		EstablecimientoInput = new JTextField();
		EstablecimientoInput.setBounds(143, 26, 182, 20);
		contentPane.add(EstablecimientoInput);
		EstablecimientoInput.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sala s = MenuPrincipal.sistema.buscarSala(Integer.parseInt(EstablecimientoInput.getText()), Integer.parseInt(SalaInput.getText()));
				if (s != null) {
					btnEliminar.setVisible(true);
					NombreOutput.setText(s.getNombre());
					LugaresOutput.setText(Integer.toString(s.getCantLugares()));
				}
				else
					JOptionPane.showMessageDialog(null, "ID de sala o establecimiento incorrecto");
			}
		});
		btnBuscar.setBounds(335, 38, 89, 23);
		contentPane.add(btnBuscar);
	}
}
