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
 * Servlet implementation class MostrarCuidadorServlet
 */
@WebServlet("/MostrarCuidadorServlet")
public class MostrarCuidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCuidadorServlet() {
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
		
		int idCuidador = 0;
		boolean errorIdCuidadorAusente = false;
		boolean errorIdCuidadorFormato = false;
		boolean errorIdCuidadorInexistente = false;
		String idCuidadorParametro = request.getParameter("idCuidador");
		if (idCuidadorParametro == null)
		  errorIdCuidadorAusente = true;
		else {
		  try {
		    idCuidador = Integer.parseInt(idCuidadorParametro);
		  } catch (Exception e) {
		    errorIdCuidadorFormato = true;
		  }
		}

		if (errorIdCuidadorAusente) {
		  out.println("<h3>Error: falta identificador de cuidador</h3>");
		} else if (errorIdCuidadorFormato) {
		  out.println("<h3>Error: el identificador de cuidador debe ser numérico</h3>");
		} else {
		  // TO-DO: incluir el código de acceso a la base de datos
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
