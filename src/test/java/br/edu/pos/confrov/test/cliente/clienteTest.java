package br.edu.pos.confrov.test.cliente;

import java.util.List;
import org.junit.Test;
import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.service.IClienteService;
import br.edu.pos.confrov.service.ICidadeService;
import br.edu.pos.confrov.service.impl.CidadeServiceImpl;
import br.edu.pos.confrov.service.impl.ClienteServiceImpl;

public class clienteTest {
	IClienteService clienteService= new ClienteServiceImpl();
	ICidadeService cidadeService= new CidadeServiceImpl();
	Cliente cliente= new Cliente();

/*@Test
	public void cadastraClienteTest() {

		cliente.setNome("Ismael" );
		cliente.setBairro("Bairo sei lá");
		cliente.setCep(789456L);
		cliente.setCpf(56556565L);
		cliente.setDtnascimento("20/08/1987");
		cliente.setEmail("ola@um.com");
		cliente.setFone(525232L);
		cliente.setEndereco("rua fulano de tal");
		cliente.setCidade(cidadeService.findByNome("Goiania"));

		Cliente clienteSalva = clienteService.criaCliente(cliente);
		assertEquals("Goiania", clienteSalva.getNome());

	}*/



	@Test	
	public void buscaTodasClientes(){ 

		List<Cliente> clientes = clienteService.findByAll();

		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());

		}



	}	
	

	@Test	
	public void buscaPorCPF(){ 


		List<Cliente> Clientes =   clienteService.findbyCPF(56565L);

		for (Cliente Cliente : Clientes) {
			System.out.println(Cliente.getNome());
		}


	}

}
