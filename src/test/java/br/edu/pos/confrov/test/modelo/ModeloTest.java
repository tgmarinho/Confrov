package br.edu.pos.confrov.test.modelo;

import org.junit.Test;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.service.ICategoriaService;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.IModeloService;
import br.edu.pos.confrov.service.impl.CategoriaServiceImpl;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;
import br.edu.pos.confrov.service.impl.ModeloServiceImpl;

public class ModeloTest {

	IMarcaService marcaService = new MarcaServiceImpl();
	IModeloService modeloService = new ModeloServiceImpl();
	ICategoriaService categoriaService = new CategoriaServiceImpl();


	@Test
	public void cadastraModeloTest() {

//		// Cria o Modelo
//		Modelo modelo = new Modelo();
//		modelo.setDescricao("Corolla");
//		// parametros de busca
//		Marca marca = new Marca();
//		marca.setDescricao("Toyota");
//		// Busca a marca a ser inserida
//		Marca marca2 = marcaService.findByDescricao("Toyota");
//		// Verifica se a Marca desse modelo existe no banco de dados
//		Assert.assertEquals("Toyota", marca2.getDescricao());
//		if(marca2!=null){
//			modelo.setMarca(marca2);
//		}

		// Persiste no Banco
		//		IModeloService modeloService = new ModeloServiceImpl();
		//		Modelo modelo2 = modeloService.criaModelo(modelo);
		//		Modelo m3 = modeloService.findByDescricao("Corolla");

		// faz a verificação
		//		Assert.assertEquals("Corolla", m3.getDescricao());

	}

	@Test
	public void cadastraModeloComCategoriaTest(){

		// Busca a marca a ser inserida
		Marca marca = marcaService.findByDescricao("Toyota");
		
		// Busca a categoria do carro
		Categoria categoria = categoriaService.findByDescricao("Passeio");
		
		// Cria o Modelo
		Modelo modelo = new Modelo();
		modelo.setDescricao("Etios");
		// vincula os relacionamentos com Marca e Categoria
		modelo.setCategoria(categoria);
		modelo.setMarca(marca);
		
//		modeloService.criaModelo(modelo);
		
		
		// faz as assertividades
		
		Modelo modeloSalvo = modeloService.findByDescricao("Etios");
		System.out.println(modeloSalvo.getDescricao());
		System.out.println(modeloSalvo.getCategoria());
		System.out.println(modeloSalvo.getMarca());
		
		



	}


}
