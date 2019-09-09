package modelo;

public class Usuario {
	
	private String password;
	private String nombreUsuario;
	
	public Usuario(String nombreUsuario, String password ) {
		super();
		this.password = password;
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
	
	

}
