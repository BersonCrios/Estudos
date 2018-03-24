
public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		Imposto iss = new ISS(new ICMS(new ICPP()));
		
		Orcamento o = new Orcamento(500);
		
		double valor = iss.calcula(o);
		
		System.out.println(valor);
	}

}