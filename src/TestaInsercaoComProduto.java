import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto sofa = new Produto("sofa", "sofa de canto");
				
		ConnectionFactory cf = new ConnectionFactory();
		try(Connection con = cf.conectar()){
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			produtoDAO.salvar(sofa);
		}
		
		System.out.println(sofa);
	}

}
