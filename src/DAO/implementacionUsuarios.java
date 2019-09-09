package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.Connection;

import interfaces.usuarios;
import modelo.Usuario;

public class implementacionUsuarios implements usuarios {
	
	ConexionMySQL conn;
	
	
	public implementacionUsuarios() {
		super();
		this.conn = new ConexionMySQL();		
	}

	@Override
	public HashSet<Usuario> listarUsuarios() {
		HashSet<Usuario> listaUsuarios=new HashSet<Usuario>(2);
		java.sql.Connection con= conn.getConexion();
		
		PreparedStatement ps;
		ResultSet res;
		
		
		try
		{
			ps=con.prepareStatement("Select * from usuarios");
			res= ps.executeQuery();
			
			while(res.next())
			{
				String mail=res.getString("usuario");
				String pass=res.getString("password");
				Usuario u=new Usuario(mail, pass);
				listaUsuarios.add(u);
				
			}
			
			
		}catch(Exception e)
		{
			System.out.println("no se pudo listar");
		}
		
		return listaUsuarios;
	}

	@Override
	public void modificarPassword(String mail, String password) {
		
				
		
		
		//no sé por qué no anda
		try {
			
			System.out.println("p:"+password);
			System.out.println("m:"+mail);
			
			java.sql.Connection con=conn.getConexion();
			String query="UPDATE usuarios SET password=? WHERE usuario=?";
			
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, mail);
			ps.executeUpdate();
			System.out.println("q:"+query);	
			
			
			
			ps.executeUpdate();
			
			System.out.println("se modificó exitosamente");
			
			ps.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

}


