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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarSala extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EstablecimientoInput;
	private JTextField SalaInput;
	private JTextField NombreInput;
	private JTextField AsientosInput;
	public static AgregarSala frameAS = new AgregarSala();

	/**
	 * Create the frame.
	 */
	public AgregarSala() {
		setTitle("Agregue nueva Sala");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEstablecimiento = new JLabel("ID Establecimiento:");
		lblIdEstablecimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento.setBounds(55, 34, 125, 14);
		contentPane.add(lblIdEstablecimiento);
		
		JLabel lblIdSala = new JLabel("ID Sala:");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdSala.setBounds(55, 71, 125, 14);
		contentPane.add(lblIdSala);
		
		JLabel lblNombreSala = new JLabel("Nombre Sala:");
		lblNombreSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreSala.setBounds(55, 106, 125, 14);
		contentPane.add(lblNombreSala);
		
		JLabel lblCantidadAsientos = new JLabel("Cantidad Asientos:");
		lblCantidadAsientos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadAsientos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadAsientos.setBounds(55, 142, 125, 14);
		contentPane.add(lblCantidadAsientos);
		
		EstablecimientoInput = new JTextField();
		EstablecimientoInput.setBounds(190, 33, 177, 20);
		contentPane.add(EstablecimientoInput);
		EstablecimientoInput.setColumns(10);
		
		SalaInput = new JTextField();
		SalaInput.setBounds(190, 70, 177, 20);
		contentPane.add(SalaInput);
		SalaInput.setColumns(10);
		
		NombreInput = new JTextField();
		NombreInput.setBounds(190, 105, 177, 20);
		contentPane.add(NombreInput);
		NombreInput.setColumns(10);
		
		AsientosInput = new JTextField();
		AsientosInput.setBounds(190, 141, 177, 20);
		contentPane.add(AsientosInput);
		AsientosInput.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sala s = MenuPrincipal.sistema.buscarSala(Integer.parseInt(EstablecimientoInput.getText()), Integer.parseInt(SalaInput.getText()));
				if (s == null) {
					MenuPrincipal.sistema.crearSala(Integer.parseInt(EstablecimientoInput.getText()), Integer.parseInt(SalaInput.getText()),
						NombreInput.getText(), Integer.parseInt(AsientosInput.getText()));
					EstablecimientoInput.setText("");
					SalaInput.setText("");
					NombreInput.setText("");
					AsientosInput.setText("");
				}
				else
					JOptionPane.showMessageDialog(null, "El ID de la sala ya existe");
			}
		});
		btnAgregar.setBounds(146, 193, 125, 34);
		contentPane.add(btnAgregar);
	}

}
