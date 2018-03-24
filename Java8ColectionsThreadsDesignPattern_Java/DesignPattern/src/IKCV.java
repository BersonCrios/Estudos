public class IKCV extends TemplateDeImpostoCondicional{
	@Override
	public double minimaTaxacao(Orcamento o) {
		return o.getValor() * 0.06;
	}

	@Override
	public double maximaTaxacao(Orcamento o) {
		return o.getValor() * 0.1;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento o) {
		return o.getValor() > 500 && temItemMaiorQue100ReaisNo(o) ;
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento o) {
		for (Item i : o.getItens()) {
			if(i.getValor() > 100){
				return true;
			}
		}
		return false;
	}
}
