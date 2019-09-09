//Junté el dao con metodos que no corresponden al dao, consideré que siendo funciones que se utilizan sobre el dao era mejor opción que crear otra clase. 
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import modelo.Jugador;
import modelo.Posicion;

public class implementacionJugadores {
 
	ConexionMySQL conn;
	
	public implementacionJugadores() {		
		this.conn = new ConexionMySQL();		
	}

	public Integer ContadorDePuestos(HashSet<Jugador> jugadores, Posicion pos)
	{
		Integer con=0;
		for(Jugador j:jugadores)
		{			
			if(j.getPosicion()==pos)				
				con=con+1;			
		}
		return con;
	}	
	
	public HashSet<Jugador> listarJugadores() {
		HashSet<Jugador> listaJugadores=new HashSet<Jugador>(20);
		java.sql.Connection con= conn.getConexion();		
		PreparedStatement ps;
		ResultSet res;		
		
		try
		{
			ps=con.prepareStatement("Select * from jugadores");
			res= ps.executeQuery();
			
			while(res.next())
			{					
				String posS=res.getString("posicion");
				Posicion pos=null;				
				switch(posS)
				{
				case "Ala":
					pos= Posicion.Ala;
					break;
				case "AlaPivot":
					pos= Posicion.AlaPivot;
					break;
				case "Pivot":
					pos=Posicion.Pivot;
					break;
				case "Base":
					pos=Posicion.Base;
					break;
				case "AyudaBase":
					pos=Posicion.AyudaBase;		
					break;
				}	
										
				Jugador u=new Jugador(res.getString("nombre"), res.getString("apellido"), pos, res.getInt("edad"), res.getFloat("altura"), res.getFloat("peso"), res.getInt("Puntaje"));				
				listaJugadores.add(u);				
			}			
			
		}catch(Exception e)
		{
			System.out.println("no se pudo listar");
		}		
		return listaJugadores;
	}		
			

	public void InsertarJugador(String nombre, String apellido, Posicion posicion, Integer edad, float altura, float peso)
	{
		String queryInsertar="INSERT INTO `neoris`.`jugadores` (`nombre`,`apellido`,`posicion`,`edad`,`altura`,`peso`) VALUES ('"+nombre+"', '"+apellido +"','"+posicion +"',"+edad+","+altura+","+peso+")";
				
		try
		{
			java.sql.Statement st=this.conn.getConexion().createStatement();			
			st.execute(queryInsertar);			
			System.out.println("insertó correctamente");
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}			 
	}
	
	public void InsertarPuntaje(Integer puntaje, String nombre, String apellido)
	{		
		try {
			java.sql.Connection con=conn.getConexion();
			PreparedStatement ps=con.prepareStatement("UPDATE `neoris`.`jugadores` SET puntaje=? WHERE nombre=? && apellido=?");
			ps.setInt(1, puntaje);
			ps.setString(2, nombre);
			ps.setString(3, apellido);			
			ps.executeUpdate();
			ps.close();			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}		
		 
	}
	}
	
	




