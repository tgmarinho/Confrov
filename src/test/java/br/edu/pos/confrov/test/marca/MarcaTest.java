package br.edu.pos.confrov.test.marca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;

public class MarcaTest {

	@Before
	public void setUp() throws Exception {
	
	
	}

	@Test
	public void test() {
		

		// Cria a Marca
		
		Marca m = new Marca();
		m.setDescricao("Fiat");

		
		// Persiste no Banco
		IMarcaService marcaService = new MarcaServiceImpl();
		Marca m2 = marcaService.criaMarca(m);
		
		// faz a verificação
		Assert.assertEquals(m2.getDescricao(), m.getDescricao());
		
		
	}

}
