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

public class AgregarPelicula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameInput;
	private JTextField DirectorInput;
	private JTextField GeneroInput;
	private JTextField DuracionInput;
	private JTextField IdiomaInput;
	private JTextField SubInput;
	private JTextField CalifInput;
	private JTextField ObserInput;
	private JTextField IdInput;
	public static AgregarPelicula frameAP = new AgregarPelicula();



	/**
	 * Create the frame.
	 */
	public AgregarPelicula() {
		setTitle("Agregue una pelicula");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 26, 85, 25);
		contentPane.add(lblNombre);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirector.setBounds(10, 53, 85, 25);
		contentPane.add(lblDirector);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(10, 81, 85, 25);
		contentPane.add(lblGenero);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracion.setBounds(10, 107, 85, 25);
		contentPane.add(lblDuracion);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdioma.setBounds(10, 131, 85, 25);
		contentPane.add(lblIdioma);
		
		JLabel lblNewLabel = new JLabel("Subtitulos:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 157, 85, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Calificacion:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 181, 85, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Observaciones:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(-8, 206, 103, 25);
		contentPane.add(lblNewLabel_2);
		
		NameInput = new JTextField();
		NameInput.setBounds(105, 26, 257, 20);
		contentPane.add(NameInput);
		NameInput.setColumns(10);
		
		DirectorInput = new JTextField();
		DirectorInput.setColumns(10);
		DirectorInput.setBounds(105, 57, 257, 20);
		contentPane.add(DirectorInput);
		
		GeneroInput = new JTextField();
		GeneroInput.setColumns(10);
		GeneroInput.setBounds(105, 85, 257, 20);
		contentPane.add(GeneroInput);
		
		DuracionInput = new JTextField();
		DuracionInput.setColumns(10);
		DuracionInput.setBounds(105, 111, 257, 20);
		contentPane.add(DuracionInput);
		
		IdiomaInput = new JTextField();
		IdiomaInput.setColumns(10);
		IdiomaInput.setBounds(105, 135, 257, 20);
		contentPane.add(IdiomaInput);
		
		SubInput = new JTextField();
		SubInput.setColumns(10);
		SubInput.setBounds(105, 161, 257, 20);
		contentPane.add(SubInput);
		
		CalifInput = new JTextField();
		CalifInput.setColumns(10);
		CalifInput.setBounds(105, 185, 257, 20);
		contentPane.add(CalifInput);
		
		ObserInput = new JTextField();
		ObserInput.setColumns(10);
		ObserInput.setBounds(105, 210, 257, 20);
		contentPane.add(ObserInput);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.crearPelicula(Integer.parseInt(IdInput.getText()), NameInput.getText(), DirectorInput.getText(), GeneroInput.getText(), DuracionInput.getText(), IdiomaInput.getText(), SubInput.getText(), Float.parseFloat(CalifInput.getText()), ObserInput.getText());
				IdInput.setText("");
				NameInput.setText("");
				DirectorInput.setText("");
				GeneroInput.setText("");
				DuracionInput.setText("");
				IdiomaInput.setText("");
				SubInput.setText("");
				CalifInput.setText("");
				ObserInput.setText("");
				JOptionPane.showMessageDialog(null, "Pelicula agregada", "PA", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(161, 236, 115, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 0, 85, 21);
		contentPane.add(lblId);
		
		IdInput = new JTextField();
		IdInput.setBounds(106, 0, 256, 19);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
	}

}
