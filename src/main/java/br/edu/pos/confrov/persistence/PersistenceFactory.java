package br.edu.pos.confrov.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceFactory {
	
	private static final EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("confrov-pu");
	}
	
	public static EntityManager getEntityManager() {
		if(emf != null) return emf.createEntityManager();
		else throw new IllegalStateException("Falha ao criar EntityManager");
	}
	
	private PersistenceFactory() {
	}
}
