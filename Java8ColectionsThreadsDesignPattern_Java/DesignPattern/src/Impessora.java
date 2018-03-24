public class Impessora implements AcaoAposGerarNota{
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Nota impresa");
	}
}
