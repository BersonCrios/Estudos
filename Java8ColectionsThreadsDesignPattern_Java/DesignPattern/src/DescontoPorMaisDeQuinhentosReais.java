public class DescontoPorMaisDeQuinhentosReais implements Desconto {
	private Desconto prox;

	@Override
	public double desconta(Orcamento o) {
		if (o.getValor() > 500) {
			return o.getValor() * 0.07;
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
