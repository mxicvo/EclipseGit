package SistemaPeliculas;
import java.time.LocalDate;
import java.util.*;

public abstract class Venta {

    protected int numero;
    protected LocalDate fecha;
    protected Vector<Entrada>entradas;
    protected float total;

	private static int proxNumero;
    
	public static int getProxNumero()
	{
		return ++proxNumero;
	}
	
    public Venta() {
		numero = getProxNumero();
		this.fecha = LocalDate.now();
		this.total = 0;
		entradas = new Vector<Entrada>();
	}
    

	public LocalDate getFecha() {
		return fecha;
	}
	
	public int getNumero() {
		return numero;
	}

	public void agregarEntrada(Funcion funcion, String asiento) {
        Entrada ent = new Entrada(funcion, asiento);
        entradas.addElement(ent);
        total = calcularTotal();
    }
	
	public boolean sosLaVenta(int nro) {
		return numero==nro;
	}
	
    public void cambiarPrecioEntrada(int id,float nuevoPrecio) {
    }

    public abstract float calcularTotal();
    
    

}