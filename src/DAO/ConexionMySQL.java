package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionMySQL {

	public static String URL="jdbc:mysql://localhost:3306/neoris";//conexion a mi base de datos
	public static String Username="root";
	public static String Password="elbordo17_";//acá va el password
	
	private Connection conexion;
	
	public ConexionMySQL()
	{		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion=(Connection)DriverManager.getConnection(URL, Username, Password);
			System.out.println("Conexión exitosa");
		}catch(Exception e) {
			System.out.println("conexion no anda");
		}		
	}
	
	public Connection getConexion() {
		return this.conexion;
	}
	

}
