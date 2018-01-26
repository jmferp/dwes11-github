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
 * Servlet implementation class MostrarNumeroServlet
 */
@WebServlet("/MostrarNumero")
public class MostrarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarNumeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>"+request.getAttribute("numero")+"</title></head>");
		if(request.getAttribute("numero")==null) {
			ServletContext contexto = getServletContext();
			response.sendRedirect(contexto.getContextPath()+"/Sorpresa");
			out.println("<p>Error: No se ha generado el numero</p>");
		}else {
			Object o=request.getAttribute("num1");
			String r=o.toString();
			//int g=Integer.parseInt(request.getAttribute("num1").toString());
			//int b=Integer.parseInt(request.getAttribute("num1").toString());
			out.println("<p>"+r+"</p>");
			//out.println("<p>"+g+"</p>");
			//out.println("<p>"+b+"</p>");
		//out.println("<body style='color:rgb("+r+","+g+","+b+");'>");
		out.println("<p>"+request.getAttribute("numero")+"</p>");
		}
		out.println("<a href="+"./index.html"+">Index</a>");
		out.print("</body>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
