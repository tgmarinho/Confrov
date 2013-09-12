package br.edu.pos.confrov.test.categoria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.pos.confrov.dao.ICategoriaDAO;
import br.edu.pos.confrov.entity.Categoria;

public class CategoriaTest {

	@Test
	public void test() {
		
	//Cria a Categoria
	Categoria categoria = new Categoria();
	categoria.setDescricao("Passeio");
	
	ICategoriaDAO categoriaService = new CategoriaServiceImpl();
	Categoria categoriaPersist = categoriaService.createCategoria(categoria);
	
	assertEquals("Passeio", categoriaPersist.getDescricao());
		
		
	}

}
