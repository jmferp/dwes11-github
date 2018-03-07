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
import modelo.Usuario;


/**
 * Servlet implementation class MostrarProductosServlet
 */
//@WebServlet("/MostrarProductos")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
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
	
		  
		  String order="";
		  if(request.getParameter("op")!=null) {
		  if(request.getParameter("op").equalsIgnoreCase("1")) {
			  order="ORDER BY nombre;";
		  	}else if(request.getParameter("op").equalsIgnoreCase("2")){
			  order="ORDER BY nombre DESC;";
		  	}else if(request.getParameter("op").equalsIgnoreCase("3")){
				  order="ORDER BY marca;";
		  	}else if(request.getParameter("op").equalsIgnoreCase("4")){
				  order="ORDER BY marca DESC;";
		  	}
		  }
		  
		  if(request.getParameter("familia")!=null) {
			  String familia=request.getParameter("familia");
			  if(request.getParameter("busq")!=null) {
				  String busq=request.getParameter("busq");
				  String consulta2 = "SELECT * from producto WHERE producto.familia="+familia+" AND (producto.nombre LIKE '%"+busq+"%' || producto.marca LIKE '%"+busq+"%')";
				  ResultSet rset2 = sentencia.executeQuery(consulta2);
				  
				  if (!rset2.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
				  out.println("<table style='border:'5px''>");
				  out.println("<tr style='background-color:lightblue'><td>Nombre<a href=MostrarProductos?op=1>&#9650;</a><a href=MostrarProductos?op=2>&#9660;</a></td>"
				  		+ "<td>Marca<a href=MostrarProductos?op=3>&#9650;</a><a href=MostrarProductos?op=4>&#9660;</a></td><td>Imagen</td><td>Comprar</td>");
				  while (rset2.next()) {
					 Producto prod=new Producto(rset2.getInt("idproducto"), rset2.getString("nombre"), rset2.getString("marca"), rset2.getDouble("precio"), rset2.getInt("stock"), rset2.getString("descripcion"), rset2.getString("imagen"), rset2.getString("familia"),rset2.getInt("ubicacion"));
				
					out.println("<tr style='background-color:orange'>");
				    out.println("<td><a href=MostrarDetalles?idproducto='"+prod.getIdproducto()+"'>"+prod.getNombre()+"</td><td>"+prod.getMarca() + "</td><td><img src='./img/"+prod.getImagen()+"' width=100 heigh=100></td>");
				    if(prod.getStock()>0) {
				    	out.println("<td><a href=AnadirCesta?idproducto='"+prod.getIdproducto()+"'><img src=./img/carrito1.png width=40px></td>");
				    }else{
				    	out.println("<td></td>");
				    }
				    out.println("</tr>");
				    }
			  
				  
				  out.println("</table>");  
				  
			  }else {
				  
				  System.out.println(familia);
				  String consulta1 = "SELECT * from producto WHERE producto.familia="+familia+" "+order;
				  ResultSet rset1 = sentencia.executeQuery(consulta1);
				  
				  if (!rset1.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
				  
				  out.println("<h2>"+familia+"</h2>");
				  out.println("<table style='border:'5px''>");
				  out.println("<tr style='background-color:lightblue'><td>Nombre<a href=MostrarProductos?op=1>&#9650;</a><a href=MostrarProductos?op=2>&#9660;</a></td>"
				  		+ "<td>Marca<a href=MostrarProductos?op=3>&#9650;</a><a href=MostrarProductos?op=4>&#9660;</a></td><td>Imagen</td><td>Comprar</td>");
				  while (rset1.next()) {
					 Producto prod=new Producto(rset1.getInt("idproducto"), rset1.getString("nombre"), rset1.getString("marca"), rset1.getDouble("precio"), rset1.getInt("stock"), rset1.getString("descripcion"), rset1.getString("imagen"), rset1.getString("familia"),rset1.getInt("ubicacion"));
					
					out.println("<tr style='background-color:orange'>");
				    out.println("<td><a href=MostrarDetalles?idproducto='"+prod.getIdproducto()+"'>"+prod.getNombre()+"</td><td>"+prod.getMarca() + "</td><td><img src='./img/"+prod.getImagen()+"' width=100 heigh=100></td>");
				    if(prod.getStock()>0) {
				    	out.println("<td><a href=AnadirCesta?idproducto='"+prod.getIdproducto()+"'><img src=./img/carrito1.png width=40px></td>");
				    }else{
				    	out.println("<td></td>");
				    }
				    out.println("</tr>");
				    }
				  
				  
				  out.println("</table>");
				  
			  }
		 
		  }else {
	
			  if(request.getParameter("busq")!=null) {
				  String busq=request.getParameter("busq");
				  String consulta2 = "SELECT * from producto WHERE producto.familia='Bio' AND (producto.nombre LIKE '%"+busq+"%' || producto.marca LIKE '%"+busq+"%')";
				  ResultSet rset2 = sentencia.executeQuery(consulta2);
				  
				  if (!rset2.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
				  out.println("<table style='border:'5px''>");
				  out.println("<tr style='background-color:lightblue'><td>Nombre<a href=MostrarProductos?op=1>&#9650;</a><a href=MostrarProductos?op=2>&#9660;</a></td>"
				  		+ "<td>Marca<a href=MostrarProductos?op=3>&#9650;</a><a href=MostrarProductos?op=4>&#9660;</a></td><td>Imagen</td><td>Comprar</td>");
				  while (rset2.next()) {
					 Producto prod=new Producto(rset2.getInt("idproducto"), rset2.getString("nombre"), rset2.getString("marca"), rset2.getDouble("precio"), rset2.getInt("stock"), rset2.getString("descripcion"), rset2.getString("imagen"), rset2.getString("familia"),rset2.getInt("ubicacion"));
					
					out.println("<tr style='background-color:orange'>");
				    out.println("<td><a href=MostrarDetalles?idproducto='"+prod.getIdproducto()+"'>"+prod.getNombre()+"</td><td>"+prod.getMarca() + "</td><td><img src='./img/"+prod.getImagen()+"' width=100 heigh=100></td>");
				    if(prod.getStock()>0) {
				    	out.println("<td><a href=AnadirCesta?idproducto='"+prod.getIdproducto()+"'><img src=./img/carrito1.png width=40px></td>");
				    }else{
				    	out.println("<td></td>");
				    }
				    out.println("</tr>");
				    
				  
				  }
				  out.println("</table>");  
			  }else {
				  String consulta = "SELECT DISTINCT familia from producto";
				  ResultSet rset = sentencia.executeQuery(consulta);
				  if (!rset.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
				  while (rset.next()) {
					  out.println("<a href=\"MostrarProductos?familia='"+rset.getString("familia")+"'\">"+rset.getString("familia")+"</a>");
				  }
				  
				  String consulta1 = "SELECT * from producto WHERE producto.familia='Bio' "+order;
				  ResultSet rset1 = sentencia.executeQuery(consulta1);
				  
				  if (!rset1.isBeforeFirst() ) {    
					    out.println("<h3>No hay resultados</p>");
					}
				  
				  out.println("<h2>Bio</h2>");
				  out.println("<table style='border:'5px''>");
				  out.println("<tr style='background-color:lightblue'><td>Nombre<a href=MostrarProductos?op=1>&#9650;</a><a href=MostrarProductos?op=2>&#9660;</a></td>"
				  		+ "<td>Marca<a href=MostrarProductos?op=3>&#9650;</a><a href=MostrarProductos?op=4>&#9660;</a></td><td>Imagen</td><td>Comprar</td>");
				  while (rset1.next()) {
					 Producto prod=new Producto(rset1.getInt("idproducto"), rset1.getString("nombre"), rset1.getString("marca"), rset1.getDouble("precio"), rset1.getInt("stock"), rset1.getString("descripcion"), rset1.getString("imagen"), rset1.getString("familia"),rset1.getInt("ubicacion"));
					
					out.println("<tr style='background-color:orange'>");
				    out.println("<td><a href=MostrarDetalles?idproducto='"+prod.getIdproducto()+"'>"+prod.getNombre()+"</td><td>"+prod.getMarca() + "</td><td><img src='./img/"+prod.getImagen()+"' width=100 heigh=100></td>");
				    if(prod.getStock()>0) {
				    	out.println("<td><a href=AnadirCesta?idproducto='"+prod.getIdproducto()+"'><img src=./img/carrito1.png width=40px></td>");
				    }else{
				    	out.println("<td></td>");
				    }
				    out.println("</tr>");
				    }
				  
				  
				  out.println("</table>");
				  
			  }
		  }
		  
		  
		  out.println("<form action='MostrarProductos' method='post'><br/>");
		    out.println("<label>Buscar: </label>");
		    out.println("<input type='text' name='busq'>");
		    out.println("<input type='submit' value='Enviar' name='enviar'>");
		  out.println("</form>");
		  
		  
		 
		  
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
