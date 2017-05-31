package br.com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hotel.jdbc.ClienteDAO;
import br.com.hotel.model.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/clientecontroller.do")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Variaveis do sistema 
		 **/
		ClienteDAO cdao = null;
		Cliente c = null;
		
		/*
		 * Recebe a acao da pagina ListaCliente.jsp
		 *---------------------------------------------*/
		String action = request.getParameter("action");
		/*----------------------------------------------
		 */
		
		if(action !=null && action.equals("del")){
			
			String codCliente = request.getParameter("id");
			
			cdao = new ClienteDAO();
			c = new Cliente();
			
			c.setCodcliente(Long.parseLong(codCliente));
			cdao.deletar(c);//O metodo deletar precisa de um id do cliente
			/*
			 * Redirecionamento de paginas pelo cliente(browser)
			 * */
			response.sendRedirect("clientecontroller.do?action=list");
		}
		
		if(action !=null && action.equals("update")){
			
			String codCliente = request.getParameter("id");
			
			cdao = new ClienteDAO();
			c = cdao.pesquisarClienteCod(Long.parseLong(codCliente));
			request.setAttribute("cliente", c);
			RequestDispatcher rd = request.getRequestDispatcher("FrmCliente.jsp");
			rd.forward(request, response);
			
		}
			
		if(action !=null && action.equals("list")){
			
			cdao = new ClienteDAO();
			List<Cliente> listaC = cdao.listarTodos();
			
			request.setAttribute("listaCliente", listaC);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListaCliente.jsp");
			rd.forward(request, response);
		}
		
		if(action != null && action.equals("new")){
			
			c = new Cliente();
			/*
			 * Set os valores do objeto 'c' para que o formulario
			 * nao seja setado com 'null'
			 * */
			c.setCodcliente(0);
			c.setEmail("");
			c.setNome("");
			c.setSenha("");
			c.setSobrenome("");
			c.setTelefonecelular("");
			c.setTelefoneresid("");
			
			request.setAttribute("cliente", c);
			
			RequestDispatcher rd = request.getRequestDispatcher("FrmCliente.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("txtid");
		String email = request.getParameter("txtemail");
		String senha = request.getParameter("txtsenha");
		String nome =  request.getParameter("txtnome");
		String sobrenome = request.getParameter("txtsobrenome");
		
		Cliente c = new Cliente();
		
		if(id != ""){
			c.setCodcliente(Long.parseLong(id));
		}
		
		c.setEmail(email);
		c.setSenha(senha);
		c.setNome(nome);
		c.setSobrenome(sobrenome);
		
		ClienteDAO cdao = new ClienteDAO();
		cdao.salvar(c);
		
		PrintWriter pw = response.getWriter();
		pw.write("Salvo com sucesso.");
	}

}
