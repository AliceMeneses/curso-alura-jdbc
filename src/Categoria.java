
public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("CATEGORIA: %d, %s", this.id, this.nome);
	}
}
