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
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class ModificarEstablecimiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdInput;
	public static ModificarEstablecimiento frameME = new ModificarEstablecimiento();


	/**
	 * Create the frame.
	 */
	public ModificarEstablecimiento() {
		setTitle("Modifique el establecimiento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(47, 12, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(57, 83, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCuit = new JLabel("Cuit: ");
		lblCuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuit.setBounds(57, 114, 69, 14);
		contentPane.add(lblCuit);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomicilio.setBounds(57, 145, 69, 14);
		contentPane.add(lblDomicilio);
		
		IdInput = new JTextField();
		IdInput.setBounds(101, 11, 173, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setBounds(136, 80, 173, 20);
		contentPane.add(NombreOutput);
		
		JTextArea CuitOutput = new JTextArea();
		CuitOutput.setBounds(136, 111, 173, 20);
		contentPane.add(CuitOutput);
		
		JTextArea DomicilioOutput = new JTextArea();
		DomicilioOutput.setBounds(136, 142, 173, 23);
		contentPane.add(DomicilioOutput);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(92, 54, 242, 2);
		contentPane.add(separator);		
		
		JLabel ldlCantidadSalas = new JLabel("Cantidad de Salas:");
		ldlCantidadSalas.setHorizontalAlignment(SwingConstants.RIGHT);
		ldlCantidadSalas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ldlCantidadSalas.setBounds(0, 175, 126, 14);
		contentPane.add(ldlCantidadSalas);
		
		JTextArea CantSalasOutput = new JTextArea();
		CantSalasOutput.setBounds(136, 170, 173, 23);
		contentPane.add(CantSalasOutput);
		
		JLabel lblCapacidadTotal = new JLabel("CapacidadTotal:");
		lblCapacidadTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidadTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCapacidadTotal.setBounds(0, 201, 126, 14);
		contentPane.add(lblCapacidadTotal);
		
		JTextArea CapacidadOutput = new JTextArea();
		CapacidadOutput.setBounds(136, 201, 173, 23);
		contentPane.add(CapacidadOutput);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setVisible(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.sistema.modificarEstablecimiento(Integer.parseInt(IdInput.getText()), NombreOutput.getText(),Integer.parseInt(CuitOutput.getText()), DomicilioOutput.getText(),Integer.parseInt(CantSalasOutput.getText()),Integer.parseInt(CapacidadOutput.getText()));
				JOptionPane.showMessageDialog(null, "Establecimiento modificado", "EM",JOptionPane.CLOSED_OPTION);
			}
		});
		btnConfirmar.setBounds(153, 238, 121, 42);
		contentPane.add(btnConfirmar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Establecimiento es = MenuPrincipal.sistema.buscarEstablecimiento(Integer.parseInt(IdInput.getText()));
				if (es != null) {
					btnConfirmar.setVisible(true);
					NombreOutput.setText(es.getNombreE());
					CuitOutput.setText(Integer.toString(es.getCuit()));
					DomicilioOutput.setText(es.getDomicilio());
					CantSalasOutput.setText(Integer.toString(es.getCantSalas()));
					CapacidadOutput.setText(Integer.toString(es.getCapacidadTotal()));
				}
				else
					JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		});
		btnBuscar.setBounds(284, 10, 89, 23);
		contentPane.add(btnBuscar);

	}
}
