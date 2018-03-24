public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento o) {
		throw new RuntimeException("Orçamentos reprovados não recebem desconto Extra");
	}

	@Override
	public void aprova(Orcamento o) {
		throw new RuntimeException("Não pode ser aprovado");

	}

	@Override
	public void reprova(Orcamento o) {
		throw new RuntimeException("Já esta reprovado");

	}

	@Override
	public void finaliza(Orcamento o) {
		o.estadoAtual = new Finalizado();
	}

}
