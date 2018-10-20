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

public class ModificarSala extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EstablecimientoInput;
	private JTextField SalaInput;
	public static ModificarSala frameMS = new ModificarSala();

	/**
	 * Create the frame.
	 */
	public ModificarSala() {
		setTitle("Modifique la sala");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEstablecimiento = new JLabel("ID Establecimiento:");
		lblIdEstablecimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdEstablecimiento.setBounds(10, 20, 139, 14);
		contentPane.add(lblIdEstablecimiento);
		
		JLabel lblIdSala = new JLabel("ID Sala:");
		lblIdSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdSala.setBounds(10, 51, 139, 19);
		contentPane.add(lblIdSala);
		
		JLabel lblCantidadDeLugares = new JLabel("Cantidad de Lugares:");
		lblCantidadDeLugares.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadDeLugares.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadDeLugares.setBounds(27, 148, 139, 20);
		contentPane.add(lblCantidadDeLugares);
		
		JLabel lblNombre = new JLabel("Nombre Sala:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(27, 113, 139, 14);
		contentPane.add(lblNombre);
		
		EstablecimientoInput = new JTextField();
		EstablecimientoInput.setBounds(159, 19, 161, 20);
		contentPane.add(EstablecimientoInput);
		EstablecimientoInput.setColumns(10);
		
		SalaInput = new JTextField();
		SalaInput.setBounds(159, 50, 161, 20);
		contentPane.add(SalaInput);
		SalaInput.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 91, 300, 2);
		contentPane.add(separator);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setBounds(176, 110, 161, 20);
		contentPane.add(NombreOutput);
		
		JTextArea LugaresOutput = new JTextArea();
		LugaresOutput.setBounds(176, 148, 161, 19);
		contentPane.add(LugaresOutput);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.modificarSala(Integer.parseInt(SalaInput.getText()), Integer.parseInt(EstablecimientoInput.getText()),
						NombreOutput.getText(), Integer.parseInt(LugaresOutput.getText()));
				JOptionPane.showMessageDialog(null, "Sala modificada", "EM",JOptionPane.CLOSED_OPTION);
			}
		});
		btnModificar.setBounds(142, 200, 113, 35);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sala s = MenuPrincipal.sistema.buscarSala(Integer.parseInt(EstablecimientoInput.getText()), Integer.parseInt(SalaInput.getText()));
				if (s != null) {
					btnModificar.setVisible(true);
					NombreOutput.setText(s.getNombre());
					LugaresOutput.setText(Integer.toString(s.getCantLugares()));
				}
				else
					JOptionPane.showMessageDialog(null, "ID de sala o establecimiento incorrecto");
			}
		});
		btnBuscar.setBounds(330, 31, 89, 23);
		contentPane.add(btnBuscar);
	}

}
