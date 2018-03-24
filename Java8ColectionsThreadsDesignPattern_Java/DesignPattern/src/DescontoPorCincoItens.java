public class DescontoPorCincoItens implements Desconto{
	private Desconto prox;

	@Override
	public double desconta(Orcamento o) {
		if (o.getItens().size() > 5) {
			return o.getValor() * 0.1;
		}

		else {
			return prox.desconta(o);
		}
	}

	@Override
	public void setProximo(Desconto prox) {
		this.prox = prox;
	}
}
