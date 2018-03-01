package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

/**
 * Servlet implementation class CompraServlet
 */
@WebServlet("/CompraServlet")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraServlet() {
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
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		out.println("<h1>Supermercado Jose Maria Fernandez Parra</h1>");
		String imagenmercado="supermercado2.jpg";
		out.println("<p><img src=img/"+imagenmercado+" width=300px heigh=300px></p>");
		
		Connection conn = null;
		Statement sentencia = null;
		
		try {
		 
		 Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  String userName = contexto.getInitParameter("usr_db_rw");
		  String password = contexto.getInitParameter("psw_db_rw");
		  String ur=contexto.getInitParameter("srv_db");
		  String url = ur+"/supermercado";
		  conn = DriverManager.getConnection(url, userName, password);

		  sentencia = conn.createStatement();
		  
		  HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" 
				+ usuario.getNombre() + "</a></h4>");
			
			
			
			
			 if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
				  
				  
				  
				  
				} catch (Exception e) {
					  e.printStackTrace();
					}
				out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
