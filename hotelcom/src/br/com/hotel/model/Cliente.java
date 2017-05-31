package br.com.hotel.model;

public class Cliente {
	
	private long codcliente;
	private String nome;
	private String email;
	private String senha;
	private String telefoneresid;
	private String telefonecelular;
	private String sobrenome;
	
	public Cliente(){
		
	}

	public long getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(long codcliente) {
		this.codcliente = codcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefoneresid() {
		return telefoneresid;
	}

	public void setTelefoneresid(String telefoneresid) {
		this.telefoneresid = telefoneresid;
	}

	public String getTelefonecelular() {
		return telefonecelular;
	}

	public void setTelefonecelular(String telefonecelular) {
		this.telefonecelular = telefonecelular;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
}
