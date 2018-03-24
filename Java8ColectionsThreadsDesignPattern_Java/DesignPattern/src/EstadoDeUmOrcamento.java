public interface EstadoDeUmOrcamento {
	void aplicaDescontoExtra(Orcamento o);
	
	void aprova(Orcamento o);
	void reprova(Orcamento o);
	void finaliza(Orcamento o);
	
}
