package SistemaPeliculas;

public class Sala extends Establecimiento {

    private int id;
    private String nombre;
    private int cantLugares;

	public Sala(int id, String nombre, int cantLugares) {
		super(cantLugares, nombre, cantLugares, nombre, cantLugares, cantLugares);
		this.id = id;
		this.nombre = nombre;
		this.cantLugares = cantLugares;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantLugares() {
		return cantLugares;
	}

	public void setCantLugares(int cantLugares) {
		this.cantLugares = cantLugares;
	}
	
}