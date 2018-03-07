package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.Select;

import modelo.Producto;
import modelo.Usuario;

/**
 * Servlet implementation class AnadirCestaServlet
 */
@WebServlet("/AnadirCesta")
public class AnadirCestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirCestaServlet() {
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

		  
		 String userName = contexto.getInitParameter("usr_db_r");
		  String password = contexto.getInitParameter("psw_db_r");
		  String ur=contexto.getInitParameter("srv_db");
		  String url = ur+"/supermercado";
		  conn = DriverManager.getConnection(url, userName, password);

		  sentencia = conn.createStatement();
		  
		  HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			out.println("<h4>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" 
				+ usuario.getNombre() + "</a></h4>");
			
			if(request.getParameter("idproducto")!=null) {
				String idproducto=request.getParameter("idproducto");
				System.out.println(idproducto);
				idproducto=(String)idproducto.subSequence(1, idproducto.length()-1);
				System.out.println(idproducto);
				int idprod=Integer.parseInt(idproducto);
				String consulta5="SELECT * FROM producto WHERE producto.idproducto="+idprod;
				ResultSet rset5 = sentencia.executeQuery(consulta5);
				  
				if (!rset5.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
				}
				  while(rset5.next()) {
						 Producto prod=new Producto(rset5.getInt("idproducto"), rset5.getString("nombre"), rset5.getString("marca"), rset5.getDouble("precio"), rset5.getInt("stock"), rset5.getString("descripcion"), rset5.getString("imagen"), rset5.getString("familia"),rset5.getInt("ubicacion"));
						 ArrayList<Producto> listprod= (ArrayList<Producto>) session.getAttribute("carrito");
						 listprod.add(prod);
						 session.setAttribute("carrito", listprod);
						 System.out.println("Añadido"+idproducto);
					
				  }
	
			}else {
				out.println("<p>Error</p>");
				
				
			}
			
			
			
		  
		  
		  
		  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
		response.sendRedirect(contexto.getContextPath() + "/MostrarProductos"); 
		
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
