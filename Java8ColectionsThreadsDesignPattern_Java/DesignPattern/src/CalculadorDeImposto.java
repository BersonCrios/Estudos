public class CalculadorDeImposto {
	public void realaizaCalculo(Orcamento o, Imposto impostoQualquer){
		double i = impostoQualquer.calcula(o);
		
		System.out.println(i);
	}
}
