import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {
	
	Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try(ResultSet rs = pstm.getGeneratedKeys()){
				while(rs.next()) {
					produto.setId(rs.getInt(1));
				}
			}
		}
	}

}
