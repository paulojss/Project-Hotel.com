package br.com.hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hotel.jdbc.ClienteDAO;
import br.com.hotel.model.Cliente;

/**
 * Servlet implementation class AutenticadorServlet
 */
@WebServlet("/autenticadorcontroller.do")
public class AutenticadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession(false);
		
		if(s != null){
			s.invalidate();
			
		}
		response.sendRedirect("login.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		
		Cliente c = new Cliente();
		c.setEmail(login);
		c.setSenha(senha);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente cReturn = cdao.autenticar(c);
		
		if(cReturn != null){
			
			//cria a sessao
			HttpSession s = request.getSession();
			s.setMaxInactiveInterval(1000);
			s.setAttribute("clienteLogado", cReturn);
			
			//Encaminha ao index
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else{
			
			response.sendRedirect("login.html");
		}
		
		
	}

}
