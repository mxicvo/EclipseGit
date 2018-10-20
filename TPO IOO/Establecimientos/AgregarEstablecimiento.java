package Establecimientos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaPeliculas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AgregarEstablecimiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdInput;
	private JTextField CuitInput;
	private JTextField NombreInput;
	private JTextField DomicilioInput;
	private JTextField CantSalasInput;
	private JTextField CapacTotalInput;
	private JButton btnNewButton;
	public static AgregarEstablecimiento frameAE = new AgregarEstablecimiento();


	/**
	 * Create the frame.
	 */
	public AgregarEstablecimiento() {
		setTitle("Agregue un establecimiento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(62, 7, 59, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomicilio.setBounds(46, 106, 75, 24);
		contentPane.add(lblDomicilio);
		
		JLabel lblCuit = new JLabel("CUIT:");
		lblCuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuit.setBounds(62, 40, 59, 20);
		contentPane.add(lblCuit);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(39, 71, 82, 24);
		contentPane.add(lblNombre);
		
		JLabel lblCapacidad = new JLabel("Capacidad salas:");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCapacidad.setBounds(5, 130, 116, 31);
		contentPane.add(lblCapacidad);
		
		JLabel lblCapacidadTotal = new JLabel("Capacidad total:");
		lblCapacidadTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidadTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCapacidadTotal.setBounds(5, 164, 116, 24);
		contentPane.add(lblCapacidadTotal);
		
		IdInput = new JTextField();
		IdInput.setBounds(131, 11, 209, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		CuitInput = new JTextField();
		CuitInput.setBounds(131, 42, 209, 20);
		contentPane.add(CuitInput);
		CuitInput.setColumns(10);
		
		NombreInput = new JTextField();
		NombreInput.setColumns(10);
		NombreInput.setBounds(131, 73, 209, 20);
		contentPane.add(NombreInput);
		
		DomicilioInput = new JTextField();
		DomicilioInput.setColumns(10);
		DomicilioInput.setBounds(131, 106, 209, 20);
		contentPane.add(DomicilioInput);
		
		CantSalasInput = new JTextField();
		CantSalasInput.setColumns(10);
		CantSalasInput.setBounds(131, 137, 209, 20);
		contentPane.add(CantSalasInput);
		
		CapacTotalInput = new JTextField();
		CapacTotalInput.setColumns(10);
		CapacTotalInput.setBounds(131, 168, 209, 20);
		contentPane.add(CapacTotalInput);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Establecimiento es = MenuPrincipal.sistema.buscarEstablecimiento(Integer.parseInt(IdInput.getText()));
				if (es == null) {
					MenuPrincipal.sistema.crearEstablecimiento(Integer.parseInt(IdInput.getText()), NombreInput.getText(), Integer.parseInt(CuitInput.getText()), DomicilioInput.getText(), Integer.parseInt(CantSalasInput.getText()), Integer.parseInt(CapacTotalInput.getText()));
					IdInput.setText("");
					NombreInput.setText("");
					CuitInput.setText("");
					DomicilioInput.setText("");
					CantSalasInput.setText("");
					CapacTotalInput.setText("");
					JOptionPane.showMessageDialog(null, "Establecimiento agregado", "EA", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "ID de establecimiento ya existe");
			}
		});
		btnNewButton.setBounds(154, 208, 130, 31);
		contentPane.add(btnNewButton);
	}
}
