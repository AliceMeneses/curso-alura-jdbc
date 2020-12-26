import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		String nome = "Mouse'";
		String descricao = "Mouse em fio'); DELETE FROM PRODUTO;";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.conectar();
		PreparedStatement pst = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ( ? , ?)", Statement.RETURN_GENERATED_KEYS);
		
		pst.setString(1, nome);
		pst.setString(2, descricao);
		
		pst.execute();
		
		ResultSet rs = pst.getGeneratedKeys();
		while(rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		
	}

}
