package br.com.hotel.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hotel.model.Cliente;

public class ClienteDAO 
{

	private Connection connection = Conexao.getConnection();
	
	public void cadastrar(Cliente c){
		
		String sql = "INSERT INTO cliente (nome,email,senha,sobrenome) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getSenha());
			//ps.setString(4, c.getTelefoneresid());
			//ps.setString(5, c.getTelefonecelular());
			ps.setString(4, c.getSobrenome());
			
			ps.execute();
			ps.close();
			
			System.out.println("Cadastrado com sucesso.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: Classe 'ClienteDAO', metodo 'cadastrar'.");
			e.printStackTrace();
		}
				
	}//fim do metodo cadastrar
	
	public void alterar(Cliente c){
		String sql = "UPDATE cliente SET nome=?,email=?,senha=?,telefoneresid=?,telefonecelular=?,sobrenome=? WHERE codcliente=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getSenha());
			ps.setString(4, c.getTelefoneresid());
			ps.setString(5, c.getTelefonecelular());
			ps.setString(6, c.getSobrenome());
			ps.setLong  (7, c.getCodcliente());
			ps.execute();
			ps.close();
			
			System.out.println("Alterado com sucesso.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: Classe 'ClienteDAO', metodo 'alterar'.");
			e.printStackTrace();
		}
	}//fim do metodo alterar
	
	public void salvar(Cliente c){
		
		if(c.getCodcliente() != 0)
			alterar(c);
		else
			cadastrar(c);
		
	}//fim do metodo salvar
	
	public void deletar(Cliente c){
		String sql = "DELETE FROM cliente WHERE codcliente=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setLong  (1, c.getCodcliente());
			ps.execute();
			ps.close();
			
			System.out.println("Excluido com sucesso.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: Classe 'ClienteDAO', metodo 'alterar'.");
			e.printStackTrace();
		}
	}//fim do metodo deletar
	
	public List<Cliente> listarTodos(){
		String sql = "SELECT * FROM cliente";
		List<Cliente> list = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Cliente c = new Cliente();
				
				c.setCodcliente(rs.getLong("codcliente"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setSenha(rs.getString("senha"));
				c.setTelefoneresid(rs.getString("telefoneresid"));
				c.setTelefonecelular(rs.getString("telefonecelular"));
				c.setSobrenome(rs.getString("sobrenome"));
				
				list.add(c);
			}//fim do while
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: Classe 'ClienteDAO', metodo 'alterar'.");
			e.printStackTrace();
		}//fim do try/catch
		return list;
	}//fim do metodo listarTodos
	
	public Cliente pesquisarClienteCod(long cod){
		String sql = "SELECT * FROM cliente WHERE codcliente=?";
		Cliente c = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, cod);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c = new Cliente();	
				c.setCodcliente(rs.getLong("codcliente"));
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				c.setSenha(rs.getString("senha"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setTelefonecelular(rs.getString("telefonecelular"));
				c.setTelefoneresid(rs.getString("telefoneresid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}//fim do metodo pesquisarClienteCod
	
	/**
	 * Busca por login e senha de usuario
	 * @param client 
	 * @return Null quando nao encontra no banco ou um ponteiro a um objeto Client completo quando encontra
	 */
	public Cliente autenticar(Cliente client){
		String sql = "SELECT * FROM cliente WHERE email=? and senha=?";
		Cliente c = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, client.getEmail());
			ps.setString(2, client.getSenha());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c = new Cliente();
				c.setCodcliente(rs.getLong("codcliente"));
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				c.setSenha(rs.getString("senha"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setTelefonecelular(rs.getString("telefonecelular"));
				c.setTelefoneresid(rs.getString("telefoneresid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fim do try/catch
		return c;
	}//fim do metodo autenticar
	
}
