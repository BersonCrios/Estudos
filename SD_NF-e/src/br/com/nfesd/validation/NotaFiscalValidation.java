package br.com.nfesd.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.nfesd.model.NotaFiscal;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class NotaFiscalValidation implements Validation<NotaFiscal>{
	List<String> listMessages;

	@Override
	public void validate(NotaFiscal i) throws ValidationException {
		if (i.getNumero() == null || i.getNumero().equals("")){
			getlistMessages().add("O número do item deve ser infomado");
		}
		
		if (i.getData() == null || i.getData().equals("")){
			getlistMessages().add("A data deve ser informada");
		}
		
		if (i.getTributos() == null || i.getTributos().equals("")){
			getlistMessages().add("A tributação deve ser informada");
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
