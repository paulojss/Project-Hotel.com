package br.com.hotel.test;

import java.util.List;

import br.com.hotel.jdbc.ClienteDAO;
import br.com.hotel.model.Cliente;

public class TestClienteDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCadastrar();
		//testAlterar();
		//testDeletar();
		//testListaTodos();
		//testAutenticar();
		//testPesquisarClienteCod();
	}

	private static void testCadastrar() {
		Cliente c = new Cliente();
		c.setNome("paulo");
		c.setEmail("@");
		c.setSenha("123");
		c.setSobrenome("santos");
		//c.setTelefonecelular("1234");
		//c.setTelefoneresid("1234");
		
		ClienteDAO cdao = new ClienteDAO();
		cdao.cadastrar(c);
	}
	
	public static void testAlterar(){
		Cliente c = new Cliente();
		c.setCodcliente(1);
		c.setNome("paulo");
		c.setEmail("paulo@gmail.com");
		c.setSenha("123");
		c.setSobrenome("santos");
		c.setTelefonecelular("1234");
		c.setTelefoneresid("1234");
		
		ClienteDAO cdao = new ClienteDAO();
		cdao.alterar(c);
	}
	
	public static void testDeletar(){
		Cliente c = new Cliente();
		c.setCodcliente(1);
		
		ClienteDAO cdao = new ClienteDAO();
		cdao.deletar(c);
	}

	public static void testListaTodos(){
		ClienteDAO cdao = new ClienteDAO();
		List<Cliente> l = cdao.listarTodos();
		
		for(Cliente c: l){
			System.out.println(c.getCodcliente());
			System.out.println(c.getEmail());
			System.out.println(c.getNome());
			System.out.println(c.getSenha());
			System.out.println(c.getSobrenome());
			System.out.println(c.getTelefonecelular());
			System.out.println(c.getTelefoneresid());
		}
	}
	
	public static void testAutenticar(){
		Cliente c = new Cliente();
		c.setEmail("@");
		c.setSenha("123");
		
		ClienteDAO dao = new ClienteDAO();
		System.out.println(dao.autenticar(c));
	}
	
	public static void testPesquisarClienteCod(){
		ClienteDAO dao = new ClienteDAO();
		System.out.println(dao.pesquisarClienteCod(2));
	}
}
