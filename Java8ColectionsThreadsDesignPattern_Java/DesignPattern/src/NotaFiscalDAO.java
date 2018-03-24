public class NotaFiscalDAO implements AcaoAposGerarNota{
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Salvei no Banco");
	}
}
