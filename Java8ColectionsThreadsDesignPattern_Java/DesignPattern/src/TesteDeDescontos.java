public class TesteDeDescontos {
	public static void main(String[] args) {
		CalculadorDeDesconto desc = new CalculadorDeDesconto();
		
		Orcamento o = new Orcamento(600.0);
		
		Item caneta = new Item("Caneta", 250.0);
		Item lapis = new Item("Lapis", 250.0);
		
		o.adicionaItem(caneta);
		o.adicionaItem(lapis);
		
		double descontoFinal = desc.calcula(o);
		
		System.out.println(descontoFinal);
	}
}
