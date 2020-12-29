package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.conectar();
		
		PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUTO");
		pst.execute();
		
		ResultSet rst = pst.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			
			System.out.println(id + " - " + nome + " - " + descricao);
		}

		con.close();

	}

}
