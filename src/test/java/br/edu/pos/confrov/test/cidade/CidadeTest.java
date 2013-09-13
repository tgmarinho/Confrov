package br.edu.pos.confrov.test.cidade;

import java.util.List;

import org.junit.Test;

import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.service.ICidadeService;
import br.edu.pos.confrov.service.IEstadoService;
import br.edu.pos.confrov.service.impl.CidadeServiceImpl;
import br.edu.pos.confrov.service.impl.EstadoServiceImpl;
import static org.junit.Assert.assertEquals;

public class CidadeTest {
	ICidadeService cidadeService= new CidadeServiceImpl();
	IEstadoService estadoService= new EstadoServiceImpl();
	Cidade cidade= new Cidade();
	
	@Test
	public void cadastraCidadeTest() {
		
		/*Cidade cidade = new Cidade();
		cidade.setNome("Goiania" );
		cidade.setEstado(estadoService.findByDescricao("Goiás"));
		
		Cidade cidadeSalva = cidadeService.criaCidade(cidade);
		assertEquals("Goiania", cidadeSalva.getNome());*/
		
	}
		
	/*@Test	
	public void cadastraCidadeEstadoTest(){

		    Estado estado = estadoService.findByDescricao("Goiás");
	
			this.cidade = new Cidade();
			cidade.setNome("Goiania");
			cidade.setEstado(estado);
			
			
			Cidade cidadeSalvo = cidadeService.findByNome("Goiania");
			System.out.println(cidadeSalvo.getNome());
			System.out.println(cidadeSalvo.getEstado());
					
		}
	@Test	
	public void buscaTodasCidades(){ 
			
			List<Cidade> cidades = cidadeService.findByAll();
			
			for (Cidade cidade : cidades) {
				System.out.println(cidade.getNome());
			}
			
			
			
		}	*/

}
