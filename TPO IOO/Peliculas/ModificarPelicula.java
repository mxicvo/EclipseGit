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

public class ModificarPelicula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static ModificarPelicula frameMP = new ModificarPelicula();
	private JTextField IdInput;


	/**
	 * Create the frame.
	 */
	public ModificarPelicula() {
		setTitle("Modifique su pelicula");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 26, 70, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre Pelicula:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(37, 80, 114, 14);
		contentPane.add(lblNombre);
		
		IdInput = new JTextField();
		IdInput.setBounds(101, 25, 168, 20);
		contentPane.add(IdInput);
		IdInput.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(99, 132, 125, 14);
		contentPane.add(lblGenero);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracion.setBounds(37, 157, 114, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdioma.setBounds(37, 182, 114, 20);
		contentPane.add(lblIdioma);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(87, 64, 242, 2);
		contentPane.add(separator);
		
		JTextArea NombreOutput = new JTextArea();
		NombreOutput.setBounds(161, 77, 168, 20);
		contentPane.add(NombreOutput);
		
		JTextArea GeneroOutput = new JTextArea();
		GeneroOutput.setBounds(161, 129, 168, 20);
		contentPane.add(GeneroOutput);
		
		JTextArea DuracionOutput = new JTextArea();
		DuracionOutput.setBounds(161, 154, 168, 20);
		contentPane.add(DuracionOutput);
		
		JTextArea IdiomaOutput = new JTextArea();
		IdiomaOutput.setBounds(161, 182, 168, 20);
		contentPane.add(IdiomaOutput);
		
		JTextArea DirectorOutput = new JTextArea();
		DirectorOutput.setBounds(161, 104, 168, 20);
		contentPane.add(DirectorOutput);
		
		JTextArea SubtitulosOutput = new JTextArea();
		SubtitulosOutput.setBounds(161, 207, 168, 20);
		contentPane.add(SubtitulosOutput);
		
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDirector.setBounds(16, 107, 135, 14);
		contentPane.add(lblDirector);
		
		JLabel lblSubtitulos = new JLabel("Subtitulos:");
		lblSubtitulos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtitulos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubtitulos.setBounds(10, 207, 141, 20);
		contentPane.add(lblSubtitulos);
		
		JLabel lblCalificacion = new JLabel("Calificacion:");
		lblCalificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCalificacion.setBounds(10, 230, 141, 20);
		contentPane.add(lblCalificacion);
		
		JTextArea CalificacionesOutput = new JTextArea();
		CalificacionesOutput.setBounds(161, 230, 168, 20);
		contentPane.add(CalificacionesOutput);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblObservaciones.setBounds(10, 255, 141, 20);
		contentPane.add(lblObservaciones);
		
		JTextArea ObservacionesOutput = new JTextArea();
		ObservacionesOutput.setBounds(161, 255, 168, 20);
		contentPane.add(ObservacionesOutput);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				MenuPrincipal.sistema.modificarPelicula(Integer.parseInt(IdInput.getText()),NombreOutput.getText(),DirectorOutput.getText(),GeneroOutput.getText(),DuracionOutput.getText(),
						IdiomaOutput.getText(),SubtitulosOutput.getText(),Float.parseFloat(CalificacionesOutput.getText()),ObservacionesOutput.getText());
				JOptionPane.showMessageDialog(null, "Pelicula modificada", "PM",JOptionPane.CLOSED_OPTION);
			}
			
		});
		btnModificar.setBounds(161, 289, 100, 20);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pelicula pe = MenuPrincipal.sistema.buscarPelicula(Integer.parseInt(IdInput.getText()));
				if (pe != null) {
					btnModificar.setVisible(true);
					NombreOutput.setText(pe.getNombre());
					DirectorOutput.setText(pe.getDirector());
					GeneroOutput.setText(pe.getGenero());
					DuracionOutput.setText(pe.getDuracion());
					IdiomaOutput.setText(pe.getIdioma());
					SubtitulosOutput.setText(pe.getSubtitulos());
					CalificacionesOutput.setText(Float.toString(pe.getCalificacion()));
					ObservacionesOutput.setText(pe.getObservaciones());
			}
				else
					JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		});
		btnBuscar.setBounds(279, 24, 89, 23);
		contentPane.add(btnBuscar);

	}
}