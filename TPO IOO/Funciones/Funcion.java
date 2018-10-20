package Funciones;
import java.time.LocalDate;
import java.util.Vector;

import Establecimientos.Establecimiento;
import Peliculas.Pelicula;
import Salas.Sala;
import Ventas.Entrada;

public class Funcion {

    private int id;
    private LocalDate fecha;
    private Sala laSala;
    private Pelicula laPelicula;
    private Establecimiento elEstablecimiento;
    private Vector<Entrada> entradas;
    private int lugaresDisponibles;
    private boolean disponible;

	public Funcion(int id, LocalDate fecha, Sala laSala, Establecimiento establecimiento, Pelicula laPelicula) {
		this.id = id;
		this.fecha = fecha;
		this.laSala = laSala;
		this.laPelicula = laPelicula;
		entradas = new Vector<Entrada>();
		this.lugaresDisponibles = laSala.getCantLugares();
		this.elEstablecimiento = establecimiento;
		disponible=true;
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
	
	public boolean getDisponibilidad() {
		return disponible;
	}
	
	public void setDisponibilidad() {
			if(disponible==true)
				disponible=false;
			else
				disponible=true;
	}

	public Pelicula getLaPelicula() {
		return laPelicula;
	}

	public void agregarEntrada(Entrada entrada) {
		if (lugaresDisponibles > 0) {
			entradas.addElement(entrada);
			lugaresDisponibles--;
		}
	}

	public void sacarEntrada(Entrada entrada){
		entradas.removeElement(entrada);
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

	public void setLugaresDisponibles(int lugaresDisponibles) {
		this.lugaresDisponibles = lugaresDisponibles;
	}

	public Establecimiento getElEstablecimiento() {
		return elEstablecimiento;
	}

	public int getLugaresDisponibles() {
		return lugaresDisponibles;
	}

	public Vector<Entrada> getEntradas() {
		return entradas;
	}
	
	public boolean asientoOcupado(String asiento) {
		for(int i = 0 ; i < entradas.size() ; i++)
			if (entradas.elementAt(i).getAsiento().equals(asiento))
				return false;
		return true;
	}
}
