package servlets;

import modelo.Obra;

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



/**
 * Servlet implementation class MostrarObraServlet
 */
@WebServlet("/MostrarObra")
public class MostrarObraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarObraServlet() {
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
		
		Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		 Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost:3306/catalogo11";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear la sentencia SQL
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String where="";
			if(request.getParameter("id_obra")!=null) {
				where="&& id_obra="+request.getParameter("id_obra");
			}
			
		  String consulta = "SELECT * from obra,autor WHERE obra.id_autor=autor.id "+where;
		  ResultSet rset = sentencia.executeQuery(consulta);

		   // Paso 5: Mostrar resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		 
		 
		  
		  out.println("<table style='border:'5px''>");
		  out.println("<tr style='background-color:lightblue'><td>Titulo</td><td>Autor</td><td>Genero</td><td>Imagen</td></tr>");
		  while (rset.next()) {
			 Obra obra=new Obra(rset.getString("id_obra"), rset.getString("titulo"), rset.getString("id_autor"), rset.getString("genero"), rset.getString("descripcion"), rset.getString("año"), rset.getString("imagen"), rset.getString("nombre"));
			
			out.println("<tr style='background-color:orange'>");
		    out.println("<td>" + obra.getTitulo() + "</td><td> " + obra.getNombre() + "</td><td>"+obra.getGenero()+"</td><td><img src='./img/"+obra.getImagen()+"' width=100 heigh=100></td></tr>");
		  }
		  out.println("</table>");

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	
		out.print("<a href=MostrarCatalogo>Eliminar filtros<br>");

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
