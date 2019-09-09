package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.implementacionJugadores;

import modelo.Jugador;
import modelo.Posicion;


/**
 * Servlet implementation class Secretaria
 */
@WebServlet("/Secretaria")
public class Secretaria extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -3989061226227061730L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Secretaria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		System.out.println(request.getParameter("posicion"));
		String nombre=request.getParameter("textoNomJug");
		String apellido=request.getParameter("textoApeJug");
		String ed=request.getParameter("edad");
		String pos=request.getParameter("posicion");
		String alt=request.getParameter("txtAltura");
		String p=request.getParameter("txtPeso");
		
		
		
		
		//esto solo funciona con punto, con coma no anda
		Float altura= Float.parseFloat(alt );
		Float peso= Float.parseFloat( p);
		Integer edad=Integer.parseInt(ed);
		Integer iPos=Integer.parseInt(pos);
		
		Posicion posicionT=null;
		
		switch(iPos){
		case 1:
			posicionT=Posicion.Base;
			break;
		case 4:
			posicionT=Posicion.AlaPivot;
			break;
		case 5:
			posicionT=Posicion.Pivot;
			break;
		case 2:
			posicionT=Posicion.AyudaBase;
			break;
		case 3:
			posicionT=Posicion.Ala;
			break;
		}
		
		
		
		HashSet<Jugador> listaDeJugadores=new HashSet<Jugador>(20);
		implementacionJugadores iJ=new implementacionJugadores();
		PrintWriter pW=response.getWriter();
		
		listaDeJugadores=iJ.listarJugadores();
		
		if (listaDeJugadores.size()<20 && iJ.ContadorDePuestos(listaDeJugadores, posicionT)<4)//contador de puestos no anda
		{
			iJ.InsertarJugador(nombre, apellido, posicionT, edad, altura, peso);
			
			
			
			pW.append("<html><head><title>Confederación argentina de Básquetbol</title></head>");
			pW.append("<body>");
			pW.append("Jugadores Seleccionados:"+"<br><br>");
			pW.append("<div><br><br><table><tr><td><strong>Nombre</strong></td> <td><strong>Apellido</strong></td>  <td><strong>Calificación</strong></td> <td><strong>Posicion</strong></td></tr>");
			for(Jugador j1:listaDeJugadores)	
			{
				pW.append("<tr><td>"+j1.getNombre()+"</td><td>"+j1.getApellido()+"</td><td>"+ j1.getPuntaje()+"</td><td>"+j1.getPosicion()+"</td></tr>");
			}
			pW.append("</table></div>");		
			pW.append("</body></html>");
			
		}
		else
		{
			pW.append("<html><head><title>Confederación argentina de Básquetbol</title></head>");
			pW.append("<body>");
			pW.append("<h1>error, ya hay jugadores suficientes en esa posición.<h1>");
			pW.append("Jugadores Seleccionados:"+"<br><br>");
			pW.append("<div><br><br><table><tr><td><strong>Nombre</strong></td> <td><strong>Apellido</strong></td>  <td><strong>Calificación</strong></td> <td><strong>Posicion</strong></td></tr>");
			for(Jugador j1:listaDeJugadores)	
			{
				pW.append("<tr><td>"+j1.getNombre()+"</td><td>"+j1.getApellido()+"</td><td>"+ j1.getPuntaje()+"</td><td>"+j1.getPosicion()+"</td></tr>");
			}
			pW.append("</table></div>");	
			pW.append("<a href='homeSecretaria.html'>Regresar a la página de Secretaria</a>");
			pW.append("</body></html>");
			
			//no hice botón de delete porque no está en las consignas
		}
		}catch(Exception e)
		{
			response.sendRedirect("Error.jsp");
		}
		
	}
		

}
