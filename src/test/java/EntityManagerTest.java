import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class EntityManagerTest {

	EntityManager manager1;
	EntityManagerFactory factory;
	

	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory ("confrovpu") ;
		manager1 = factory.createEntityManager () ;
		
		System.out.println ( " ------------------ CRIANDO TABELAS - - - - - - - - - - - - - - - - - " ) ;
		
		
	}

}
