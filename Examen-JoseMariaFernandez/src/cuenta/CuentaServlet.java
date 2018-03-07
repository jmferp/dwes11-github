package cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class CuentaServlet
 */
@WebServlet("/Cuenta")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		ServletContext contexto = request.getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		
		out.println(usuario.toString());
		
		ArrayList<Producto> listprod= (ArrayList<Producto>) session.getAttribute("carrito");
		double sum=0;;
		out.println("<p>Precio total</p>");
		for(int i=0;i<listprod.size();i++) {
			sum=listprod.get(i).getPrecio()+sum;
			
		}
		out.println("<p>"+sum+"</p>");
		
		out.println("<p><a href='"+contexto.getContextPath()+"/Logout'>Cerrar sesion</a></p>");
		out.println("<p><a href='"+contexto.getContextPath()+"/Compra'>Compra</a></p>");
		out.println("<p><a href='"+request.getHeader("Referer")+"'>Volver</a></p>");
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
