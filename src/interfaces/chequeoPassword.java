package interfaces;

import java.util.HashSet;

import modelo.Usuario;
public interface chequeoPassword {
	

	public Boolean chequeo(String mail, String password, HashSet<Usuario> usuarios);
	

}
