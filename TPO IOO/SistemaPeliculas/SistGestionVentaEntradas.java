package SistemaPeliculas;
import java.time.LocalDate;
import java.util.*;

import Establecimientos.Establecimiento;
import Funciones.Funcion;
import Peliculas.Pelicula;
import Salas.Sala;
import Usuarios.Usuario;
import Ventas.Entrada;
import Ventas.Venta;
import Ventas.VentaContado;
import Ventas.VentaCredito;

public class SistGestionVentaEntradas {

    private Vector<Venta> Ventas;
    private Vector<Establecimiento> Establecimientos;
    private Vector<Usuario> Usuarios;
    private Vector<Pelicula> Peliculas;
    private Vector<Funcion> Funciones;
    private Venta ventaActual;

    public SistGestionVentaEntradas() {
    	Ventas=new Vector<Venta>();
    	Establecimientos=new Vector<Establecimiento>();
    	Usuarios=new Vector<Usuario>();
    	Peliculas=new Vector<Pelicula>();
    	Funciones=new Vector<Funcion>();
    	cargaInicial();
    }

    private void cargaInicial() {
		Peliculas.add(new Pelicula(1234,"Deadpool 2","Perez","Comedia","MuchoTiempo","English","No",4.0f,"Hay mejores"));
		Usuarios.add(new Usuario(1233,"ricardo@hotmail.com","123456","Ricardo","Lima 717",LocalDate.of(1938, 12, 22),"Operador"));
		
	}

	public void crearEstablecimiento(int id, String nombre,int cuit,String domicilio,int cantSalas,int capacidadTotal) 	{
		Establecimientos.add(new Establecimiento(id,nombre,cuit,domicilio,cantSalas,capacidadTotal));
	}

    public void modificarEstablecimiento(int id, String nombre,int cuit,String domicilio,int cantSalas,int capacidadTotal) {
		Establecimiento e = buscarEstablecimiento(id);
		if (e!=null) {
			e.setNombreE(nombre);
			e.setCuit(cuit);
			e.setDomicilio(domicilio);
			e.setCantSalas(cantSalas);
			e.setCapacidadTotal(capacidadTotal);
		}
    }

    public void eliminarEstablecimiento(int id) {
    	Establecimiento e =buscarEstablecimiento(id);
    	e.setDisponibilidad();
    }
    
    public Establecimiento buscarEstablecimiento(int id) {
		for (int i=0; i<Establecimientos.size();i++) {
			if (Establecimientos.elementAt(i).sosElEstablecimiento(id))
				return Establecimientos.elementAt(i);

		}
		return null;
	}

    public void crearPelicula(int id,String nombre,String director,String genero,String duracion,String idioma,String subtitulos,float calificacion,String observaciones) 	{
		Pelicula p = buscarPelicula(id);
		if (p==null) {
			p = new Pelicula(id,nombre,director,genero,duracion,idioma,subtitulos,calificacion,observaciones);
			Peliculas.add(p);
		}
	}


    public void modificarPelicula(int id,String nombre,String director,String genero,String duracion,String idioma,String subtitulos,float calificacion,String observaciones) {
		Pelicula p = buscarPelicula(id);
		if (p!=null) {
			p.setNombre(nombre);
			p.setDirector(director);
			p.setGenero(genero);
			p.setDuracion(duracion);
			p.setIdioma(idioma);
			p.setSubtitulos(subtitulos);
			p.setCalificacion(calificacion);
			p.setObservaciones(observaciones);
		}
    }

    public void eliminarPelicula(int id) {
     	Pelicula e=buscarPelicula(id);
     	int j=0;
     	for(int i=0;i<Funciones.size();i++)
     		if(Funciones.elementAt(i).getLaPelicula().getNombre().equals(e.getNombre()))
     			j=1;
     	if(j==0)			
     		e.setDisponibilidad();
    }
    
    public Pelicula buscarPelicula(int id) {
		for (int i=0; i<Peliculas.size();i++) {
		if (Peliculas.elementAt(i).sosLaPelicula(id))
			return Peliculas.elementAt(i);
	}
		return null;
	}

    public void crearFuncion(int id,LocalDate fecha,Sala laSala, Establecimiento establecimiento,Pelicula laPelicula) {
			Funciones.add(new Funcion(id, fecha, laSala, establecimiento, laPelicula));
	}

    public void modificarFuncion(int id,LocalDate fecha,Sala laSala,Pelicula laPelicula,int lugaresDisp) {
    	 Funcion f = buscarFuncion(id);
    	 if (f != null) {
    		 f.setFecha(fecha);
    		 f.setLaSala(laSala);
    		 f.setLaPelicula(laPelicula);
    		 f.setLugaresDisponibles(lugaresDisp);
    	 }
    }

     public void eliminarFuncion(int id) {
    	 Funcion f = buscarFuncion(id);
    	 if(f.getLugaresDisponibles()==f.getLaSala().getCantLugares())
    		 f.setDisponibilidad();
    }

     public Funcion buscarFuncion(int id) 	{
  		for (int i=0; i<Funciones.size();i++)
 		{
 			if (Funciones.elementAt(i).sosLaFuncion(id))
 				return Funciones.elementAt(i);

 		}
 		return null;
  	}
     
    public void crearUsuario(int dni, String email, String password, String nombre, String domicilio, LocalDate fechaNac,
			String tipoDeUsuario)
    {
    	Usuario u = buscarUsuario(nombre);
		if (u==null) {
			u = new Usuario(dni,email,password,nombre,domicilio,fechaNac,tipoDeUsuario);
			Usuarios.add(u);
		}
	}

   public void modificarUsuario(int dni, String email, String password, String nombre, String domicilio, LocalDate fechaNac,
			String tipoDeUsuario) {
		Usuario u = buscarUsuario(nombre);
		if (u!=null)
		{
			u.setDni(dni);
			u.setEmail(email);
			u.setPassword(password);
			u.setNombre(nombre);
			u.setDomicilio(domicilio);
			u.setFechaNac(fechaNac);
			u.setTipoDeUsuario(tipoDeUsuario);
		}
    }

    public void eliminarUsuario(String user) {
 		for (int i=0; i<Usuarios.size();i++)
			if (Usuarios.elementAt(i).sosElUsuario(user))
				Usuarios.elementAt(i).setDisponibilidad();
    }
    
    public Usuario buscarUsuario(String user) 	{
 		for (int i = 0; i < Usuarios.size(); i++) {
			if (Usuarios.elementAt(i).sosElUsuario(user))
				return Usuarios.elementAt(i);
		}
		return null;
 	}
    
	public int iniciarVentaContado()
	{
		VentaContado vta = new VentaContado();
		ventaActual = vta;
		return vta.getNumero();
	}

	public int iniciarVentaCredito(String tipoDeTarjeta, int numeroTarjeta, LocalDate fechaVtoTarjeta, int codSeguridadTarjeta)
	{
		VentaCredito vta = new VentaCredito(tipoDeTarjeta,numeroTarjeta,fechaVtoTarjeta,codSeguridadTarjeta);
		ventaActual = vta;
		return vta.getNumero();
	}
	
	public void agregarEntradaAVenta(int idFuncion, String asiento) {
		Funcion f = buscarFuncion(idFuncion);
		ventaActual.agregarEntrada(f, asiento);
	}
	
	public float cerrarVenta() {
		Ventas.addElement(ventaActual);
		return ventaActual.calcularGanancia();
	}

	public Venta getVentaActual() {
		return ventaActual;
	}

	public void crearSala(int idEstablecimiento, int idSala, String nombre, int cantLugares) {
		Establecimiento e = buscarEstablecimiento(idEstablecimiento);
		if (e!=null) {
			Sala s=new Sala(idSala, nombre, cantLugares);
			e.agregarSala(s);
		}
	}
	
	public void modificarSala(int idSala,int idEstablec, String nombre, int cantLugares) {
		Sala s = buscarSala(idEstablec,idSala);
		if (s!=null)
		{
			s.setNombre(nombre);
			s.setCantLugares(cantLugares);
		}
    }
	
	public void eliminarSala(int idEst,int idSala) {
		Establecimiento e=buscarEstablecimiento(idEst);
		e.eliminarSala(idSala);
	}
	
	 public Sala buscarSala(int idEstablecimiento, int idSala) 	{
	 		Establecimiento e = buscarEstablecimiento(idEstablecimiento);
	 		return e.buscarSala(idSala);
	 }

    public void cambiarPrecioEntrada(float nuevoPrecio) {
        Entrada.setPrecio(nuevoPrecio);
    }

	public void cambiarComisionVenta(float num){
		VentaCredito.setComision(num/100);
	}
	
	public int getLongitudVectorFunciones() {
		return Funciones.size();
	}
	
	public Funcion getElementFunciones(int i) {
		return Funciones.elementAt(i);
	}

}
