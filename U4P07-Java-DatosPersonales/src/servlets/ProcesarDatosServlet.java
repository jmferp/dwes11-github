package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesarDatosServlet
 */
@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SimpleDateFormat formatoFechaFormulario= new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha = formatoFechaFormulario.parse(request.getParameter("fecha"));
			SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
			out.println("Fecha:"+formatoFechaSalida.format(fecha));
		}catch(ParseException e){
			e.printStackTrace();
		}
		out.print("<ul>");
		Enumeration <String> param=request.getParameterNames();
		while(param.hasMoreElements()) {
			String actual=param.nextElement();
			out.println("<li>"+actual+" "+request.getParameter(actual)+"</li>");
		}
		out.println("</ul>");
		
		String[] valores=request.getParameterValues("aficion");
		out.println("<ul>Aficion");
		for(int i=0;i<valores.length;i++) {
			out.println("<li>"+valores[i]+"</li>");
		}
		out.println("</ul>");
		
		/*Map <String,String[]> paresPeticion=request.getParameterMap();
		paresPeticion.forEach((parametro,valor)->{
			out.println("<p>"+parametro+"");
			for(Object v:valor) {
				out.println(":"+valor+"</p>");
			}
		});*/
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
