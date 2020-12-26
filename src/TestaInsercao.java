import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.conectar();
		
		Statement stm = con.createStatement();
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('MOUSE', 'MOUSE SEM FIO')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		while(rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		
	}

}
