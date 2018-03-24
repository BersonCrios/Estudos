public class ICPP extends TemplateDeImpostoCondicional{

	@Override
	public double minimaTaxacao(Orcamento o) {
		return o.getValor() * 0.05;
	}

	@Override
	public double maximaTaxacao(Orcamento o) {
		return o.getValor() * 0.07;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento o) {
		return o.getValor() > 500 ;
	}


}
