package br.com.nfesd.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.nfesd.factory.JPAFactory;
import br.com.nfesd.model.NotaFiscal;
import br.com.nfesd.model.Produto;
import br.com.nfesd.repository.NotaFiscalRepository;
import br.com.nfesd.repository.ProdutoRepository;
import br.com.nfesd.util.Report;
import br.com.nfesd.validation.NotaFiscalValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class NotaFiscalController extends Controller<NotaFiscal> {

	private List<NotaFiscal> listaNotaFiscal;
	private List<Produto> listaProduto;
	
	
	private Report relatorio;
	
	
	public Report getRelatorio() {
		if (relatorio == null) 
			relatorio = new Report("jdbc/nfe", "reports", "notaFiscal");
		return relatorio;
}
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public NotaFiscal getEntity() {
		if (entity == null) {
			entity = new NotaFiscal();
		}
		return entity;
	}

	@Override
	public Validation<NotaFiscal> getValidation() {
		return new NotaFiscalValidation();
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaNotaFiscal(null);
	}

	public List<NotaFiscal> getListaNotaFiscal() {
		if (listaNotaFiscal == null) {
			NotaFiscalRepository repository = new NotaFiscalRepository(JPAFactory.getEntityManager());
			listaNotaFiscal = repository.bucarTodos();
		}
		return listaNotaFiscal;
	}

	public void setListaNotaFiscal(List<NotaFiscal> listaNotaFiscal) {
		this.listaNotaFiscal = listaNotaFiscal;
	}

	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			ProdutoRepository repository = new ProdutoRepository(JPAFactory.getEntityManager());
			listaProduto = repository.bucarTodos();
		}
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
}
