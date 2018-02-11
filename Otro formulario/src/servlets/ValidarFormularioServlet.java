package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarFormularioServlet
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarFormularioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		char especiales[] = { '*', '-', '+', '?', '¿', '!', '¡' };
		String pass = request.getParameter("pass");
		boolean encontradoNum = false;
		boolean encontradoChar = false;
		boolean encontradoMayus = false;
		
		char clave;

		for (int i = 0; i < pass.length(); i++) {
			clave = pass.charAt(i);
			String passValue = String.valueOf(clave);
			if (passValue.matches("[A-Z]")) {
				encontradoMayus = true;
				
			} else if (passValue.matches("[0-9]")) {
				encontradoNum = true;
			}
		}
		for (int i = 0; i < pass.length() && !encontradoChar; i++) {

			for (int j = 0; j < especiales.length && !encontradoChar; j++) {
				if (pass.charAt(i) == especiales[j]) {
					encontradoChar = true;
				}
			}
		}
		
		
		SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
		boolean fechacorrect=false;

		try{

			Date fecha=formatoEntrada.parse(request.getParameter("fecha"));
			Date actual=new Date();
			
			long ActualMilisegundos = actual.getTime();
			long FechaMilisegundos1 = fecha.getTime();
			
			
		if(ActualMilisegundos>FechaMilisegundos1){
			fechacorrect=true;			
		}else {
			fechacorrect=false;			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		int nm=Integer.parseInt(request.getParameter("numero"));
		boolean numeric=false;
		if(request.getParameter("numero")!="") {
			if(nm>0) {
			if(request.getParameter("numero").matches("[0-9]+")) {
				numeric=true;
			}else {
				numeric=false;
			}
			}
		}
		boolean nombrevacio=false;
		
		if(request.getParameter("nombre")!="") {
			nombrevacio=true;
		}else {
			nombrevacio=false;
		}
		
		if (!encontradoNum || !encontradoChar || !encontradoMayus 
				|| !numeric || !fechacorrect || !nombrevacio) {

			response.sendRedirect("./index.html");

		} else if (encontradoNum && encontradoChar && encontradoMayus 
				&& numeric && fechacorrect && nombrevacio) {
			int limite=Integer.parseInt(request.getParameter("numero"));
			int num=(int)(Math.random()*limite);
			request.setAttribute("numeroAleatorio", num);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ProcesarDatos");
			rd.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}