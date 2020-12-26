import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.conectar();
		
		PreparedStatement pst = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID >= ?");
		pst.setInt(1, 2);
		
		pst.execute();
		
		int linhas = pst.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + linhas);


	}

}
