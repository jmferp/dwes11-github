package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/SaludoServlet")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		
		String bienvenida="";
		String errorUsuario = "";
		String usuario = "";
		// procesamiento del formulario
		
		if (request.getParameter("reiniciarSesion")!=null) {
			session.invalidate();
			session = request.getSession();
			session.setAttribute("usuario", usuario);
		}
		
		if (request.getMethod().equals("POST")) { // si se ha enviado el formulario...
			// validar nombre
			usuario = request.getParameter("usuario");
			if (session.isNew()) {
				  session.setAttribute("usuario", usuario);
				  
			}else {
			bienvenida="Damos la bienvenida a "+usuario;
			}
			if (usuario == "") {
				errorUsuario = "Debes introducir un nombre";
				out.println("<p>"+errorUsuario+"</p>");
			} else {
				out.println("<h2>"+bienvenida+"</h2>");
			}
			
			out.println("<p><a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a></p>");
		}else {
			
			out.println("<form action='"+request.getRequestURI()+"' method='post'>"
					+ "<label>Introducir nombre</label>" + "<input type='text' name='usuario'/>"
					+ "<span class='error'>" + errorUsuario + "</span><br/>"
					+ "<input type='submit' name='enviar' value='Enviar'/></form>");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
