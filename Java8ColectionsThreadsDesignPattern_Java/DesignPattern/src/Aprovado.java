public class Aprovado implements EstadoDeUmOrcamento{
	@Override
	public void aplicaDescontoExtra(Orcamento o) {
		o.valor -= o.valor * 0.02;
}

	@Override
	public void aprova(Orcamento o) {
		throw new RuntimeException("Já aprovado");

	}

	@Override
	public void reprova(Orcamento o) {
		throw new RuntimeException("Já aprovado, não pode ser reprovado");

	}

	@Override
	public void finaliza(Orcamento o) {
		o.estadoAtual = new Finalizado();
	}
}
