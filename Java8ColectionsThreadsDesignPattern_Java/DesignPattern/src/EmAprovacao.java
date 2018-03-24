public class EmAprovacao implements EstadoDeUmOrcamento{
	@Override
	public void aplicaDescontoExtra(Orcamento o) {
			o.valor -= o.valor * 0.05;
	}

	@Override
	public void aprova(Orcamento o) {
		o.estadoAtual = new Aprovado();
		
	}

	@Override
	public void reprova(Orcamento o) {
		o.estadoAtual = new Reprovado();
		
	}

	@Override
	public void finaliza(Orcamento o) {
		throw new RuntimeException("Orçamento em aprovação, operação não permitida");
	}
}
