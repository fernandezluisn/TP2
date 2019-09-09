package interfaces;

import java.util.Set;

import modelo.Usuario;

public interface usuarios {
	
	public Set<Usuario> listarUsuarios();	
	

	void modificarPassword(String mail, String password);

}
