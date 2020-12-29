package br.com.alura.jdbc.modelo;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	
	public Produto(int id, String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Produto: %d - %s - %s", this.id, this.nome, this.descricao);
	}
}
