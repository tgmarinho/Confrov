package br.edu.pos.confrov.persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class EntityManagerTest {

	EntityManager manager1;
	EntityManagerFactory factory;
	

	@Test
	public void criaTabelasTest() {
		
		/*
		 * Classe de teste utilitária para criar as entidades através do mapeamente JPA/Hibernate
		 * lembrando de colocar value="create" para gerar, e depois alterar para "update"
		 * para não perder os dados
		 * 
		 */
		
		
		factory = Persistence.createEntityManagerFactory ("confrovpu") ;
		manager1 = factory.createEntityManager () ;
		
		System.out.println ( " ------------------ Cria as Tabelas- - - - - - - - - - - - - - - - - " ) ;
		
		
	}

}
