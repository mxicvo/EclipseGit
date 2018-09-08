package SistemaPeliculas;
import java.util.*;

public class Establecimiento {

    private int id;
    private String nombreE;
    private int cuit;
    private String domicilio;
    private int capacidadTotal;
    private int cantSalas;
    private Vector<Sala> salas;
    
	public Establecimiento(int id, String nombreE, int cuit, String domicilio, int capacidadTotal, int cantSalas) {
		super();
		this.id = id;
		this.nombreE = nombreE;
		this.cuit = cuit;
		this.domicilio = domicilio;
		this.capacidadTotal = capacidadTotal;
		this.cantSalas = cantSalas;
		salas = new Vector<Sala>();
	}

	public int getId() {
		return id;
	}

	public String getNombreE() {
		return nombreE;
	}

	public int getCuit() {
		return cuit;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getCapacidadTotal() {
		return capacidadTotal;
	}

	public int getCantSalas() {
		return cantSalas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setCapacidadTotal(int capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}

	public Vector<Sala> getSalas() {
		return salas;
	}
	
	public boolean sosElEstablecimiento(int id) 
	{
		return this.id == id;
	}
}