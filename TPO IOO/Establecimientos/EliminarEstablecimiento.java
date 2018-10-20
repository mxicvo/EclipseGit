package Establecimientos;

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

public class EliminarEstablecimiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdInput;
	
	public static EliminarEstablecimiento frameEE = new EliminarEstablecimiento();
	


	/**
	 * Create the frame.
	 */
	public EliminarEstablecimiento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEstablecimiento = new JLabel("ID Establecimiento");
		lblIdEstablecimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento.setBounds(10, 24, 120, 26);
		contentPane.add(lblIdEstablecimiento);
		
		IdInput = new JTextField();
		IdInput.setBounds(140, 26, 164, 26);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setEditable(false);
		NombreOutput.setBounds(159, 95, 164, 23);
		contentPane.add(NombreOutput);
		
		JTextArea DomicilioOutput = new JTextArea();
		DomicilioOutput.setEditable(false);
		DomicilioOutput.setBounds(159, 132, 164, 23);
		contentPane.add(DomicilioOutput);
		
		JTextArea SalasOutput = new JTextArea();
		SalasOutput.setEditable(false);
		SalasOutput.setBounds(159, 170, 164, 26);
		contentPane.add(SalasOutput);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.eliminarEstablecimiento(Integer.parseInt(IdInput.getText()));
				JOptionPane.showMessageDialog(null, "Establecimiento eliminado", "EE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(140, 218, 101, 32);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Establecimiento es = MenuPrincipal.sistema.buscarEstablecimiento(Integer.parseInt(IdInput.getText()));
				if (es != null) {
					btnEliminar.setVisible(true);
					NombreOutput.setText(es.getNombreE());
					DomicilioOutput.setText(es.getDomicilio());
					SalasOutput.setText(Integer.toString(es.getCantSalas()));
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
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomicilio.setBounds(38, 135, 111, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblCantidadDeSalas = new JLabel("Cantidad de Salas:");
		lblCantidadDeSalas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeSalas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadDeSalas.setBounds(10, 168, 139, 24);
		contentPane.add(lblCantidadDeSalas);
	}
}
