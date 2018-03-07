package cuenta;
import modelo.Producto;
import modelo.Usuario;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		ServletContext contexto = getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		String mensajeError = "";
		
		Connection conn = null;
		Statement sentencia = null;
		try {
			
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			
			String userName = contexto.getInitParameter("usr_db_r");
			String password = contexto.getInitParameter("psw_db_r");
			String url = contexto.getInitParameter("srv_db")+"/supermercado";
			conn = DriverManager.getConnection(url, userName, password);

		
			sentencia = conn.createStatement();

			if (session != null) {
				if ((session.getAttribute("usuario") != null)) {
					response.sendRedirect(contexto.getContextPath() + "/MostrarProductos"); 
				}
			} else { 
				if (request.getMethod().equals("POST")) { 
				
					mensajeError = "";

					
					if (request.getParameter("login") == "") {
						mensajeError = "Usuario vacio";
					} else {
						
						if (request.getParameter("password") == "") {
							mensajeError = "Contraseña vacia";
						} else {
							if (request.getParameter("login") != "") {

								String consulta = "SELECT * FROM cliente where cliente.login LIKE '" + request.getParameter("username") + "'";
								ResultSet rset = sentencia.executeQuery(consulta);
								
								if (!rset.isBeforeFirst()) {
									mensajeError = "Usuario no valido";
									
								} else {
									rset.next();

									if (!rset.getString("password").equals(request.getParameter("password"))) {
										mensajeError = "Contraseña no valida";
									} else {
										String login = rset.getString("login");
										String pas = rset.getString("password");
										String nombre = rset.getString("nombre");
										double gasto = rset.getDouble("gasto");
										String direccion = rset.getString("direccion");
										
											session = request.getSession();

											Usuario user = new Usuario(login, pas, nombre, gasto,direccion );
											session.setAttribute("usuario", user);
											ArrayList<Producto> listProd=new ArrayList<Producto>();
											session.setAttribute("carrito", listProd);
											contexto.log("Crear sesion " + request.getRequestURI());
											response.sendRedirect(contexto.getContextPath() + "/MostrarProductos");

										}
									}

								}
							}
						}
						
					}
					

				}
			
			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Login</title></head><body>");
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
                    + "</form>"
					+ "<h3>" + mensajeError + "</h3>");
			
			
		 
		 
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
