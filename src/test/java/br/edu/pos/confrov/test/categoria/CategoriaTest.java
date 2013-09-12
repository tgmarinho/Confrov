package br.edu.pos.confrov.test.categoria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.service.ICategoriaService;
import br.edu.pos.confrov.service.impl.CategoriaServiceImpl;

public class CategoriaTest {

	@Test
	public void test() {
		
	//Cria a Categoria
	Categoria categoria = new Categoria();
	categoria.setDescricao("Rolé");
	
	ICategoriaService categoriaService = new CategoriaServiceImpl();
	Categoria categoriaSalva = categoriaService.criaCategoria(categoria);
	
	assertEquals("Rolé", categoriaSalva.getDescricao());
		
	Categoria c2 = categoriaService.findByDescricao("Passeio");
	assertEquals("Passeio", c2.getDescricao());
	
	
	}

}
