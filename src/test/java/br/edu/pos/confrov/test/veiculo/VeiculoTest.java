package br.edu.pos.confrov.test.veiculo;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.GenericDAOImpl;
import br.edu.pos.confrov.service.IModeloService;
import br.edu.pos.confrov.service.impl.ModeloServiceImpl;

public class VeiculoTest {

	IModeloService modeloService = new ModeloServiceImpl();
	GenericDAOImpl<Veiculo> daoGenerico = new GenericDAOImpl<Veiculo>(Veiculo.class);
	
	@Test
	public void cadastraVeiculo(){
		
		Veiculo v = new Veiculo();
		v.setAnoFabricacao(2010);
		v.setAnoModelo(2011);
		v.setCor("Preto");
		v.setPlaca("HKJ-2323");
		v.setValorLocacao(new BigDecimal("150"));
		v.setModelo(modeloService.findById(1L));
		
		Assert.assertEquals("Corolla", v.getModelo().getDescricao());
		
		
		daoGenerico.beginTransaction();
		daoGenerico.save(v);
		daoGenerico.commit();
		daoGenerico.closeTransaction();
		
		Assert.assertEquals("Corolla", v.getModelo().getDescricao());
		Assert.assertEquals("Toyota", v.getModelo().getMarca().getDescricao());
		Assert.assertEquals("Trabalho", v.getModelo().getCategoria().getDescricao());
		
		
	}
	
	
	@Test
	public void deletaVeiculoTest(){
	
		daoGenerico.beginTransaction();
		Veiculo v = daoGenerico.find(4L);
		daoGenerico.delete(v.getId(), Veiculo.class);
		daoGenerico.commitAndCloseTransaction();
		
	}
	
}
