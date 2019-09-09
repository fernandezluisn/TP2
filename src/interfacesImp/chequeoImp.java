package interfacesImp;

import modelo.*;

import java.util.HashSet;

import interfaces.chequeoPassword;
import modelo.Usuario;

public class chequeoImp implements chequeoPassword {

	@Override
	public Boolean chequeo(String nombre, String pass, HashSet<Usuario> usuarios) {
		Boolean es=false;
		for(Usuario u:usuarios)
		{
			if (u.getNombreUsuario().equals(nombre) && u.getPassword().equals(pass))
			{				
					es=true;						
			}				
		}		
		return es;
	}

	

}
