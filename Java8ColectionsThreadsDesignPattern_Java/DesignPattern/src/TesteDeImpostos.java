public class TesteDeImpostos {

	public static void main(String[] args) {
		Imposto iss  = new ISS();
		Imposto icms  = new ICMS();
		
		Orcamento o = new Orcamento(500.0);
		
		CalculadorDeImposto c = new CalculadorDeImposto();
		
		c.realaizaCalculo(o, iss);
		c.realaizaCalculo(o, icms);
	}

}
