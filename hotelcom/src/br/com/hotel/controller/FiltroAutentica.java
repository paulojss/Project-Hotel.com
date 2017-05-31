package br.com.hotel.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutentica implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutentica() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//Casting do HttpServeltRequest
		HttpServletRequest hsrequest = (HttpServletRequest) request;
		
		//Captura o caminho da aplicacao
		String url = hsrequest.getRequestURI();
		
		//captura sessao
		HttpSession s = hsrequest.getSession();
		
		
		if(s.getAttribute("clienteLogado") != null || url.lastIndexOf("index.jsp")>-1 || url.lastIndexOf("autenticadorcontroller.do")>-1){
			
			// pass the request along the filter chain
			chain.doFilter(request, response);
			
		}else{
			
			//redireciona para login
			//((HttpServletResponse) response).sendRedirect("login2.html");
			((HttpServletResponse) response).sendRedirect("index.jsp");
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
