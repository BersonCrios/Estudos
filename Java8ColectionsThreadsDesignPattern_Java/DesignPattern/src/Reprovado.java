public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento o) {
		throw new RuntimeException("Or�amentos reprovados n�o recebem desconto Extra");
	}

	@Override
	public void aprova(Orcamento o) {
		throw new RuntimeException("N�o pode ser aprovado");

	}

	@Override
	public void reprova(Orcamento o) {
		throw new RuntimeException("J� esta reprovado");

	}

	@Override
	public void finaliza(Orcamento o) {
		o.estadoAtual = new Finalizado();
	}

}
