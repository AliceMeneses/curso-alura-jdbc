import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto sofa = new Produto("sofa", "sofa de canto");
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";
		
		ConnectionFactory cf = new ConnectionFactory();
		try(Connection con = cf.conectar()){
			try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, sofa.getNome());
				pstm.setNString(2, sofa.getDescricao());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					while(rs.next()) {
						sofa.setId(rs.getInt(1));
					}
				}
			}
		}
		
		System.out.println(sofa);
	}

}
