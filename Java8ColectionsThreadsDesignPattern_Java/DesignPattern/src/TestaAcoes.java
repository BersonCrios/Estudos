
public class TestaAcoes {
	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();

		builder.adicionaAcao(new EnviadorDeEmail());
		builder.adicionaAcao(new EnviadorDeSms());
		builder.adicionaAcao(new NotaFiscalDAO());
		builder.adicionaAcao(new Impessora());

		NotaFiscal nf = builder.paraEmpresa("Caelum").comCnpj("13.123.123-123/123123-123")
				.comItem(new ItemDaNota("Nome do item", 100)).comObservacao("lkla").naDataAtual().constroi();
	
	System.out.println(nf.getValorBruto());
	}
}
