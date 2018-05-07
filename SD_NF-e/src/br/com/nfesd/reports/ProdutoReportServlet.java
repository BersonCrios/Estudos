package br.com.nfesd.reports;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.com.nfesd.factory.JPAFactory;



@WebServlet("/produto")
public class ProdutoReportServlet extends ReportServlet {

	private static final long serialVersionUID = 3950243916175811238L;

	@Override
	public String getArquivoJasper() {
		return "produto.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
   
}