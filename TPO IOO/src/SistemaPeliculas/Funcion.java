package SistemaPeliculas;
import java.time.LocalDate;

public class Funcion {

    private int id;
    private LocalDate fecha;
    private Sala laSala;
    private Pelicula laPelicula;
    private DiccionarioSimple lugares;
    private int lugaresDisponibles;
    
	public Funcion(int id, LocalDate fecha, Sala laSala, Pelicula laPelicula) {
		this.id = id;
		this.fecha = fecha;
		this.laSala = laSala;
		this.laPelicula = laPelicula;
		lugares = new DiccionarioSimple();
		this.lugaresDisponibles = laSala.getCantLugares();
	}
	
	public int getId() {
		return id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Sala getLaSala() {
		return laSala;
	}
	
	public Pelicula getLaPelicula() {
		return laPelicula;
	}
	
	public DiccionarioSimple getLugares() {
		return lugares;
	}
	
	public void ocuparLugar(String lugar) {
		if (lugaresDisponibles > 0) {
			lugares.agregar(lugar, true);
			lugaresDisponibles--;
		}	
	}
	
	public void desocuparLugar(String lugar) {
		lugares.agregar(lugar, false);
		lugaresDisponibles++;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setLaSala(Sala laSala) {
		this.laSala = laSala;
	}

	public void setLaPelicula(Pelicula laPelicula) {
		this.laPelicula = laPelicula;
	}
	
	
	
	public boolean sosLaFuncion(int id) 
	{
		return this.id == id;
	}
}