package br.com.nfesd.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.nfesd.factory.JPAFactory;
import br.com.nfesd.model.Produto;
import br.com.nfesd.repository.ProdutoRepository;
import br.com.nfesd.validation.ProdutoValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private List<Produto> listaProduto;

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
		}
		return entity;
	}

	@Override
	public Validation<Produto> getValidation() {
		return new ProdutoValidation();
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaProduto(null);
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
