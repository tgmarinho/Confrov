package br.edu.pos.confrov.test.marca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;

public class MarcaTest {

	@Test
	public void cadastraMarcatest()  {

		// Cria a Marca
		Marca m = new Marca();
		m.setDescricao("Toyota");

		// Persiste no Banco
		IMarcaService marcaService = new MarcaServiceImpl();
		Marca m2 = marcaService.criaMarca(m);
		
		// faz a verificação
		Assert.assertEquals("Toyota", m2.getDescricao());
		
	}
	


}
