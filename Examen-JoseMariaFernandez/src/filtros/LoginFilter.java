package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req; 
		HttpServletResponse response = (HttpServletResponse) res; 
		ServletContext contexto = request.getServletContext(); 
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(false); 
		String errorSesion = ""; 
		
		if (session == null) {
			errorSesion="No hay sesion iniciada";
		} else {
			if (session.getAttribute("usuario") == null) {
				errorSesion="Sesion iniciada, pero no contiene usuario";
			}
		}
		
		if( !errorSesion.isEmpty() && !(uri.endsWith("html") || uri.endsWith("Login"))){ // L4
			contexto.log(errorSesion + " - " + uri);
			response.sendRedirect(contexto.getContextPath()+"/Login");
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
