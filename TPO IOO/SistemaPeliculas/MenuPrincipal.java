package SistemaPeliculas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Establecimientos.AgregarEstablecimiento;
import Establecimientos.EliminarEstablecimiento;
import Establecimientos.ModificarEstablecimiento;
import Funciones.AgregarFuncion;
import Funciones.EliminarFuncion;
import Funciones.Funcion;
import Funciones.ModificarFuncion;
import Peliculas.AgregarPelicula;
import Peliculas.EliminarPelicula;
import Peliculas.ModificarPelicula;
import Salas.AgregarSala;
import Salas.EliminarSala;
import Salas.ModificarSala;
import Usuarios.AgregarUsuario;
import Usuarios.EliminarUsuario;
import Usuarios.ModificarUsuario;
import Ventas.Entrada;
import Ventas.VenderEntradas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JSeparator;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static SistGestionVentaEntradas sistema = new SistGestionVentaEntradas();
	public static MenuPrincipal frameMP = new MenuPrincipal();
	private JTextField PeliculaInput;
	private JTextField PrecioInput;
	
	

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Sistema Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel Vendedor = new Panel();
		Vendedor.setBounds(0, 43, 434, 218);
		contentPane.add(Vendedor);
		Vendedor.setLayout(null);
		
		JButton btnVenderEntradas = new JButton("Vender Entradas");
		btnVenderEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VenderEntradas.frameVE.setVisible(true);
			}
		});
		btnVenderEntradas.setBounds(10, 86, 139, 44);
		Vendedor.add(btnVenderEntradas);
		
		JLabel lblNombrePelicula = new JLabel("Nombre Pelicula:");
		lblNombrePelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombrePelicula.setBounds(10, 0, 107, 19);
		Vendedor.add(lblNombrePelicula);
		
		PeliculaInput = new JTextField();
		PeliculaInput.setBounds(10, 23, 155, 20);
		Vendedor.add(PeliculaInput);
		PeliculaInput.setColumns(10);
		
		List listFunciones = new List();
		listFunciones.setBounds(171, 11, 253, 197);
		Vendedor.add(listFunciones);
		Vendedor.setVisible(false);
		
		JButton btnBuscarFunciones = new JButton("Buscar Funciones");
		btnBuscarFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0 ; i < sistema.getLongitudVectorFunciones()-1; i++)
					if (sistema.getElementFunciones(i).getLaPelicula().getNombre().equals(PeliculaInput.getText())) {
						Funcion func = sistema.getElementFunciones(i);
						listFunciones.add(PeliculaInput.getText().toUpperCase());
						listFunciones.add("ID: " + func.getId());
						listFunciones.add("FECHA: " + func.getFecha().toString());
						listFunciones.add("SALA: " + func.getLaSala().getNombre());
						listFunciones.add("LUGARES DISPONIBLES: " +  func.getLaSala().getCantLugares());
						listFunciones.add("\n");
					}
				}
		});
		btnBuscarFunciones.setBounds(10, 50, 139, 23);
		Vendedor.add(btnBuscarFunciones);
		
		PrecioInput = new JTextField();
		PrecioInput.setBounds(10, 150, 155, 22);
		Vendedor.add(PrecioInput);
		PrecioInput.setColumns(10);
		PrecioInput.setText(Float.toString(Entrada.getPrecio()));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 172, 2);
		Vendedor.add(separator);
		
		JLabel lblCambiarPrecio = new JLabel("Precio:");
		lblCambiarPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarPrecio.setBounds(10, 132, 73, 16);
		Vendedor.add(lblCambiarPrecio);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrada.setPrecio(Float.parseFloat(PrecioInput.getText()));
				PrecioInput.setText(Float.toString(Entrada.getPrecio()));
			}
		});
		btnCambiar.setBounds(36, 182, 97, 23);
		Vendedor.add(btnCambiar);
		
		Panel Operador = new Panel();
		Operador.setBounds(0, 42, 434, 219);
		contentPane.add(Operador);
		Operador.setVisible(false);
		
		JButton btnCargarPelicula = new JButton("Cargar Pelicula");
		btnCargarPelicula.setBounds(59, 1, 304, 31);
		btnCargarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarPelicula.frameAP.setVisible(true);
			}
		});
		Operador.setLayout(null);
		Operador.add(btnCargarPelicula);
		
		JButton btnEliminarPelicula = new JButton("Eliminar Pelicula");
		btnEliminarPelicula.setBounds(59, 32, 304, 31);
		btnEliminarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPelicula.frameEP.setVisible(true);
			}
		});
		Operador.add(btnEliminarPelicula);
		
		JButton btnModificarPelicula = new JButton("Modificar Pelicula");
		btnModificarPelicula.setBounds(59, 63, 304, 31);
		btnModificarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPelicula.frameMP.setVisible(true);
			}
		});
		Operador.add(btnModificarPelicula);
		
		JLabel Separador = new JLabel("");
		Separador.setBounds(0, 94, 434, 31);
		Operador.add(Separador);
		
		JButton btnCargarFuncion = new JButton("Cargar Funcion");
		btnCargarFuncion.setBounds(59, 125, 304, 31);
		btnCargarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarFuncion.frameAF.setVisible(true);
			}
		});
		Operador.add(btnCargarFuncion);
		
		JButton btnEliminarFuncion = new JButton("Eliminar Funcion");
		btnEliminarFuncion.setBounds(59, 156, 304, 31);
		btnEliminarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarFuncion.frameEF.setVisible(true);
			}
		});
		Operador.add(btnEliminarFuncion);
		
		JButton btnModificarFuncion = new JButton("Modificar Funcion");
		btnModificarFuncion.setBounds(59, 187, 304, 31);
		btnModificarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarFuncion.frameMF.setVisible(true);
			}
		});
		Operador.add(btnModificarFuncion);
		
		Panel SuperAdmin = new Panel();
		SuperAdmin.setBounds(0, 42, 434, 219);
		contentPane.add(SuperAdmin);
		SuperAdmin.setVisible(false);
		
		Button buttonCrearUsuario = new Button("Crear Usuario");
		buttonCrearUsuario.setBounds(38, 71, 112, 68);
		buttonCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarUsuario.frameAU.setVisible(true);
			}
		});
		SuperAdmin.setLayout(null);
		SuperAdmin.add(buttonCrearUsuario);
		
		Button buttonEliminarUsuario = new Button("Eliminar Usuario");
		buttonEliminarUsuario.setBounds(156, 71, 112, 68);
		buttonEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarUsuario.frameEU.setVisible(true);
			}
		});
		SuperAdmin.add(buttonEliminarUsuario);
		
		
		Button buttonModificarUsuario = new Button("Modificar Usuario");
		buttonModificarUsuario.setBounds(274, 71, 112, 68);
		buttonModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario.frameMU.setVisible(true);
			}
		});
		SuperAdmin.add(buttonModificarUsuario);
		
		Panel Administrador = new Panel();
		Administrador.setBounds(0, 43, 434, 218);
		contentPane.add(Administrador);
		Administrador.setVisible(false);
		
		JButton btnCrearSala = new JButton("Crear Sala");
		btnCrearSala.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCrearSala.setBounds(235, 11, 173, 52);
		btnCrearSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarSala.frameAS.setVisible(true);
			}
		});
		
		JButton btnCrearEstablecimiento = new JButton("Crear Establecimiento");
		btnCrearEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCrearEstablecimiento.setBounds(21, 11, 173, 53);
		btnCrearEstablecimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEstablecimiento frame=new AgregarEstablecimiento();
				frame.setVisible(true);
			}
		});
		
		JButton btnEliminarSala = new JButton("Eliminar Sala");
		btnEliminarSala.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminarSala.setBounds(235, 137, 173, 52);
		btnEliminarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarSala.frameES.setVisible(true);
			}
		});
		
		JButton btnModificarEstablecimiento = new JButton("Modificar Establecimiento");
		btnModificarEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificarEstablecimiento.setBounds(21, 75, 173, 52);
		btnModificarEstablecimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarEstablecimiento.frameME.setVisible(true);
			}
		});
		
		JButton btnModificarSala = new JButton("Modificar Sala");
		btnModificarSala.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificarSala.setBounds(235, 74, 173, 52);
		btnModificarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarSala.frameMS.setVisible(true);
			}
		});
		
		JButton btnEliminarEstablecimiento = new JButton("Eliminar Establecimiento");
		btnEliminarEstablecimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminarEstablecimiento.setBounds(21, 137, 173, 53);
		btnEliminarEstablecimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarEstablecimiento.frameEE.setVisible(true);
			}
		});
		Administrador.setLayout(null);
		Administrador.add(btnCrearSala);
		Administrador.add(btnCrearEstablecimiento);
		Administrador.add(btnEliminarSala);
		Administrador.add(btnModificarEstablecimiento);
		Administrador.add(btnModificarSala);
		Administrador.add(btnEliminarEstablecimiento);
		
		JLabel lblGestionDeEstablecimientos = new JLabel("Gestion de Establecimientos Cinematograficos");
		lblGestionDeEstablecimientos.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblGestionDeEstablecimientos.setBounds(0, 2, 330, 34);
		contentPane.add(lblGestionDeEstablecimientos);
		
		JButton btnDesloguear = new JButton("Log-out");
		btnDesloguear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.frameL.setVisible(true);
				Login.mp.setVisible(false);
			}
		});
		btnDesloguear.setBounds(340, 10, 89, 23);
		contentPane.add(btnDesloguear);
		
		if(Login.UserOk.getTipoDeUsuario().equals("Administrador"))
			Administrador.setVisible(true);
		if(Login.UserOk.getTipoDeUsuario().equals("Operador"))
			Operador.setVisible(true);
		if(Login.UserOk.getTipoDeUsuario().equals("SuperAdmin"))
			SuperAdmin.setVisible(true);
		if(Login.UserOk.getTipoDeUsuario().equals("Vendedor"))
			Vendedor.setVisible(true);
		
		sistema.crearEstablecimiento(1111, "Jorge", 122222, "Recoleta", 86, 90);
		sistema.crearSala(1111, 2222, "A8", 30);
		sistema.crearSala(1111, 2223, "B6", 40);
		sistema.crearSala(1111, 2224, "H4", 50);
		sistema.crearPelicula(3333, "Titanic", "Alberto", "Drama", "120", "Ingles", "Castellano", (float)9, "Jack se muere al final");
		sistema.crearPelicula(3338, "Deadpool 2", "Alberto", "Comedia", "120", "Ingles", "Castellano", (float)3, "Se muere pero no se muere");

		sistema.crearFuncion(12345, LocalDate.of(2019, 01, 25), sistema.buscarSala(1111, 2222), sistema.buscarEstablecimiento(1111), sistema.buscarPelicula(3333));
		sistema.crearFuncion(12346, LocalDate.of(2018, 11, 13), sistema.buscarSala(1111, 2223), sistema.buscarEstablecimiento(1111), sistema.buscarPelicula(3333));
		sistema.crearFuncion(12347, LocalDate.of(2018, 12, 24), sistema.buscarSala(1111, 2224), sistema.buscarEstablecimiento(1111), sistema.buscarPelicula(3333));
		sistema.crearFuncion(12348, LocalDate.of(2018, 12, 29), sistema.buscarSala(1111, 2224), sistema.buscarEstablecimiento(1111), sistema.buscarPelicula(3338));
		sistema.crearFuncion(12349, LocalDate.of(2018, 12, 24), sistema.buscarSala(1111, 2224), sistema.buscarEstablecimiento(1111), sistema.buscarPelicula(3338));

	}
}
