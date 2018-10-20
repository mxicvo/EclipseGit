package Ventas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Funciones.Funcion;
import SistemaPeliculas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class VenderEntradas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FuncionInput;
	private JTextField AsientoInput;
	public static VenderEntradas frameVE = new VenderEntradas();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField TipoTarjetaInput;
	private JTextField NumTarjetaInput;
	private JTextField VencimientoInput;
	private JTextField SeguridadInput;
	private JTextField ComisionInput;

	/**
	 * Create the frame.
	 */
	public VenderEntradas() {
		setTitle("Vender entradas");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panelCredito = new Panel();
		panelCredito.setBounds(10, 79, 412, 174);
		contentPane.add(panelCredito);
		panelCredito.setVisible(false);
		panelCredito.setLayout(null);
		
		JLabel lblTipoDeTarjeta = new JLabel("Tipo de Tarjeta:");
		lblTipoDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeTarjeta.setBounds(12, 13, 131, 16);
		panelCredito.add(lblTipoDeTarjeta);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Numero de Tarjeta:");
		lblNumeroDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDeTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTarjeta.setBounds(12, 42, 131, 16);
		panelCredito.add(lblNumeroDeTarjeta);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
		lblFechaVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaVencimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaVencimiento.setBounds(12, 71, 131, 16);
		panelCredito.add(lblFechaVencimiento);
		
		JLabel lblCodigoSeguridad = new JLabel("Codigo Seguridad:");
		lblCodigoSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoSeguridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoSeguridad.setBounds(12, 100, 131, 19);
		panelCredito.add(lblCodigoSeguridad);
		
		TipoTarjetaInput = new JTextField();
		TipoTarjetaInput.setBounds(155, 11, 172, 22);
		panelCredito.add(TipoTarjetaInput);
		TipoTarjetaInput.setColumns(10);
		
		NumTarjetaInput = new JTextField();
		NumTarjetaInput.setBounds(155, 40, 172, 22);
		panelCredito.add(NumTarjetaInput);
		NumTarjetaInput.setColumns(10);
		
		VencimientoInput = new JTextField();
		VencimientoInput.setBounds(155, 69, 172, 22);
		panelCredito.add(VencimientoInput);
		VencimientoInput.setColumns(10);
		
		SeguridadInput = new JTextField();
		SeguridadInput.setBounds(155, 99, 172, 22);
		panelCredito.add(SeguridadInput);
		SeguridadInput.setColumns(10);
		
		Panel panelContado = new Panel();
		panelContado.setBounds(10, 79, 412, 174);
		contentPane.add(panelContado);
		panelContado.setVisible(false);
		panelContado.setLayout(null);
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPelicula.setBounds(12, 13, 56, 16);
		panelContado.add(lblPelicula);
		
		JTextArea PeliculaOutput = new JTextArea();
		PeliculaOutput.setEditable(false);
		PeliculaOutput.setBounds(67, 11, 174, 22);
		panelContado.add(PeliculaOutput);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSala.setBounds(249, 13, 40, 16);
		panelContado.add(lblSala);
		
		JTextArea SalaOutput = new JTextArea();
		SalaOutput.setEditable(false);
		SalaOutput.setBounds(301, 11, 99, 22);
		panelContado.add(SalaOutput);
		
		JLabel lblAsiento = new JLabel("Asiento:");
		lblAsiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAsiento.setBounds(12, 63, 56, 16);
		panelContado.add(lblAsiento);
		
		AsientoInput = new JTextField();
		AsientoInput.setBounds(67, 61, 99, 22);
		panelContado.add(AsientoInput);
		AsientoInput.setColumns(10);
		
		JTextArea DisponiblesOutput = new JTextArea();
		DisponiblesOutput.setEditable(false);
		DisponiblesOutput.setBounds(329, 63, 71, 22);
		panelContado.add(DisponiblesOutput);
		
		JLabel lblDisponibles = new JLabel("Disponibles:");
		lblDisponibles.setBounds(329, 44, 71, 16);
		panelContado.add(lblDisponibles);
		
		JLabel lblCantidadDeEntradas = new JLabel("Cant. Entradas:");
		lblCantidadDeEntradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidadDeEntradas.setBounds(12, 107, 111, 16);
		panelContado.add(lblCantidadDeEntradas);
		
		JTextArea EntradasOutput = new JTextArea();
		EntradasOutput.setEditable(false);
		EntradasOutput.setBounds(124, 105, 71, 22);
		panelContado.add(EntradasOutput);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(207, 108, 56, 16);
		panelContado.add(lblTotal);
		
		JTextArea TotalOutput = new JTextArea();
		TotalOutput.setEditable(false);
		TotalOutput.setBounds(249, 105, 123, 22);
		panelContado.add(TotalOutput);
		
		JButton btnConfirmarVenta = new JButton("Confirmar Venta");
		btnConfirmarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float total = MenuPrincipal.sistema.cerrarVenta();
				JOptionPane.showMessageDialog(null, "Venta realizada con exito. Su ganancia es de: $" + total);
				panelContado.setVisible(false);
				FuncionInput.setText("");
				AsientoInput.setText("");
			}
		});
		btnConfirmarVenta.setBounds(111, 136, 145, 25);
		panelContado.add(btnConfirmarVenta);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 48, 246, 2);
		panelContado.add(separator);
		
		JButton btnAgregarAsiento = new JButton("Agregar asiento");
		btnAgregarAsiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				Funcion aux = MenuPrincipal.sistema.buscarFuncion(Integer.parseInt(FuncionInput.getText()));
				if (aux.asientoOcupado(AsientoInput.getText())) {
					aux.agregarEntrada(new Entrada(aux, AsientoInput.getText()));
					MenuPrincipal.sistema.agregarEntradaAVenta(Integer.parseInt(FuncionInput.getText()), AsientoInput.getText());
					DisponiblesOutput.setText(Integer.toString(aux.getLugaresDisponibles()));
					EntradasOutput.setText(Integer.toString(MenuPrincipal.sistema.getVentaActual().getEntradas().size()));
					TotalOutput.setText(Float.toString(MenuPrincipal.sistema.getVentaActual().calcularTotal()));
				}
				else
					JOptionPane.showMessageDialog(null, "Asiento no disponible");
			}
		});
		btnAgregarAsiento.setBounds(178, 60, 139, 25);
		panelContado.add(btnAgregarAsiento);
		
		JLabel lblIdFuncion = new JLabel("ID Funcion:");
		lblIdFuncion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdFuncion.setBounds(39, 11, 75, 25);
		contentPane.add(lblIdFuncion);
		
		FuncionInput = new JTextField();
		FuncionInput.setBounds(126, 13, 230, 22);
		contentPane.add(FuncionInput);
		FuncionInput.setColumns(10);
		
		JRadioButton rdbtnContado = new JRadioButton("Contado");
		buttonGroup.add(rdbtnContado);
		rdbtnContado.setBounds(33, 48, 81, 25);
		contentPane.add(rdbtnContado);
		
		JRadioButton rdbtnCredito = new JRadioButton("Credito");
		buttonGroup.add(rdbtnCredito);
		rdbtnCredito.setBounds(114, 48, 81, 25);
		contentPane.add(rdbtnCredito);
		
		JButton btnIniciarVenta = new JButton("Iniciar Venta");
		btnIniciarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcion aux = MenuPrincipal.sistema.buscarFuncion(Integer.parseInt(FuncionInput.getText()));
				if (aux != null && !(!rdbtnContado.isSelected() && !rdbtnCredito.isSelected())) {
					if (rdbtnContado.isSelected()) {
						panelContado.setVisible(true);
						MenuPrincipal.sistema.iniciarVentaContado();
					}
					if (rdbtnCredito.isSelected()) {
						panelCredito.setVisible(true);
						ComisionInput.setText(Float.toString(VentaCredito.getComision()));
					}
					PeliculaOutput.setText(aux.getLaPelicula().getNombre());
					SalaOutput.setText(aux.getLaSala().getNombre());
					DisponiblesOutput.setText(Integer.toString(aux.getLugaresDisponibles()));
					EntradasOutput.setText("0");
					TotalOutput.setText("$0");
				}
				else
					JOptionPane.showMessageDialog(null, "ID de funcion incorrecto / Seleccione un metodo de pago");
			}
		});
		btnIniciarVenta.setBounds(222, 48, 134, 25);
		contentPane.add(btnIniciarVenta);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.sistema.iniciarVentaCredito(TipoTarjetaInput.getText(), Integer.parseInt(NumTarjetaInput.getText()),
						LocalDate.parse(VencimientoInput.getText()), Integer.parseInt(SeguridadInput.getText()));
				panelContado.setVisible(true);
				panelCredito.setVisible(false);
			}
		});
		btnContinuar.setBounds(300, 134, 100, 25);
		panelCredito.add(btnContinuar);
		
		JLabel lblyymmdd = new JLabel("(YY-MM-DD)");
		lblyymmdd.setBounds(332, 72, 80, 16);
		panelCredito.add(lblyymmdd);
		
		JLabel lblComision = new JLabel("Comision:");
		lblComision.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComision.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblComision.setBounds(0, 139, 67, 16);
		panelCredito.add(lblComision);
		
		ComisionInput = new JTextField();
		ComisionInput.setBounds(79, 135, 86, 22);
		panelCredito.add(ComisionInput);
		ComisionInput.setColumns(10);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.sistema.cambiarComisionVenta(Float.parseFloat(ComisionInput.getText()));
				ComisionInput.setText(Float.toString(VentaCredito.getComision()));
			}
		});
		btnCambiar.setBounds(177, 134, 97, 25);
		panelCredito.add(btnCambiar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 124, 252, 2);
		panelCredito.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(286, 134, 1, 27);
		panelCredito.add(separator_2);
	}
}
