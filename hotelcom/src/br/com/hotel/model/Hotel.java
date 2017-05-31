package br.com.hotel.model;

public class Hotel {
	
	private long   codhotel;
	private String nome;
	private String rua;
	private String qudra;
	private String lote;
	private String bairro;
	private String cidade;
	private String estado;
	private String descricao;
	private int    classificacao;
	private int    numero;
	
	public Hotel(){
		
	}

	public long getCodhotel() {
		return codhotel;
	}

	public void setCodhotel(long codhotel) {
		this.codhotel = codhotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getQudra() {
		return qudra;
	}

	public void setQudra(String qudra) {
		this.qudra = qudra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
