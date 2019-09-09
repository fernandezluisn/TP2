package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.implementacionJugadores;
import modelo.Jugador;

/**
 * Servlet implementation class DirectorTecnico
 */
@WebServlet("/DirectorTecnico")
public class DirectorTecnico extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -257470035675246887L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DirectorTecnico() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Ya te voy a programar ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		implementacionJugadores iJ=new implementacionJugadores();	
		HashSet<Jugador> j=iJ.listarJugadores();
		
		String puntajeS=request.getParameter("textoPunJug");
		String nombre=request.getParameter("textoNomJug");
		String apellido=request.getParameter("textoApeJug");
		
		Integer puntaje=Integer.parseInt(puntajeS);
		
		if(puntaje<101 && puntaje>=0)
		iJ.InsertarPuntaje(puntaje, nombre, apellido);		
		
		
		
		PrintWriter pW=response.getWriter();
		
		pW.append("<html><head><title>Confederación argentina de Básquetbol</title></head>");
		pW.append("<body>");
		pW.append("Jugadores Seleccionados:"+"<br><br>");
		pW.append("<div><br><br><table><tr><td><strong>Nombre</strong></td> <td><strong>Apellido</strong></td>  <td><strong>Calificación</strong></td> <td><strong>Posicion</strong></td></tr>");
		for(Jugador j1:j)	
		{
			pW.append("<tr><td>"+j1.getNombre()+"</td><td>"+j1.getApellido()+"</td><td>"+ j1.getPuntaje()+"</td><td>"+j1.getPosicion()+"</td></tr>");
		}
		pW.append("</table></div>");		
	
		
		if(j.size()==20)
			{
			ArrayList<Jugador> alas=new ArrayList<Jugador>();
			ArrayList<Jugador> bases=new ArrayList<Jugador>();
			ArrayList<Jugador> alapivot=new ArrayList<Jugador>();
			ArrayList<Jugador> ayudabase=new ArrayList<Jugador>();
			ArrayList<Jugador> pivot=new ArrayList<Jugador>();
			
			for(Jugador jugador:j)
			{		
				switch(jugador.getPosicion())
				{
				case Ala:
					alas.add(jugador);
					break;
				case Base:
					bases.add(jugador);
					break;
				case AyudaBase:
					ayudabase.add(jugador);
					break;
				case AlaPivot:
					alapivot.add(jugador);
					break;
				case Pivot:
					pivot.add(jugador);
					break;
				}
			}
				
			Collections.sort(alas);
			Collections.sort(bases);
			Collections.sort(ayudabase);
			Collections.sort(alapivot);
			Collections.sort(pivot);			
			
			this.FiltrarTres(alas,pW, "ala");
			this.FiltrarTres(bases,pW, "base");
			this.FiltrarTres(alapivot,pW, "ayuda base");
			this.FiltrarTres(pivot,pW, "ala pivot");
			this.FiltrarTres(ayudabase,pW, "pivot");
			}
		else
		{
			pW.append("<h3>La lista se encuentra incompleta ya que faltan jugadores o incluir puntajes para poder dar la lista definitiva de convocados.</h3>");
			pW.append("<p>Observe la lista que aparece arriba y pidale al secretario que incluya los jugadores faltantes o rellene los puntajes nulos</p>");
		}
		pW.append("<a href='homeDirector.jsp'>Regresar a la página de Director Técnico</a>");
		pW.append("</body></html>");}catch(Exception e)
		{
			response.sendRedirect("Error.jsp");
		}
	}

	
	public void FiltrarTres(ArrayList<Jugador> lista, PrintWriter p, String nombre)
	{		
		p.append("<h2>Jugadores convocados de "+ nombre+"</h2>");
		for(Integer i=3; i>1;i--)
		{
			Jugador j=lista.get(i);
			p.append("<p>nombre: "+j.getNombre()+ " apellido: "+ j.getApellido()+" puntaje: "+ j.getPuntaje()+"</p>");
		}
		
		if(lista.get(0).getPuntaje()==lista.get(1).getPuntaje())
		{
			p.append("<p>"+lista.get(0).getNombre()+" "+lista.get(0).getApellido()+" y "+ lista.get(1).getNombre()+" " +lista.get(1).getApellido()+" tienen el mismo puntaje, cambie el puntaje de uno de los dos para que quede en la lista de seleccionados."+"</p><br><br>");
			//insertar boton para seleccionar
		}
		else
		{
			Jugador j=lista.get(1);
			p.append("<p>nombre: "+j.getNombre()+ " apellido: "+ j.getApellido()+" puntaje: "+ j.getPuntaje()+"</p><br><br>");
		}
	}
}


