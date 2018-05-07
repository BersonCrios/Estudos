package br.com.nfesd.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.nfesd.model.Produto;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class ProdutoValidation implements Validation<Produto>{
	List<String> listMessages;

	@Override
	public void validate(Produto i) throws ValidationException {
		if (i.getCodigo() == null || i.getCodigo().equals("")){
			getlistMessages().add("O número do item deve ser infomado");
		}
		
		if (i.getPrecoUni() == null || i.getPrecoUni().equals("")){
			getlistMessages().add("A data deve ser informada");
		}
		
		if (getlistMessages().size() > 0){
			throw new ValidationException(getlistMessages());
		}
	}
	
	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}
	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}

}
