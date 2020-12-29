package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.conectar();
		
		System.out.println("Fechando conexão");
		conn.close();
	}

}
