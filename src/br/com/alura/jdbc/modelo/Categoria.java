package br.com.alura.jdbc.modelo;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int id;
	private String nome;
	private List<Produto> produtos;
	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.produtos = new ArrayList<Produto>();
		
	}
	
	@Override
	public String toString() {
		return String.format("CATEGORIA: %d, %s", this.id, this.nome);
	}

	public String getNome() {
		return nome;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
