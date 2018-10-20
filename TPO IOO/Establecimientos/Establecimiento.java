package Establecimientos;
import java.util.*;

import Salas.Sala;

public class Establecimiento {

    private int id;
    private String nombreE;
    private int cuit;
    private boolean disponibilidad;
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
		disponibilidad=true;
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
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad() {
		if(disponibilidad==true)
			disponibilidad=false;
		else
			disponibilidad=true;
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
	
	public void setCantSalas(int cantSalas) {
		this.cantSalas = cantSalas;
	}

	public void agregarSala(Sala LaSala) {
		salas.addElement(LaSala);
	}

	public boolean sosElEstablecimiento(int id)
	{
		return this.id == id;
	}
	
	 public Sala buscarSala(int id) 	{
	 		for (int i = 0; i < salas.size(); i++) {
				if (salas.elementAt(i).sosLaSala(id))
					return salas.elementAt(i);
			}
			return null;
	 }
	 
	 public void eliminarSala(int id) {
		 for(int i=0;i<salas.size();i++)
			 if(salas.elementAt(i).getId()==id) {
				 salas.elementAt(i).setDisponibilidad();
		 		break;
			 }		 
	 }
}
