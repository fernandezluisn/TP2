package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.implementacionUsuarios;
import interfaces.chequeoPassword;
import interfacesImp.chequeoImp;
import modelo.Usuario;


@WebServlet("/Seleccion")
public class Seleccion extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6809977147081139423L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("cambioDeContraseña.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("textoUsuario");
		String contraseña=request.getParameter("pass");
		HashSet<Usuario> listaDeUsuarios=new HashSet<Usuario>();
		implementacionUsuarios iU=new implementacionUsuarios();
		
		listaDeUsuarios=iU.listarUsuarios();
		
		
		chequeoImp cP=new chequeoImp();		
		
		/*Usuario tecnico=new Usuario("dt@seleccion.com", "1234");		
		Usuario secretaria=new Usuario("secretaria@seleccion.com", "1234");
		
		listaDeUsuarios.add(secretaria);
		listaDeUsuarios.add(tecnico);*/
		
		
			if(cP.chequeo(usuario, contraseña, listaDeUsuarios))
			{
				switch(usuario)
				{
				case "secretaria@seleccion.com":
					response.sendRedirect("homeSecretaria.html");
					break;
				case "dt@seleccion.com":
					response.sendRedirect("homeDirector.jsp");
					break;
				}
				
			}
			else
			{
				response.sendRedirect("Error.jsp");		
				/*PrintWriter pW=response.getWriter();
				pW.append("<html><body>");
				pW.append("<p>"+tecnico.getNombreUsuario()+"</p>");
				pW.append("</body></html>");*/
			}
			
		
	
	}

}
