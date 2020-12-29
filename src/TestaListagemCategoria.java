import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().conectar()){
			
			List<Categoria> categoria;
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listar();
			
			categorias.forEach(System.out::println);
		}
		
	}

}