import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao2 {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection con = factory.conectar()) {
			con.setAutoCommit(false);

			try (PreparedStatement pst = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ( ? , ?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("TV", "LG", pst);
				adicionarVariavel("Teclado", "teclado gamer", pst);

				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				con.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement pst) throws SQLException {
		pst.setString(1, nome);
		pst.setString(2, descricao);

		pst.execute();

		/*
		 * if(nome == "Teclado") { throw new RuntimeException("Inserção não efetuada");
		 * 
		 * }
		 */

		try (ResultSet rs = pst.getGeneratedKeys()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println(id);
			}
		}
	}

}
