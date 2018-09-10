package SistemaPeliculas;

public class VentaCredito extends Venta {

    private String tipoDeTarjeta;
    private int numeroTarjeta;
    private String fechaVtoTarjeta;
    private int codSeguridadTarjeta;
    private static float comision;

    public VentaCredito(String tipoDeTarjeta, int numeroTarjeta, String fechaVtoTarjeta, int codSeguridadTarjeta) {
		super();
		this.tipoDeTarjeta = tipoDeTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVtoTarjeta = fechaVtoTarjeta;
		this.codSeguridadTarjeta = codSeguridadTarjeta;
	}

	public float calcularGanancia() {
        return (Entrada.getPrecio() * entradas.size()) * (1 - comision);
    }

	public String getTipoDeTarjeta() {
		return tipoDeTarjeta;
	}

	public void setTipoDeTarjeta(String tipoDeTarjeta) {
		this.tipoDeTarjeta = tipoDeTarjeta;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFechaVtoTarjeta() {
		return fechaVtoTarjeta;
	}

	public void setFechaVtoTarjeta(String fechaVtoTarjeta) {
		this.fechaVtoTarjeta = fechaVtoTarjeta;
	}

	public int getCodSeguridadTarjeta() {
		return codSeguridadTarjeta;
	}

	public void setCodSeguridadTarjeta(int codSeguridadTarjeta) {
		this.codSeguridadTarjeta = codSeguridadTarjeta;
	}

	public static float getComision() {
		return comision;
	}

	public static void setComision(float comision) {
		VentaCredito.comision = comision;
	}

}
