package br.edu.pos.confrov.test.cliente;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.service.IClienteService;
import br.edu.pos.confrov.service.ICidadeService;
import br.edu.pos.confrov.service.impl.CidadeServiceImpl;
import br.edu.pos.confrov.service.impl.ClienteServiceImpl;

public class clienteTest {
	IClienteService ClienteService= new ClienteServiceImpl();
	ICidadeService cidadeService= new CidadeServiceImpl();
	Cliente Cliente= new Cliente();

	/*@Test
	public void cadastraClienteTest() {

		Cliente cliente = new Cliente();
		Cliente.setNome("Quézia" );
		Cliente.setBairro("Bairo sei lá");
		Cliente.setCep(789456L);
		Cliente.setCpf(56565L);
		Cliente.setDtnascimento("20/08/1987");
		Cliente.setEmail("ola@um.com");
		Cliente.setFone(525232L);
		Cliente.setEndereco("rua fulano de tal");
		Cliente.setCidade(cidadeService.findByNome("Goiania"));

		Cliente ClienteSalva = ClienteService.criaCliente(Cliente);
		assertEquals("Goiania", ClienteSalva.getNome());

	}*/



	@Test	
	public void buscaTodasClientes(){ 

		List<Cliente> Clientes = ClienteService.findByAll();

		for (Cliente Cliente : Clientes) {
			System.out.println(Cliente.getNome()+ '\n'+Cliente.getEndereco()+'\n'+ Cliente.getBairro()
					+'\n'+ Cliente.getCep() +'\n'+ Cliente.getCpf() +'\n'+ Cliente.getEmail() 
					+'\n'+ Cliente.getFone() +'\n'+ Cliente.getCidade());

		}



	}	
	/*

	@Test	
	public void buscaPorCPF(){ 


		List<Cliente> Clientes =   ClienteService.findbyCPF(56565L);

		for (Cliente Cliente : Clientes) {
			System.out.println(Cliente.getNome());
		}


	}*/

}
