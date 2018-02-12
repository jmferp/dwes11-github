package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.println("<html><head><meta charset='UTF-8'/></head>");
		int num[]= {0,1,2,3,4,5,6,7,8,9};
		
		boolean validado=false;
		boolean env=false;
		boolean env1=false;
		boolean env2=false;
		boolean env3=false;

		String pas=request.getParameter("password");
		
		for (int i = 0; i < pas.length(); i++) {
			char p = pas.charAt(i);
			String pa = String.valueOf(p);
			if (pa.matches("[A-Z]")) {
				env = true;
			}
			if (pa.matches("[0-9]")) {
				env1 = true;
			}
		}
		
		char especiales[]= {'?','¿','!','¡','(',')','@'};
		for(int i=0;i<pas.length();i++) {
			for(int k=0;k<especiales.length;k++) {
				if(pas.charAt(i)==(especiales[k])) {
					env2=true;
				}
			}
		}
		
		String tlf=request.getParameter("tlf");
		int cont=0;
		for(int j=0;j<tlf.length();j++) {
			for(int i=0;i<num.length;i++) {
				String s=String.valueOf(tlf.charAt(j));
				int st=Integer.parseInt(s);
				if(st==(num[i]) ) {
					cont++;
				}
			}
		}
		
		SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
		

		try{

			Date fecha=formatoEntrada.parse(request.getParameter("fecha"));
			Date actual=new Date();
			
			long ActualMilisegundos = actual.getTime();
			long FechaMilisegundos1 = fecha.getTime();
			
			
		if(ActualMilisegundos>FechaMilisegundos1){
			env3=true;			
		}else {
					
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		int nm=Integer.parseInt(request.getParameter("numero"));
		boolean env4=false;
		if(request.getParameter("numero")!="") {
			if(nm>0) {
			if(request.getParameter("numero").matches("[0-9]+")) {
				env4=true;
			
			}
		}
		}
		
		
		if(env&&env1&&env2&&env3&&cont==9&&env4) {
			validado=true;
		}
		
		if(!validado) {
			response.sendRedirect("./index.html");
		}else {
			int limite=Integer.parseInt(request.getParameter("numero"));
			int numero=(int)(Math.random()*limite);
			request.setAttribute("numeroAleatorio", numero);
			RequestDispatcher rd = request.getRequestDispatcher("/ProcesarDatos");
			rd.forward(request, response);	
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
