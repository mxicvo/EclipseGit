	package Salas;

import Establecimientos.Establecimiento;

public class Sala extends Establecimiento {

    private final int id;
    private String nombre;
    private int cantLugares;
    private boolean disponibilidad;

	public Sala(int id, String nombre, int cantLugares) {
		super(cantLugares, nombre, cantLugares, nombre, cantLugares, cantLugares);
		this.id = id;
		this.nombre = nombre;
		this.cantLugares = cantLugares;
		disponibilidad=true;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad() {
		if(disponibilidad==true)
			disponibilidad=false;
		else
			disponibilidad=true;
}
	

	public int getCantLugares() {
		return cantLugares;
	}

	public void setCantLugares(int cantLugares) {
		this.cantLugares = cantLugares;
	}
	
	public boolean sosLaSala(int id) {
		return this.id == id;
	}

}
