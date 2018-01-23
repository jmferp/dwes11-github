package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/MuestraVariablesServidor",name="MuestraVariablesServidor", initParams= {
@WebInitParam(name="alumno",value="josemaria"),
@WebInitParam(name="servlet1",value="serv1"),
@WebInitParam(name="servlet2",value="serv2"),
})
public class MuestraVariablesServidor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Variables servidor</title></head>"
				+ "<style>table,td {border:solid 1px black;}</style></head>");
		out.println("<body><h1>Variables de servidor</h1>");

		out.println("<h3>Variables contenidas en la petición (objeto request)</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		out.println("<tr> <td>Dirección remota (request.getRemoteAddress)</td> <td>" + request.getRemoteAddr()
				+ "</td></tr>");
		out.println(
				"<tr> <td>Puerto remoto (request.getRemotePort)</td> <td>" + request.getRemotePort() + "</td></tr>");
		out.println("<tr><td>URL invocada (request.getRequestURL)</td><td>" + request.getRequestURL() + "</td></tr>");
		out.println("<tr><td>Método de petición (request.getMethod)</td> <td>" + request.getMethod() + "</td></tr>");
		out.println("<tr><td>Protocolo (request.getProtocol)</td> <td>" + request.getProtocol() + "</td></tr>");
		out.println("<tr><td>Nombre del Servidor (request.getServerName)</td> <td>" + request.getServerName()
				+ "</td></tr>");
		out.println("<tr><td>Puerto del Servidor (request.getServerPort)</td> <td>" + request.getServerPort()
				+ "</td></tr>");
		out.println("<tr><td>Nombre del ServletPath (request.getServletPath)</td> <td>" + request.getServletPath()
				+ "</td></tr>");
		out.println("</table><br/>");

		out.println("<h3>Variables contenidas en el contexto (objeto servletContext)</h3>");
		ServletContext contexto = getServletContext();
		Enumeration <String> parametros= contexto.getInitParameterNames();
		Enumeration <String> parametrosServlet= this.getInitParameterNames();

		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		out.println("<tr><td>Software de SERVIDOR</td><td>" + contexto.getServerInfo() + "</td></tr>");
		out.println("<tr><td>Directorio de DESPLIEGUE</td><td>" + contexto.getRealPath("/") + "</td></tr>");
		out.println("<tr><td>Nombre de la aplicación</td><td>" + contexto.getServletContextName() + "</td></tr>");
		out.println("<tr><td>Parametro de inicio de servlet</td><td>" + contexto.getInitParameter("alumno") + "</td></tr>");
		out.println("</table>");
		
		out.println("<h3>Parametros de inicializacion del servlet"+request.getServletPath()+"</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		while(parametrosServlet.hasMoreElements()) {
			String actual=parametrosServlet.nextElement();
		out.print("<tr><td>"+actual+"</td><td>"+this.getInitParameter(actual)+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("<h3>Parametros de inicializacion del contexto"+contexto.getServletContextName()+"</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		while(parametros.hasMoreElements()) {
			String actual=parametros.nextElement();
		out.print("<tr><td>"+actual+"</td><td>"+contexto.getInitParameter(actual)+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("<p>El servidor de bases de datos que utilizaremos es "+contexto.getInitParameter("srv_bd")+"</p>");
		out.println("<p>El servidor de bases de datos que utilizaremos es "+this.getInitParameter("servlet1")+"</p>");
		
		Enumeration <String> parametrosRequest= request.getParameterNames();
		out.println("<h3>Parametros de la request</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		while(parametrosRequest.hasMoreElements()) {
			String actual=parametrosRequest.nextElement();
		out.print("<tr><td>"+actual+"</td><td>"+request.getParameter(actual)+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("<h3>Atributos de la request</h3>");
		request.setAttribute("fecha", new Date(0));
		request.setAttribute("autor", "Tu Nombre");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		while(parametrosRequest.hasMoreElements()) {
			String actual=parametrosRequest.nextElement();
		out.print("<tr><td>"+actual+"</td><td>"+request.getParameter(actual)+"</td></tr>");
		}
		out.println("</table>");
		out.close();
	}
}