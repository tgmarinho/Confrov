package br.edu.pos.confrov.test.cidade;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.service.ICidadeService;
import br.edu.pos.confrov.service.IEstadoService;
import br.edu.pos.confrov.service.impl.CidadeServiceImpl;
import br.edu.pos.confrov.service.impl.EstadoServiceImpl;

public class CidadeTest {
	
	ICidadeService cidadeService= new CidadeServiceImpl();
	IEstadoService estadoService= new EstadoServiceImpl();
	Cidade cidade= new Cidade();

	@Test
	public void cadastraCidadeTest() {

		Cidade cidade = new Cidade();
		cidade.setNome("Goiania" );
		cidade.setEstado(estadoService.findByDescricao("Goiás"));

		Cidade cidadeSalva = cidadeService.criaCidade(cidade);
		assertEquals("Goiania", cidadeSalva.getNome());

	}



	@Test	
	public void buscaTodasCidades(){ 

		List<Cidade> cidades = cidadeService.findByAll();

		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome()+ '-'+cidade.getEstado());

		}



	}	

	@Test	
	public void buscaPorEstado(){ 


		List<Cidade> cidades =   cidadeService.findbyEstado(1L);

		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}



	}	

}
