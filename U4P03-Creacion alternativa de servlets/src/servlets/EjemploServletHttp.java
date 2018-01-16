package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
//@WebServlet(urlPatterns={"/EjemploServletHttp","/SampleHttpServlet"}, loadOnStartup=1)
public class EjemploServletHttp extends HttpServlet { //Linea B
	private static final long serialVersionUID = 1L; //Linea C
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploServletHttp() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
	    log("Iniciando el servlet HTTP");
	  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //Linea D
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Servlet HTTP</title></head>");
		out.println("<body><h1>Servlet HTTP</h1>");
		out.println("<h3>Me llamo Jose Maria</h3>");
		out.println("<p>Ejecución de " + request.getContextPath() + "</p>");
		out.println("<a href=./index.html" +">Volver</a>");
		out.println("</body></html>");
		out.close();
		//Linea E
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //Linea F
		// TODO Auto-generated method stub
		doGet(request, response); //Linea G
	}
	
	

}
