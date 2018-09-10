package SistemaPeliculas;
import java.time.LocalDate;

public class Entrada {

    private static float precio;
    private Funcion funcion;
    private String asiento;
    private String nombrePeli;
    private String numSala;
    private LocalDate fecha;
    private String nombreEstablecimiento;

	public Entrada(Funcion funcion, String asiento) {
		this.funcion = funcion;
		nombrePeli = funcion.getLaPelicula().getNombre();
		numSala = funcion.getLaSala().getNombre();
		fecha = funcion.getFecha();
		nombreEstablecimiento = funcion.getLaSala().getNombreE();
		this.asiento = asiento;
	}

	public static float getPrecio() {
		return precio;
	}

	public static void setPrecio(float precio) {
		Entrada.precio = precio;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public String getAsiento() {
		return asiento;
	}

	public String getNombrePeli() {
		return nombrePeli;
	}

	public String getNumSala() {
		return numSala;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

}
