package br.com.nfesd.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NF-e");
	
	private JPAFactory() {}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}