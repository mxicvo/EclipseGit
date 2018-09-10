package SistemaPeliculas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	public static SistGestionVentaEntradas sistema = new SistGestionVentaEntradas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbmPeliculas = new JButton("ABM Peliculas");
		btnAbmPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPeliculas frame= new MenuPeliculas();
				frame.setVisible(true);				
			}
		});
		btnAbmPeliculas.setBounds(136, 94, 146, 23);
		contentPane.add(btnAbmPeliculas);
		
		JButton btnAbmEstablecimientos = new JButton("ABM Establecimientos");
		btnAbmEstablecimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEstablecimientos frame= new MenuEstablecimientos();
				frame.setVisible(true);				
			}
		});
		btnAbmEstablecimientos.setBounds(136, 26, 146, 23);
		contentPane.add(btnAbmEstablecimientos);
		
		JButton btnAbmUsuarios = new JButton("ABM Usuarios");
		btnAbmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuarios frame= new MenuUsuarios();
				frame.setVisible(true);
			}
		});
		btnAbmUsuarios.setBounds(136, 128, 146, 23);
		contentPane.add(btnAbmUsuarios);
		
		JButton btnAbmFunciones = new JButton("ABM Funciones");
		btnAbmFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFunciones frame= new MenuFunciones();
				frame.setVisible(true);
			}
		});
		btnAbmFunciones.setBounds(136, 60, 146, 23);
		contentPane.add(btnAbmFunciones);
		
		JButton btnVentaDeEntradas = new JButton("Venta de entradas");
		btnVentaDeEntradas.setBounds(136, 162, 146, 23);
		contentPane.add(btnVentaDeEntradas);
		btnVentaDeEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
