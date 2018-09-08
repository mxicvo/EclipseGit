package SistemaPeliculas;

import java.time.LocalDate;

public class Usuario{

    private int id;
    private int dni;
    private String email;
    private String password;
    private String nombre;
    private String domicilio;
    private LocalDate fechaNac;
    private String tipoDeUsuario;
    
	public Usuario(int id, int dni, String email, String password, String nombre, String domicilio, LocalDate fechaNac,
			String tipoDeUsuario) {
		super();
		this.id = id;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.fechaNac = fechaNac;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	
	public boolean sosElUsuario(int id) 
	{
		return this.id == id;
	}
	
}