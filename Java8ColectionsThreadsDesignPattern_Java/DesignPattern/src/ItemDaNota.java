public class ItemDaNota {
	private String Nome;
	private double valor;

	public ItemDaNota(String nome, double valor) {
		Nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return Nome;
	}

	public double getValor() {
		return valor;
	}
}
