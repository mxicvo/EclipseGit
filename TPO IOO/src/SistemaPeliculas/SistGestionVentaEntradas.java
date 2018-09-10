package SistemaPeliculas;
import java.time.LocalDate;
import java.util.*;

public class SistGestionVentaEntradas {

    private Vector<Venta> Ventas;
    private Vector<Establecimiento> Establecimientos;
    private Vector<Usuario> Usuarios;
    private Vector<Pelicula> Peliculas;
    private Vector<Funcion> Funciones;

    public SistGestionVentaEntradas() {
    	Ventas=new Vector<Venta>();
    	Establecimientos=new Vector<Establecimiento>();
    	Usuarios=new Vector<Usuario>();
    	Peliculas=new Vector<Pelicula>();
    	Funciones=new Vector<Funcion>();
    }

    public void crearEstablecimiento(int id, String nombre,int cuit,String domicilio,int cantSalas,int capacidadTotal) 	{
		Establecimiento e = buscarEstablecimiento(id);
		if (e==null)
		{
			e = new Establecimiento(id,nombre,cuit,domicilio,cantSalas,capacidadTotal);
			Establecimientos.add(e);
		}
	}

     private Establecimiento buscarEstablecimiento(int id) {
 		for (int i=0; i<Establecimientos.size();i++)
		{
			if (Establecimientos.elementAt(i).sosElEstablecimiento(id))
				return Establecimientos.elementAt(i);

		}
		return null;
 	}

    public void modificarEstablecimiento(int id,String nombre,int cuit,String domicilio) {
		Establecimiento e = buscarEstablecimiento(id);
		if (e!=null) //Solo se modifica si el establecimiento existe
		{
			e.setNombreE(nombre);
			e.setCuit(cuit);
			e.setDomicilio(domicilio);
		}
    }

    public void eliminarEstablecimiento(int id) {
        Establecimientos.remove(id);
    }

    public void crearPelicula(int id,String nombre,String director,String genero,String duracion,String idioma,String subtitulos,float calificacion,String observaciones) 	{
		Pelicula p = buscarPelicula(id);
		if (p==null)
		{
			p = new Pelicula(id,nombre,director,genero,duracion,idioma,subtitulos,calificacion,observaciones);
			Peliculas.add(p);
		}
	}


    private Pelicula buscarPelicula(int id)
    {
		for (int i=0; i<Peliculas.size();i++)
	{
		if (Peliculas.elementAt(i).sosLaPelicula(id))
			return Peliculas.elementAt(i);

	}
	return null;
	}


    public void modificarPelicula(int id,String nombre,String director,String genero,String duracion,String idioma,String subtitulos,float calificacion,String observaciones) {
		Pelicula p = buscarPelicula(id);
		if (p!=null) //Solo se modifica si la pelicula existe
		{
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
     	Peliculas.remove(id);
    }

    public void crearFuncion(int id,LocalDate fecha,Sala laSala,Pelicula laPelicula) {
    	Funcion f = buscarFuncion(id);
		if (f==null)
		{
			f = new Funcion(id,fecha,laSala,laPelicula);
			Funciones.add(f);
		}
	}

    private Funcion buscarFuncion(int id) 	{
 		for (int i=0; i<Funciones.size();i++)
		{
			if (Funciones.elementAt(i).sosLaFuncion(id))
				return Funciones.elementAt(i);

		}
		return null;
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
       Funciones.remove(id);
    }

    public void crearUsuario(int id, int dni, String email, String password, String nombre, String domicilio, LocalDate fechaNac,
			String tipoDeUsuario)
    {
    	Usuario u = buscarUsuario(id);
		if (u==null)
		{
			u = new Usuario(id,dni,email,password,nombre,domicilio,fechaNac,tipoDeUsuario);
			Usuarios.add(u);
		}
	}


    private Usuario buscarUsuario(int id) 	{
 		for (int i=0; i<Usuarios.size();i++)
		{
			if (Usuarios.elementAt(i).sosElUsuario(id))
				return Usuarios.elementAt(i);

		}
		return null;
 	}

   public void modificarUsuario(int id,String email,String password,String nombre,String domicilio,int dni,LocalDate fechaNac,String tipoDeUsuario) {
		Usuario u = buscarUsuario(id);
		if (u!=null) //Solo se modifica si el usuario existe
		{
			u.setEmail(email);
			u.setPassword(password);
			u.setNombre(nombre);
			u.setDomicilio(domicilio);
			u.setDni(dni);
			u.setFechaNac(fechaNac);
			u.setTipoDeUsuario(tipoDeUsuario);
		}
    }

    public void eliminarUsuario(int id) {
       Usuarios.remove(id);
    }

	public int iniciarVentaContado()
	{
		VentaContado vta = new VentaContado();
		Ventas.add(vta);
		return vta.getNumero();
	}

	public int iniciarVentaCredito(String tipoDeTarjeta, int numeroTarjeta, String fechaVtoTarjeta, int codSeguridadTarjeta)
	{
		VentaCredito vta = new VentaCredito(tipoDeTarjeta,numeroTarjeta,fechaVtoTarjeta,codSeguridadTarjeta);
		Ventas.add(vta);
		return vta.getNumero();
	}

	   private Venta buscarVenta(int nro) 	{
	 		for (int i=0; i<Ventas.size();i++)
			{
				if (Ventas.elementAt(i).sosLaVenta(nro))
					return Ventas.elementAt(i);

			}
			return null;
	 	}


    public float cierreVenta(int nro) {
		Venta vta = buscarVenta(nro);
		return vta.calcularTotal();
    }

    public void imprimirVenta(int nro) {
       Venta vta = buscarVenta(nro);
       if(vta!=null) {
    	   System.out.println("N�: " + vta.getNumero());
    	   System.out.println("Fecha: " + vta.getFecha());
       }
    }

    public void cambiarPrecioEntrada(float nuevoPrecio) {
        Entrada.setPrecio(nuevoPrecio);
    }

	public void cambiarComisionVenta(float num){
		VentaCredito.setComision(num/100);
	}

}
