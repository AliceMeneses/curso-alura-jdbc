import java.sql.SQLException;

public class TestaConexao2 {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory cf = new  ConnectionFactory();
		for(int i = 1; i <=20; i++) {
			cf.conectar();
			System.out.println("Conexão:" + i);
		}
	}

}
