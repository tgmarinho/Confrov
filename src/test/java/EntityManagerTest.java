import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.edu.pos.confrov.entity.Marca;


public class EntityManagerTest {

	EntityManager manager1;
	EntityManagerFactory factory;
	

	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory ("testepu") ;
		manager1 = factory.createEntityManager () ;
		
		System.out.println ( " ------------------ PRIMEIRO FIND - - - - - - - - - - - - - - - - - " ) ;
		Marca marca = manager1.find(Marca.class, 1L);
		
//		Assert.assertEquals(1L, marca.getId().longValue());
		
	}

}
