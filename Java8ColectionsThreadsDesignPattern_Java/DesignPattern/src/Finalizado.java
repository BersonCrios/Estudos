public class Finalizado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento o) {
		throw new RuntimeException("Somente orcamento finalizados ou em aprovação");
	}

	@Override
	public void aprova(Orcamento o) {
		throw new RuntimeException("Já finalizado");
	}

	@Override
	public void reprova(Orcamento o) {
		throw new RuntimeException("Já finalizado");
	}

	@Override
	public void finaliza(Orcamento o) {
		throw new RuntimeException("Já finalizadoo");
	}

}
