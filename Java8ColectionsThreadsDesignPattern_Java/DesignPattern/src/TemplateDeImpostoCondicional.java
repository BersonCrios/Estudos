public abstract class TemplateDeImpostoCondicional extends Imposto {

	@Override
	public double calcula(Orcamento o) {
		if (deveUsarMaximaTaxacao(o)) {
			return maximaTaxacao(o) + calculoDoOutroImposto(o);
		}
		
		else{
			return minimaTaxacao(o) + calculoDoOutroImposto(o);
		}
	}

	public abstract double minimaTaxacao(Orcamento o);

	public abstract double maximaTaxacao(Orcamento o);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento o);

}
