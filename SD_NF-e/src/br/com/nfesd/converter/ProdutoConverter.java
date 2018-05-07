package br.com.nfesd.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nfesd.factory.JPAFactory;
import br.com.nfesd.model.Produto;
import br.com.nfesd.repository.ProdutoRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ProdutoRepository repo = new ProdutoRepository(JPAFactory.getEntityManager());

		try {
			Produto f = ((Produto) repo.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Produto) arg2).getId() == null ? "" : ((Produto) arg2).getId().toString();
		}
		return "";
	}

}
