package br.edu.pos.confrov.test.estado;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.service.IEstadoService;
import br.edu.pos.confrov.service.impl.EstadoServiceImpl;

public class EstadoTest {
IEstadoService estadoService = new EstadoServiceImpl();
	
	@Test
	public void cadastraEstadotest() { // nesse teste passou
		
	Estado estado = new Estado();
	estado.setNome("Goiás" );
	estado.setSigla("GO");
	
	Estado estadoSalva = estadoService.criaEstado(estado);
	assertEquals("Goiás", estadoSalva.getNome());
	assertEquals("GO",estadoSalva.getSigla());
		
	}
	
	@Test
	public void buscaTodosEstados(){ 
		
		List<Estado> estados = estadoService.findByAll();
		
		for (Estado estado : estados) {
			System.out.println(estado.getNome()+'-'+ estado.getSigla());
		}
		
		
		
	}
}
