package SistemaPeliculas;

public class VentaContado extends Venta {

    public VentaContado() {
		super();
	}

	public float calcularTotal() {
        return Entrada.getPrecio() * entradas.size();
    }
}