import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().conectar()) {

			List<Categoria> categoria;
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listarComProdutos();

			categorias.forEach(ct -> {
				
				System.out.println(ct.getNome());
				for(Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
