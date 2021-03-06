package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoServlet
 */
//@WebServlet("/Saludo")
@WebServlet(name="SaludoServlet")
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
		//response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext contexto = getServletContext();
		System.out.println(contexto.getAttribute("contador"));
		
		//out.println("<html><head><meta charset='UTF-8'/></head><body>");
		out.println("<h1>Servlet sencillo que saluda al visitante</h1>");
		out.println("<p>¡Hoy es un gran día!</p>");
		out.println("<p><a href='./index.html'>Volver al inicio</a></p>");
		//out.println("</body></html>");
		//out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
