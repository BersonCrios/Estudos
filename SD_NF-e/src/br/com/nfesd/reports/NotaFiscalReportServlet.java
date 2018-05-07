package br.com.nfesd.reports;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.com.nfesd.factory.JPAFactory;



@WebServlet("/notaFiscal")
public class NotaFiscalReportServlet extends ReportServlet {

	private static final long serialVersionUID = -1364483431279888834L;

	@Override
	public String getArquivoJasper() {
		return "notaFiscal.jasper";
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