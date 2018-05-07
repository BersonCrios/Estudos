package br.com.nfesd.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.nfesd.model.NotaFiscal;
import br.unitins.frame.repository.Repository;

public class NotaFiscalRepository extends Repository<NotaFiscal> {
	public NotaFiscalRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<NotaFiscal> getModelClass() {
		return NotaFiscal.class;
	}

	@SuppressWarnings("unchecked")
	public List<NotaFiscal> bucarTodos() {

		Query query = geEntityManager().createQuery("Select nf From NotaFiscal nf Order by nf.id Desc");
		List<NotaFiscal> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<NotaFiscal>();

		return lista;

	}
}
