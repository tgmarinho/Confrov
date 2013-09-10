package br.edu.pos.confrov.test.modelo;

import org.junit.Assert;
import org.junit.Test;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;

public class ModeloTest {

	@Test
	public void test() {

		// Cria o Modelo

		ModeloTest m = new ModeloTest();
		m.
		m.setDescricao("Corola");


		// Persiste no Banco
		IMarcaService marcaService = new MarcaServiceImpl();
		Marca m2 = marcaService.criaMarca(m);

		// faz a verificação
		Assert.assertEquals("Toyota", m2.getDescricao());

	}

}
