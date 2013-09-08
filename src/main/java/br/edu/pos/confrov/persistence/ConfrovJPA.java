package br.edu.pos.confrov.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class ConfrovJPA {

	private static final String PERSISTENCE_UNIT_NAME = "confrov-pu";

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	private ConfrovJPA() {
	}

	public static boolean isEntityManagerOpen(){
		return ConfrovJPA.manager.get() != null && ConfrovJPA.manager.get().isOpen();
	}

	public static EntityManager getEntityManager() {
		if (ConfrovJPA.factory == null) {
			ConfrovJPA.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = ConfrovJPA.manager.get();
		if (em == null || !em.isOpen()) {
			em = ConfrovJPA.factory.createEntityManager();
			ConfrovJPA.manager.set(em);
		}
		return em;
	}

	public static void evictCache(EntityManager em, String region){
		((Session)em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
	}

	public static void closeEntityManager() {
		EntityManager em = ConfrovJPA.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) { 
				tx.commit();
			}
			em.close();
			ConfrovJPA.manager.set(null);
		}
	}

	public static void closeEntityManagerFactory(){
		closeEntityManager();
		ConfrovJPA.factory.close();
	}

}
