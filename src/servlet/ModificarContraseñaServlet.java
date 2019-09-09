package servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.implementacionUsuarios;
import interfacesImp.chequeoImp;
import modelo.Usuario;

/**
 * Servlet implementation class ModificarContraseñaServlet
 */
@WebServlet("/ModificarContraseñaServlet")
public class ModificarContraseñaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarContraseñaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario=request.getParameter("txt1");
		String contraseña=request.getParameter("pass1");
		HashSet<Usuario> listaDeUsuarios=new HashSet<Usuario>();
		implementacionUsuarios iU=new implementacionUsuarios();
		
		listaDeUsuarios=iU.listarUsuarios();
		
		chequeoImp cP=new chequeoImp();
		
		if(cP.chequeo(usuario, contraseña, listaDeUsuarios))
		{
			String pass2=request.getParameter("pass2");
			String pass3=request.getParameter("pass3");
			if(pass3.equals(pass2))
			{
				
				iU.modificarPassword(usuario, pass3);
				
				response.sendRedirect("index.html");
				
			}
			else
			{
				
				response.sendRedirect("Error.jsp");
			}
		}
		else
		{
			response.sendRedirect("Error.jsp");
			
			
		}
	}

}
