package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.DAO.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto sofa = new Produto("sofa", "sofa de canto");
		
		List<Produto> produtos;
				
		ConnectionFactory cf = new ConnectionFactory();
		try(Connection con = cf.conectar()){
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			produtoDAO.salvar(sofa);
			produtos = produtoDAO.listar();
		}
		
		produtos.forEach(System.out::println);
	}

}
