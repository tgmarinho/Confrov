package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.ICidadeDAO;
import br.edu.pos.confrov.dao.IClienteDAO;
import br.edu.pos.confrov.dao.impl.CidadeDAOImpl;
import br.edu.pos.confrov.dao.impl.ClienteDAOImpl;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.IClienteService;

public class ClienteServiceImpl implements IClienteService {
	
	private static final long serialVersionUID = 1L;

	private IClienteDAO clienteDAO = new ClienteDAOImpl();

	@Override
	public Cliente criaCliente(Cliente cliente) {
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			cliente = clienteDAO.criaCliente(cliente, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return cliente;
	}

	@Override
	public Cliente findByNome(String nome) {
		Dba dba = new Dba();
		Cliente	 cliente;
		try{
			cliente = clienteDAO.findByNome(nome);
		} finally {
			dba.closeEm();
		}
		return cliente;
	}

	@Override
	public List<Cliente> findByAll() {
		Dba dba = new Dba();
		List<Cliente> clientes;
		try {
			clientes = clienteDAO.findByAll();
		} finally {
			dba.closeEm();
		}

		return clientes;
	}

	@Override
	public List<Cliente> findbyCPF(Long cpf) {
		Dba dba = new Dba();
		List<Cliente> clientes;
		try{
			clientes =  clienteDAO.findbyCPF(cpf);
		} finally {
			dba.closeEm();
		}
		return clientes;
	}
	
	@Override
	public Cliente editaCliente(Cliente cliente) {
		return cliente = clienteDAO.editaCliente(cliente);
	}

}
