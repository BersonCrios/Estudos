public class Finalizado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento o) {
		throw new RuntimeException("Somente orcamento finalizados ou em aprova��o");
	}

	@Override
	public void aprova(Orcamento o) {
		throw new RuntimeException("J� finalizado");
	}

	@Override
	public void reprova(Orcamento o) {
		throw new RuntimeException("J� finalizado");
	}

	@Override
	public void finaliza(Orcamento o) {
		throw new RuntimeException("J� finalizadoo");
	}

}
