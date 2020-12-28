import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException{
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT * FROM CATEGORIA";
		
		try(PreparedStatement pstm =  connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rs = pstm.getResultSet()){
				while(rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(categoria);
				}
			}
		}
		
		return categorias;
	}
}
