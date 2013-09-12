package br.edu.pos.confrov.test.categoria;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.service.ICategoriaService;
import br.edu.pos.confrov.service.impl.CategoriaServiceImpl;

public class CategoriaTest {

	ICategoriaService categoriaService = new CategoriaServiceImpl();
	
	@Test
	public void cadastraCategoriatest() { // nesse teste passou
		
	//Cria a Categoria
	Categoria categoria = new Categoria();
	categoria.setDescricao("VIagem");
	
	Categoria categoriaSalva = categoriaService.criaCategoria(categoria);
	assertEquals("VIagem", categoriaSalva.getDescricao());
		
//	Categoria c2 = categoriaService.findByDescricao("Passeio");
//	assertEquals("Passeio", c2.getDescricao());
	
	// testes ok
	
	// blz vc implemtou algo q passou nos testes, agora falta vc commitar, ou seja mandar para o git hub
	// bou mostrar como faz
	}
	
	@Test
	public void buscaTodasCategorias(){ // nesse falhou ver o q houve
		
		List<Categoria> categorias = categoriaService.findByAll();
		
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getDescricao());
		}
		
		// agora vou testar
		
		
	}

}
