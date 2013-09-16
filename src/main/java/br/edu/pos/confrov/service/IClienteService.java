package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Cliente;

public interface IClienteService extends Serializable {
	
	public Cliente criaCliente(Cliente Cliente);

	public Cliente findByNome(String nome);

	public List<Cliente> findByAll();
		
	List<Cliente> findbyCPF(Long cpf);

	public Cliente editaCliente(Cliente cliente);


}
