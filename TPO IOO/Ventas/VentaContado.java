package Ventas;

public class VentaContado extends Venta {

    public VentaContado() {
		super();
	}

	public float calcularGanancia() {
        return Entrada.getPrecio() * entradas.size();
    }
}
