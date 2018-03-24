import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private double impostos;
	private String observacao;
	private Calendar data;

	private List<AcaoAposGerarNota> todasAsAcoesASeremExecultada;

	public NotaFiscalBuilder() {
		this.todasAsAcoesASeremExecultada = new ArrayList<AcaoAposGerarNota>();
	}

	
	public void adicionaAcao(AcaoAposGerarNota acao){
		this.todasAsAcoesASeremExecultada.add(acao);
	}
	
	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String Cnpj) {
		cnpj = Cnpj;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota i) {
		todosItens.add(i);
		valorBruto += i.getValor();
		impostos += i.getValor() * 0.05;
		return this;
	}

	public NotaFiscalBuilder comObservacao(String Observacao) {
		observacao = Observacao;
		return this;
	}

	public NotaFiscalBuilder naDataAtual() {
		this.data = Calendar.getInstance();
		return this;
	}

	public NotaFiscal constroi() {
		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, observacao);

		for (AcaoAposGerarNota acao : todasAsAcoesASeremExecultada) {
			acao.executa(nf);
		}

		return nf;
	}

}
