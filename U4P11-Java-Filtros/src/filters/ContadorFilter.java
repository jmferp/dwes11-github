package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ContadorFilter
 */
@WebFilter(filterName="FiltroDeContador")
public class ContadorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ContadorFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Aplicando filtro contador");
		ServletContext contexto = request.getServletContext();
		if(contexto.getAttribute("contador")!=null) {
			int cont=Integer.parseInt(contexto.getAttribute("contador").toString());
			cont++;
			contexto.setAttribute("contador", cont );
		}else {
			contexto.setAttribute("contador", 1);
		}
		
		chain.doFilter(request, response);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
