package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.Ubicacion;
import modelo.Usuario;


/**
 * Servlet implementation class MostrarDetalles
 */
@WebServlet("/MostrarDetalles")
public class MostrarDetallesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDetallesServlet() {
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
		  
		  
		  String where="";
			if(request.getParameter("idproducto")!=null) {
				where="&& idproducto="+request.getParameter("idproducto");
			}
			
		  String consulta = "SELECT * from producto,ubicacion WHERE producto.ubicacion=ubicacion.idubicacion "+where;
		  ResultSet rset1 = sentencia.executeQuery(consulta);
		  if (!rset1.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		  
		  out.println("<table style='border:'5px''>");
		  out.println("<tr style='background-color:lightblue'><td>Nombre</td><td>Marca</td><td>Precio</td><td>Descripcion</td><td>Imagen</td><td>Familia</td><td>Pasillo</td><td>Modulo</td><td>Altura</td><td>Hueco</td></tr>");
		  while (rset1.next()) {
			  Producto prod=new Producto(rset1.getInt("idproducto"), rset1.getString("nombre"), rset1.getString("marca"), rset1.getDouble("precio"), rset1.getInt("stock"), rset1.getString("descripcion"), rset1.getString("imagen"), rset1.getString("familia"),rset1.getInt("ubicacion"));
				Ubicacion ub=new Ubicacion(rset1.getInt("idubicacion"), rset1.getInt("pasillo"),rset1.getInt("modulo"),rset1.getInt("altura"),rset1.getInt("hueco"));
			out.println("<tr style='background-color:orange'>");
		    out.println("<td>" + prod.getNombre()  + "</td><td> " + prod.getMarca() + "</td><td>"+prod.getPrecio()+"</td><td>"+prod.getDescripcion()+"</td><td><img src='./img/"+prod.getImagen()+"' width=100 heigh=100></td><td>"+prod.getFamilia()+"</td><td>"+ub.getPasillo()+"</td><td>"+ub.getModulo()+"</td><td>"+ub.getAltura()+"</td><td>"+ub.getHueco()+"</td></tr>");
		  }
		  out.println("</table>");
		  
		  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
		out.println("<a href=MostrarProductos>Volver</a>");
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
