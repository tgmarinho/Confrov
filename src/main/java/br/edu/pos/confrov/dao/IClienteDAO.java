package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.persistence.Dba;

public interface IClienteDAO extends Serializable {
	
	public Cliente criaCliente(Cliente cliente, Dba dba);

	public Cliente findByNome(String nome);
	
	public List<Cliente> findbyCPF (Long cpf);
	
	public List<Cliente> findByAll();

	public Cliente editaCliente(Cliente cliente);

}
