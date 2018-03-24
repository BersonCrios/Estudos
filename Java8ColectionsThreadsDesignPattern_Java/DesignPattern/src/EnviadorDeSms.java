public class EnviadorDeSms implements AcaoAposGerarNota {
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Envei por SMS");
	}
}
