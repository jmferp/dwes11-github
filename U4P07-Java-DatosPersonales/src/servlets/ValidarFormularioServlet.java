package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head>");

		boolean validado=true;
		boolean env=false;
		boolean env1=false;
		boolean env2=false;
		boolean env3=false;
		boolean env4=false;
		String pas=request.getParameter("password");
		String num[]={"0","1","2","3","4","5","6","7","8","9"};
		String letra[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
		for(int i=0;i<num.length;i++) {
			if(pas.contains(num[i])) {
			env=true;
			}
		}
		for(int j=0;j<letra.length;j++) {
			if(pas.contains(letra[j])) {
				env1=true;
			}
		}
		String especiales[]= {"á","é","í","ó","ú","ü","ñ"};
		for(int k=0;k<especiales.length;k++) {
			if(pas.contains(especiales[k])) {
				env2=true;
			}
		}
		
		String tlf=request.getParameter("tlf");
		for(int i=0;i<num.length;i++) {
			int j=0;
			String s=String.valueOf(tlf.charAt(j));
			if(s.equalsIgnoreCase(num[i]) ) {
				env3=true;
			}
		}
		
		SimpleDateFormat formatoFechaFormulario= new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha = formatoFechaFormulario.parse(request.getParameter("fecha"));
			SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
			out.println("Fecha:"+formatoFechaSalida.format(fecha));
			
			Date date=new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			if(fecha.before(date)) {
				env4=true;
			}
			
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		if(env&&env1&&env2&&env3&&env4) {
			validado=true;
		}
		
		if(validado) {
		

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
		}else {
			out.println("Error");
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
